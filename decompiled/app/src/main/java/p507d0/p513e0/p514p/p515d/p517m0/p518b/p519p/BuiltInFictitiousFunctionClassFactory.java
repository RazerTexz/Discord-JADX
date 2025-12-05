package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.BuiltInsPackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.FunctionInterfacePackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.FunctionClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* renamed from: d0.e0.p.d.m0.b.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {

    /* renamed from: a */
    public final StorageManager f22589a;

    /* renamed from: b */
    public final ModuleDescriptor2 f22590b;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        this.f22589a = storageManager;
        this.f22590b = moduleDescriptor2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        if (!Strings4.contains$default((CharSequence) strAsString, (CharSequence) "Function", false, 2, (Object) null)) {
            return null;
        }
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        FunctionClassKind.a.C13305a className = FunctionClassKind.f22601j.parseClassName(strAsString, packageFqName);
        if (className == null) {
            return null;
        }
        FunctionClassKind functionClassKindComponent1 = className.component1();
        int iComponent2 = className.component2();
        List<PackageFragmentDescriptor> fragments = this.f22590b.getPackage(packageFqName).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof FunctionInterfacePackageFragment) {
                arrayList2.add(obj2);
            }
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) _Collections.firstOrNull((List) arrayList2);
        if (packageFragmentDescriptor == null) {
            packageFragmentDescriptor = (BuiltInsPackageFragment) _Collections.first((List) arrayList);
        }
        return new FunctionClassDescriptor(this.f22589a, packageFragmentDescriptor, functionClassKindComponent1, iComponent2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return (StringsJVM.startsWith$default(strAsString, "Function", false, 2, null) || StringsJVM.startsWith$default(strAsString, "KFunction", false, 2, null) || StringsJVM.startsWith$default(strAsString, "SuspendFunction", false, 2, null) || StringsJVM.startsWith$default(strAsString, "KSuspendFunction", false, 2, null)) && FunctionClassKind.f22601j.parseClassName(strAsString, fqName) != null;
    }
}
