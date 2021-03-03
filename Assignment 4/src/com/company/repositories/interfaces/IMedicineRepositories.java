package com.company.repositories.interfaces;

import com.company.entities.Medicine;

import java.util.List;

public interface IMedicineRepositories {
    boolean createMedicine(Medicine medicine);
    Medicine getMedicine(int id);
    Medicine getMedicineByName(String name);
    boolean removeMedicineById(int id);
    Medicine getMedicineByPrice(int price1, int price2);
    List <Medicine> getAllMedicines();
    boolean removeMedicineByName(String name);
    Medicine getMedicineByExpirationData(String expiration_data);
    boolean removeMedicineByExpirationData(String expiration_data);
}
