package rx.subjects;

import b.i.a.f.e.o.f;
import j0.l.a.e;
import j0.q.c;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final c<T> l;

    public static class a implements Action1<c.b<T>> {
        public final /* synthetic */ c j;

        public a(c cVar) {
            this.j = cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x003d A[Catch: all -> 0x0039, TryCatch #5 {all -> 0x0039, blocks: (B:18:0x0023, B:19:0x0027, B:21:0x002d, B:23:0x0033, B:27:0x003d, B:28:0x0043), top: B:67:0x0023 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // rx.functions.Action1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(Object obj) throws Throwable {
            c.b bVar = (c.b) obj;
            Object obj2 = this.j.latest;
            synchronized (bVar) {
                if (bVar.k && !bVar.l) {
                    bVar.k = false;
                    boolean z2 = true;
                    bVar.l = obj2 != null;
                    if (obj2 != null) {
                        List<Object> list = null;
                        boolean z3 = true;
                        while (true) {
                            if (list == null) {
                                if (z3) {
                                }
                                synchronized (bVar) {
                                }
                                throw th;
                            }
                            try {
                                for (Object obj3 : list) {
                                    if (obj3 != null) {
                                        e.a(bVar.j, obj3);
                                    }
                                }
                                if (z3) {
                                    e.a(bVar.j, obj2);
                                    z3 = false;
                                }
                                try {
                                    synchronized (bVar) {
                                        try {
                                            list = bVar.m;
                                            bVar.m = null;
                                            if (list == null) {
                                                bVar.l = false;
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            z2 = false;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                z2 = false;
                            }
                            if (!z2) {
                                synchronized (bVar) {
                                    bVar.l = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public BehaviorSubject(Observable.a<T> aVar, c<T> cVar) {
        super(aVar);
        this.l = cVar;
    }

    public static <T> BehaviorSubject<T> k0() {
        return m0(null, false);
    }

    public static <T> BehaviorSubject<T> l0(T t) {
        return m0(t, true);
    }

    public static <T> BehaviorSubject<T> m0(T t, boolean z2) {
        c cVar = new c();
        if (z2) {
            if (t == null) {
                t = (T) e.f3771b;
            }
            cVar.latest = t;
        }
        a aVar = new a(cVar);
        cVar.onAdded = aVar;
        cVar.onTerminated = aVar;
        return new BehaviorSubject<>(cVar, cVar);
    }

    public T n0() {
        Object obj = this.l.latest;
        if ((obj == null || (obj instanceof e.c) || e.c(obj)) ? false : true) {
            return (T) e.b(obj);
        }
        return null;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l.latest == null || this.l.active) {
            Object obj = e.a;
            for (c.b<T> bVar : this.l.b(obj)) {
                bVar.a(obj);
            }
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.l.latest == null || this.l.active) {
            e.c cVar = new e.c(th);
            ArrayList arrayList = null;
            for (c.b<T> bVar : this.l.b(cVar)) {
                try {
                    bVar.a(cVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            f.n1(arrayList);
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        if (this.l.latest == null || this.l.active) {
            if (t == null) {
                t = (T) e.f3771b;
            }
            c<T> cVar = this.l;
            cVar.latest = t;
            for (c.b bVar : cVar.get().e) {
                bVar.a(t);
            }
        }
    }
}
