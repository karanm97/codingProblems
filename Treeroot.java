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
				if(child_sum[i] > temp)
					al.add(i);
					temp = child_sum[i];			
			}
			System.out.println(al);

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