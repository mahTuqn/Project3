package com.javaweb.controller.admin;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.MyUserDetail;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.security.utils.SecurityUtils;
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

@Controller
public class CustomerController {

    @Autowired
    private IUserService userService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView customerList(CustomerSearchRequest customerSearchRequest) {

        ModelAndView mav= new ModelAndView("admin/customer/list");

        MyUserDetail currentUser = SecurityUtils.getPrincipal();
        Long userId = currentUser.getId();
        List<CustomerEntity> customers ;
        if(customerSearchRequest.getFullName() != null) {
            customers=customerRepository.findByCustomer(customerSearchRequest);
        }
        else {
            customers=customerRepository.findAll();
        }

        List<CustomerSearchResponse>responseList = new ArrayList<>();
        if(userId == 1) {
            for(CustomerEntity item : customers) {
                CustomerSearchResponse customerSearchResponse = modelMapper.map(item, CustomerSearchResponse.class);
                responseList.add(customerSearchResponse);
            }
        }
        else {
            for(CustomerEntity item : customers) {
                for(UserEntity user : item.getUsers()) {
                    if(user.getId() == userId) {
                        CustomerSearchResponse customerSearchResponse = modelMapper.map(item, CustomerSearchResponse.class);
                        responseList.add(customerSearchResponse);
                    }
                }
            }
        }
        mav.addObject("modelSearch", customerSearchRequest);
        mav.addObject("customerList", responseList);
        mav.addObject("listStaffs", userService.getStaffs());
        mav.addObject("transactionType", TransactionType.type());
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView customerEdit(@ModelAttribute("customerEdit")CustomerDTO customerDTO, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("transactionEdit", new TransactionDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView customerEdit(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerEntity customer = customerRepository.findById(id).get();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        List<TransactionEntity>listCode1= transactionRepository.findByCustomerIdAndCode(id,"DDX");
        List<TransactionEntity>listCode2= transactionRepository.findByCustomerIdAndCode(id,"CSKH");

        List<TransactionDTO>listCodeDTO1= new ArrayList<>();
        for(TransactionEntity item: listCode1) {
            TransactionDTO transactionDTO = modelMapper.map(item, TransactionDTO.class);
            if(item.getStaffId()!=null) {
                UserEntity user = userRepository.findById(item.getStaffId()).get();
                transactionDTO.setStaffName(user.getFullName());
            }
            listCodeDTO1.add(transactionDTO);
        }

        List<TransactionDTO>listCodeDTO2= new ArrayList<>();
        for(TransactionEntity item: listCode2) {
            TransactionDTO transactionDTO = modelMapper.map(item, TransactionDTO.class);
            if(item.getStaffId()!=null) {
                UserEntity user = userRepository.findById(item.getStaffId()).get();
                transactionDTO.setStaffName(user.getFullName());
            }
            listCodeDTO2.add(transactionDTO);
        }


        mav.addObject("transactionEdit", new TransactionDTO());
        mav.addObject("customerEdit", customerDTO);
        mav.addObject("transactionType", TransactionType.type());
        mav.addObject("transactionList1", listCodeDTO1);
        mav.addObject("transactionList2",listCodeDTO2);
        return mav;
    }
}
