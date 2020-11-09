import java.util.Scanner;
/*
door in Tower is locked, needs key from  location 3, in the locked room is a
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("You wake up in a foreign countryside unknown to you, you have no memory off how you got there and have nothing except\n the clothes on you back. ");
        Entrance entrance = new Entrance();
        Tower tower = new Tower();
        Door door = new Door();
        Trap trap = new Trap();
        House house = new House();

        Inventory inventory = new Inventory();
        Help myHelp = new Help();

        int win = 0;
        int location = 1;

        System.out.println(entrance.toString());
        //main loop
        while (win == 0) {
            int input = input();
            //System.out.println("[debug]: location = " + location);
            //error
            if (input == 69) {
                System.out.println("Hmmm... I am not sure I understand.");
            }
            //inventory
            else if (input == 1) {
                inventory.readInventory();
            }
            //entrance
            else if (input == 2) {
                location = 1;
            }
            //help
            else if (input == 3) {
                myHelp.printHelp();
                location = location;
            }
            //north:
            else if (input == 4) {
                if (location == 1) {
                    location = 2;
                }
                else if (location == 2) {
                    location = 4;
                }
                else {
                    System.out.println("Unable");
                    location = location;
                }
            }
            //south:
            else if (input == 5) {
                if (location == 2) {
                    location = 1;
                }
                else if (location == 4) {
                    location = 2;
                }
                else {
                    System.out.println("Unable");
                    location = location;
                }
            }
            //east:
            else if (input == 6) {
                if (location == 3) {
                    location = 2;
                }
                else if (location == 2) {
                    location = 5;
                }
                else {
                    System.out.println("Unable");
                    location = location;
                }
            }
            //west
            else if (input == 7) {
                if (location == 2) {
                    location = 3;
                }
                else if (location == 5) {
                    location = 2;
                }
                else {
                    System.out.println("Unable");
                    location = location;
                }
            }
            //search
            else if (input ==  8) {
                 if (location == 2 && (tower.door == false)) {
                    inventory.addSafeKey();
                     System.out.println("You found a key!");
                }
                else if (location == 3 && (door.door == true)) {
                    inventory.addGateKey();
                     System.out.println("You found a key!");
                }
                else if (location == 2 && (tower.door == true)) {
                    inventory.addHouseKey();
                     System.out.println("You found a key!");
                }
                else {
                    System.out.println("You find nothing :( ");
                }
            }
            //use
            else if (input == 9) {
                if (location == 2 && (tower.door == false) && (inventory.gateKey >= 1)) {
                    tower.door = true;
                    System.out.println("You opened the door!");
                }
                else if (location == 3 && (inventory.safeKey >= 1) && (door.door == false)) {
                    door.door = true;
                    System.out.println("You opened the door!");
                }
                else if (location == 5 && (inventory.houseKey >= 1)) {
                    house.door = true;
                    System.out.println("You opened the door!");
                }
            }
            //hint:
            else if (input == 10) {
                if  (location == 1) {
                    System.out.println("use the help command for a list of commands, than try out a few.");
                }
                else if (location == 2) {
                    System.out.println("Try searching around, and exploring.");
                }
                else  if (location == 3) {
                    System.out.println("try to unlock door, if you cannot, try finding a key.");
                }
                else  if (location == 4) {
                    System.out.println("HOW.....\n HOW??????\n AAAAAAAAA!!!!!!");
                    win = 999;
                }
                else if (location == 5) {
                    System.out.println("This is the end. Go to the other locations first.");
                }
            }
            //print location
            if (location == 1) {
                System.out.println(entrance.toString());
            }
            else if (location ==2) {
                System.out.println(tower.toString());
            }
            else if (location == 3) {
                System.out.println(door.toString());
            }
            else if (location == 4) {
                System.out.println(trap.toString());
                win = -1;
            }
            else  if (location == 5) {
                System.out.println(house.toString());
            }
            //victory
            if ((location == 5) && (house.door == true)) {
                System.out.println("You enter the house, and hear something ....\nYou hear your teacher calling your name...\nThen you wake up!\nYou WIN!!!\n (you get to enjoy virtual class again, yay!!)");
                win = 1;
            }
            //System.out.println("[debug]: location = " + location);
        }
    }

    public static int input() {
        Scanner readIn = new Scanner(System.in);
        System.out.print("> ");
        String in = readIn.nextLine();
        in = in.toLowerCase();
        if (in.equals("inventory")) {
            return (1);
        }
        else if (in.equals("entrance")) {
            return(2);
        }
        else if (in.equals("help")) {
            return(3);
        }
        else if (in.equals("north")) {
            return (4);
        }
        else if (in.equals("south")) {
            return(5);
        }
        else if (in.equals("east")) {
            return(6);
        }
        else if (in.equals("west")) {
            return(7);
        }
        else if (in.equals("search")) {
            return (8);
        }
        else if (in.equals("use")) {
            return (9);
        }
        else if (in.equals("hint")) {
            return (10);
        }
        //unknown input
        return(69);
    }
}