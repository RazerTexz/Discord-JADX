package p637j0.p642l.p647e;

import p637j0.Notification;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.e.e, reason: use source file name */
/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum InternalObservableUtils {
    ;


    /* JADX INFO: renamed from: j */
    public static final e f27270j = new e();

    /* JADX INFO: renamed from: k */
    public static final b f27271k = new b();

    /* JADX INFO: renamed from: l */
    public static final Action1<Throwable> f27272l = new a();

    /* JADX INFO: renamed from: j0.l.e.e$a */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class a implements Action1<Throwable> {
        @Override // p658rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$b */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class b implements Func1<Notification<?>, Throwable> {
        @Override // p637j0.p641k.Func1
        public Throwable call(Notification<?> notification) {
            return notification.f26690c;
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$c */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class c implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* JADX INFO: renamed from: j */
        public final Func1<? super Observable<? extends Void>, ? extends Observable<?>> f27274j;

        public c(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.f27274j = func1;
        }

        @Override // p637j0.p641k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.f27274j.call(observable.m11083G(InternalObservableUtils.f27270j));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$d */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class d implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        /* JADX INFO: renamed from: j */
        public final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> f27275j;

        public d(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.f27275j = func1;
        }

        @Override // p637j0.p641k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.f27275j.call(observable.m11083G(InternalObservableUtils.f27271k));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$e */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class e implements Func1<Object, Void> {
        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }
}
