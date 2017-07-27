//懒汉模式（类加载时不初始化）
public class LazySingleton
{
	public static String name="";
	//1.私有化构造函数
	private LazySingleton(){
		this.name="zhangsan";
	}
	//2.声明类的唯一实例，使用private static修饰
	private static LazySingleton instance;
	//3.公开访问点getInstance-----需要同步
	public static synchronized LazySingleton getInstance(){
		if(instance==null){
			instance=new LazySingleton();
		}
		return instance;
	}			
}