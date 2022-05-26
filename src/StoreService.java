import java.util.HashSet;


public class StoreService {
    //store
    private static HashSet<String> storeNameSet = new HashSet<>();

    //invoice
    private static HashSet<Long> invoiceIdSet = new HashSet<>();
    private static long lastInvoiceId = 0;

    //client
    private static HashSet<Long> clientInn = new HashSet<>();

    //product
    private static HashSet<Long> productIdSet = new HashSet<>();
    private static long lastProductId = 0;




    public static <T> boolean isUsingForbidden(T item) {
        if(item instanceof Store){
            return storeNameSet.contains(item);
        }
        else if(item instanceof Invoice){
            return invoiceIdSet.contains(item);
        }
        else if(item instanceof Client){
            return clientInn.contains(item);
        }
        else if(item instanceof Product){
            return productIdSet.contains(item);
        }

        return true;
    }


    //*** Store *********
    public static void addStoreName(String storeName) {
        storeNameSet.add(storeName);
    }

    //*** invoice ********
    public static long getLastInvoiceId() {
        return lastInvoiceId;
    }
    public static void setLastInvoiceId(long lastInvoiceId) {
        StoreService.lastInvoiceId = lastInvoiceId;
        invoiceIdSet.add(lastInvoiceId);
    }

    //*** Product *************
    public static long getLastProductId() {
        return lastProductId;
    }
    public static void setLastProductId(long lastProductId) {
        StoreService.lastProductId = lastProductId;
        productIdSet.add(lastProductId);
    }
    //*************************


}



