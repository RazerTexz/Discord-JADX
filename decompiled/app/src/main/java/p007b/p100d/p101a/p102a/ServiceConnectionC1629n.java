package p007b.p100d.p101a.p102a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.billingclient.api.BillingResult;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractBinderC3943c;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3942b;
import p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* renamed from: b.d.a.a.n */
/* loaded from: classes.dex */
public final class ServiceConnectionC1629n implements ServiceConnection {

    /* renamed from: j */
    public final Object f2968j = new Object();

    /* renamed from: k */
    public boolean f2969k = false;

    /* renamed from: l */
    public InterfaceC1616b f2970l;

    /* renamed from: m */
    public final /* synthetic */ C1614a f2971m;

    public /* synthetic */ ServiceConnectionC1629n(C1614a c1614a, InterfaceC1616b interfaceC1616b) {
        this.f2971m = c1614a;
        this.f2970l = interfaceC1616b;
    }

    /* renamed from: a */
    public final void m811a(BillingResult billingResult) {
        synchronized (this.f2968j) {
            InterfaceC1616b interfaceC1616b = this.f2970l;
            if (interfaceC1616b != null) {
                interfaceC1616b.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC3944d c3942b;
        C3941a.m5415e("BillingClient", "Billing service connected.");
        C1614a c1614a = this.f2971m;
        int i = AbstractBinderC3943c.f10480a;
        if (iBinder == null) {
            c3942b = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            c3942b = iInterfaceQueryLocalInterface instanceof InterfaceC3944d ? (InterfaceC3944d) iInterfaceQueryLocalInterface : new C3942b(iBinder);
        }
        c1614a.f2936f = c3942b;
        C1614a c1614a2 = this.f2971m;
        if (c1614a2.m810l(new CallableC1628m(this), 30000L, new RunnableC1627l(this), c1614a2.m807i()) == null) {
            m811a(this.f2971m.m809k());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C3941a.m5416f("BillingClient", "Billing service disconnected.");
        this.f2971m.f2936f = null;
        this.f2971m.f2931a = 0;
        synchronized (this.f2968j) {
            InterfaceC1616b interfaceC1616b = this.f2970l;
            if (interfaceC1616b != null) {
                interfaceC1616b.onBillingServiceDisconnected();
            }
        }
    }
}
