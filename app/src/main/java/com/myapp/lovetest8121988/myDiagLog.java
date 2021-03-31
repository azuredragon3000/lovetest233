package com.myapp.lovetest8121988;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class myDiagLog {
    private startnewview startnewview1;
    myDiagLog(String txt, String ok, Context content,startnewview startnewview1){
        LayoutInflater layoutinflater = LayoutInflater.from(content);
        View promptUserView = layoutinflater.inflate(R.layout.dialog_signin, null);
        this.startnewview1 = startnewview1;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(content);

        alertDialogBuilder.setView(promptUserView);

        final EditText userAnswer1 = (EditText) promptUserView.findViewById(R.id.username);
        final EditText userAnswer2 = (EditText) promptUserView.findViewById(R.id.username);
        alertDialogBuilder.setTitle(txt);

        // prompt for username
        alertDialogBuilder.setPositiveButton(ok,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startnewview1.startview1();
            }
        });

        // all set and time to build and show up!
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        // return result;
    }


}
