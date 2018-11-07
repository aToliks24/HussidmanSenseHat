
public class demo_joystick {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		for(int i=0;i<5;) {
			int dir =sh.get_last_stick_action();
			if (dir!=-1 ) {
				print(dir+"");
				i++;
				}
			else {
				print("No Action");
			}
		}	
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
