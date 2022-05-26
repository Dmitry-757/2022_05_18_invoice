public class Product {
    private long productID;
    private String productName;

    public Product(String productName) throws Exception {
        productID = StoreService.getLastProductId()+1;
        if( StoreService.isPresent(productID)) {
            throw new Exception("Product with id "+productID+" already exist!");
        }

        StoreService.setLastProductId(productID);
        this.productName = productName;
    }
}
