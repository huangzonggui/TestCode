//在外面的循环语句前定义一个标号，然后在里层循环体的代码中使用带有标号的break 语句，即可跳出外层循环（如果不定义一个标号就break只跳出一重循环） 
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