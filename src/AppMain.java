public class AppMain {
    public static void main(String[] args) {
        Client ka1 = null;
        try {
            ka1 = new Client("Pupkin",1101005351);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Store store1 = null;
        try {
            store1 = new Store("Sklad1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Invoice invoice1 = null;
        try {
            invoice1 = new Invoice(EInvoiceType.IN, store1, ka1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Product product1 = null, product2 = null;
        try {
            product1 = new Product("some product1");
            product2 = new Product("some product2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        invoice1.addString(product1, 10);
        invoice1.addString(product2, 20);

        System.out.println(invoice1);
    }
}
