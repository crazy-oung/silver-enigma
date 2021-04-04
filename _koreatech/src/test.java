import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int[] K = new int[20];
		while( i< 100) {
			System.out.println((int) ((Math.random() * (K.length - 5)) + 5));
			i++;
		}
	}

}
