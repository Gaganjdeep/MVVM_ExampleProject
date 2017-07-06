package ggn.lecture.verb.Features.Splash;

import android.content.Context;
import android.content.Intent;

import ggn.lecture.verb.Features.Internal.Base.BaseActivityNoBinding;
import ggn.lecture.verb.Features.LoginRegisteration.Login.LoginActivity;
import ggn.lecture.verb.Features.LoginRegisteration.UserPrefrence.UserSelectionActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.UtilsG.UtillsG;

public class SplashActivity extends BaseActivityNoBinding<SplashPresenter> implements SplashView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, SplashActivity.class);
        context.startActivity(starter);
        UtillsG.finishAll(context);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new SplashPresenter());
        getPresenter().attachView(this);

        getPresenter().splashCheck();
    }

    @Override
    public Context getActivityG()
    {
        return SplashActivity.this;
    }

    @Override
    public void initViews()
    {
        //no initialization required for this activity ,as no view used..!
    }

    @Override
    public long splashTimer()
    {
        return 4000;
    }

    @Override
    public void openLogin()
    {
        LoginActivity.start(getActivityG());
    }

    @Override
    public void openUserSelection()
    {
        UserSelectionActivity.start(getActivityG());
    }
}
