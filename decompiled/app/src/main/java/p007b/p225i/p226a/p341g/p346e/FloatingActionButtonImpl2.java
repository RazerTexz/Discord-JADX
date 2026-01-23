package p007b.p225i.p226a.p341g.p346e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p225i.p226a.p341g.p346e.FloatingActionButtonImpl3;

/* JADX INFO: renamed from: b.i.a.g.e.e, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButtonImpl2 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f11649a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FloatingActionButtonImpl3.f f11650b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FloatingActionButtonImpl3 f11651c;

    public FloatingActionButtonImpl2(FloatingActionButtonImpl3 floatingActionButtonImpl3, boolean z2, FloatingActionButtonImpl3.f fVar) {
        this.f11651c = floatingActionButtonImpl3;
        this.f11649a = z2;
        this.f11650b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.f11651c;
        floatingActionButtonImpl3.f11660B = 0;
        floatingActionButtonImpl3.f11685v = null;
        FloatingActionButtonImpl3.f fVar = this.f11650b;
        if (fVar != null) {
            FloatingActionButton.C10919a c10919a = (FloatingActionButton.C10919a) fVar;
            c10919a.f21018a.onShown(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11651c.f11664F.internalSetVisibility(0, this.f11649a);
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.f11651c;
        floatingActionButtonImpl3.f11660B = 2;
        floatingActionButtonImpl3.f11685v = animator;
    }
}
