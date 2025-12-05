package p007b.p225i.p361c.p368l;

import p007b.p225i.p361c.p400t.Provider2;

/* compiled from: Lazy.java */
/* renamed from: b.i.c.l.r, reason: use source file name */
/* loaded from: classes3.dex */
public class Lazy2<T> implements Provider2<T> {

    /* renamed from: a */
    public static final Object f12209a = new Object();

    /* renamed from: b */
    public volatile Object f12210b = f12209a;

    /* renamed from: c */
    public volatile Provider2<T> f12211c;

    public Lazy2(Provider2<T> provider2) {
        this.f12211c = provider2;
    }

    @Override // p007b.p225i.p361c.p400t.Provider2
    public T get() {
        T t = (T) this.f12210b;
        Object obj = f12209a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f12210b;
                if (t == obj) {
                    t = this.f12211c.get();
                    this.f12210b = t;
                    this.f12211c = null;
                }
            }
        }
        return t;
    }
}
