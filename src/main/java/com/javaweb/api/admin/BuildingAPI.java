package com.javaweb.api.admin;


import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
//import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingRepository buildingRepository;
//    @Autowired
//    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @PostMapping
    public void addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        BuildingEntity build;
        if (buildingDTO.getId() == null) {
            build = new BuildingEntity();
        } else {
            build = buildingRepository.findById(buildingDTO.getId()).get();
//            rentAreaRepository.deleteByBuildingId(build.getId());
        }
        build.setName(buildingDTO.getName());
        build.setDistrict(buildingDTO.getDistrict());
        build.setFloorArea(Long.valueOf(buildingDTO.getFloorArea()));
        build.setRentPrice(Long.valueOf(buildingDTO.getRentPrice()));
        build.setWard(buildingDTO.getWard());
        build.setRentPriceDescription(buildingDTO.getRentPriceDescription());
        build.setStreet(buildingDTO.getStreet());
        build.setNumberOfBasement(Long.valueOf(buildingDTO.getNumberOfBasement()));
        build.setManagerName(buildingDTO.getManagerName());
        build.setManagerPhone(buildingDTO.getManagerPhone());


        List<RentAreaEntity>rentAreas= new ArrayList<>();
        String[] arr= buildingDTO.getRentArea().split(",");
        for(String item : arr) {
            RentAreaEntity rentArea = new RentAreaEntity();
            rentArea.setValue(item);
            rentArea.setBuilding(build);
            rentAreas.add(rentArea);
        }
        build.setRentAreaEntities(rentAreas);
        buildingRepository.save(build);

        //xuong DB xu li du lieu de update hoac them moi
//        return buildingDTO;
    }

    @Transactional
    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable Long[] ids) {

//        assignmentBuildingRepository.deleteByBuildingIdIn(ids);
//
//        rentAreaRepository.deleteByBuildingIdIn(ids);
//
//        buildingRepository.deleteByIdIn(ids);

        buildingRepository.deleteByIdIn(ids);


    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO result = buildingService.listStaffs(id);
        return result;
    }


    @Transactional
    @PostMapping("/assignment")
    public void updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {

//        assignmentBuildingRepository.deleteByBuildingId(assignmentBuildingDTO.getBuildingId());
//        for(Long item:assignmentBuildingDTO.getStaffs()) {
//            AssignmentBuildingEntity assignmentBuilding= new AssignmentBuildingEntity();
//            BuildingEntity building = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
//            List<UserEntity> users = userRepository.findByStatusAndRoles_Code(1,"USER");
//            for(UserEntity it: users) {
//                if(it.getId().equals(item)) {
//                    UserEntity user = userRepository.findById(item).get();
//                    assignmentBuilding.setBuilding(building);
//                    assignmentBuilding.setUser(user);
//                    assignmentBuildingRepository.save(assignmentBuilding);
//                }
//            }
//        }

        BuildingEntity buildingEntity= buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        List<UserEntity> staffs= userRepository.findByIdIn(assignmentBuildingDTO.getStaffs());
        buildingEntity.setUsers(staffs);
        buildingRepository.save(buildingEntity);
        System.out.println("ok");
    }
}
