//����ʽ����ģʽ���������ʱ������˳�ʼ������������ؽ���������ȡ������ٶȿ죩
public class HungarySingleton
{
	private HungarySingleton(){
	}

	private static HungarySingleton instance=new HungarySingleton();
	//�������ʵ�getInstance-----����Ҫͬ��
	public static HungarySingleton getInstance(){
		return instance;
	}
}