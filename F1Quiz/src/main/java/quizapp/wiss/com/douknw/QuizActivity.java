package quizapp.wiss.com.douknw;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.concurrent.ThreadLocalRandom;

import static quizapp.wiss.com.douknw.R.id.radio4;
import static quizapp.wiss.com.douknw.R.id.radiogroup;

/**
 * Created by HP on 28-11-2016.
 */


public class QuizActivity extends ActionBarActivity implements View.OnClickListener{
    ArrayList<QuestionPojo> questionList = new ArrayList<QuestionPojo>();

    private String Category;
    private TextView txtQue;
    private RadioGroup radiogroup;
    private RadioButton rbtn1,rbtn2,rbtn3,rbtn4;

    ArrayList<QuestionPojo>random_list=new ArrayList<QuestionPojo>();

    Set<Integer> generate_list = new LinkedHashSet<>();
    private TextView quenum,score;


    int counter=0;
    private ProgressDialog pDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        txtQue = (TextView)findViewById(R.id.question);

        radiogroup = (RadioGroup)findViewById(R.id.radiogroup);

        quenum=(TextView)findViewById(R.id.questionNo);
       // score=(TextView)findViewById(R.id.questionScore);

        rbtn1 = (RadioButton)findViewById(R.id.radio1);
        rbtn2 = (RadioButton)findViewById(R.id.radio2);
        rbtn3 = (RadioButton)findViewById(R.id.radio3);
        rbtn4 = (RadioButton)findViewById(R.id.radio4);


        ConstValue.correct_ans = 0;

        QuestionPojo qPojo1 = new QuestionPojo("1","Which track included Brabham Straight, Surtees, Dingle Dell and Clark Curve?","Brands Hatch","Aintree","Silverstone","Donington","Brands Hatch");
        QuestionPojo qPojo2 = new QuestionPojo("2","A track made from existing roads, with a tunnel, a curve by a casino, and a swimming pool, has made this a most popular venue for F1.","Kyalami","Phoenix","Adelaide","Monaco","Monaco");
        QuestionPojo qPojo3 = new QuestionPojo("3","Built in 1922 as a road course, the banking was last used in the tragic 1961 race.","Zandvoort","Monza","Monsanto","Bremgarten","Monza");
        QuestionPojo qPojo4 = new QuestionPojo("4","Jackie Stewart called it \"the Green Hell\"; Niki Lauda was severely burned in an accident here in 1976.","Nurburgring","Imola","Osterreichring","Hockenheim","Nurburgring");
        QuestionPojo qPojo5 = new QuestionPojo("5","Including sections of the RN138 and the RN840 roads, the wooded section of this track ran down to a hairpin curve.","Rouen-les-Essarts","Dijon-Prenois","Clermont-Ferrand"," Paul Ricard","Rouen-les-Essarts");
        QuestionPojo qPojo6 = new QuestionPojo("6","Graham Hill won here almost as often as he did at Monaco, yet it was here where he shattered his legs in an accident, hastening his decline.","Zandvoort","Watkins Glen","Spa Francorchamps","Estoril","Watkins Glen");
        QuestionPojo qPojo7 = new QuestionPojo("7","Home to races from 1970 to 1987, this very fast track included curves called Hella-Licht and Sebringkurve.","Zeltweg","Hockenheim","Osterreichring","A-1 ring","Osterreichring");
        QuestionPojo qPojo8 = new QuestionPojo("8","With unpredictable weather, drivers can go from a dry start into a sudden wall of spray; In 1982 the track was redesigned.","Montreal","Hockenheim","Spa Francorchamps","Imola","Spa Francorchamps");
        QuestionPojo qPojo9 = new QuestionPojo("9","Between 1950 and 1990, which American track hosted the greatest number of Grands Prix?","Indianapolis","Sebring"," Long Beach","Watkins Glen","Watkins Glen");
        QuestionPojo qPojo10 = new QuestionPojo("10","At which course was Ayrton Senna killed?","Hungaroring","Imola","Suzuka","Barcelona","Imola");





        questionList.add(qPojo1);
        questionList.add(qPojo2);
        questionList.add(qPojo3);
        questionList.add(qPojo4);
        questionList.add(qPojo5);
        questionList.add(qPojo6);
        questionList.add(qPojo7);
        questionList.add(qPojo8);
        questionList.add(qPojo9);
        questionList.add(qPojo10);


        setRandomQuesList();

        setQuiz(counter);

        rbtn1.setOnClickListener(this);
        rbtn2.setOnClickListener(this);
        rbtn3.setOnClickListener(this);
        rbtn4.setOnClickListener(this);
    }


    private void setQuiz(int position) {
        QuestionPojo que =random_list.get(position);
        quenum.setText(String.valueOf(counter+1)+"/5");
        txtQue.setText(que.getQuestion());
        rbtn1.setText(que.getOption1());
        rbtn2.setText(que.getOption2());
        rbtn3.setText(que.getOption3());
        rbtn4.setText(que.getOption4());
    }

    private void setRandomQuesList() {

        for (int i = 0; i < 10; i++) {
            int n = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                n = ThreadLocalRandom.current().nextInt(0, 10);
            }
            generate_list.add(n);
        }

        for (int i = 0; i < 5; i++) {

            //Log.e("", "*********" + generated.toArray()[i]);

            random_list.add(questionList.get((Integer) generate_list.toArray()[i]));
        }

    }


    public void next(){
        reset();
        if (counter < 4) {
            counter++;
            setQuiz(counter);
        }else {
            //finalResult();

            Intent i=new Intent(QuizActivity.this,Dialogbox.class);
            startActivity(i);
        }
        //
        // score.setText("Score :"+String.valueOf(ConstValue.correct_ans));
    }


    private void reset() {
        radiogroup.clearCheck();
    }

    public void matchAns(int position, String ans){
        QuestionPojo que =  random_list.get(position);
        if (ans.equalsIgnoreCase(que.getCorrectAns())){
            ConstValue.correct_ans++;
        }
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.radio1)
        {

            String answer = rbtn1.getText().toString();
            matchAns(counter,answer);
            rbtn1.setChecked(false);
            new DoInBack().execute();

        }
        else if(view.getId() == R.id.radio2)
        {
            String answer = rbtn2.getText().toString();
            matchAns(counter,answer);
            rbtn2.setChecked(false);
            new DoInBack().execute();
        }
        else if(view.getId() == R.id.radio3)
        {
            String answer = rbtn3.getText().toString();
            matchAns(counter,answer);
            rbtn3.setChecked(false);
            new DoInBack().execute();
        }
        else if(view.getId() == R.id.radio4)
        {
            String answer = rbtn4.getText().toString();
            matchAns(counter,answer);
            rbtn4.setChecked(false);
            new DoInBack().execute();
        }
    }


    class DoInBack extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(QuizActivity.this);
            pDialog.setMessage("Please Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {



            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            next();
            pDialog.dismiss();
        }
    }
}


