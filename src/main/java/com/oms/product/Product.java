package com.oms.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "PRODUCT_DESC")
    private String productDescription;

    @Column(name = "PRODUCT_CLASS_CODE")
    private int productClassCode;

    @Column(name = "PRODUCT_PRICE")
    private Double productPrice;

    @Column(name = "PRODUCT_QUANTITY_AVAIL")
    private int productQuantityAvailable;

    @Column(name = "LEN")
    private int length;

    @Column(name = "WIDTH")
    private int width;

    @Column(name = "HEIGHT")
    private int height;

    @Column(name = "WEIGHT")
    private Double weight;

    public Product() {
       
    }

    public Product(String productDescription, int productClassCode, Double productPrice,
                   int productQuantityAvailable, int length, int width, int height, Double weight) {
        this.productDescription = productDescription;
        this.productClassCode = productClassCode;
        this.productPrice = productPrice;
        this.productQuantityAvailable = productQuantityAvailable;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductClassCode() {
		return productClassCode;
	}

	public void setProductClassCode(int productClassCode) {
		this.productClassCode = productClassCode;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantityAvailable() {
		return productQuantityAvailable;
	}

	public void setProductQuantityAvailable(int productQuantityAvailable) {
		this.productQuantityAvailable = productQuantityAvailable;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
    

}
