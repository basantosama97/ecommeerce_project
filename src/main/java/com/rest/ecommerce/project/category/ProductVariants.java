package com.rest.ecommerce.project.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class ProductVariants {
    @Id
    private Integer sku;
    private Integer quantity;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Product product_id;

    @JoinColumn(name = "size_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("productVariants")
    private Size size_id;

    @JoinColumn(name = "color_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("productVariants")
    private Color color_id;

    public ProductVariants() {
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Size getSize_id() {
        return size_id;
    }

    public void setSize_id(Size size_id) {
        this.size_id = size_id;
    }

    public Color getColor_id() {
        return color_id;
    }

    public void setColor_id(Color color_id) {
        this.color_id = color_id;
    }

    public ProductVariants(Integer sku, Integer quantity, Product product_id, Size size_id, Color color_id) {
        this.sku = sku;
        this.quantity = quantity;
        this.product_id = product_id;
        this.size_id = size_id;
        this.color_id = color_id;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
