package dao.impls;

import dao.interfaces.IRepository;
import entities.Products;
import helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Repository implements IRepository<Products> {

    @Override
    public ArrayList<Products> all() {
        ArrayList<Products> pr = new ArrayList<>();
        try {
            String sql_txt = "SELECT * FROM products";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Float price = rs.getFloat("price");
                Products p = new Products(id,name,price);
                pr.add(p);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return pr;
    }

    @Override
    public boolean create(Products products) {
        return false;
    }

    @Override
    public boolean update(Products products) {
        return false;
    }

    @Override
    public boolean delete(Products products) {
        return false;
    }

    @Override
    public Products findOne(Integer id){return null;}

    @Override
    public Products findPrice(Integer id) {
        try{
            String sql_txt = "SELECT price FROM products WHERE name = ?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt, arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                return new Products(Id, name, price);

            }
        } catch (Exception e) {

        }
        return  null;
    }
}
