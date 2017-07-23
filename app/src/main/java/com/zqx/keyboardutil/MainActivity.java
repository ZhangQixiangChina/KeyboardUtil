package com.zqx.keyboardutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements KeyboardUtil.KeyBoardListener {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.et)
    EditText mEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        KeyboardUtil.listenKeyboard(this, this);

    }

    @OnClick(R.id.root)
    public void onEmptyClick() {//点击空白处收起键盘
        KeyboardUtil.hideKeyboard(this);
    }

    @Override
    public void onKeyboardChange(boolean isShow, int keyboardHeight) {
        String kbState = isShow ? "弹出" : "收起";
        mTv.setText(
                "当前键盘状态: " + kbState + "\n" +
                        "键盘高度: " + keyboardHeight + "px"
        );
    }
}
