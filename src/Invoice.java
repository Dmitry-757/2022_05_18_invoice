import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Invoice implements InvoiceI{
    //title
    private final long invoiceId;
    private EInvoiceType type;
    private Store store;
    private Client client;

    //strings
    private long lastInvoiceStringId = 0;
    private HashMap<Long, InvoiceString> invoiceStrings = new HashMap<>();
    private long currentStringId = 0;


    //constructors
    public Invoice(@NotNull EInvoiceType type, @NotNull Store store, @NotNull Client client) throws Exception {
//        if( StoreService.<Invoice, Long>isUsingForbidden(this, StoreService.getLastInvoiceId()+1)) {
        if( StoreService.isUsingForbidden(this, StoreService.getLastInvoiceId()+1)) {
            throw new Exception("invoice with id "+(StoreService.getLastInvoiceId()+1)+" already exist!");
        }
        this.invoiceId = StoreService.getLastInvoiceId()+1;
        this.type = type;
        this.store = store;
        this.client = client;
        //StoreService.setLastInvoiceId(invoiceId);
        StoreService.addNewInvoice(this);
    }

    //********* head part of invoice *********

    public long getInvoiceId() {
        return invoiceId;
    }

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

    public EInvoiceType getType() {
        return type;
    }

    public void setType(EInvoiceType type) {
        this.type = type;
    }
    //****************************************

    //*********************** work with invoice strings *************
    //**** add string ****
    @Override
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
    @Override
    public void correctString(InvoiceString invoiceString, Product product, double quantity){
        invoiceString.setProduct(product);
        invoiceString.setQuantity(quantity);
    }
    //********************************

    //**** removing invoice string from invoice ****
    @Override
    public void removeString(InvoiceString invoiceString){
        invoiceStrings.remove(invoiceString.getId(), invoiceString);
        //System.gc();//call garbage collector for cleaning memory
    }
    //********************************

//    @Override
//    public TreeMap<Long, InvoiceString> getInvoiceTable() {
//        TreeMap<Long, InvoiceString> res = new TreeMap<>();
//        res.putAll(invoiceStrings);
//        return res;
//    }

    @Override
    public String getInvoiceStrings() {
        TreeMap<Long, InvoiceString> treeMap = new TreeMap<>();
        treeMap.putAll(invoiceStrings);
        String tablPart = "";
        if(treeMap.size() > 0 ) {
            StringBuilder sb = new StringBuilder();
            for (InvoiceString invoiceString : treeMap.values()) {
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
