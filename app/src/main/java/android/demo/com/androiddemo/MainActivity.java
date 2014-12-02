package android.demo.com.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Intent mCircleIntent;
    EditText mImagePathEditText;

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

        final Toast EditTextToast = Toast.makeText(this, "Type the url of an image", Toast.LENGTH_SHORT);
        mImagePathEditText = (EditText)findViewById(R.id.imagePathEditText);
        mImagePathEditText.setOnLongClickListener(new View.OnLongClickListener() { // tooltip implementation
            @Override
            public boolean onLongClick(View v) {
                EditTextToast.show();
                return false;
            }
        });

        mCircleIntent = new Intent(this, CircleActivity.class);

        //Add an event listener to the button
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Raise an Intent to the android system to move us to the next activity
                mCircleIntent.putExtra("imagePath", mImagePathEditText.getText().toString());
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
