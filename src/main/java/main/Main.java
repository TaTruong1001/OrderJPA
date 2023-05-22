package main;

import configuration.JPAConfig;
import entity.OrderDetailEntity;
import entity.OrderEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailRepository;
import repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static OrderDetailRepository orderDetailRepository = (OrderDetailRepository) context.getBean("orderDetailRepository");

    public static void main(String[] args) {
        // createNewOrederWithOrderDetail();
        //  getAllUsingQuery();
       // findById(1);
       //  findByCurrentMonth();
       // findByproductName("Java");
    }
    public static void getAllUsingQuery(){
        List<OrderEntity> orderEntities = orderRepository.getAll();
        if(orderEntities != null){
            System.out.println("\nFind " +orderEntities.size()+ " order");
            for (OrderEntity orderEntity: orderEntities){
                System.out.println(orderEntity.toString());
            }
        }
    }
    public static void findById(int id){
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (!orderEntity.isPresent()){
            System.out.println("Not exist");
        }else
            System.out.println(orderEntity.toString());

    }
    public static void findByCurrentMonth(){
        List<OrderEntity> orderEntity = orderRepository.findByCurrentMonth();
        if (orderEntity != null){
            System.out.println("\nFind ");
            for (OrderEntity order: orderEntity) {
                System.out.println("\n "+order.toString());
            }
        }
    }
        public static void findByproductName(String name){
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findByProductName(name);
            if(orderDetailEntities != null){
                System.out.println("\nFind ");
                for (OrderDetailEntity order: orderDetailEntities) {
                    System.out.println("\n "+order.getOrder().toString());
                }
            }
        }
        public static void findOrdersWhichTotalAmountThan(double unitPrice, int quantity){
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findBy
        }

    public static void createNewOrderWithOrderDetail(){
        OrderEntity orderEntity = createNewOrder();
        orderRepository.save(orderEntity);

        OrderDetailEntity orderDetail = createNewOrderDetail();
        orderDetail.setOrder(orderEntity);
        orderDetailRepository.save(orderDetail);
    }

    public static OrderEntity createNewOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName("Tomy");
        orderEntity.setCustomerAddress("HN");
        orderEntity.setOrderDate(LocalDate.parse("2023-05-10"));
        return orderEntity;
    }
    public static OrderDetailEntity createNewOrderDetail(){
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setProductName("Iphone2");
        orderDetailEntity.setUnitPrice(20000000);
        orderDetailEntity.setQuantity(2);
        return orderDetailEntity;

    }
    public static void createNewOrderDetailEntity(){
        OrderEntity orderEntity= new OrderEntity();
        orderEntity.setId(3);

        OrderDetailEntity orderDetailEntity = createNewOrderDetail();
        orderDetailEntity.setOrder(orderEntity);
        orderDetailRepository.save(orderDetailEntity);

    }
}
