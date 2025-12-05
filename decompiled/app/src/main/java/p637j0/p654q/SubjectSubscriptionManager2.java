package p637j0.p654q;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.Observer2;
import p637j0.p641k.Actions2;
import p637j0.p642l.p643a.NotificationLite;
import p637j0.p655r.BooleanSubscription;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Action1;

/* compiled from: SubjectSubscriptionManager.java */
/* renamed from: j0.q.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class SubjectSubscriptionManager2<T> extends AtomicReference<a<T>> implements Observable.InterfaceC13005a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    public boolean active;
    public volatile Object latest;
    public Action1<b<T>> onAdded;
    public Action1<b<T>> onStart;
    public Action1<b<T>> onTerminated;

    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: j0.q.c$a */
    public static final class a<T> {

        /* renamed from: a */
        public static final b[] f27409a;

        /* renamed from: b */
        public static final a f27410b;

        /* renamed from: c */
        public static final a f27411c;

        /* renamed from: d */
        public final boolean f27412d;

        /* renamed from: e */
        public final b[] f27413e;

        static {
            b[] bVarArr = new b[0];
            f27409a = bVarArr;
            f27410b = new a(true, bVarArr);
            f27411c = new a(false, bVarArr);
        }

        public a(boolean z2, b[] bVarArr) {
            this.f27412d = z2;
            this.f27413e = bVarArr;
        }
    }

    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: j0.q.c$b */
    public static final class b<T> implements Observer2<T> {

        /* renamed from: j */
        public final Subscriber<? super T> f27414j;

        /* renamed from: k */
        public boolean f27415k = true;

        /* renamed from: l */
        public boolean f27416l;

        /* renamed from: m */
        public List<Object> f27417m;

        /* renamed from: n */
        public boolean f27418n;

        public b(Subscriber<? super T> subscriber) {
            this.f27414j = subscriber;
        }

        /* renamed from: a */
        public void m10880a(Object obj) {
            if (!this.f27418n) {
                synchronized (this) {
                    this.f27415k = false;
                    if (this.f27416l) {
                        if (this.f27417m == null) {
                            this.f27417m = new ArrayList();
                        }
                        this.f27417m.add(obj);
                        return;
                    }
                    this.f27418n = true;
                }
            }
            NotificationLite.m10744a(this.f27414j, obj);
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.f27414j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            this.f27414j.onError(th);
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            this.f27414j.onNext(t);
        }
    }

    public SubjectSubscriptionManager2() {
        super(a.f27411c);
        this.active = true;
        Actions2.a aVar = Actions2.f26710a;
        this.onStart = aVar;
        this.onAdded = aVar;
        this.onTerminated = aVar;
    }

    /* renamed from: a */
    public void m10878a(b<T> bVar) {
        a<T> aVar;
        a<T> aVar2;
        do {
            aVar = get();
            if (aVar.f27412d) {
                return;
            }
            b<T>[] bVarArr = aVar.f27413e;
            int length = bVarArr.length;
            if (length == 1 && bVarArr[0] == bVar) {
                aVar2 = a.f27411c;
            } else {
                if (length == 0) {
                    aVar2 = aVar;
                    break;
                }
                int i = length - 1;
                b[] bVarArr2 = new b[i];
                int i2 = 0;
                for (b<T> bVar2 : bVarArr) {
                    if (bVar2 != bVar) {
                        if (i2 == i) {
                            aVar2 = aVar;
                            break;
                        } else {
                            bVarArr2[i2] = bVar2;
                            i2++;
                        }
                    }
                }
                if (i2 == 0) {
                    aVar2 = a.f27411c;
                } else {
                    if (i2 < i) {
                        b[] bVarArr3 = new b[i2];
                        System.arraycopy(bVarArr2, 0, bVarArr3, 0, i2);
                        bVarArr2 = bVarArr3;
                    }
                    aVar2 = new a<>(aVar.f27412d, bVarArr2);
                }
            }
            if (aVar2 == aVar) {
                return;
            }
        } while (!compareAndSet(aVar, aVar2));
    }

    /* renamed from: b */
    public b<T>[] m10879b(Object obj) {
        this.latest = obj;
        this.active = false;
        return get().f27412d ? a.f27409a : getAndSet(a.f27410b).f27413e;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        b<T> bVar = new b<>(subscriber);
        subscriber.add(new BooleanSubscription(new SubjectSubscriptionManager(this, bVar)));
        this.onStart.call(bVar);
        if (subscriber.isUnsubscribed()) {
            return;
        }
        while (true) {
            a<T> aVar = get();
            z2 = false;
            if (aVar.f27412d) {
                this.onTerminated.call(bVar);
                break;
            }
            b[] bVarArr = aVar.f27413e;
            int length = bVarArr.length;
            b[] bVarArr2 = new b[length + 1];
            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
            bVarArr2[length] = bVar;
            if (compareAndSet(aVar, new a(aVar.f27412d, bVarArr2))) {
                this.onAdded.call(bVar);
                z2 = true;
                break;
            }
        }
        if (z2 && subscriber.isUnsubscribed()) {
            m10878a(bVar);
        }
    }
}
