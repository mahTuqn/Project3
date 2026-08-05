package com.javaweb.api.admin;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.security.utils.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController(value="transactionAPIOfAdmin")
@RequestMapping("/api/transaction")
public class TransactionAPI {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @PostMapping
    public void addOrUpdateTransaction(@RequestBody TransactionDTO transactionDTO) {

        TransactionEntity transactionEntity;
        if(transactionDTO.getId() == null) {
            transactionEntity = new TransactionEntity();
        }
        else {
            transactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
        }

        modelMapper.map(transactionDTO,transactionEntity);
        transactionEntity.setStaffId(SecurityUtils.getPrincipal().getId());
        transactionEntity.setCreatedDate(new java.util.Date());
        transactionRepository.save(transactionEntity);
    }
}
