package b.i.a.c.f3;

import b.i.a.c.f3.v;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ v j;
    public final /* synthetic */ v.b k;

    public /* synthetic */ c(v vVar, v.b bVar) {
        this.j = vVar;
        this.k = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        v vVar = this.j;
        v.b bVar = this.k;
        synchronized (vVar.d) {
            i = vVar.e;
        }
        bVar.a(i);
    }
}
