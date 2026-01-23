package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k1, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType5 extends KotlinType {
    public KotlinType5() {
        super(null);
    }

    /* JADX INFO: renamed from: a */
    public abstract KotlinType mo10011a();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return mo10011a().getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return mo10011a().getArguments();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeConstructor getConstructor() {
        return mo10011a().getConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        return mo10011a().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return mo10011a().isMarkedNullable();
    }

    public String toString() {
        return isComputed() ? mo10011a().toString() : "<Not computed yet>";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public final KotlinType3 unwrap() {
        KotlinType kotlinTypeMo10011a = mo10011a();
        while (kotlinTypeMo10011a instanceof KotlinType5) {
            kotlinTypeMo10011a = ((KotlinType5) kotlinTypeMo10011a).mo10011a();
        }
        return (KotlinType3) kotlinTypeMo10011a;
    }
}
