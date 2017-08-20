package cn.promptness.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.promptness.pojo.Image;
import cn.promptness.router.RouteKey;
import cn.promptness.service.ImageService;

public class TestImage {

	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void method() {
		ImageService imageService = applicationContext.getBean(ImageService.class);
		
		//第一次
		List<Image> defaultList = imageService.queryAll();
		defaultList.forEach(System.out::println);
		
		//第二次
		RouteKey.bindKey("LOCAL");
		List<Image> list = imageService.queryAll();
		list.forEach(System.out::println);
		
		//第三次
		List<Image> defaultList2 = imageService.queryAll();
		defaultList2.forEach(System.out::println);
	}

}
