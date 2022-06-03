import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;


public class StoreService {
    //store
//    private static HashSet<String> storeNameSet = new HashSet<>();
    private static HashMap<String, Store> storeMap = new HashMap<>();

    //invoice key=invoiceId, value=invoice
    private static HashMap<Long, Invoice> invoiceMap = new HashMap<>();
    private static long lastInvoiceId = 0;

    //client key=INN, value=Name
    private static HashMap<Integer, Client> clientMap = new HashMap<>();

    //product
    private static HashMap<String, Product> productMap = new HashMap<>();
    private static long lastProductId = 0;



    //check uniqueness of objects
    public static <O, T> boolean isUsingForbidden(O obj, T item) {
        if(obj instanceof Store){
//            return storeNameSet.contains(item);
            return storeMap.containsKey(item);
        }
        else if(obj instanceof Invoice){
            return invoiceMap.containsKey(item);
        }
        else if(obj instanceof Client){
            return clientMap.containsKey(item);
        }
        else if(obj instanceof Product){
            return productMap.containsKey(item);
        }

        return true;
    }


    //************** service procedures when creating new objects ********
    //*** Store *********
    public static void addNewStore(Store store ) {
        storeMap.put(store.getStoreName(), store);
    }

    //*** invoice ********
    public static long getLastInvoiceId() {
        return lastInvoiceId;
    }

    public static void addNewInvoice(Invoice invoice){
        invoiceMap.put(invoice.getInvoiceId(),invoice);
        StoreService.lastInvoiceId = invoice.getInvoiceId();
    }
    //******************************************************

    //*** Product *************
    public static long getLastProductId() {
        return lastProductId;
    }
    public static void addProduct(Product product){
        productMap.put(product.getProductName(), product);
        StoreService.lastProductId = product.getProductID();
    }

    //**** Client **********************
    public static void addClient(Client client){
        clientMap.put(client.getInn(), client);
    }



    //methods from home task
    public static Invoice addInvoice(EInvoiceType type, Store store, Client client) throws Exception {
        return new Invoice(type, store, client);
    }

    public static void correctInvoice(Invoice invoice, EInvoiceType type, Store store, Client client) {
        invoice.setType(type);
        invoice.setStore(store);
        invoice.setClient(client);
    }

    public static void removeInvoice(Invoice invoice) {
        invoiceMap.remove(invoice.getInvoiceId());
    }

    //get invoice by id
    public static Map<Long, Invoice> getInvoiceByParam(long invoiceID) {
        Map<Long, Invoice> filteredMap = invoiceMap
                .entrySet()
                .stream()
                .filter(v -> (invoiceID == v.getKey()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    //get invoices by type
    public static Map<Long, Invoice> getInvoiceByParam(EInvoiceType type) {
        Map<Long, Invoice> filteredMap = invoiceMap
                .entrySet()
                .stream()
                .filter(v -> (type == v.getValue().getType()))
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    //get invoices by store
    public static Map<Long, Invoice> getInvoiceByParam(Store store) {
        Map<Long, Invoice> filteredMap = invoiceMap
                .entrySet()
                .stream()
                .filter(v -> (store.equals(v.getValue().getStore()) )  )
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    //get invoices by client
    public static Map<Long, Invoice> getInvoiceByParam(Client client) {
        Map<Long, Invoice> filteredMap = invoiceMap
                .entrySet()
                .stream()
                .filter(v -> (client.equals(v.getValue().getClient()) )  )
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    //*************************

    //get Product by name
//    public static Map<String, Product> getProductByParam(String name) {
//        Map<String, Product> filteredMap = productMap
//                .entrySet()
//                .stream()
//                .filter(v -> (name.equals(v.getValue().getProductName()) )  )
//                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
//
//        return filteredMap;
//    }


    public  static void deleteDirectoryItem(Object obj) {
        if(obj instanceof Product)
            productMap.remove( ( (Product)obj).getProductName()  );
        else if(Product.class.getName() == "Store")
            storeMap.remove( ( (Store)obj).getStoreName()  );
    }


    public static Product getProductByName(String name) {
        return productMap.get(name);
    }

    public static void deleteProduct(Product product){
        productMap.remove(product.getProductName());
    }

    public static Store getStoreByName(String name) {
        return storeMap.get(name);
    }

    public static void deleteStore(Store item){
        storeMap.remove(item.getStoreName());
    }

}



