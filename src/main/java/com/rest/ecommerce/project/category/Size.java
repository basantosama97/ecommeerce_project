package com.rest.ecommerce.project.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Size {
    @Id
    @JsonIgnore
    private Integer size_id;
    private String size_value;

    @OneToMany(mappedBy = "size_id")
    private List<ProductVariants> productVariants;

    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariants> productVariants) {
        this.productVariants = productVariants;
    }

    public Size() {
    }

    public Size(Integer size_id, String size_value) {
        this.size_id = size_id;
        this.size_value = size_value;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    public String getSize_value() {
        return size_value;
    }

    public void setSize_value(String size_value) {
        this.size_value = size_value;
    }
}
