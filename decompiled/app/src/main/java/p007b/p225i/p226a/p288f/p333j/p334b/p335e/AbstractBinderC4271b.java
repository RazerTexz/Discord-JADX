package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b;
import p007b.p225i.p226a.p288f.p333j.p334b.C4267d;

/* renamed from: b.i.a.f.j.b.e.b */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC4271b extends BinderC3925b implements InterfaceC4268a {
    public AbstractBinderC4271b() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b
    /* renamed from: c */
    public final boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        BinderC4306s binderC4306s = (BinderC4306s) this;
        binderC4306s.f11432d.m4045b(binderC4306s.f11431c.f9430c);
        C3301k<C4267d> c3301k = binderC4306s.f11407b;
        if (c3301k != null) {
            c3301k.m4106a(BinderC4277d0.f11406a);
        }
        return true;
    }
}
