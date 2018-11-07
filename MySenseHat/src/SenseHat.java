import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SenseHat {
	public SenseHat() {
		this.python_script = String.format("sense.set_imu_config(True, True, True);");
		this.runPython();
	}
	
	String python_imports = "from sense_hat import SenseHat;import time; sense=SenseHat(); ";
	String python_script = "";
	boolean declerative = true;

	public void declerative() {
		this.declerative = true;
	}

	public void imperative() {
		this.declerative = false;
	}

	public void set_rotation(int degree) {
		this.python_script = String.format("sense.set_rotation(%d);", degree);
		this.runPython();
	}

	public void flip_h() {
		this.python_script = "sense.flip_h();";
		this.runPython();

	}

	public void flip_v() {
		this.python_script = "sense.flip_v();";
		this.runPython();
	}

	public void set_pixels(int[][] rgb_pixels) {
		String res = "";
		List<String> lst_px_str = new ArrayList<String>();
		for (int[] px : rgb_pixels)
			lst_px_str.add(Arrays.toString(px));
		res = String.join(",", lst_px_str);
		this.python_script = String.format("sense.set_pixels([%s]);", res);
		this.runPython();
	}

	public void set_pixel(int x, int y, int[] rgb) {
		this.python_script = String.format("sense.set_pixel(%d,%d,%s);", x, y, Arrays.toString(rgb));
		this.runPython();
	}

	public int[] get_pixel(int x, int y) {
		this.python_script = String.format("print(sense.get_pixel(%d,%d));", x, y);
		String ret = this.runPython();
		float[] fres = string_array_to_floats(ret);
		int[] res=new int[fres.length];
		for (int i=0;i<fres.length;i++) {
			res[i]=(int)fres[i];
		}
		return res;
	}



	public void load_image(String image_path) {
		this.python_script = String.format("sense.load_image(%s);", image_path);
		this.runPython();
	}

	public void clear(int[] rgb) {
		this.python_script = String.format("sense.clear(%s);", Arrays.toString(rgb));
		this.runPython();
	}

	public void clear() {
		clear(new int[] { 0, 0, 0 });
	}

	public void show_message(String text_string, int[] rgb) {
		this.python_script = String.format("sense.show_message(text_string='%s',text_colour=%s);", text_string,
				Arrays.toString(rgb));
		this.runPython();
	}

	public void show_letter(String text_string, int[] rgb) {
		this.python_script = String.format("sense.show_letter(s='%s',text_colour=%s);", text_string,
				Arrays.toString(rgb));
		this.runPython();
	}

	public float get_humidity() {
		this.python_script = "print(sense.get_humidity());";
		String ret = this.runPython();
		return Float.valueOf(ret);
	}

	public float get_temperature() {
		this.python_script = "print(sense.get_temperature());";
		String ret = this.runPython();
		return Float.valueOf(ret);
	}

	public float get_compass() {
		this.python_script = "print(sense.get_compass());";
		String ret = this.runPython();
		return Float.valueOf(ret);
	}

	public float get_pressure() {
		this.python_script = "print(max([sense.get_pressure() for x in range(100) ]));";
		String ret = this.runPython();
		return Float.valueOf(ret);
	}
	
	public float[] get_gyro() {
		this.python_script = "gyro_only = sense.get_gyroscope_raw();print(gyro_only).values()";
		String ret = this.runPython();
		float[] res= string_array_to_floats(ret);
		return res;
	}
	
	
	public float[] get_accelerometer() {
		this.python_script = "gyro_only = sense.get_accelerometer_raw();print(gyro_only).values()";
		String ret = this.runPython();
		float[] res= string_array_to_floats(ret);
		return res;
	}
	
	

	public int get_last_stick_action() {
		int res = -1;
		String predefine="import subprocess;from threading import Timer;kill = lambda process: process.kill();fnc=sense.stick.wait_for_event;";
		this.python_script = "sense.show_letter(s='J',text_colour=(123,222,45) ; sense.clear(0,0,0);e=sense.stick.wait_for_event()  ;res= e.direction ;print(res);";
		String ret = this.runPython();
		if (ret.equals("middle"))
			res = 0;
		else if (ret.equals("up"))
			res = 1;
		else if (ret.equals("right"))
			res = 2;
		else if (ret.equals("down"))
			res = 3;
		else if (ret.equals("left"))
			res = 4;
		return res;
	}

	private float[] string_array_to_floats(String ret){
		ret = ret.replaceAll("\\[", "");
		ret = ret.replaceAll("\\]", "");
		ret = ret.replaceAll(" ", "");
		String[] splitted_ret = ret.split(",");
		float[] res=new float[splitted_ret.length];
		for(int i=0;i<splitted_ret.length;i++) {
			res[i]=Float.parseFloat(splitted_ret[i]);
		}
		return res;
	}
	
	private String runPython() {
		String res = "";
		try {
			Runtime rt = Runtime.getRuntime();
			String[] cmdline = { "python", "-c", this.python_imports + this.python_script };
			Process proc = rt.exec(cmdline);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

			String s = null;
			while ((s = stdInput.readLine()) != null) {
				res += s;
			}

			// read any errors from the attempted command
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
