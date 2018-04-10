package quizapp.wiss.com.douknw;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainCategoryActivity extends ActionBarActivity {
    /** Called when the activity is first created. */

    private GridviewAdapter mAdapter;
    private ArrayList<String> listCountry;
    private ArrayList<Integer> listFlag;

    private GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_category);

        prepareList();

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new GridviewAdapter(MainCategoryActivity.this,listCountry, listFlag);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(mAdapter);

        // Implement On Item click listener
        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {

                String value = mAdapter.getItem(position);
              //  Toast.makeText(MainCategoryActivity.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainCategoryActivity.this,QuizActivity.class);
                i.putExtra("category_name",value);
                startActivity(i);
            }
        });

    }

    public void prepareList()
    {
        listCountry = new ArrayList<String>();

      /*  listCountry.add("General Aptitude");
        listCountry.add("Verbal Reasoning");
        listCountry.add("Interview");
        listCountry.add("Puzzles");
        listCountry.add("Gen. Knowledge");
        listCountry.add("Engineering");
        listCountry.add("Programming");
        listCountry.add("Medical/Science");

        listFlag = new ArrayList<Integer>();
        listFlag.add(R.drawable.general_apptitude);
        listFlag.add(R.drawable.reasoning);
        listFlag.add(R.drawable.interview);
        listFlag.add(R.drawable.puzzles);
        listFlag.add(R.drawable.gk);
        listFlag.add(R.drawable.engineering);
        listFlag.add(R.drawable.programing);
        listFlag.add(R.drawable.medical);*/

    }
}