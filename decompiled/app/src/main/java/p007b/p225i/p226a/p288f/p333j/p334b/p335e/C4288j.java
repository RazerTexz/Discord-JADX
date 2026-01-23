package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.RemoteException;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.j */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4288j implements InterfaceC4269a0 {

    /* JADX INFO: renamed from: a */
    public final C4286i f11417a;

    /* JADX INFO: renamed from: b */
    public final Message f11418b;

    /* JADX INFO: renamed from: c */
    public final BinderC4272b0 f11419c;

    /* JADX INFO: renamed from: d */
    public final PublishOptions f11420d;

    public C4288j(C4286i c4286i, Message message, BinderC4272b0 binderC4272b0, PublishOptions publishOptions) {
        this.f11417a = c4286i;
        this.f11418b = message;
        this.f11419c = binderC4272b0;
        this.f11420d = publishOptions;
    }

    @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
    /* JADX INFO: renamed from: a */
    public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
        C4286i c4286i = this.f11417a;
        Message message = this.f11418b;
        BinderC4272b0 binderC4272b0 = this.f11419c;
        PublishOptions publishOptions = this.f11420d;
        Objects.requireNonNull(c4286i);
        zzaf zzafVar = new zzaf(1, message);
        int i = c4286i.f11416m;
        Objects.requireNonNull(c4280f);
        ((InterfaceC4311u0) c4280f.m4142w()).mo5995n(new zzbz(2, zzafVar, publishOptions.f20725a, new BinderC3933j(c3301k), null, null, false, binderC4272b0, false, null, i));
    }
}
