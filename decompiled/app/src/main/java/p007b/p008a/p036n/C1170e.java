package p007b.p008a.p036n;

import android.animation.Animator;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Animator.kt */
/* renamed from: b.a.n.e */
/* loaded from: classes.dex */
public final class C1170e implements Animator.AnimatorListener {

    /* renamed from: a */
    public final /* synthetic */ OverlayManager f1555a;

    /* renamed from: b */
    public final /* synthetic */ OverlayBubbleWrap f1556b;

    public C1170e(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        this.f1555a = overlayManager;
        this.f1556b = overlayBubbleWrap;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        if (this.f1555a.trashWrap != null) {
            OverlayBubbleWrap overlayBubbleWrap = this.f1556b;
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
        }
        TrashEventListener trashEventListener = this.f1555a.trashEventListener;
        if (trashEventListener != null) {
            trashEventListener.mo228b(this.f1556b);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }
}
