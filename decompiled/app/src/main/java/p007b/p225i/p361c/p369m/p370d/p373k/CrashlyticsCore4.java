package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: CrashlyticsCore.java */
/* renamed from: b.i.c.m.d.k.l0, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsCore4 implements Callable<Boolean> {

    /* renamed from: j */
    public final /* synthetic */ CrashlyticsCore3 f12346j;

    public CrashlyticsCore4(CrashlyticsCore3 crashlyticsCore3) {
        this.f12346j = crashlyticsCore3;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        C4663x c4663x = this.f12346j.f12336h;
        boolean z2 = true;
        if (c4663x.f12431k.m6445b().exists()) {
            Logger3.f12227a.m6371b("Found previous crash marker.");
            c4663x.f12431k.m6445b().delete();
        } else {
            String strM6474i = c4663x.m6474i();
            if (strM6474i == null || !c4663x.f12443w.mo6366e(strM6474i)) {
                z2 = false;
            }
        }
        return Boolean.valueOf(z2);
    }
}
