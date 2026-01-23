package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;

/* JADX INFO: renamed from: b.i.a.f.i.b.b6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3987b6 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C3999c6 f10567j;

    /* JADX INFO: renamed from: k */
    public final Bundle f10568k;

    public RunnableC3987b6(C3999c6 c3999c6, Bundle bundle) {
        this.f10567j = c3999c6;
        this.f10568k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        C3999c6 c3999c6 = this.f10567j;
        Bundle bundle = this.f10568k;
        Objects.requireNonNull(c3999c6);
        if (C3644ea.m4872b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11112z0)) {
            if (bundle == null) {
                c3999c6.m5867l().f10633D.m5682b(new Bundle());
                return;
            }
            Bundle bundleM5681a = c3999c6.m5867l().f10633D.m5681a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    c3999c6.m5866e();
                    if (C4196t9.m5876W(obj)) {
                        c3999c6.m5866e().m5904R(c3999c6.f10607p, 27, null, null, 0);
                    }
                    c3999c6.mo5726g().f11146k.m5862c("Invalid default event parameter type. Name, value", str, obj);
                } else if (C4196t9.m5885r0(str)) {
                    c3999c6.mo5726g().f11146k.m5861b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundleM5681a.remove(str);
                } else if (c3999c6.m5866e().m5910b0("param", str, 100, obj)) {
                    c3999c6.m5866e().m5895I(bundleM5681a, str, obj);
                }
            }
            c3999c6.m5866e();
            int iM5531t = c3999c6.f11202a.f11260h.m5531t();
            if (bundleM5681a.size() > iM5531t) {
                Iterator it = new TreeSet(bundleM5681a.keySet()).iterator();
                int i = 0;
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    i++;
                    if (i > iM5531t) {
                        bundleM5681a.remove(str2);
                    }
                }
            } else {
                z2 = false;
            }
            if (z2) {
                c3999c6.m5866e().m5904R(c3999c6.f10607p, 26, null, null, 0);
                c3999c6.mo5726g().f11146k.m5860a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            c3999c6.m5867l().f10633D.m5682b(bundleM5681a);
            C4161q7 c4161q7M5971p = c3999c6.m5971p();
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            c4161q7M5971p.m5814z(new RunnableC3977a8(c4161q7M5971p, bundleM5681a, c4161q7M5971p.m5811I(false)));
        }
    }
}
