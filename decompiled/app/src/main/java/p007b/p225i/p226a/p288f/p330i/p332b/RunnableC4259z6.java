package p007b.p225i.p226a.p288f.p330i.p332b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.z6 */
/* loaded from: classes3.dex */
public final class RunnableC4259z6 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ C4004d f11393j;

    /* renamed from: k */
    public final /* synthetic */ int f11394k;

    /* renamed from: l */
    public final /* synthetic */ long f11395l;

    /* renamed from: m */
    public final /* synthetic */ boolean f11396m;

    /* renamed from: n */
    public final /* synthetic */ C3999c6 f11397n;

    public RunnableC4259z6(C3999c6 c3999c6, C4004d c4004d, int i, long j, boolean z2) {
        this.f11397n = c3999c6;
        this.f11393j = c4004d;
        this.f11394k = i;
        this.f11395l = j;
        this.f11396m = z2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f11397n.m5559z(this.f11393j);
        C3999c6.m5538C(this.f11397n, this.f11393j, this.f11394k, this.f11395l, false, this.f11396m);
    }
}
