package com.linde.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linde.library.utils.LogUtils;

import java.util.List;

/**
 * Created by LinDe on 2015/11/6.
 * Wrap {@link BaseAdapter}
 *
 * @param <Bean>
 * @param <VH>
 */
public abstract class BaseAdapterWrapper<Bean, VH extends BaseAdapterWrapper.ViewHolder> extends BaseAdapter
{
    public final LogUtils mLogUtils;
    public final Context mContext;
    protected List<Bean> mList;

    public BaseAdapterWrapper(Context context, List<Bean> list)
    {
        this.mContext = context;
        this.mList = list;
        mLogUtils = new LogUtils(this.getClass());
    }

    @Override
    public int getCount() {return 0;}

    @Override
    public Bean getItem(int position) {return mList.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        VH holder;
        if (convertView == null)
        {
            holder = onCreateViewHolder(LayoutInflater.from(mContext), parent, getItemViewType(position));
            convertView = holder.itemView;
            convertView.setTag(holder);
        } else
        {
            //noinspection unchecked
            holder = (VH) convertView.getTag();
        }
        try {onBindViewHolder(holder, getItem(position), position);}
        catch (Exception e) {e.printStackTrace();}
        return holder.itemView;
    }

    protected abstract void onBindViewHolder(VH holder, Bean bean, int position);

    protected abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType);

    public abstract static class ViewHolder
    {
        public final View itemView;

        public ViewHolder(View itemView) {this.itemView = itemView;}
    }
}
