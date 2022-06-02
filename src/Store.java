import java.util.Objects;

public class Store {
    private String storeName;

    public Store(String storeName) throws Exception {
//        if( StoreService.<Store,String>isUsingForbidden(this, storeName)) { //Explicit type arguments can be inferred
        if( StoreService.isUsingForbidden(this, storeName)) {
            throw new Exception("store with name "+storeName+" already exist!");
        }

        this.storeName = storeName;
        StoreService.addNewStore(this);
    }

    public String getStoreName() {
        return storeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return storeName.equals(store.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName);
    }
}
