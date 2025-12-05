package p007b.p483p.p484a;

import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: Alerter.kt */
/* renamed from: b.p.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class Alerter implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ViewOnClickListenerC5272b f14364j;

    public Alerter(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        this.f14364j = viewOnClickListenerC5272b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnClickListenerC5272b viewOnClickListenerC5272b = this.f14364j;
        if (viewOnClickListenerC5272b != null) {
            ViewParent parent = viewOnClickListenerC5272b.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.f14364j);
            }
        }
    }
}
