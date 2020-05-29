package com.idm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.dao.ILeadDAO;
import com.idm.model.Lead;
import com.idm.scheduling.SendDataRequest;

@Service
public class DataPassRequestService {

    private static final Logger log = LoggerFactory.getLogger(DataPassRequestService.class);
    
    @Autowired
	private ILeadDAO leadDAO; 
	   
    public String doHeadRequest() {
    	
    	List<Lead> leads = leadDAO.findAll();
    	ExecutorService executor = Executors.newFixedThreadPool(5);
    	List<Future<Lead>> futures = new ArrayList<Future<Lead>>();
    	for (Lead lead : leads) {
    		futures.add(executor.submit(new SendDataRequest(lead,leadDAO)));
    	}
    	executor.shutdown();
    	return "SUCCESS";	
   }
}
