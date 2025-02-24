import org.hibernate.SessionFactory;

import com.coding.connection.DbConnection;

public class Ex01TestConnection {

public static void main(String[] args) {
		
		SessionFactory sessionFactory = DbConnection.getSessionFactory();
		System.out.println("sessionFactory: " + sessionFactory);
		
		// Sử dụng openSession khi trong 1 service/method cần nhiều session/thread
		// để thực thi
		System.out.println("\ns1: " + sessionFactory.openSession());
		System.out.println("s2: " + sessionFactory.openSession());

	}
	
}
