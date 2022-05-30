public interface InvoiceI {
    void addString(Product product, double quantity);
    void correctString(InvoiceString invoiceString, Product product, double quantity);
    void removeString(InvoiceString invoiceString);

}
