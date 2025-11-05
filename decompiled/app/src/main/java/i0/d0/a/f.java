package i0.d0.a;

import j0.h;
import j0.l.a.e0;
import j0.o.l;
import java.lang.reflect.Type;
import rx.Observable;
import rx.Scheduler;

/* compiled from: RxJavaCallAdapter.java */
/* loaded from: classes3.dex */
public final class f<R> implements i0.e<R, Object> {
    public final Type a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3736b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public f(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = type;
        this.f3736b = z3;
        this.c = z4;
        this.d = z5;
        this.e = z6;
    }

    @Override // i0.e
    public Type a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    @Override // i0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(i0.d<R> dVar) {
        Observable.a aVar;
        Observable.a cVar = new c(dVar);
        if (!this.f3736b) {
            if (this.c) {
                aVar = new a(cVar);
            }
            Observable observable = new Observable(l.a(cVar));
            if (!this.d) {
                return new h(new e0(observable));
            }
            if (!this.e) {
                return observable;
            }
            try {
                return new j0.d(new j0.c(observable));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                l.b(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        aVar = new e(cVar);
        cVar = aVar;
        Observable observable2 = new Observable(l.a(cVar));
        if (!this.d) {
        }
    }
}
