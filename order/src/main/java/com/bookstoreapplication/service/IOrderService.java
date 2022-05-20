package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.OrderDTO;
import com.bookstoreapplication.model.Order;

import java.util.List;

public interface IOrderService {

    Order insertOrder(OrderDTO orderdto);

    List<Order> getAllOrderRecords();

    Order getOrderRecord(Integer id);

    Order updateOrderRecord(Integer id, OrderDTO dto);

    Order deleteOrderRecord(Integer id);

    String cancelOrder(int orderId, int userId);
}