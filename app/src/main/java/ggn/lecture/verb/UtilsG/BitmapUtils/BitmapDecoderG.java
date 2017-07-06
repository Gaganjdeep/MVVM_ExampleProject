//==============================================================================================================================
package ggn.lecture.verb.UtilsG.BitmapUtils;


//==============================================================================================================================

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ggn.lecture.verb.UtilsG.Constants;


//------------------------------------------------------------------------------------------------------------------------------

//==============================================================================================================================
public class BitmapDecoderG
{
    //--------------------------------------------------------------------------------------------------------------------------
    public static Uri getTemporaryUri()
    {
        return Uri.fromFile(createTemporaryFile());

    }

    public static String getBytesImageBitmap(Context context, Bitmap imageUri)
    {
        try
        {
            Bitmap                bm   = imageUri;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 90, baos); //bm is the bitmap object
            byte[] b = baos.toByteArray();
            return Base64.encodeToString(b, Base64.DEFAULT);


        }
        catch (Exception | Error e)
        {
            e.printStackTrace();
            try
            {
                Bitmap                bm   = imageUri;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 60, baos); //bm is the bitmap object
                byte[] b = baos.toByteArray();
                return Base64.encodeToString(b, Base64.DEFAULT);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            return "";
        }
    }


    //--------------------------------------------------------------------------------------------------------------------------
    public static Uri onActivityResult(Context context,int requestCode, int resultCode, Intent data )
    {
        switch (requestCode)
        {
            case Constants.RequestCode.CAMERA:
                if (resultCode == Activity.RESULT_OK)
                {
                    try
                    {
                        return Uri.fromFile(generatedname);
//                        if (tempFile.exists())
//                            tempFile.delete();
                    }
                    catch (Exception error)
                    {
                        error.printStackTrace();
                    }
                }

                break;

            case Constants.RequestCode.GALLERY:
                try
                {
                    try
                    {
                        String      filePathG = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis()+".png";
                        InputStream inputStream;
                        inputStream = context.getContentResolver().openInputStream(data.getData());
                        FileOutputStream fileOutputStream = new FileOutputStream(filePathG);
                        copyStream(inputStream, fileOutputStream);
                        fileOutputStream.close();
                        inputStream.close();

                        return Uri.fromFile(new File(filePathG));
                    }
                    catch (Exception ex)
                    {
                        Log.e("Exception is", ex.toString());
                    }

                    return data.getData();
                }
                catch (Exception error)
                {
                    error.printStackTrace();
                }

                break;
        }

        return null;
    }
    private static void copyStream(InputStream input, OutputStream output) throws IOException
    {
        byte[] buffer = new byte[1024];
        int    bytesRead;
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
    }




    private static String randomName()
    {

        return System.currentTimeMillis() + "";

    }


    //--------------------------------------------------------------------------------------------------------------------------
    private static File createTemporaryFile()
    {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            try
            {
                File file = new File(Environment.getExternalStorageDirectory(), randomName());

                file.createNewFile();

                generatedname = file;

                return file;
            }
            catch (IOException error)
            {
            }
        }

        return null;
    }


    public static void openCamera(final Context context, final Fragment frag)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, getTemporaryUri());
        if (frag != null)
        {
            frag.startActivityForResult(cameraIntent, Constants.RequestCode.CAMERA);
        }
        else
        {
            ((Activity) context).startActivityForResult(cameraIntent, Constants.RequestCode.CAMERA);
        }
    }


    public static void openGallery(final Context context, final Fragment frag)
    {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK);

        pickPhoto.setType("image/*");


        if (frag != null)
        {
            frag.startActivityForResult(pickPhoto, Constants.RequestCode.GALLERY);
        }
        else
        {
            ((Activity) context).startActivityForResult(pickPhoto, Constants.RequestCode.GALLERY);
        }

    }


    public static void selectImage(final Context context, final Fragment frag)
    {
        generatedname = null;
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int item)
            {
                if (items[item].equals("Take Photo"))
                {
                    openCamera(context, frag);
                }
                else if (items[item].equals("Choose from Library"))
                {
                    openGallery(context, frag);
                }
                else if (items[item].equals("Cancel"))
                {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    //--------------------------------------------------------------------------------------------------------------------------
    private static String temporaryFilePath()
    {
        return Environment.getExternalStorageDirectory() + "/" + TEMP_PHOTO_FILE;
    }

    //--------------------------------------------------------------------------------------------------------------------------
    public static final  String TEMP_PHOTO_FILE = "temporary_holderG.jpg";
    private static final double LOG_2           = Math.log(2);


    private static File generatedname;

}
