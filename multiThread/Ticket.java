public class Ticket implements Runnable
{
	private int tick = 100;//100��Ʊ

	Object o = new Object();//�� ����

	public void run(){
		while(true){
			synchronized(o){//ͬ������飬�����ȫ����
				if(tick>0){
					/*try{
						Thread.sleep(10);
					}catch(Exception e){
						e.printStackTrace();
						//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
					}*/
					System.out.println(Thread.currentThread().getName()+" sale: ��"+ tick-- +"��");
				}else{
					System.out.println(Thread.currentThread().getName()+" Ʊ�Ѿ������");
					break;
				}
			}
		}
	}
}