package b.i.a.c.t2;

import b.i.a.c.t2.r;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ r.a j;
    public final /* synthetic */ Exception k;

    public /* synthetic */ d(r.a aVar, Exception exc) {
        this.j = aVar;
        this.k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a aVar = this.j;
        Exception exc = this.k;
        r rVar = aVar.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.N(exc);
    }
}
