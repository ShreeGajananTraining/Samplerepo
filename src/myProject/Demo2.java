package myProject;

public class Demo2 {
	
	public void display(char c) {
		System.out.println(c);
	}
	public void display(int num) {
		System.out.println(num);
	}

	public static void main(String[] args) {
		Demo2 obj=new Demo2();
		obj.display('a');
		obj.display(10);

	}

}
