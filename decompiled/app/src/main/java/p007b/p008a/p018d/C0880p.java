package p007b.p008a.p018d;

import java.util.Map;
import p637j0.p641k.Func1;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: AppTransformers.kt */
/* renamed from: b.a.d.p */
/* loaded from: classes.dex */
public final class C0880p<T, R, K> implements Func1<K, Boolean> {

    /* renamed from: j */
    public final /* synthetic */ Map f575j;

    public C0880p(Map map) {
        this.f575j = map;
    }

    @Override // p637j0.p641k.Func1
    public Boolean call(Object obj) {
        return Boolean.valueOf(this.f575j.containsKey(obj));
    }
}
