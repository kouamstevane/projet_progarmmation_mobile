package fr.lri.keller.td3b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioGroupSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        radioGroupSize = (RadioGroup) findViewById(R.id.radioGroupSize);

        Intent intent = getIntent();
        switch (intent.getIntExtra(TD3Activity.EXTRA_SIZE, TD3Activity.DEFAULT_SIZE)) {
            case TD3Activity.SMALL_SIZE:
                radioGroupSize.check(R.id.radioButtonSmall);
                break;
            case TD3Activity.MEDIUM_SIZE:
                radioGroupSize.check(R.id.radioButtonMedium);
                break;
            case TD3Activity.LARGE_SIZE:
                radioGroupSize.check(R.id.radioButtonLarge);
                break;
            default:
                radioGroupSize.check(R.id.radioButtonLarge);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void chooseTextSize(View view) {
        Intent data = new Intent();
        switch (view.getId()) {
            case R.id.radioButtonSmall:
                data.putExtra(TD3Activity.EXTRA_SIZE, TD3Activity.SMALL_SIZE);
                break;
            case R.id.radioButtonMedium:
                data.putExtra(TD3Activity.EXTRA_SIZE, TD3Activity.MEDIUM_SIZE);
                break;
            case R.id.radioButtonLarge:
                data.putExtra(TD3Activity.EXTRA_SIZE, TD3Activity.LARGE_SIZE);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, data);
        finish();
    }
}
