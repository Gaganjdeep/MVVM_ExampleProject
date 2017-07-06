package ggn.lecture.verb.Features.LoginRegisteration.ForgotPassword;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BaseActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordPresenter> implements ForgotPasswordView
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, ForgotPasswordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_forgot_password;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new ForgotPasswordPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
        setupToolbar("");

        getDataBinder().setData(getPresenter());
//        getDataBinder().btnSubmit.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                getPresenter().submitEmail();
//            }
//        });
    }


    @Override
    public Context getActivityG()
    {
        return ForgotPasswordActivity.this;
    }
}
