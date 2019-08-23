import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
						inOrderRecurse(0,result);
                        
			return result;
		}
		
		void inOrderRecurse(int i, List<Integer> result){
			
			if(left[i]!=-1){
				inOrderRecurse(left[i],result);
			}
			result.add(key[i]);
			if(right[i]!=-1){
				inOrderRecurse(right[i],result);
			}
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
				preOrderRecurse(0,result);
			return result;
		}
		void preOrderRecurse(int i, List<Integer> result){
			
			result.add(key[i]);
			if(left[i]!=-1){
				preOrderRecurse(left[i],result);
			}
			if(right[i]!=-1){
				preOrderRecurse(right[i],result);
			}
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
				postOrderRecurse(0,result);
			return result;
		}
		
		void postOrderRecurse(int i, List<Integer> result){
			
			if(left[i]!=-1){
				postOrderRecurse(left[i],result);
			}
			if(right[i]!=-1){
				postOrderRecurse(right[i],result);
			}
			result.add(key[i]);
		}
		
	}
	
	

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
