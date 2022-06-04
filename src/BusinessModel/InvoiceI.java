package BusinessModel;

import java.util.Map;

public interface InvoiceI {
    void addString(Product product, double quantity);
    void correctString(InvoiceString invoiceString, Product product, double quantity);
    void removeString(InvoiceString invoiceString);
    //TreeMap<Long, BusinessModel.InvoiceString> getInvoiceTable();
    String getTableOfProducts();
    Map<Long, InvoiceString> getInvoiceStringByProduct(String productName);
    Map<Long, InvoiceString> getInvoiceStringByProduct(long productID);

}
