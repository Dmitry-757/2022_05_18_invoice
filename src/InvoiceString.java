public class InvoiceString {
    private long invoiceStringId;

    public InvoiceString() throws Exception {
        invoiceStringId = StoreService.getLastInvoiceId()+1;
        if( StoreService.isPresent(invoiceStringId)) {
            throw new Exception("invoice string with id "+invoiceStringId+" already exist!");
        }

        this.invoiceStringId = invoiceStringId;
        StoreService.setLastInvoiceStringId(invoiceStringId);
    }

}
