package lect005;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestTestAndSetLock implements PoorLock {
    private AtomicBoolean flag = new AtomicBoolean(false);

    @Override
    public void lock() {
        while(true) {
            while(flag.get());
            if(!flag.getAndSet(true))
                return;
        }
    }

    @Override
    public void unlock() {
        flag.set(false);
    }
}
