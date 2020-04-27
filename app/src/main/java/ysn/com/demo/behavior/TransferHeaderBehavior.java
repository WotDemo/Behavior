package ysn.com.demo.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * @Author yangsanning
 * @ClassName TransferHeaderBehavior
 * @Description 改变头像位置的Behavior
 * @Date 2020/4/27
 */
public class TransferHeaderBehavior extends CoordinatorLayout.Behavior<ImageView> {

    /**
     * 处于中心时候原始X轴
     */
    private int originalX = 0;
    /**
     * 处于中心时候原始Y轴
     */
    private int originalY = 0;


    public TransferHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, @NonNull ImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull ImageView child, @NonNull View dependency) {
        // 计算X轴坐标
        if (originalX == 0) {
            this.originalX= dependency.getWidth() / 2 - child.getWidth() / 2;
        }
        // 计算Y轴坐标
        if (originalY == 0) {
            originalY = dependency.getHeight() - child.getHeight();
        }

        // X轴百分比
        float percentX = dependency.getY() / originalX;
        if (percentX >= 1) {
            percentX = 1;
        }

        // Y轴百分比
        float percentY = dependency.getY() / originalY;
        if (percentY >= 1) {
            percentY = 1;
        }

        float x = originalX - originalX * percentX;
        if (x <= child.getWidth()) {
            x = child.getWidth();
        }

        // 头像的放大和缩小
        child.setScaleX(1 - percentY/2);
        child.setScaleY(1 - percentY/2);

        child.setX(x);
        child.setY(originalY - originalY * percentY);
        return true;
    }
}
