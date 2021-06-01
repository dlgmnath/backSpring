package com.co.portafolio.superMarket.service;

import com.co.portafolio.superMarket.dto.EmployDto;

import java.util.List;

public interface IEmployService {
    List<EmployDto> findAll();
    EmployDto findById(Integer employpId);
    EmployDto findByName(String name);
    void createEmploy(EmployDto employDto) throws Exception;
    EmployDto updateEmploy(Integer employpId, EmployDto employDto) throws Exception;
    void deleteEmploy(Integer employpId) throws Exception;
}
