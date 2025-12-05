package p007b.p225i.p226a.p242c.p259f3;

import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* compiled from: lambda */
/* renamed from: b.i.a.c.f3.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2729a implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CopyOnWriteArraySet f6686j;

    /* renamed from: k */
    public final /* synthetic */ int f6687k;

    /* renamed from: l */
    public final /* synthetic */ ListenerSet.a f6688l;

    public /* synthetic */ RunnableC2729a(CopyOnWriteArraySet copyOnWriteArraySet, int i, ListenerSet.a aVar) {
        this.f6686j = copyOnWriteArraySet;
        this.f6687k = i;
        this.f6688l = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArraySet<ListenerSet.c> copyOnWriteArraySet = this.f6686j;
        int i = this.f6687k;
        ListenerSet.a aVar = this.f6688l;
        for (ListenerSet.c cVar : copyOnWriteArraySet) {
            if (!cVar.f6746d) {
                if (i != -1) {
                    FlagSet.b bVar = cVar.f6744b;
                    AnimatableValueParser.m426D(!bVar.f6735b);
                    bVar.f6734a.append(i, true);
                }
                cVar.f6745c = true;
                aVar.invoke(cVar.f6743a);
            }
        }
    }
}
