package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KotlinTypeFactory.kt */
/* renamed from: d0.e0.p.d.m0.n.k0, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory5 extends KotlinType4 {

    /* renamed from: k */
    public final TypeConstructor f24791k;

    /* renamed from: l */
    public final List<TypeProjection> f24792l;

    /* renamed from: m */
    public final boolean f24793m;

    /* renamed from: n */
    public final MemberScope3 f24794n;

    /* renamed from: o */
    public final Function1<KotlinTypeRefiner, KotlinType4> f24795o;

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinTypeFactory5(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z2, MemberScope3 memberScope3, Function1<? super KotlinTypeRefiner, ? extends KotlinType4> function1) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(function1, "refinedTypeFactory");
        this.f24791k = typeConstructor;
        this.f24792l = list;
        this.f24793m = z2;
        this.f24794n = memberScope3;
        this.f24795o = function1;
        if (getMemberScope() instanceof ErrorUtils.d) {
            StringBuilder sbM833U = outline.m833U("SimpleTypeImpl should not be created for error type: ");
            sbM833U.append(getMemberScope());
            sbM833U.append('\n');
            sbM833U.append(getConstructor());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f22735f.getEMPTY();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return this.f24792l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public TypeConstructor getConstructor() {
        return this.f24791k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        return this.f24794n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return this.f24793m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : z2 ? new KotlinTypeFactory4(this) : new KotlinTypeFactory2(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return annotations4.isEmpty() ? this : new KotlinTypeFactory3(this, annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public KotlinType4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType4 kotlinType4Invoke = this.f24795o.invoke(kotlinTypeRefiner);
        return kotlinType4Invoke == null ? this : kotlinType4Invoke;
    }
}
