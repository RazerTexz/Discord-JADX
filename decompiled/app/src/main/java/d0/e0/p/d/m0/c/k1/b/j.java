package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.f1;
import d0.e0.p.d.m0.c.k1.b.f;
import d0.e0.p.d.m0.c.k1.b.t;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.z.d.a0;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public final class j extends n implements d0.e0.p.d.m0.c.k1.b.f, t, d0.e0.p.d.m0.e.a.k0.g {
    public final Class<?> a;

    /* compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class a extends d0.z.d.j implements Function1<Member, Boolean> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(Member.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            d0.z.d.m.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class b extends d0.z.d.j implements Function1<Constructor<?>, m> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(m.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(Constructor<?> constructor) {
            return invoke2(constructor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final m invoke2(Constructor<?> constructor) {
            d0.z.d.m.checkNotNullParameter(constructor, "p0");
            return new m(constructor);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class c extends d0.z.d.j implements Function1<Member, Boolean> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(Member.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            d0.z.d.m.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class d extends d0.z.d.j implements Function1<Field, p> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(p.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ p invoke(Field field) {
            return invoke2(field);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final p invoke2(Field field) {
            d0.z.d.m.checkNotNullParameter(field, "p0");
            return new p(field);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public static final class e extends d0.z.d.o implements Function1<Class<?>, Boolean> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
            return Boolean.valueOf(invoke2(cls));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            d0.z.d.m.checkNotNullExpressionValue(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public static final class f extends d0.z.d.o implements Function1<Class<?>, d0.e0.p.d.m0.g.e> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.e invoke(Class<?> cls) {
            return invoke2(cls);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.g.e invoke2(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!d0.e0.p.d.m0.g.e.isValidIdentifier(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return d0.e0.p.d.m0.g.e.identifier(simpleName);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public static final class g extends d0.z.d.o implements Function1<Method, Boolean> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
            return Boolean.valueOf(invoke2(method));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Method method) {
            if (!method.isSynthetic()) {
                if (!j.this.isEnum()) {
                    return true;
                }
                j jVar = j.this;
                d0.z.d.m.checkNotNullExpressionValue(method, "method");
                if (!j.access$isEnumValuesOrValueOf(jVar, method)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    public /* synthetic */ class h extends d0.z.d.j implements Function1<Method, s> {
        public static final h j = new h();

        public h() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return a0.getOrCreateKotlinClass(s.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ s invoke(Method method) {
            return invoke2(method);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final s invoke2(Method method) {
            d0.z.d.m.checkNotNullParameter(method, "p0");
            return new s(method);
        }
    }

    public j(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        this.a = cls;
    }

    public static final boolean access$isEnumValuesOrValueOf(j jVar, Method method) {
        Objects.requireNonNull(jVar);
        String name = method.getName();
        if (d0.z.d.m.areEqual(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (d0.z.d.m.areEqual(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && d0.z.d.m.areEqual(this.a, ((j) obj).a);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.c.k1.b.c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return f.a.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public /* bridge */ /* synthetic */ AnnotatedElement getElement() {
        return getElement();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getFields() {
        return getFields();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public d0.e0.p.d.m0.g.b getFqName() {
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = d0.e0.p.d.m0.c.k1.b.b.getClassId(this.a).asSingleFqName();
        d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "klass.classId.asSingleFqName()");
        return bVarAsSingleFqName;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public c0 getLightClassOriginKind() {
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.t
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(this.a.getSimpleName());
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(klass.simpleName)");
        return eVarIdentifier;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.g getOuterClass() {
        return getOuterClass();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.j> getPermittedTypes() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.w> getRecordComponents() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public Collection<d0.e0.p.d.m0.e.a.k0.j> getSupertypes() {
        Class cls;
        cls = Object.class;
        if (d0.z.d.m.areEqual(this.a, cls)) {
            return d0.t.n.emptyList();
        }
        d0.z.d.c0 c0Var = new d0.z.d.c0(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        c0Var.add(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        d0.z.d.m.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        c0Var.addSpread(genericInterfaces);
        List listListOf = d0.t.n.listOf(c0Var.toArray(new Type[c0Var.size()]));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new l((Type) it.next()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.z
    public List<x> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public f1 getVisibility() {
        return t.a.getVisibility(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isAbstract() {
        return t.a.isAbstract(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isAnnotationType() {
        return this.a.isAnnotation();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return f.a.isDeprecatedInJavaDoc(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isEnum() {
        return this.a.isEnum();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isFinal() {
        return t.a.isFinal(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isInterface() {
        return this.a.isInterface();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isRecord() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public boolean isSealed() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isStatic() {
        return t.a.isStatic(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(j.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<d0.e0.p.d.m0.c.k1.b.c> getAnnotations() {
        return f.a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<m> getConstructors() throws SecurityException {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        d0.z.d.m.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filterNot(d0.t.k.asSequence(declaredConstructors), a.j), b.j));
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public Class<?> getElement() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<p> getFields() {
        Field[] declaredFields = this.a.getDeclaredFields();
        d0.z.d.m.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filterNot(d0.t.k.asSequence(declaredFields), c.j), d.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<d0.e0.p.d.m0.g.e> getInnerClassNames() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        d0.z.d.m.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return d0.f0.q.toList(d0.f0.q.mapNotNull(d0.f0.q.filterNot(d0.t.k.asSequence(declaredClasses), e.j), f.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public List<s> getMethods() throws SecurityException {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return d0.f0.q.toList(d0.f0.q.map(d0.f0.q.filter(d0.t.k.asSequence(declaredMethods), new g()), h.j));
    }

    @Override // d0.e0.p.d.m0.e.a.k0.g
    public j getOuterClass() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new j(declaringClass);
    }
}
