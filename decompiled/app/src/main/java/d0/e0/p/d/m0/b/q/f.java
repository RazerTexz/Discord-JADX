package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.y;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.b.h {
    public static final /* synthetic */ KProperty<Object>[] f = {a0.property1(new y(a0.getOrCreateKotlinClass(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    public Function0<b> g;
    public final d0.e0.p.d.m0.m.j h;

    /* compiled from: JvmBuiltIns.kt */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    public static final class b {
        public final c0 a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3239b;

        public b(c0 c0Var, boolean z2) {
            d0.z.d.m.checkNotNullParameter(c0Var, "ownerModuleDescriptor");
            this.a = c0Var;
            this.f3239b = z2;
        }

        public final c0 getOwnerModuleDescriptor() {
            return this.a;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.f3239b;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    public static final class c extends d0.z.d.o implements Function0<g> {
        public final /* synthetic */ d0.e0.p.d.m0.m.o $storageManager;

        /* compiled from: JvmBuiltIns.kt */
        public static final class a extends d0.z.d.o implements Function0<b> {
            public final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar) {
                super(0);
                this.this$0 = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ b invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                Function0 function0Access$getSettingsComputation$p = f.access$getSettingsComputation$p(this.this$0);
                if (function0Access$getSettingsComputation$p == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) function0Access$getSettingsComputation$p.invoke();
                f.access$setSettingsComputation$p(this.this$0, null);
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d0.e0.p.d.m0.m.o oVar) {
            super(0);
            this.$storageManager = oVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ g invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final g invoke() {
            d0.e0.p.d.m0.c.i1.y builtInsModule = f.this.getBuiltInsModule();
            d0.z.d.m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
            return new g(builtInsModule, this.$storageManager, new a(f.this));
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    public static final class d extends d0.z.d.o implements Function0<b> {
        public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        public final /* synthetic */ c0 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c0 c0Var, boolean z2) {
            super(0);
            this.$moduleDescriptor = c0Var;
            this.$isAdditionalBuiltInsFeatureSupported = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ b invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d0.e0.p.d.m0.m.o oVar, a aVar) {
        super(oVar);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(aVar, "kind");
        this.h = oVar.createLazyValue(new c(oVar));
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            d(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            d(true);
        }
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(f fVar) {
        return fVar.g;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(f fVar, Function0 function0) {
        fVar.g = function0;
    }

    @Override // d0.e0.p.d.m0.b.h
    public d0.e0.p.d.m0.c.h1.a e() {
        return getCustomizer();
    }

    @Override // d0.e0.p.d.m0.b.h
    public Iterable g() {
        Iterable<d0.e0.p.d.m0.c.h1.b> iterableG = super.g();
        d0.z.d.m.checkNotNullExpressionValue(iterableG, "super.getClassDescriptorFactories()");
        d0.e0.p.d.m0.m.o oVar = this.e;
        if (oVar == null) {
            d0.e0.p.d.m0.b.h.a(5);
            throw null;
        }
        d0.z.d.m.checkNotNullExpressionValue(oVar, "storageManager");
        d0.e0.p.d.m0.c.i1.y builtInsModule = getBuiltInsModule();
        d0.z.d.m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return u.plus(iterableG, new e(oVar, builtInsModule, null, 4, null));
    }

    public final g getCustomizer() {
        return (g) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) f[0]);
    }

    @Override // d0.e0.p.d.m0.b.h
    public d0.e0.p.d.m0.c.h1.c h() {
        return getCustomizer();
    }

    public final void initialize(c0 c0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        setPostponedSettingsComputation(new d(c0Var, z2));
    }

    public final void setPostponedSettingsComputation(Function0<b> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "computation");
        Function0<b> function02 = this.g;
        this.g = function0;
    }
}
