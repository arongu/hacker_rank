package aron.hacker_rank.inheritance.inner;

public class InnerClasses {
    public static class A {
        void a() {
            System.out.println("a()");
        }
    }

    public static class B extends InnerClasses.A {
        @Override
        void a() {
            System.out.println("extended a()");
        }
    }

    public class InsideClass {
        public void x() {
            System.out.println("x");
        }
    }

    public static void main(final String[] args) {
        // calling the constructor of a nested static class (no need to create an instance of the outside class)
        final InnerClasses.B b = new B();
        b.a();

        // creating an instance of the outside class 'InnerClasses', so non-static methods will accessible
        final InnerClasses innerClasses = new InnerClasses(); // instance
        final InsideClass insideClass = innerClasses.new InsideClass(); // calling the non-static constructor of InsideClass
    }
}
