
public class demo_compass {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		for(int i=0;i<10;i++)
			print(sh.get_compass()+"");
	}

	public static void print(String str) {
		System.out.println(str);
	}
	
}
