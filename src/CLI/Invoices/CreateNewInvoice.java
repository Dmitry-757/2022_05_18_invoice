package CLI.Invoices;

import BusinessModel.*;
import CLI.Directories.WorkWithClients;
import CLI.Directories.WorkWithStores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static CLI.CLI.sc;

public class CreateNewInvoice {
    static void createNewInvoice() throws Exception {
        String invoiceNumber;
        EInvoiceType type;
        Client client;
        Store store;

        //number of invoice
        Pattern pattern = Pattern.compile("^[0-9a-zA-Zа-яА-Я]*");
        System.out.println("Input invoice Number");
        String name;
        //sc.nextLine();
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            invoiceNumber = matcher.group();
            System.out.println("invoice Number = " + invoiceNumber);
        } else {
            throw new Exception("wrong input invoice Number!");
        }


        //type of invoice
        //sc.nextLine();
        System.out.println("Input type of new invoice: 1-in, 2-out");
        if (sc.hasNextInt()) {
            int intValue = sc.nextInt();
            sc.nextLine();
            switch (intValue){
                case 1 -> type = EInvoiceType.IN;
                case 2 -> type = EInvoiceType.OUT;
                default -> throw new Exception("Wrong choice of type of invoice!");
            }
            System.out.println("type of new invoice = " + type.name());
            //sc.nextLine();

            //client
            System.out.println("Choose client from:");
//            for (Map.Entry<Integer, Client> entry: StoreService.getClientMap().entrySet()){
//                System.out.println("Inn="+entry.getKey()+"  name="+entry.getValue().getName());
//            }
            WorkWithClients.printClients();
            System.out.println("Input Inn of client");
            int inn;
//            sc.nextLine();
            if (sc.hasNextInt()) {
                inn = sc.nextInt();
                sc.nextLine();
                System.out.println("Inn of client = " + inn);
                if(StoreService.getClientMap().containsKey(inn)){
                    client = StoreService.getClientMap().get(inn);
                }
                else throw new Exception("client with inn="+inn+" was not found!");
            }
            else throw new Exception("Wrong input of client`s inn!");

            //store
            pattern = Pattern.compile("^[a-zA-Zа-яА-Я0-9]*");
            WorkWithStores.printStores();
            System.out.println("Input name of store");
            //sc.nextLine();
            line = sc.nextLine();
            matcher = pattern.matcher(line);
            if (matcher.find()) {
                name = matcher.group();
                System.out.println("name of store = " + name);
                if(StoreService.getStoreMap().containsKey(name)){
                    store = StoreService.getStoreMap().get(name);
                }
                else {
                    throw new Exception("store was not found!");
                }
            } else {
                throw new Exception("wrong input name of store!");
            }

            Invoice invoice = new Invoice(invoiceNumber, type, store, client);
            System.out.println("let`s input table part of invoice");
            WorkWithStringsOfInvoice.workWithStringsOfInvoice(invoice);

        }
    }

}
