package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.IntegerLiteralTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.IntersectionTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: IntersectionType.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntersectionType2 {

    /* renamed from: a */
    public static final IntersectionType2 f24831a = new IntersectionType2();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    /* renamed from: d0.e0.p.d.m0.n.l1.v$a */
    public static final class a {

        /* renamed from: j */
        public static final a f24832j;

        /* renamed from: k */
        public static final a f24833k;

        /* renamed from: l */
        public static final a f24834l;

        /* renamed from: m */
        public static final a f24835m;

        /* renamed from: n */
        public static final /* synthetic */ a[] f24836n;

        /* compiled from: IntersectionType.kt */
        /* renamed from: d0.e0.p.d.m0.n.l1.v$a$a, reason: collision with other inner class name */
        public static final class C13338a extends a {
            public C13338a(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return m10016f(kotlinType3);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* renamed from: d0.e0.p.d.m0.n.l1.v$a$b */
        public static final class b extends a {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.IntersectionType2.a
            public b combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.IntersectionType2.a
            public /* bridge */ /* synthetic */ a combine(KotlinType3 kotlinType3) {
                return combine(kotlinType3);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* renamed from: d0.e0.p.d.m0.n.l1.v$a$c */
        public static final class c extends a {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return m10016f(kotlinType3);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* renamed from: d0.e0.p.d.m0.n.l1.v$a$d */
        public static final class d extends a {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                a aVarM10016f = m10016f(kotlinType3);
                return aVarM10016f == a.f24833k ? this : aVarM10016f;
            }
        }

        static {
            c cVar = new c("START", 0);
            f24832j = cVar;
            C13338a c13338a = new C13338a("ACCEPT_NULL", 1);
            f24833k = c13338a;
            d dVar = new d("UNKNOWN", 2);
            f24834l = dVar;
            b bVar = new b("NOT_NULL", 3);
            f24835m = bVar;
            f24836n = new a[]{cVar, c13338a, dVar, bVar};
        }

        public a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static a valueOf(String str) {
            Intrinsics3.checkNotNullParameter(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = f24836n;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a combine(KotlinType3 kotlinType3);

        /* renamed from: f */
        public final a m10016f(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "<this>");
            return kotlinType3.isMarkedNullable() ? f24833k : NewKotlinTypeChecker3.f24825a.isSubtypeOfAny(kotlinType3) ? f24835m : f24834l;
        }
    }

    public static final boolean access$isStrictSupertype(IntersectionType2 intersectionType2, KotlinType kotlinType, KotlinType kotlinType2) {
        Objects.requireNonNull(intersectionType2);
        NewKotlinTypeChecker2 newKotlinTypeChecker2 = NewKotlinTypeChecker.f24820b.getDefault();
        return newKotlinTypeChecker2.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeChecker2.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<KotlinType4> m10015a(Collection<? extends KotlinType4> collection, Function2<? super KotlinType4, ? super KotlinType4, Boolean> function2) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            KotlinType4 kotlinType4 = (KotlinType4) it.next();
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    KotlinType4 kotlinType42 = (KotlinType4) it2.next();
                    if (kotlinType42 != kotlinType4) {
                        Intrinsics3.checkNotNullExpressionValue(kotlinType42, "lower");
                        Intrinsics3.checkNotNullExpressionValue(kotlinType4, "upper");
                        boolean z3 = function2.invoke(kotlinType42, kotlinType4).booleanValue();
                        if (z3) {
                            z2 = true;
                            break;
                        }
                    }
                }
            }
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    public final KotlinType4 intersectTypes$descriptors(List<? extends KotlinType4> list) {
        Intrinsics3.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<KotlinType4> arrayList = new ArrayList();
        for (KotlinType4 kotlinType4 : list) {
            if (kotlinType4.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> supertypes = kotlinType4.getConstructor().getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
                for (KotlinType kotlinType : supertypes) {
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
                    KotlinType4 kotlinType4UpperIfFlexible = flexibleTypes2.upperIfFlexible(kotlinType);
                    if (kotlinType4.isMarkedNullable()) {
                        kotlinType4UpperIfFlexible = kotlinType4UpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(kotlinType4UpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(kotlinType4);
            }
        }
        a aVarCombine = a.f24832j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarCombine = aVarCombine.combine((KotlinType3) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KotlinType4 kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList) {
            if (aVarCombine == a.f24835m) {
                if (kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof NewCapturedType) {
                    kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default = SpecialTypes5.withNotNullProjection((NewCapturedType) kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default = SpecialTypes5.makeSimpleTypeDefinitelyNotNullOrNotNull$default(kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        if (linkedHashSet.size() == 1) {
            return (KotlinType4) _Collections.single(linkedHashSet);
        }
        new IntersectionType3(linkedHashSet);
        Collection<KotlinType4> collectionM10015a = m10015a(linkedHashSet, new IntersectionType4(this));
        ((ArrayList) collectionM10015a).isEmpty();
        KotlinType4 kotlinType4FindIntersectionType = IntegerLiteralTypeConstructor.f24444a.findIntersectionType(collectionM10015a);
        if (kotlinType4FindIntersectionType != null) {
            return kotlinType4FindIntersectionType;
        }
        Collection<KotlinType4> collectionM10015a2 = m10015a(collectionM10015a, new IntersectionType5(NewKotlinTypeChecker.f24820b.getDefault()));
        ArrayList arrayList3 = (ArrayList) collectionM10015a2;
        arrayList3.isEmpty();
        return arrayList3.size() < 2 ? (KotlinType4) _Collections.single(collectionM10015a2) : new IntersectionTypeConstructor(linkedHashSet).createType();
    }
}
