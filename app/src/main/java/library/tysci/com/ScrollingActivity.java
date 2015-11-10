package library.tysci.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.linde.library.activity.NetChangeActivity;
import com.linde.library.enum_.NetState;
import com.linde.library.utils.FindViewByIdUtils;

public class ScrollingActivity extends NetChangeActivity
{
    private final static int FRAGMENT_ID = R.id.fragment1;
    private Toolbar toolbar = null;
    private FloatingActionButton fab = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        FindViewByIdUtils.injectAllFields(this);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addFragment(FRAGMENT_ID, new TestFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void netChange(NetState state)
    {
        switch (state)
        {
        case NET_NO:
            mLogUtils.i("NET_NO");
            break;
        case NET_MOBILE:
            mLogUtils.i("NET_MOBILE");
            break;
        case NET_WIFI:
            mLogUtils.i("NET_WIFI");
            break;
        }
    }
}
