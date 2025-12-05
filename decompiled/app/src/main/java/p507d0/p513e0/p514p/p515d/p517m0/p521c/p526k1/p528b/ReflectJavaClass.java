package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaModifierListOwner;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p507d0.p592z.p594d.SpreadBuilder;

/* compiled from: ReflectJavaClass.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, InterfaceC11574g {

    /* renamed from: a */
    public final Class<?> f23046a;

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$a */
    public /* synthetic */ class a extends FunctionReference implements Function1<Member, Boolean> {

        /* renamed from: j */
        public static final a f23047j = new a();

        public a() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(Member.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            Intrinsics3.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$b */
    public /* synthetic */ class b extends FunctionReference implements Function1<Constructor<?>, ReflectJavaConstructor> {

        /* renamed from: j */
        public static final b f23048j = new b();

        public b() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaConstructor.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ReflectJavaConstructor invoke(Constructor<?> constructor) {
            return invoke2(constructor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ReflectJavaConstructor invoke2(Constructor<?> constructor) {
            Intrinsics3.checkNotNullParameter(constructor, "p0");
            return new ReflectJavaConstructor(constructor);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$c */
    public /* synthetic */ class c extends FunctionReference implements Function1<Member, Boolean> {

        /* renamed from: j */
        public static final c f23049j = new c();

        public c() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "isSynthetic";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(Member.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
            return Boolean.valueOf(invoke2(member));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Member member) {
            Intrinsics3.checkNotNullParameter(member, "p0");
            return member.isSynthetic();
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$d */
    public /* synthetic */ class d extends FunctionReference implements Function1<Field, ReflectJavaField> {

        /* renamed from: j */
        public static final d f23050j = new d();

        public d() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaField.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ReflectJavaField invoke(Field field) {
            return invoke2(field);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ReflectJavaField invoke2(Field field) {
            Intrinsics3.checkNotNullParameter(field, "p0");
            return new ReflectJavaField(field);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$e */
    public static final class e extends Lambda implements Function1<Class<?>, Boolean> {

        /* renamed from: j */
        public static final e f23051j = new e();

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
            Intrinsics3.checkNotNullExpressionValue(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$f */
    public static final class f extends Lambda implements Function1<Class<?>, Name> {

        /* renamed from: j */
        public static final f f23052j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Name invoke(Class<?> cls) {
            return invoke2(cls);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Name invoke2(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!Name.isValidIdentifier(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return Name.identifier(simpleName);
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$g */
    public static final class g extends Lambda implements Function1<Method, Boolean> {
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
                if (!ReflectJavaClass.this.isEnum()) {
                    return true;
                }
                ReflectJavaClass reflectJavaClass = ReflectJavaClass.this;
                Intrinsics3.checkNotNullExpressionValue(method, "method");
                if (!ReflectJavaClass.access$isEnumValuesOrValueOf(reflectJavaClass, method)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: ReflectJavaClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.j$h */
    public /* synthetic */ class h extends FunctionReference implements Function1<Method, ReflectJavaMethod> {

        /* renamed from: j */
        public static final h f23053j = new h();

        public h() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ReflectJavaMethod.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ReflectJavaMethod invoke(Method method) {
            return invoke2(method);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ReflectJavaMethod invoke2(Method method) {
            Intrinsics3.checkNotNullParameter(method, "p0");
            return new ReflectJavaMethod(method);
        }
    }

    public ReflectJavaClass(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "klass");
        this.f23046a = cls;
    }

    public static final boolean access$isEnumValuesOrValueOf(ReflectJavaClass reflectJavaClass, Method method) {
        Objects.requireNonNull(reflectJavaClass);
        String name = method.getName();
        if (Intrinsics3.areEqual(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (Intrinsics3.areEqual(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && Intrinsics3.areEqual(this.f23046a, ((ReflectJavaClass) obj).f23046a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner
    public /* bridge */ /* synthetic */ AnnotatedElement getElement() {
        return getElement();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public /* bridge */ /* synthetic */ Collection getFields() {
        return getFields();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public FqName getFqName() {
        FqName fqNameAsSingleFqName = reflectClassUtil.getClassId(this.f23046a).asSingleFqName();
        Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "klass.classId.asSingleFqName()");
        return fqNameAsSingleFqName;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public EnumC11569c0 getLightClassOriginKind() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.f23046a.getModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public Name getName() {
        Name nameIdentifier = Name.identifier(this.f23046a.getSimpleName());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(klass.simpleName)");
        return nameIdentifier;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public /* bridge */ /* synthetic */ InterfaceC11574g getOuterClass() {
        return getOuterClass();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<javaTypes3> getPermittedTypes() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<InterfaceC11590w> getRecordComponents() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public Collection<javaTypes3> getSupertypes() {
        Class cls;
        cls = Object.class;
        if (Intrinsics3.areEqual(this.f23046a, cls)) {
            return Collections2.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Object genericSuperclass = this.f23046a.getGenericSuperclass();
        spreadBuilder.add(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f23046a.getGenericInterfaces();
        Intrinsics3.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        spreadBuilder.addSpread(genericInterfaces);
        List listListOf = Collections2.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new ReflectJavaClassifierType((Type) it.next()));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f23046a.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public Visibility2 getVisibility() {
        return ReflectJavaModifierListOwner.a.getVisibility(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.f23046a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.isAbstract(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isAnnotationType() {
        return this.f23046a.isAnnotation();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isEnum() {
        return this.f23046a.isEnum();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.isFinal(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isInterface() {
        return this.f23046a.isInterface();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isRecord() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public boolean isSealed() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.isStatic(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.m860k0(ReflectJavaClass.class, sb, ": ");
        sb.append(this.f23046a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ InterfaceC11564a findAnnotation(FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<ReflectJavaConstructor> getConstructors() throws SecurityException {
        Constructor<?>[] declaredConstructors = this.f23046a.getDeclaredConstructors();
        Intrinsics3.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filterNot(_Arrays.asSequence(declaredConstructors), a.f23047j), b.f23048j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.f23046a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<ReflectJavaField> getFields() {
        Field[] declaredFields = this.f23046a.getDeclaredFields();
        Intrinsics3.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filterNot(_Arrays.asSequence(declaredFields), c.f23049j), d.f23050j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<Name> getInnerClassNames() {
        Class<?>[] declaredClasses = this.f23046a.getDeclaredClasses();
        Intrinsics3.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return _Sequences2.toList(_Sequences2.mapNotNull(_Sequences2.filterNot(_Arrays.asSequence(declaredClasses), e.f23051j), f.f23052j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public List<ReflectJavaMethod> getMethods() throws SecurityException {
        Method[] declaredMethods = this.f23046a.getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return _Sequences2.toList(_Sequences2.map(_Sequences2.filter(_Arrays.asSequence(declaredMethods), new g()), h.f23053j));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.f23046a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }
}
