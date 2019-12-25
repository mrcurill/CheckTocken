package com.kaagapov.checkToken.repo;

import com.kaagapov.checkToken.entity.AuthLog;
import org.springframework.data.repository.CrudRepository;

public interface AuthLogRepository extends CrudRepository<AuthLog, Long> {
}
