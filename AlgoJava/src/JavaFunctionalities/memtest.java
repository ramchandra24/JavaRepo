package JavaFunctionalities;

public class memtest {
	int a;
	int b;
	public memtest(int a, int  b) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
	}
	
	public memtest newnode() {
		return new memtest(10, 20);
	}
	
public static void main(String[] args) {
	memtest a = new memtest(1, 2);
	System.out.println(a.a + a.b);
	a = a.newnode();
	System.gc();
	System.out.println(a.a + a.b);
	int x = 0;
	while (x++ < 10) {
		new memtest(3,  6);
		System.out.println("new temp");
		System.gc();
	}
}
@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	System.out.println("Finalize called: " + (this.a + this.b));
	super.finalize();
}
}
