package p007b.p225i.p226a.p288f.p330i.p332b;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.y0 */
/* loaded from: classes3.dex */
public final class RunnableC4242y0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ String f11356j;

    /* renamed from: k */
    public final /* synthetic */ long f11357k;

    /* renamed from: l */
    public final /* synthetic */ C3968a f11358l;

    public RunnableC4242y0(C3968a c3968a, String str, long j) {
        this.f11358l = c3968a;
        this.f11356j = str;
        this.f11357k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3968a c3968a = this.f11358l;
        String str = this.f11356j;
        long j = this.f11357k;
        c3968a.mo5848b();
        AnimatableValueParser.m583w(str);
        if (c3968a.f10502c.isEmpty()) {
            c3968a.f10503d = j;
        }
        Integer num = c3968a.f10502c.get(str);
        if (num != null) {
            c3968a.f10502c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (c3968a.f10502c.size() >= 100) {
            c3968a.mo5726g().f11144i.m5860a("Too many ads visible");
        } else {
            c3968a.f10502c.put(str, 1);
            c3968a.f10501b.put(str, Long.valueOf(j));
        }
    }
}
