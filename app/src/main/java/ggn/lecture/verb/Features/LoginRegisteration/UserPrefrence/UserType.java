package ggn.lecture.verb.Features.LoginRegisteration.UserPrefrence;

import android.support.annotation.StringDef;

/**
 * Created by G-Expo on 05 Jul 2017.
 */
// LV


@StringDef({UserType.STUDENT, UserType.NON_STUDENT, UserType.LECTURER})
public @interface UserType
{
    String STUDENT     = "student";
    String NON_STUDENT = "non_student";
    String LECTURER    = "lecturer";
}
