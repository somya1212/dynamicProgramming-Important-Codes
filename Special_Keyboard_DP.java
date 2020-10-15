/*
Imagine you have a special keyboard with the following keys: 

Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Find maximum numbers of A's that can be produced by pressing keys on the special keyboard N times. 
*/
class spkey { 
    static int findoptimal(int N) { 
		if (N <= 6)return N; 
		int screen[] = new int[N]; 
		int b, n; 
		for (n = 1; n <= 6; n++) 
			screen[n - 1] = n;
		for (n = 7; n <= N; n++) {  
			screen[n - 1] = 0; 
			for (b = n - 3; b >= 1; b--) {
				int curr = (n - b - 1) * screen[b - 1]; 
				if (curr > screen[n - 1]) 
					screen[n - 1] = curr; 
			} 
		} 
		return screen[N - 1]; 
	} 

	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    System.out.println(findoptimal(n));
		}
	}
}

/*

For Input:
3

your output is: 
3
execution time .15sec
*/
