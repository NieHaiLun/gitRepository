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
		// 1.加载hibernate核心配置文件
		// 固定的到src下找hibernate.cfg.xml文件
		Configuration cfg = new Configuration();
		cfg.configure();
		// 2.创建SessionFactory对象
		/*
		 * 创建SessionFactory过程中
		 * 1.找核心文件中数据库部分,连接数据库
		 * 2.找是否需要hibernate帮创建表,
		 * 		如果需要帮创建表:根据映射关系把表创建
		 */
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.使用SessionFactory对象创建Session对象
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction tx = session.beginTransaction();
		// 5.调用session方法实现crud操作
		User user = new User();
		user.setUsername("qe");
		user.setPassword("ninqwe");
		user.setAddress("东京");
		session.save(user);
		// 6.提交事务
		tx.commit();
		// 7.关闭连接
		session.close();
		sessionFactory.close();
	}
}
