public class TestSingleton
{
	public static void main(String[] args){
		LazySingleton s1=LazySingleton.getInstance();
		LazySingleton s2=LazySingleton.getInstance();
		if(s1==s2){
			System.out.println("����ģʽ��s1==s2");
			System.out.println(s1.name);
		}else{
			System.out.println("����ģʽ��s1!=s2");
		}

		HungarySingleton s3=HungarySingleton.getInstance();
		HungarySingleton s4=HungarySingleton.getInstance();
		if(s3==s4){
			System.out.println("����ģʽ��s3==s4");
		}else{
			System.out.println("����ģʽ��s3!=s4");
		}
		//����ģʽ��Ӧ�ã������ļ��������ࡢ�̳߳ء����桢��־����	
		//����ģʽ�������ʱ���Ѿ�ʵ�����ˣ����ص��Ǽ�����ʱ�Ƚ�����������ʱ��ȡ������ٶȱȽϿ죬�̰߳�ȫ
		//����ģʽ���ص��Ǽ�����ʱ�ȽϿ죬������ʱ��ȡ������ٶȱȽ������̲߳���ȫ ͬ��synchronized
	}
}