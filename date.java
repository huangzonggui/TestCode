//2����"2006-05-01 12:24:48"����ַ�����ʾ��ʱ��ת����Ϊ --> java.util.Date���󣬲�����.
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
public class date
{
	public static void main(String[] args){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��");
		String strdate = "2011��02��30�� ";
		try{
			//parse()�����������ڽ��ַ���ת��Ϊʱ������ַ�����ʾʱ��ĸ�ʽ������SimpleDateFormat����ĸ�ʽһ�¡�
			Date date = sf.parse(strdate);
			System.out.println(date);
		}catch (ParseException e){
			e.printStackTrace();
		}
	}
}