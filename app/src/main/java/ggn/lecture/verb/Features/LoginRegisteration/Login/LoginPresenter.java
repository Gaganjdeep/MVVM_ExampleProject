package ggn.lecture.verb.Features.LoginRegisteration.Login;

import android.databinding.ObservableField;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class LoginPresenter extends BasePresenter<LoginView>
{

    public ObservableField<String> userName =
            new ObservableField<>();
    public ObservableField<String> password =
            new ObservableField<>();

    public LoginPresenter()
    {
        userName.set("");
        password.set("");
    }

    public void LoginClicked(View view)
    {
        if (userName.get().isEmpty()) {
            getView().displayError("Please enter user name");
        }
        else if (password.get().isEmpty()) {
            getView().displayError("Please enter password");
        }
        else {
//all done ,just verify on server.
            getView().displayError("Yiipeeeeeeeeeeeeeee..!");

        }

    }

}
