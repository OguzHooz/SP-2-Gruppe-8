package sample;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger count = new AtomicInteger(0);
    int userid;
    String email;
    String password;

    public void generateUserID() {
        userid = count.incrementAndGet();
    }
}
