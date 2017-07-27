public class TicketDemo{
	public static void main(String[] args){
		Ticket t = new Ticket();//t不是线程，因为与Thread类无关

		Thread t1 = new Thread(t);//创建一个线程，并把Runnable自雷对象传递给Thread构造函数
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//四个线程在一直买票
		System.out.println("------main-------");

	}
}