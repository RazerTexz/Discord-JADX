package b.i.a.c;

import b.i.a.c.f3.p;
import b.i.a.c.y1;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a0 implements p.a {
    public final /* synthetic */ int a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y1.f f805b;
    public final /* synthetic */ y1.f c;

    public /* synthetic */ a0(int i, y1.f fVar, y1.f fVar2) {
        this.a = i;
        this.f805b = fVar;
        this.c = fVar2;
    }

    @Override // b.i.a.c.f3.p.a
    public final void invoke(Object obj) {
        int i = this.a;
        y1.f fVar = this.f805b;
        y1.f fVar2 = this.c;
        y1.c cVar = (y1.c) obj;
        cVar.j(i);
        cVar.g(fVar, fVar2, i);
    }
}
