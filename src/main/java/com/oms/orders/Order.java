package com.oms.orders;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "order_header")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "ORDER_SHIPMENT_DATE")
    private Date orderShipmentDate;

    @Column(name = "SHIPPER_ID")
    private Integer shipperId;

	

	

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getOrderShipmentDate() {
		return orderShipmentDate;
	}

	public void setOrderShipmentDate(Date orderShipmentDate) {
		this.orderShipmentDate = orderShipmentDate;
	}

	public int getShipperId() {
		return shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}
	

	public Order() {
		super();
	}

	public Order(int customerId, Date orderDate, String orderStatus, String paymentMode, Date paymentDate,
			Date orderShipmentDate) {
		super();
		
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.orderShipmentDate = orderShipmentDate;
	}

    
}