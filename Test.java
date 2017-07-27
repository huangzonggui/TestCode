public class Test{
	public static void test(String str){
		str="new";
		System.out.println(str);
	}
	
	public static void main(String[] args){
		/*
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}*/
		String string="old";
		System.out.println(string);
		test(string);
		System.out.println(string);
	}
}