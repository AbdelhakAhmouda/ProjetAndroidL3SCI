package sci.iam.learnapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirm_password;
    Button signup;
    TextView login;

    DataBaseForSignUp dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        dataBase = new DataBaseForSignUp(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }


    public void signup() {

        if (!validate()) {
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(SignUp.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        final String name = username.getText().toString();
        final String pass = password.getText().toString();


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        String userExist = dataBase.searchUser(name);
                        long id = dataBase.insertUserData(name,pass);

                        if(userExist != null) {
                            Toast.makeText(SignUp.this, "Error! that user already exist", Toast.LENGTH_LONG).show();
                        }else {
                            if (id < 0) {
                                Toast.makeText(SignUp.this, "Error! Not registered correctly", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(SignUp.this, "Successfully registered", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }

                        progressDialog.dismiss();
                    }
                }, 3000);
    }



    public boolean validate() {
        boolean valid = true;

        String name = username.getText().toString();
        String pass = password.getText().toString();
        String confirmpass = confirm_password.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            username.setError("at least 3 characters");
            valid = false;
        } else {
            username.setError(null);
        }


        if (pass.isEmpty() || pass.length() < 4 ) {
            password.setError("should be greater or equal 4 alphanumeric characters");
            valid = false;
        } else {
            password.setError(null);
        }

        if (!pass.equals(confirmpass) ) {
            confirm_password.setError("password mismatch!!");
            valid = false;
        } else {
            confirm_password.setError(null);
        }


        return valid;
    }


}
