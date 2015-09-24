package se.chalmers.agumentedexploration.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import se.chalmers.agumentedexploration.R;

/**
 * Created by richard on 24/09/15.
 */
public class ToolbarActivity extends AppCompatActivity {


    private Toolbar toolbarView;


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setup();
    }

    private void setup() {
        toolbarView = (Toolbar)findViewById(R.id.toolbar);
        if (toolbarView == null)
        {
            throw new IllegalStateException ("have you forgot to include the toolbar in your layout? Add a view with id toolbar");
        }
        setSupportActionBar(toolbarView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public Toolbar getToolbar(){
        return toolbarView;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setup();

    }
}