//导致死锁的一个例子
public class DeadLock implements Runnable
{
	public boolean flag;
	public static Object o1=new Object();
	public static Object o2=new Object();

	public DeadLock(boolean flag){
		this.flag=flag;
	}

	//编译器可以给你验证@Override下面的方法名是否是你父类中所有的,如果没有则报错，比如你如果没写@Override而你下面的方法名又写错了,这时你的编译器是可以通过的(它以为这个方法是你的子类中自己增加的方法)。
	@Override
	public void run(){
		if(this.flag){//true是对象o1
			synchronized(o1){
				System.out.println("o1:锁定o1，准备申请o2资源");
				try{
					Thread.sleep(1000);//在第一个线程锁住o1对象时睡眠1秒，那么这一秒内是线程占着o1
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("o1:锁定o1和o2,申请到了o1和o2资源");
				}
			}
		}else{//false是对象o2
			synchronized(o2){
				System.out.println("o2:锁定o2,准备申请o1资源");
				try{
					Thread.sleep(1000);//线程o2锁住o2，那么前0.1秒内是o2占着o2，在0.1秒后，线程2请求o1而此时o1被线程1占着

  //所以o2等待o1的结果。1秒后，线程请求o2，而o2被线程2占着，那么线程1又要等待线程2的结果，于是他们互相等待就产生

  //死锁了
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("o2:锁定o1和o2,申请到了o1和o2资源");
				}
			}
		}
	}
}