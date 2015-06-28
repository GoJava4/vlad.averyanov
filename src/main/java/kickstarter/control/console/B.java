package kickstarter.control.console;

class B extends A {
	{System.out.println("non-static B");}
	static {System.out.println("static B");}
	static String str = "B";
	static void staticFoo() {
		System.out.println("B staticFoo");
	}
	void nonStaticFoo() {
		System.out.println("B nonStaticFoo");
	}
	B(){
		System.out.println("constructor B");
	}
}
