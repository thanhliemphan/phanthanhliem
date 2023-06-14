package mvc.repository;

import mvc.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity,Integer> {
    List<OrdersEntity> findByCustomerNameContaining(String customerName);
}
