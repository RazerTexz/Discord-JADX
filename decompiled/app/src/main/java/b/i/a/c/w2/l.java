package b.i.a.c.w2;

import b.i.a.c.w2.s;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ s.a j;
    public final /* synthetic */ s k;
    public final /* synthetic */ int l;

    public /* synthetic */ l(s.a aVar, s sVar, int i) {
        this.j = aVar;
        this.k = sVar;
        this.l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.a aVar = this.j;
        s sVar = this.k;
        int i = this.l;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(sVar);
        sVar.c0(aVar.a, aVar.f1156b, i);
    }
}
