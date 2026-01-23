package p007b.p085c.p086a.p095y.p096k;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;

/* JADX INFO: renamed from: b.c.a.y.k.n, reason: use source file name */
/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* JADX INFO: renamed from: a */
    public final List<Keyframe<V>> f2738a;

    public BaseAnimatableValue(V v) {
        this.f2738a = Collections.singletonList(new Keyframe(v));
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: b */
    public List<Keyframe<V>> mo774b() {
        return this.f2738a;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    public boolean isStatic() {
        return this.f2738a.isEmpty() || (this.f2738a.size() == 1 && this.f2738a.get(0).m667d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2738a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2738a.toArray()));
        }
        return sb.toString();
    }

    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f2738a = list;
    }
}
