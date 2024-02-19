package org.sorel.designpattern.behavioral.mediator;

public interface Colleague {

    void setMediator(Mediator mediator);

    void setColleagueEnabled(boolean enabled);
}
