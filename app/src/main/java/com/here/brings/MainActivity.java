package com.here.brings;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private  EditText mShareTextEditText;
    private  EditText mTelpTextEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = (EditText)findViewById(R.id.website_edittext);
        mLocationEditText=(EditText)findViewById(R.id.location_edittext);
        mShareTextEditText=(EditText)findViewById(R.id.share_edittext);
        mTelpTextEditText=(EditText)findViewById(R.id.mtelp_editText);

    }

    public void openWebsite(View view){
        String url=mWebsiteEditText.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents","can't handle this!");
        }
    }

    public  void openLocation(View view){
        String loc=mLocationEditText.getText().toString();
        Uri adressUri= Uri.parse("geo:0,0?q=" + loc);
        Intent intent=new Intent(Intent.ACTION_VIEW, adressUri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public  void  shareText(View view){
        String txt=mShareTextEditText.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();

    }

    public void telp(View view){
        String telp=mTelpTextEditText.getText().toString();
        Intent intent=new Intent((Intent.ACTION_DIAL));
        intent.setData(Uri.parse("tel:"+telp));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }


}
