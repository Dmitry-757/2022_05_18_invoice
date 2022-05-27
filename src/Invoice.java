import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Invoice {
    //title
    private long invoiceId;
    private EInvoiceType type;
    private Store store;
    private Client client;

    //strings
    private long lastInvoiceStringId = 0;
    private HashMap<Long, InvoiceString> invoiceStrings = new HashMap<>();
    private long currentStringId = 0;



    //constructors
    public Invoice(@NotNull EInvoiceType type, @NotNull Store store, @NotNull Client client) throws Exception {
        invoiceId = StoreService.getLastInvoiceId()+1;
        if( StoreService.isUsingForbidden(this, invoiceId)) {
            throw new Exception("invoice with id "+invoiceId+" already exist!");
        }

        StoreService.setLastInvoiceId(invoiceId);
        this.type = type;
        this.store = store;
        this.client = client;
    }

    //********* head part of invoice *********
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    //****************************************

    //*********************** work with invoice strings *************
    //**** add string ****
//    public void addString(){
//        try {
//            currentStringId += lastInvoiceStringId;
//            InvoiceString invoiceString = new InvoiceString(invoiceId, currentStringId);
//            invoiceStrings.put(invoiceString.getId(), invoiceString);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void addString(Product product, double quantity){
        try {
            lastInvoiceStringId++;
            currentStringId = lastInvoiceStringId;
            InvoiceString invoiceString = new InvoiceString(invoiceId, lastInvoiceStringId, product, quantity);
            invoiceStrings.put(invoiceString.getId(), invoiceString);
        } catch (Exception e) {
            System.out.println("Error! "+e.getMessage());
        }
    }

    //**** correcting invoice string ****
    public void correctString(InvoiceString invoiceString, Product product, double quantity){
        invoiceString.setProduct(product);
        invoiceString.setQuantity(quantity);
    }
    //********************************

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId);
    }

    @Override
    public String toString() {
        String tablPart = "";
        if(invoiceStrings != null) {
            StringBuilder sb = new StringBuilder();
            for (InvoiceString invoiceString : invoiceStrings.values()) {
                sb.append("Product: ").append(invoiceString.getProduct().getProductName()).append("  quantity = ").append(invoiceString.getQuantity()).append("\n");
            }
            tablPart = sb.toString();
        }
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", type=" + type +
                ", store=" + store.getStoreName() +
                ", client=" + client.getName() +
                '}'+"\n"+
                tablPart;
    }


}

//enum EInvoiceType {
//    IN,
//    OUT
//}
