package dao.impls;

import dao.interfaces.IRepository;
import entities.Products;
import helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductsRepository implements IRepository<Products> {

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
                Integer qty = rs.getInt("quantity");
                Products p = new Products(id,name,price, qty);
                pr.add(p);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return pr;
    }

    @Override
    public Products create(Products products) {
//        try {
//            String sql_txt  = "insert into products(name, author, qty) values(?,?,?)";
//            Connector conn = Connector.getInstance();
//            ArrayList arr = new ArrayList();
//            arr.add(book.getName());
//            arr.add(book.getAuthor());
//            arr.add(book.getQty());
//
//            if (conn.executeAdd(sql_txt,arr)) {
//                return true;
//            }
//        } catch (Exception e){
//
//        }
//
        return new Products();
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

}
