//饿汉式单例模式（在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快）
public class HungarySingleton
{
	private HungarySingleton(){
	}

	private static HungarySingleton instance=new HungarySingleton();
	//公开访问点getInstance-----不需要同步
	public static HungarySingleton getInstance(){
		return instance;
	}
}