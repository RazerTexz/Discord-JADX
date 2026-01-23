package p658rx.subjects;

import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.NotificationLite;
import p637j0.p654q.SubjectSubscriptionManager2;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {

    /* JADX INFO: renamed from: k */
    public static final Object[] f27647k = new Object[0];

    /* JADX INFO: renamed from: l */
    public final SubjectSubscriptionManager2<T> f27648l;

    /* JADX INFO: renamed from: rx.subjects.BehaviorSubject$a */
    public static class C13014a implements Action1<SubjectSubscriptionManager2.b<T>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ SubjectSubscriptionManager2 f27649j;

        public C13014a(SubjectSubscriptionManager2 subjectSubscriptionManager2) {
            this.f27649j = subjectSubscriptionManager2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x003d A[Catch: all -> 0x0039, TryCatch #5 {all -> 0x0039, blocks: (B:18:0x0023, B:19:0x0027, B:21:0x002d, B:23:0x0033, B:27:0x003d, B:28:0x0043), top: B:67:0x0023 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // p658rx.functions.Action1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(Object obj) throws Throwable {
            SubjectSubscriptionManager2.b bVar = (SubjectSubscriptionManager2.b) obj;
            Object obj2 = this.f27649j.latest;
            synchronized (bVar) {
                if (bVar.f27415k && !bVar.f27416l) {
                    bVar.f27415k = false;
                    boolean z2 = true;
                    bVar.f27416l = obj2 != null;
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
                                        NotificationLite.m10744a(bVar.f27414j, obj3);
                                    }
                                }
                                if (z3) {
                                    NotificationLite.m10744a(bVar.f27414j, obj2);
                                    z3 = false;
                                }
                                try {
                                    synchronized (bVar) {
                                        try {
                                            list = bVar.f27417m;
                                            bVar.f27417m = null;
                                            if (list == null) {
                                                bVar.f27416l = false;
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
                                    bVar.f27416l = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public BehaviorSubject(Observable.InterfaceC13005a<T> interfaceC13005a, SubjectSubscriptionManager2<T> subjectSubscriptionManager2) {
        super(interfaceC13005a);
        this.f27648l = subjectSubscriptionManager2;
    }

    /* JADX INFO: renamed from: k0 */
    public static <T> BehaviorSubject<T> m11129k0() {
        return m11131m0(null, false);
    }

    /* JADX INFO: renamed from: l0 */
    public static <T> BehaviorSubject<T> m11130l0(T t) {
        return m11131m0(t, true);
    }

    /* JADX INFO: renamed from: m0 */
    public static <T> BehaviorSubject<T> m11131m0(T t, boolean z2) {
        SubjectSubscriptionManager2 subjectSubscriptionManager2 = new SubjectSubscriptionManager2();
        if (z2) {
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            subjectSubscriptionManager2.latest = t;
        }
        C13014a c13014a = new C13014a(subjectSubscriptionManager2);
        subjectSubscriptionManager2.onAdded = c13014a;
        subjectSubscriptionManager2.onTerminated = c13014a;
        return new BehaviorSubject<>(subjectSubscriptionManager2, subjectSubscriptionManager2);
    }

    /* JADX INFO: renamed from: n0 */
    public T m11132n0() {
        Object obj = this.f27648l.latest;
        if ((obj == null || (obj instanceof NotificationLite.c) || NotificationLite.m10746c(obj)) ? false : true) {
            return (T) NotificationLite.m10745b(obj);
        }
        return null;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f27648l.latest == null || this.f27648l.active) {
            Object obj = NotificationLite.f26768a;
            for (SubjectSubscriptionManager2.b<T> bVar : this.f27648l.m10879b(obj)) {
                bVar.m10880a(obj);
            }
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        if (this.f27648l.latest == null || this.f27648l.active) {
            NotificationLite.c cVar = new NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager2.b<T> bVar : this.f27648l.m10879b(cVar)) {
                try {
                    bVar.m10880a(cVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C3404f.m4321n1(arrayList);
        }
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (this.f27648l.latest == null || this.f27648l.active) {
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            SubjectSubscriptionManager2<T> subjectSubscriptionManager2 = this.f27648l;
            subjectSubscriptionManager2.latest = t;
            for (SubjectSubscriptionManager2.b bVar : subjectSubscriptionManager2.get().f27413e) {
                bVar.m10880a(t);
            }
        }
    }
}
