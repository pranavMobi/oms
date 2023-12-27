package com.oms.orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "order_items")
@IdClass(OrderItemId.class)
public class OrderItem {

	@Id
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID", insertable = false, updatable = false)
    private Order order;
	
	 @Id
	 @Column(name = "ORDER_ID")
	 private int orderId;

    @Id
    @Column(name = "PRODUCT_ID") 
    private int productId;

    @Column(name = "PRODUCT_QUANTITY")
    private int productQuantity;

   
    

    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public OrderItem(int orderId, int productId, int productQuantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    
}
