//����ʽ����������
public class SynchronizedLazySingleton{

	public static String name="";
	private SynchronizedLazySingleton(){
		this.name="lisi";
	}

	private static SynchronizedLazySingleton instance;

	public static synchronized SynchronizedLazySingleton getInstance(){
		Object o=new Object();
		if(instance==null){
			//synchronized(o){//����������������ͬ����ķ����Ϳ��Ա�������
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