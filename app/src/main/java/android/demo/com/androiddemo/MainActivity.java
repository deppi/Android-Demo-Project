package android.demo.com.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Intent mCircleIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //1. *****************************************************
        //Set the xml view that will be used for this activity
        setContentView(R.layout.activity_main);
        //********************************************************

        //2. *****************************************************
        //Obtain the button instance from the view
        Button btnStart = (Button)findViewById(R.id.start);

        mCircleIntent = new Intent(this, CircleActivity.class);
        mCircleIntent.putExtra("imagePath", "http://www.bikesarena.com/wp-content/uploads/2013/11/Funny-Laughing-Meme-3-231x300.png");

        //Add an event listener to the button
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Raise an Intent to the android system to move us to the next activity
                startActivity(mCircleIntent);
            }
        });
        //*********************************************************
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
