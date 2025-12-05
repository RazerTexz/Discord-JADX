package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: JobSupport.kt */
/* renamed from: s.a.d1 */
/* loaded from: classes3.dex */
public final class C13078d1 extends AbstractC13113g1<Job> {

    /* renamed from: n */
    public final Function1<Throwable, Unit> f27780n;

    /* JADX WARN: Multi-variable type inference failed */
    public C13078d1(Job job, Function1<? super Throwable, Unit> function1) {
        super(job);
        this.f27780n = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27780n.invoke(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.CompletionHandler2
    /* renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27780n.invoke(th);
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbM833U = outline.m833U("InvokeOnCompletion[");
        sbM833U.append(C13078d1.class.getSimpleName());
        sbM833U.append(MentionUtils.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
