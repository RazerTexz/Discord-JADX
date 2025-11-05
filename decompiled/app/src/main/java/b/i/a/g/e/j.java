package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* compiled from: MotionStrategy.java */
/* loaded from: classes3.dex */
public interface j {
    void a();

    @AnimatorRes
    int b();

    void c();

    boolean d();

    void e();

    AnimatorSet f();

    void g(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
