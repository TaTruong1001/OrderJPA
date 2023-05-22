package repository;

import entity.OrderDetailEntity;
import entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> findByProductName(String name);

    @Query(value = "use orderdb;\n" +
            "Select order_product.id,order_product.customerAddress,order_product.customerName,order_product.orderDate from orderdb.order_product join orderdb.orderdetail_product on order_product.id=orderdetail_product.orderid group by orderid\n", nativeQuery = true)

    List<OrderDetailEntity> findTotalAmountMoreThan(double amount);
}