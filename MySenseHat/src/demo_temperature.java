
public class demo_temperature {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		print(sh.get_temperature()+"");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
