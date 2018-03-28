package com.englishdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Bean.English_Book;
import com.englishdemo.R;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private List<English_Book.BooksBean> books;
    private Context context = null;
    private LayoutInflater inflater = null;

    public BookAdapter (List<English_Book.BooksBean> list, Context context){

        this.books = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.book_item, null);
            viewHolder.book_name = (TextView) view.findViewById(R.id.book_name);
            viewHolder.press_name = (TextView) view.findViewById(R.id.book_grade);
            viewHolder.book_version_name = (TextView) view.findViewById(R.id.book_version_name);
            view.setTag(viewHolder);// 通过setTag将ViewHolder和view绑定
        }  else {
            viewHolder = (ViewHolder) view.getTag(); // 获取，通过ViewHolder找到相应的控件
        }
        English_Book.BooksBean booksBean = books.get(i);
        viewHolder.book_name.setText(booksBean.getName());
        viewHolder.press_name.setText(booksBean.getPress_name());
        viewHolder.book_version_name.setText(booksBean.getVersion_name());
        return view;
    }

    class ViewHolder {
        TextView book_name;
        TextView press_name;
        TextView book_version_name;
    }
}
