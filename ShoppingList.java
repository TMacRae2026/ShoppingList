/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;

/**
 *
 * @author TMacRae2026
 */

import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingList {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<String>();
        
        
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the item you would like to add by typeing 'add (item)'. (type 'help' to get a list of all commands):");
            String command = scanner.next(); //two inputs, the command name and the argument for the command
            String arg = "";
            if(command.equalsIgnoreCase("add") || command.equalsIgnoreCase("remove")) { //Argument only applies to add and remove cases
                arg = scanner.next();
            }
            switch(command.toLowerCase()) { //note for future command with arg idea, make a class called 'command' and make classes that extend command
                case "add":
                    shoppingList.add(arg);
                    break;
                case "remove":
                    for(int i = 0; i < shoppingList.size(); i++) {
                        if(shoppingList.get(i).equalsIgnoreCase(arg)) { //linar search the list to find the item.
                            shoppingList.remove(i);
                        }
                    }
                    break;
                case "view": //print the whole list
                    int i = 0;
                    for(String s : shoppingList) {
                        i++;
                        System.out.println(i + ": " + s);
                    }
                    break;
                case "help":
                    printHelp();
                    break;
            }
            
        }
    }
    
    static void printHelp() {
        System.out.println("add (item), adds an item to the list.\nremove (item), removes an item from the list.\nhelp, displays this list.\nview, prints the list.");
    }
    
}
