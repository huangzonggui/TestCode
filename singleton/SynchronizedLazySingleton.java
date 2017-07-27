//懒汉式：死锁程序
public class SynchronizedLazySingleton{

	public static String name="";
	private SynchronizedLazySingleton(){
		this.name="lisi";
	}

	private static SynchronizedLazySingleton instance;

	public static synchronized SynchronizedLazySingleton getInstance(){
		Object o=new Object();
		if(instance==null){
			//synchronized(o){//在这个例子中如果用同步块的方法就可以避免死锁
				instance=new SynchronizedLazySingleton();
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				SynchronizedLazySingleton2 s=SynchronizedLazySingleton2.getInstance();
			//}
		}
		return instance;
	}	
}