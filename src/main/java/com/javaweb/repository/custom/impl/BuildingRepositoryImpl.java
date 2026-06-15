package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.NumberUtilObject;
import com.javaweb.utils.StringUtilObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public static void joinTable(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
        Long staffId = buildingSearchRequest.getStaffId();
        if(staffId != null) {
            sql.append(" INNER JOIN assignmentbuilding ON assignmentbuilding.buildingid = building.id ");
        }

        List<String>typeCode= buildingSearchRequest.getTypeCode();
        if(typeCode!=null && typeCode.size()!=0) {
            sql.append(" INNER JOIN buildingrenttype ON buildingrenttype.buildingid = building.id ");
            sql.append(" INNER JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
        }
    }

    public static void queryNormal(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {
        try{
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for(Field item: fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area") && !fieldName.startsWith("rentPrice")) {
                    Object value= item.get(buildingSearchRequest);
                    if(StringUtilObject.checkString(value)) {
                        if(NumberUtilObject.isNumber(value)) {
                            where.append(" AND building."+fieldName+" = "+value+" ");
                        }
                        else {
                            where.append(" AND building."+fieldName+" LIKE '%"+value+"%' ");
                        }
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void querySpecial(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {
        Long staffId= buildingSearchRequest.getStaffId();
        if(staffId != null) {
            where.append(" AND assignmentbuilding.staffid = "+staffId+" ");
        }

        List<String>typeCode = buildingSearchRequest.getTypeCode();
        if(typeCode!=null && typeCode.size()!=0) {
            where.append(" AND ( ");
            String sql = typeCode.stream().map(it -> " renttype.code like '%" + it + "%' ").collect(Collectors.joining(" OR "));
            where.append(sql);
            where.append(" ) ");
        }

        Long areaFrom = buildingSearchRequest.getAreaFrom();
        Long areaTo = buildingSearchRequest.getAreaTo();
        if(areaTo !=null || areaFrom!=null) {
            where.append(" AND EXISTS ( SELECT * FROM rentarea WHERE building.id = rentarea.buildingid ");

            if(areaTo!=null) {
                where.append(" AND rentarea.value <= "+areaTo+" ");
            }
            if(areaFrom!=null) {
                where.append(" AND rentarea.value >= "+areaFrom+" ");
            }

            where.append(" ) ");
        }

        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
        if(rentPriceFrom!=null || rentPriceTo!=null) {

            if(rentPriceTo!=null) {
                where.append(" AND building.rentprice <= "+rentPriceTo+" ");
            }
            if(rentPriceFrom!=null) {
                where.append(" AND building.rentprice >= "+rentPriceFrom+" ");
            }

        }

    }

    @Override
    public List<BuildingEntity> find(BuildingSearchRequest buildingSearchRequest) {

        StringBuilder sql =new StringBuilder("SELECT * FROM building ");
        joinTable(buildingSearchRequest, sql);
        StringBuilder where=new StringBuilder(" WHERE 1=1 ");
        queryNormal(buildingSearchRequest,where);
        querySpecial(buildingSearchRequest, where);
//        where.append(" GROUP BY building.id ; ");
        sql.append(where);
        Query query=entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
       return query.getResultList();
    }
}
