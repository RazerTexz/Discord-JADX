package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorBase;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.EmptyPackageFragmentDesciptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ClassTypeConstructorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p580t.Sets5;
import p507d0.p580t.SetsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0, reason: use source file name */
/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotFoundClasses {

    /* JADX INFO: renamed from: a */
    public final StorageManager f22685a;

    /* JADX INFO: renamed from: b */
    public final ModuleDescriptor2 f22686b;

    /* JADX INFO: renamed from: c */
    public final storage3<FqName, PackageFragmentDescriptor> f22687c;

    /* JADX INFO: renamed from: d */
    public final storage3<a, ClassDescriptor> f22688d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$a */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final ClassId f22689a;

        /* JADX INFO: renamed from: b */
        public final List<Integer> f22690b;

        public a(ClassId classId, List<Integer> list) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(list, "typeParametersCount");
            this.f22689a = classId;
            this.f22690b = list;
        }

        public final ClassId component1() {
            return this.f22689a;
        }

        public final List<Integer> component2() {
            return this.f22690b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f22689a, aVar.f22689a) && Intrinsics3.areEqual(this.f22690b, aVar.f22690b);
        }

        public int hashCode() {
            return this.f22690b.hashCode() + (this.f22689a.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ClassRequest(classId=");
            sbM833U.append(this.f22689a);
            sbM833U.append(", typeParametersCount=");
            sbM833U.append(this.f22690b);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$b */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class b extends ClassDescriptorBase {

        /* JADX INFO: renamed from: r */
        public final boolean f22691r;

        /* JADX INFO: renamed from: s */
        public final List<TypeParameterDescriptor> f22692s;

        /* JADX INFO: renamed from: t */
        public final ClassTypeConstructorImpl f22693t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z2, int i) {
            super(storageManager, declarationDescriptor, name, SourceElement.f23099a, false);
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "container");
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f22691r = z2;
            Ranges2 ranges2Until = _Ranges.until(0, i);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
            Iterator<Integer> it = ranges2Until.iterator();
            while (it.hasNext()) {
                int iNextInt = ((Iterators4) it).nextInt();
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations4.f22735f.getEMPTY(), false, Variance.INVARIANT, Name.identifier(Intrinsics3.stringPlus(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(iNextInt))), iNextInt, storageManager));
            }
            this.f22692s = arrayList;
            this.f22693t = new ClassTypeConstructorImpl(this, typeParameterUtils.computeConstructorTypeParameters(this), SetsJVM.setOf(DescriptorUtils2.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
        public Annotations4 getAnnotations() {
            return Annotations4.f22735f.getEMPTY();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.f22692s;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public /* bridge */ /* synthetic */ MemberScope3 getStaticScope() {
            return getStaticScope();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
        public /* bridge */ /* synthetic */ TypeConstructor getTypeConstructor() {
            return getTypeConstructor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
        public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope3.b.f24373b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassDescriptorBase, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
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
            return this.f22691r;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("class ");
            sbM833U.append(getName());
            sbM833U.append(" (not found)");
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
        public MemberScope3.b getStaticScope() {
            return MemberScope3.b.f24373b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.f22693t;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$c */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class c extends Lambda implements Function1<a, ClassDescriptor> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassDescriptor invoke(a aVar) {
            return invoke2(aVar);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ClassDescriptor invoke2(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "$dstr$classId$typeParametersCount");
            ClassId classIdComponent1 = aVar.component1();
            List<Integer> listComponent2 = aVar.component2();
            if (classIdComponent1.isLocal()) {
                throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unresolved local class: ", classIdComponent1));
            }
            ClassId outerClassId = classIdComponent1.getOuterClassId();
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = outerClassId == null ? null : NotFoundClasses.this.getClass(outerClassId, _Collections.drop(listComponent2, 1));
            if (classOrPackageFragmentDescriptor == null) {
                storage3 storage3VarAccess$getPackageFragments$p = NotFoundClasses.access$getPackageFragments$p(NotFoundClasses.this);
                FqName packageFqName = classIdComponent1.getPackageFqName();
                Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor) ((LockBasedStorageManager.m) storage3VarAccess$getPackageFragments$p).invoke(packageFqName);
            }
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor2 = classOrPackageFragmentDescriptor;
            boolean zIsNestedClass = classIdComponent1.isNestedClass();
            StorageManager storageManagerAccess$getStorageManager$p = NotFoundClasses.access$getStorageManager$p(NotFoundClasses.this);
            Name shortClassName = classIdComponent1.getShortClassName();
            Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) _Collections.firstOrNull((List) listComponent2);
            return new b(storageManagerAccess$getStorageManager$p, classOrPackageFragmentDescriptor2, shortClassName, zIsNestedClass, num == null ? 0 : num.intValue());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$d */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class d extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PackageFragmentDescriptor invoke(FqName fqName) {
            return invoke2(fqName);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PackageFragmentDescriptor invoke2(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            return new EmptyPackageFragmentDesciptor(NotFoundClasses.access$getModule$p(NotFoundClasses.this), fqName);
        }
    }

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        this.f22685a = storageManager;
        this.f22686b = moduleDescriptor2;
        this.f22687c = storageManager.createMemoizedFunction(new d());
        this.f22688d = storageManager.createMemoizedFunction(new c());
    }

    public static final /* synthetic */ ModuleDescriptor2 access$getModule$p(NotFoundClasses notFoundClasses) {
        return notFoundClasses.f22686b;
    }

    public static final /* synthetic */ storage3 access$getPackageFragments$p(NotFoundClasses notFoundClasses) {
        return notFoundClasses.f22687c;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(NotFoundClasses notFoundClasses) {
        return notFoundClasses.f22685a;
    }

    public final ClassDescriptor getClass(ClassId classId, List<Integer> list) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        Intrinsics3.checkNotNullParameter(list, "typeParametersCount");
        return (ClassDescriptor) ((LockBasedStorageManager.m) this.f22688d).invoke(new a(classId, list));
    }
}
