package b.f.j.l;

import b.f.j.l.g;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBucketsPoolBackend.java */
/* loaded from: classes3.dex */
public abstract class q<T> {
    public final Set<T> a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final g<T> f598b = new g<>();

    public abstract T a(int i);

    public abstract int b(T t);

    public T c() {
        T t;
        g<T> gVar = this.f598b;
        synchronized (gVar) {
            g.b<T> bVar = gVar.c;
            if (bVar == null) {
                t = null;
            } else {
                T tPollLast = bVar.c.pollLast();
                if (bVar.c.isEmpty()) {
                    gVar.b(bVar);
                    gVar.a.remove(bVar.f596b);
                }
                t = tPollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.a.remove(t);
            }
        }
        return t;
    }
}
