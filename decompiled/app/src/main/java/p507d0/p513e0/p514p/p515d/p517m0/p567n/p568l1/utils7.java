package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.r, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils7 {

    /* JADX INFO: renamed from: a */
    public final KotlinType f24829a;

    /* JADX INFO: renamed from: b */
    public final utils7 f24830b;

    public utils7(KotlinType kotlinType, utils7 utils7Var) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.f24829a = kotlinType;
        this.f24830b = utils7Var;
    }

    public final utils7 getPrevious() {
        return this.f24830b;
    }

    public final KotlinType getType() {
        return this.f24829a;
    }
}
