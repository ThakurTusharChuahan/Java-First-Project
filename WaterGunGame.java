import java.util.Scanner;
import java.util.Random;

public class WaterGunGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("===== WATER GUN GAME =====");

        System.out.print("Enter Player 1 Name: ");
        String player1 = sc.nextLine();

        System.out.print("Enter Player 2 Name: ");
        String player2 = sc.nextLine();

        int health1 = 100;
        int health2 = 100;

        int ammo1 = 5;
        int ammo2 = 5;

        boolean player1Turn = true;

        while (health1 > 0 && health2 > 0) {

            System.out.println("\n--------------------------");
            System.out.println(player1 + " Health : " + health1 + " | Ammo : " + ammo1);
            System.out.println(player2 + " Health : " + health2 + " | Ammo : " + ammo2);
            System.out.println("--------------------------");

            int choice;

            if (player1Turn) {

                System.out.println("\n" + player1 + "'s Turn");
                System.out.println("1. Shoot");
                System.out.println("2. Reload");
                System.out.print("Choose Option: ");
                choice = sc.nextInt();

                if (choice == 1) {

                    if (ammo1 > 0) {

                        int damage = rand.nextInt(16) + 5; // 5 to 20

                        health2 -= damage;
                        ammo1--;

                        System.out.println(player1 + " shot " + player2);
                        System.out.println("Damage = " + damage);

                    } else {
                        System.out.println("No Ammo! Please Reload.");
                    }

                } else if (choice == 2) {

                    ammo1 = 5;
                    System.out.println(player1 + " reloaded the gun.");

                } else {
                    System.out.println("Invalid Choice!");
                    continue;
                }

            } else {

                System.out.println("\n" + player2 + "'s Turn");
                System.out.println("1. Shoot");
                System.out.println("2. Reload");
                System.out.print("Choose Option: ");
                choice = sc.nextInt();

                if (choice == 1) {

                    if (ammo2 > 0) {

                        int damage = rand.nextInt(16) + 5; // 5 to 20

                        health1 -= damage;
                        ammo2--;

                        System.out.println(player2 + " shot " + player1);
                        System.out.println("Damage = " + damage);

                    } else {
                        System.out.println("No Ammo! Please Reload.");
                    }

                } else if (choice == 2) {

                    ammo2 = 5;
                    System.out.println(player2 + " reloaded the gun.");

                } else {
                    System.out.println("Invalid Choice!");
                    continue;
                }
            }

            player1Turn = !player1Turn;
        }

        System.out.println("\n===== GAME OVER =====");

        if (health1 <= 0) {
            System.out.println(player2 + " Wins!");
        } else {
            System.out.println(player1 + " Wins!");
        }

        sc.close();
    }
}