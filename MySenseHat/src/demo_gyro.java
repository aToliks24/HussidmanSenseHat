
public class demo_gyro {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		for (int i=0;i<10;i++)
			print("{X: "+sh.get_gyro()[0] + " Y: "+sh.get_gyro()[1] +"  Z: "+sh.get_gyro()[2] +"}");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
