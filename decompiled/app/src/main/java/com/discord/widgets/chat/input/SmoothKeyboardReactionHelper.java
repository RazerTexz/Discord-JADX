package com.discord.widgets.chat.input;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import d0.z.d.m;
import java.util.List;

/* compiled from: SmoothKeyboardReactionHelper.kt */
@TargetApi(30)
/* loaded from: classes2.dex */
public final class SmoothKeyboardReactionHelper {
    public static final SmoothKeyboardReactionHelper INSTANCE = new SmoothKeyboardReactionHelper();

    /* compiled from: SmoothKeyboardReactionHelper.kt */
    public static final class Callback extends WindowInsetsAnimation.Callback {
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(View view) {
            super(0);
            m.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            m.checkNotNullParameter(insets, "insets");
            m.checkNotNullParameter(runningAnimations, "runningAnimations");
            return insets;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation animation, WindowInsetsAnimation.Bounds bounds) {
            m.checkNotNullParameter(animation, "animation");
            m.checkNotNullParameter(bounds, "bounds");
            if (this.view.getRootWindowInsets().isVisible(WindowInsets.Type.ime())) {
                this.view.setTranslationY(bounds.getUpperBound().bottom);
            } else {
                this.view.setTranslationY(-bounds.getUpperBound().bottom);
            }
            this.view.animate().setDuration(animation.getDurationMillis()).setInterpolator(animation.getInterpolator()).translationY(0.0f);
            WindowInsetsAnimation.Bounds boundsOnStart = super.onStart(animation, bounds);
            m.checkNotNullExpressionValue(boundsOnStart, "super.onStart(animation, bounds)");
            return boundsOnStart;
        }
    }

    private SmoothKeyboardReactionHelper() {
    }

    public final void install(View view) {
        m.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new Callback(view));
        }
    }
}
