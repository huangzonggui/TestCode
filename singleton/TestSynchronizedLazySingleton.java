public class TestSynchronizedLazySingleton
{
	public static void main(String[] args){
		InitThread t1 = new InitThread();
		InitThread t2 = new InitThread();
		t1.start();
		t2.start();
	}
}

//ͨ���̳�Thread���������µ��߳�
class InitThread extends Thread
{
	public void run(){
		System.out.print(Thread.currentThread().getName()+"��");
		//System.out.println(Thread.currentThread().getName().equals("Thread-0"));
		if(Thread.currentThread().getName().equals("Thread-0")){//���ﲻ����==,��Ϊ==�ǱȽ������������͵����ݻ��������ñ�ĵ�ַ�Ƿ���ȣ�����������������������ĵ�ַ���ȣ�����ֻ����equals
			SynchronizedLazySingleton instance = SynchronizedLazySingleton.getInstance();
			System.out.println(instance.name);			
		}else{
			SynchronizedLazySingleton2 instance2 = SynchronizedLazySingleton2.getInstance();
			System.out.println(instance2.name);
		}
	}
}