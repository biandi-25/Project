package com.company.controllers;

import com.company.entities.Medicine;
import com.company.repositories.interfaces.IMedicineRepositories;

import java.util.List;

public class MedicineController {
    private final IMedicineRepositories repo;

    public MedicineController(IMedicineRepositories repo){this.repo=repo;}
    public String createMedicine(String name, int price, String expiration_data, String manufacturer){
        Medicine medicine = new Medicine(name, price, expiration_data, manufacturer);
        boolean created= repo.createMedicine(medicine);

        return  (created ?  "Medicine was created!" : "Medicine creation was failed!!");
    }
    public String getMedicine(int id){
        Medicine medicine = repo.getMedicine(id);

        return (medicine == null ? "Medicine was not found" : medicine.toString());
    }
    public String getMedicineByExpirationData(String expiration_data){
        Medicine medicine = repo.getMedicineByExpirationData(expiration_data);
        return (medicine == null ? "Medicine was not found!" : medicine.toString());
    }
    public String getMedicineByName(String name){
        Medicine medicine = repo.getMedicineByName(name);

        return (medicine == null ? "Medicine was not found" : medicine.toString());
    }
    public String getMedicineByPrice(int price1, int price2){
        Medicine medicine = repo.getMedicineByPrice(price1, price2);
        return (medicine == null ? "Medicine was not found" : medicine.toString());
    }
    public String removeMedicineById(int id) {
        boolean removed = repo.removeMedicineById(id);

        return ( removed ? "Medicine was removed" : "It has trouble");
    }
    public String removeMedicineByName(String name)
    {
        boolean removed = repo.removeMedicineByName(name);

        return ( removed ? "Medicine was removed" : "It has trouble");
    }
    public String getAllMedicines(){
        List <Medicine> medicine= repo.getAllMedicines();


        return medicine.toString();
    }
    public String removeMedicineByExpirationData(String expiration_data) {
        boolean removed = repo.removeMedicineByExpirationData(expiration_data);

        return ( removed ? "Medicine was removed" : "It has trouble");
    }
}
