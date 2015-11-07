package com.ellekay.lucie.fashionhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseObject;


public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_up);

        Parse.initialize(this, "Pfeqj5fHsKxhPyJ3jAl5qWKYeVzeBJUsFlZDYWs0", "j3KLdZTzsLQJRcKaceWrejzlp4NQW9e1EkExPnaW");

        ParseObject testObject = new ParseObject("Fashion");
        testObject.put("shoes", "sandals");
        testObject.saveInBackground();
    }
}
