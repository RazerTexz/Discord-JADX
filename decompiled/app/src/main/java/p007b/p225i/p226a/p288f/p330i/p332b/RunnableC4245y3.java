package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
@WorkerThread
/* renamed from: b.i.a.f.i.b.y3 */
/* loaded from: classes3.dex */
public final class RunnableC4245y3 implements Runnable {

    /* renamed from: j */
    public final InterfaceC4256z3 f11361j;

    /* renamed from: k */
    public final int f11362k;

    /* renamed from: l */
    public final Throwable f11363l;

    /* renamed from: m */
    public final byte[] f11364m;

    /* renamed from: n */
    public final String f11365n;

    /* renamed from: o */
    public final Map<String, List<String>> f11366o;

    public RunnableC4245y3(String str, InterfaceC4256z3 interfaceC4256z3, int i, Throwable th, byte[] bArr, Map map, C4223w3 c4223w3) {
        Objects.requireNonNull(interfaceC4256z3, "null reference");
        this.f11361j = interfaceC4256z3;
        this.f11362k = i;
        this.f11363l = th;
        this.f11364m = bArr;
        this.f11365n = str;
        this.f11366o = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11361j.mo5751a(this.f11365n, this.f11362k, this.f11363l, this.f11364m, this.f11366o);
    }
}
