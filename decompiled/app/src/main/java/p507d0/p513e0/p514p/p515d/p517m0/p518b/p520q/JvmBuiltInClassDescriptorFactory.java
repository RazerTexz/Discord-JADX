package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.BuiltInsPackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t.SetsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {

    /* JADX INFO: renamed from: a */
    public static final b f22631a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f22632b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    /* JADX INFO: renamed from: c */
    public static final FqName f22633c = StandardNames.f22499l;

    /* JADX INFO: renamed from: d */
    public static final Name f22634d;

    /* JADX INFO: renamed from: e */
    public static final ClassId f22635e;

    /* JADX INFO: renamed from: f */
    public final ModuleDescriptor2 f22636f;

    /* JADX INFO: renamed from: g */
    public final Function1<ModuleDescriptor2, DeclarationDescriptor> f22637g;

    /* JADX INFO: renamed from: h */
    public final storage5 f22638h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$a */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, BuiltInsPackageFragment> {

        /* JADX INFO: renamed from: j */
        public static final a f22639j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ BuiltInsPackageFragment invoke(ModuleDescriptor2 moduleDescriptor2) {
            return invoke2(moduleDescriptor2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BuiltInsPackageFragment invoke2(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(JvmBuiltInClassDescriptorFactory.access$getKOTLIN_FQ_NAME$cp()).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            return (BuiltInsPackageFragment) _Collections.first((List) arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$b */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_CLASS_ID$cp();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$c */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class c extends Lambda implements Function0<ClassDescriptorImpl> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ClassDescriptorImpl invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassDescriptorImpl invoke() {
            ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor) JvmBuiltInClassDescriptorFactory.access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory.this).invoke(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory.this)), JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_NAME$cp(), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsJVM.listOf(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory.this).getBuiltIns().getAnyType()), SourceElement.f23099a, false, this.$storageManager);
            classDescriptorImpl.initialize(new CloneableClassScope(this.$storageManager, classDescriptorImpl), Sets5.emptySet(), null);
            return classDescriptorImpl;
        }
    }

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.a.f22536d;
        Name nameShortName = fqNameUnsafe.shortName();
        Intrinsics3.checkNotNullExpressionValue(nameShortName, "cloneable.shortName()");
        f22634d = nameShortName;
        ClassId classId = ClassId.topLevel(fqNameUnsafe.toSafe());
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f22635e = classId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Function1<? super ModuleDescriptor2, ? extends DeclarationDescriptor> function1) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.f22636f = moduleDescriptor2;
        this.f22637g = function1;
        this.f22638h = storageManager.createLazyValue(new c(storageManager));
    }

    public static final /* synthetic */ ClassId access$getCLONEABLE_CLASS_ID$cp() {
        return f22635e;
    }

    public static final /* synthetic */ Name access$getCLONEABLE_NAME$cp() {
        return f22634d;
    }

    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory) {
        return jvmBuiltInClassDescriptorFactory.f22637g;
    }

    public static final /* synthetic */ FqName access$getKOTLIN_FQ_NAME$cp() {
        return f22633c;
    }

    public static final /* synthetic */ ModuleDescriptor2 access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory) {
        return jvmBuiltInClassDescriptorFactory.f22636f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        if (Intrinsics3.areEqual(classId, f22631a.getCLONEABLE_CLASS_ID())) {
            return (ClassDescriptorImpl) storage7.getValue(this.f22638h, this, (KProperty<?>) f22632b[0]);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return Intrinsics3.areEqual(fqName, f22633c) ? SetsJVM.setOf((ClassDescriptorImpl) storage7.getValue(this.f22638h, this, (KProperty<?>) f22632b[0])) : Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Intrinsics3.areEqual(name, f22634d) && Intrinsics3.areEqual(fqName, f22633c);
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor2, (i & 4) != 0 ? a.f22639j : function1);
    }
}
