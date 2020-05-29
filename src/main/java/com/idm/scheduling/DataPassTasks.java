package com.idm.scheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.idm.service.DataPassRequestService;

@Component
public class DataPassTasks {

    @Autowired
    private DataPassRequestService dataPassRequestService;

    private static final Logger log = LoggerFactory.getLogger(DataPassTasks.class);

    @Scheduled(fixedRate = 15000)
    public void getHeadValue() {
    	System.out.println("trigger");
        log.info("Value: {}", dataPassRequestService.doHeadRequest());
    }
}
