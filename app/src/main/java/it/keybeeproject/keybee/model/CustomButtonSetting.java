package it.keybeeproject.keybee.model;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import it.keybeeproject.keybee.R;

public class CustomButtonSetting {
    public int idx;
    public Spinner spinner;
    public ArrayAdapter<String> adapter;
    // Long press or short press
    boolean longPress;
    public TextView textView;
    public ButtonAction buttonAction;

    public CustomButtonSetting(int idx,
                               boolean isOnTop,
                               int buttonNumber,
                               boolean longPress,
                               Context context,
                               Spinner spinner,
                               TextView textView
//                               ButtonAction buttonAction
                               ) {
        this.idx = idx;
        this.spinner = spinner;
        this.adapter = new ArrayAdapter<>(context, R.layout.text_spinner, ButtonAction.LABELS);
        this.spinner.setAdapter(this.adapter);
        this.textView = textView;
        this.longPress = longPress;
//        this.buttonAction = buttonAction;
    }
}
