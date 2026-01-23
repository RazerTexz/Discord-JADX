package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleDescriptorImpl3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ KProperty<Object>[] f22640f = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* JADX INFO: renamed from: g */
    public Function0<b> f22641g;

    /* JADX INFO: renamed from: h */
    public final storage5 f22642h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$a */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$b */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final ModuleDescriptor2 f22647a;

        /* JADX INFO: renamed from: b */
        public final boolean f22648b;

        public b(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "ownerModuleDescriptor");
            this.f22647a = moduleDescriptor2;
            this.f22648b = z2;
        }

        public final ModuleDescriptor2 getOwnerModuleDescriptor() {
            return this.f22647a;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.f22648b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class c extends Lambda implements Function0<JvmBuiltInsCustomizer2> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$c$a */
        /* JADX INFO: compiled from: JvmBuiltIns.kt */
        public static final class a extends Lambda implements Function0<b> {
            public final /* synthetic */ JvmBuiltIns this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(JvmBuiltIns jvmBuiltIns) {
                super(0);
                this.this$0 = jvmBuiltIns;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ b invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                Function0 function0Access$getSettingsComputation$p = JvmBuiltIns.access$getSettingsComputation$p(this.this$0);
                if (function0Access$getSettingsComputation$p == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) function0Access$getSettingsComputation$p.invoke();
                JvmBuiltIns.access$setSettingsComputation$p(this.this$0, null);
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ JvmBuiltInsCustomizer2 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JvmBuiltInsCustomizer2 invoke() {
            ModuleDescriptorImpl3 builtInsModule = JvmBuiltIns.this.getBuiltInsModule();
            Intrinsics3.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
            return new JvmBuiltInsCustomizer2(builtInsModule, this.$storageManager, new a(JvmBuiltIns.this));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.f$d */
    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class d extends Lambda implements Function0<b> {
        public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        public final /* synthetic */ ModuleDescriptor2 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
            super(0);
            this.$moduleDescriptor = moduleDescriptor2;
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
    public JvmBuiltIns(StorageManager storageManager, a aVar) {
        super(storageManager);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        this.f22642h = storageManager.createLazyValue(new c(storageManager));
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            m9361d(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            m9361d(true);
        }
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(JvmBuiltIns jvmBuiltIns) {
        return jvmBuiltIns.f22641g;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(JvmBuiltIns jvmBuiltIns, Function0 function0) {
        jvmBuiltIns.f22641g = function0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns
    /* JADX INFO: renamed from: e */
    public AdditionalClassPartsProvider mo9362e() {
        return getCustomizer();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns
    /* JADX INFO: renamed from: g */
    public Iterable mo9364g() {
        Iterable<ClassDescriptorFactory> iterableMo9364g = super.mo9364g();
        Intrinsics3.checkNotNullExpressionValue(iterableMo9364g, "super.getClassDescriptorFactories()");
        StorageManager storageManager = this.f22463e;
        if (storageManager == null) {
            KotlinBuiltIns.m9355a(5);
            throw null;
        }
        Intrinsics3.checkNotNullExpressionValue(storageManager, "storageManager");
        ModuleDescriptorImpl3 builtInsModule = getBuiltInsModule();
        Intrinsics3.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return _Collections.plus(iterableMo9364g, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
    }

    public final JvmBuiltInsCustomizer2 getCustomizer() {
        return (JvmBuiltInsCustomizer2) storage7.getValue(this.f22642h, this, (KProperty<?>) f22640f[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns
    /* JADX INFO: renamed from: h */
    public PlatformDependentDeclarationFilter mo9365h() {
        return getCustomizer();
    }

    public final void initialize(ModuleDescriptor2 moduleDescriptor2, boolean z2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        setPostponedSettingsComputation(new d(moduleDescriptor2, z2));
    }

    public final void setPostponedSettingsComputation(Function0<b> function0) {
        Intrinsics3.checkNotNullParameter(function0, "computation");
        Function0<b> function02 = this.f22641g;
        this.f22641g = function0;
    }
}
