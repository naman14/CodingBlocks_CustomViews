package test.uitest;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by naman on 24/07/16.
 */
public class FirstActivity extends AppCompatActivity {

    ImageView image;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.btn_launch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity();
            }
        });
    }

    private void launchSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, Pair.create((View) image, "transition_image"));
        startActivity(intent, options.toBundle());
    }
}
