//2．将"2006-05-01 12:24:48"这个字符串表示的时间转换成为 --> java.util.Date对象，并返回.
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class date
{
	public static void main(String[] args){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
		String strdate = "2011年02月30日 ";
		try{
			//parse()方法功能在于将字符串转化为时间对象，字符串表示时间的格式必须与SimpleDateFormat定义的格式一致。
			Date date = sf.parse(strdate);
			System.out.println(date);
		}catch (ParseException e){
			e.printStackTrace();
		}
	}
}