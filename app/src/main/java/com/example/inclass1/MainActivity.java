package com.example.inclass1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void onClickButton(View view) {
        int viewID = view.getId();
        if(viewID == R.id.buttonWebsite)
        {
            onClickWebsiteURL(view);
        }
        else if(viewID == R.id.buttonTelephone)
        {
            onClickTelephoneCall(view);
        }
        else if(viewID == R.id.buttonEmail)
        {
            onClickSendEmail(view);
        } else if(viewID == R.id.buttonMap)
        {
            onClickShowMap(view);
        } else if(viewID == R.id.buttonCamera)
        {
            onClickOpenCamera(view);
        } else if(viewID == R.id.buttonMedia)
        {
            onClickPlayMedia(view);
        }
    }

    private void onClickPlayMedia(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/TouMO5U4dK0"));
        startActivity(intent);
    }

    private void onClickOpenCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    private void onClickShowMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"));
        startActivity(intent);
    }

    private void onClickSendEmail(View view) {
        String strEmail = ((Button)view).getText().toString();
        String[] addresses = new String[]{strEmail};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        startActivity(intent);
    }

    public void onClickWebsiteURL(View view) {
        // get the URL from the caption of the button
        String strUrl = ((Button)view).getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUrl));
        startActivity(intent);
    }

    private void onClickTelephoneCall(View view) {
        String telephone = ((Button)view).getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telephone));
        startActivity(intent);
    }
}