package p630i0.p631d0.p632a;

import java.lang.reflect.Type;
import p630i0.Call3;
import p630i0.CallAdapter;
import p637j0.Completable2;
import p637j0.Completable3;
import p637j0.Single2;
import p637j0.p642l.p643a.OnSubscribeSingle2;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Scheduler;

/* JADX INFO: renamed from: i0.d0.a.f, reason: use source file name */
/* JADX INFO: compiled from: RxJavaCallAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {

    /* JADX INFO: renamed from: a */
    public final Type f26505a;

    /* JADX INFO: renamed from: b */
    public final boolean f26506b;

    /* JADX INFO: renamed from: c */
    public final boolean f26507c;

    /* JADX INFO: renamed from: d */
    public final boolean f26508d;

    /* JADX INFO: renamed from: e */
    public final boolean f26509e;

    public RxJavaCallAdapter(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f26505a = type;
        this.f26506b = z3;
        this.f26507c = z4;
        this.f26508d = z5;
        this.f26509e = z6;
    }

    @Override // p630i0.CallAdapter
    /* JADX INFO: renamed from: a */
    public Type mo10705a() {
        return this.f26505a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    @Override // p630i0.CallAdapter
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo10706b(Call3<R> call3) {
        Observable.InterfaceC13005a bodyOnSubscribe;
        Observable.InterfaceC13005a callExecuteOnSubscribe = new CallExecuteOnSubscribe(call3);
        if (!this.f26506b) {
            if (this.f26507c) {
                bodyOnSubscribe = new BodyOnSubscribe(callExecuteOnSubscribe);
            }
            Observable observable = new Observable(C12774l.m10862a(callExecuteOnSubscribe));
            if (!this.f26508d) {
                return new Single2(new OnSubscribeSingle2(observable));
            }
            if (!this.f26509e) {
                return observable;
            }
            try {
                return new Completable3(new Completable2(observable));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                C12774l.m10863b(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        bodyOnSubscribe = new ResultOnSubscribe(callExecuteOnSubscribe);
        callExecuteOnSubscribe = bodyOnSubscribe;
        Observable observable2 = new Observable(C12774l.m10862a(callExecuteOnSubscribe));
        if (!this.f26508d) {
        }
    }
}
