package b.i.a.c.t2;

import b.i.a.c.t2.r;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ r.a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ i(r.a aVar, int i, long j, long j2) {
        this.j = aVar;
        this.k = i;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a aVar = this.j;
        int i = this.k;
        long j = this.l;
        long j2 = this.m;
        r rVar = aVar.f1126b;
        int i2 = b.i.a.c.f3.e0.a;
        rVar.e0(i, j, j2);
    }
}
