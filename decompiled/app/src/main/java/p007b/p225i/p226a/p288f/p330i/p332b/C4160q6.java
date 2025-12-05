package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.q6 */
/* loaded from: classes3.dex */
public final class C4160q6 implements InterfaceC4218v9 {

    /* renamed from: a */
    public final /* synthetic */ C3999c6 f11152a;

    public C4160q6(C3999c6 c3999c6) {
        this.f11152a = c3999c6;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4218v9
    /* renamed from: a */
    public final void mo5762a(String str, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.f11152a.m5545H("auto", "_err", bundle);
        } else {
            this.f11152a.f11202a.m5943l();
            throw null;
        }
    }
}
