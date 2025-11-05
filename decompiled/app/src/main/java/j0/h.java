package j0;

import j0.o.l;
import rx.functions.Action1;

/* compiled from: Single.java */
/* loaded from: classes3.dex */
public class h<T> {
    public final a<T> a;

    /* compiled from: Single.java */
    public interface a<T> extends Action1<i<? super T>> {
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=j0.h$a<T>, code=j0.h$a, for r2v0, types: [j0.h$a<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(a aVar) {
        j0.k.b<a, a> bVar = l.c;
        this.a = bVar != null ? bVar.call(aVar) : aVar;
    }
}
