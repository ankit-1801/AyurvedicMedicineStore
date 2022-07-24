package com.ayurvedamedicine.controller;

import com.ayurvedamedicine.entities.Order;
import com.ayurvedamedicine.entities.OrderItem;
import com.ayurvedamedicine.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    
    @PostMapping("/ordercreate")
    public ResponseEntity<String>createOrder (@RequestBody Order o) throws IOException {
        return new ResponseEntity<>(iOrderService.add(o), HttpStatus.CREATED);

    }
    @GetMapping("/readOrderAll")
    public List<Order> fetchingOrder(){
        return iOrderService.readAll();
    }
    @GetMapping("/readorderbyid/{ordId}")
    public ResponseEntity<Order> readOrder(@PathVariable("ordId")Integer ordId)
    {
        return new ResponseEntity<>(iOrderService.read(ordId),HttpStatus.OK);
    }
    @GetMapping("/getMediListById/{ordId}")
    public List<OrderItem> getMediListById(@PathVariable("ordId")Integer ordId)
    {
    	return iOrderService.getMediListById(ordId);
    }
    @PatchMapping("/updateorder/{ordId}")
    public ResponseEntity<String> updateorder(@PathVariable("ordId") Integer ordId, @RequestBody Order order){
        return new ResponseEntity<>(iOrderService.update(order, ordId), HttpStatus.OK);
    }
    @DeleteMapping("/del/{ordId}")
    private void deleteOrder(@PathVariable("ordId") Integer ordId){
        iOrderService.delete(ordId);
    }
    @GetMapping("/getUserOrders/{userId}")
    public List<Order> getOrderByUserId(@PathVariable("userId")Integer userId)
    {
        return iOrderService.getOrderByUserId(userId);
    }

}