package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.v.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {

    /* renamed from: a */
    public static final a f24444a = new a(null);

    /* renamed from: b */
    public final long f24445b;

    /* renamed from: c */
    public final ModuleDescriptor2 f24446c;

    /* renamed from: d */
    public final Set<KotlinType> f24447d;

    /* renamed from: e */
    public final KotlinType4 f24448e;

    /* renamed from: f */
    public final Lazy f24449f;

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.n$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v14, types: [d0.e0.p.d.m0.n.j0] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [d0.e0.p.d.m0.n.c0, d0.e0.p.d.m0.n.j0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        public final KotlinType4 findIntersectionType(Collection<? extends KotlinType4> collection) {
            Intrinsics3.checkNotNullParameter(collection, "types");
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            KotlinType4 next = it.next();
            while (it.hasNext()) {
                KotlinType4 kotlinType4 = (KotlinType4) it.next();
                next = next;
                if (next != 0 && kotlinType4 != null) {
                    TypeConstructor constructor = next.getConstructor();
                    TypeConstructor constructor2 = kotlinType4.getConstructor();
                    boolean z2 = constructor instanceof IntegerLiteralTypeConstructor;
                    if (z2 && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                        IntegerLiteralTypeConstructor integerLiteralTypeConstructor = (IntegerLiteralTypeConstructor) constructor;
                        IntegerLiteralTypeConstructor integerLiteralTypeConstructor2 = new IntegerLiteralTypeConstructor(IntegerLiteralTypeConstructor.access$getValue$p(integerLiteralTypeConstructor), IntegerLiteralTypeConstructor.access$getModule$p(integerLiteralTypeConstructor), _Collections.union(integerLiteralTypeConstructor.getPossibleTypes(), ((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes()), null);
                        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                        next = KotlinTypeFactory.integerLiteralType(Annotations4.f22735f.getEMPTY(), integerLiteralTypeConstructor2, false);
                    } else if (z2) {
                        if (((IntegerLiteralTypeConstructor) constructor).getPossibleTypes().contains(kotlinType4)) {
                            next = kotlinType4;
                        }
                    } else if (!(constructor2 instanceof IntegerLiteralTypeConstructor) || !((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes().contains(next)) {
                    }
                }
                next = 0;
            }
            return next;
        }
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.n$b */
    public static final class b extends Lambda implements Function0<List<KotlinType4>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<KotlinType4> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<KotlinType4> invoke2() {
            KotlinType4 defaultType = IntegerLiteralTypeConstructor.this.getBuiltIns().getComparable().getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
            List<KotlinType4> listMutableListOf = Collections2.mutableListOf(TypeSubstitution.replace$default(defaultType, CollectionsJVM.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, IntegerLiteralTypeConstructor.access$getType$p(IntegerLiteralTypeConstructor.this))), null, 2, null));
            if (!IntegerLiteralTypeConstructor.access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor.this)) {
                listMutableListOf.add(IntegerLiteralTypeConstructor.this.getBuiltIns().getNumberType());
            }
            return listMutableListOf;
        }
    }

    public IntegerLiteralTypeConstructor(long j, ModuleDescriptor2 moduleDescriptor2, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        this.f24448e = KotlinTypeFactory.integerLiteralType(Annotations4.f22735f.getEMPTY(), this, false);
        this.f24449f = LazyJVM.lazy(new b());
        this.f24445b = j;
        this.f24446c = moduleDescriptor2;
        this.f24447d = set;
    }

    public static final /* synthetic */ ModuleDescriptor2 access$getModule$p(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        return integerLiteralTypeConstructor.f24446c;
    }

    public static final /* synthetic */ KotlinType4 access$getType$p(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        return integerLiteralTypeConstructor.f24448e;
    }

    public static final /* synthetic */ long access$getValue$p(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        return integerLiteralTypeConstructor.f24445b;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        Collection<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtil.getAllSignedLiteralTypes(integerLiteralTypeConstructor.f24446c);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!integerLiteralTypeConstructor.getPossibleTypes().contains((KotlinType) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Set<KotlinType> set = this.f24447d;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(((KotlinType) it.next()).getConstructor(), typeConstructor)) {
                return true;
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.f24446c.getBuiltIns();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.f24447d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return (List) this.f24449f.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        StringBuilder sbM829Q = outline.m829Q('[');
        sbM829Q.append(_Collections.joinToString$default(this.f24447d, ",", null, null, 0, null, IntegerLiteralTypeConstructor2.f24450j, 30, null));
        sbM829Q.append(']');
        return Intrinsics3.stringPlus("IntegerLiteralType", sbM829Q.toString());
    }
}
