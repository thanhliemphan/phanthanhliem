package mvc.repository;

import mvc.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity,Integer> {
    @Query(value = "select orderdetails.orderDetailId,orderdetails.orderId,orderdetails.productId,orderdetails.quantity\n" +
            "from orderdetails join products on orderdetails.productId=products.productId where orderdetails.orderId=?1",nativeQuery = true)
    List<OrderDetailsEntity> viewDetailsByOrderId(int orderId);
}
