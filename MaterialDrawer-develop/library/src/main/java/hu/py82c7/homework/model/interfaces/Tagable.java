package hu.py82c7.homework.model.interfaces;

/**
 * Created by mikepenz on 03.02.15.
 */
public interface Tagable<T> {
    T withTag(Object tag);

    Object getTag();
}