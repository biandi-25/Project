package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicine;
import com.company.repositories.interfaces.IMedicineRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedicineRepositories implements IMedicineRepositories {
    private final IDB db;

    public MedicineRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createMedicine(Medicine medicine){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO medicines(name,price,expiration_data,manufacturer) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, medicine.getName());
            st.setInt(2, medicine.getPrice());
            st.setString(3, medicine.getExpiration_data());
            st.setString(4, medicine.getManufacturer());

            st.execute();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Medicine getMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            var sql = "SELECT id,name, price, expiration_data, manufacturer FROM medicines WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Medicine medicine=new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration_data"),
                        rs.getString("manufacturer"));
                return medicine;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = ("SELECT id, name, price, expiration_data, manufacturer FROM medicines");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List <Medicine> medicines = new LinkedList<>();
            while (rs.next()){
                Medicine medicine = new Medicine(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getString("expiration_data"),
                rs.getString("manufacturer"));
                medicines.add(medicine);
            }
            return medicines;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
        }
    @Override
        public Medicine getMedicineByName(String name){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, price, expiration_data, manufacturer FROM medicines WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Medicine medicine=new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration_data"),
                        rs.getString("manufacturer"));
                return medicine;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean removeMedicineById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement( "DELETE FROM medicines WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
        }

    @Override
    public Medicine getMedicineByPrice(int price1, int price2) {
            Connection con = null;
            try {
                con = db.getConnection();
                PreparedStatement st = con.prepareStatement("SELECT id,name, price," +
                        " expiration_data, manufacturer FROM medicines WHERE price BETWEEN'" + price1 + "'AND'" + price2+ "'");

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Medicine medicine = new Medicine(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getString("expiration_data"),
                            rs.getString("manufacturer"));
                    return medicine;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
        }
    @Override
    public Medicine getMedicineByExpirationData(String expiration_data) {
        getMedicineByExpirationData(expiration_data);
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, data, manufacturer FROM medicines WHERE expiration_data =? AND price = (SELECT MAX(price) FROM medicine)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, expiration_data);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("data"),
                        rs.getString("manufacturer"));
                return medicine;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean removeMedicineByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement( "DELETE FROM medicines WHERE name = ?");
            preparedStatement.setString(1,name);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }
    @Override
    public boolean removeMedicineByExpirationData(String expiration_data) {
        Connection con = null;
        try {
            con = db.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement( "DELETE FROM medicines WHERE expiration_data = ?");
            preparedStatement.setString(1,expiration_data);
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }
    }

