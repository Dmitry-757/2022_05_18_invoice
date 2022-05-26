import java.util.HashSet;


public class StoreService {
    //store
    private static HashSet<String> storeNameSet = new HashSet<>();

    //invoice
    private static HashSet<Long> invoiceIdSet = new HashSet<>();
    private static long lastInvoiceId = 0;

    //client
    private static HashSet<Long> clientInn = new HashSet<>();

    //invoice strings
    private static HashSet<Long> invoiceStringIdSet = new HashSet<>();
    private static long lastInvoiceStringId = 0;





    public static <T> boolean isPresent(T item) {
        if(item instanceof Store){
            return storeNameSet.contains(item);
        }
        else if(item instanceof Invoice){
            return invoiceIdSet.contains(item);
        }
        else if(item instanceof Client){
            return clientInn.contains(item);
        }

        return false;
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

    //*** invoice strings **********
    public static void setLastInvoiceStringId(long lastInvoiceStringId) {
        StoreService.lastInvoiceStringId = lastInvoiceStringId;
        invoiceStringIdSet.add(lastInvoiceStringId);
    }


}



