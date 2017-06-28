package itheima.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo001 {
	@Test
	public void demo01(){
		System.out.println("测试");
	}
	@Before
	public void demo02(){
		System.out.println("之前执行");
	}
	@After
	public void demo03(){
		System.out.println("之后执行");
	}
}
