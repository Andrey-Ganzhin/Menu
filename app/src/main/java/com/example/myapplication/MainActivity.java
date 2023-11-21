package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu.getClass().getSimpleName()
                .equals("MenuBuilder")){
            try{
                Method m = menu.getClass()
                        .getDeclaredMethod (
                                "setOptionalIconsVisible",
                                Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = findViewById(R.id.selectedMenuItem);
        switch(id){
            case R.id.call_settings :
                headerView.setText("Вы вклю чили Call");
                return true;
            case R.id.camera_settings:
                headerView.setText("Вы включили Camera");
                return true;
            case R.id.video_settings:
                headerView.setText("Вы включили Video");
                return true;
            case R.id.email_settings:
                headerView.setText("Вы включили Email");
                return true;
            case R.id.add_settings:
                headerView.setText("Вы включили Add");
                return true;
            case R.id.copy_settings:
                headerView.setText("Вы включили Copy");
                return true;
            case R.id.paste_settings:
                headerView.setText("Вы включили Paste");
                return true;
            case R.id.help_settings:
                headerView.setText("Вы включили Help");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
