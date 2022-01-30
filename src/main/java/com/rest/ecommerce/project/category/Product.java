package com.rest.ecommerce.project.category;

import javax.persistence.*;
import java.util.List;
//@Document(indexName = "productindex")
//@Access(value=AccessType.PROPERTY)
//@Table(name = "PRODUCT")
@Entity
public class Product {

    @Id
    private Integer pid;
    //@Field(type = FieldType.Text)
    private String product_name;
    //@Field(type = FieldType.Text)
    private String product_description;
    private String product_slug;
    private String product_image;
    private Boolean newProduct;
    private Boolean featured;
    private Boolean active;
//    @Field(type = FieldType.Float)
    private float price;

    @OneToMany(mappedBy = "product_id")
    private List<ProductVariants> productVariants;

    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariants> productVariants) {
        this.productVariants = productVariants;
    }
//@Field(type = FieldType.Keyword)
    @JoinColumn(name = "category_")
    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnore
    private Category category_;

    public Category getCategory_() {
        return category_;
    }

    public void setCategory_(Category category_) {
        this.category_ = category_;
    }

    public Product() {
    }

    public Product(String infoHash, long length, String name, String nameInfo) {
    }

    public Product(Integer product_id, String product_name, String product_description, String product_slug, String product_image, Boolean new_product, Boolean featured, Boolean active, float product_price) {
        this.pid = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_slug = product_slug;
        this.product_image = product_image;
        this.newProduct = new_product;
        this.featured = featured;
        this.active = active;
        this.price = product_price;
    }

    public Product(int i, String s, String description, String slug, String image, boolean b, boolean b1, boolean b2) {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_slug() {
        return product_slug;
    }

    public void setProduct_slug(String product_slug) {
        this.product_slug = product_slug;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Boolean getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Boolean newProduct) {
        this.newProduct = newProduct;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
