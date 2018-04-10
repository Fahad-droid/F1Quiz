package quizapp.wiss.com.douknw;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by HP on 23-11-2016.
 */

public class LoginActivity extends ActionBarActivity {

    private EditText etxtName,etxtMail;
    private TextView submit;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String username,email;

    public ProgressDialog pDialog;

    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editor = preferences.edit();
        

        etxtName = (EditText)findViewById(R.id.etxtname);
        etxtMail = (EditText)findViewById(R.id.etxtemail);


        submit = (TextView)findViewById(R.id.txtSubmit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = etxtName.getText().toString().trim();
                email = etxtMail.getText().toString().trim();

                Boolean b = email.matches(EMAIL_REGEX);

                if(!username.equals("") && !email.equals("") && b )
                {
                    new DoInBackground().execute();

                }
                else
                {

                    if(username.equals(""))
                    {
                        etxtName.setError("Please Enter your Name, Thank you.");
                    }
                    else if(email.equals("") || !b)
                    {
                        etxtMail.setError("Enter valid Email-id, Thank you.");
                    }

                }

            }
        });
    }

    class DoInBackground extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            editor.putString("Name",username);
            editor.putString("Email",email);
            editor.apply();
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pDialog.dismiss();
            Intent i = new Intent(LoginActivity.this,MainCategoryActivity.class);
            finish();
            startActivity(i);
        }
    }


}
