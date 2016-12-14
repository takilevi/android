package hu.homework.login;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;


public class MainActivity extends ActionBarActivity {

    private TextView nyitoszoveg;
    public static int admin = 0;
    public static String email = "proba@senki.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        nyitoszoveg= (TextView)findViewById(R.id.hellotext);
        nyitoszoveg.setText("na itt a mailcim: "+email+"itt meg az adminszint: "+admin);
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
