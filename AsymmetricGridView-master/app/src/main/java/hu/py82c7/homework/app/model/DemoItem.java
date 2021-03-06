package hu.py82c7.homework.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import hu.py82c7.homework.AsymmetricItem;

public class DemoItem implements AsymmetricItem {
  private int columnSpan;
  private int rowSpan;
  private int position;
  private int chairs;

  public DemoItem() {
    this(1, 1, 0);
  }

  public DemoItem(int columnSpan, int rowSpan, int position) {
    this.columnSpan = columnSpan;
    this.rowSpan = rowSpan;
    this.position = position;
    chairs = 2*rowSpan + 2*columnSpan;
  }

  public DemoItem(Parcel in) {
    readFromParcel(in);
  }

  @Override public int getColumnSpan() {
    return columnSpan;
  }

  @Override public int getRowSpan() {
    return rowSpan;
  }

  public int getPosition() {
    return position;
  }
  public int getChairs() {
    return chairs;
  }

  @Override public String toString() {
    return String.format("%s: %sx%s %s", position, rowSpan, columnSpan,chairs);
  }

  @Override public int describeContents() {
    return 0;
  }

  private void readFromParcel(Parcel in) {
    columnSpan = in.readInt();
    rowSpan = in.readInt();
    position = in.readInt();
    chairs = in.readInt();
  }

  @Override public void writeToParcel(@NonNull Parcel dest, int flags) {
    dest.writeInt(columnSpan);
    dest.writeInt(rowSpan);
    dest.writeInt(position);
    dest.writeInt(chairs);
  }

  /* Parcelable interface implementation */
  public static final Parcelable.Creator<DemoItem> CREATOR = new Parcelable.Creator<DemoItem>() {
    @Override public DemoItem createFromParcel(@NonNull Parcel in) {
      return new DemoItem(in);
    }

    @Override @NonNull public DemoItem[] newArray(int size) {
      return new DemoItem[size];
    }
  };
}
