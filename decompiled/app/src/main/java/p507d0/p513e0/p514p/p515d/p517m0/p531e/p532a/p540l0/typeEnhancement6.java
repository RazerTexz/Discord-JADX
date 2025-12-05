package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JavaToKotlinClassMapper;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations6;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker4;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: typeEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class typeEnhancement6 {

    /* renamed from: a */
    public static final typeEnhancement2 f23508a;

    /* renamed from: b */
    public static final typeEnhancement2 f23509b;

    /* compiled from: typeEnhancement.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.l0.x$a */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f23510a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f23511b;

        static {
            typeQualifiers2.valuesCustom();
            f23510a = new int[]{1, 2};
            typeQualifiers3.valuesCustom();
            f23511b = new int[]{1, 2, 0};
        }
    }

    static {
        FqName fqName = JvmAnnotationNames.f23161o;
        Intrinsics3.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        f23508a = new typeEnhancement2(fqName);
        FqName fqName2 = JvmAnnotationNames.f23162p;
        Intrinsics3.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        f23509b = new typeEnhancement2(fqName2);
    }

    /* renamed from: a */
    public static final <T> typeEnhancement3<T> m9516a(T t) {
        return new typeEnhancement3<>(t, null);
    }

    public static final Annotations4 access$compositeAnnotationsOrSingle(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new Annotations6((List<? extends Annotations4>) _Collections.toList(list)) : (Annotations4) _Collections.single(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    public static final typeEnhancement3 access$enhanceMutability(ClassifierDescriptor classifierDescriptor, typeQualifiers typequalifiers, TypeComponentPosition typeComponentPosition) {
        typeEnhancement3 typeenhancement3;
        if (TypeComponentPosition2.shouldEnhance(typeComponentPosition) && (classifierDescriptor instanceof ClassDescriptor)) {
            JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.f22630a;
            typeQualifiers2 mutability = typequalifiers.getMutability();
            int i = mutability == null ? -1 : a.f23510a[mutability.ordinal()];
            if (i == 1) {
                if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                    if (javaToKotlinClassMapper.isMutable(classDescriptor)) {
                        typeenhancement3 = new typeEnhancement3(javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor), f23509b);
                        return typeenhancement3;
                    }
                }
                return m9516a(classifierDescriptor);
            }
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMapper.isReadOnly(classDescriptor2)) {
                    typeenhancement3 = new typeEnhancement3(javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor2), f23509b);
                    return typeenhancement3;
                }
            }
            return m9516a(classifierDescriptor);
        }
        return m9516a(classifierDescriptor);
    }

    public static final typeEnhancement3 access$getEnhancedNullability(KotlinType kotlinType, typeQualifiers typequalifiers, TypeComponentPosition typeComponentPosition) {
        typeEnhancement3 typeenhancement3;
        if (!TypeComponentPosition2.shouldEnhance(typeComponentPosition)) {
            return m9516a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        typeQualifiers3 nullability = typequalifiers.getNullability();
        int i = nullability == null ? -1 : a.f23511b[nullability.ordinal()];
        if (i == 1) {
            typeenhancement3 = new typeEnhancement3(Boolean.TRUE, f23508a);
        } else {
            if (i != 2) {
                return m9516a(Boolean.valueOf(kotlinType.isMarkedNullable()));
            }
            typeenhancement3 = new typeEnhancement3(Boolean.FALSE, f23508a);
        }
        return typeenhancement3;
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return typeEnchancementUtils.hasEnhancedNullability(NewKotlinTypeChecker4.f24827a, kotlinType);
    }
}
