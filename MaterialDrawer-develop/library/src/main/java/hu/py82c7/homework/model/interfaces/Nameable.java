package hu.py82c7.homework.model.interfaces;

import hu.py82c7.homework.holder.StringHolder;

/**
 * Created by mikepenz on 03.02.15.
 */
public interface Nameable<T> {
    T withName(String name);

    T withName(int nameRes);

    T withName(StringHolder name);

    StringHolder getName();
}
