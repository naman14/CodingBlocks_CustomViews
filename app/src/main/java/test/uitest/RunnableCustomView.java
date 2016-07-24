package test.uitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naman on 24/07/16.
 */
public class RunnableCustomView extends View {

    float xPos = 0;
    Paint paint;


    private Runnable animateLine = new Runnable() {
        @Override
        public void run() {
            boolean reachedEnd = false;
            xPos = xPos + 10;

            if (xPos <= getWidth()) {
                invalidate();
            } else reachedEnd = true;

            if (!reachedEnd)
                postDelayed(this, 15);

        }
    };


    public RunnableCustomView(Context context) {
        super(context);
        init();
    }

    public RunnableCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        post(animateLine);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, getHeight() / 2, xPos, getHeight() / 2, paint);
    }
}
