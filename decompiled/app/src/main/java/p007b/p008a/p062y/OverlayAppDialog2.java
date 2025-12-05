package p007b.p008a.p062y;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* compiled from: OverlayAppDialog.kt */
/* renamed from: b.a.y.l, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class OverlayAppDialog2 extends OverlayDialog implements AppComponent {

    /* renamed from: x */
    public final Subject<Void, Void> f2042x;

    /* renamed from: y */
    public Function1<? super OverlayDialog, Unit> f2043y;

    /* compiled from: Animator.kt */
    /* renamed from: b.a.y.l$a */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayAppDialog2.this.getOnDialogClosed().invoke(OverlayAppDialog2.this);
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

    /* compiled from: OverlayAppDialog.kt */
    /* renamed from: b.a.y.l$b */
    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: j */
        public final /* synthetic */ Animator f2045j;

        public b(Animator animator) {
            this.f2045j = animator;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f2045j.end();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayAppDialog2(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.f2042x = publishSubjectM11133k0;
        setOnClickListener(new OverlayAppDialog(this));
        this.f2043y = OverlayAppDialog3.f2048j;
    }

    /* renamed from: g */
    public final void m387g() {
        getUnsubscribeSignal().onNext(null);
        Log.i(getClass().getSimpleName(), "closing");
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.f2043y.invoke(this);
            return;
        }
        Animator closingAnimator = getClosingAnimator();
        closingAnimator.addListener(new a());
        closingAnimator.start();
        addOnAttachStateChangeListener(new b(closingAnimator));
    }

    public abstract Animator getClosingAnimator();

    public final Function1<OverlayDialog, Unit> getOnDialogClosed() {
        return this.f2043y;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f2042x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }

    public final void setOnDialogClosed(Function1<? super OverlayDialog, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.f2043y = function1;
    }
}
