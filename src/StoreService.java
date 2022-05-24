import java.util.HashSet;

public class StoreService {
    private static HashSet<String> storeNameSet = new HashSet<>();
    private static HashSet<String> invoiceIdSet = new HashSet<>();

    public static HashSet<String> getStoreIdSet() {
        return storeNameSet;
    }
    public static void addStoreName(String storeName) {
        storeNameSet.add(storeName);
    }


    public static HashSet<String> getInvoiceIdSet() {
        return invoiceIdSet;
    }
    public static void addInvoiceId(String storeName) {
        invoiceIdSet.add(storeName);
    }

}
