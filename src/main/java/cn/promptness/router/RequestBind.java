package cn.promptness.router;

import javax.servlet.http.HttpServletRequest;

/**
 * 绑定request对象到当前线程中
 * 
 * @author Lynn
 *
 */
public class RequestBind {
	//静态保证threadLocal对象是单例的
	private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

	public static void bindRequest(HttpServletRequest request) {
		threadLocal.set(request);
	}

	public static void removeRequest() {
		threadLocal.remove();
	}

	public static HttpServletRequest getRequest() {
		return threadLocal.get();
	}

}
