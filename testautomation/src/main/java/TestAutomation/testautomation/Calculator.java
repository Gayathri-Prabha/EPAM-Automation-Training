package TestAutomation.testautomation;

public class Calculator {
	public int add(int a,int b) {
		return(a+b);
	}
	public int sub(int a, int b) {
		if(a>b)
			return(a-b);
		else
			return(b-a);
	}
	public int mul(int a,int b) {
		return(a*b);
	}
	public Integer div(int a,int b) {
		if(b==0)
			return null;
		return(a/b);
	}
	public Integer divWithZeroHandling(int a,int b) {
		return (a/b);
	}
	public static void main( String[] args ) {
	}
}
