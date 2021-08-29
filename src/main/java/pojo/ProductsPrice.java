package pojo;

public class ProductsPrice {
    private String nameProduct;
    private String priceDolars;
    private String pricePounds;
    private String priceEuro;

    public ProductsPrice(String _nameProduct, String _priceDolars, String _pricePounds, String _priceEuro) {
        this.nameProduct = _nameProduct;
        this.priceDolars = _priceDolars;
        this.pricePounds = _pricePounds;
        this.priceEuro = _priceEuro;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }


    public String getPriceDolars() {
        return this.priceDolars;
    }


    public String getPricePounds() {
        return this.pricePounds;
    }

    public String getPriceEuro() {
        return this.priceEuro;
    }

}
