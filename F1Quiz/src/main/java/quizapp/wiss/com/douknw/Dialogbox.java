package quizapp.wiss.com.douknw;

/**
 * Created by fahad on 2016-11-28.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dialogbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogbox);

        if(ConstValue.correct_ans==0 || ConstValue.correct_ans==1 || ConstValue.correct_ans==2){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            //Setting message manually and performing action on button click
            builder.setMessage("\bPlease try again !!\n\n")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ConstValue.correct_ans=0;
                            Intent i=new Intent(Dialogbox.this,QuizActivity.class);
                            startActivity(i);
                        }
                    })

                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                    });



            //Creating dialog box
            AlertDialog alert = builder.create();

            //Setting the title manually
            alert.setTitle("Your Score is : "+String.valueOf(ConstValue.correct_ans));
            alert.show();
            setContentView(R.layout.activity_dialogbox);
        }

        else if(ConstValue.correct_ans==3){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            //Setting message manually and performing action on button click
            builder.setMessage("\bGood Job !!\n\n")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ConstValue.correct_ans=0;
                            Intent i=new Intent(Dialogbox.this,QuizActivity.class);
                            startActivity(i);
                        }
                    })

                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                    });

            //Creating dialog box
            AlertDialog alert = builder.create();

            //Setting the title manually
            alert.setTitle("Your Score is : "+String.valueOf(ConstValue.correct_ans));
            alert.show();
            setContentView(R.layout.activity_dialogbox);

        }

        else if(ConstValue.correct_ans==4){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            //Setting message manually and performing action on button click
            builder.setMessage("\bExcellent work !!\n\n")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ConstValue.correct_ans=0;
                            Intent i=new Intent(Dialogbox.this,QuizActivity.class);
                            startActivity(i);
                        }
                    })

                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

            //Creating dialog box
            AlertDialog alert = builder.create();

            //Setting the title manually
            alert.setTitle("Your Score is : "+String.valueOf(ConstValue.correct_ans));
            alert.show();
            setContentView(R.layout.activity_dialogbox);

        }

        else if(ConstValue.correct_ans==4){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            //Setting message manually and performing action on button click
            builder.setMessage("\bYou are a genius !!\n\n")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ConstValue.correct_ans=0;
                            Intent i=new Intent(Dialogbox.this,QuizActivity.class);
                            startActivity(i);
                        }
                    })

                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

            //Creating dialog box
            AlertDialog alert = builder.create();

            //Setting the title manually
            alert.setTitle("Your Score is : "+String.valueOf(ConstValue.correct_ans));
            alert.show();
            setContentView(R.layout.activity_dialogbox);

        }

        else if(ConstValue.correct_ans==5){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);


            //Setting message manually and performing action on button click
            builder.setMessage("\bYou are a genius !!\n\n")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ConstValue.correct_ans=0;
                            Intent i=new Intent(Dialogbox.this,ConstValue.class);
                            startActivity(i);
                        }
                    })

                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

            //Creating dialog box
            AlertDialog alert = builder.create();

            //Setting the title manually
            alert.setTitle("Your Score is : "+String.valueOf(ConstValue.correct_ans));
            alert.show();
            setContentView(R.layout.activity_dialogbox);

        }

    }
}