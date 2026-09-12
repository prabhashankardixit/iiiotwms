package com.iiiotwms.returns.service;

import com.iiiotwms.returns.entity.ReturnHdr;
import com.iiiotwms.returns.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnService {

    @Autowired private ReturnRepository returnRepository;

    public List<ReturnHdr> getAllReturns() { return returnRepository.findAll(); }

    public ReturnHdr createReturn(ReturnHdr returnHdr) { return returnRepository.save(returnHdr); }
}
