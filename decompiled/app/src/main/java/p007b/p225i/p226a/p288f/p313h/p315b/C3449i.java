package p007b.p225i.p226a.p288f.p313h.p315b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: b.i.a.f.h.b.i */
/* loaded from: classes3.dex */
public final class C3449i extends AbstractC3349d<InterfaceC3445e> {
    public C3449i(Context context, Looper looper, C3347c c3347c, InterfaceC3290f interfaceC3290f, InterfaceC3303l interfaceC3303l) {
        super(context, looper, 126, c3347c, interfaceC3290f, interfaceC3303l);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* renamed from: l */
    public final int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3445e ? (InterfaceC3445e) iInterfaceQueryLocalInterface : new C3444d(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* renamed from: t */
    public final Feature[] mo4139t() {
        return C3442b.f9628d;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* renamed from: x */
    public final String mo3984x() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    /* renamed from: y */
    public final String mo3985y() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }
}
