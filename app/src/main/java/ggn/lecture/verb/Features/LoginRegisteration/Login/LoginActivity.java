package ggn.lecture.verb.Features.LoginRegisteration.Login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BaseActivity;
import ggn.lecture.verb.Features.LoginRegisteration.ForgotPassword.ForgotPasswordActivity;
import ggn.lecture.verb.Features.LoginRegisteration.Registration.RegistrationActivity;
import ggn.lecture.verb.R;
import ggn.lecture.verb.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginPresenter> implements LoginView, View.OnClickListener
{

    public static void start(Context context)
    {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new LoginPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {

        getDataBinder().setData(getPresenter());

        getDataBinder().layoutForgetPassword.setOnClickListener(this);
        getDataBinder().layoutSignUp.setOnClickListener(this);
        getDataBinder().btnLogin.setOnClickListener(this);
    }

    @Override
    public Context getActivityG()
    {
        return LoginActivity.this;
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
//            case R.id.btnLogin:
//                getPresenter().LoginClicked();
//                break;
            case R.id.layoutForgetPassword:
                ForgotPasswordActivity.start(getActivityG());
                break;
            case R.id.layoutSignUp:
                RegistrationActivity.start(getActivityG());
                break;

        }
    }
}
