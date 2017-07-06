package ggn.lecture.verb.Features.Splash;

import ggn.lecture.verb.Features.Internal.Base.Contract.Viewable;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public interface SplashView extends Viewable<SplashPresenter>
{
    long splashTimer();

    void openLogin();

    void openUserSelection();
}
