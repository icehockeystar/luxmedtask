package org.euroit.luxmedtask.mapper;

import org.euroit.luxmedtask.api.CompanyController;
import org.euroit.luxmedtask.db.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;

import java.util.UUID;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, mappingControl = DeepClone.class)
public interface CompanyMapper {
    CompanyController.ReadCompanyResponse from(CompanyEntity companyEntity);

    default String map(UUID value) {
        return value.toString();
    }
}
