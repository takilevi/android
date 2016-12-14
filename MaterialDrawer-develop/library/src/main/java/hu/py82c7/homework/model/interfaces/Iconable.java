package hu.py82c7.homework.model.interfaces;

import android.graphics.drawable.Drawable;

import com.mikepenz.iconics.typeface.IIcon;
import hu.py82c7.homework.holder.ImageHolder;

/**
 * Created by mikepenz on 03.02.15.
 */
public interface Iconable<T> {
    T withIcon(Drawable icon);

    T withIcon(IIcon iicon);

    T withIcon(ImageHolder icon);

    ImageHolder getIcon();
}
