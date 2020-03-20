package com.example.marvelappiness.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by debasish on 20/03/20.
 */

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
