package com.kaagapov.checkToken.repo;

import com.kaagapov.checkToken.entity.ProductItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {
    List<ProductItem> findByProductId(long productId);
}
