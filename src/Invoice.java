import java.util.Objects;

public class Invoice {
    //title
    private long invoiceId;
    private EInvoiceType type;
    private Store store;
    private Client client;

    //strings
    private InvoiceString invoiceString;

    public Invoice(Store store, EInvoiceType type, Client client) throws Exception {
        invoiceId = StoreService.getLastInvoiceId()+1;
        if( StoreService.isPresent(invoiceId)) {
            throw new Exception("invoice with id "+invoiceId+" already exist!");
        }

        this.invoiceId = invoiceId;
        StoreService.setLastInvoiceId(invoiceId);
        this.type = type;
        this.store = store;
        this.client = client;
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
