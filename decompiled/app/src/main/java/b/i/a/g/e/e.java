package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.i.a.g.e.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes3.dex */
public class e extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.InterfaceC0122f f1614b;
    public final /* synthetic */ f c;

    public e(f fVar, boolean z2, f.InterfaceC0122f interfaceC0122f) {
        this.c = fVar;
        this.a = z2;
        this.f1614b = interfaceC0122f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        f fVar = this.c;
        fVar.B = 0;
        fVar.v = null;
        f.InterfaceC0122f interfaceC0122f = this.f1614b;
        if (interfaceC0122f != null) {
            FloatingActionButton.a aVar = (FloatingActionButton.a) interfaceC0122f;
            aVar.a.onShown(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.c.F.internalSetVisibility(0, this.a);
        f fVar = this.c;
        fVar.B = 2;
        fVar.v = animator;
    }
}
