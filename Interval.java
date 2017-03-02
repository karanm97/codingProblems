import java.util.Scanner;

class Interval {

	int[] A, B;
	int T, M, N;
	int A_LENGTH, B_ELEMENT, uncommon_sum, common_sum = 0, common, uncommon, temp1, temp2, score;
	int lower_limit, upper_limit;
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
			System.out.println("Score is "+score);
		}
	}
	
	// okay
	//define upper and lower limits
	public int findCommon(int[] A, int[] B, int j) {
		B_ELEMENT=B[j];
		System.out.println("B[] is "+ B_ELEMENT);
		common_sum=0;
		if(j == 0) {
			lower_limit=A.length - B_ELEMENT;
			upper_limit=B_ELEMENT- lower_limit+1;
		}
		// System.out.println("Common is" +common);
		for(int i=lower_limit; i<=upper_limit; i++) {
			common_sum=common_sum+A[i];
		}
		System.out.println("COmmon sum is"+common_sum);
		//clear till common
		// uncommon=B.length-common;
		left_lower = lower_limit- lower_limit;
		left_upper = lower_limit-1;
		right_lower = upper_limit+1;
		right_upper = upper_limit+ lower_limit;
		for(int i=left_lower; i<= left_upper; i++) {
			temp1=temp1+A[i];

		}

		for(int i=right_lower; i<=right_upper ; i++) {
			temp2=temp2+A[i];
		}
		
		if(temp1>temp2) {
			lower_limit = left_lower + 1;
			upper_limit = upper_limit - 1;
			System.out.println(" Largest is "+(common_sum+temp1));
			System.out.println("Lower Limit"+ lower_limit);
			System.out.println("Upper Limit"+ upper_limit);

			return common_sum+temp1;
		}
		lower_limit = lower_limit + 1;
		upper_limit = right_upper - 1;
		System.out.println(" Largest is "+(common_sum+temp2));
		System.out.println("Lower Limit"+ lower_limit);
		System.out.println("Upper Limit"+ upper_limit);			
		return common_sum+temp2;
	}

	public void setScore(int score_temp, int j) {
		if(((j+1)%2)!=0) {
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