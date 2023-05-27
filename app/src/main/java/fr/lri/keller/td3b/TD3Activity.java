package fr.lri.keller.td3b;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TD3Activity extends AppCompatActivity {

    public final static String EXTRA_LEVEL = "EXTRA_LEVEL";
    public final static String EXTRA_LAUNCHES = "EXTRA_LAUNCHES";
    public final static String EXTRA_SIZE = "EXTRA_SIZE";

    public final static int NUMBER_OF_LAUNCHES_REQUEST = 1;
    public final static int SIZE_REQUEST = 2;

    private TextView scoreT;
    private TextView scoreV;
    private TextView levelT;
    private TextView levelV;
    private TextView lnumberT;
    private TextView lnumberV;

    private int score = 0;
    private int level = 1;
    private int launches = 0;

    public final static int SMALL_SIZE = 14;
    public final static int MEDIUM_SIZE = 18;
    public final static int LARGE_SIZE = 22;
    public final static int DEFAULT_SIZE = LARGE_SIZE;
    private int size = LARGE_SIZE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td3);
        scoreT = (TextView) findViewById(R.id.scoreT);
        scoreV = (TextView) findViewById(R.id.scoreV);
        levelT = (TextView) findViewById(R.id.levelT);
        levelV = (TextView) findViewById(R.id.levelV);
        lnumberT = (TextView) findViewById(R.id.lnumberT);
        lnumberV = (TextView) findViewById(R.id.lnumberV);
        lnumberV.setText(launches + "");

        System.out.println("TD3Activity.onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("TD3Activity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("TD3Activity.onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("TD3Activity.onRestart");
    }

    @Override
    protected void onPause() {
        System.out.println("TD3Activity.onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("TD3Activity.onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("TD3Activity.onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_td3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra(EXTRA_SIZE, size);
            startActivityForResult(intent, SIZE_REQUEST);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click(View v) {
        score++;
        scoreV.setText(score + "");
        if (score % 5 == 0) {
            level++;
            levelV.setText(level + "");
            Intent intent = new Intent(this, LevelActivity.class);
            intent.putExtra(EXTRA_LEVEL, level);
            intent.putExtra(EXTRA_SIZE, size);
            startActivityForResult(intent, NUMBER_OF_LAUNCHES_REQUEST);
        }
    }

    public void init(View v) {
        score = 0; level = 1;
        scoreV.setText(score + "");
        levelV.setText(level + "");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NUMBER_OF_LAUNCHES_REQUEST) {
                launches = data.getIntExtra(EXTRA_LAUNCHES, 0);
                lnumberV.setText(launches + "");
            }
            size = data.getIntExtra(EXTRA_SIZE, size);
            scoreT.setTextSize(size);
            scoreV.setTextSize(size);
            levelT.setTextSize(size);
            levelV.setTextSize(size);
            lnumberT.setTextSize(size);
            lnumberV.setTextSize(size);
        }
    }
}
