package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.zzcb;
import java.lang.ref.WeakReference;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3936m;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.n */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4296n implements InterfaceC4269a0 {

    /* JADX INFO: renamed from: a */
    public final C3301k f11427a;

    public C4296n(C3301k c3301k) {
        this.f11427a = c3301k;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
    /* JADX INFO: renamed from: a */
    public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
        C3301k c3301k2 = this.f11427a;
        if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
            C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
            c3938o.f10465a.put(c3301k2.f9430c, new WeakReference<>(new BinderC3936m(c3301k2)));
        }
        zzcb zzcbVar = new zzcb(1, new BinderC3933j(c3301k), c4280f.f11408A.m5408b(c3301k2.f9430c), false, null, null);
        zzcbVar.f20793m = true;
        ((InterfaceC4311u0) c4280f.m4142w()).mo5996s(zzcbVar);
    }
}
