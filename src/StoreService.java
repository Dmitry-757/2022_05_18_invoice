import java.util.HashMap;
import java.util.HashSet;


public class StoreService implements StoreServiceI{
    //store
    private static HashSet<String> storeNameSet = new HashSet<>();

    //invoice
//    private static HashSet<Long> invoiceIdSet = new HashSet<>();
    private static HashMap<Long, Invoice> invoiceMap = new HashMap<>();
    private static long lastInvoiceId = 0;

    //client
    private static HashSet<Long> clientInn = new HashSet<>();

    //product
    private static HashSet<Long> productIdSet = new HashSet<>();
    private static long lastProductId = 0;




    public static <O, T> boolean isUsingForbidden(O obj, T item) {
        if(obj instanceof Store){
            return storeNameSet.contains(item);
        }
        else if(obj instanceof Invoice){
            return invoiceMap.containsKey(item);
//            return invoiceIdSet.contains(item);
        }
        else if(obj instanceof Client){
            return clientInn.contains(item);
        }
        else if(obj instanceof Product){
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
//    public static void setLastInvoiceId(long lastInvoiceId) {
//        StoreService.lastInvoiceId = lastInvoiceId;
////        invoiceIdSet.add(lastInvoiceId);
//    }

    public static void addNewInvoice(Invoice invoice){
        invoiceMap.put(invoice.getInvoiceId(),invoice);
        StoreService.lastInvoiceId = invoice.getInvoiceId();
    }
    //******************************************************

    //*** Product *************
    public static long getLastProductId() {
        return lastProductId;
    }
    public static void setLastProductId(long lastProductId) {
        StoreService.lastProductId = lastProductId;
        productIdSet.add(lastProductId);
    }


    //methods from home task
    @Override
    public Invoice addInvoice(EInvoiceType type, Store store, Client client) throws Exception {
        return new Invoice(type, store, client);
    }

    @Override
    public void correctInvoice(Invoice invoice, EInvoiceType type, Store store, Client client) {
        invoice.setType(type);
        invoice.setStore(store);
        invoice.setClient(client);
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        invoiceMap.remove(invoice.getInvoiceId());
    }
    //*************************


}



