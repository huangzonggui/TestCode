//����������һ������
public class DeadLock implements Runnable
{
	public boolean flag;
	public static Object o1=new Object();
	public static Object o2=new Object();

	public DeadLock(boolean flag){
		this.flag=flag;
	}

	//���������Ը�����֤@Override����ķ������Ƿ����㸸�������е�,���û���򱨴����������ûд@Override��������ķ�������д����,��ʱ��ı������ǿ���ͨ����(����Ϊ�������������������Լ����ӵķ���)��
	@Override
	public void run(){
		if(this.flag){//true�Ƕ���o1
			synchronized(o1){
				System.out.println("o1:����o1��׼������o2��Դ");
				try{
					Thread.sleep(1000);//�ڵ�һ���߳���סo1����ʱ˯��1�룬��ô��һ�������߳�ռ��o1
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("o1:����o1��o2,���뵽��o1��o2��Դ");
				}
			}
		}else{//false�Ƕ���o2
			synchronized(o2){
				System.out.println("o2:����o2,׼������o1��Դ");
				try{
					Thread.sleep(1000);//�߳�o2��סo2����ôǰ0.1������o2ռ��o2����0.1����߳�2����o1����ʱo1���߳�1ռ��

  //����o2�ȴ�o1�Ľ����1����߳�����o2����o2���߳�2ռ�ţ���ô�߳�1��Ҫ�ȴ��߳�2�Ľ�����������ǻ���ȴ��Ͳ���

  //������
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("o2:����o1��o2,���뵽��o1��o2��Դ");
				}
			}
		}
	}
}