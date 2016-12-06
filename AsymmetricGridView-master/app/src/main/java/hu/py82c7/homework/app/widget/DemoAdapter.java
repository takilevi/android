package hu.py82c7.homework.app.widget;

import android.widget.ListAdapter;

import hu.py82c7.homework.app.model.DemoItem;

import java.util.List;

public interface DemoAdapter extends ListAdapter {

  void appendItems(List<DemoItem> newItems);

  void setItems(List<DemoItem> moreItems);
}
