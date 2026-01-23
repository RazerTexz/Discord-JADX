package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import java.lang.ref.WeakReference;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3931h;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.l */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4292l implements InterfaceC4269a0 {

    /* JADX INFO: renamed from: a */
    public final C4286i f11422a;

    /* JADX INFO: renamed from: b */
    public final C3301k f11423b;

    /* JADX INFO: renamed from: c */
    public final BinderC4277d0 f11424c;

    /* JADX INFO: renamed from: d */
    public final SubscribeOptions f11425d;

    public C4292l(C4286i c4286i, C3301k c3301k, BinderC4277d0 binderC4277d0, SubscribeOptions subscribeOptions) {
        this.f11422a = c4286i;
        this.f11423b = c3301k;
        this.f11424c = binderC4277d0;
        this.f11425d = subscribeOptions;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
    /* JADX INFO: renamed from: a */
    public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
        C4286i c4286i = this.f11422a;
        C3301k c3301k2 = this.f11423b;
        BinderC4277d0 binderC4277d0 = this.f11424c;
        SubscribeOptions subscribeOptions = this.f11425d;
        int i = c4286i.f11416m;
        if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
            C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
            c3938o.f10465a.put(c3301k2.f9430c, new WeakReference<>(new BinderC3931h(c3301k2)));
        }
        ((InterfaceC4311u0) c4280f.m4142w()).mo5991C(new SubscribeRequest(3, c4280f.f11408A.m5408b(c3301k2.f9430c), subscribeOptions.f20737a, new BinderC3933j(c3301k), subscribeOptions.f20738b, null, 0, null, null, null, false, binderC4277d0, false, null, subscribeOptions.f20740d, 0, i));
    }
}
