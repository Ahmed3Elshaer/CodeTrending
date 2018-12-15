package io.ahmed3elshaer.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread{
    val scheduler : Scheduler
}