package fr.lri.keller.td3b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {

    private TextView levelT;
    private TextView levelV;
    private TextView lnumberT;
    private TextView lnumberV;

    private static int lnumber = 0;
    private int size = TD3Activity.DEFAULT_SIZE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        levelT = (TextView) findViewById(R.id.levelT);
        levelV = (TextView) findViewById(R.id.levelV);
        lnumberT = (TextView) findViewById(R.id.lnumberT);
        lnumberV = (TextView) findViewById(R.id.lnumberV);

        Intent intent = getIntent();

        int level = intent.getIntExtra(TD3Activity.EXTRA_LEVEL, 1);
        levelV.setText(level + "");

        size = intent.getIntExtra(TD3Activity.EXTRA_SIZE, TD3Activity.DEFAULT_SIZE);
        setTextSize();

        lnumber++;
        lnumberV.setText(lnumber + "");

        System.out.println("LevelActivity.onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("LevelActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("LevelActivity.onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("LevelActivity.onRestart");
    }

    @Override
    protected void onPause() {
        System.out.println("LevelActivity.onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("LevelActivity.onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("LevelActivity.onDestroy");
        super.onDestroy();
    }

    @Override
    public void finish() {
        System.out.println("LevelActivity.finish");
        Intent data = new Intent();
        data.putExtra(TD3Activity.EXTRA_LAUNCHES, lnumber);
        data.putExtra(TD3Activity.EXTRA_SIZE, size);
        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level, menu);
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
            intent.putExtra(TD3Activity.EXTRA_SIZE, size);
            startActivityForResult(intent, TD3Activity.SIZE_REQUEST);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void back(View v) {
        finish();
    }

    private void setTextSize() {
        levelT.setTextSize(size);
        levelV.setTextSize(size);
        lnumberT.setTextSize(size);
        lnumberV.setTextSize(size);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            size = data.getIntExtra(TD3Activity.EXTRA_SIZE, size);
            setTextSize();
        }
    }

}
