package org.deroesch.gofpatterns;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void helloWorld() {
        new App();
        App.main(null);
        assertTrue(true);
    }
}
