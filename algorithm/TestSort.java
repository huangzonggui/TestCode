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
//选择排序
	public static void selectSort(int[] a){
		//int i;
		int j;
		int temp=0;//记录最小值的值，用来比较
		int flag=0;//记录最小值的下标
		int n=a.length;
		for(int i=0;i<n;i++){
			temp=a[i];
			flag=i;
			for(j=i+1;j<n;j++){//一趟比较
				if(a[j]<temp){
					temp=a[j];
					flag=j;
				}
			}
			//如果有最小值，换
			if(flag!=i){
				a[flag]=a[i];
				a[i]=temp;

			}
		}
	}
	//插入排序
	public static void insertSort(int[] a){
		if(a!=null){
			for(int i=1;i<a.length;i++){
				int temp=a[i],j=i;
				//a[i]是待插入的数
				if(a[j-1]>temp){//最后一个数（最大的）都比你小，你最大了，就不用比了
					while(j>=1&&a[j-1]>temp){//这个循环是找到比temp小的下标j
						//a[j]向左移动，为了继续向左寻找比temp更小的数
						a[j]=a[j-1];
						j--;
					}
				}
				//插入操作
				a[j]=temp;
			}
		}
	}

	//冒泡排序
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

	//归并排序:二路归并排序的时间复杂度是O(nlogn)
	public static void MergeSort(int a[],int b,int e){//begin end
		if(b<e){
			int m = (b+e)/2;//求中点下标
			MergeSort(a,b,m);//中点属于左边的
			MergeSort(a,m+1,e);
			Merge(a,b,m,e);
		}
	}
	public static void Merge(int a[],int b,int m,int e){
		int i,j,k;
		int ll=m-b+1;//ll：left length
		int rl=e-m;//rl：right length
		int L[]=new int[ll];
		int R[]=new int[rl];
		//初始化左右数组
		for(i=b,j=0;j<ll;i++,j++)
			L[j]=a[i];
		for(i=m+1,j=0;j<rl;i++,j++)
			R[j]=a[i];
		//循环合并两个数组
		for(i=0,j=0,k=b;i<ll&&j<rl;k++){
			//如果左数组的元素大于右边的
			if(L[i]>R[j]){
				a[k]=L[i];
				i++;
			}else{
				a[k]=R[j];
				j++;
			}
		}
		//将没有比较完的元素放进数组中
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


	//快速排序：分而治之
	public static void quickSort(int a[]){
		int len=a.length;
		quick(a,0,len-1);
	}

	public static void quick(int a[],int low, int high){
		int i=low;//在后面的递归求解中要用到，所以需要暂存low和high
		int j=high;
		//如果low=high，证明这个子序列只有一个元素，还会执行到下面的递归求解，执行完low>high了
		if(low>high)
			return;
		//进行一趟排序，low向右扫描，high向左扫描，一趟排序完时:左边的子序列所有数<a[low]<右边的子序列所有数
		int temp=a[low];
		while(low<high){
			while(low<high&&a[high]>temp)
				high--;//向左扫描，找到比temp小的数 
			//找到比temp小的数后
			if(low<high)//上面停止循环的原因如果不是low>high的话就是a[high]<temp
				a[low]=a[high];
			while(low<high&&a[low]<temp)
				low++;//向右扫描，找到比temp大的数
			if(low<high)
				a[high]=a[low];
		}
		//一趟排序完后，low=high,也就是中数的位置
		a[low]=temp;
		//递归求解
		quick(a,i,low-1);
		quick(a,low+1,j);
	}


	//希尔排序：也叫“缩小增量排序”
	//？？？？？
	public static void shellSort(int array[]){
		int len=array.length;
		int i,j;
		int h;
		int temp;
		for(h=len/2;h>0;h=h/2){//h为增量
			for(i=h;i<len;i++){//
				temp=array[i];
				for(j=i-h;j>=0;j-=h){
					System.out.print("j="+j+" ");
					System.out.print("h="+h+" ");
					System.out.print("i="+i+" ");
					if(temp<array[j]){
						array[j+h]=array[j];
					}else{
						System.out.print("break：");
						for(int k=0;k<len;k++){
							System.out.print(array[k]+" ");
						}
						break;
					}
					System.out.print("数组：");
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

	//堆排序
	private static void heapSort(int[] arr) {
		int len=arr.length;
        for(int i = len/2 - 1; i >=0; i --){ //堆构造     
            heapAdjust(arr,i,len);//i表示最后一个有子节点的父节点，因为只有（len/2-1）~0才有子节点
        }
		
		/*len--;
        while (len >0){
            swap(arr,0,len);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(arr,0,len);    //再次对堆进行调整,因为之前是大顶堆，只改了堆顶，所以直接定位到堆顶0这个位置
			len--;
        } */
		for (int i = len - 1; i > 0; i--) {   
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换  
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整  
        } 
    }
	//构建大顶堆
	//参数（数组，父节点的下标，数组最后一个元素的下标）
	public static  void heapAdjust(int[] arr,int i,int len){
		int maxChild;
		int father;
		//没有右节点的是什么情况，father是一个下沉的节点，找到适合father的位置，插入，相当于之前排序的temp
		for(father=arr[i]; 2*i+1<len; i=maxChild){//i=maxChild:表示在堆调整过程中不断将下沉的元素改为父节点，继续下一次的调整，2*i+1表示有左结点
			maxChild=2*i+1;
			//如果left不是最后一个节点,就是有右节点，比较左右节点的大小
			if(maxChild != len-1 && arr[maxChild] < arr[maxChild + 1]){
				maxChild++;//如果右节点大
			}
			if(father<arr[maxChild]){//
				arr[i]=arr[maxChild];
			}else{
				break;//大顶堆结构没有被破坏，不需要调整
			}
		}
		arr[i]=father;
	}
    public static  void swap(int[] arr,int i,int j){//交换
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
    }
}