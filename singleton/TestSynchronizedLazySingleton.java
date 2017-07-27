public class TestSynchronizedLazySingleton
{
	public static void main(String[] args){
		InitThread t1 = new InitThread();
		InitThread t2 = new InitThread();
		t1.start();
		t2.start();
	}
}

//通过继承Thread类来开启新的线程
class InitThread extends Thread
{
	public void run(){
		System.out.print(Thread.currentThread().getName()+"：");
		//System.out.println(Thread.currentThread().getName().equals("Thread-0"));
		if(Thread.currentThread().getName().equals("Thread-0")){//这里不能用==,因为==是比较两个基本类型的数据或两个引用变的地址是否相等，这里是两个对象，两个对象的地址不等，所以只能用equals
			SynchronizedLazySingleton instance = SynchronizedLazySingleton.getInstance();
			System.out.println(instance.name);			
		}else{
			SynchronizedLazySingleton2 instance2 = SynchronizedLazySingleton2.getInstance();
			System.out.println(instance2.name);
		}
	}
}