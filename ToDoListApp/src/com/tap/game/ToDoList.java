package com.tap.game;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks; // List to hold tasks
    private Scanner scanner; // Scanner for user input

    public ToDoList() {
        tasks = new ArrayList<>(); // Initialize the task list
        scanner = new Scanner(System.in); // Initialize scanner
    }

    // Method to add a task
    public void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine(); // Get task from user
        tasks.add(task); // Add task to the list
        System.out.println("Task added: " + task);
    }

    // Method to remove a task
    public void removeTask() {
        viewTasks(); // Display current tasks
        System.out.print("Enter the task number to remove: ");
        int index = scanner.nextInt() - 1; // Get index from user
        scanner.nextLine(); // Consume the newline character
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index); // Remove task
            System.out.println("Removed task: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to view tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i)); // Display tasks with numbers
            }
        }
    }

    // Method to update a task
    public void updateTask() {
        viewTasks(); // Display current tasks
        System.out.print("Enter the task number to update: ");
        int index = scanner.nextInt() - 1; // Get index from user
        scanner.nextLine(); // Consume the newline character
        if (index >= 0 && index < tasks.size()) {
            System.out.print("Enter the updated task: ");
            String updatedTask = scanner.nextLine(); // Get updated task from user
            tasks.set(index, updatedTask); // Update the task
            System.out.println("Updated task: " + updatedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList(); // Create a new ToDoList object
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        int choice;

        do {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Update Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    toDoList.addTask(); // Call method to add a task
                    break;
                case 2:
                    toDoList.removeTask(); // Call method to remove a task
                    break;
                case 3:
                    toDoList.viewTasks(); // Call method to view tasks
                    break;
                case 4:
                    toDoList.updateTask(); // Call method to update a task
                    break;
                case 5:
                    System.out.println("Thank you for using the To-Do List!"); // Exit message
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Error message
            }
        } while (choice != 5); // Repeat until the user chooses to exit

        scanner.close(); // Close the scanner
    }
}
