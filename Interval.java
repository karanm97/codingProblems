import java.util.Scanner;

class Interval {

	/* useless constructor */
	// public Interval(T, M, N, A, B) {
	// 	this.T = T;
	// 	this.M = M;
	// 	this.N = N;
	// 	this.A = A;
	// 	this.B = B;

	// }

	/* Sample processing */
	// public void printTemp(int[] temp) {
	// 	// System.out.println("Hello World");
	// 	for (int a : temp) {
	// 		System.out.println(a);
	// 	}
	// }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] A = new int[M];
		int[] B = new int[N];
		for(int i = 0; i < M; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}	
		Interval i = new Interval();
		i.printTemp(A);
	}
}