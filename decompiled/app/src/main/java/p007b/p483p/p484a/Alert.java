package p007b.p483p.p484a;

import android.view.View;
import p007b.p483p.p484a.SwipeDismissTouchListener;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Alert.kt */
/* renamed from: b.p.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Alert implements SwipeDismissTouchListener.a {

    /* renamed from: j */
    public final /* synthetic */ ViewOnClickListenerC5272b f14338j;

    public Alert(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        this.f14338j = viewOnClickListenerC5272b;
    }

    @Override // p007b.p483p.p484a.SwipeDismissTouchListener.a
    /* renamed from: a */
    public void mo7463a(View view, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    @Override // p007b.p483p.p484a.SwipeDismissTouchListener.a
    /* renamed from: b */
    public boolean mo7464b() {
        return true;
    }

    @Override // p007b.p483p.p484a.SwipeDismissTouchListener.a
    public void onDismiss(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b = this.f14338j;
        viewOnClickListenerC5272b.clearAnimation();
        viewOnClickListenerC5272b.setVisibility(8);
        viewOnClickListenerC5272b.postDelayed(new Alert5(viewOnClickListenerC5272b), 100);
    }
}
