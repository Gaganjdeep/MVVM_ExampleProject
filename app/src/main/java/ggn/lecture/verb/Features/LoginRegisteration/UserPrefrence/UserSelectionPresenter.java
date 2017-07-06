package ggn.lecture.verb.Features.LoginRegisteration.UserPrefrence;

import ggn.lecture.verb.Features.Internal.Base.BasePresenter;
import ggn.lecture.verb.R;

/**
 * Created by G-Expo on 05 Jul 2017.
 */

public class UserSelectionPresenter extends BasePresenter<UserSelectionView>
{
    private String selectedUser;

    public void onCheckChanged(int i)
    {
        switch (i) {
            case R.id.radiobtn_student:
                selectedUser = UserType.STUDENT;
                break;
            case R.id.radiobtn_nonstudent:
                selectedUser = UserType.NON_STUDENT;
                break;
            case R.id.radiobtn_lecture:
                selectedUser = UserType.LECTURER;
                break;
        }
    }

    /**
     * skip button working goes here..
     */
    public void skipClicked()
    {

    }
}
