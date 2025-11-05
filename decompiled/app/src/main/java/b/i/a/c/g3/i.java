package b.i.a.c.g3;

import b.i.a.c.f3.e0;
import b.i.a.c.g3.x;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ x.a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ i(x.a aVar, String str, long j, long j2) {
        this.j = aVar;
        this.k = str;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.a aVar = this.j;
        String str = this.k;
        long j = this.l;
        long j2 = this.m;
        x xVar = aVar.f995b;
        int i = e0.a;
        xVar.n(str, j, j2);
    }
}
