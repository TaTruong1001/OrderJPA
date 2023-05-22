package repository;

import entity.OrderDetailEntity;
import entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    @Query(value = "select * from order_product", nativeQuery = true)
    List<OrderEntity> getAll();

    @Query(value = "SELECT * FROM \n" +
            "order_product o\n" +
            "where\n" +
            "(select sum(unitPrice*quantity) from orderdetail_product o1 where o.id = o1.orderId )>1000;", nativeQuery = true)

    List<OrderEntity> findTotalAmountMoreThan(double amount);


    @Query(value = "select * from order_product where MONTH(orderDate)=MONTH(now())", nativeQuery = true)
    List<OrderEntity> findByCurrentMonth();
}
