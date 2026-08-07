package com.javaweb.api.admin;


import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.MyUserDetail;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController(value="customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    @PostMapping
    public void addOrUpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerEntity customer;
        if(customerDTO.getId() ==null) {
            customer = new CustomerEntity();
        }
        else {
            customer = customerRepository.findById(customerDTO.getId()).get();
        }

        MyUserDetail currentUser = SecurityUtils.getPrincipal();
        Long userId = currentUser.getId();

        List<UserEntity> users = new ArrayList<>();

        UserEntity user = userRepository.findById(userId).get();
        users.add(user);

        modelMapper.map(customerDTO,customer);
        customer.setIsActive(1);
        customer.setUsers(users);
        //List<TransactionEntity>transactionList = transactionRepository.findByCustomerId(customerDTO.getId());

       // customer.setTransactionEntities(transactionList);
        customer.setPhone(customerDTO.getCustomerPhone());
        customerRepository.save(customer);
    }

    @Transactional
    @DeleteMapping("/{ids}")
    public void deleteCustomer(@PathVariable Long[]ids) {
        List<CustomerEntity> customer = customerRepository.findByIdIn(ids);
        for(CustomerEntity item : customer) {
            item.setIsActive(0);
            customerRepository.save(item);
        }
    }


    @Transactional
    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id) {
        ResponseDTO res = customerService.listStaffs(id);
        return res;
    }

    @Transactional
    @PostMapping("/assignment")
    public void updateAssignmentCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {
        CustomerEntity customer = customerRepository.findById(assignmentCustomerDTO.getCustomerId()).get();
        List<UserEntity> staffs = userRepository.findByIdIn(assignmentCustomerDTO.getStaffs());
        customer.setUsers(staffs);
        customerRepository.save(customer);
    }
}
