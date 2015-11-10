package library.tysci.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linde.library.utils.FindViewByIdUtils;

/**
 * @author LinDe
 */
public class TestFragment extends Fragment
{
    private TextView textView1 = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        FindViewByIdUtils.injectAllFields(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        textView1.setText("哈哈哈哈啊哈哈哈哈哈啊哈哈啊哈哈");
    }
}
