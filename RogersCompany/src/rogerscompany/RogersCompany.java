package rogerscompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RogersCompany {

    static InputStreamReader inStream = new InputStreamReader(System.in);
    static BufferedReader stdin = new BufferedReader(inStream);
    static ArrayList<Account> AccountList = new ArrayList<Account>();
    static ArrayList<Customer> CustomerList = new ArrayList<>();
    static ArrayList<InternetPlan> InternetPlanList = new ArrayList<>();
    static ArrayList<CellPhonePlan> CellPhonePlanList = new ArrayList<>();
    static ArrayList<TVPlan> TVPlanList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        presetAccounts();
        displayMenu();
    }

    public static void presetAccounts() throws IOException {
        AccountList.add(new Account(new Customer("Bob", "Smith", "123 Lane, School Locker, China", "NO CREDIT CARD"), new InternetPlan("Large", 10, 10, 80), new CellPhonePlan("Medium", 25, 25, 3, 90), new TVPlan("null", 0, 0)));
        AccountList.add(new Account(new Customer("Jane", "Doe", "35 Road, Computer Town, USA", "1234 5678 9012 3456"), new InternetPlan("Medium", 5, 5, 70), new CellPhonePlan("Medium", 25, 25, 3, 90), new TVPlan("Large", 10, 10)));
        AccountList.add(new Account(new Customer("Ryan", "Bloggins", "1 Way, Big City, Canada", "3412 1234 4132, 2134"), new InternetPlan("null", 0, 0, 0), new CellPhonePlan("null", 0, 0, 0, 0), new TVPlan("null", 0, 0)));
        AccountList.add(new Account(new Customer("SpongeBob", "SquarePants", "124 Conch Street, Bikini Bottom, Pacific Ocean", " NO CREDIT CARD"), new InternetPlan("Small", 1, 1, 60), new CellPhonePlan("Small", 15, 15, 1, 80), new TVPlan("Large", 10, 10)));
        AccountList.add(new Account(new Customer("Patrick", "Star", "120 Conch Street, Bikini Bottom, Pacific Ocean", " NO CREDIT CARD"), new InternetPlan("Large", 10, 10, 80), new CellPhonePlan("Medium", 25, 25, 3, 90), new TVPlan("Large", 10, 10)));
        AccountList.add(new Account(new Customer("Bob", "Smith", "987 Street, Other Town, Cuba", "9876 5432 5674 2345"), new InternetPlan("Small", 1, 1, 60), new CellPhonePlan("Medium", 25, 25, 3, 90), new TVPlan("Medium", 8, 8)));
    }

    public static void displayMenu() throws IOException {
        boolean run = true;
        do {
            System.out.println("Rogers Database");
            System.out.println("1 - Add New Account");
            System.out.println("2 - Display all Rogers Company Accounts");
            System.out.println("3 - Search Accounts");
            System.out.println("4 - Remove Account");
            System.out.println("5 - Change Account Information");
            System.out.println("6 - Exit program");
            System.out.print("Input: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {

                case 1:
                    System.out.println("\n");
                    addAccount();
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("\n");
                    displayAllAccounts();
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("\n");
                    findAccount();
                    System.out.println("\n");
                    break;

                case 4:
                    removeAccount();
                    System.out.println("\n");
                    break;

                case 5:
                    changeAccountInfo();
                    System.out.println("\n");
                    break;

                case 6:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");
            }
        } while (run == true);
    }

    public static void addAccount() throws IOException {
        AccountList.add(new Account(createCustomer(), createInternetPlan(), createCellPhonePlan(), createTVPlan()));
        System.out.println("\nNew Account Created \n");
    }

    public static Customer createCustomer() throws IOException {
        String card = "NO CREDIT CARD";

        Customer customer = new Customer("    ", "    ", "    ", card);
        System.out.print("Enter first name: ");
        String firstName = stdin.readLine();
        System.out.print("Enter last name: ");
        String lastName = stdin.readLine();
        System.out.print("Enter address: ");
        String address = stdin.readLine();

        boolean run = true;
        do {
            System.out.println("Do you have a credit card?");
            System.out.println("1 - no");
            System.out.println("2 - yes");
            System.out.print("Input: ");
            int choice = Integer.parseInt(stdin.readLine());
            switch (choice) {
                case 1:
                    run = false;
                    break;

                case 2:
                    System.out.print(" Input Credit Card number");
                    card = stdin.readLine();
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");
            }
        } while (run == true);
        customer = new Customer(firstName, lastName, address, card);
        CustomerList.add(customer);
        return customer;
    }

    public static InternetPlan createInternetPlan() throws IOException {
        System.out.println("\nInternet Plan Options");
        System.out.println("Option 1: Large Usage, 10 (Gbps) Download, 10 (Mbps) Upload ------ $80/month");
        System.out.println("Option 2: Medium Usage, 5 (Gbps) Download, 5 (Mbps) Upload ------ $70/month");
        System.out.println("Option 3: Small Usage, 1 (Gbps) Download, 1 (Mbps) Upload ------ $60/month");
        System.out.println("Option 4: NO INTERNET PLAN");

        InternetPlan internet = new InternetPlan("null", 0, 0, 0);

        boolean run = true;
        do {
            System.out.print("Option Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {

                case 1:
                    internet = new InternetPlan("Large", 10, 10, 80);
                    run = false;
                    break;

                case 2:
                    internet = new InternetPlan("Medium", 5, 5, 70);
                    run = false;
                    break;

                case 3:
                    internet = new InternetPlan("Small", 1, 1, 60);
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");
            }
        } while (run == true);

        InternetPlanList.add(internet);
        return internet;
    }

    public static CellPhonePlan createCellPhonePlan() throws IOException {
        System.out.println("\nPhone Plan Options");
        System.out.println("Option 1: Large Usage, 50 Calls/month, 50 Texts/month, 5GB of Data ------ $100/month");
        System.out.println("Option 2: Medium Usage, 25 Calls/month, 25 Texts/month, 3GB of Data ------ $90/month");
        System.out.println("Option 3: Small Usage, 15 Calls/month, 15 Texts/month, 1GB of Data ------ $80/month");
        System.out.println("Option 4: NO CELLPHONE PLAN");

        CellPhonePlan cell = new CellPhonePlan("null", 0, 0, 0, 0);

        boolean run = true;

        do {
            System.out.print("Option Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {

                case 1:
                    cell = new CellPhonePlan("Large", 50, 50, 5, 100);
                    run = false;
                    break;

                case 2:
                    cell = new CellPhonePlan("Medium", 25, 25, 3, 90);
                    run = false;
                    break;
                case 3:
                    cell = new CellPhonePlan("Small", 15, 15, 1, 80);
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");
            }
        } while (run == true);

        CellPhonePlanList.add(cell);
        return cell;
    }

    public static TVPlan createTVPlan() throws IOException {
        System.out.println("\nTV Plan Options");
        System.out.println("Option 1: Large Usage, 10 Channels ------ $10/month");
        System.out.println("Option 2: Medium Usage, 8 Channels  ------ $8/month");
        System.out.println("Option 3: Small Usage, 6 Channels ------ $6/month");
        System.out.println("Option 4: NO TV PLAN");

        TVPlan tv = new TVPlan("null", 0, 0);

        boolean run = true;
        do {
            System.out.print("Plan Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {

                case 1:
                    tv = new TVPlan("Large", 10, 10);
                    run = false;
                    break;

                case 2:
                    tv = new TVPlan("Medium", 8, 8);
                    run = false;
                    break;
                case 3:
                    tv = new TVPlan("Small", 6, 6);
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");
            }

        } while (run == true);

        TVPlanList.add(tv);
        return tv;

    }

    public static void displayAllAccounts() throws IOException {
        System.out.println("\t\t\tAll Accounts in the Rogers Company database\n");

        for (Account account : AccountList) {
            System.out.println(account);
        }
    }

    public static void findAccount() throws IOException {

        System.out.println("How would you like to find the Account? ");
        System.out.println("1- by first name");
        System.out.println("2- by last name");
        System.out.println("3- by address");
        System.out.print("Input:");

        int choice = Integer.parseInt(stdin.readLine());

        switch (choice) {

            case 1:
                findAccountFirstName();
                break;

            case 2:
                findAccountLastName();
                break;

            case 3:
                findAccountAddress();
                break;

            default:
                System.out.println("INVALID. Please enter again.");
        }

    }

    public static void findAccountFirstName() throws IOException {
        System.out.println("search which first name?");
        System.out.print("Input:");
        String firstName = stdin.readLine();
        int count = 0;

        for (Account account : AccountList) {

            if (account.getCustomer().getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("\n");
                displayOneAccount(account);
                count++;
            }
        }
        System.out.println(count + " Account(s) with the name " + firstName);
    }

    public static void findAccountLastName() throws IOException {
        System.out.println("search which last name?");
        System.out.print("Input:");
        String lastName = stdin.readLine();
        int count = 0;

        for (Account account : AccountList) {

            if (account.getCustomer().getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("\n");
                displayOneAccount(account);
                count++;
            }
        }
        System.out.println(count + " Account(s) with the last name " + lastName);
    }

    public static void findAccountAddress() throws IOException {
        System.out.println("search which address?");
        System.out.print("Input:");
        String address = stdin.readLine();
        int count = 0;

        for (Account account : AccountList) {

            if (account.getCustomer().getAddress().equalsIgnoreCase(address)) {
                System.out.println("\n");
                displayOneAccount(account);
                count++;
            }
        }
        System.out.println(count + " Account(s) with the address " + address);
    }

    public static void displayOneAccount(Account account) throws IOException {
        System.out.println(account);
    }

    public static void remove(Account account) throws IOException {
        AccountList.remove(account);

    }

    public static void removeAccount() throws IOException {
        System.out.print("Enter first name of Account to remove: ");
        String firstName = stdin.readLine();
        System.out.print("Enter last name of Account to remove: ");
        String lastName = stdin.readLine();
        System.out.print("Enter adress of Account to remove: ");
        String address = stdin.readLine();

        int count = 0;

        for (Account account : AccountList) {

            if (account.getCustomer().getFirstName().equalsIgnoreCase(firstName) && account.getCustomer().getLastName().equalsIgnoreCase(lastName) && account.getCustomer().getAddress().equalsIgnoreCase(address)) {
                remove(account);    //cant do comodifications (travers and remove too, so must do in seperate and then exit loop
                count++;
                System.out.println("\nAccount Removed \n");
                break;
            }
        }
        if (count == 0) {
            System.out.println("No Account match");
        }
    }

    public static void changeCustomerInfo() throws IOException {
        System.out.print("Enter current first name of Customer to change: ");
        String firstName = stdin.readLine();
        System.out.print("Enter current last name of Customer to change: ");
        String lastName = stdin.readLine();
        System.out.print("Enter current address of Customer to change: ");
        String address = stdin.readLine();

        int count = 0;
        for (Account account : AccountList) {

            if (account.getCustomer().getFirstName().equalsIgnoreCase(firstName) && account.getCustomer().getLastName().equalsIgnoreCase(lastName) && account.getCustomer().getAddress().equalsIgnoreCase(address)) {
                displayOneAccount(account);
                boolean run = true;
                do {
                    System.out.println("What would you like to change (add, remove, change)");

                    System.out.println("1 - Name");
                    System.out.println("2 - Last Name");
                    System.out.println("3 - Address");
                    System.out.println("4 - Credit Card Number");
                    System.out.print("Input: ");
                    int choice = Integer.parseInt(stdin.readLine());

                    switch (choice) {

                        case 1:
                            changeName(account);
                            run = false;
                            break;

                        case 2:
                            changeLastName(account);
                            run = false;
                            break;

                        case 3:
                            changeAddress(account);
                            run = false;
                            break;

                        case 4:
                            changeCard(account);
                            run = false;
                            break;
                        default:
                            System.out.println("INVALID. Please enter again.");
                    }
                } while (run == true);
                displayOneAccount(account);
                count++;
                System.out.println("\nCustomer Information Updated \n");

            }

        }

        if (count == 0) {
            System.out.println("No Account match");
        }

    }

    public static void changeName(Account account) throws IOException {
        System.out.println("Current Name of this Customer is " + account.getCustomer().getFirstName());
        System.out.print("Input new name: ");
        String newFirstName = stdin.readLine();
        account.getCustomer().setFirstName(newFirstName);
    }

    public static void changeLastName(Account account) throws IOException {
        System.out.println("Current Last Name of this Customer is " + account.getCustomer().getLastName());
        System.out.print("Input new last name: ");
        String newLastName = stdin.readLine();
        account.getCustomer().setLastName(newLastName);
    }

    public static void changeAddress(Account account) throws IOException {
        System.out.println("Current Address of this Customer is " + account.getCustomer().getAddress());
        System.out.print("Input new address: ");
        String newAddress = stdin.readLine();
        account.getCustomer().setAddress(newAddress);
    }

    public static void changeCard(Account account) throws IOException {
        System.out.println("Current Credit Card number of this Customer is " + account.getCustomer().getCard());
        System.out.print("Input new credit card number: ");
        String newCreditCard = stdin.readLine();
        account.getCustomer().setCard(newCreditCard);
    }

    public static void changeAccountInfo() throws IOException {
        boolean run = true;
        do {
            System.out.println("1 - Change Customer Information");
            System.out.println("2 - Change Plan Information");
            System.out.println("3 - Exit");
            System.out.print("Input: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {
                case 1:
                    changeCustomerInfo();
                    break;
                case 2:
                    changePlans();
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("INVALID. Please enter again.");
            }

        } while (run == true);

    }

    public static void changePlans() throws IOException {
        System.out.print("Enter first name of Customer: ");
        String firstName = stdin.readLine();
        System.out.print("Enter last name of Customer: ");
        String lastName = stdin.readLine();
        System.out.print("Enter address of Customer: ");
        String address = stdin.readLine();

        int count = 0;
        for (Account account : AccountList) {

            if (account.getCustomer().getFirstName().equalsIgnoreCase(firstName) && account.getCustomer().getLastName().equalsIgnoreCase(lastName) && account.getCustomer().getAddress().equalsIgnoreCase(address)) {
                displayOneAccount(account);
                boolean run = true;
                do {
                    System.out.println("What would you like to change (add, remove, change)");

                    System.out.println("1 - Internet Plan");
                    System.out.println("2 - Phone Plan");
                    System.out.println("3 - TV Plan");
                    System.out.print("Input: ");
                    int choice = Integer.parseInt(stdin.readLine());

                    switch (choice) {

                        case 1:
                            changeInternetPlan(account);
                            run = false;
                            break;

                        case 2:
                            changePhonePlan(account);
                            run = false;
                            break;

                        case 3:
                            changeTvPlan(account);
                            run = false;
                            break;

                        default:
                            System.out.println("INVALID. Please enter again.");
                    }
                } while (run == true);
                displayOneAccount(account);
                count++;
                System.out.println("\nCustomer Plan Updated \n");

            }

        }

        if (count == 0) {
            System.out.println("No Account match");
        }

    }

    public static void changeInternetPlan(Account account) throws IOException {
        System.out.println("\nInternet Plan Options");
        System.out.println("Option 1: Large Usage, 10 (Gbps) Download, 10 (Mbps) Upload ------ $80/month");
        System.out.println("Option 2: Medium Usage, 5 (Gbps) Download, 5 (Mbps) Upload ------ $70/month");
        System.out.println("Option 3: Small Usage, 1 (Gbps) Download, 1 (Mbps) Upload ------ $60/month");
        System.out.println("Option 4: NO INTERNET PLAN");
        String newName = "null";
        int newDownload = 0, newUpload = 0, newPrice = 0;

        boolean run = true;
        do {
            System.out.print("Option Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {

                case 1:
                    newName = "Large";
                    newDownload = 10;
                    newUpload = 10;
                    newPrice = 80;
                    run = false;
                    break;

                case 2:
                    newName = "Medium";
                    newDownload = 5;
                    newUpload = 5;
                    newPrice = 70;
                    run = false;
                    break;

                case 3:
                    newName = "Small";
                    newDownload = 1;
                    newUpload = 1;
                    newPrice = 60;
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");

            }

        } while (run == true);

        account.getInternet().setName(newName);
        account.getInternet().setDownload(newDownload);
        account.getInternet().setUpload(newUpload);
        account.getInternet().setPrice(newPrice);

    }

    public static void changePhonePlan(Account account) throws IOException {
        System.out.println("\nPhone Plan Options");
        System.out.println("Option 1: Large Usage, 50 Calls/month, 50 Texts/month, 5GB of Data ------ $100/month");
        System.out.println("Option 2: Medium Usage, 25 Calls/month, 25 Texts/month, 3GB of Data ------ $90/month");
        System.out.println("Option 3: Small Usage, 15 Calls/month, 15 Texts/month, 1GB of Data ------ $80/month");
        System.out.println("Option 4: NO CELLPHONE PLAN");

        String newName = "null";
        int newCalls = 0, newTexts = 0, newData = 0, newPrice = 0;

        boolean run = true;
        do {
            System.out.print("Option Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {
                case 1:
                    newName = "Large";
                    newCalls = 50;
                    newTexts = 50;
                    newData = 5;
                    newPrice = 100;
                    run = false;
                    break;

                case 2:
                    newName = "Medium";
                    newCalls = 25;
                    newTexts = 25;
                    newData = 3;
                    newPrice = 90;
                    run = false;
                    break;

                case 3:
                    newName = "Small";
                    newCalls = 15;
                    newTexts = 15;
                    newData = 1;
                    newPrice = 80;
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");

            }

        } while (run == true);

        account.getCell().setName(newName);
        account.getCell().setCalls(newCalls);
        account.getCell().setTexts(newTexts);
        account.getCell().setData(newData);
        account.getCell().setPrice(newPrice);

    }

    public static void changeTvPlan(Account account) throws IOException {
        System.out.println("\nTV Plan Options");
        System.out.println("Option 1: Large Usage, 10 Channels ------ $10/month");
        System.out.println("Option 2: Medium Usage, 8 Channels  ------ $8/month");
        System.out.println("Option 3: Small Usage, 6 Channels ------ $6/month");
        System.out.println("Option 4: NO TV PLAN");

        String newName = "null";
        int newChannels = 0, newPrice = 0;

        boolean run = true;
        do {
            System.out.print("Option Choice: ");
            int choice = Integer.parseInt(stdin.readLine());

            switch (choice) {
                case 1:
                    newName = "Large";
                    newChannels = 10;
                    newPrice = 10;
                    run = false;
                    break;

                case 2:
                    newName = "Medium";
                    newChannels = 8;
                    newPrice = 8;
                    run = false;
                    break;

                case 3:
                    newName = "Small";
                    newChannels = 6;
                    newPrice = 6;
                    run = false;
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("INVALID. Please enter again.");

            }

        } while (run == true);

        account.getTv().setName(newName);
        account.getTv().setChannels(newChannels);
        account.getTv().setPrice(newPrice);

    }
}
