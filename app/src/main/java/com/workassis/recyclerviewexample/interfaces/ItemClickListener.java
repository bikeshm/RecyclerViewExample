package com.workassis.recyclerviewexample.interfaces;

import android.view.View;

public interface  ItemClickListener {
    void onClick(View view, int position);
    void onLongClickListener(View view, int position);
}
