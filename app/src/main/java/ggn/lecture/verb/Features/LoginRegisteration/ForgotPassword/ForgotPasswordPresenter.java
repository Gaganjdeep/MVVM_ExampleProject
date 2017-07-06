package ggn.lecture.verb.Features.LoginRegisteration.ForgotPassword;

import android.databinding.ObservableField;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordView>
{
    public final ObservableField<String> email =
            new ObservableField<>();

    public ForgotPasswordPresenter()
    {
        email.set("");
    }

    public void submitEmail(View view)
    {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
            getView().displayError("Please enter a valid email");
        }
        else {
            //api call to get password.
            getView().displayError("Yiipeeeeeeeeeeeeeee..!");

        }
    }
}
