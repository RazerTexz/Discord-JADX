package p507d0.p513e0;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.KTypeBase;

/* compiled from: TypesJVM.kt */
/* renamed from: d0.e0.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypesJVM5 {
    /* renamed from: a */
    public static final Type m9328a(KType kType, boolean z2) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypesJVM3((KTypeParameter) classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) classifier;
        Class javaObjectType = z2 ? JvmClassMapping.getJavaObjectType(kClass) : JvmClassMapping.getJavaClass(kClass);
        List<KTypeProjection> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return m9329b(javaObjectType, arguments);
        }
        Class<?> componentType = javaObjectType.getComponentType();
        Intrinsics3.checkNotNullExpressionValue(componentType, "jClass.componentType");
        if (componentType.isPrimitive()) {
            return javaObjectType;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) _Collections.singleOrNull((List) arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        KVariance kVarianceComponent1 = kTypeProjection.component1();
        KType kTypeComponent2 = kTypeProjection.component2();
        if (kVarianceComponent1 == null) {
            return javaObjectType;
        }
        int iOrdinal = kVarianceComponent1.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return javaObjectType;
            }
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        Intrinsics3.checkNotNull(kTypeComponent2);
        Type typeM9328a = m9328a(kTypeComponent2, false);
        return typeM9328a instanceof Class ? javaObjectType : new TypesJVM(typeM9328a);
    }

    public static final /* synthetic */ Type access$computeJavaType(KType kType, boolean z2) {
        return m9328a(kType, z2);
    }

    public static final String access$typeToString(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequenceGenerateSequence = C12075n.generateSequence(type, TypesJVM4.f22313j);
            name = ((Class) _Sequences2.last(sequenceGenerateSequence)).getName() + StringsJVM.repeat("[]", _Sequences2.count(sequenceGenerateSequence));
        } else {
            name = cls.getName();
        }
        Intrinsics3.checkNotNullExpressionValue(name, "if (type.isArray) {\n    …\n        } else type.name");
        return name;
    }

    /* renamed from: b */
    public static final Type m9329b(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m9330c((KTypeProjection) it.next()));
            }
            return new TypesJVM2(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(m9330c((KTypeProjection) it2.next()));
            }
            return new TypesJVM2(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeM9329b = m9329b(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(m9330c((KTypeProjection) it3.next()));
        }
        return new TypesJVM2(cls, typeM9329b, arrayList3);
    }

    /* renamed from: c */
    public static final Type m9330c(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return TypesJVM6.f22315k.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics3.checkNotNull(type);
        int iOrdinal = variance.ordinal();
        if (iOrdinal == 0) {
            return m9328a(type, true);
        }
        if (iOrdinal == 1) {
            return new TypesJVM6(null, m9328a(type, true));
        }
        if (iOrdinal == 2) {
            return new TypesJVM6(m9328a(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Type getJavaType(KType kType) {
        Type javaType;
        Intrinsics3.checkNotNullParameter(kType, "$this$javaType");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? m9328a(kType, false) : javaType;
    }
}
