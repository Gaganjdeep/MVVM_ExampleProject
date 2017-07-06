package ggn.lecture.verb.UtilsG;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by G-Expo on 20 Mar 2017.
 */

public class LocalDataHelper<T>
{
    private String dataName = "CategoryList.srl";

    public LocalDataHelper()
    {
    }

    public LocalDataHelper<T> setListName(String dataName)
    {
        this.dataName = dataName;
        return this;
    }

    public synchronized void write(Context context, ArrayList<T> nameOfClassGetterSetter)
    {
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String       filename = dataName;
        ObjectOutput out      = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(directory
                    + File.separator + filename));
            out.writeObject(nameOfClassGetterSetter);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized ArrayList<T> read(Context context)
    {
        ObjectInputStream input       = null;
        ArrayList<T>      ReturnClass = null;
        String            filename    = dataName;
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        try {
            input = new ObjectInputStream(new FileInputStream(directory
                    + File.separator + filename));
            ReturnClass = (ArrayList<T>) input.readObject();
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        if (ReturnClass != null) {
            return ReturnClass;
        }
        else {
            return new ArrayList<>();
        }
    }

}
