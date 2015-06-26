package kickstarter.control;

public class C {

	public static void main(String [] args){
		
		System.out.println("A obj2 = new B();");
		A obj2 = new B();
		System.out.println("obj2.nonStaticFoo();");
		obj2.nonStaticFoo();
		System.out.println("obj2.staticFoo();");
		obj2.staticFoo();
		System.out.println();
		System.out.println("B obj3 = new B();");
		B obj3 = new B();
		System.out.println("obj3.nonStaticFoo();");
		obj3.nonStaticFoo();
		System.out.println("obj3.staticFoo();");
		obj3.staticFoo();
		System.out.println();
		System.out.println("A obj1 = new A();");
		A obj1 = new A();
		System.out.println("obj1.nonStaticFoo();");
		obj1.nonStaticFoo();
		System.out.println("obj1.staticFoo();");
		obj1.staticFoo();
		
	}
	
}
