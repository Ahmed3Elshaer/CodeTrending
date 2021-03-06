package io.ahmed3elshaer.domain.interactor

import io.ahmed3elshaer.domain.executor.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<T, in Params> constructor(
    private val postExecutionThread: PostExecutionThread
) {
    private val disposables = CompositeDisposable()
    protected abstract fun buildUseCaseObservable(params: Params? = null): Completable
    open fun execute(observer: DisposableCompletableObserver, params: Params? = null) {
        val completable = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose(){
        disposables.dispose()
    }
}