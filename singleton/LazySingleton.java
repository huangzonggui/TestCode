//����ģʽ�������ʱ����ʼ����
public class LazySingleton
{
	public static String name="";
	//1.˽�л����캯��
	private LazySingleton(){
		this.name="zhangsan";
	}
	//2.�������Ψһʵ����ʹ��private static����
	private static LazySingleton instance;
	//3.�������ʵ�getInstance-----��Ҫͬ��
	public static synchronized LazySingleton getInstance(){
		if(instance==null){
			instance=new LazySingleton();
		}
		return instance;
	}			
}