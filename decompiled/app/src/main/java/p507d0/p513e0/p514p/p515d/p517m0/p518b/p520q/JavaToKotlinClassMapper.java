package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p580t.SetsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaToKotlinClassMapper.kt */
/* renamed from: d0.e0.p.d.m0.b.q.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaToKotlinClassMapper {

    /* renamed from: a */
    public static final JavaToKotlinClassMapper f22630a = new JavaToKotlinClassMapper();

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "mutable");
        FqName fqNameMutableToReadOnly = JavaToKotlinClassMap.f22614a.mutableToReadOnly(DescriptorUtils.getFqName(classDescriptor));
        if (fqNameMutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtils2.getBuiltIns(classDescriptor).getBuiltInClassByFqName(fqNameMutableToReadOnly);
            Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "readOnly");
        FqName onlyToMutable = JavaToKotlinClassMap.f22614a.readOnlyToMutable(DescriptorUtils.getFqName(classDescriptor));
        if (onlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtils2.getBuiltIns(classDescriptor).getBuiltInClassByFqName(onlyToMutable);
            Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "mutable");
        return JavaToKotlinClassMap.f22614a.isMutable(DescriptorUtils.getFqName(classDescriptor));
    }

    public final boolean isReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "readOnly");
        return JavaToKotlinClassMap.f22614a.isReadOnly(DescriptorUtils.getFqName(classDescriptor));
    }

    public final ClassDescriptor mapJavaToKotlin(FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num) {
        ClassId classIdMapJavaToKotlin;
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (num == null || !Intrinsics3.areEqual(fqName, JavaToKotlinClassMap.f22614a.getFUNCTION_N_FQ_NAME())) {
            classIdMapJavaToKotlin = JavaToKotlinClassMap.f22614a.mapJavaToKotlin(fqName);
        } else {
            StandardNames standardNames = StandardNames.f22488a;
            classIdMapJavaToKotlin = StandardNames.getFunctionClassId(num.intValue());
        }
        if (classIdMapJavaToKotlin != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(classIdMapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName fqName, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        ClassDescriptor classDescriptorMapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, kotlinBuiltIns, null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            return Sets5.emptySet();
        }
        FqName onlyToMutable = JavaToKotlinClassMap.f22614a.readOnlyToMutable(DescriptorUtils2.getFqNameUnsafe(classDescriptorMapJavaToKotlin$default));
        if (onlyToMutable == null) {
            return SetsJVM.setOf(classDescriptorMapJavaToKotlin$default);
        }
        ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(onlyToMutable);
        Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return Collections2.listOf((Object[]) new ClassDescriptor[]{classDescriptorMapJavaToKotlin$default, builtInClassByFqName});
    }

    public final boolean isMutable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        return classDescriptor != null && isMutable(classDescriptor);
    }

    public final boolean isReadOnly(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        return classDescriptor != null && isReadOnly(classDescriptor);
    }
}
