public class TestDeadLock{
	public static void main(String[] args){
		Thread t1 = new Thread(new DeadLock(true));
		Thread t2 = new Thread(new DeadLock(false));
		t1.start();
		t2.start();
	}
}