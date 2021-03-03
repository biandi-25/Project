package com.company;

import com.company.controllers.MedicineController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.MedicineRepositories;
import com.company.repositories.interfaces.IMedicineRepositories;

public class Main {

    public static void main(String[] args) {
	    IDB db = new PostgresDB();
        IMedicineRepositories repo = new MedicineRepositories(db);
        MedicineController controller = new MedicineController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
