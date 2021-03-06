package com.cogitator.googletransitionapi.view.base

/**
 *
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 *
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 28/06/2018 (MM/DD/YYYY)
 */
abstract class BasePresenter<T : MvpView> : Presenter<T> {

    protected var mvpView: T? = null
        get() {
            if (field == null) throw MvpViewNotAttachedException()
            return field
        }

    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
    }

    class MvpViewNotAttachedException
        : RuntimeException("Please call Presenter.attachView(MvpView) before requesting data " +
            "to the Presenter")
}