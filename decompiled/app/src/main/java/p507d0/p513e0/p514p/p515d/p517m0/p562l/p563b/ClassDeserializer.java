package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedClassDescriptor;
import p507d0.p580t.SetsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h, reason: use source file name */
/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassDeserializer {

    /* JADX INFO: renamed from: a */
    public static final b f24629a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final Set<ClassId> f24630b = SetsJVM.setOf(ClassId.topLevel(StandardNames.a.f22536d.toSafe()));

    /* JADX INFO: renamed from: c */
    public final context5 f24631c;

    /* JADX INFO: renamed from: d */
    public final Function1<a, ClassDescriptor> f24632d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$a */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final ClassId f24633a;

        /* JADX INFO: renamed from: b */
        public final ClassData f24634b;

        public a(ClassId classId, ClassData classData) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            this.f24633a = classId;
            this.f24634b = classData;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.f24633a, ((a) obj).f24633a);
        }

        public final ClassData getClassData() {
            return this.f24634b;
        }

        public final ClassId getClassId() {
            return this.f24633a;
        }

        public int hashCode() {
            return this.f24633a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$b */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.access$getBLACK_LIST$cp();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$c */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
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
            Intrinsics3.checkNotNullParameter(aVar, "key");
            return ClassDeserializer.access$createClass(ClassDeserializer.this, aVar);
        }
    }

    public ClassDeserializer(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        this.f24631c = context5Var;
        this.f24632d = context5Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassDescriptor access$createClass(ClassDeserializer classDeserializer, a aVar) {
        Object next;
        context6 context6VarCreateContext;
        Objects.requireNonNull(classDeserializer);
        ClassId classId = aVar.getClassId();
        Iterator<ClassDescriptorFactory> it = classDeserializer.f24631c.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            ClassDescriptor classDescriptorCreateClass = it.next().createClass(classId);
            if (classDescriptorCreateClass != null) {
                return classDescriptorCreateClass;
            }
        }
        if (f24629a.getBLACK_LIST().contains(classId)) {
            return null;
        }
        ClassData classData = aVar.getClassData();
        if (classData == null && (classData = classDeserializer.f24631c.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        NameResolver nameResolverComponent1 = classData.component1();
        C11678c c11678cComponent2 = classData.component2();
        BinaryVersion binaryVersionComponent3 = classData.component3();
        SourceElement sourceElementComponent4 = classData.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor classDescriptorDeserializeClass$default = deserializeClass$default(classDeserializer, outerClassId, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = classDescriptorDeserializeClass$default instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) classDescriptorDeserializeClass$default : null;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            Name shortClassName = classId.getShortClassName();
            Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!deserializedClassDescriptor.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            context6VarCreateContext = deserializedClassDescriptor.getC();
        } else {
            PackageFragmentProvider packageFragmentProvider = classDeserializer.f24631c.getPackageFragmentProvider();
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it2 = PackageFragmentProvider2.packageFragments(packageFragmentProvider, packageFqName).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) next;
                if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                    Name shortClassName2 = classId.getShortClassName();
                    Intrinsics3.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                    boolean z2 = ((DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(shortClassName2);
                    if (z2) {
                        break;
                    }
                }
            }
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) next;
            if (packageFragmentDescriptor2 == null) {
                return null;
            }
            context5 context5Var = classDeserializer.f24631c;
            C11695t typeTable = c11678cComponent2.getTypeTable();
            Intrinsics3.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            TypeTable typeTable2 = new TypeTable(typeTable);
            VersionRequirement2.a aVar2 = VersionRequirement2.f24073a;
            C11698w versionRequirementTable = c11678cComponent2.getVersionRequirementTable();
            Intrinsics3.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            context6VarCreateContext = context5Var.createContext(packageFragmentDescriptor2, nameResolverComponent1, typeTable2, aVar2.create(versionRequirementTable), binaryVersionComponent3, null);
        }
        return new DeserializedClassDescriptor(context6VarCreateContext, c11678cComponent2, nameResolverComponent1, binaryVersionComponent3, sourceElementComponent4);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return f24630b;
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return this.f24632d.invoke(new a(classId, classData));
    }
}
