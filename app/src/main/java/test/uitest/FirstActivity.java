package test.uitest;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by naman on 24/07/16.
 */
public class FirstActivity extends AppCompatActivity {

    ImageView image;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.btn_launch);
        textView = (TextView) findViewById(R.id.sample_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCircularReveal();
            }
        });
    }

    private void createCircularReveal() {
        float endRadius = Math.max(image.getWidth() / 2, image.getHeight() / 2);
        Animator animator = ViewAnimationUtils.
                createCircularReveal(image,
                        image.getMeasuredWidth() / 2,
                        image.getMeasuredHeight() / 2,
                        0,
                        endRadius);
        image.setVisibility(View.VISIBLE);
        animator.setDuration(1000);
        animator.start();

    }

    private void launchSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, Pair.create((View) image, "transition_image"));
        startActivity(intent, options.toBundle());
    }
}
