package ggn.lecture.verb.Features.LoginRegisteration.Registration;

import android.content.Context;
import android.content.Intent;

import ggn.lecture.verb.Features.Internal.Base.BaseActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.ActivityRegisterationBinding;

public class RegistrationActivity extends BaseActivity<ActivityRegisterationBinding, RegistrationPresenter> implements RegistrationView
{

    public static void start(Context context) {
        Intent starter = new Intent(context, RegistrationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_registeration;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new RegistrationPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        setupToolbar("");
        getDataBinder().setData(getPresenter());

    }

    @Override
    public Context getActivityG()
    {
        return RegistrationActivity.this;
    }

}
