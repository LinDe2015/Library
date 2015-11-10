package com.linde.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.linde.library.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LinDe on 2015/11/9.
 * Wrap {@link android.support.v7.widget.RecyclerView.Adapter}
 */
public abstract class BaseRecyclerAdapter<Bean, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter
{
    private final static int TYPE_HEADER = 0x1;
    private final static int TYPE_ITEM = 0x2;
    private final static int TYPE_FOOT = 0x3;

    public final LogUtils mLogUtils;
    public final Context context;
    protected List<Bean> list;
    public final List<View> mHeaderViews, mFootViews;
    private int headerPosition, footPosition;

    public BaseRecyclerAdapter(Context context, List<Bean> list)
    {
        mLogUtils = new LogUtils(this.getClass());
        this.context = context;
        this.list = list;
        this.mHeaderViews = new ArrayList<>();
        this.mFootViews = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        switch (viewType)
        {
        case TYPE_HEADER:
            return new RecyclerView.ViewHolder(mHeaderViews.get(headerPosition)) {};
        case TYPE_ITEM:
            return onCreateViewHolder(context, parent);
        case TYPE_FOOT:
            return new RecyclerView.ViewHolder(mFootViews.get(footPosition)) {};
        }
        mLogUtils.e("viewType Error");
        return null;
    }

    protected abstract VH onCreateViewHolder(Context context, ViewGroup parent);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (isHeaderView(position) || isFootView(position)) return;
        //noinspection unchecked
        final VH vh = (VH) holder;
        final int pos = position - mHeaderViews.size();
        onBindViewHolder(vh, list.get(pos), pos);
    }

    protected abstract void onBindViewHolder(VH vh, Bean bean, int position);

    protected void setList(List<Bean> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position)
    {
        if (isHeaderView(position))
        {
            headerPosition = position;
            mLogUtils.i("第" + headerPosition + "个头部布局");
            return TYPE_HEADER;
        }
        if (isFootView(position))
        {
            footPosition = position - (mHeaderViews.size() + (list == null ? 0 : list.size()));
            mLogUtils.i("第" + footPosition + "个底部布局");
            return TYPE_FOOT;
        }
        mLogUtils.i("创建Item");
        return TYPE_ITEM;
    }

    public boolean addHeaderView(View headerView)
    {
        if (headerView == null) return false;
        try
        {
            mHeaderViews.add(headerView);
            notifyDataSetChanged();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFootView(View footView)
    {
        if (footView == null) return false;
        try
        {
            mFootViews.add(footView);
            notifyDataSetChanged();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public void clearHeaderView() {mHeaderViews.clear();}

    public void clearFootView() {mFootViews.clear();}

    public boolean isHeaderView(int position) {return position < mHeaderViews.size();}

    public boolean isFootView(int position) {return position >= mHeaderViews.size() + (list == null ? 0 : list.size());}

    @Override
    public int getItemCount() {return mHeaderViews.size() + (list == null ? 0 : list.size()) + mFootViews.size();}
}
