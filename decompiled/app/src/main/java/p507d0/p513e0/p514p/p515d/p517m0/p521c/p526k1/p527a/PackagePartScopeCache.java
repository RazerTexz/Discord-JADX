package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.EmptyPackageFragmentDesciptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializedDescriptorResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ChainedMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.a, reason: use source file name */
/* JADX INFO: compiled from: PackagePartScopeCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackagePartScopeCache {

    /* JADX INFO: renamed from: a */
    public final DeserializedDescriptorResolver f23009a;

    /* JADX INFO: renamed from: b */
    public final ReflectKotlinClassFinder f23010b;

    /* JADX INFO: renamed from: c */
    public final ConcurrentHashMap<ClassId, MemberScope3> f23011c;

    public PackagePartScopeCache(DeserializedDescriptorResolver deserializedDescriptorResolver, ReflectKotlinClassFinder reflectKotlinClassFinder) {
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "resolver");
        Intrinsics3.checkNotNullParameter(reflectKotlinClassFinder, "kotlinClassFinder");
        this.f23009a = deserializedDescriptorResolver;
        this.f23010b = reflectKotlinClassFinder;
        this.f23011c = new ConcurrentHashMap<>();
    }

    public final MemberScope3 getPackagePartScope(ReflectKotlinClass2 reflectKotlinClass2) {
        Collection collectionListOf;
        Intrinsics3.checkNotNullParameter(reflectKotlinClass2, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope3> concurrentHashMap = this.f23011c;
        ClassId classId = reflectKotlinClass2.getClassId();
        MemberScope3 memberScope3 = concurrentHashMap.get(classId);
        if (memberScope3 == null) {
            FqName packageFqName = reflectKotlinClass2.getClassId().getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass2.getClassHeader().getKind() == KotlinClassHeader.a.MULTIFILE_CLASS) {
                List<String> multifilePartNames = reflectKotlinClass2.getClassHeader().getMultifilePartNames();
                collectionListOf = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    ClassId classId2 = ClassId.topLevel(JvmClassName.byInternalName((String) it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(this.f23010b, classId2);
                    if (kotlinJvmBinaryClassFindKotlinClass != null) {
                        collectionListOf.add(kotlinJvmBinaryClassFindKotlinClass);
                    }
                }
            } else {
                collectionListOf = CollectionsJVM.listOf(reflectKotlinClass2);
            }
            EmptyPackageFragmentDesciptor emptyPackageFragmentDesciptor = new EmptyPackageFragmentDesciptor(this.f23009a.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionListOf.iterator();
            while (it2.hasNext()) {
                MemberScope3 memberScope3CreateKotlinPackagePartScope = this.f23009a.createKotlinPackagePartScope(emptyPackageFragmentDesciptor, (KotlinJvmBinaryClass) it2.next());
                if (memberScope3CreateKotlinPackagePartScope != null) {
                    arrayList.add(memberScope3CreateKotlinPackagePartScope);
                }
            }
            List list = _Collections.toList(arrayList);
            MemberScope3 memberScope3Create = ChainedMemberScope.f24333b.create("package " + packageFqName + " (" + reflectKotlinClass2 + ')', list);
            MemberScope3 memberScope3PutIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScope3Create);
            memberScope3 = memberScope3PutIfAbsent != null ? memberScope3PutIfAbsent : memberScope3Create;
        }
        Intrinsics3.checkNotNullExpressionValue(memberScope3, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return memberScope3;
    }
}
