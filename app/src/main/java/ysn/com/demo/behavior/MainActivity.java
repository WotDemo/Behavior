package ysn.com.demo.behavior;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ysn.com.demo.behavior.page.BehaviorActivity;
import ysn.com.demo.behavior.page.FollowUpActivity;

/**
 * @Author yangsanning
 * @ClassName MainActivity
 * @Description 一句话概括作用
 * @Date 2020/4/29
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout rootView = findViewById(R.id.main_activity_root);
        for (int i = 0; i < rootView.getChildCount(); i++) {
            rootView.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_avatar_behavior:
                startActivity(BehaviorActivity.class);
                break;
            case R.id.main_activity_follow_up_behavior:
                startActivity(FollowUpActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
