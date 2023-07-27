package com.example.test2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.test2.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class AutoCompleteActivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView autoCompleteTextView;
    private boolean isShow = true;
    private String[] s = {"10000","10086","10010","120"};
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        List list = Arrays.asList(s);
        autoCompleteTextView = findViewById(R.id.textComplete);
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);

        autoCompleteTextView.setAdapter(adapter);
        textInputLayout = findViewById(R.id.testBox);
//        autoCompleteTextView.setDropDownBackgroundResource(R.color.white);

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!list.contains(charSequence.toString())){
                    textInputLayout.setError("信息填写错误");
                }else textInputLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
//        textInputLayout.setEndIconOnClickListener(view -> {
//            isShow = !isShow;
//            if(!isShow)
//            {
//                autoCompleteTextView.showDropDown();
//            }
//            else autoCompleteTextView.dismissDropDown();
//        });
        TextInputLayout prefix = findViewById(R.id.prefix);
        AutoCompleteTextView prefixText = findViewById(R.id.prefix_text);

    }
}