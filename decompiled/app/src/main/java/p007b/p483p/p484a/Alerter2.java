package p007b.p483p.p484a;

import android.view.ViewGroup;

/* JADX INFO: renamed from: b.p.a.h, reason: use source file name */
/* JADX INFO: compiled from: Alerter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Alerter2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ViewGroup f14365j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Alerter3 f14366k;

    public Alerter2(ViewGroup viewGroup, Alerter3 alerter3) {
        this.f14365j = viewGroup;
        this.f14366k = alerter3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14365j.addView(this.f14366k.f14368b);
    }
}
