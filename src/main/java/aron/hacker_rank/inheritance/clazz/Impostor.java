package aron.hacker_rank.inheritance.clazz;

public class Impostor extends Original {
    public void whoAreYou() {
        System.out.println("Impostor");
    }

    public static void main(String[] args) {
        Original o = new Impostor();
        o.whoAreYou();
    }
}
