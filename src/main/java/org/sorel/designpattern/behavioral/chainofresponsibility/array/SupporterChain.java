package org.sorel.designpattern.behavioral.chainofresponsibility.array;

import java.util.ArrayList;
import java.util.List;

public class SupporterChain {
    private List<Supporter> supporterList = new ArrayList<>();

    public void addSupport(Supporter supporter) {
        this.supporterList.add(supporter);
    }

    public void support(Trouble trouble) {
        boolean supported = false;
        for (Supporter supporter : supporterList) {
            supported = supporter.support(trouble);
            if (supported) {
                done(trouble, supporter);
                break;
            }
        }

        if (!supported) {
            fail(trouble);
        }
    }

    protected void done(Trouble trouble, Supporter supporter) {
        System.out.println(trouble + " is resolved by " + supporter + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can't be resolved.");
    }
}
