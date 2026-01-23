package p637j0;

import p637j0.p641k.Func1;
import p637j0.p652o.C12774l;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.d, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class Completable3 {

    /* JADX INFO: renamed from: a */
    public final a f26687a;

    /* JADX INFO: renamed from: j0.d$a */
    /* JADX INFO: compiled from: Completable.java */
    public interface a extends Action1<CompletableSubscriber> {
    }

    public Completable3(a aVar) {
        Func1<a, a> func1 = C12774l.f27377d;
        this.f26687a = func1 != null ? func1.call(aVar) : aVar;
    }
}
