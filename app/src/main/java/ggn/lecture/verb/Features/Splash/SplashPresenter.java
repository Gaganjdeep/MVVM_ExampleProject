package ggn.lecture.verb.Features.Splash;

import android.os.Handler;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class SplashPresenter extends BasePresenter<SplashView> implements Runnable
{
    public void splashCheck()
    {
        new Handler().postDelayed(this, getView().splashTimer());
    }

    @Override
    public void run()
    {
        //all login or other checks goes here..
        getView().openLogin();
    }
}
