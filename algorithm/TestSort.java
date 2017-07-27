public class TestSort
{
	public static void main(String[] args){
		//int i = 0;
		int a[]={5,8,2,4,1,6,3,0,7,9};
		//int a[]={ 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		int len=a.length;
		//selectSort(a);
		//insertSort(a);
		//bubbleSort(a);
		//MergeSort(a,0,len-1);
		//quickSort(a);
		//shellSort(a);
		heapSort(a);
		for(int i=0;i<len;i++){
			System.out.print(a[i]+" ");
		}

	}
//ѡ������
	public static void selectSort(int[] a){
		//int i;
		int j;
		int temp=0;//��¼��Сֵ��ֵ�������Ƚ�
		int flag=0;//��¼��Сֵ���±�
		int n=a.length;
		for(int i=0;i<n;i++){
			temp=a[i];
			flag=i;
			for(j=i+1;j<n;j++){//һ�˱Ƚ�
				if(a[j]<temp){
					temp=a[j];
					flag=j;
				}
			}
			//�������Сֵ����
			if(flag!=i){
				a[flag]=a[i];
				a[i]=temp;

			}
		}
	}
	//��������
	public static void insertSort(int[] a){
		if(a!=null){
			for(int i=1;i<a.length;i++){
				int temp=a[i],j=i;
				//a[i]�Ǵ��������
				if(a[j-1]>temp){//���һ���������ģ�������С��������ˣ��Ͳ��ñ���
					while(j>=1&&a[j-1]>temp){//���ѭ�����ҵ���tempС���±�j
						//a[j]�����ƶ���Ϊ�˼�������Ѱ�ұ�temp��С����
						a[j]=a[j-1];
						j--;
					}
				}
				//�������
				a[j]=temp;
			}
		}
	}

	//ð������
	public static void bubbleSort(int a[]){
		for(int i=a.length-1;i>0;i--){
			int j=0;
			int temp;
			while(j<i){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
				j++;
			}
		}
	}

	//�鲢����:��·�鲢�����ʱ�临�Ӷ���O(nlogn)
	public static void MergeSort(int a[],int b,int e){//begin end
		if(b<e){
			int m = (b+e)/2;//���е��±�
			MergeSort(a,b,m);//�е�������ߵ�
			MergeSort(a,m+1,e);
			Merge(a,b,m,e);
		}
	}
	public static void Merge(int a[],int b,int m,int e){
		int i,j,k;
		int ll=m-b+1;//ll��left length
		int rl=e-m;//rl��right length
		int L[]=new int[ll];
		int R[]=new int[rl];
		//��ʼ����������
		for(i=b,j=0;j<ll;i++,j++)
			L[j]=a[i];
		for(i=m+1,j=0;j<rl;i++,j++)
			R[j]=a[i];
		//ѭ���ϲ���������
		for(i=0,j=0,k=b;i<ll&&j<rl;k++){
			//����������Ԫ�ش����ұߵ�
			if(L[i]>R[j]){
				a[k]=L[i];
				i++;
			}else{
				a[k]=R[j];
				j++;
			}
		}
		//��û�бȽ����Ԫ�طŽ�������
		while(i<ll){
			a[k]=L[i];
			i++;
			k++;
		}
		while(j<rl){
			a[k]=R[j];
			j++;
			k++;
		}
	}


	//�������򣺷ֶ���֮
	public static void quickSort(int a[]){
		int len=a.length;
		quick(a,0,len-1);
	}

	public static void quick(int a[],int low, int high){
		int i=low;//�ں���ĵݹ������Ҫ�õ���������Ҫ�ݴ�low��high
		int j=high;
		//���low=high��֤�����������ֻ��һ��Ԫ�أ�����ִ�е�����ĵݹ���⣬ִ����low>high��
		if(low>high)
			return;
		//����һ������low����ɨ�裬high����ɨ�裬һ��������ʱ:��ߵ�������������<a[low]<�ұߵ�������������
		int temp=a[low];
		while(low<high){
			while(low<high&&a[high]>temp)
				high--;//����ɨ�裬�ҵ���tempС���� 
			//�ҵ���tempС������
			if(low<high)//����ֹͣѭ����ԭ���������low>high�Ļ�����a[high]<temp
				a[low]=a[high];
			while(low<high&&a[low]<temp)
				low++;//����ɨ�裬�ҵ���temp�����
			if(low<high)
				a[high]=a[low];
		}
		//һ���������low=high,Ҳ����������λ��
		a[low]=temp;
		//�ݹ����
		quick(a,i,low-1);
		quick(a,low+1,j);
	}


	//ϣ������Ҳ�С���С��������
	//����������
	public static void shellSort(int array[]){
		int len=array.length;
		int i,j;
		int h;
		int temp;
		for(h=len/2;h>0;h=h/2){//hΪ����
			for(i=h;i<len;i++){//
				temp=array[i];
				for(j=i-h;j>=0;j-=h){
					System.out.print("j="+j+" ");
					System.out.print("h="+h+" ");
					System.out.print("i="+i+" ");
					if(temp<array[j]){
						array[j+h]=array[j];
					}else{
						System.out.print("break��");
						for(int k=0;k<len;k++){
							System.out.print(array[k]+" ");
						}
						break;
					}
					System.out.print("���飺");
					for(int k=0;k<len;k++){
						System.out.print(array[k]+" ");
					}
					System.out.print("j-=h="+(j-h));
				}
				System.out.println();
				System.out.println("-------------");
				array[j+h]=temp;
			}
		}
	}

	//������
	private static void heapSort(int[] arr) {
		int len=arr.length;
        for(int i = len/2 - 1; i >=0; i --){ //�ѹ���     
            heapAdjust(arr,i,len);//i��ʾ���һ�����ӽڵ�ĸ��ڵ㣬��Ϊֻ�У�len/2-1��~0�����ӽڵ�
        }
		
		/*len--;
        while (len >0){
            swap(arr,0,len);    //���Ѷ�Ԫ����β�ڵ㽻���󣬳��ȼ�1��βԪ�����
            heapAdjust(arr,0,len);    //�ٴζԶѽ��е���,��Ϊ֮ǰ�Ǵ󶥶ѣ�ֻ���˶Ѷ�������ֱ�Ӷ�λ���Ѷ�0���λ��
			len--;
        } */
		for (int i = len - 1; i > 0; i--) {   
            swap(arr, 0, i); // ���Ѷ���¼�͵�ǰδ�����������е����һ����¼����  
            heapAdjust(arr, 0, i); // ����֮����Ҫ���¼����Ƿ���ϴ󶥶ѣ���������Ҫ����  
        } 
    }
	//�����󶥶�
	//���������飬���ڵ���±꣬�������һ��Ԫ�ص��±꣩
	public static  void heapAdjust(int[] arr,int i,int len){
		int maxChild;
		int father;
		//û���ҽڵ����ʲô�����father��һ���³��Ľڵ㣬�ҵ��ʺ�father��λ�ã����룬�൱��֮ǰ�����temp
		for(father=arr[i]; 2*i+1<len; i=maxChild){//i=maxChild:��ʾ�ڶѵ��������в��Ͻ��³���Ԫ�ظ�Ϊ���ڵ㣬������һ�εĵ�����2*i+1��ʾ������
			maxChild=2*i+1;
			//���left�������һ���ڵ�,�������ҽڵ㣬�Ƚ����ҽڵ�Ĵ�С
			if(maxChild != len-1 && arr[maxChild] < arr[maxChild + 1]){
				maxChild++;//����ҽڵ��
			}
			if(father<arr[maxChild]){//
				arr[i]=arr[maxChild];
			}else{
				break;//�󶥶ѽṹû�б��ƻ�������Ҫ����
			}
		}
		arr[i]=father;
	}
    public static  void swap(int[] arr,int i,int j){//����
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
    }
}