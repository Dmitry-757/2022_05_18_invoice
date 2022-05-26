import java.util.Objects;

public class InvoiceString {
    private long invoiceId; //reference to had-part
    private long invoiceStringId;

    private Product product;

    public InvoiceString(long invoiceId, long invoiceStringId) throws Exception {
        if((invoiceId>0)&&(invoiceStringId>0)) {
            this.invoiceId = invoiceId;
            this.invoiceStringId = invoiceStringId;
        }
        else
            throw new Exception("invoiceId and invoiceStringId must not be zero");
    }

    public long getId() {
        return invoiceStringId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, invoiceStringId);
    }
}
