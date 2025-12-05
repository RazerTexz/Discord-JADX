package p007b.p225i.p226a.p341g.p346e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p225i.p226a.p341g.p346e.FloatingActionButtonImpl3;

/* compiled from: FloatingActionButtonImpl.java */
/* renamed from: b.i.a.g.e.d, reason: use source file name */
/* loaded from: classes3.dex */
public class FloatingActionButtonImpl extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f11645a;

    /* renamed from: b */
    public final /* synthetic */ boolean f11646b;

    /* renamed from: c */
    public final /* synthetic */ FloatingActionButtonImpl3.f f11647c;

    /* renamed from: d */
    public final /* synthetic */ FloatingActionButtonImpl3 f11648d;

    public FloatingActionButtonImpl(FloatingActionButtonImpl3 floatingActionButtonImpl3, boolean z2, FloatingActionButtonImpl3.f fVar) {
        this.f11648d = floatingActionButtonImpl3;
        this.f11646b = z2;
        this.f11647c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f11645a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.f11648d;
        floatingActionButtonImpl3.f11660B = 0;
        floatingActionButtonImpl3.f11685v = null;
        if (this.f11645a) {
            return;
        }
        FloatingActionButton floatingActionButton = floatingActionButtonImpl3.f11664F;
        boolean z2 = this.f11646b;
        floatingActionButton.internalSetVisibility(z2 ? 8 : 4, z2);
        FloatingActionButtonImpl3.f fVar = this.f11647c;
        if (fVar != null) {
            FloatingActionButton.C10919a c10919a = (FloatingActionButton.C10919a) fVar;
            c10919a.f21018a.onHidden(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11648d.f11664F.internalSetVisibility(0, this.f11646b);
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.f11648d;
        floatingActionButtonImpl3.f11660B = 1;
        floatingActionButtonImpl3.f11685v = animator;
        this.f11645a = false;
    }
}
