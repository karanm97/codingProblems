class LittleElephantAndString {

	int i,j, finalInt; 
	int sumOfA = 0, sumOfB = 0;

	public static void main (String args[]) {

		LittleElephantAndString classObject = new LittleElephantAndString();

		String  A = args[0];
		String B = args[1];
		
		if (A.length() ==  B.length()) {

			if (A.length() <= 50 && B.length() <= 50) {

				System.out.println(classObject.getNumber(A , B));	

			}

			else {
				System.out.println(-1);
			}
		}

		else {
			System.out.println(-1);
		}
		

	}

	public int getNumber(String A , String B) {

		for (i=0; i<A.length(); i++) {
			
			sumOfA = sumOfA + (int) A.charAt(i);

		}

		for (i=0; i<B.length(); i++) {
			
			sumOfB = sumOfB + (int) B.charAt(i);

		}

		if (sumOfA == sumOfB) {

			System.out.println("function called");
			






















		}

		else return -1;
		

	    return  finalInt;
	}

}