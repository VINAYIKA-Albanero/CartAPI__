package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Data

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private Date date;
    private String status;
    private double total;
    private String userId;
    private List<OrderItem> orderItems;

    public Order(String id, Date date, String status, double total, String userId, List<OrderItem> orderItems) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.total = total;
        this.userId = userId;
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }




    // public String getCustomerName(Long id) {
       // return customerRepository.findNameById(id);
  //  }
}
