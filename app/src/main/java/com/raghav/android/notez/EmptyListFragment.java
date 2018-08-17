package com.raghav.android.notez;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EmptyListFragment extends Fragment {
    private static final String TAG = "NoteZ";
    private Button mAddButton;
    private TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.empty_list_layout,container,false);
        Log.d(TAG,"in fragment onCreateView()");

        mAddButton = (Button)v.findViewById(R.id.add_button);
        mTextView =(TextView) v.findViewById(R.id.textView);
        mTextView.setText(R.string.empty_list_message);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                Fragment fg = fm.findFragmentById(R.id.fragment_container);
                if(fg!= null){
                    fm.beginTransaction().detach(fg).commit();
                }
                fg= NoteListFragment.newInstance();
                fm.beginTransaction().add(R.id.fragment_container,fg).commit();
            }
        });

        return v;
    }
    public static EmptyListFragment newInstance(){
        return new EmptyListFragment();
    }
}
