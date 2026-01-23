package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.CompanionObjectMapping;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.FunctionClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNamesUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c, reason: use source file name */
/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaToKotlinClassMap {

    /* JADX INFO: renamed from: a */
    public static final JavaToKotlinClassMap f22614a;

    /* JADX INFO: renamed from: b */
    public static final String f22615b;

    /* JADX INFO: renamed from: c */
    public static final String f22616c;

    /* JADX INFO: renamed from: d */
    public static final String f22617d;

    /* JADX INFO: renamed from: e */
    public static final String f22618e;

    /* JADX INFO: renamed from: f */
    public static final ClassId f22619f;

    /* JADX INFO: renamed from: g */
    public static final FqName f22620g;

    /* JADX INFO: renamed from: h */
    public static final ClassId f22621h;

    /* JADX INFO: renamed from: i */
    public static final HashMap<FqNameUnsafe, ClassId> f22622i;

    /* JADX INFO: renamed from: j */
    public static final HashMap<FqNameUnsafe, ClassId> f22623j;

    /* JADX INFO: renamed from: k */
    public static final HashMap<FqNameUnsafe, FqName> f22624k;

    /* JADX INFO: renamed from: l */
    public static final HashMap<FqNameUnsafe, FqName> f22625l;

    /* JADX INFO: renamed from: m */
    public static final List<a> f22626m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.c$a */
    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final ClassId f22627a;

        /* JADX INFO: renamed from: b */
        public final ClassId f22628b;

        /* JADX INFO: renamed from: c */
        public final ClassId f22629c;

        public a(ClassId classId, ClassId classId2, ClassId classId3) {
            Intrinsics3.checkNotNullParameter(classId, "javaClass");
            Intrinsics3.checkNotNullParameter(classId2, "kotlinReadOnly");
            Intrinsics3.checkNotNullParameter(classId3, "kotlinMutable");
            this.f22627a = classId;
            this.f22628b = classId2;
            this.f22629c = classId3;
        }

        public final ClassId component1() {
            return this.f22627a;
        }

        public final ClassId component2() {
            return this.f22628b;
        }

        public final ClassId component3() {
            return this.f22629c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f22627a, aVar.f22627a) && Intrinsics3.areEqual(this.f22628b, aVar.f22628b) && Intrinsics3.areEqual(this.f22629c, aVar.f22629c);
        }

        public final ClassId getJavaClass() {
            return this.f22627a;
        }

        public int hashCode() {
            return this.f22629c.hashCode() + ((this.f22628b.hashCode() + (this.f22627a.hashCode() * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("PlatformMutabilityMapping(javaClass=");
            sbM833U.append(this.f22627a);
            sbM833U.append(", kotlinReadOnly=");
            sbM833U.append(this.f22628b);
            sbM833U.append(", kotlinMutable=");
            sbM833U.append(this.f22629c);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    static {
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        f22614a = javaToKotlinClassMap;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.f22602k;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        f22615b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.f22604m;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        f22616c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.f22603l;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        f22617d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.f22605n;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        f22618e = sb4.toString();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f22619f = classId;
        FqName fqNameAsSingleFqName = classId.asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f22620g = fqNameAsSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f22621h = classId2;
        Intrinsics3.checkNotNullExpressionValue(ClassId.topLevel(new FqName("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        javaToKotlinClassMap.m9379e(Class.class);
        f22622i = new HashMap<>();
        f22623j = new HashMap<>();
        f22624k = new HashMap<>();
        f22625l = new HashMap<>();
        ClassId classId3 = ClassId.topLevel(StandardNames.a.f22512I);
        Intrinsics3.checkNotNullExpressionValue(classId3, "topLevel(FqNames.iterable)");
        FqName fqName = StandardNames.a.f22520Q;
        FqName packageFqName = classId3.getPackageFqName();
        FqName packageFqName2 = classId3.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName fqNameTail = FqNamesUtil.tail(fqName, packageFqName2);
        int i = 0;
        ClassId classId4 = new ClassId(packageFqName, fqNameTail, false);
        ClassId classId5 = ClassId.topLevel(StandardNames.a.f22511H);
        Intrinsics3.checkNotNullExpressionValue(classId5, "topLevel(FqNames.iterator)");
        FqName fqName2 = StandardNames.a.f22519P;
        FqName packageFqName3 = classId5.getPackageFqName();
        FqName packageFqName4 = classId5.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId6 = new ClassId(packageFqName3, FqNamesUtil.tail(fqName2, packageFqName4), false);
        ClassId classId7 = ClassId.topLevel(StandardNames.a.f22513J);
        Intrinsics3.checkNotNullExpressionValue(classId7, "topLevel(FqNames.collection)");
        FqName fqName3 = StandardNames.a.f22521R;
        FqName packageFqName5 = classId7.getPackageFqName();
        FqName packageFqName6 = classId7.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId8 = new ClassId(packageFqName5, FqNamesUtil.tail(fqName3, packageFqName6), false);
        ClassId classId9 = ClassId.topLevel(StandardNames.a.f22514K);
        Intrinsics3.checkNotNullExpressionValue(classId9, "topLevel(FqNames.list)");
        FqName fqName4 = StandardNames.a.f22522S;
        FqName packageFqName7 = classId9.getPackageFqName();
        FqName packageFqName8 = classId9.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId10 = new ClassId(packageFqName7, FqNamesUtil.tail(fqName4, packageFqName8), false);
        ClassId classId11 = ClassId.topLevel(StandardNames.a.f22516M);
        Intrinsics3.checkNotNullExpressionValue(classId11, "topLevel(FqNames.set)");
        FqName fqName5 = StandardNames.a.f22524U;
        FqName packageFqName9 = classId11.getPackageFqName();
        FqName packageFqName10 = classId11.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId12 = new ClassId(packageFqName9, FqNamesUtil.tail(fqName5, packageFqName10), false);
        ClassId classId13 = ClassId.topLevel(StandardNames.a.f22515L);
        Intrinsics3.checkNotNullExpressionValue(classId13, "topLevel(FqNames.listIterator)");
        FqName fqName6 = StandardNames.a.f22523T;
        FqName packageFqName11 = classId13.getPackageFqName();
        FqName packageFqName12 = classId13.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId14 = new ClassId(packageFqName11, FqNamesUtil.tail(fqName6, packageFqName12), false);
        FqName fqName7 = StandardNames.a.f22517N;
        ClassId classId15 = ClassId.topLevel(fqName7);
        Intrinsics3.checkNotNullExpressionValue(classId15, "topLevel(FqNames.map)");
        FqName fqName8 = StandardNames.a.f22525V;
        FqName packageFqName13 = classId15.getPackageFqName();
        FqName packageFqName14 = classId15.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId16 = new ClassId(packageFqName13, FqNamesUtil.tail(fqName8, packageFqName14), false);
        ClassId classIdCreateNestedClassId = ClassId.topLevel(fqName7).createNestedClassId(StandardNames.a.f22518O.shortName());
        Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        FqName fqName9 = StandardNames.a.f22526W;
        FqName packageFqName15 = classIdCreateNestedClassId.getPackageFqName();
        FqName packageFqName16 = classIdCreateNestedClassId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        List<a> listListOf = Collections2.listOf((Object[]) new a[]{new a(access$classId(javaToKotlinClassMap, Iterable.class), classId3, classId4), new a(access$classId(javaToKotlinClassMap, Iterator.class), classId5, classId6), new a(access$classId(javaToKotlinClassMap, Collection.class), classId7, classId8), new a(access$classId(javaToKotlinClassMap, List.class), classId9, classId10), new a(access$classId(javaToKotlinClassMap, Set.class), classId11, classId12), new a(access$classId(javaToKotlinClassMap, ListIterator.class), classId13, classId14), new a(access$classId(javaToKotlinClassMap, Map.class), classId15, classId16), new a(access$classId(javaToKotlinClassMap, Map.Entry.class), classIdCreateNestedClassId, new ClassId(packageFqName15, FqNamesUtil.tail(fqName9, packageFqName16), false))});
        f22626m = listListOf;
        javaToKotlinClassMap.m9378d(Object.class, StandardNames.a.f22532b);
        javaToKotlinClassMap.m9378d(String.class, StandardNames.a.f22542g);
        javaToKotlinClassMap.m9378d(CharSequence.class, StandardNames.a.f22540f);
        javaToKotlinClassMap.m9377c(Throwable.class, StandardNames.a.f22564s);
        javaToKotlinClassMap.m9378d(Cloneable.class, StandardNames.a.f22536d);
        javaToKotlinClassMap.m9378d(Number.class, StandardNames.a.f22562q);
        javaToKotlinClassMap.m9377c(Comparable.class, StandardNames.a.f22565t);
        javaToKotlinClassMap.m9378d(Enum.class, StandardNames.a.f22563r);
        javaToKotlinClassMap.m9377c(Annotation.class, StandardNames.a.f22571z);
        for (a aVar : listListOf) {
            JavaToKotlinClassMap javaToKotlinClassMap2 = f22614a;
            Objects.requireNonNull(javaToKotlinClassMap2);
            ClassId classIdComponent1 = aVar.component1();
            ClassId classIdComponent2 = aVar.component2();
            ClassId classIdComponent3 = aVar.component3();
            javaToKotlinClassMap2.m9375a(classIdComponent1, classIdComponent2);
            FqName fqNameAsSingleFqName2 = classIdComponent3.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName2, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, ClassId> map = f22623j;
            FqNameUnsafe unsafe = fqNameAsSingleFqName2.toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
            map.put(unsafe, classIdComponent1);
            FqName fqNameAsSingleFqName3 = classIdComponent2.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName3, "readOnlyClassId.asSingleFqName()");
            FqName fqNameAsSingleFqName4 = classIdComponent3.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName4, "mutableClassId.asSingleFqName()");
            HashMap<FqNameUnsafe, FqName> map2 = f22624k;
            FqNameUnsafe unsafe2 = classIdComponent3.asSingleFqName().toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe2, "mutableClassId.asSingleFqName().toUnsafe()");
            map2.put(unsafe2, fqNameAsSingleFqName3);
            HashMap<FqNameUnsafe, FqName> map3 = f22625l;
            FqNameUnsafe unsafe3 = fqNameAsSingleFqName3.toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe3, "readOnlyFqName.toUnsafe()");
            map3.put(unsafe3, fqNameAsSingleFqName4);
        }
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int i2 = 0;
        while (i2 < 8) {
            JvmPrimitiveType jvmPrimitiveType = jvmPrimitiveTypeArrValues[i2];
            i2++;
            JavaToKotlinClassMap javaToKotlinClassMap3 = f22614a;
            ClassId classId17 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics3.checkNotNullExpressionValue(classId17, "topLevel(jvmType.wrapperFqName)");
            StandardNames standardNames = StandardNames.f22488a;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics3.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            ClassId classId18 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            Intrinsics3.checkNotNullExpressionValue(classId18, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            javaToKotlinClassMap3.m9375a(classId17, classId18);
        }
        for (ClassId classId19 : CompanionObjectMapping.f22455a.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap4 = f22614a;
            StringBuilder sbM833U = outline.m833U("kotlin.jvm.internal.");
            sbM833U.append(classId19.getShortClassName().asString());
            sbM833U.append("CompanionObject");
            ClassId classId20 = ClassId.topLevel(new FqName(sbM833U.toString()));
            Intrinsics3.checkNotNullExpressionValue(classId20, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            ClassId classIdCreateNestedClassId2 = classId19.createNestedClassId(SpecialNames.f24093b);
            Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap4.m9375a(classId20, classIdCreateNestedClassId2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            JavaToKotlinClassMap javaToKotlinClassMap5 = f22614a;
            ClassId classId21 = ClassId.topLevel(new FqName(Intrinsics3.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i3))));
            Intrinsics3.checkNotNullExpressionValue(classId21, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            StandardNames standardNames2 = StandardNames.f22488a;
            javaToKotlinClassMap5.m9375a(classId21, StandardNames.getFunctionClassId(i3));
            javaToKotlinClassMap5.m9376b(new FqName(Intrinsics3.stringPlus(f22616c, Integer.valueOf(i3))), f22621h);
            if (i4 >= 23) {
                break;
            } else {
                i3 = i4;
            }
        }
        while (true) {
            int i5 = i + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.f22605n;
            String str = functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix();
            JavaToKotlinClassMap javaToKotlinClassMap6 = f22614a;
            javaToKotlinClassMap6.m9376b(new FqName(Intrinsics3.stringPlus(str, Integer.valueOf(i))), f22621h);
            if (i5 >= 22) {
                FqName safe = StandardNames.a.f22534c.toSafe();
                Intrinsics3.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                javaToKotlinClassMap6.m9376b(safe, javaToKotlinClassMap6.m9379e(Void.class));
                return;
            }
            i = i5;
        }
    }

    public static final /* synthetic */ ClassId access$classId(JavaToKotlinClassMap javaToKotlinClassMap, Class cls) {
        return javaToKotlinClassMap.m9379e(cls);
    }

    /* JADX INFO: renamed from: a */
    public final void m9375a(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> map = f22622i;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(unsafe, classId2);
        FqName fqNameAsSingleFqName = classId2.asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "kotlinClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, ClassId> map2 = f22623j;
        FqNameUnsafe unsafe2 = fqNameAsSingleFqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe2, "kotlinFqNameUnsafe.toUnsafe()");
        map2.put(unsafe2, classId);
    }

    /* JADX INFO: renamed from: b */
    public final void m9376b(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> map = f22623j;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(unsafe, classId);
    }

    /* JADX INFO: renamed from: c */
    public final void m9377c(Class<?> cls, FqName fqName) {
        ClassId classIdM9379e = m9379e(cls);
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(kotlinFqName)");
        m9375a(classIdM9379e, classId);
    }

    /* JADX INFO: renamed from: d */
    public final void m9378d(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        m9377c(cls, safe);
    }

    /* JADX INFO: renamed from: e */
    public final ClassId m9379e(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(clazz.canonicalName))");
            return classId;
        }
        ClassId classIdCreateNestedClassId = m9379e(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return classIdCreateNestedClassId;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m9380f(FqNameUnsafe fqNameUnsafe, String str) {
        Integer intOrNull;
        String strAsString = fqNameUnsafe.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "kotlinFqName.asString()");
        String strSubstringAfter = Strings4.substringAfter(strAsString, str, "");
        return (strSubstringAfter.length() > 0) && !Strings4.startsWith$default((CharSequence) strSubstringAfter, '0', false, 2, (Object) null) && (intOrNull = StringNumberConversions.toIntOrNull(strSubstringAfter)) != null && intOrNull.intValue() >= 23;
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return f22620g;
    }

    public final List<a> getMutabilityMappings() {
        return f22626m;
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> map = f22624k;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> map = f22625l;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return map.containsKey(fqNameUnsafe);
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return f22622i.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "kotlinFqName");
        if (!m9380f(fqNameUnsafe, f22615b) && !m9380f(fqNameUnsafe, f22617d)) {
            if (!m9380f(fqNameUnsafe, f22616c) && !m9380f(fqNameUnsafe, f22618e)) {
                return f22623j.get(fqNameUnsafe);
            }
            return f22621h;
        }
        return f22619f;
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return f22624k.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return f22625l.get(fqNameUnsafe);
    }
}
