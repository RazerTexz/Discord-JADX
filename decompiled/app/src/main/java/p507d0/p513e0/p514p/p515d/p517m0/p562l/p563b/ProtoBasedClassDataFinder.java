package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.x, reason: use source file name */
/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {

    /* JADX INFO: renamed from: a */
    public final NameResolver f24687a;

    /* JADX INFO: renamed from: b */
    public final BinaryVersion f24688b;

    /* JADX INFO: renamed from: c */
    public final Function1<ClassId, SourceElement> f24689c;

    /* JADX INFO: renamed from: d */
    public final Map<ClassId, C11678c> f24690d;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(C11688m c11688m, NameResolver nameResolver, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        Intrinsics3.checkNotNullParameter(c11688m, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(function1, "classSource");
        this.f24687a = nameResolver;
        this.f24688b = binaryVersion;
        this.f24689c = function1;
        List<C11678c> class_List = c11688m.getClass_List();
        Intrinsics3.checkNotNullExpressionValue(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(class_List, 10)), 16));
        for (Object obj : class_List) {
            linkedHashMap.put(NameResolverUtil.getClassId(this.f24687a, ((C11678c) obj).getFqName()), obj);
        }
        this.f24690d = linkedHashMap;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        C11678c c11678c = this.f24690d.get(classId);
        if (c11678c == null) {
            return null;
        }
        return new ClassData(this.f24687a, c11678c, this.f24688b, this.f24689c.invoke(classId));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.f24690d.keySet();
    }
}
