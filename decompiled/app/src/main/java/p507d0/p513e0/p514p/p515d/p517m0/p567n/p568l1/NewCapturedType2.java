package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j, reason: use source file name */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType2 implements CapturedTypeConstructor2 {

    /* JADX INFO: renamed from: a */
    public final TypeProjection f24815a;

    /* JADX INFO: renamed from: b */
    public Function0<? extends List<? extends KotlinType3>> f24816b;

    /* JADX INFO: renamed from: c */
    public final NewCapturedType2 f24817c;

    /* JADX INFO: renamed from: d */
    public final TypeParameterDescriptor f24818d;

    /* JADX INFO: renamed from: e */
    public final Lazy f24819e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$a */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class a extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ List<KotlinType3> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends KotlinType3> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KotlinType3> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KotlinType3> invoke2() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$b */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class b extends Lambda implements Function0<List<? extends KotlinType3>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KotlinType3> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KotlinType3> invoke2() {
            Function0 function0Access$getSupertypesComputation$p = NewCapturedType2.access$getSupertypesComputation$p(NewCapturedType2.this);
            if (function0Access$getSupertypesComputation$p == null) {
                return null;
            }
            return (List) function0Access$getSupertypesComputation$p.invoke();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$c */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class c extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ List<KotlinType3> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends KotlinType3> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KotlinType3> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KotlinType3> invoke2() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$d */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class d extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends KotlinType3> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends KotlinType3> invoke2() {
            List<KotlinType3> supertypes = NewCapturedType2.this.getSupertypes();
            KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(((KotlinType3) it.next()).refine(kotlinTypeRefiner));
            }
            return arrayList;
        }
    }

    public NewCapturedType2(TypeProjection typeProjection, Function0<? extends List<? extends KotlinType3>> function0, NewCapturedType2 newCapturedType2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        this.f24815a = typeProjection;
        this.f24816b = function0;
        this.f24817c = newCapturedType2;
        this.f24818d = typeParameterDescriptor;
        this.f24819e = LazyJVM.lazy(Lazy5.PUBLICATION, new b());
    }

    public static final /* synthetic */ Function0 access$getSupertypesComputation$p(NewCapturedType2 newCapturedType2) {
        return newCapturedType2.f24816b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics3.areEqual(NewCapturedType2.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedType2 newCapturedType2 = (NewCapturedType2) obj;
        NewCapturedType2 newCapturedType22 = this.f24817c;
        if (newCapturedType22 == null) {
            newCapturedType22 = this;
        }
        NewCapturedType2 newCapturedType23 = newCapturedType2.f24817c;
        if (newCapturedType23 != null) {
            newCapturedType2 = newCapturedType23;
        }
        return newCapturedType22 == newCapturedType2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinType type = getProjection().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "projection.type");
        return TypeUtils2.getBuiltIns(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor2
    public TypeProjection getProjection() {
        return this.f24815a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    public int hashCode() {
        NewCapturedType2 newCapturedType2 = this.f24817c;
        return newCapturedType2 == null ? super.hashCode() : newCapturedType2.hashCode();
    }

    public final void initializeSupertypes(List<? extends KotlinType3> list) {
        Intrinsics3.checkNotNullParameter(list, "supertypes");
        Function0<? extends List<? extends KotlinType3>> function0 = this.f24816b;
        this.f24816b = new c(list);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CapturedType(");
        sbM833U.append(getProjection());
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<KotlinType3> getSupertypes() {
        List<KotlinType3> list = (List) this.f24819e.getValue();
        return list == null ? Collections2.emptyList() : list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public NewCapturedType2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f24816b == null ? null : new d(kotlinTypeRefiner);
        NewCapturedType2 newCapturedType2 = this.f24817c;
        if (newCapturedType2 == null) {
            newCapturedType2 = this;
        }
        return new NewCapturedType2(typeProjectionRefine, dVar, newCapturedType2, this.f24818d);
    }

    public /* synthetic */ NewCapturedType2(TypeProjection typeProjection, Function0 function0, NewCapturedType2 newCapturedType2, TypeParameterDescriptor typeParameterDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedType2, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    public /* synthetic */ NewCapturedType2(TypeProjection typeProjection, List list, NewCapturedType2 newCapturedType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedType2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedType2(TypeProjection typeProjection, List<? extends KotlinType3> list, NewCapturedType2 newCapturedType2) {
        this(typeProjection, new a(list), newCapturedType2, null, 8, null);
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        Intrinsics3.checkNotNullParameter(list, "supertypes");
    }
}
