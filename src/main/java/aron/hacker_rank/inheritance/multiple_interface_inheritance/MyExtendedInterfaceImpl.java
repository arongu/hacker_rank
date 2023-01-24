package aron.hacker_rank.inheritance.multiple_interface_inheritance;

public class MyExtendedInterfaceImpl implements MyExtendedInterface, InterfaceA, InterfaceB {
    @Override
    public void a() {
        System.out.println("hello for interface A");
    }

    @Override
    public void b() {
        System.out.println("hello for interface B");
    }
}
