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
	// 添加数据
	// @Test
	public void add() {
		// 加载hibernate核心配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
		// 创建SessionFactory对象
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 获得Session
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setPassword("你好");
		u.setAddress("北京市");
		u.setUsername("魏凯旋");
		Serializable save = session.save(u);
		// 提交事务
		tx.commit();
		// 关闭连接
		session.close();
		sessionFactory.close();
	}

	// 根据id查询
	// @Test
	public void getUser() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 获得Session
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 根据id查询
		User u = (User) session.get(User.class, 1);
		System.out.println(u.getUsername());
		tx.commit();
		// 关闭连接
		session.close();
		sessionFactory.close();
	}
	// 修改事务
	// @Test
	public void udateUser(){
		Session session = HibernateUtils.openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 根据id查询
		User u = (User) session.get(User.class, 1);
		u.setUsername("小果果");
		tx.commit();
		// 关闭连接
		session.close();
	}
	// 删除
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
