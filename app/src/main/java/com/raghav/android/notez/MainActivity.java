package com.raghav.android.notez;

import android.os.Bundle;

public class MainActivity extends SingleFrameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);
    }
}
