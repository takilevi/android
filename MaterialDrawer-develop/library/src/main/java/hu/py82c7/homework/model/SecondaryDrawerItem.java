package hu.py82c7.homework.model;

import android.content.Context;
import android.support.annotation.LayoutRes;

import hu.py82c7.homework.holder.ColorHolder;

/**
 * Created by mikepenz on 03.02.15.
 */
public class SecondaryDrawerItem extends AbstractBadgeableDrawerItem<SecondaryDrawerItem> {

    @Override
    public int getType() {
        return hu.py82c7.homework.R.id.material_drawer_item_secondary;
    }

    @Override
    @LayoutRes
    public int getLayoutRes() {
        return hu.py82c7.homework.R.layout.material_drawer_item_secondary;
    }

    /**
     * helper method to decide for the correct color
     * OVERWRITE to get the correct secondary color
     *
     * @param ctx
     * @return
     */
    @Override
    protected int getColor(Context ctx) {
        int color;
        if (this.isEnabled()) {
            color = ColorHolder.color(getTextColor(), ctx, hu.py82c7.homework.R.attr.material_drawer_secondary_text, hu.py82c7.homework.R.color.material_drawer_secondary_text);
        } else {
            color = ColorHolder.color(getDisabledTextColor(), ctx, hu.py82c7.homework.R.attr.material_drawer_hint_text, hu.py82c7.homework.R.color.material_drawer_hint_text);
        }
        return color;
    }
}
