package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
	// ����д��null ���Խ�Լϵͳ��Դ
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
