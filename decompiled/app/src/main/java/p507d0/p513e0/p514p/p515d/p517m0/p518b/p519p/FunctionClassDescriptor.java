package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjectionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b, reason: use source file name */
/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {

    /* JADX INFO: renamed from: o */
    public static final ClassId f22591o;

    /* JADX INFO: renamed from: p */
    public static final ClassId f22592p;

    /* JADX INFO: renamed from: q */
    public final StorageManager f22593q;

    /* JADX INFO: renamed from: r */
    public final PackageFragmentDescriptor f22594r;

    /* JADX INFO: renamed from: s */
    public final FunctionClassKind f22595s;

    /* JADX INFO: renamed from: t */
    public final int f22596t;

    /* JADX INFO: renamed from: u */
    public final b f22597u;

    /* JADX INFO: renamed from: v */
    public final FunctionClassScope f22598v;

    /* JADX INFO: renamed from: w */
    public final List<TypeParameterDescriptor> f22599w;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$a */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.b$b */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public final class b extends AbstractClassTypeConstructor {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ FunctionClassDescriptor f22600c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FunctionClassDescriptor functionClassDescriptor) {
            super(FunctionClassDescriptor.access$getStorageManager$p(functionClassDescriptor));
            Intrinsics3.checkNotNullParameter(functionClassDescriptor, "this$0");
            this.f22600c = functionClassDescriptor;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* JADX INFO: renamed from: a */
        public Collection<KotlinType> mo9370a() {
            List<ClassId> listListOf;
            int iOrdinal = this.f22600c.getFunctionKind().ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                listListOf = CollectionsJVM.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
            } else if (iOrdinal == 2) {
                listListOf = Collections2.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.f22499l, FunctionClassKind.f22602k.numberedClassName(this.f22600c.getArity()))});
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                listListOf = Collections2.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.f22491d, FunctionClassKind.f22603l.numberedClassName(this.f22600c.getArity()))});
            }
            ModuleDescriptor2 containingDeclaration = FunctionClassDescriptor.access$getContainingDeclaration$p(this.f22600c).getContainingDeclaration();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
            for (ClassId classId : listListOf) {
                ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (classDescriptorFindClassAcrossModuleDependencies == null) {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
                List listTakeLast = _Collections.takeLast(getParameters(), classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listTakeLast, 10));
                Iterator it = listTakeLast.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new TypeProjectionImpl(((TypeParameterDescriptor) it.next()).getDefaultType()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
                arrayList.add(KotlinTypeFactory.simpleNotNullType(Annotations4.f22735f.getEMPTY(), classDescriptorFindClassAcrossModuleDependencies, arrayList2));
            }
            return _Collections.toList(arrayList);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor
        /* JADX INFO: renamed from: d */
        public SupertypeLoopChecker mo9371d() {
            return SupertypeLoopChecker.a.f23103a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public /* bridge */ /* synthetic */ ClassDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.access$getParameters$p(this.f22600c);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractClassTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeConstructor, p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return this.f22600c;
        }
    }

    static {
        new a(null);
        f22591o = new ClassId(StandardNames.f22499l, Name.identifier("Function"));
        f22592p = new ClassId(StandardNames.f22496i, Name.identifier("KFunction"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(StorageManager storageManager, PackageFragmentDescriptor packageFragmentDescriptor, FunctionClassKind functionClassKind, int i) {
        super(storageManager, functionClassKind.numberedClassName(i));
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(functionClassKind, "functionKind");
        this.f22593q = storageManager;
        this.f22594r = packageFragmentDescriptor;
        this.f22595s = functionClassKind;
        this.f22596t = i;
        this.f22597u = new b(this);
        this.f22598v = new FunctionClassScope(storageManager, this);
        ArrayList arrayList = new ArrayList();
        Ranges2 ranges2 = new Ranges2(1, i);
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
        Iterator<Integer> it = ranges2.iterator();
        while (it.hasNext()) {
            m9369b(arrayList, this, Variance.IN_VARIANCE, Intrinsics3.stringPlus("P", Integer.valueOf(((Iterators4) it).nextInt())));
            arrayList2.add(Unit.f27425a);
        }
        m9369b(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.f22599w = _Collections.toList(arrayList);
    }

    public static final /* synthetic */ PackageFragmentDescriptor access$getContainingDeclaration$p(FunctionClassDescriptor functionClassDescriptor) {
        return functionClassDescriptor.f22594r;
    }

    public static final /* synthetic */ ClassId access$getFunctionClassId$cp() {
        return f22591o;
    }

    public static final /* synthetic */ ClassId access$getKFunctionClassId$cp() {
        return f22592p;
    }

    public static final /* synthetic */ List access$getParameters$p(FunctionClassDescriptor functionClassDescriptor) {
        return functionClassDescriptor.f22599w;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(FunctionClassDescriptor functionClassDescriptor) {
        return functionClassDescriptor.f22593q;
    }

    /* JADX INFO: renamed from: b */
    public static final void m9369b(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Annotations4.f22735f.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.f22593q));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return Annotations4.f22735f.getEMPTY();
    }

    public final int getArity() {
        return this.f22596t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) m11459getCompanionObjectDescriptor();
    }

    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public Void m11459getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f22599w;
    }

    public final FunctionClassKind getFunctionKind() {
        return this.f22595s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getSealedSubclasses() {
        return getSealedSubclasses();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.f23099a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope3 getStaticScope() {
        return getStaticScope();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f22597u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f22598v;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) m11460getUnsubstitutedPrimaryConstructor();
    }

    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public Void m11460getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23087e;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "PUBLIC");
        return descriptorVisibility2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        String strAsString = getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return strAsString;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.f22594r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3.b getStaticScope() {
        return MemberScope3.b.f24373b;
    }
}
