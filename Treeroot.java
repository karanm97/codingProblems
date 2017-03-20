import java.util.*;
import java.io.*;

class Treeroot {
	
	int testCases, nodeCount, temp;
	public void process() {
		FastReader fs = new FastReader();
		ArrayList<Integer> al = new ArrayList<Integer>();

		testCases = fs.nextInt();
		int j = 0;
		while(j++ < testCases) {
			nodeCount = fs.nextInt();
			int[] unique_id = new int[nodeCount];
			int[] child_sum = new int[nodeCount];
			temp = Integer.MIN_VALUE;
			for(int i = 0; i < nodeCount; i++) {
				unique_id[i] = fs.nextInt();
				child_sum[i] = fs.nextInt();
                // System.out.println(i);
				if(temp <= child_sum[i]) {
                    al.add(i);
                    temp = child_sum[i];    
                }						
                // System.out.println();
			}

            // prints the unique id and sum 
            // for(int i = 0; i < nodeCount; i++) {
            //     System.out.print(unique_id[i]);
            //     System.out.print("\t"+child_sum[i]);
            //     System.out.println();
            // }



            // for(int iterator : al) {
            //     System.out.println(iterator);
            // }
            // for(int a = 0; a < al.size(); a++) {
            //     System.out.println()
            // }

            // Collections.sort(al);
            int another = Integer.MIN_VALUE;
            for(int iterator : al) {
                // System.out.println(unique_id[iterator]);
                if(another <= unique_id[iterator]) {
                    another = unique_id[iterator];                    
                }
            }
            System.out.println(another);



		}	
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("d:\\programming\\case.txt"));
		new Treeroot().process();
	}
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));

        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}