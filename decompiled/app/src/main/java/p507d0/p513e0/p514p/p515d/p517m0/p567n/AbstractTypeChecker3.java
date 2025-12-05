package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartSet;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AbstractTypeChecker.kt */
/* renamed from: d0.e0.p.d.m0.n.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractTypeChecker3 implements InterfaceC11985n {

    /* renamed from: a */
    public int f24758a;

    /* renamed from: b */
    public boolean f24759b;

    /* renamed from: c */
    public ArrayDeque<InterfaceC11980i> f24760c;

    /* renamed from: d */
    public Set<InterfaceC11980i> f24761d;

    /* compiled from: AbstractTypeChecker.kt */
    /* renamed from: d0.e0.p.d.m0.n.f$a */
    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* compiled from: AbstractTypeChecker.kt */
    /* renamed from: d0.e0.p.d.m0.n.f$b */
    public static abstract class b {

        /* compiled from: AbstractTypeChecker.kt */
        /* renamed from: d0.e0.p.d.m0.n.f$b$a */
        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* renamed from: d0.e0.p.d.m0.n.f$b$b, reason: collision with other inner class name */
        public static final class C13335b extends b {

            /* renamed from: a */
            public static final C13335b f24766a = new C13335b();

            public C13335b() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3.b
            public InterfaceC11980i transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
                return abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979h);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* renamed from: d0.e0.p.d.m0.n.f$b$c */
        public static final class c extends b {

            /* renamed from: a */
            public static final c f24767a = new c();

            public c() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3.b
            public /* bridge */ /* synthetic */ InterfaceC11980i transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
                return (InterfaceC11980i) m11472transformType(abstractTypeChecker3, interfaceC11979h);
            }

            /* renamed from: transformType, reason: collision with other method in class */
            public Void m11472transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        /* renamed from: d0.e0.p.d.m0.n.f$b$d */
        public static final class d extends b {

            /* renamed from: a */
            public static final d f24768a = new d();

            public d() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3.b
            public InterfaceC11980i transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(interfaceC11979h, "type");
                return abstractTypeChecker3.upperBoundIfFlexible(interfaceC11979h);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public abstract InterfaceC11980i transformType(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h);
    }

    public static final /* synthetic */ int access$getArgumentsDepth(AbstractTypeChecker3 abstractTypeChecker3) {
        return abstractTypeChecker3.f24758a;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(AbstractTypeChecker3 abstractTypeChecker3, int i) {
        abstractTypeChecker3.f24758a = i;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return abstractTypeChecker3.addSubtypeConstraint(interfaceC11979h, interfaceC11979h2, z2);
    }

    public Boolean addSubtypeConstraint(InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2) {
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11979h2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<InterfaceC11980i> arrayDeque = this.f24760c;
        Intrinsics3.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<InterfaceC11980i> set = this.f24761d;
        Intrinsics3.checkNotNull(set);
        set.clear();
        this.f24759b = false;
    }

    public boolean customIsSubtypeOf(InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11979h2, "superType");
        return true;
    }

    public List<InterfaceC11980i> fastCorrespondingSupertypes(InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        return InterfaceC11985n.a.fastCorrespondingSupertypes(this, interfaceC11980i, interfaceC11983l);
    }

    public InterfaceC11982k get(InterfaceC11981j interfaceC11981j, int i) {
        return InterfaceC11985n.a.get(this, interfaceC11981j, i);
    }

    public InterfaceC11982k getArgumentOrNull(InterfaceC11980i interfaceC11980i, int i) {
        return InterfaceC11985n.a.getArgumentOrNull(this, interfaceC11980i, i);
    }

    public a getLowerCapturedTypePolicy(InterfaceC11980i interfaceC11980i, InterfaceC11974c interfaceC11974c) {
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11974c, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<InterfaceC11980i> getSupertypesDeque() {
        return this.f24760c;
    }

    public final Set<InterfaceC11980i> getSupertypesSet() {
        return this.f24761d;
    }

    public boolean hasFlexibleNullability(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.hasFlexibleNullability(this, interfaceC11979h);
    }

    public final void initialize() {
        this.f24759b = true;
        if (this.f24760c == null) {
            this.f24760c = new ArrayDeque<>(4);
        }
        if (this.f24761d == null) {
            this.f24761d = SmartSet.f25003j.create();
        }
    }

    public boolean isClassType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11985n.a.isClassType(this, interfaceC11980i);
    }

    public boolean isDefinitelyNotNullType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isDefinitelyNotNullType(this, interfaceC11979h);
    }

    public boolean isDynamic(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isDynamic(this, interfaceC11979h);
    }

    public abstract boolean isErrorTypeEqualsToAnything();

    public boolean isIntegerLiteralType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11985n.a.isIntegerLiteralType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isMarkedNullable(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isMarkedNullable(this, interfaceC11979h);
    }

    public boolean isNothing(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isNothing(this, interfaceC11979h);
    }

    public abstract boolean isStubTypeEqualsToAnything();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i lowerBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.lowerBoundIfFlexible(this, interfaceC11979h);
    }

    public abstract InterfaceC11979h prepareType(InterfaceC11979h interfaceC11979h);

    public abstract InterfaceC11979h refineType(InterfaceC11979h interfaceC11979h);

    public int size(InterfaceC11981j interfaceC11981j) {
        return InterfaceC11985n.a.size(this, interfaceC11981j);
    }

    public abstract b substitutionSupertypePolicy(InterfaceC11980i interfaceC11980i);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11983l typeConstructor(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.typeConstructor(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i upperBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.upperBoundIfFlexible(this, interfaceC11979h);
    }
}
