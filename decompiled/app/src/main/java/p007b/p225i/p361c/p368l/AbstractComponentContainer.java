package p007b.p225i.p361c.p368l;

import java.util.Set;
import p007b.p225i.p361c.p400t.Provider2;

/* compiled from: AbstractComponentContainer.java */
/* renamed from: b.i.c.l.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractComponentContainer implements ComponentContainer {
    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: a */
    public <T> T mo6346a(Class<T> cls) {
        Provider2<T> provider2Mo6355b = mo6355b(cls);
        if (provider2Mo6355b == null) {
            return null;
        }
        return provider2Mo6355b.get();
    }

    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: d */
    public <T> Set<T> mo6347d(Class<T> cls) {
        return mo6356c(cls).get();
    }
}
