//Esme Rubinstein
public class Pyramid {

    public static void main(String[] args) {
	if(args.length == 1) {
	    int star = 0;
	    int N = Integer.parseInt(args[0]);
	    for(int i = 1; i < N+1; i++) {
		for(int j=0; j < N-i; j++) {
		    System.out.printf(" ");
		    }
		while(star!=2*i-1) {
			System.out.printf("*");
			star += 1;
		}
		star = 0;
		System.out.printf("\n");
		
		}
	    
	    }
	else {
	    System.out.println("Enter valid height");
	    System.exit(1);
	// TODO Auto-generated method stub
	}
    }

}
