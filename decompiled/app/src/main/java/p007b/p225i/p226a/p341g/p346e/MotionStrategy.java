package p007b.p225i.p226a.p341g.p346e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* compiled from: MotionStrategy.java */
/* renamed from: b.i.a.g.e.j, reason: use source file name */
/* loaded from: classes3.dex */
public interface MotionStrategy {
    /* renamed from: a */
    void mo6078a();

    @AnimatorRes
    /* renamed from: b */
    int mo6112b();

    /* renamed from: c */
    void mo6113c();

    /* renamed from: d */
    boolean mo6114d();

    /* renamed from: e */
    void mo6079e();

    /* renamed from: f */
    AnimatorSet mo6080f();

    /* renamed from: g */
    void mo6115g(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
