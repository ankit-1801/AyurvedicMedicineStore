package com.ayurvedamedicine.serviceImpl;

import com.ayurvedamedicine.entities.Order;
import com.ayurvedamedicine.exception.MedicineNotFoundException;
import com.ayurvedamedicine.exception.OrderNotFoundException;
import com.ayurvedamedicine.repository.IOrderRepository;
import com.ayurvedamedicine.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;


    @Override
    public String add(Order order) {
        order.setOrderDate(LocalDate.now());
        iOrderRepository.save(order);
        return "order added successfully";
    }

    @Override
    public String update(Order order, Integer id) {
        Order o=iOrderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id= "+id+" is not found"));

        boolean needUpdate = false;
        if (order.getTotalCost() !=0.0)
        {
            o.setOrderId(order.getOrderId());
            needUpdate = true;
        }
//        if(order.getOrderDate().isBefore(order.getDispatchDate())){
//            o.setOrderDate(order.getOrderDate());
//            needUpdate = true;
//        }
//        if(order.getDispatchDate().isAfter(order.getOrderDate())){
//            o.setDispatchDate(order.getDispatchDate());
//            needUpdate = true;
//        }
        if(needUpdate) {
            iOrderRepository.save(o);
            return "order updated successfully";
        }
        return "Nothing to update";
    }

    @Override
    public String delete(Integer id) {
        iOrderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id= "+id+" is not found"));
        iOrderRepository.deleteById(id);
        return " Order deleteed ";
    }

    @Override
    public Order read(Integer id) {
        Order order=iOrderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("order with id ="+id+"is not found"));
        return order;
    }

    @Override
    public List<Order> readAll() {
        List<Order> orderList=new ArrayList<Order>();
        iOrderRepository.findAll().forEach(order -> orderList.add(order));
        return orderList;
    }

	@Override
	public List<Order> getOrderByUserId(int customerId) {
		List <Order> orderList=iOrderRepository.findByUserId(customerId);
        return orderList;
	}
}