package cn.promptness.router;

/**
 * 绑定获取路由器数据源中的key值到线程中
 * 
 * @author Lynn
 *
 */
public class RouteKey {

	// 设置为静态是为了保证threadLocal对象是单例的
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

	public static void bindKey(String key) {
		threadLocal.set(key);
	}

	public static void removeKey() {
		threadLocal.remove();
	}

	public static String getKey() {
		return threadLocal.get();
	}

}
