package hu.py82c7.homework.model.interfaces;

import hu.py82c7.homework.holder.StringHolder;

/**
 * Created by mikepenz on 03.02.15.
 */
public interface Badgeable<T> {
    T withBadge(String badge);

    T withBadge(int badgeRes);

    T withBadge(StringHolder badgeRes);

    StringHolder getBadge();
}
