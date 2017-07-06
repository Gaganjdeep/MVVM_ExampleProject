package ggn.lecture.verb.Features.TestPackage;

/**
 * Created by G-Expo on 09 Jun 2017.
 */

public class TestModel
{
    private String  message;
    private String  title;
    private boolean isAnonymous;
    private float   rating;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public boolean isAnonymous()
    {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous)
    {
        isAnonymous = anonymous;
    }
}
