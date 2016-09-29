
package com.kturley;

import org.jboss.weld.environment.se.Weld;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        weld.initialize().instance().select(Fibber.class).get().run(args);
        weld.shutdown();
    }
}
