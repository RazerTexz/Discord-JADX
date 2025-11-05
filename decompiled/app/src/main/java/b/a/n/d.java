package b.a.n;

import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: OverlayManager.kt */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ OverlayManager j;
    public final /* synthetic */ Function1 k;
    public final /* synthetic */ OverlayBubbleWrap l;
    public final /* synthetic */ Object m;

    /* compiled from: OverlayManager.kt */
    public static final class a implements View.OnAttachStateChangeListener {

        /* compiled from: View.kt */
        /* renamed from: b.a.n.d$a$a, reason: collision with other inner class name */
        public static final class ViewOnLayoutChangeListenerC0036a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View k;

            public ViewOnLayoutChangeListenerC0036a(View view) {
                this.k = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                m.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                View viewFindViewWithTag = this.k.findViewWithTag(d.this.m);
                m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
                d.this.l.b(viewFindViewWithTag);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m.checkNotNullParameter(view, "v");
            if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
                view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0036a(view));
                return;
            }
            View viewFindViewWithTag = view.findViewWithTag(d.this.m);
            m.checkNotNullExpressionValue(viewFindViewWithTag, "v.findViewWithTag(anchorViewTag)");
            d.this.l.b(viewFindViewWithTag);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewCompat.isAttachedToWindow(d.this.l)) {
                d.this.l.setBubbleTouchable(true);
                d.this.l.a(true);
            }
        }
    }

    public d(OverlayManager overlayManager, Function1 function1, OverlayBubbleWrap overlayBubbleWrap, Object obj) {
        this.j = overlayManager;
        this.k = function1;
        this.l = overlayBubbleWrap;
        this.m = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) this.k.invoke(this.l);
        overlayBubbleWrap.addOnAttachStateChangeListener(new a());
        this.j.a(overlayBubbleWrap);
        this.l.setBubbleTouchable(false);
        this.j.windowManager.removeViewImmediate(this.l);
        WindowManager windowManager = this.j.windowManager;
        OverlayBubbleWrap overlayBubbleWrap2 = this.l;
        windowManager.addView(overlayBubbleWrap2, overlayBubbleWrap2.getWindowLayoutParams());
    }
}
