package yas.uiux.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpScreen extends AppCompatActivity {
    TextView signin_sift;
    ImageView password_show,password_unshow;
    EditText edit_text_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //REMOVE STATUSBAR
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //REMOVE TOOLBAR
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_sign_up_screen);


        //MOVE TO SIGNIN SCREEN

        signin_sift =(TextView) findViewById(R.id.signin_sift);
        signin_sift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SignInScreen.class);
                startActivity(intent);

            }
        });


        edit_text_password=(EditText) findViewById(R.id.edit_text_password);


        //PASSWORD HIDE BUTTON

        password_show =(ImageView) findViewById(R.id.password_show);
        password_unshow =(ImageView) findViewById(R.id.password_unshow);
        password_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edit_text_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                password_unshow.setVisibility(View.VISIBLE);
                password_show.setVisibility(View.GONE);
            }
        });

        //PASSWORD SHOW BUTTON

        password_unshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edit_text_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

                password_unshow.setVisibility(View.GONE);
                password_show.setVisibility(View.VISIBLE);

            }
        });


    }
}