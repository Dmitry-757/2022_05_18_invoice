public class Invoice {
    private long invoiceId;
    private EInvoiceType type;
    private Store store;
    private Client client;


    public Invoice(Store store, EInvoiceType type) throws Exception {
        invoiceId = StoreService.getLastInvoiceId()+1;
//        if( StoreService.isInvoiceIdPresent(invoiceId)) {
        if( StoreService.isPresent(invoiceId)) {
            throw new Exception("invoice with id "+invoiceId+" already exist!");
        }

        this.invoiceId = invoiceId;
        StoreService.setLastInvoiceId(invoiceId);
        this.type = type;
        this.store = store;
    }



}

enum EInvoiceType {
    IN,
    OUT
}
