public class TestArray
{
	public static void main(String[] args){
		int[] array={1,-2,4,8,-4,7,-1,-5};
		System.out.println(maxSubArray(array));
	}

	public static int maxSubArray(int a[]){
		int n=a.length;
		int nAll=a[0];
		int nEnd=a[0];
		for(int i=1;i<n;++i){//i++Ҳ��û������ģ�++iЧ�ʺã���һ�ζ���Ĵ�����ʵ���ϱ������Ż���һ�� 

			System.out.println(i);
			nEnd=max(nEnd+a[i],a[i]);
			nAll=max(nEnd,nAll);
		}
		return nAll;
	}
	public static int max(int m,int n){
		return m>n?m:n;	
	}
}

//��չ��
//++iģ��:i=i+1;	return i;
//i++ģ��:int temp=i;	i=temp+1;	return temp;
