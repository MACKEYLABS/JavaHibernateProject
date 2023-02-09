import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ThingsList {
  private List<ThingsEntity> things = new ArrayList<>();
  private SessionFactory sessionFactory;

  public ThingsList() {
    Configuration configuration = new Configuration().configure();
    sessionFactory = configuration.buildSessionFactory();
  }

  public int getListSize() {
    return things.size();
  }

  public void add(String item) {
	  ThingsEntity newThing = new ThingsEntity();
	  newThing.setItem(item);
	  try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(newThing);
	    transaction.commit();
	  }
	}

	public void delete(int id) {
	  try (Session session = sessionFactory.openSession()) {
	    Transaction tx = null;
	    try {
	      tx = session.beginTransaction();
	      ThingsEntity thing = (ThingsEntity) session.get(ThingsEntity.class, id);
	      session.delete(thing);
	      tx.commit();
	    } catch (HibernateException e) {
	      if (tx!=null) tx.rollback();
	      e.printStackTrace();
	    }
	  }
	}

	public void list() {
	  try (Session session = sessionFactory.openSession()) {
	    things = session.createQuery("from ThingsEntity", ThingsEntity.class).list();
	    for (ThingsEntity thing : things) {
	      System.out.println(thing.getId() + " " + thing.getItem());
	    }
	  }
	}
}