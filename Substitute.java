/*
 Author : Karan Mundra
 Content : Practice Problem  of TopCoder
 link : https://arena.topcoder.com/#/u/practiceCode/1282/1262/1333/2/1282
*/
 
class Substitute {

	public int i , j , return_value ;
	String stringAdder = "";

	public static void main (String args[]) {

		Substitute subsObject = new Substitute();
		String key = "CRYSTALBUM";
		String code = "MMA";
		System.out.println("Key: "+key);
		System.out.println("Code: "+code);
		int final_answer = subsObject.getValue(key,code);
		System.out.println(final_answer);

	}

	public int getValue(String key , String code) {

		//Declaring String arrays for storing individual letters of passed Strings

		String[] codeString = new String[code.length()];
		String[] keyString = new String[10];


		//Storing String values

		for (i = 0 ; i <= 9 ; i++) {

			keyString[i] =  Character.toString(key.charAt(i)); 
			
		}

		for (i = 0 ; i < code.length() ; i++ ) {
			codeString[i] = Character.toString(code.charAt(i));
		}


		// Comparing two string arrays 
		for (i = 0; i < code.length() ; i++) {
			
			for (j = 0; j <= 9 ; j++ ) {

				if ((codeString[i].equals(keyString[j]))) {

					if ( j == 9) {

						stringAdder = stringAdder+Integer.toString(j-9);
					}

					else {

						stringAdder = stringAdder+Integer.toString(j+1);

					}
					
				}

			}
		}

		try {				

			return_value = Integer.parseInt(stringAdder.toString()); 

		}

		catch(NumberFormatException e) {

		}

		return return_value;

	}

}
