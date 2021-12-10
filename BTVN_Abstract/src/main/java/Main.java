public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        Application.printInstruction();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = Application.scanner.nextInt();
            Application.scanner.nextLine();

            switch (choice) {
                case 0:
                    Application.printInstruction();
                    break;
                case 1:
                    Application.newClient();
                    break;
                case 2:
                    Application.printList();
                    break;
                case 3:
                    Application.printListBySex();
                    break;
                case 4:
                    Application.searchClientByID();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }

    }


}

