package com.academic.inventory.entities;
import jakarta.persistence.*;


@Entity /// this class is a table in the data base
@Table(name = "productS") // with the name products

public class Product {
    @Id // this is the primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  the data base is automatically  numbered
    private Long id; // allow you to save big numebers

    // and here are the atributes of this class

    private String name;
    private String sku;
    private  int amount;
    private double price;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku(){
        return  sku;
    }

    public void setSku(String sku){
        this.sku = sku;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
