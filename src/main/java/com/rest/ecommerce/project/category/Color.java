package com.rest.ecommerce.project.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Color {

    @Id
    @JsonIgnore
    private Integer color_id;

    private String color_value;

    @OneToMany(mappedBy = "color_id")
    private List<ProductVariants> productVariants;

    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariants> productVariants) {
        this.productVariants = productVariants;
    }

    public Color() {
    }

    public Color(Integer color_id, String color_value) {
        this.color_id = color_id;
        this.color_value = color_value;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public String getColor_value() {
        return color_value;
    }

    public void setColor_value(String color_value) {
        this.color_value = color_value;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color_id=" + color_id +
                ", color_value='" + color_value + '\'' +
                '}';
    }
}
