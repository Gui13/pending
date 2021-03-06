package net.ttsui.junit.rules.pending;

import org.junit.runners.model.Statement;

class PendingImplementationStatement extends Statement {

    private final Statement base;

    PendingImplementationStatement(Statement base) {
        this.base = base;
    }

    @Override
    public void evaluate() throws Throwable {
        try {
            base.evaluate();
        } catch (Throwable e) {
            // Ignore failures, because the implementation is still pending.
            return;
        }
        throw new AssertionError("Unexpected success");
    }

}
