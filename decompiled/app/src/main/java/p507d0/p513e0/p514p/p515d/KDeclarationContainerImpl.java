package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectJavaClassFinder2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.RuntimeModuleData;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.ClassBasedDeclarationContainer;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: KDeclarationContainerImpl.kt */
/* renamed from: d0.e0.p.d.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {

    /* renamed from: l */
    public static final a f22380l = new a(null);

    /* renamed from: j */
    public static final Class<?> f22378j = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");

    /* renamed from: k */
    public static final Regex f22379k = new Regex("<v#(\\d+)>");

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.access$getLOCAL_PROPERTY_SIGNATURE$cp();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$b */
    public abstract class b {

        /* renamed from: a */
        public static final /* synthetic */ KProperty[] f22381a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};

        /* renamed from: b */
        public final ReflectProperties.a f22382b = ReflectProperties.lazySoft(new a());

        /* compiled from: KDeclarationContainerImpl.kt */
        /* renamed from: d0.e0.p.d.i$b$a */
        public static final class a extends Lambda implements Function0<RuntimeModuleData> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ RuntimeModuleData invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RuntimeModuleData invoke() {
                return moduleByClassLoader.getOrCreateModule(KDeclarationContainerImpl.this.getJClass());
            }
        }

        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.f22382b.getValue(this, f22381a[0]);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$c */
    public enum c {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "member");
            CallableMemberDescriptor.a kind = callableMemberDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$d */
    public static final class d extends Lambda implements Function1<FunctionDescriptor, CharSequence> {

        /* renamed from: j */
        public static final d f22387j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(FunctionDescriptor functionDescriptor) {
            return invoke2(functionDescriptor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
            return DescriptorRenderer2.f24227c.render(functionDescriptor) + " | " + RuntimeTypeMapper3.f22358b.mapSignature(functionDescriptor).asString();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$e */
    public static final class e extends Lambda implements Function1<PropertyDescriptor, CharSequence> {

        /* renamed from: j */
        public static final e f22388j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(PropertyDescriptor propertyDescriptor) {
            return invoke2(propertyDescriptor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(PropertyDescriptor propertyDescriptor) {
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
            return DescriptorRenderer2.f24227c.render(propertyDescriptor) + " | " + RuntimeTypeMapper3.f22358b.mapPropertySignature(propertyDescriptor).asString();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$f */
    public static final class f<T> implements Comparator<DescriptorVisibility2> {

        /* renamed from: j */
        public static final f f22389j = new f();

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DescriptorVisibility2 descriptorVisibility2, DescriptorVisibility2 descriptorVisibility22) {
            return compare2(descriptorVisibility2, descriptorVisibility22);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(DescriptorVisibility2 descriptorVisibility2, DescriptorVisibility2 descriptorVisibility22) {
            Integer numCompare = DescriptorVisibilities.compare(descriptorVisibility2, descriptorVisibility22);
            if (numCompare != null) {
                return numCompare.intValue();
            }
            return 0;
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    /* renamed from: d0.e0.p.d.i$g */
    public static final class g extends util {
        public g(KDeclarationContainerImpl kDeclarationContainerImpl, KDeclarationContainerImpl kDeclarationContainerImpl2) {
            super(kDeclarationContainerImpl2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorVisitorEmptyBodies, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Object visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Object obj) {
            return visitConstructorDescriptor(constructorDescriptor, (Unit) obj);
        }

        public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Unit unit) {
            Intrinsics3.checkNotNullParameter(constructorDescriptor, "descriptor");
            Intrinsics3.checkNotNullParameter(unit, "data");
            throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
        }
    }

    public static final /* synthetic */ Regex access$getLOCAL_PROPERTY_SIGNATURE$cp() {
        return f22379k;
    }

    /* renamed from: a */
    public final void m9340a(List<Class<?>> list, String str, boolean z2) {
        list.addAll(m9343d(str));
        int size = ((((ArrayList) r5).size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            Intrinsics3.checkNotNullExpressionValue(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z2 ? f22378j : Object.class;
        Intrinsics3.checkNotNullExpressionValue(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<KCallableImpl<?>> m9341b(MemberScope3 memberScope3, c cVar) {
        KCallableImpl kCallableImpl;
        Intrinsics3.checkNotNullParameter(memberScope3, "scope");
        Intrinsics3.checkNotNullParameter(cVar, "belonginess");
        g gVar = new g(this, this);
        Collection<DeclarationDescriptor> contributedDescriptors$default = ResolutionScope.a.getContributedDescriptors$default(memberScope3, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                kCallableImpl = ((Intrinsics3.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.f23090h) ^ true) && cVar.accept(callableMemberDescriptor)) ? (KCallableImpl) declarationDescriptor.accept(gVar, Unit.f27425a) : null;
            }
            if (kCallableImpl != null) {
                arrayList.add(kCallableImpl);
            }
        }
        return _Collections.toList(arrayList);
    }

    /* renamed from: c */
    public Class<?> mo9342c() {
        Class<?> wrapperByPrimitive = reflectClassUtil.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    /* renamed from: d */
    public final List<Class<?>> m9343d(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int iIndexOf$default = i;
            while (str.charAt(iIndexOf$default) == '[') {
                iIndexOf$default++;
            }
            char cCharAt = str.charAt(iIndexOf$default);
            if (!Strings4.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                if (cCharAt != 'L') {
                    throw new KotlinReflectionInternalError(outline.m883w("Unknown type prefix in the method signature: ", str));
                }
                iIndexOf$default = Strings4.indexOf$default((CharSequence) str, ';', i, false, 4, (Object) null);
            }
            int i2 = iIndexOf$default + 1;
            arrayList.add(m9346g(str, i, i2));
            i = i2;
        }
        return arrayList;
    }

    /* renamed from: e */
    public final Class<?> m9344e(String str) {
        return m9346g(str, Strings4.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    /* renamed from: f */
    public final Method m9345f(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z2) throws SecurityException {
        Method methodM9345f;
        if (z2) {
            clsArr[0] = cls;
        }
        Method methodM9348i = m9348i(cls, str, clsArr, cls2);
        if (methodM9348i != null) {
            return methodM9348i;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (methodM9345f = m9345f(superclass, str, clsArr, cls2, z2)) != null) {
            return methodM9345f;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            Intrinsics3.checkNotNullExpressionValue(cls3, "superInterface");
            Method methodM9345f2 = m9345f(cls3, str, clsArr, cls2, z2);
            if (methodM9345f2 != null) {
                return methodM9345f2;
            }
            if (z2) {
                Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(reflectClassUtil.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method methodM9348i2 = m9348i(clsTryLoadClass, str, clsArr, cls2);
                    if (methodM9348i2 != null) {
                        return methodM9348i2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        Intrinsics3.checkNotNullParameter(str, "desc");
        return m9347h(getJClass(), m9343d(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        Intrinsics3.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        m9340a(arrayList, str, true);
        return m9347h(jClass, arrayList);
    }

    public final Method findDefaultMethod(String str, String str2, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "desc");
        if (Intrinsics3.areEqual(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(getJClass());
        }
        m9340a(arrayList, str2, false);
        Class<?> clsMo9342c = mo9342c();
        String strM883w = outline.m883w(str, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return m9345f(clsMo9342c, strM883w, (Class[]) array, m9344e(str2), z2);
    }

    public final FunctionDescriptor findFunctionDescriptor(String str, String str2) {
        Collection<FunctionDescriptor> functions;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        if (Intrinsics3.areEqual(str, "<init>")) {
            functions = _Collections.toList(getConstructorDescriptors());
        } else {
            Name nameIdentifier = Name.identifier(str);
            Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "Name.identifier(name)");
            functions = getFunctions(nameIdentifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics3.areEqual(RuntimeTypeMapper3.f22358b.mapSignature((FunctionDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) _Collections.single((List) arrayList);
        }
        String strJoinToString$default = _Collections.joinToString$default(collection, "\n", null, null, 0, null, d.f22387j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public final Method findMethodBySignature(String str, String str2) throws SecurityException {
        Method methodM9345f;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "desc");
        if (Intrinsics3.areEqual(str, "<init>")) {
            return null;
        }
        Object[] array = m9343d(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> clsM9344e = m9344e(str2);
        Method methodM9345f2 = m9345f(mo9342c(), str, clsArr, clsM9344e, false);
        if (methodM9345f2 != null) {
            return methodM9345f2;
        }
        if (!mo9342c().isInterface() || (methodM9345f = m9345f(Object.class, str, clsArr, clsM9344e, false)) == null) {
            return null;
        }
        return methodM9345f;
    }

    public final PropertyDescriptor findPropertyDescriptor(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        MatchResult matchResultMatchEntire = f22379k.matchEntire(str2);
        if (matchResultMatchEntire != null) {
            String str3 = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str3));
            if (localProperty != null) {
                return localProperty;
            }
            StringBuilder sbM837Y = outline.m837Y("Local property #", str3, " not found in ");
            sbM837Y.append(getJClass());
            throw new KotlinReflectionInternalError(sbM837Y.toString());
        }
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "Name.identifier(name)");
        Collection<PropertyDescriptor> properties = getProperties(nameIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics3.areEqual(RuntimeTypeMapper3.f22358b.mapPropertySignature((PropertyDescriptor) obj).asString(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (PropertyDescriptor) _Collections.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            DescriptorVisibility2 visibility = ((PropertyDescriptor) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = MapsJVM.toSortedMap(linkedHashMap, f.f22389j).values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "properties\n             …                }).values");
        List list = (List) _Collections.last(collectionValues);
        if (list.size() == 1) {
            Intrinsics3.checkNotNullExpressionValue(list, "mostVisibleProperties");
            return (PropertyDescriptor) _Collections.first(list);
        }
        Name nameIdentifier2 = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "Name.identifier(name)");
        String strJoinToString$default = _Collections.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, 0, null, e.f22388j, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    /* renamed from: g */
    public final Class<?> m9346g(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = reflectClassUtil.getSafeClassLoader(getJClass());
            String strSubstring = str.substring(i + 1, i2 - 1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(StringsJVM.replace$default(strSubstring, MentionUtils.SLASH_CHAR, '.', false, 4, (Object) null));
            Intrinsics3.checkNotNullExpressionValue(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> cls = Void.TYPE;
            Intrinsics3.checkNotNullExpressionValue(cls, "Void.TYPE");
            return cls;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return reflectClassUtil.createArrayType(m9346g(str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError(outline.m883w("Unknown type prefix in the method signature: ", str));
        }
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    /* renamed from: h */
    public final Constructor<?> m9347h(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Method m9348i(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) throws SecurityException {
        boolean z2;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "result");
            if (Intrinsics3.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics3.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                Intrinsics3.checkNotNullExpressionValue(method, "method");
                if (Intrinsics3.areEqual(method.getName(), str) && Intrinsics3.areEqual(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Intrinsics3.checkNotNull(parameterTypes);
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
