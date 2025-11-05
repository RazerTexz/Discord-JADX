package b.i.a.c.f3;

import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.f3.n;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ListenerSet.java */
/* loaded from: classes3.dex */
public final class p<T> {
    public final g a;

    /* renamed from: b, reason: collision with root package name */
    public final o f973b;
    public final b<T> c;
    public final CopyOnWriteArraySet<c<T>> d;
    public final ArrayDeque<Runnable> e = new ArrayDeque<>();
    public final ArrayDeque<Runnable> f = new ArrayDeque<>();
    public boolean g;

    /* compiled from: ListenerSet.java */
    public interface a<T> {
        void invoke(T t);
    }

    /* compiled from: ListenerSet.java */
    public interface b<T> {
        void a(T t, n nVar);
    }

    /* compiled from: ListenerSet.java */
    public static final class c<T> {
        public final T a;

        /* renamed from: b, reason: collision with root package name */
        public n.b f974b = new n.b();
        public boolean c;
        public boolean d;

        public c(T t) {
            this.a = t;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public p(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, g gVar, b<T> bVar) {
        this.a = gVar;
        this.d = copyOnWriteArraySet;
        this.c = bVar;
        this.f973b = gVar.b(looper, new b.i.a.c.f3.b(this));
    }

    public void a() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.f973b.e(0)) {
            o oVar = this.f973b;
            oVar.d(oVar.c(0));
        }
        boolean z2 = !this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (z2) {
            return;
        }
        while (!this.e.isEmpty()) {
            this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }

    public void b(int i, a<T> aVar) {
        this.f.add(new b.i.a.c.f3.a(new CopyOnWriteArraySet(this.d), i, aVar));
    }

    public void c() {
        Iterator<c<T>> it = this.d.iterator();
        while (it.hasNext()) {
            c<T> next = it.next();
            b<T> bVar = this.c;
            next.d = true;
            if (next.c) {
                bVar.a(next.a, next.f974b.b());
            }
        }
        this.d.clear();
        this.g = true;
    }
}
