package p659s.p660a.p663c2;

import com.discord.widgets.chat.input.MentionUtils;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result2;
import p507d0.Result3;
import p659s.p660a.CancellableContinuationImpl6;
import p659s.p660a.p661a.LockFreeLinkedList3;
import p659s.p660a.p661a.Symbol3;

/* compiled from: AbstractChannel.kt */
/* renamed from: s.a.c2.t, reason: use source file name */
/* loaded from: classes3.dex */
public class AbstractChannel8<E> extends AbstractChannel7 {

    /* renamed from: m */
    public final E f27767m;

    /* renamed from: n */
    public final CancellableContinuation<Unit> f27768n;

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChannel8(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f27767m = e;
        this.f27768n = cancellableContinuation;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: q */
    public void mo11227q() {
        this.f27768n.mo10907r(CancellableContinuationImpl6.f27874a);
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: r */
    public E mo11228r() {
        return this.f27767m;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: s */
    public void mo11229s(AbstractChannel4<?> abstractChannel4) {
        CancellableContinuation<Unit> cancellableContinuation = this.f27768n;
        Throwable thM11234w = abstractChannel4.m11234w();
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(thM11234w)));
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: t */
    public Symbol3 mo11230t(LockFreeLinkedList3.b bVar) {
        if (this.f27768n.mo10901c(Unit.f27425a, null) != null) {
            return CancellableContinuationImpl6.f27874a;
        }
        return null;
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + C3404f.m4312l0(this) + '(' + this.f27767m + ')';
    }
}
