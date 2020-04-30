package ysn.com.demo.behavior.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ysn.com.demo.behavior.R;

/**
 * @Author yangsanning
 * @ClassName FollowUpActivity
 * @Description 控件跟随控件移动
 * @Date 2020/4/30
 */
public class FollowUpActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView textView;
    private int x;
    private int y;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up);
        textView = findViewById(R.id.follow_up_activity_drag);
        textView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = (int) event.getRawX();
                y = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                int dx = x - this.x;
                int dy = y - this.y;
                int l = textView.getLeft();
                int r = textView.getRight();
                int t = textView.getTop();
                int b = textView.getBottom();
                textView.layout(l + dx, t + dy, r + dx, b + dy);
                this.x = (int) event.getRawX();
                this.y = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
        }
        return true;
    }
}
