//实现字符串的反转
public class reverse
{
	public static void main(String[] args){
		String str="abc123456";
		StringBuilder strb = new StringBuilder(str);
		str = strb.reverse().toString();
		System.out.println(str);
	}
}