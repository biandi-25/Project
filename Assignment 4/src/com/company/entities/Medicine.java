package com.company.entities;

public class Medicine {
    private int id;
    private String name;
    private int price;
    private String expiration_data;
    private String manufacturer;

    public Medicine(){

    }

    public Medicine(String name, int price, String expiration_data, String manufacturer){
        setName(name);
        setPrice(price);
        setExpiration_data(expiration_data);
        setManufacturer(manufacturer);
    }
    public Medicine(int id,String name, int price, String expiration_data, String manufacturer){
        setId(id);
        setName(name);
        setPrice(price);
        setExpiration_data(expiration_data);
        setManufacturer(manufacturer);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpiration_data() {
        return expiration_data;
    }

    public void setExpiration_data(String expiration_data) {
        this.expiration_data = expiration_data;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration_data='" + expiration_data + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
