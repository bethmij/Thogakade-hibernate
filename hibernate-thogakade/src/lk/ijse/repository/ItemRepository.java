package lk.ijse.repository;

import javafx.scene.control.Alert;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemRepository {

        private Session session;

        public ItemRepository(){
            session = SessionFactoryConfig.getInstance().getSession();
        }

        public int saveItem(Item item){
            Transaction transaction = session.beginTransaction();
            try {
                int itemId = (int) session.save(item);
                transaction.commit();
                return itemId;

            }catch (Exception e){
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                return -1;
            }finally {
                session.close();
            }
        }

        public boolean updateItem(Item item){
            Transaction transaction = session.beginTransaction();
            try {
                session.update(item);
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

        public boolean deleteItem(Item item){
            Transaction transaction = session.beginTransaction();
            try {
                session.delete(item);
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

        public Item getItem(int id){
            Transaction transaction = session.beginTransaction();
            Item item = null;

            try {
                item = session.get(Item.class, id);
                transaction.commit();

            }catch (Exception e){
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }finally {
                session.close();
            }

            return item;
        }

        public List<Item> getAllItem(){
            Transaction transaction = session.beginTransaction();
            List<Item> itemList = null;

            try {
                itemList = session.createSQLQuery("SELECT * FROM item").addEntity(Item.class).list();
                transaction.commit();

            }catch (Exception e){
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

            }finally {
                session.close();
            }
            return itemList;
        }

        public int getItemCode(){
            Transaction transaction = session.beginTransaction();
            List<Integer> id = null;

            try {
                id = session.createSQLQuery("SELECT item_code FROM item ORDER BY item_code DESC LIMIT 1").list();
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

    public List<Integer> getItemList(){
        Transaction transaction = session.beginTransaction();
        List<Integer> id = null;

        try {
            id = session.createSQLQuery("SELECT item_code FROM item ").list();
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
