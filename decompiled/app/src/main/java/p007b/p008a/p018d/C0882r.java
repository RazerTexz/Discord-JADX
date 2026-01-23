package p007b.p008a.p018d;

import java.util.Map;
import p637j0.p641k.Func1;

/* JADX INFO: Add missing generic type declarations: [K, V1] */
/* JADX INFO: renamed from: b.a.d.r */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0882r<T, R, K, V1> implements Func1<K, V1> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0883s f577j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Map f578k;

    public C0882r(C0883s c0883s, Map map) {
        this.f577j = c0883s;
        this.f578k = map;
    }

    @Override // p637j0.p641k.Func1
    public final V1 call(K k) {
        return (V1) this.f577j.f579j.f570k.invoke(this.f578k.get(k));
    }
}
