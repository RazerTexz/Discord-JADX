package b.i.a.c.w2;

import b.i.a.c.w2.s;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ s.a j;
    public final /* synthetic */ s k;
    public final /* synthetic */ Exception l;

    public /* synthetic */ k(s.a aVar, s sVar, Exception exc) {
        this.j = aVar;
        this.k = sVar;
        this.l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.a aVar = this.j;
        this.k.u(aVar.a, aVar.f1156b, this.l);
    }
}
