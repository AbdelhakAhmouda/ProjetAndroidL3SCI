package sci.iam.learnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ModulesActivity extends AppCompatActivity {


    TextView welcome_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        welcome_text = findViewById(R.id.welcome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String username = bundle.getString("username");
        String password = bundle.getString("password");


        welcome_text.setText("Welcome '"+username+"', your Password '"+password+"'");

    }



}
