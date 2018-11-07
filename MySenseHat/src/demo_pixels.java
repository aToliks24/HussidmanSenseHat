import java.util.concurrent.TimeUnit;

public class demo_pixels {
	public static void main(String[] args) {
		SenseHat sh = new SenseHat();
		int[] O = { 255, 255, 255 };
		int[] X = { 255, 0, 0 };
		sh.clear();
		int[][] qmark = new int[][] { O, O, O, X, X, O, O, O, 
									  O, O, X, O, O, X, O, O, 
									  O, O, O, O, O, X, O, O, 
									  O, O, O, O, X, O, O, O, 
									  O, O, O, X, O, O, O, O, 
									  O, O, O, X, O, O, O, O, 
									  O, O, O, O, O, O, O, O, 
									  O, O, O, X, O, O, O, O };
		sh.set_pixels(qmark);
		int i = 10;
		while (i-- > 0) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i%2==0)
				sh.flip_h();
			else
				sh.flip_v();
		}
		sh.clear();
	}

	public static void print(String str) {
		System.out.println(str);
	}
}
