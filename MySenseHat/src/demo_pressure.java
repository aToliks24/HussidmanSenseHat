
public class demo_pressure {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		for (int i=0;i<10;i++)
			print(sh.get_pressure()+"");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
