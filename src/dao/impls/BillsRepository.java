package dao.impls;

import dao.interfaces.IRepository;
import entities.Bill;
import helper.Connector;

import java.util.ArrayList;

public class BillsRepository implements IRepository<Bill> {
    @Override
    public ArrayList<Bill> all() {
        return null;
    }

    @Override
    public Bill create(Bill bill) {
        Bill b = new Bill();
        try {
            String sql_txt = "insert into bill(datetime, total) values(null, null);";
            Connector conn = Connector.getInstance();
            Integer id = conn.getKeysQuery(sql_txt);
            b = new Bill(id, null, 0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    @Override
    public boolean update(Bill bill) {

        return false;
    }

    @Override
    public boolean delete(Bill bill) {
        return false;
    }

    @Override
    public Bill findOne(Integer id) {
        return null;
    }
}
