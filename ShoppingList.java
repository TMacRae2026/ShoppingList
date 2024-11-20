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
        ArrayList<Command> commands = new ArrayList<Command>();
        commands.add(new Add()); //makes a list of all command instances
        commands.add(new Remove());
        commands.add(new View());
        commands.add(new Help());
        
        
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the item you would like to add by typeing 'add (item)'. (type 'help' to get a list of all commands):");
            String command = scanner.next();
            String arg = "";
            if(command.equalsIgnoreCase("add") || command.equalsIgnoreCase("remove")) {
                arg = scanner.next();
            }
            for(Command c : commands) { //Executes user inputted command
                if(c.getName().equals(command)){
                    shoppingList = c.executeCommand(arg, shoppingList);
                }
            }
        }
    }
}

class Command {
    // Fields
    private String name;

    // Constructor
    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    // Method to be overridden by subclasses
    public ArrayList<String> executeCommand(String arg, ArrayList<String> list) {
        return null;
    }
}


class Add extends Command {

    // Constructor
    public Add() {
        super("add"); //supercall
    }
    // Overridden method to implement specific behavior
    @Override
    public ArrayList<String> executeCommand(String arg, ArrayList<String> in) {
        in.add(arg);
        return in;
    }
}

class Remove extends Command {

    // Constructor
    public Remove() {
        super("remove"); //supercall
    }

    // Overridden method to implement specific behavior
    @Override
    public ArrayList<String> executeCommand(String arg, ArrayList<String> in) {
        in.remove(arg);
        return in;
    }
}

class View extends Command {

    // Constructor
    public View() {
        super("view"); //supercall
    }

    // Overridden method to implement specific behavior
    @Override
    public ArrayList<String> executeCommand(String arg, ArrayList<String> in) {
        int i = 0;
        for(String s : in) {
            i++;
            System.out.println(i + ": " + s);
        }
        return in;
    }
}

class Help extends Command {

    // Constructor
    public Help() {
        super("help"); //supercall
    }

    // Overridden method to implement specific behavior
    @Override
    public ArrayList<String> executeCommand(String arg, ArrayList<String> in) {
        System.out.println("add (item), adds an item to the list."
                + "\nremove (item), removes an item from the list."
                + "\nhelp, displays this list."
                + "\nview, prints the list."); 
        /*Note, how do I get access to the commands arraylist?
        I don't want to make the executeCommand have another argument,
        but I don't see any other way to do it.*/
        return in;
    }
}

