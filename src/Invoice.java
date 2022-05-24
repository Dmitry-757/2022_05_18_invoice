public class Invoice {
    private String invoiceId;


    public Invoice(String invoiceId) throws Exception {
        if( StoreService.getInvoiceIdSet().contains(invoiceId)) {
            throw new Exception("invoice with name "+invoiceId+" already exist!");
        }

        this.invoiceId = invoiceId;
        StoreService.addInvoiceId(invoiceId);
    }

}
