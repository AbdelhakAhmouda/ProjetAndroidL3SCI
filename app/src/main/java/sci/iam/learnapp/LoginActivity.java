package sci.iam.learnapp;

import android.app.ProgressDialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button signin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Authenticating");

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        signin = findViewById(R.id.button);


        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               signin(v);
            }
        });

    }


    public void signin(View view) {

        if (!validate()) {
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                       onLogin();
                        progressDialog.dismiss();
                    }
                }, 3000);

    }


    public void onLogin(){
        String user = username.getText().toString();
        String pass = password.getText().toString();


        if (!user.equals("abcd") || !pass.equals("EFGH")){
            Toast.makeText(this, "Sorry Wrong Inputs", Toast.LENGTH_LONG).show();
            Log.d("login","Wrong Inputs");
        }
        else{

                Toast.makeText(this, "Correct login.. ;)", Toast.LENGTH_LONG).show();
                Log.d("login","Correct");

                Intent intent = new Intent(LoginActivity.this, ModulesActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("username",user);
                bundle.putString("password",pass);
                intent.putExtras(bundle);

                LoginActivity.this.startActivity(intent);
            }
        }




    public boolean validate() {
        boolean valid = true;
        String user = username.getText().toString();
        String pass = password.getText().toString();


        if (user.isEmpty() ) {
            username.setError("Empty!! enter a valid username");
            valid = false;
        } else {
            username.setError(null);
        }

        if (pass.isEmpty() || password.length() < 4 ) {
            password.setError("should be greater or equal 4 characters");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }



}
