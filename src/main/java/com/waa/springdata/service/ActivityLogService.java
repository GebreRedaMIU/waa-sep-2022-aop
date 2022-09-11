package com.waa.springdata.service;

import com.waa.springdata.entity.ActivityLog;
import com.waa.springdata.repo.ActivityLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ActivityLogService {
    @Autowired
    private ActivityLogRepo activityLogRepo;
   
    public void save(ActivityLog activityLog) {
        activityLogRepo.save(activityLog);
    }
    
}
