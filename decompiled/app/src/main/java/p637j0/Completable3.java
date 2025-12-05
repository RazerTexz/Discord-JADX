package p637j0;

import p637j0.p641k.Func1;
import p637j0.p652o.C12774l;
import p658rx.functions.Action1;

/* compiled from: Completable.java */
/* renamed from: j0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class Completable3 {

    /* renamed from: a */
    public final a f26687a;

    /* compiled from: Completable.java */
    /* renamed from: j0.d$a */
    public interface a extends Action1<CompletableSubscriber> {
    }

    public Completable3(a aVar) {
        Func1<a, a> func1 = C12774l.f27377d;
        this.f26687a = func1 != null ? func1.call(aVar) : aVar;
    }
}
