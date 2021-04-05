import java.util.Random;

public class RunGC {
	public static void main(String[] args) {
		Runtime.getRuntime().gc();
		System.gc();
	}
}
