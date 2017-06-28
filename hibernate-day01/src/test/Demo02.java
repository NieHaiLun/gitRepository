package test;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import entity.User;
import utils.HibernateUtils;

public class Demo02 {
	// �������
	// @Test
	public void add() {
		// ����hibernate���������ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
		// ����SessionFactory����
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// ���Session
		Session session = sessionFactory.openSession();
		// ��������
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setPassword("���");
		u.setAddress("������");
		u.setUsername("κ����");
		Serializable save = session.save(u);
		// �ύ����
		tx.commit();
		// �ر�����
		session.close();
		sessionFactory.close();
	}

	// ����id��ѯ
	// @Test
	public void getUser() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// ���Session
		Session session = sessionFactory.openSession();
		// ��������
		Transaction tx = session.beginTransaction();
		// ����id��ѯ
		User u = (User) session.get(User.class, 1);
		System.out.println(u.getUsername());
		tx.commit();
		// �ر�����
		session.close();
		sessionFactory.close();
	}
	// �޸�����
	// @Test
	public void udateUser(){
		Session session = HibernateUtils.openSession();
		// ��������
		Transaction tx = session.beginTransaction();
		// ����id��ѯ
		User u = (User) session.get(User.class, 1);
		u.setUsername("С����");
		tx.commit();
		// �ر�����
		session.close();
	}
	// ɾ��
	@Test
	public void deleteUser(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User u = (User) session.get(User.class, 2);
			session.delete(u);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
