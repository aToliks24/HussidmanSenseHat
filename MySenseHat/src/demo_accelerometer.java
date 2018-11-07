
public class demo_accelerometer {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		for (int i=0;i<10;i++)
			print("{X: "+sh.get_accelerometer()[0] + " Y: "+sh.get_accelerometer()[1] +"  Z: "+sh.get_accelerometer()[2] +"}");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
