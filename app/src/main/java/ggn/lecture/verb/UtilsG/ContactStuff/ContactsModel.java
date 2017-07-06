package ggn.lecture.verb.UtilsG.ContactStuff;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by G-Expo on 06 Feb 2017.
 */
public class ContactsModel implements Parcelable
{
    private String Name, PhoneNumber, userId, profileImage;

    private boolean isRegistered;

    public static final Creator<ContactsModel> CREATOR = new Creator<ContactsModel>()
    {
        @Override
        public ContactsModel createFromParcel(Parcel in)
        {
            return new ContactsModel(in);
        }

        @Override
        public ContactsModel[] newArray(int size)
        {
            return new ContactsModel[size];
        }
    };

    public void setName(String name)
    {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        PhoneNumber = phoneNumber;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getProfileImage()
    {
        return profileImage;
    }

    public void setProfileImage(String profileImage)
    {
        this.profileImage = profileImage;
    }

    public void setRegistered(boolean registered)
    {
        isRegistered = registered;
    }

    public ContactsModel(String name, String phoneNumber, boolean isRegistered)
    {
        Name = name;
        PhoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
    }

    public ContactsModel()
    {
    }

    public boolean isRegistered()
    {
        return isRegistered;
    }

    public String getName()
    {
        return Name;
    }

    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    protected ContactsModel(Parcel in)
    {
        Name = in.readString();
        PhoneNumber = in.readString();

    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(Name);
        parcel.writeString(PhoneNumber);
        parcel.writeString(userId);
        parcel.writeString(profileImage);
        parcel.writeByte((byte) (isRegistered ? 1 : 0));
    }
}
