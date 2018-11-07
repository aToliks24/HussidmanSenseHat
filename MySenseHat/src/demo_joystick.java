
public class demo_joystick {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		long t1=System.currentTimeMillis()/1000;
		for(int i=0;i<5;) {
			long t2=System.currentTimeMillis()/1000-t1;
			int dir =sh.get_last_stick_action();
			if (dir!=-1 ) {
				print(sh.get_last_stick_action()+"");
				i++;
				}
			if (t2>30)
				break;
			}
		
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
