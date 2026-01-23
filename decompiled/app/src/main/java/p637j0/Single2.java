package p637j0;

import p637j0.p641k.Func1;
import p637j0.p652o.C12774l;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.h, reason: use source file name */
/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes3.dex */
public class Single2<T> {

    /* JADX INFO: renamed from: a */
    public final a<T> f26696a;

    /* JADX INFO: renamed from: j0.h$a */
    /* JADX INFO: compiled from: Single.java */
    public interface a<T> extends Action1<SingleSubscriber<? super T>> {
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=j0.h$a<T>, code=j0.h$a, for r2v0, types: [j0.h$a<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Single2(a aVar) {
        Func1<a, a> func1 = C12774l.f27376c;
        this.f26696a = func1 != null ? func1.call(aVar) : aVar;
    }
}
