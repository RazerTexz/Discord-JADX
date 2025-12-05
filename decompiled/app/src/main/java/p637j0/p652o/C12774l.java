package p637j0.p652o;

import java.io.PrintStream;
import p007b.p100d.p104b.p105a.outline;
import p637j0.Completable3;
import p637j0.Single2;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* compiled from: RxJavaHooks.java */
/* renamed from: j0.o.l */
/* loaded from: classes3.dex */
public final class C12774l {

    /* renamed from: a */
    public static volatile Action1<Throwable> f27374a = new C12768f();

    /* renamed from: e */
    public static volatile Func2<Observable, Observable.InterfaceC13005a, Observable.InterfaceC13005a> f27378e = new C12769g();

    /* renamed from: g */
    public static volatile Func1<Subscription, Subscription> f27380g = new C12770h();

    /* renamed from: f */
    public static volatile Func1<Action0, Action0> f27379f = new C12771i();

    /* renamed from: h */
    public static volatile Func1<Throwable, Throwable> f27381h = new C12772j();

    /* renamed from: i */
    public static volatile Func1<Observable.InterfaceC13006b, Observable.InterfaceC13006b> f27382i = new C12773k();

    /* renamed from: b */
    public static volatile Func1<Observable.InterfaceC13005a, Observable.InterfaceC13005a> f27375b = new C12765c();

    /* renamed from: c */
    public static volatile Func1<Single2.a, Single2.a> f27376c = new C12766d();

    /* renamed from: d */
    public static volatile Func1<Completable3.a, Completable3.a> f27377d = new C12767e();

    /* renamed from: a */
    public static <T> Observable.InterfaceC13005a<T> m10862a(Observable.InterfaceC13005a<T> interfaceC13005a) {
        Func1<Observable.InterfaceC13005a, Observable.InterfaceC13005a> func1 = f27375b;
        return func1 != null ? func1.call(interfaceC13005a) : interfaceC13005a;
    }

    /* renamed from: b */
    public static void m10863b(Throwable th) {
        Action1<Throwable> action1 = f27374a;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                StringBuilder sbM833U = outline.m833U("The onError handler threw an Exception. It shouldn't. => ");
                sbM833U.append(th2.getMessage());
                printStream.println(sbM833U.toString());
                th2.printStackTrace();
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    /* renamed from: c */
    public static Throwable m10864c(Throwable th) {
        Func1<Throwable, Throwable> func1 = f27381h;
        return func1 != null ? func1.call(th) : th;
    }

    /* renamed from: d */
    public static Action0 m10865d(Action0 action0) {
        Func1<Action0, Action0> func1 = f27379f;
        return func1 != null ? func1.call(action0) : action0;
    }
}
