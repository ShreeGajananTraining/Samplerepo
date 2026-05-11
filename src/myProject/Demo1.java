package myProject;

public class Demo1 {
	
	public void display(char c) {
		System.out.println(c);
	}
	public void display(char c,int num) {
		System.out.println(c + " "+num);
	}
	
	public static void main(String[] args) {
	         Demo1 obj=new Demo1();
	         obj.display('a');
	         obj.display('a',10);
	}

}
