package BusinessModel;

import java.util.Objects;

public class Product {
    private long productID;
    private String productName;
    private String measure;

    public Product(String productName) throws Exception {
        productID = StoreService.getLastProductId()+1;
//            if( BusinessModel.StoreService.<BusinessModel.Product,Long>isUsingForbidden(this, productID)) {////Explicit type arguments can be inferred
            if( StoreService.isUsingForbidden(this, productID)) {
            throw new Exception("BusinessModel.Product with id "+productID+" already exist!");
        }

        //BusinessModel.StoreService.setLastProductId(productID);
        this.productName = productName;
        StoreService.addProduct(this);
    }

    public long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

}
