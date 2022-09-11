package com.waa.springdata.repo;

import com.waa.springdata.entity.ActivityLog;
import com.waa.springdata.entity.ActivityLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {

    List<ActivityLog> findAll();
}
