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
    private HashMap<Long, InvoiceString> invoiceStrings = new HashMap<>();
    private HashSet<Product> productSet = new HashSet<>(); //to provide uniqueness of Products in invoice
    private long currentStringId = 0;


    //constructors
    public Invoice(@NotNull String invoiceNumber, @NotNull EInvoiceType type, @NotNull Store store, @NotNull Client client) throws Exception {
//        if( BusinessModel.StoreService.<BusinessModel.Invoice, Long>isUsingForbidden(this, BusinessModel.StoreService.getLastInvoiceId()+1)) {
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
            if(!productSet.contains(product)) {
                lastInvoiceStringId++;
                currentStringId = lastInvoiceStringId;
                InvoiceString invoiceString = new InvoiceString(invoiceId, lastInvoiceStringId, product, quantity);
                invoiceStrings.put(invoiceString.getId(), invoiceString);
                productSet.add(product);
            }
            else System.out.println("BusinessModel.Product "+product.getProductName()+" already present!");
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
        productSet.remove(invoiceString.getProduct());
        //System.gc();//call garbage collector for cleaning memory
    }
    //********************************


    @Override
    public String getTableOfProducts() {

//        Comparator<Long> valueComparator = new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                int compare = invoiceStrings
//                                      .get(o1)
//                                      .getProduct()
//                                      .getProductName()
//                                      .compareTo(invoiceStrings.get(o2).getProduct().getProductName());
//                if (compare == 0) return 1;
//                else return compare;
//            }
//        };

        Comparator<Long> valueComparator = (o1, o2) -> {
            int compare = invoiceStrings
                            .get(o1)
                            .getProduct()
                            .getProductName()
                            .compareTo(invoiceStrings.get(o2).getProduct().getProductName());
//            if (compare == 0) return 1;
//            else return compare;
            return compare;
        };

        TreeMap<Long, InvoiceString> sortedTreeMap = new TreeMap<>(valueComparator);
        sortedTreeMap.putAll(invoiceStrings);


        String tablePart = "";
        if(sortedTreeMap.size() > 0 ) {
            StringBuilder sb = new StringBuilder();
            String output = String.format("%20s    %10s \n", "BusinessModel.Product", "quantity");
            sb.append(output);
            for (InvoiceString invoiceString : sortedTreeMap.values()) {
                output = String.format("%20s    %10s \n", invoiceString.getProduct().getProductName(), invoiceString.getQuantity());
                sb.append(output);
//                sb.append("BusinessModel.Product: ").append(invoiceString.getProduct().getProductName()).append("  quantity = ").append(invoiceString.getQuantity()).append("\n");
            }
            tablePart = sb.toString();
        }
        return "BusinessModel.Invoice{" +
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

        Map<Long, InvoiceString> filteredMap = invoiceStrings
                .entrySet()
                .stream()
                .filter(v -> productName.equals(v.getValue().getProduct().getProductName()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        return filteredMap;
    }

    @Override
    //getInvoiceStringByProductID
    public Map<Long, InvoiceString> getInvoiceStringByProduct(long productID) {
        Map<Long, InvoiceString> filteredMap = invoiceStrings
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
        if(invoiceStrings != null) {
            StringBuilder sb = new StringBuilder();
            for (InvoiceString invoiceString : invoiceStrings.values()) {
                sb.append("BusinessModel.Product: ").append(invoiceString.getProduct().getProductName()).append("  quantity = ").append(invoiceString.getQuantity()).append("\n");
            }
            tablPart = sb.toString();
        }
        return "BusinessModel.Invoice{" +
                "invoiceId=" + invoiceId +
                ", type=" + type +
                ", store=" + store.getName() +
                ", client=" + client.getName() +
                '}'+"\n"+
                tablPart;
    }


}

//enum BusinessModel.EInvoiceType {
//    IN,
//    OUT
//}
