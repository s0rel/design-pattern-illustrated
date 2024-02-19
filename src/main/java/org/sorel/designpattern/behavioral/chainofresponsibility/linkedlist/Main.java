package org.sorel.designpattern.behavioral.chainofresponsibility.linkedlist;


public class Main {
    public static void main(String[] args) {
        Supporter alice = new NoSupporter("Alice");
        Supporter bob = new LimitSupporter("Bob", 100);
        Supporter charlie = new SpecialSupporter("Charlie", 429);
        Supporter diana = new LimitSupporter("Diana", 200);
        Supporter elmo = new OddSupporter("Elmo");
        Supporter fred = new LimitSupporter("Fred", 300);

        SupporterChain chain = new SupporterChain();
        chain.addSupport(alice);
        chain.addSupport(bob);
        chain.addSupport(charlie);
        chain.addSupport(diana);
        chain.addSupport(elmo);
        chain.addSupport(fred);
        for (int i = 0; i < 500; i += 33) {
            chain.support(new Trouble(i));
        }
    }
}
