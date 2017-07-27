//懒汉式：死锁程序
public class SynchronizedLazySingleton2{

	public static String name="";
	private SynchronizedLazySingleton2(){
		this.name="lisi2";
	}

	private static SynchronizedLazySingleton2 instance;

	public static synchronized SynchronizedLazySingleton2 getInstance(){
		Object o=new Object();
		if(instance==null){
			//synchronized(o){//在这个例子中如果用同步块的方法就可以避免死锁
				instance=new SynchronizedLazySingleton2();
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				SynchronizedLazySingleton s=SynchronizedLazySingleton.getInstance();
			//}
		}
		return instance;
	}	
}