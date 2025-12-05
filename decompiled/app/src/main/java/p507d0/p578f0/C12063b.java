package p507d0.p578f0;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.AbstractIterator3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Sequences.kt */
/* renamed from: d0.f0.b */
/* loaded from: classes3.dex */
public final class C12063b<T, K> extends AbstractIterator3<T> {

    /* renamed from: l */
    public final HashSet<K> f25072l;

    /* renamed from: m */
    public final Iterator<T> f25073m;

    /* renamed from: n */
    public final Function1<T, K> f25074n;

    /* JADX WARN: Multi-variable type inference failed */
    public C12063b(Iterator<? extends T> it, Function1<? super T, ? extends K> function1) {
        Intrinsics3.checkNotNullParameter(it, "source");
        Intrinsics3.checkNotNullParameter(function1, "keySelector");
        this.f25073m = it;
        this.f25074n = function1;
        this.f25072l = new HashSet<>();
    }

    @Override // p507d0.p580t.AbstractIterator3
    /* renamed from: a */
    public void mo10059a() {
        while (this.f25073m.hasNext()) {
            T next = this.f25073m.next();
            if (this.f25072l.add(this.f25074n.invoke(next))) {
                m10074b(next);
                return;
            }
        }
        this.f25173j = 3;
    }
}
