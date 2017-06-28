package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
	// 这里写成null 可以节约系统资源
	private static Configuration configuration =null;
	private static SessionFactory sessionFactory =null;
	static{
		configuration = new Configuration().configure();;
		sessionFactory = configuration.buildSessionFactory();
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
