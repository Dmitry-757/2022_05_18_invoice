public class Store {
    private String storeName;

    public Store(String storeName) throws Exception {
        if( StoreService.getStoreIdSet().contains(storeName)) {
            throw new Exception("store with name "+storeName+" already exist!");
        }

        this.storeName = storeName;
        StoreService.addStoreName(storeName);
    }
}
