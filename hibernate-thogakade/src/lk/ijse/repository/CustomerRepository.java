package lk.ijse.repository;

import javafx.scene.control.Alert;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {

    private Session session;

    public CustomerRepository(){
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            return customerId;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return -1;
        }finally {
            session.close();
        }
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    public Customer getCustomer(int id){
        Transaction transaction = session.beginTransaction();
        Customer customer = null;
        try {
            customer = session.get(Customer.class, id);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }finally {
            session.close();
        }

        return customer;
    }

    public List<Customer> getAllCustomer(){
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = null;

        try {
            customerList = session.createSQLQuery("SELECT * FROM customer").addEntity(Customer.class).list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }
        return customerList;
    }

    public int getCustomerId(){
        Transaction transaction = session.beginTransaction();
        List<Integer> id = null;

        try {
            id = session.createSQLQuery("SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1").list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }

        if(!id.isEmpty())
            return id.get(0);
        else
            return 0;
    }

    public List<Integer> getCustIDList(){
        Transaction transaction = session.beginTransaction();
        List<Integer> id = null;

        try {
            id = session.createSQLQuery("SELECT customer_id FROM customer ").list();
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }finally {
            session.close();
        }

        return id;
    }
}
