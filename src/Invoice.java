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
    private HashMap<Long, InvoiceString> invoiceStrings;
    private long currentStringId = 0;



    //strings
    private InvoiceString invoiceString;


    //constructors
    public Invoice(@NotNull Store store, @NotNull EInvoiceType type, @NotNull Client client) throws Exception {
        invoiceId = StoreService.getLastInvoiceId()+1;
        if( StoreService.isUsingForbidden(invoiceId)) {
            throw new Exception("invoice with id "+invoiceId+" already exist!");
        }

        StoreService.setLastInvoiceId(invoiceId);
        this.type = type;
        this.store = store;
        this.client = client;
    }

    //add string
    public void addString(){
        try {
            currentStringId += lastInvoiceStringId;
            InvoiceString invoiceString = new InvoiceString(invoiceId, currentStringId);
            invoiceStrings.put(invoiceString.getId(), invoiceString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void addString(Product product, double quantity){
        try {
            currentStringId += lastInvoiceStringId;
            InvoiceString invoiceString = new InvoiceString(invoiceId, currentStringId, product, quantity);
            invoiceStrings.put(invoiceString.getId(), invoiceString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    @Override
    public int hashCode() {
        return Objects.hash(invoiceId);
    }
}

enum EInvoiceType {
    IN,
    OUT
}
