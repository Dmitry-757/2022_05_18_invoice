
public interface StoreServiceI {
    void addInvoice(EInvoiceType type, Store store, Client client) throws Exception;
    void correctInvoice(Invoice invoice, EInvoiceType type, Store store, Client client);
    void removeInvoice(Invoice invoice);

}
