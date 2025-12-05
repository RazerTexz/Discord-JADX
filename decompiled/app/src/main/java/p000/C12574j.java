package p000;

import java.util.Map;
import java.util.Set;
import p637j0.p641k.Func1;

/* compiled from: java-style lambda group */
/* renamed from: j */
/* loaded from: classes2.dex */
public final class C12574j<T, R> implements Func1<Map<Long, ? extends Integer>, Set<? extends Long>> {

    /* renamed from: j */
    public static final C12574j f26680j = new C12574j(0);

    /* renamed from: k */
    public static final C12574j f26681k = new C12574j(1);

    /* renamed from: l */
    public final /* synthetic */ int f26682l;

    public C12574j(int i) {
        this.f26682l = i;
    }

    @Override // p637j0.p641k.Func1
    public final Set<? extends Long> call(Map<Long, ? extends Integer> map) {
        int i = this.f26682l;
        if (i == 0) {
            return map.keySet();
        }
        if (i == 1) {
            return map.keySet();
        }
        throw null;
    }
}
