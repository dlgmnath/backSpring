package com.co.portafolio.superMarket.service.impl;

import com.co.portafolio.superMarket.dto.BillDto;
import com.co.portafolio.superMarket.entity.BillEntity;
import com.co.portafolio.superMarket.repository.IBillRepository;
import com.co.portafolio.superMarket.service.IBillService;
import com.co.portafolio.superMarket.util.BillUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    IBillRepository iBillRepository;

    @Override
    public List<BillDto> findAll(){
        List<BillEntity> billEntityList = iBillRepository.findAll();
        List<BillDto> billDtoList = new ArrayList();

        for(BillEntity entity: billEntityList) {
            billDtoList.add(BillUtil.BillEntityToBillDto(entity));
        }
        return billDtoList;
    }

    @Override
    public BillDto findById( Integer productId) {
        Optional<BillEntity> entity = iBillRepository.findById(productId);
        BillDto billDto = null;

        if(entity.isPresent()){
            billDto = BillUtil.BillEntityToBillDto(entity.get());
        }
        return billDto;
    }

    @Override
    public BillDto findByBillCode(Integer billCode){
        Optional<BillEntity> entity = iBillRepository.findByBillCode(billCode);
        BillDto billDto = null;

        if(entity.isPresent()){
            billDto = BillUtil.BillEntityToBillDto((entity.get()));
        }
        return billDto;
    }

    @Override
    public void createBill(BillDto billDto) throws Exception {
        Optional<BillEntity> entity = iBillRepository.findByBillCode(billDto.getBillCode());
        if(!entity.isPresent()){
            iBillRepository.save(BillUtil.BillDtoToBillEntity(billDto));
        } else {
            throw new Exception("Producto ya existe");
        }
    }

    @Override
    public BillDto updateBill(Integer billId, BillDto billDto) throws Exception {
        Optional<BillEntity> billEntity = iBillRepository.findById(billId);

        if(billEntity.isPresent()) {
            billEntity.get().setBillId(billDto.getBillId());
            billEntity.get().setBillCode(billDto.getBillCode());
            billEntity.get().setBillCode(billDto.getEmployId());
            billEntity.get().setProduct(billDto.getProduct());
            billEntity.get().setPrice(billDto.getPrice());
            billEntity.get().setDate(billDto.getDate());
            iBillRepository.save(billEntity.get());
            return billDto;
        } else {
            throw new Exception("Producto no encontrado");
        }
    }

    @Override
    public void deleteBill (Integer productId) throws Exception {
        Optional<BillEntity> billEntity = iBillRepository.findById((productId));

        if(billEntity.isPresent()){
            billEntity.get().setStatus(0);
            iBillRepository.save(billEntity.get());
        }else {
            throw new Exception(" No es posible eliminar el producto");
        }
    }
}
