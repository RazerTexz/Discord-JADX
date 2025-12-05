package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: JobSupport.kt */
/* renamed from: s.a.q */
/* loaded from: classes3.dex */
public final class C13141q extends AbstractC13094e1<C13116h1> implements Job4 {

    /* renamed from: n */
    public final Job6 f27882n;

    public C13141q(C13116h1 c13116h1, Job6 job6) {
        super(c13116h1);
        this.f27882n = job6;
    }

    @Override // p659s.p660a.Job4
    /* renamed from: h */
    public boolean mo11333h(Throwable th) {
        return ((C13116h1) this.f27845m).mo11286E(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo11198q(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.CompletionHandler2
    /* renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27882n.mo11304s((Job5) this.f27845m);
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChildHandle[");
        sbM833U.append(this.f27882n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
