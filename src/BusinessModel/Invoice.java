package BusinessModel;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;


public class Invoice implements InvoiceI{
    //title
    private final long invoiceId;
    private String invoiceNumber;
    private EInvoiceType type;
    private Store store;
    private Client client;

    //strings
    private long lastInvoiceStringId = 0;
    private HashMap<Long, InvoiceString> invoiceStringsMap = new HashMap<>();
    private HashSet<Product> productSet = new HashSet<>(); //to provide uniqueness of Products in invoice
    private long currentStringId = 0;


    //constructors
    public Invoice(@NotNull String invoiceNumber, @NotNull EInvoiceType type, @NotNull Store store, @NotNull Client client) throws Exception {
        if( StoreService.isUsingForbidden(this, StoreService.getLastInvoiceId()+1)) {
            throw new Exception("invoice with id "+(StoreService.getLastInvoiceId()+1)+" already exist!");
        }
        this.invoiceId = StoreService.getLastInvoiceId()+1;
        this.invoiceNumber = invoiceNumber;
        this.type = type;
        this.store = store;
        this.client = client;
        StoreService.addNewInvoice(this);
    }

    //********* head part of invoice *********

    public long getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public HashSet<Product> getProductSet() {
        return productSet;
    }

    //**** add string ****
    @Override
    public void addString(Product product, double quantity){
        try {
            if(!productSet.contains(product)) {
                lastInvoiceStringId++;
                currentStringId = lastInvoiceStringId;
                InvoiceString invoiceString = new InvoiceString(invoiceId, lastInvoiceStringId, product, quantity);
                invoiceStringsMap.put(invoiceString.getId(), invoiceString);
                productSet.add(product);
            }
            else System.out.println("Product "+product.getName()+" already present!");
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
        invoiceStringsMap.remove(invoiceString.getId(), invoiceString);
        productSet.remove(invoiceString.getProduct());
        //System.gc();//call garbage collector for cleaning memory
    }
    //********************************

    public List<InvoiceString> getInvoiceStrings(){
        return invoiceStringsMap.values().stream().toList();
    }

    @Override
    public String getTableOfProducts() {

        Comparator<Long> valueComparator = (o1, o2) -> {
            int compare = invoiceStringsMap
                            .get(o1)
                            .getProduct()
                            .getName()
                            .compareTo(invoiceStringsMap.get(o2).getProduct().getName());
            return compare;
        };

        TreeMap<Long, InvoiceString> sortedTreeMap = new TreeMap<>(valueComparator);
        sortedTreeMap.putAll(invoiceStringsMap);


        String tablePart = "";
        if(sortedTreeMap.size() > 0 ) {
            StringBuilder sb = new StringBuilder();
            String output = String.format("%20s    %10s \n", "Product", "quantity");
            sb.append(output);
            for (InvoiceString invoiceString : sortedTreeMap.values()) {
                output = String.format("%20s    %10s \n", invoiceString.getProduct().getName(), invoiceString.getQuantity());
                sb.append(output);
            }
            tablePart = sb.toString();
        }
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", type=" + type +
                ", store=" + store.getName() +
                ", client=" + client.getName() +
                '}'+"\n"+
                tablePart;
    }

    @Override
    //getInvoiceStringByProductName
    public Map<Long, InvoiceString> getInvoiceStringByProduct(String productName) {

        Map<Long, InvoiceString> filteredMap = invoiceStringsMap
                .entrySet()
                .stream()
                .filter(v -> productName.equals(v.getValue().getProduct().getName()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    @Override
    //getInvoiceStringByProductID
    public Map<Long, InvoiceString> getInvoiceStringByProduct(long productID) {
        Map<Long, InvoiceString> filteredMap = invoiceStringsMap
                .entrySet()
                .stream()
                .filter(v -> productID == (v.getValue().getProduct().getProductID()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId);
    }

    @Override
    public String toString() {
        String tablPart = "";
        if(invoiceStringsMap != null) {
            StringBuilder sb = new StringBuilder();
            for (InvoiceString invoiceString : invoiceStringsMap.values()) {
                sb.append("Product: ").append(invoiceString.getProduct().getName()).append("  quantity = ").append(invoiceString.getQuantity()).append("\n");
            }
            tablPart = sb.toString();
        }
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", invoiceNumber=" + invoiceNumber +
                ", type=" + type +
                ", store=" + store.getName() +
                ", client=" + client.getName() +
                '}'+"\n"+
                tablPart;
    }

    public String getTablePart(){
        String tablPart = "";
        if(invoiceStringsMap != null) {
            StringBuilder sb = new StringBuilder();
            for (InvoiceString invoiceString : invoiceStringsMap.values()) {
                sb.append("Product: ").append(invoiceString.getProduct().getName()).append("  quantity = ").append(invoiceString.getQuantity()).append("\n");
            }
            tablPart = sb.toString();
        }
        return tablPart;
    }

}

