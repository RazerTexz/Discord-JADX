package p007b.p225i.p226a.p288f.p299e.p300h;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.e */
/* loaded from: classes3.dex */
public final class C3270e<R extends InterfaceC3273h> extends BasePendingResult<R> {

    /* renamed from: l */
    public final R f9339l;

    public C3270e(AbstractC3268c abstractC3268c, R r) {
        super(abstractC3268c);
        this.f9339l = r;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: d */
    public final R mo3987d(Status status) {
        return this.f9339l;
    }
}
