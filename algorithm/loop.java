//�������ѭ�����ǰ����һ����ţ�Ȼ�������ѭ����Ĵ�����ʹ�ô��б�ŵ�break ��䣬�����������ѭ�������������һ����ž�breakֻ����һ��ѭ���� 
public class loop
{
	public static void main(String[] args){
		loop:
			for(int i=0;i<10;i++){
				System.out.println(i);
				for(int j=0;j<10;j++){
					System.out.println(j);
					if(j==5) break loop;
				}
			}
	}
}