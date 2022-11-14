package com.spyboot.wt.service;

import java.util.concurrent.atomic.AtomicReference;

public class Token {

    private static volatile AtomicReference<String> authorization =
            new AtomicReference<>("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgzMjQxOTgsInVuYW1lIjoiYWRtaW4ifQ.tD-7Sit2DFN0pC7bg6rm03TSp0Jl2qIvbLBQN6nbmCQ");

    public static AtomicReference<String> getAuthorization() {
        return authorization;
    }

    public static void setAuthorization(AtomicReference<String> authorization) {
        Token.authorization = authorization;
    }


}
