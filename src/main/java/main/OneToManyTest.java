package main;

import config.HBConfig;
import entity.Cart;
import entity.Item;
import org.hibernate.Session;

public class OneToManyTest {

    public static void main(String[] args) {
        Session session = HBConfig.buildSessionFactory().openSession();


        try {

            session.beginTransaction();
//            Cart cart=(Cart) session.createQuery("FROM Cart where id=1").getSingleResult();
//            for(Item i: cart.getItems()){
//                System.out.println(i);
//            }


            Cart cart = new Cart();
            cart.setCardUser("Kamal Aliyev");
            session.save(cart);

            Item item1 = new Item();
            item1.setCount("1");
            item1.setDescription("White t-shirt");
            item1.setName("T-shirt");
            item1.setCart(cart);
            session.save(item1);

            Item item2 = new Item();
            item2.setCount("2");
            item2.setDescription("Black pant");
            item2.setName("pant");
            item2.setCart(cart);
            session.save(item2);



            session.getTransaction().commit();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            if (null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}