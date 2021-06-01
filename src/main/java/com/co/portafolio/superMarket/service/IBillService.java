package com.co.portafolio.superMarket.service;

import com.co.portafolio.superMarket.dto.BillDto;

import java.util.List;

public interface IBillService {
    List<BillDto> findAll();
    BillDto findById(Integer billId);
    BillDto findByBillCode(Integer billCode);
    void createBill(BillDto billDto) throws Exception;
    BillDto updateBill(Integer billId, BillDto billDto) throws Exception;
    void deleteBill(Integer billId) throws Exception;
}
