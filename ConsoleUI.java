package sample;

import java.util.Scanner;

public class ConsoleUI extends MygymManager {
    private final static MygymManager manager = new MygymManager();
    public static int count = 0;

    public static void main(String[] args) {

        System.out.println("WELCOME TO OUR GYM MANAGEMENT SYSTEM!");

        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            //main console menu
            System.out.println("Press 1 to Add member.");
            System.out.println("Press 2 to Delete member.");
            System.out.println("Press 3 to print data.");
            System.out.println("Press 4 to save data.");
            System.out.println("Press 5 to go to GUI.");

            //get user choice
            System.out.print("Enter your choice : ");
            String choice = scanner.next();

            if (choice.equals("1")) {
                addMember();
            } else if (choice.equals("2")) {
                deleteMember();
            } else if (choice.equals("3")) {
                printMember();
            } else if (choice.equals("4")) {
                saveMember();
            }
            else if (choice.equals("5")){
                manager.openGui();
            }
            else {
                System.out.println("Invalid Input");
            }
            while (true) {
                //get user decision to end program
                System.out.println("\n Do you want to exit (y/n) ");
                String choice1 = scanner.next();
                choice1.toLowerCase();
                if (choice1.equals("y")) {
                    exit = true;
                    break;
                } else if (choice1.equals("n")) {
                    System.out.println("End...............!");
                    break;
                }
            }
        }
    }


    private static void saveMember() {
        manager.save();
    }

    private static void printMember() {
        manager.print();
    }

    private static void deleteMember() {
        //set delete member in console
        Scanner input = new Scanner(System.in);
        System.out.println("Add Membership number: ");
        String membershipNo = input.next();
        boolean result = manager.deleteMember(membershipNo);
        if (result) {
            count++;
        }
    }

    private static void addMember() {
        Scanner input = new Scanner(System.in);

        if (count < 100) { System.out.println("Enter Membership Number: ");
        //calculate member limit and get details
            String membershipID = input.next();
            System.out.println("Enter Member Name:");
            String membershipName = input.next();
            System.out.println("Enter Member Join Day: ");
            int memberDay = input.nextInt();
            System.out.println("Enter member Join Month: ");
            int memberMonth = input.nextInt();
            System.out.println("Enter Member Join year: ");
            int memberYear = input.nextInt();
            System.out.println("Enter the type of membership(D-default member, S-student member, 0-over 60 members)");
            //add date to get membership date
            String type = input.next();
            Date date = new Date(memberDay, memberMonth, memberYear);

            DefaultMember member = null;
            //switch type of member
            switch (type) {
                case "D":
                case "d":
                    member = new DefaultMember(membershipID, membershipName, date);
                    break;
                case "S":
                case "s":
                    System.out.println("Enter school name: ");
                    String schoolName = input.next();
                    member = new StudentMember(membershipID, membershipName, date, schoolName);
                    break;
                case "O":
                case "o":
                    System.out.println("Enter member age: ");
                    int age = Integer.parseInt(input.next());
                    member = new Over60Member(membershipID, membershipName, date, age);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            manager.addMember(member);
            count++;
        } else {
            System.out.println("No free slots");

        }
    }
}
