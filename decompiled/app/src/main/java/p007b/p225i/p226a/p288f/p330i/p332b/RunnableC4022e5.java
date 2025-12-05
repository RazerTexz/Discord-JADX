package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.i.b.e5 */
/* loaded from: classes3.dex */
public final class RunnableC4022e5 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ zzz f10686j;

    /* renamed from: k */
    public final /* synthetic */ BinderC4257z4 f10687k;

    public RunnableC4022e5(BinderC4257z4 binderC4257z4, zzz zzzVar) {
        this.f10687k = binderC4257z4;
        this.f10686j = zzzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10687k.f11390a.m5717R();
        if (this.f10686j.f20702l.m9117w0() == null) {
            C4097k9 c4097k9 = this.f10687k.f11390a;
            zzz zzzVar = this.f10686j;
            Objects.requireNonNull(c4097k9);
            zzn zznVarM5744y = c4097k9.m5744y(zzzVar.f20700j);
            if (zznVarM5744y != null) {
                c4097k9.m5705F(zzzVar, zznVarM5744y);
                return;
            }
            return;
        }
        C4097k9 c4097k92 = this.f10687k.f11390a;
        zzz zzzVar2 = this.f10686j;
        Objects.requireNonNull(c4097k92);
        zzn zznVarM5744y2 = c4097k92.m5744y(zzzVar2.f20700j);
        if (zznVarM5744y2 != null) {
            c4097k92.m5736q(zzzVar2, zznVarM5744y2);
        }
    }
}
