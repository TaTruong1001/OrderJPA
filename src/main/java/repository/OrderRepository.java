package repository;

import entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    @Query(value = "select * from order_product", nativeQuery = true)
    List<OrderEntity> getAll();


    @Query(value = "select * from order_product where MONTH(orderDate)=MONTH(now())", nativeQuery = true)
    List<OrderEntity> findByCurrentMonth();
}
