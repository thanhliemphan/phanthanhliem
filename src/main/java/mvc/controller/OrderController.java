package mvc.controller;

import mvc.entity.DetailsEntity;
import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class OrderController {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String orderList(OrdersEntity order, Model model){
        List<OrdersEntity> ordersList =(List<OrdersEntity>) ordersRepository.findAll();
        model.addAttribute("ordersList",ordersList);
        return "ordersList";
    }
    @RequestMapping(value = "viewDetail/{order.orderId}")
    public String viewDetail(@PathVariable("order.orderId") int orderId, Model model){
        List<OrderDetailsEntity> orderDetailsList =orderDetailsRepository.viewDetailsByOrderId(orderId);
        List<DetailsEntity> detailsList = new ArrayList<>();
        for (OrderDetailsEntity detail:orderDetailsList) {
            DetailsEntity item= new DetailsEntity();
            item.setProduct(detail.getProductEntity());
            item.setOrder(detail.getOrdersEntity());
            item.setOrderDetailsId(detail.getOrderDetailId());
            item.setQuantity(detail.getQuantity());
            detailsList.add(item);
        }
        model.addAttribute("detailsList",detailsList);
        return "viewDetails";
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(@RequestParam("searchInput")String searchInput, Model model){
        List<OrdersEntity> ordersList;
        if (searchInput.isEmpty()){
            ordersList = (List<OrdersEntity>) ordersRepository.findAll();
        } else {
            ordersList = ordersRepository.findByCustomerNameContaining(searchInput);
        }
        model.addAttribute("ordersList",ordersList);
        return "ordersList";
    }
}
