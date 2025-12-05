package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.RemoteException;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzce;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;

/* renamed from: b.i.a.f.j.b.e.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4290k implements InterfaceC4269a0 {

    /* renamed from: a */
    public final Message f11421a;

    public C4290k(Message message) {
        this.f11421a = message;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
    /* renamed from: a */
    public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
        zzaf zzafVar = new zzaf(1, this.f11421a);
        Objects.requireNonNull(c4280f);
        ((InterfaceC4311u0) c4280f.m4142w()).mo5992P(new zzce(1, zzafVar, new BinderC3933j(c3301k), null, null, false, null));
    }
}
