#include <stdio.h>
int main()
{
	int a[3][4]={{1,2,3,4},{11,22,33,44},{111,222,333,444},};
	for(int i=0;i<3;i++){
		for(int j=0;j<4;j++){
			printf("a[%d][%d]=%d\t",i,j,*(*(a+i)+j));	
		}
		printf("\n");
	}
	printf("a[%d][%d]=%d\t",5,1,*(*(a+5)+1));//越界但是可以编译通过，输出一个错误的数
	return 0;
}