
public class demo_humidity {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		print(sh.get_humidity()+"");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
