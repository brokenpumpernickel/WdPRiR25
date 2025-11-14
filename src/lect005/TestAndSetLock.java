package lect005;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAndSetLock implements PoorLock {
    private AtomicBoolean flag = new AtomicBoolean(false);

    @Override
    public void lock() {
        while(flag.getAndSet(true));
    }

    @Override
    public void unlock() {
        flag.set(false);
    }
}
