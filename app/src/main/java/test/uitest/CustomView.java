package test.uitest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naman on 24/07/16.
 */
public class CustomView extends View {

    Paint paint;
    int color;
    float radius;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        this.color = ta.getColor(R.styleable.CustomView_circleColor, Color.BLUE);
        this.radius = ta.getDimension(R.styleable.CustomView_circleRadius, 200);
        ta.recycle();
        init();

    }

    public CustomView(Context context, AttributeSet atrs, int defStyle) {
        super(context, atrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setColor(int color) {
        paint.setColor(color);
        invalidate();
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }
}
