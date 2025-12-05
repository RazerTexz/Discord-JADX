package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.d8 */
/* loaded from: classes3.dex */
public final class RunnableC4013d8 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ boolean f10663j;

    /* renamed from: k */
    public final /* synthetic */ zzaq f10664k;

    /* renamed from: l */
    public final /* synthetic */ zzn f10665l;

    /* renamed from: m */
    public final /* synthetic */ String f10666m;

    /* renamed from: n */
    public final /* synthetic */ C4161q7 f10667n;

    public RunnableC4013d8(C4161q7 c4161q7, boolean z2, boolean z3, zzaq zzaqVar, zzn zznVar, String str) {
        this.f10667n = c4161q7;
        this.f10663j = z3;
        this.f10664k = zzaqVar;
        this.f10665l = zznVar;
        this.f10666m = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4161q7 c4161q7 = this.f10667n;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Discarding data. Failed to send event to service");
        } else {
            c4161q7.m5812w(interfaceC4068i3, this.f10663j ? null : this.f10664k, this.f10665l);
            this.f10667n.m5808F();
        }
    }
}
