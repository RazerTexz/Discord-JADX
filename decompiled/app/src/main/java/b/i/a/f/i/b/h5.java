package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class h5 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ z4 k;

    public h5(z4 z4Var, zzn zznVar) {
        this.k = z4Var;
        this.j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.a.R();
        this.k.a.p(this.j);
    }
}
