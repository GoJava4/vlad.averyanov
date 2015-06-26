package kickstarter.control;

class A { 
	static {System.out.println("static A");}
	{System.out.println("non-static A");}
	A(){
		System.out.println("constructor A");
	}
	{System.out.println("non-static2 A");}
	 String str = "A";
	static void staticFoo() {
		System.out.println("A staticFoo");
	}
	void nonStaticFoo() {
		System.out.println("A nonStaticFoo");
	}
}
