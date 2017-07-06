package ggn.lecture.verb.UtilsG.ContactStuff;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

import ggn.lecture.verb.UtilsG.CallBackG;

/**
 * Created by G-Expo on 06 Feb 2017.
 */

public class GetAllContacts extends AsyncTask<Void, Void, List<ContactsModel>>
{
    private Context                        con;
    private CallBackG<List<ContactsModel>> callBack;

    public GetAllContacts(Context con, CallBackG<List<ContactsModel>> callBack)
    {
        this.con = con;
        this.callBack = callBack;
    }

    @Override
    protected List<ContactsModel> doInBackground(Void... voids)
    {


        List<ContactsModel> list = null;
        try {
            list = new ArrayList<>();


            String selection = ContactsContract.Contacts.HAS_PHONE_NUMBER;

            ContentResolver cr  = con.getContentResolver();
            Cursor          cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, selection, null, null);


            if (cur.getCount() > 0) {

                int name_ = cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                int phNo  = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                while (cur.moveToNext()) {
//                    String id      = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                    try {
                        String name = cur.getString(name_);

                        ContactsModel contactsModel = new ContactsModel(name, removeCharsFromNumber(cur.getString(phNo)), false);
                        list.add(contactsModel);
                    }
                    catch (Exception | Error e) {
                        e.printStackTrace();
                    }

                }
            }
            cur.close();


            //Sort Entries
            Collections.sort(list, new Comparator<ContactsModel>()
            {
                @Override
                public int compare(ContactsModel t1, ContactsModel t2)
                {
                    return (t1.getName()).compareToIgnoreCase(t2.getName());
                }
            });
//
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

    public String removeCharsFromNumber(String number)
    {
        if (number.contains("+")) {
            number = number.substring(1);
        }
        if (number.contains(" ")) {
            number = number.replaceAll(" ", "");
        }

        number = number.replaceAll("[\\p{Ps}\\p{Pe}]", "");

        if (number.contains("-")) {
            number = number.replaceAll("-", "");
        }

        return number;
    }

    @Override
    protected void onPostExecute(List<ContactsModel> contactsModels)
    {
        LinkedHashSet<ContactsModel> setModel = new LinkedHashSet<>(contactsModels);

        callBack.CallBackG(new ArrayList<>(setModel));
        super.onPostExecute(contactsModels);
    }
}
