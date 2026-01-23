package p007b.p008a.p036n;

import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.n.d, reason: use source file name */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayManager5 implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OverlayManager f1548j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Function1 f1549k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ OverlayBubbleWrap f1550l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Object f1551m;

    /* JADX INFO: renamed from: b.a.n.d$a */
    /* JADX INFO: compiled from: OverlayManager.kt */
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b.a.n.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: View.kt */
        public static final class ViewOnLayoutChangeListenerC13211a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ View f1554k;

            public ViewOnLayoutChangeListenerC13211a(View view) {
                this.f1554k = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Intrinsics3.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                View viewFindViewWithTag = this.f1554k.findViewWithTag(OverlayManager5.this.f1551m);
                Intrinsics3.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
                OverlayManager5.this.f1550l.mo390b(viewFindViewWithTag);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "v");
            if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
                view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC13211a(view));
                return;
            }
            View viewFindViewWithTag = view.findViewWithTag(OverlayManager5.this.f1551m);
            Intrinsics3.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
            OverlayManager5.this.f1550l.mo390b(viewFindViewWithTag);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewCompat.isAttachedToWindow(OverlayManager5.this.f1550l)) {
                OverlayManager5.this.f1550l.setBubbleTouchable(true);
                OverlayManager5.this.f1550l.mo389a(true);
            }
        }
    }

    public OverlayManager5(OverlayManager overlayManager, Function1 function1, OverlayBubbleWrap overlayBubbleWrap, Object obj) {
        this.f1548j = overlayManager;
        this.f1549k = function1;
        this.f1550l = overlayBubbleWrap;
        this.f1551m = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) this.f1549k.invoke(this.f1550l);
        overlayBubbleWrap.addOnAttachStateChangeListener(new a());
        this.f1548j.m8430a(overlayBubbleWrap);
        this.f1550l.setBubbleTouchable(false);
        this.f1548j.windowManager.removeViewImmediate(this.f1550l);
        WindowManager windowManager = this.f1548j.windowManager;
        OverlayBubbleWrap overlayBubbleWrap2 = this.f1550l;
        windowManager.addView(overlayBubbleWrap2, overlayBubbleWrap2.getWindowLayoutParams());
    }
}
