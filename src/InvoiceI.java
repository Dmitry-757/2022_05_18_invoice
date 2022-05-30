import java.util.TreeMap;

public interface InvoiceI {
    void addString(Product product, double quantity);
    void correctString(InvoiceString invoiceString, Product product, double quantity);
    void removeString(InvoiceString invoiceString);
    //TreeMap<Long, InvoiceString> getInvoiceTable();
    String getInvoiceStrings();

}
