package p007b.p225i.p226a.p242c;

import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2526a0 implements ListenerSet.a {

    /* renamed from: a */
    public final /* synthetic */ int f5464a;

    /* renamed from: b */
    public final /* synthetic */ Player2.f f5465b;

    /* renamed from: c */
    public final /* synthetic */ Player2.f f5466c;

    public /* synthetic */ C2526a0(int i, Player2.f fVar, Player2.f fVar2) {
        this.f5464a = i;
        this.f5465b = fVar;
        this.f5466c = fVar2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        int i = this.f5464a;
        Player2.f fVar = this.f5465b;
        Player2.f fVar2 = this.f5466c;
        Player2.c cVar = (Player2.c) obj;
        cVar.mo256j(i);
        cVar.mo253g(fVar, fVar2, i);
    }
}
