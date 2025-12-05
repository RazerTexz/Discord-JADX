package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.m8 */
/* loaded from: classes3.dex */
public final class RunnableC4118m8 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ComponentName f10970j;

    /* renamed from: k */
    public final /* synthetic */ ServiceConnectionC4096k8 f10971k;

    public RunnableC4118m8(ServiceConnectionC4096k8 serviceConnectionC4096k8, ComponentName componentName) {
        this.f10971k = serviceConnectionC4096k8;
        this.f10970j = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4161q7.m5802x(this.f10971k.f10894l, this.f10970j);
    }
}
