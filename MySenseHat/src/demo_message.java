
public class demo_message {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		int [] rgb=new int[]{123,222,45};
		sh.show_message("my Cyber Message",rgb);
	}



	public static void print(String str) {
		System.out.println(str);
	}
	
}
