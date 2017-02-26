import java.util.Scanner;

class Interval {

	int[] A, B;
	int T, M, N;
	int A_LENGTH, B_ELEMENT, uncommon_sum, common_sum = 0, common, uncommon, temp1, temp2, score;
	int lower_limit, uppper_limit;
	int left_lower, left_upper, right_lower, right_upper;	
	Scanner sc = new Scanner(System.in);

	// Okay
	public void getInput() {
		T = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt(); 
		A = new int[M];
		B = new int[N];
		A = new Interval().utilArrayScanner(A, M);
		B = new Interval().utilArrayScanner(B, N);	
	}

	public int[] utilArrayScanner(int[] temp, int count) {
		for(int i = 0; i < count; i++) {
			temp[i] = sc.nextInt();
		}
		return temp;
	}
	
	public void mainAction() {
		Interval it = new Interval();
		for(int j = 0; j< B.length; j++) {
			//works
			// it.printTemp(A) ;	
			score = it.findCommon(A, B, j);
			it.setScore(score, j);
			// it.updateRange();
			System.out.println(score);
		}
	}
	
	// okay
	//define upper and lower limits
	public int findCommon(int[] A, int[] B, int j) {
		B_ELEMENT=B[j];
		// System.out.println("B[1] is "+ B_ELEMENT);
		common_sum=0;
		if(j == 0) {
			lower_limit=A.length - B_ELEMENT;
			uppper_limit=B_ELEMENT- lower_limit+1;
		}
		// System.out.println("Common is" +common);
		for(int i=lower_limit; i<=uppper_limit; i++) {
			common_sum=common_sum+A[i];
		}
		System.out.println("COmmon sum is"+common_sum);
		//clear till common
		uncommon=B.length-common;
		left_lower = lower_limit- lower_limit;
		left_upper = lower_limit-1;
		right_lower = uppper_limit+1;
		right_upper = uppper_limit+ lower_limit-1;
		for(int i=left_lower; i<= left_upper; i++) {
			temp1=temp1+A[i];

		}

		for(int i=right_lower; i<=right_upper ; i++) {
			temp2=temp2+A[i];
		}

		
		if(temp1>temp2) {
			lower_limit = left_lower + 1;
			uppper_limit = left_upper - 1;
			System.out.println(" Largest is "+(common_sum+temp1));
			return common_sum+temp1;
		}
		lower_limit = right_lower + 1;
		uppper_limit = right_upper - 1;
		System.out.println(" Largest is "+(common_sum+temp2));
			return common_sum+temp2;
			
	}

	//cannot find symbol
	public void setScore(int score_temp, int j) {
		// if(j>B.length-1) {
		// 	System.out.println(score);
		// 	System.exit(0);
		// }
		if((j+1)%2!=0) {
			score=score+ score_temp;   
		}
		else {
			score=score- score_temp;
		}
	}

	

	public static void main(String args[]) {
		Interval i = new Interval();
		i.getInput();
		i.mainAction();

	}













	 // Sample processing 
	 // public void printTemp(int[] temp) {
	 // 	 System.out.println("Hello World");
	 // 	for (int a : temp) {
	 // 		System.out.println(a);
	 // 	}
	 // }
}