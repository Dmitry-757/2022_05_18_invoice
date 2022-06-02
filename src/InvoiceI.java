import java.util.Map;
import java.util.TreeMap;

public interface InvoiceI {
    void addString(Product product, double quantity);
    void correctString(InvoiceString invoiceString, Product product, double quantity);
    void removeString(InvoiceString invoiceString);
    //TreeMap<Long, InvoiceString> getInvoiceTable();
    String getTableOfProducts();
    Map<Long, InvoiceString> getInvoiceString(String productName);
    Map<Long, InvoiceString> getInvoiceString(long productID);

}
