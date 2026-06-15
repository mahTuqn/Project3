package com.javaweb.controller.admin;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.TypeCode;
import com.javaweb.enums.district;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IUserService userService;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RentAreaRepository rentAreaRepository;


    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {

       List<BuildingEntity>buildings;
        if(buildingSearchRequest.getName()!=null && !buildingSearchRequest.getName().trim().isEmpty()) {
             buildings=buildingRepository.find(buildingSearchRequest);
        }
        else {
            buildings=buildingRepository.findAll();
        }
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch",buildingSearchRequest);

        List<BuildingSearchResponse> responseList=new ArrayList<>();

        for(BuildingEntity item : buildings) {
            BuildingSearchResponse buildingSearchResponse = modelMapper.map(item, BuildingSearchResponse.class);
//            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
//            buildingSearchResponse.setId(item.getId());
//            buildingSearchResponse.setName(item.getName());
            buildingSearchResponse.setAddress(item.getStreet()+item.getWard());
//            buildingSearchResponse.setNumberOfBasement(item.getNumberOfBasement());
//            buildingSearchResponse.setManagerName(item.getManagerName());
//            buildingSearchResponse.setManagerPhone(item.getManagerPhone());
//            buildingSearchResponse.setFloorArea(item.getFloorArea());

            List<RentAreaEntity>rentAreas=rentAreaRepository.findByBuildingId(item.getId());
            String values= rentAreas.stream().map(it-> it.getValue().toString()).collect(Collectors.joining(","));
            buildingSearchResponse.setRentArea(values);

//            BuildingSearchResponse buildingSearchResponse = modelMapper.map(item, BuildingSearchResponse.class);
            responseList.add(buildingSearchResponse);

        }

        mav.addObject("buildingList", responseList);
//        mav.addObject("buildingList", find);
        mav.addObject("listStaffs", userService.getStaffs());
        mav.addObject("districts", district.type());
        mav.addObject("typeCodes", TypeCode.type());
        return mav;
    }

    @RequestMapping(value="/admin/building-edit", method = RequestMethod.GET )
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit")BuildingDTO buildingDTO, HttpServletRequest request) {
        ModelAndView mav= new ModelAndView("admin/building/edit");
        mav.addObject("districts", district.type());
        mav.addObject("typeCodes", TypeCode.type());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id,
                                     HttpServletRequest request) {

        BuildingEntity build = buildingRepository.findById(id).get();

        ModelAndView mav = new ModelAndView("admin/building/edit");

//        BuildingDTO buildingDTO = new BuildingDTO();

//        buildingDTO.setId(build.getId());
//        buildingDTO.setName(build.getName());
//        buildingDTO.setDistrict(build.getDistrict());
//        buildingDTO.setFloorArea(Long.valueOf(build.getFloorArea()));
//        buildingDTO.setRentPrice(Long.valueOf(build.getRentPrice()));
//        buildingDTO.setWard(build.getWard());
//        buildingDTO.setRentPriceDescription(build.getRentPriceDescription());
//        buildingDTO.setStreet(build.getStreet());
//        buildingDTO.setNumberOfBasement(build.getNumberOfBasement());
//        buildingDTO.setManagerName(build.getManagerName());
//        buildingDTO.setManagerPhone(build.getManagerPhone());

        BuildingDTO buildingDTO = modelMapper.map(build, BuildingDTO.class);

        List<RentAreaEntity>rentAreas= rentAreaRepository.findByBuildingId(build.getId());
        String values= rentAreas.stream().map(it-> it.getValue().toString()).collect(Collectors.joining(","));

        buildingDTO.setRentArea(values);

        mav.addObject("buildingEdit", buildingDTO);
        mav.addObject("districts", district.type());
        mav.addObject("typeCodes", TypeCode.type());

        return mav;
    }
}