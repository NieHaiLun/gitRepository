package test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import entity.User;

public class Demo {
	@Test
	public void addUser(){
		// 1.����hibernate���������ļ�
		// �̶��ĵ�src����hibernate.cfg.xml�ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
		// 2.����SessionFactory����
		/*
		 * ����SessionFactory������
		 * 1.�Һ����ļ������ݿⲿ��,�������ݿ�
		 * 2.���Ƿ���Ҫhibernate�ﴴ����,
		 * 		�����Ҫ�ﴴ����:����ӳ���ϵ�ѱ���
		 */
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.ʹ��SessionFactory���󴴽�Session����
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction tx = session.beginTransaction();
		// 5.����session����ʵ��crud����
		User user = new User();
		user.setUsername("qe");
		user.setPassword("ninqwe");
		user.setAddress("����");
		session.save(user);
		// 6.�ύ����
		tx.commit();
		// 7.�ر�����
		session.close();
		sessionFactory.close();
	}
}
