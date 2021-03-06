package org.deroesch.gofpatterns.chainofcommand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName(value = "Chain of Command")
class GizmoTest {

    @Test
    void testNullArgs() {
        // Constructor can't take null as an arg.
        assertThrows(NullPointerException.class, () -> new First(null));
    }

    @Test
    void testSuccessor() {
        // Last element in the chain doesn't have a successor
        assertFalse(new Last().hasSuccessor());
    }

    private boolean handled = false;

    @Test
    @DisplayName(value = "Run the chain")
    void testExecute() {

        GizmoChain last = new Last();
        GizmoChain middle = new Middle(last);
        GizmoChain first = new First(middle);

        first.execute();

        assertTrue(handled);
    }

    class First extends GizmoChain {

        public First(@NonNull GizmoChain successor) {
            super(successor);
        }

        @Override
        public boolean handler() {
            log.info(this + " says Sorry!");
            return false;
        }
    }

    class Middle extends GizmoChain {

        public Middle(@NonNull GizmoChain successor) {
            super(successor);
        }

        @Override
        public boolean handler() {
            log.info(this + " says Sorry!");
            return false;
        }
    }

    class Last extends GizmoChain {

        public Last() {
        }

        @Override
        public boolean handler() {
            log.info(this + " says Done!");
            handled = true;
            return true;
        }
    }

}
