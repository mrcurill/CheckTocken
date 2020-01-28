package com.kaagapov.checkToken.repo;

import com.kaagapov.checkToken.entity.Component;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComponentRepository extends CrudRepository<Component, Long> {
    List<Component> findByName(String name);
}
