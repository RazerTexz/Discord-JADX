package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolverImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedPackageMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o, reason: use source file name */
/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {

    /* JADX INFO: renamed from: p */
    public final BinaryVersion f24670p;

    /* JADX INFO: renamed from: q */
    public final DeserializedContainerSource2 f24671q;

    /* JADX INFO: renamed from: r */
    public final NameResolverImpl f24672r;

    /* JADX INFO: renamed from: s */
    public final ProtoBasedClassDataFinder f24673s;

    /* JADX INFO: renamed from: t */
    public C11688m f24674t;

    /* JADX INFO: renamed from: u */
    public MemberScope3 f24675u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$a */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class a extends Lambda implements Function1<ClassId, SourceElement> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SourceElement invoke(ClassId classId) {
            return invoke2(classId);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SourceElement invoke2(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "it");
            DeserializedContainerSource2 deserializedContainerSource2Access$getContainerSource$p = DeserializedPackageFragmentImpl.access$getContainerSource$p(DeserializedPackageFragmentImpl.this);
            if (deserializedContainerSource2Access$getContainerSource$p != null) {
                return deserializedContainerSource2Access$getContainerSource$p;
            }
            SourceElement sourceElement = SourceElement.f23099a;
            Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return sourceElement;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.o$b */
    /* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class b extends Lambda implements Function0<Collection<? extends Name>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends Name> invoke2() {
            Collection<ClassId> allClassIds = DeserializedPackageFragmentImpl.this.getClassDataFinder().getAllClassIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj : allClassIds) {
                ClassId classId = (ClassId) obj;
                if ((classId.isNestedClass() || ClassDeserializer.f24629a.getBLACK_LIST().contains(classId)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ClassId) it.next()).getShortClassName());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, C11688m c11688m, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2) {
        super(fqName, storageManager, moduleDescriptor2);
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(c11688m, "proto");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        this.f24670p = binaryVersion;
        this.f24671q = deserializedContainerSource2;
        C11691p strings = c11688m.getStrings();
        Intrinsics3.checkNotNullExpressionValue(strings, "proto.strings");
        C11690o qualifiedNames = c11688m.getQualifiedNames();
        Intrinsics3.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.f24672r = nameResolverImpl;
        this.f24673s = new ProtoBasedClassDataFinder(c11688m, nameResolverImpl, binaryVersion, new a());
        this.f24674t = c11688m;
    }

    public static final /* synthetic */ DeserializedContainerSource2 access$getContainerSource$p(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        return deserializedPackageFragmentImpl.f24671q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializedPackageFragment
    public /* bridge */ /* synthetic */ ClassDataFinder getClassDataFinder() {
        return getClassDataFinder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3 = this.f24675u;
        if (memberScope3 != null) {
            return memberScope3;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    public void initialize(context5 context5Var) {
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        C11688m c11688m = this.f24674t;
        if (c11688m == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.f24674t = null;
        C11687l c11687l = c11688m.getPackage();
        Intrinsics3.checkNotNullExpressionValue(c11687l, "proto.`package`");
        this.f24675u = new DeserializedPackageMemberScope(this, c11687l, this.f24672r, this.f24670p, this.f24671q, context5Var, new b());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.f24673s;
    }
}
