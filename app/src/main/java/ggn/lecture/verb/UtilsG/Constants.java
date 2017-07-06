package ggn.lecture.verb.UtilsG;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by G-Expo on 07 Mar 2017.
 */
// HomeHelp
@Retention(RetentionPolicy.SOURCE)
public @interface Constants
{
    String STCIKER_LIST = "stickerList.srl";
    String FB_ID        = "520728504777049";

    @interface Extras
    {
        String DATA              = "data";
        String WISH_ID           = "wishId";
        String TRANSITION_NAME_1 = "name";
        String TRANSITION_NAME_2 = "name2";
        String PAGE_NUMBER       = "page_number";
        String TITLE             = "title";
    }

    @interface RequestCode
    {
        int CAMERA       = 11;
        int GALLERY      = 22;
        int PLACE_PICKER = 101;
        int COLOR_PICKER = 202;
        int IMAGE_SEARCH = 303;
        int INVITE       = 404;
        int IMAGESEARCH  = 505;
    }

}
