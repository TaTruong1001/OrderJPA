package repository;

import entity.OrderDetailEntity;
import entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> findByProductName(String name);

}