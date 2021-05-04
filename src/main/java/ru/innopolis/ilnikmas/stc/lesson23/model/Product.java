package ru.innopolis.ilnikmas.stc.lesson23.model;

public class Product {
    private Integer productId;
    private String product;
    private Double price;
    private String manufacturer;
    private String originCountry;

    public Product() {}

    public Product(Integer productId, String product, Double price, String manufacturer, String originCountry) {
        this.productId = productId;
        this.product = product;
        this.price = price;
        this.manufacturer = manufacturer;
        this.originCountry = originCountry;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", originCountry='" + originCountry + '\'' +
                '}';
    }


}
