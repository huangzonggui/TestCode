public class Ticket implements Runnable
{
	private int tick = 100;//100张票

	Object o = new Object();//锁 对象

	public void run(){
		while(true){
			synchronized(o){//同步代码块，解决安全问题
				if(tick>0){
					/*try{
						Thread.sleep(10);
					}catch(Exception e){
						e.printStackTrace();
						//在命令行打印异常信息在程序中出错的位置及原因。
					}*/
					System.out.println(Thread.currentThread().getName()+" sale: 第"+ tick-- +"张");
				}else{
					System.out.println(Thread.currentThread().getName()+" 票已经买光了");
					break;
				}
			}
		}
	}
}