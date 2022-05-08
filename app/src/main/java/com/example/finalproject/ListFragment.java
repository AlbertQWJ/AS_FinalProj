package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private ListAdapter ListAdapter;
    private List<Book> bookList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        initBooks();
        ListAdapter = new ListAdapter(getActivity(), R.layout.list_item, bookList);
        ListView listView = view.findViewById(R.id.listfragment_list);
        listView.setAdapter(ListAdapter);

        return view;
    }

    private void initBooks() {
        Book MyApplication = new Book(R.mipmap.ic_launcher, "3389-应用开发期末大作业", "裘伟杰", "2022", "1923028");
        bookList.add(MyApplication);
        Book book1 = new Book(R.drawable.book1, "丰乳肥臀", "莫言", "1995", "作家出版社");
        bookList.add(book1);
        Book book2 = new Book(R.drawable.book2, "猫头鹰王国", "凯瑟琳·拉丝基", "2012", "湖北少儿出版社");
        bookList.add(book2);
        Book book3 = new Book(R.drawable.book3, "城南旧事", "林海音", "1960", "光启出版社");
        bookList.add(book3);
        Book book4 = new Book(R.drawable.book4, "老人与海", "海明威", "1951", "天津出版传媒集团");
        bookList.add(book4);
        Book book5 = new Book(R.drawable.book5, "傲慢与偏见", "简·奥斯汀", "1813", "上海译文出版社");
        bookList.add(book5);
        Book book6 = new Book(R.drawable.book6, "围城", "钱钟书", "1947", "上海晨光");
        bookList.add(book6);
        Book book7 = new Book(R.drawable.book7, "活着", "余华", "1992", "长江文艺出版社");
        bookList.add(book7);
        Book book8 = new Book(R.drawable.book8, "瓦尔登湖", "亨利·戴维·梭罗", "1978", "今日世界出版社");
        bookList.add(book8);
        Book book9 = new Book(R.drawable.book9, "雷雨", "曹禺", "1934", "文学季刊");
        bookList.add(book9);
        Book book10 = new Book(R.drawable.book10, "茶花女", "小仲马", "1979", "江西人民出版社");
        bookList.add(book10);
        Book book11 = new Book(R.drawable.book11, "简·爱 ", "夏洛蒂·勃朗特", "1980", "上海译文出版社");
        bookList.add(book11);
        Book book12 = new Book(R.drawable.book12, "四世同堂", "老舍", "1944", "扫荡报");
        bookList.add(book12);
    }
}
