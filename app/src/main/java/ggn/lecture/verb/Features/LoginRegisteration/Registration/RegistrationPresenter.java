package ggn.lecture.verb.Features.LoginRegisteration.Registration;

import android.databinding.ObservableField;
import android.view.View;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class RegistrationPresenter extends BasePresenter<RegistrationView>
{
    public ObservableField<String> userName         =
            new ObservableField<>();
    public ObservableField<String> email            =
            new ObservableField<>();
    public ObservableField<String> password         =
            new ObservableField<>();
    public ObservableField<String> confirm_password =
            new ObservableField<>();

    public RegistrationPresenter()
    {
        userName.set("");
        email.set("");
        password.set("");
        confirm_password.set("");
    }

    /**
     * register user on server with filled details.
     */
    public void registerClicked(View view)
    {
        if (userName.get().isEmpty()) {
            getView().displayError("Please enter Name");
        }
        else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
            getView().displayError("Please enter a valid email");
        }
        else if (password.get().isEmpty()) {

            getView().displayError("Please enter password");
        }
        else if (confirm_password.get().isEmpty()) {
            getView().displayError("Please enter confirm password");

        }
        else if (!confirm_password.get().equals(password.get())) {
            getView().displayError("Password not matched");

        }
        else {
            // send request to server.
            getView().displayError("Yiipeeeeeeeeeeeeeee..!");
        }
    }
}
