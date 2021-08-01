package com.pyc.empty;
/*
 * @product IntelliJ IDEA
 * @project Empty
 * @file MyTextView
 * @pack com.pyc.empty
 * @date 2021/8/1
 * @time 14:51
 * @author 御承扬
 * @E-mail 2923616405@qq.com
 **/

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/**
 * @author 彭友聪
 * @date 2021/8/1
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
