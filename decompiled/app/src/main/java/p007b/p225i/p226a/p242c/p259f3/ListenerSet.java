package p007b.p225i.p226a.p242c.p259f3;

import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;

/* JADX INFO: renamed from: b.i.a.c.f3.p, reason: use source file name */
/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ListenerSet<T> {

    /* JADX INFO: renamed from: a */
    public final Clock4 f6736a;

    /* JADX INFO: renamed from: b */
    public final HandlerWrapper f6737b;

    /* JADX INFO: renamed from: c */
    public final b<T> f6738c;

    /* JADX INFO: renamed from: d */
    public final CopyOnWriteArraySet<c<T>> f6739d;

    /* JADX INFO: renamed from: e */
    public final ArrayDeque<Runnable> f6740e = new ArrayDeque<>();

    /* JADX INFO: renamed from: f */
    public final ArrayDeque<Runnable> f6741f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g */
    public boolean f6742g;

    /* JADX INFO: renamed from: b.i.a.c.f3.p$a */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface a<T> {
        void invoke(T t);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$b */
    /* JADX INFO: compiled from: ListenerSet.java */
    public interface b<T> {
        /* JADX INFO: renamed from: a */
        void mo3037a(T t, FlagSet flagSet);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.p$c */
    /* JADX INFO: compiled from: ListenerSet.java */
    public static final class c<T> {

        /* JADX INFO: renamed from: a */
        public final T f6743a;

        /* JADX INFO: renamed from: b */
        public FlagSet.b f6744b = new FlagSet.b();

        /* JADX INFO: renamed from: c */
        public boolean f6745c;

        /* JADX INFO: renamed from: d */
        public boolean f6746d;

        public c(T t) {
            this.f6743a = t;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f6743a.equals(((c) obj).f6743a);
        }

        public int hashCode() {
            return this.f6743a.hashCode();
        }
    }

    public ListenerSet(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, Clock4 clock4, b<T> bVar) {
        this.f6736a = clock4;
        this.f6739d = copyOnWriteArraySet;
        this.f6738c = bVar;
        this.f6737b = clock4.mo2950b(looper, new C2731b(this));
    }

    /* JADX INFO: renamed from: a */
    public void m3034a() {
        if (this.f6741f.isEmpty()) {
            return;
        }
        if (!this.f6737b.mo2958e(0)) {
            HandlerWrapper handlerWrapper = this.f6737b;
            handlerWrapper.mo2957d(handlerWrapper.mo2956c(0));
        }
        boolean z2 = !this.f6740e.isEmpty();
        this.f6740e.addAll(this.f6741f);
        this.f6741f.clear();
        if (z2) {
            return;
        }
        while (!this.f6740e.isEmpty()) {
            this.f6740e.peekFirst().run();
            this.f6740e.removeFirst();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3035b(int i, a<T> aVar) {
        this.f6741f.add(new RunnableC2729a(new CopyOnWriteArraySet(this.f6739d), i, aVar));
    }

    /* JADX INFO: renamed from: c */
    public void m3036c() {
        for (c<T> cVar : this.f6739d) {
            b<T> bVar = this.f6738c;
            cVar.f6746d = true;
            if (cVar.f6745c) {
                bVar.mo3037a(cVar.f6743a, cVar.f6744b.m3033b());
            }
        }
        this.f6739d.clear();
        this.f6742g = true;
    }
}
