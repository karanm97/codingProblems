public class RepeatedStrings {
	
	String s;
	int k;

	public String findKth(String s, int k) {
		this.s = s;
		this.k = k;
		int counter = 0;
		int strLength = s.length();
		for (int i = 1; i < strLength; i++ ) {
			if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
				counter++;
			}
		}
		System.out.println(counter);
		return "Hey";	
	}

	public static void main(String args[]) {
		RepeatedStrings rs = new RepeatedStrings();
		System.out.println(rs.findKth("()))((()())", 3));
	}
}