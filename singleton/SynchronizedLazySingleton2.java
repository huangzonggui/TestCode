//����ʽ����������
public class SynchronizedLazySingleton2{

	public static String name="";
	private SynchronizedLazySingleton2(){
		this.name="lisi2";
	}

	private static SynchronizedLazySingleton2 instance;

	public static synchronized SynchronizedLazySingleton2 getInstance(){
		Object o=new Object();
		if(instance==null){
			//synchronized(o){//����������������ͬ����ķ����Ϳ��Ա�������
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