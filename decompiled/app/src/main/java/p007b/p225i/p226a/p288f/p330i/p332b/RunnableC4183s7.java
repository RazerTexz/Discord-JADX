package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.s7 */
/* loaded from: classes3.dex */
public final class RunnableC4183s7 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ String f11205j;

    /* renamed from: k */
    public final /* synthetic */ String f11206k;

    /* renamed from: l */
    public final /* synthetic */ boolean f11207l;

    /* renamed from: m */
    public final /* synthetic */ zzn f11208m;

    /* renamed from: n */
    public final /* synthetic */ InterfaceC3660fc f11209n;

    /* renamed from: o */
    public final /* synthetic */ C4161q7 f11210o;

    public RunnableC4183s7(C4161q7 c4161q7, String str, String str2, boolean z2, zzn zznVar, InterfaceC3660fc interfaceC3660fc) {
        this.f11210o = c4161q7;
        this.f11205j = str;
        this.f11206k = str2;
        this.f11207l = z2;
        this.f11208m = zznVar;
        this.f11209n = interfaceC3660fc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            C4161q7 c4161q7 = this.f11210o;
            InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
            if (interfaceC4068i3 == null) {
                c4161q7.mo5726g().f11141f.m5862c("Failed to get user properties; not connected to service", this.f11205j, this.f11206k);
                return;
            }
            Bundle bundleM5871A = C4196t9.m5871A(interfaceC4068i3.mo5671R(this.f11205j, this.f11206k, this.f11207l, this.f11208m));
            this.f11210o.m5808F();
            this.f11210o.m5866e().m5898L(this.f11209n, bundleM5871A);
        } catch (RemoteException e) {
            this.f11210o.mo5726g().f11141f.m5862c("Failed to get user properties; remote exception", this.f11205j, e);
        } finally {
            this.f11210o.m5866e().m5898L(this.f11209n, bundle);
        }
    }
}
