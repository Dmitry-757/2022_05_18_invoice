package AppMain;

import CLI.CLI;

public class AppMain {
    public static  boolean terminate;

    public static void main(String[] args) {
        /*
        BusinessModel.Client ka1 = null;
        try {
            ka1 = new BusinessModel.Client("Pupkin",1101005351);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BusinessModel.Store store1 = null;
        try {
            store1 = new BusinessModel.Store("Sklad1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        BusinessModel.Invoice invoice1 = null;
        try {
            invoice1 = new BusinessModel.Invoice(BusinessModel.EInvoiceType.IN, store1, ka1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BusinessModel.Product product1 = null, product2 = null, product3 = null;
        try {
            product1 = new BusinessModel.Product("some product1");
            product2 = new BusinessModel.Product("some product2");
            product3 = new BusinessModel.Product("some product0");
            invoice1.addString(product1, 10);
            invoice1.addString(product2, 20);
            invoice1.addString(product3, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(invoice1);
        System.out.println(invoice1.getTableOfProducts());

        System.out.println("********************************************");
        System.out.println();
        System.out.println("let`s try find product by name 'some product0'");

        Map<Long, BusinessModel.InvoiceString> filteredMap =
        invoice1.getInvoiceStringByProduct("some product0");
        for (Map.Entry<Long, BusinessModel.InvoiceString> es: filteredMap.entrySet()){
            System.out.println(es.getValue());
        }

        System.out.println("********************************************");
        System.out.println();
        System.out.println("let`s try find product by ID '2'");
        System.out.println(invoice1.getInvoiceStringByProduct(2));
*/
        CLI cli = new CLI();
        while (!terminate){
            cli.upLevelMenu();
        }

    }
}
