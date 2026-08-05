package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import com.javaweb.utils.NumberUtilObject;
import com.javaweb.utils.StringUtilObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public static void joinTable(CustomerSearchRequest customerSearchRequest, StringBuilder sql) {
        Long staffId= customerSearchRequest.getStaffId();
        if(staffId != null) {
            sql.append(" INNER JOIN assignmentcustomer ON assignmentcustomer.customerid = customer.id ");
            sql.append(" INNER JOIN user ON assignmentcustomer.staffid = user.id ");
        }
        Long customerId = customerSearchRequest.getId();
        if(customerId != null) {
            sql.append(" INNER JOIN transaction ON transaction.customerid = customer.id ");
        }
    }

    public static void queryNormal(CustomerSearchRequest customerSearchRequest, StringBuilder where) {
        try{
            Field[] fields = CustomerSearchRequest.class.getDeclaredFields();
            for(Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("staffId")) {
                    Object value = item.get(customerSearchRequest);
                    if(StringUtilObject.checkString(value)) {
                        if(NumberUtilObject.isNumber(value)) {
                            where.append(" AND customer."+fieldName+" = "+value+" ");
                        }
                        else {
                            where.append(" AND customer."+fieldName+" LIKE '%"+value+"%' ");
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void querySpecial(CustomerSearchRequest customerSearchRequest, StringBuilder where) {
        Long staffid = customerSearchRequest.getStaffId();
        if(staffid != null) {
            where.append(" AND assignmentcustomer.staffid = "+staffid+" ");
        }
    }

    @Override
    public List<CustomerEntity> findByCustomer(CustomerSearchRequest customerSearchRequest) {

        StringBuilder sql = new StringBuilder("SELECT * FROM customer ");
        joinTable(customerSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
        queryNormal(customerSearchRequest, where);
        querySpecial(customerSearchRequest, where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }
}
