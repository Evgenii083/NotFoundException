package org.example.Exception.project;

public class Product {

    public Product() {
    }


    public Product(String productName, int id, int productId) {
        this.productName = productName;
        this.id = id;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    private String productName;
    private int id;
    private int productId;


}

