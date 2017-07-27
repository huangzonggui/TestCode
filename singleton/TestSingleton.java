public class TestSingleton
{
	public static void main(String[] args){
		LazySingleton s1=LazySingleton.getInstance();
		LazySingleton s2=LazySingleton.getInstance();
		if(s1==s2){
			System.out.println("饿汉模式：s1==s2");
			System.out.println(s1.name);
		}else{
			System.out.println("饿汉模式：s1!=s2");
		}

		HungarySingleton s3=HungarySingleton.getInstance();
		HungarySingleton s4=HungarySingleton.getInstance();
		if(s3==s4){
			System.out.println("饿汉模式：s3==s4");
		}else{
			System.out.println("饿汉模式：s3!=s4");
		}
		//单例模式的应用：配置文件、工具类、线程池、缓存、日志对象	
		//饿汉模式（类加载时就已经实例化了）的特点是加载类时比较慢，但运行时获取对象的速度比较快，线程安全
		//懒汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢，线程不安全 同步synchronized
	}
}