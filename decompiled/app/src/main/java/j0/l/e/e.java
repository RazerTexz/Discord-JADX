package j0.l.e;

import rx.Observable;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

/* compiled from: InternalObservableUtils.java */
/* loaded from: classes3.dex */
public enum e {
    ;

    public static final C0634e j = new C0634e();
    public static final b k = new b();
    public static final Action1<Throwable> l = new a();

    /* compiled from: InternalObservableUtils.java */
    public static final class a implements Action1<Throwable> {
        @Override // rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* compiled from: InternalObservableUtils.java */
    public static final class b implements j0.k.b<j0.f<?>, Throwable> {
        @Override // j0.k.b
        public Throwable call(j0.f<?> fVar) {
            return fVar.c;
        }
    }

    /* compiled from: InternalObservableUtils.java */
    public static final class c implements j0.k.b<Observable<? extends j0.f<?>>, Observable<?>> {
        public final j0.k.b<? super Observable<? extends Void>, ? extends Observable<?>> j;

        public c(j0.k.b<? super Observable<? extends Void>, ? extends Observable<?>> bVar) {
            this.j = bVar;
        }

        @Override // j0.k.b
        public Observable<?> call(Observable<? extends j0.f<?>> observable) {
            return this.j.call(observable.G(e.j));
        }
    }

    /* compiled from: InternalObservableUtils.java */
    public static final class d implements j0.k.b<Observable<? extends j0.f<?>>, Observable<?>> {
        public final j0.k.b<? super Observable<? extends Throwable>, ? extends Observable<?>> j;

        public d(j0.k.b<? super Observable<? extends Throwable>, ? extends Observable<?>> bVar) {
            this.j = bVar;
        }

        @Override // j0.k.b
        public Observable<?> call(Observable<? extends j0.f<?>> observable) {
            return this.j.call(observable.G(e.k));
        }
    }

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$e, reason: collision with other inner class name */
    public static final class C0634e implements j0.k.b<Object, Void> {
        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }
}
