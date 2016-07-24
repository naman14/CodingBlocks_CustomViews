package test.uitest;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomView customView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customView = (CustomView) findViewById(R.id.custom_view);
        textView = (TextView) findViewById(R.id.text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              customView.setRadius(400);
                startAnimation();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startAnimation() {
//        Animator animator = ObjectAnimator.ofFloat(textView, "translationX", 0f, 600f);
//        animator.setDuration(300);
//        animator.start();

//        Path path = new Path();
//        path.moveTo(0, 0);
//        path.lineTo(1200, 0);
//        path.lineTo(1200, 1200);
//        path.lineTo(0, 1200);
//        path.lineTo(0, 0);
//
//        ValueAnimator animator1 = ObjectAnimator.ofFloat(textView, "x", "y", path);
//        animator1.setDuration(1500);
//        animator1.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator1.start();

        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(0.5f, 200f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 400f);

        PropertyValuesHolder phv = PropertyValuesHolder.ofKeyframe("radius", kf0, kf1, kf2);

        ValueAnimator animator = ObjectAnimator.ofPropertyValuesHolder(customView, phv);
        animator.setDuration(500);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void setRadius(float value) {
        customView.setRadius(value);
    }
}
