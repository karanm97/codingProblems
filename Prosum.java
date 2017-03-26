import java.io.*;
import java.util.*;

class Prosum {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("d:\\programming\\case.txt"));
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		int[] temp = null;
		while(testcases-- > 0) {
			int elementCount = sc.nextInt();
			for(int i = 0; i< elementCount; i++) {
				temp[elementCount] = sc.nextInt();
			}
			int counter = 0;
			for(int i = 0; i < temp.length; i++) {
				if(temp[i]*temp[i+1] > temp[i]+temp[i+1])
					counter++;
			}
			System.out.println(counter);
		}
	}
}