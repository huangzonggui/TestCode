public class TicketDemo{
	public static void main(String[] args){
		Ticket t = new Ticket();//t�����̣߳���Ϊ��Thread���޹�

		Thread t1 = new Thread(t);//����һ���̣߳�����Runnable���׶��󴫵ݸ�Thread���캯��
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//�ĸ��߳���һֱ��Ʊ
		System.out.println("------main-------");

	}
}