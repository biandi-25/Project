package com.company;

import com.company.controllers.MedicineController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final MedicineController controller;
    private final Scanner scanner;

    public MyApplication(MedicineController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (1-8)");
            System.out.println("1. Get all medicines");
            System.out.println("2. Get medicine by id");
            System.out.println("3. Get medicine by name");
            System.out.println("4. Get medicine by prices");
            System.out.println("5. Create medicine");
            System.out.println("6. Delete medicine by id");
            System.out.println("7. Delete medicine by name");
            System.out.println("8. Get the most expensive medicine by expiration_data");
            System.out.println("9. Remove medicine by expiration data");
            System.out.println("0. Exit");
            System.out.println();
            try{
                System.out.println("Enter the option: (1-9)");
                int option = scanner.nextInt();
                if(option==1){
                    getAllMedicinesMenu();
                }
                else if(option==2){
                    getMedicineByIdMenu();
            }
                else if(option==3){
                    getMedicineByNameMenu();
                }
                else if(option==4){
                    getMedicineByPriceMenu();
                }
                else if(option==5){
                    createMedicineMenu();
                }
                else if(option==6){
                    removeMedicineByIdMenu();
                }
                else if(option==7){
                    removeMedicineByNameMenu();
                }
                else if(option==8){
                    getMedicineByExpirationData();
                }
                else if(option==9){
                    removeMedicineByExpirationData();
                }
                else {
                    break;
                }
                }catch (InputMismatchException e){
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("***************************************");
        }
    }
    public void getAllMedicinesMenu(){
        String response = controller.getAllMedicines();
        System.out.println(response);
    }
    public void getMedicineByIdMenu(){
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller.getMedicine(id);
        System.out.println(response);
    }
    public void getMedicineByNameMenu(){
        System.out.println("Please enter name:");
        String name = scanner.next();
        String response = controller.getMedicineByName(name);
        System.out.println(response);
    }
    public void getMedicineByPriceMenu(){
        System.out.println("Pleace enter first price:");
        int price1 = scanner.nextInt();
        System.out.println("Please enter second price:");
        int price2 = scanner.nextInt();

        String response = controller.getMedicineByPrice(price1, price2);
        System.out.println(response);

    }
    public void createMedicineMenu(){
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter price:");
        int price = scanner.nextInt();
        System.out.println("Please enter expiration data:");
        String expiration_data = scanner.next();
        System.out.println("Please enter manufacturer:");
        String manufacturer = scanner.next();
        String response = controller.createMedicine(name,price,expiration_data,manufacturer);
        System.out.println(response);
    }
    public void removeMedicineByIdMenu() {
        System.out.println("Please enter id: ");
        int id = scanner.nextInt();
        String response = controller.removeMedicineById(id);
        System.out.println(response);
    }
    public void getMedicineByExpirationData(){
        System.out.println("Please enter expiration_data");
        String expiration_data = scanner.next();
        String response = controller.getMedicineByExpirationData(expiration_data);
        System.out.println(response);
    }
    public void removeMedicineByNameMenu() {
        System.out.println("Please enter name: ");
        String name = scanner.next();
        String response = controller.removeMedicineByName(name);
        System.out.println(response);
    }
    public void removeMedicineByExpirationData() {
        System.out.println("Please enter Expiration Data: ");
        String expiration_data = scanner.next();
        String response = controller.removeMedicineByExpirationData(expiration_data);
        System.out.println(response);
    }
}
