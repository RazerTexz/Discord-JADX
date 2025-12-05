package p007b.p100d.p101a.p102a;

import java.util.Objects;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.m */
/* loaded from: classes.dex */
public final /* synthetic */ class CallableC1628m implements Callable {

    /* renamed from: j */
    public final /* synthetic */ ServiceConnectionC1629n f2967j;

    public /* synthetic */ CallableC1628m(ServiceConnectionC1629n serviceConnectionC1629n) {
        this.f2967j = serviceConnectionC1629n;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object call() {
        int iMo5420N;
        ServiceConnectionC1629n serviceConnectionC1629n = this.f2967j;
        synchronized (serviceConnectionC1629n.f2968j) {
            if (!serviceConnectionC1629n.f2969k) {
                int i = 3;
                try {
                    String packageName = serviceConnectionC1629n.f2971m.f2935e.getPackageName();
                    int i2 = 16;
                    iMo5420N = 3;
                    while (true) {
                        if (i2 < 3) {
                            i2 = 0;
                            break;
                        }
                        try {
                            iMo5420N = serviceConnectionC1629n.f2971m.f2936f.mo5420N(i2, packageName, "subs");
                            if (iMo5420N == 0) {
                                break;
                            }
                            i2--;
                        } catch (Exception unused) {
                            i = iMo5420N;
                            C3941a.m5416f("BillingClient", "Exception while checking if billing is supported; try to reconnect");
                            serviceConnectionC1629n.f2971m.f2931a = 0;
                            serviceConnectionC1629n.f2971m.f2936f = null;
                            iMo5420N = i;
                            if (iMo5420N != 0) {
                            }
                            return null;
                        }
                    }
                    Objects.requireNonNull(serviceConnectionC1629n.f2971m);
                    boolean z2 = true;
                    serviceConnectionC1629n.f2971m.f2938h = i2 >= 3;
                    if (i2 < 3) {
                        C3941a.m5415e("BillingClient", "In-app billing API does not support subscription on this device.");
                    }
                    int i3 = 16;
                    while (true) {
                        if (i3 < 3) {
                            break;
                        }
                        iMo5420N = serviceConnectionC1629n.f2971m.f2936f.mo5420N(i3, packageName, "inapp");
                        if (iMo5420N == 0) {
                            serviceConnectionC1629n.f2971m.f2939i = i3;
                            break;
                        }
                        i3--;
                    }
                    C1614a c1614a = serviceConnectionC1629n.f2971m;
                    int i4 = c1614a.f2939i;
                    c1614a.f2945o = i4 >= 16;
                    c1614a.f2944n = i4 >= 15;
                    c1614a.f2943m = i4 >= 14;
                    c1614a.f2942l = i4 >= 10;
                    c1614a.f2941k = i4 >= 9;
                    if (i4 < 6) {
                        z2 = false;
                    }
                    c1614a.f2940j = z2;
                    if (i4 < 3) {
                        C3941a.m5416f("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    }
                    if (iMo5420N == 0) {
                        serviceConnectionC1629n.f2971m.f2931a = 2;
                    } else {
                        serviceConnectionC1629n.f2971m.f2931a = 0;
                        serviceConnectionC1629n.f2971m.f2936f = null;
                    }
                } catch (Exception unused2) {
                }
                if (iMo5420N != 0) {
                    serviceConnectionC1629n.m811a(C1631p.f2980i);
                } else {
                    serviceConnectionC1629n.m811a(C1631p.f2972a);
                }
            }
        }
        return null;
    }
}
