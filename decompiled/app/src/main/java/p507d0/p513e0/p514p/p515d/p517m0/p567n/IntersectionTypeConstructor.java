package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.TypeIntersectionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11978g;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0, reason: use source file name */
/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, InterfaceC11978g {

    /* JADX INFO: renamed from: a */
    public KotlinType f24739a;

    /* JADX INFO: renamed from: b */
    public final LinkedHashSet<KotlinType> f24740b;

    /* JADX INFO: renamed from: c */
    public final int f24741c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0$a */
    /* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
    public static final class a extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final KotlinType4 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return IntersectionTypeConstructor.this.refine(kotlinTypeRefiner).createType();
        }
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> collection) {
        Intrinsics3.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.f24740b = linkedHashSet;
        this.f24741c = linkedHashSet.hashCode();
    }

    public final MemberScope3 createScopeForKotlinType() {
        return TypeIntersectionScope.f24381b.create("member scope for intersection type", this.f24740b);
    }

    public final KotlinType4 createType() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations4.f22735f.getEMPTY(), this, Collections2.emptyList(), false, createScopeForKotlinType(), new a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return Intrinsics3.areEqual(this.f24740b, ((IntersectionTypeConstructor) obj).f24740b);
        }
        return false;
    }

    public final KotlinType getAlternativeType() {
        return this.f24739a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.f24740b.iterator().next().getConstructor().getBuiltIns();
        Intrinsics3.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return this.f24740b;
    }

    public int hashCode() {
        return this.f24741c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType kotlinType) {
        IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor(this.f24740b);
        intersectionTypeConstructor.f24739a = kotlinType;
        return intersectionTypeConstructor;
    }

    public String toString() {
        return _Collections.joinToString$default(_Collections.sortedWith(this.f24740b, new C11910b0()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).refine(kotlinTypeRefiner));
            z2 = true;
        }
        IntersectionTypeConstructor alternative = null;
        if (z2) {
            KotlinType alternativeType = getAlternativeType();
            alternative = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return alternative == null ? this : alternative;
    }
}
