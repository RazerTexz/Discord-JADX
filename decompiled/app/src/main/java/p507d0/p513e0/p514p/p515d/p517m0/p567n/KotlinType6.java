package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.v, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType6 extends KotlinType3 implements InterfaceC11977f {

    /* JADX INFO: renamed from: k */
    public final KotlinType4 f24887k;

    /* JADX INFO: renamed from: l */
    public final KotlinType4 f24888l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinType6(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        super(null);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
        this.f24887k = kotlinType4;
        this.f24888l = kotlinType42;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract KotlinType4 getDelegate();

    public final KotlinType4 getLowerBound() {
        return this.f24887k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public final KotlinType4 getUpperBound() {
        return this.f24888l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4);

    public String toString() {
        return DescriptorRenderer2.f24227c.renderType(this);
    }
}
