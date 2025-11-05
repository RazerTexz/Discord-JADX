package j0.n;

import b.i.a.f.e.o.f;
import j0.g;
import j0.l.a.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public class c<T> implements g<T> {
    public final g<? super T> j;
    public boolean k;
    public volatile boolean l;
    public a m;

    /* compiled from: SerializedObserver.java */
    public static final class a {
        public Object[] a;

        /* renamed from: b, reason: collision with root package name */
        public int f3800b;

        public void a(Object obj) {
            int i = this.f3800b;
            Object[] objArr = this.a;
            if (objArr == null) {
                objArr = new Object[16];
                this.a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f3800b = i + 1;
        }
    }

    public c(g<? super T> gVar) {
        this.j = gVar;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            this.l = true;
            if (!this.k) {
                this.k = true;
                this.j.onCompleted();
                return;
            }
            a aVar = this.m;
            if (aVar == null) {
                aVar = new a();
                this.m = aVar;
            }
            aVar.a(j0.l.a.e.a);
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        f.o1(th);
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            this.l = true;
            if (!this.k) {
                this.k = true;
                this.j.onError(th);
                return;
            }
            a aVar = this.m;
            if (aVar == null) {
                aVar = new a();
                this.m = aVar;
            }
            aVar.a(new e.c(th));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x002d, code lost:
    
        continue;
     */
    @Override // j0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            if (this.k) {
                a aVar = this.m;
                if (aVar == null) {
                    aVar = new a();
                    this.m = aVar;
                }
                if (t == null) {
                    t = (T) j0.l.a.e.f3771b;
                }
                aVar.a(t);
                return;
            }
            this.k = true;
            try {
                this.j.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.m;
                        if (aVar2 == null) {
                            this.k = false;
                            return;
                        }
                        this.m = null;
                        for (Object obj : aVar2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (j0.l.a.e.a(this.j, obj)) {
                                    this.l = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.l = true;
                                f.o1(th);
                                this.j.onError(OnErrorThrowable.a(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.l = true;
                f.p1(th2, this.j, t);
            }
        }
    }
}
