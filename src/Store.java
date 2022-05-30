public class Store {
    private String storeName;

    public Store(String storeName) throws Exception {
//        if( StoreService.<Store,String>isUsingForbidden(this, storeName)) { //Explicit type arguments can be inferred
        if( StoreService.isUsingForbidden(this, storeName)) {
            throw new Exception("store with name "+storeName+" already exist!");
        }

        this.storeName = storeName;
        StoreService.addStoreName(storeName);
    }

    public String getStoreName() {
        return storeName;
    }
}
