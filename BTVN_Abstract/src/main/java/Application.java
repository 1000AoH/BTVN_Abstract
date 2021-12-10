import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {


    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Client> listClient = new ArrayList<>();

    public static void searchClientByID() {
        System.out.println("Enter the client ID");
        String x = scanner.nextLine();
        int count = 0;
        for (Client i : listClient) {
            if (i.getCode().toLowerCase().equals(x.toLowerCase())) {
                System.out.println("Client with this code: ");
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No Client found with this code");
        } else {
            System.out.println("Choice:");
            System.out.println("1 - Adjust the Client information: ");
            System.out.println("2 - Remove Client from the list:");
            System.out.println("3 - Quit:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adjustInfo(count-1);
                    break;
                case 2:
                    System.out.println("Remove successfully");
                    listClient.remove(count - 1);
                    break;
                default:
                    break;
            }
        }
    }

    public static void adjustInfo(int index) {
        boolean quit = false;
        System.out.println("0 - Print Instruction");
        System.out.println("1 - Adjust name ");
        System.out.println("2 - Adjust place");
        System.out.println("3 - Adjust email");
        System.out.println("4 - Adjust phone number");
        System.out.println("5 - Adjust sex");
        System.out.println("6 - Adjust birth year");
        System.out.println("7 - Quit");
        while (!quit) {
            System.out.println("Choose option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("1 - Adjust name ");
                    System.out.println("2 - Adjust place");
                    System.out.println("3 - Adjust email");
                    System.out.println("4 - Adjust phone number");
                    System.out.println("5 - Adjust sex");
                    System.out.println("6 - Adjust birth year");
                    System.out.println("7 - Quit");
                    break;
                case 1:
                    System.out.println("Enter Client Name");

                    listClient.get(index).setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter Client Place");
                    listClient.get(index).setPlace(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Enter Client Email");
                    listClient.get(index).setEmail(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Enter Client Phone Number");
                    listClient.get(index).setPhoneNumber(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Enter Client Sex:" + "\n1-Male\n" + "2-Female");
                    int sexInt = Integer.parseInt(scanner.nextLine());
                    if (sexInt == 1) {
                        listClient.get(index).setSex(Client.Sex.Male);
                    } else {
                        listClient.get(index).setSex(Client.Sex.Female);
                    }
                    break;
                case 6:
                    System.out.println("Enter Client Birth Year");
                    listClient.get(index).setBirthYear(scanner.nextInt());
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }
    }

    public static void printListBySex() {
        System.out.println("Choose sort method:");
        System.out.println("1 - Male");
        System.out.println("2 - Female");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                for (Client i : listClient) {
                    if (i.getSex().toString().toLowerCase().equals("male")) {
                        System.out.println(i);
                    }
                }
                break;
            } else if (choice == 2) {
                for (Client i : listClient) {
                    if (i.getSex().toString().toLowerCase().equals("female")) {
                        System.out.println(i);
                    }
                }
                break;
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public static void printList() {
        System.out.println(listClient);
    }

    public static void newClient() {
        System.out.println("Enter Client code: ");
        String code = scanner.nextLine();
        System.out.println("Enter Client name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Client place: ");
        String place = scanner.nextLine();
        System.out.println("Enter Client email: ");
        String email = scanner.nextLine();
        while (!CheckEmail.isEmailValid(email)) {
            System.out.println("Email is invalid");
            System.out.println("Enter Client email: ");
            email = scanner.nextLine();
        }
        System.out.println("Enter Client Phone Number (11 digits): ");

        String phone = scanner.nextLine();
        while (!CheckPhoneNumber.isValid11DigitnMobile(phone)) {
            System.out.println("Phone number should have 11 digit and start with 0 ");
            System.out.println("Enter Client Phone Number (11 digits): ");

            phone = scanner.nextLine();
        }

        System.out.println("Enter Client Sex:" + "\n1-Male\n" + "2-Female");
        int sexInt = Integer.parseInt(scanner.nextLine());
        Client.Sex sex;
        if (sexInt == 1) {
            sex = Client.Sex.Male;
        } else {
            sex = Client.Sex.Female;
        }
        System.out.println("Enter Client BirthYear:");
        int birthYear = Integer.parseInt(scanner.nextLine());
        while (birthYear < 1800 || birthYear > Year.now().getValue()) {
            System.out.println("Birth year need to be in the range of 1800-" + Year.now().getValue());
            System.out.println("Enter Client BirthYear:");
            birthYear = Integer.parseInt(scanner.nextLine());
        }
        var client = new Client(code, name, place, email, phone, sex, birthYear);
        listClient.add(client);
    }

    public static void printInstruction() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print options.");
        System.out.println("\t 1 - To add Client to the list.");
        System.out.println("\t 2 - To print list Clients.");
        System.out.println("\t 3 - To print list sorted by SEX.");
        System.out.println("\t 4 - To Search for a Client by ID.");
        System.out.println("\t 5 - To quit the program.");

    }
}
