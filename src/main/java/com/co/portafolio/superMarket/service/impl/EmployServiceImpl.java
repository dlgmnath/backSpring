package com.co.portafolio.superMarket.service.impl;

import com.co.portafolio.superMarket.dto.EmployDto;
import com.co.portafolio.superMarket.entity.EmployEntity;
import com.co.portafolio.superMarket.repository.IEmployRepository;
import com.co.portafolio.superMarket.service.IEmployService;
import com.co.portafolio.superMarket.util.EmployUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployServiceImpl implements IEmployService {

    @Autowired
    IEmployRepository iEmployRepository;

    @Override
    public List<EmployDto> findAll() {
        List<EmployEntity> employEntityList = iEmployRepository.findAll();
        List<EmployDto> employDtoList = new ArrayList<>();

        for(EmployEntity entity: employEntityList){
            employDtoList.add(EmployUtil.EmployEntityToEmployDto(entity));
        }
        return employDtoList;
    }

    @Override
    public EmployDto findById( Integer employId) {
        Optional<EmployEntity> entity = iEmployRepository.findById(employId);
        EmployDto employDto = null;

        if(entity.isPresent()){
            employDto = EmployUtil.EmployEntityToEmployDto(entity.get());
        }
        return employDto;
    }

    @Override
    public EmployDto findByName(String name){
        Optional<EmployEntity> entity = iEmployRepository.findByName((name));
        EmployDto employDto = null;

        if(entity.isPresent()){
            employDto = EmployUtil.EmployEntityToEmployDto((entity.get()));
        }
        return employDto;
    }

    @Override
    public void createEmploy(EmployDto employDto) throws Exception {
        Optional<EmployEntity> entity = iEmployRepository.findByName(employDto.getName());
        if(!entity.isPresent()){
            iEmployRepository.save(EmployUtil.EmployDtoToEmployEntity(employDto));
        } else {
            throw new Exception("Producto ya existe");
        }
    }

    @Override
    public EmployDto updateEmploy(Integer productId, EmployDto employDto) throws Exception {
        Optional<EmployEntity> employEntity = iEmployRepository.findById(productId);

        if(employEntity.isPresent()) {
            employEntity.get().setPersonalId(employDto.getPersonalId());
            employEntity.get().setName(employDto.getName());
            employEntity.get().setPositionId(employDto.getPositionId());
            iEmployRepository.save(employEntity.get());
            return employDto;
        } else {
            throw new Exception("Producto no encontrado");
        }
    }

    @Override
    public void deleteEmploy (Integer productId) throws Exception {
        Optional<EmployEntity> employEntity = iEmployRepository.findById((productId));

        if(employEntity.isPresent()){
            employEntity.get().setStatus(0);
            iEmployRepository.save(employEntity.get());
        }else {
            throw new Exception(" No es posible eliminar el producto");
        }
    }
}
