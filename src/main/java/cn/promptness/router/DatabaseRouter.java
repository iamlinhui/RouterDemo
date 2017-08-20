package cn.promptness.router;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承
 * 
 * @author Lynn
 *
 */
public class DatabaseRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		//1.从当前线程上尝试读取key的信息
		String key = RouteKey.getKey();
		
		//2).将key从当前线程上移除
		RouteKey.removeKey();

		// 3.不论key是否为null，都可以直接返回，因为就算是为null也可以找默认数据源
		return key;
	}
	

}
