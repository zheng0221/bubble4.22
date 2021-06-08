package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;
//discarded
public class ActivityHuanzheShouye extends AppCompatActivity {
    public static LottieAnimationView bubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanzhe_shouye);

        bubble=findViewById(R.id.bubble);
        bubble.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                showBottomDialog();
            }
        });
    }


    public  abstract static class DoubleClickListener implements View.OnClickListener {
        private static final long DOUBLE_TIME = 1000;
        private static long lastClickTime = 0;

        @Override
        public void onClick(View v) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < DOUBLE_TIME) {
                onDoubleClick(v);
            }
            lastClickTime = currentTimeMillis;
        }

        public abstract void onDoubleClick(View v);
    }

    private void showBottomDialog() {
        //1、使用Dialog、设置style
        final Dialog editbubbledialog = new Dialog(this, R.style.eidt_bubble_dialog);
        //2、设置布局
        View view = View.inflate(this, R.layout.edit_bubble_dialog, null);
        editbubbledialog.setContentView(view);

        Window window = editbubbledialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.dialogstyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editbubbledialog.show();
        SeekBar seekBar_v = (SeekBar)view.findViewById(R.id.seekBar_v);
        seekBar_v.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress){
                    case 10:
                        Log.e("1", "1");
                        ActivityHuanzheShouye.bubble.setAnimation(".lottie1/1_1.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 30:
                        Log.e("2", "2");
                        ActivityHuanzheShouye.bubble.setAnimation("2/1_2.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 50:
                        Log.e("3", "3");
                        ActivityHuanzheShouye.bubble.setAnimation("3/1_3.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 80:
                        ActivityHuanzheShouye.bubble.setAnimation("4/1_4.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 100:
                        ActivityHuanzheShouye.bubble.setAnimation("5/1_5.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //触碰SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //放开SeekBar
            }
        });

        editbubbledialog.findViewById(R.id.edit_bubble_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("finish", "finish");
                editbubbledialog.dismiss();
            }
        });

    }


}