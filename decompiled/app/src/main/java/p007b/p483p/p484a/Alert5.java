package p007b.p483p.p484a;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: b.p.a.e, reason: use source file name */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alert5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ViewOnClickListenerC5272b f14362j;

    public Alert5(ViewOnClickListenerC5272b viewOnClickListenerC5272b) {
        this.f14362j = viewOnClickListenerC5272b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f14362j.getParent() != null) {
                try {
                    ViewParent parent = this.f14362j.getParent();
                    if (parent == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ((ViewGroup) parent).removeView(this.f14362j);
                    OnHideAlertListener onHideListener$alerter_release = this.f14362j.getOnHideListener$alerter_release();
                    if (onHideListener$alerter_release != null) {
                        onHideListener$alerter_release.onHide();
                    }
                } catch (Exception unused) {
                    Log.e(getClass().getSimpleName(), "Cannot remove from parent layout");
                }
            }
        } catch (Exception e) {
            Log.e(Alert5.class.getSimpleName(), Log.getStackTraceString(e));
        }
    }
}
