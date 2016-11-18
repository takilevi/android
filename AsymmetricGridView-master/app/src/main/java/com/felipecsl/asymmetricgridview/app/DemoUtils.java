package com.felipecsl.asymmetricgridview.app;

import com.felipecsl.asymmetricgridview.app.model.DemoItem;

import java.util.ArrayList;
import java.util.List;

final class DemoUtils {
  int currentOffset;

  DemoUtils() {
  }

  public List<DemoItem> moarItems() {
    List<DemoItem> items = new ArrayList<>();


    DemoItem item1 = new DemoItem(1, 3, currentOffset + 0);
    items.add(item1);
    DemoItem item2 = new DemoItem(1, 1, currentOffset + 1);
    items.add(item2);
    DemoItem item3 = new DemoItem(1, 2, currentOffset + 2);
    items.add(item3);
    DemoItem item4 = new DemoItem(1, 1, currentOffset + 3);
    items.add(item4);
    DemoItem item5 = new DemoItem(1, 2, currentOffset + 4);
    items.add(item5);
    DemoItem item6 = new DemoItem(2, 1, currentOffset + 5);
    items.add(item6);
    DemoItem item7 = new DemoItem(1, 1, currentOffset + 6);
    items.add(item7);

    currentOffset += 7;

    return items;
  }
  public List<DemoItem> plusoneItem(){
    double rand = Math.random();
    List<DemoItem> items = new ArrayList<>();
    if(rand<0.2f) {

      DemoItem item1 = new DemoItem(1, 1, currentOffset + 0);
      items.add(item1);
      currentOffset += 1;
    }
    else if(rand>0.2f && rand<0.4f){
      DemoItem item2 = new DemoItem(1, 2, currentOffset + 0);
      items.add(item2);
      currentOffset += 1;
    }
    else if(rand>0.4f&&rand<0.6f){
      DemoItem item3 = new DemoItem(2, 1, currentOffset + 0);
      items.add(item3);
      currentOffset += 1;

    }
    else if(rand>0.6f&&rand<0.8f){
      DemoItem item4 = new DemoItem(2, 2, currentOffset + 0);
      items.add(item4);
      currentOffset += 1;

    }
    else{
      DemoItem item5 = new DemoItem(2, 3, currentOffset + 0);
      items.add(item5);
      currentOffset += 1;

    }


    return items;
  }

  //public void addOrdertoTable(DemoItem table, OrderItem order){}
}
