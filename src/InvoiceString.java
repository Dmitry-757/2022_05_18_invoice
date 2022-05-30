import java.util.Objects;

public class InvoiceString {
    private final long invoiceId; //reference to had-part
    private final long invoiceStringId;

    private Product product;
    private double quantity;

    public InvoiceString(long invoiceId, long invoiceStringId) throws Exception {
        if((invoiceId>0)&&(invoiceStringId>0)) {
            this.invoiceId = invoiceId;
            this.invoiceStringId = invoiceStringId;
        }
        else
            throw new Exception("Error! invoiceId and invoiceStringId must not be zero");
    }

    public InvoiceString(long invoiceId, long invoiceStringId, Product product, double quantity) throws Exception {
        if((invoiceId>0)&&(invoiceStringId>0)) {
            this.invoiceId = invoiceId;
            this.invoiceStringId = invoiceStringId;
            this.product = product;
            this.quantity = quantity;
        }
        else
            throw new Exception("invoiceId and invoiceStringId must not be zero");
    }


    public long getId() {
        return invoiceStringId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, invoiceStringId);
    }
}
