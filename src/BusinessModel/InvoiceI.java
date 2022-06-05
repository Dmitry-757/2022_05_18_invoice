package BusinessModel;

import java.util.Map;

public interface InvoiceI {
    void addString(Product product, double quantity);
    void correctString(InvoiceString invoiceString, Product product, double quantity);
    void removeString(InvoiceString invoiceString);
    String getTableSortedByProducts();
    Map<Long, InvoiceString> getInvoiceStringByProduct(String productName);
    Map<Long, InvoiceString> getInvoiceStringByProduct(long productID);

}
