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
import java.util.Date;

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
        String originalCreatedBy = null;
        Date originalCreatedDate = null;
        if(transactionDTO.getId() == null) {
            transactionEntity = new TransactionEntity();
        }
        else {
            transactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
            originalCreatedBy = transactionEntity.getCreatedBy();
            originalCreatedDate = transactionEntity.getCreatedDate();
        }

        modelMapper.map(transactionDTO,transactionEntity);
        transactionEntity.setStaffId(SecurityUtils.getPrincipal().getId());
        if(transactionDTO.getId() == null) {
            transactionEntity.setCreatedDate(new java.util.Date());
        } else {
            transactionEntity.setCreatedBy(originalCreatedBy);
        }
        transactionEntity.setCreatedDate(new java.util.Date());
        transactionRepository.save(transactionEntity);
    }
}
