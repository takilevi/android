package hu.py82c7.homework.app.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import hu.py82c7.homework.app.model.DemoItem;

import java.util.List;

/**
 * Sample adapter implementation extending from AsymmetricGridViewAdapter<DemoItem> This is the
 * easiest way to get started.
 */
public class DefaultListAdapter extends ArrayAdapter<DemoItem> implements DemoAdapter {

  private final LayoutInflater layoutInflater;

  public DefaultListAdapter(Context context, List<DemoItem> items) {
    super(context, 0, items);
    layoutInflater = LayoutInflater.from(context);
  }

  public DefaultListAdapter(Context context) {
    super(context, 0);
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public View getView(int position, View convertView, @NonNull ViewGroup parent) {
    View v;

    DemoItem item = getItem(position);
    boolean isRegular = getItemViewType(position) == 0;

    if (convertView == null) {
      v = layoutInflater.inflate(
          isRegular ? hu.py82c7.homework.app.R.layout.adapter_item : hu.py82c7.homework.app.R.layout.adapter_item_odd, parent, false);
    } else {
      v = convertView;
    }

    TextView textView;
    if (isRegular) {
      textView = (TextView) v.findViewById(hu.py82c7.homework.app.R.id.textview);
    } else {
      textView = (TextView) v.findViewById(hu.py82c7.homework.app.R.id.textview_odd);
    }

    textView.setText("Table ID: "+String.valueOf(item.getPosition())+ "\n"+
            "Chairs belongs table: "+String.valueOf(item.getChairs()));

    return v;
  }

  @Override public int getViewTypeCount() {
    return 2;
  }

  @Override public int getItemViewType(int position) {
    return position % 2 == 0 ? 1 : 0;
  }

  public void appendItems(List<DemoItem> newItems) {
    addAll(newItems);
    notifyDataSetChanged();
  }

  public void setItems(List<DemoItem> moreItems) {
    clear();
    appendItems(moreItems);
  }
}