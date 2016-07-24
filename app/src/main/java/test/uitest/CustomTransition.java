package test.uitest;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by naman on 24/07/16.
 */
@TargetApi(21)
public class CustomTransition extends Transition {

    private static final String BACKGROUND = "com.uitest:custom_transition:color";

    public CustomTransition() {
        super();
    }

    public CustomTransition(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        View endView = transitionValues.view;
        transitionValues.values.put(BACKGROUND, endView.getBackground());
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;

        transitionValues.values.put(BACKGROUND, view.getBackground());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, final TransitionValues endValues) {

        if (startValues == null || endValues == null) {
            return null;
        }

        final View endView = endValues.view;

        if (endView.getBackground() instanceof ColorDrawable) {

            int startColor = ((ColorDrawable) startValues.values.get(BACKGROUND)).getColor();
            int finalColor = ((ColorDrawable) endValues.values.get(BACKGROUND)).getColor();

            ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, finalColor);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int color = (int) valueAnimator.getAnimatedValue();
                    endView.setBackgroundColor(color);
                }
            });
            valueAnimator.start();
            return valueAnimator;

        }

        return null;
    }
}
