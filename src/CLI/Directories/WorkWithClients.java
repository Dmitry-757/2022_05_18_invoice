package CLI.Directories;

import BusinessModel.Client;
import BusinessModel.StoreService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class WorkWithClients {
    //************* work with clients ********************
    public static void workWithClients() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New client, 2 - client, 3 - Delete client, 4 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> createNewClient();
                    case 2 -> changeClient();
                    case 3 -> deleteClient();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    private static void deleteClient() {
        sc.nextLine();
        System.out.println("Input inn of deleting client");
        if (sc.hasNextInt()) {
            int inn = sc.nextInt();
            System.out.println("inn of deleting client = " + inn);
            Client client = StoreService.getClientByINN(inn);
            if (client != null) {
                StoreService.deleteDirectoryItem(client);
            } else
                System.out.println("client by INN `" + inn + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private static void changeClient() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        //String name;
        sc.nextLine();
        System.out.println("Input inn of changing client");
        if (sc.hasNextInt()) {
            int inn = sc.nextInt();
            System.out.println("inn of changing client = " + inn);
            Client client = StoreService.getClientByINN(inn);
            if (client != null) {
                System.out.println("Input new name of client");
                sc.nextLine();
                String line = sc.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String newName = matcher.group();
                    client.setName(newName);
                    System.out.println("new name of client = " + newName);
                }
            } else
                System.out.println("client by INN `" + inn + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private static void createNewClient() {
        sc.nextLine();
        System.out.println("Input inn of new client");
        if (sc.hasNextInt()) {
            int inn = sc.nextInt();
            System.out.println("inn of new client = " + inn);

            Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
            System.out.println("Input name of client");
            String name;
            sc.nextLine();
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                name = matcher.group();
                System.out.println("name of client = " + name);
                try {
                    new Client(name, inn);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("wrong input - can`t find name...");
            }
        }
    }
    //************* work with clients ***********************
    //*****************************************************
}
