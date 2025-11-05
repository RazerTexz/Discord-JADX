package i0;

import i0.i;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ i.b.a j;
    public final /* synthetic */ f k;
    public final /* synthetic */ Throwable l;

    public /* synthetic */ a(i.b.a aVar, f fVar, Throwable th) {
        this.j = aVar;
        this.k = fVar;
        this.l = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b.a aVar = this.j;
        this.k.a(i.b.this, this.l);
    }
}
