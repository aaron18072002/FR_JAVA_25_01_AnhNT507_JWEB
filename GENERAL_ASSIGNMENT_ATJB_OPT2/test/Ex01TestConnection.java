import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fa.training.hibernate.HibernateUtil;

public class Ex01TestConnection {

	public static void main(String[] args) {
		
		System.out.println("Testing HibernateUtil...");

        // Lấy SessionFactory từ HibernateUtil
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        if (sessionFactory == null) {
            System.err.println("❌ SessionFactory is NULL! Check configuration.");
            return;
        }
        System.out.println("✅ SessionFactory created successfully!");

        // Mở một Session thử nghiệm
        try (Session session = sessionFactory.openSession()) {
            if (session != null && session.isConnected()) {
                System.out.println("✅ Hibernate Session opened successfully!");
            } else {
                System.err.println("❌ Failed to open Hibernate Session!");
            }
        } catch (Exception e) {
            System.err.println("❌ Error while opening Session: " + e.getMessage());
        }

        // Đóng Hibernate
        HibernateUtil.shutdown();
        System.out.println("✅ Hibernate shutdown completed!");
		
	}
	
}
