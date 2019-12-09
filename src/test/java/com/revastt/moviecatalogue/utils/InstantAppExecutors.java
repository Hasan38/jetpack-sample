package com.revastt.moviecatalogue.utils;

import java.util.concurrent.Executor;

public class InstantAppExecutors extends AppExecutors {
    private static Executor instant = Runnable::run;

    public InstantAppExecutors() {
        super();
    }
}