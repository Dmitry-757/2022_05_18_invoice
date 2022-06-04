package CLI.Directories;

import BusinessModel.Client;
import BusinessModel.Store;
import BusinessModel.StoreService;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class WorkWithStores {
    //************* work with stores ********************
    public static void workWithStores() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New store, 2 - Change store, 3 - Delete store, 4 - print stores, 5 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> createNewStore();
                    case 2 -> changeStore();
                    case 3 -> deleteStore();
                    case 4 -> printStores();
                    case 5 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    private static void printStores() {
        System.out.println("current stores:");
        for (Map.Entry<String, Store> entry: StoreService.getStoreMap().entrySet()){
            System.out.println("name="+entry.getKey());
        }
    }

    private static void deleteStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        sc.nextLine();
        printStores();
        System.out.println("Input name of deleting store");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of deleting store = " + name);
            Store store = StoreService.getStoreByName(name);
            if (store != null) {
                StoreService.deleteDirectoryItem(store);
            } else
                System.out.println("store by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private static void changeStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        sc.nextLine();
        printStores();
        System.out.println("Input name of changing store");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of changing store = " + name);
            Store store = StoreService.getStoreByName(name);
            if (store != null) {
                System.out.println("Input new name of product");
                line = sc.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String newName = matcher.group();
                    store.setName(newName);
                    System.out.println("new name of store = " + newName);
                }
            } else
                System.out.println("store by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private static void createNewStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        System.out.println("Input name of store");
        String name;
        sc.nextLine();
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of store = " + name);
            try {
                new Store(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }
    //************* work with stores ***********************
    //*****************************************************

}
