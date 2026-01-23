package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {
        public Animatable2.AnimationCallback mPlatformCallback;

        /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback$1 */
        public class C06761 extends Animatable2.AnimationCallback {
            public C06761() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                AnimationCallback.this.onAnimationEnd(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                AnimationCallback.this.onAnimationStart(drawable);
            }
        }

        @RequiresApi(23)
        public Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new C06761();
            }
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(Drawable drawable) {
        }

        public void onAnimationStart(Drawable drawable) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@NonNull AnimationCallback animationCallback);
}
