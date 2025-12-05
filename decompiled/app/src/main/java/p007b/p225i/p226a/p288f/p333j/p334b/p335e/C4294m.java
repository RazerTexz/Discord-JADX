package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.internal.zzcg;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;

/* renamed from: b.i.a.f.j.b.e.m */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4294m implements InterfaceC4269a0 {

    /* renamed from: a */
    public final C3301k f11426a;

    public C4294m(C3301k c3301k) {
        this.f11426a = c3301k;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
    /* renamed from: a */
    public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
        C3301k c3301k2 = this.f11426a;
        Objects.requireNonNull(c4280f);
        BinderC3933j binderC3933j = new BinderC3933j(c3301k);
        if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
            binderC3933j.m5406g(new Status(0, null));
            return;
        }
        ((InterfaceC4311u0) c4280f.m4142w()).mo5994j0(new zzcg(1, c4280f.f11408A.m5408b(c3301k2.f9430c), binderC3933j, null, 0, null, null, false, null));
        C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
        c3938o.f10465a.remove(c3301k2.f9430c);
    }
}
