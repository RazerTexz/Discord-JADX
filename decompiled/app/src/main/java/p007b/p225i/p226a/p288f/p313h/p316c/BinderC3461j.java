package p007b.p225i.p226a.p288f.p313h.p316c;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: b.i.a.f.h.c.j */
/* loaded from: classes3.dex */
public final class BinderC3461j extends BinderC3457f {

    /* renamed from: a */
    public final /* synthetic */ C3458g f9641a;

    public BinderC3461j(C3458g c3458g) {
        this.f9641a = c3458g;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.BinderC3457f, p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3469r
    /* renamed from: O */
    public final void mo4399O(Status status, Credential credential) {
        this.f9641a.m9035g(new C3456e(status, credential));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.InterfaceC3469r
    /* renamed from: l */
    public final void mo4401l(Status status) {
        this.f9641a.m9035g(new C3456e(status, null));
    }
}
