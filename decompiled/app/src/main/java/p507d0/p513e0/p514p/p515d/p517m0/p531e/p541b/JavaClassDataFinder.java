package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassData;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassDataFinder;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaClassDataFinder.kt */
/* renamed from: d0.e0.p.d.m0.e.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaClassDataFinder implements ClassDataFinder {

    /* renamed from: a */
    public final KotlinClassFinder f23611a;

    /* renamed from: b */
    public final DeserializedDescriptorResolver f23612b;

    public JavaClassDataFinder(KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f23611a = kotlinClassFinder;
        this.f23612b = deserializedDescriptorResolver;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(this.f23611a, classId);
        if (kotlinJvmBinaryClassFindKotlinClass == null) {
            return null;
        }
        Intrinsics3.areEqual(kotlinJvmBinaryClassFindKotlinClass.getClassId(), classId);
        return this.f23612b.readClassData$descriptors_jvm(kotlinJvmBinaryClassFindKotlinClass);
    }
}
