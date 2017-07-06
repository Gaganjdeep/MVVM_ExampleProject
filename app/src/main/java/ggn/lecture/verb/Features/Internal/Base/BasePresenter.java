package ggn.lecture.verb.Features.Internal.Base;

import android.support.annotation.NonNull;

import ggn.lecture.verb.Features.Internal.Base.Contract.Presentable;
import ggn.lecture.verb.Features.Internal.Base.Contract.Viewable;

public class BasePresenter<T extends Viewable> implements Presentable<T>
{
    private T viewable;

    @Override
    public void onStart()
    {
        // No-op by default
    }

    @Override
    public void onViewCreated()
    {
//        views are created ,now its time to initialize them..
        if (getView() != null) {
            getView().initViews();
        }
    }

    @Override
    public void onResume()
    {
        // No-op by default
    }

    @Override
    public void onPause()
    {
        // No-op by default
    }

    @Override
    public void onStop()
    {
        // No-op by default
    }

    @Override
    public void attachView(@NonNull T viewable)
    {
        this.viewable = viewable;
    }

    @Override
    public void detachView()
    {
        this.viewable = null;
    }

    @Override
    public T getView()
    {
        return viewable;
    }
}
