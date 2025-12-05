package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.KClass;
import p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl;
import p507d0.p513e0.p514p.p515d.ReflectProperties;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.CompanionObjectMapping;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.CompanionObjectMappingUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.ReflectKotlinClass2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.RuntimeModuleData;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.MemberDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: KClassImpl.kt */
/* renamed from: d0.e0.p.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KTypeParameterOwnerImpl {

    /* renamed from: m */
    public final ReflectProperties.b<KClassImpl<T>.a> f22361m;

    /* renamed from: n */
    public final Class<T> f22362n;

    /* compiled from: KClassImpl.kt */
    /* renamed from: d0.e0.p.d.h$a */
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: d */
        public static final /* synthetic */ KProperty[] f22363d = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};

        /* renamed from: e */
        public final ReflectProperties.a f22364e;

        /* renamed from: f */
        public final ReflectProperties.a f22365f;

        /* renamed from: g */
        public final ReflectProperties.a f22366g;

        /* renamed from: h */
        public final ReflectProperties.b f22367h;

        /* renamed from: i */
        public final ReflectProperties.a f22368i;

        /* renamed from: j */
        public final ReflectProperties.a f22369j;

        /* renamed from: k */
        public final ReflectProperties.a f22370k;

        /* renamed from: l */
        public final ReflectProperties.a f22371l;

        /* renamed from: m */
        public final ReflectProperties.a f22372m;

        /* renamed from: n */
        public final ReflectProperties.a f22373n;

        /* renamed from: o */
        public final ReflectProperties.a f22374o;

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$a, reason: collision with other inner class name */
        public static final class C13302a extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public C13302a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KCallableImpl<?>> invoke2() {
                return _Collections.plus((Collection) a.this.getAllNonStaticMembers(), (Iterable) a.this.getAllStaticMembers());
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$b */
        public static final class b extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KCallableImpl<?>> invoke2() {
                return _Collections.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getInheritedNonStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$c */
        public static final class c extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KCallableImpl<?>> invoke2() {
                return _Collections.plus(a.access$getDeclaredStaticMembers$p(a.this), (Iterable) a.access$getInheritedStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$d */
        public static final class d extends Lambda implements Function0<List<? extends Annotation>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends Annotation> invoke2() {
                return util2.computeAnnotations(a.this.getDescriptor());
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$e */
        public static final class e extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KFunction<T>> invoke() {
                Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(constructorDescriptors, 10));
                Iterator<T> it = constructorDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KFunctionImpl(KClassImpl.this, (ConstructorDescriptor) it.next()));
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$f */
        public static final class f extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KCallableImpl<?>> invoke2() {
                return _Collections.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getDeclaredStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$g */
        public static final class g extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends KCallableImpl<?>> invoke2() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.m9341b(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$h */
        public static final class h extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends KCallableImpl<?>> invoke2() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.m9341b(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$i */
        public static final class i extends Lambda implements Function0<ClassDescriptor> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ ClassDescriptor invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ClassDescriptor invoke() {
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                RuntimeModuleData moduleData = KClassImpl.this.getData().invoke().getModuleData();
                ClassDescriptor classDescriptorDeserializeClass = classIdAccess$getClassId$p.isLocal() ? moduleData.getDeserialization().deserializeClass(classIdAccess$getClassId$p) : findClassInModule.findClassAcrossModuleDependencies(moduleData.getModule(), classIdAccess$getClassId$p);
                if (classDescriptorDeserializeClass != null) {
                    return classDescriptorDeserializeClass;
                }
                KClassImpl.access$reportUnresolvedClass(KClassImpl.this);
                throw null;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$j */
        public static final class j extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public j() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends KCallableImpl<?>> invoke2() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.m9341b(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$k */
        public static final class k extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public k() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends KCallableImpl<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends KCallableImpl<?>> invoke2() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.m9341b(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$l */
        public static final class l extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {
            public l() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KClassImpl<? extends Object>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KClassImpl<? extends Object>> invoke2() {
                Collection contributedDescriptors$default = ResolutionScope.a.getContributedDescriptors$default(a.this.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                for (T t : contributedDescriptors$default) {
                    if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (DeclarationDescriptor declarationDescriptor : arrayList) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList2.add(kClassImpl);
                    }
                }
                return arrayList2;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$m */
        public static final class m extends Lambda implements Function0<T> {
            public m() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                ClassDescriptor descriptor = a.this.getDescriptor();
                if (descriptor.getKind() != ClassKind.OBJECT) {
                    return null;
                }
                T t = (T) ((!descriptor.isCompanionObject() || CompanionObjectMappingUtils.isMappedIntrinsicCompanionObject(CompanionObjectMapping.f22455a, descriptor)) ? KClassImpl.this.getJClass().getDeclaredField("INSTANCE") : KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString())).get(null);
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                return t;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$n */
        public static final class n extends Lambda implements Function0<String> {
            public n() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ String invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2() {
                if (KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                if (classIdAccess$getClassId$p.isLocal()) {
                    return null;
                }
                return classIdAccess$getClassId$p.asSingleFqName().asString();
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$o */
        public static final class o extends Lambda implements Function0<List<? extends KClassImpl<? extends T>>> {
            public o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KClassImpl<? extends T>> invoke() {
                Collection<ClassDescriptor> sealedSubclasses = a.this.getDescriptor().getSealedSubclasses();
                Intrinsics3.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (ClassDescriptor classDescriptor : sealedSubclasses) {
                    Objects.requireNonNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = util2.toJavaClass(classDescriptor);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList.add(kClassImpl);
                    }
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$p */
        public static final class p extends Lambda implements Function0<String> {
            public p() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ String invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2() {
                if (KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                if (classIdAccess$getClassId$p.isLocal()) {
                    a aVar = a.this;
                    return a.access$calculateLocalClassName(aVar, KClassImpl.this.getJClass());
                }
                String strAsString = classIdAccess$getClassId$p.getShortClassName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.shortClassName.asString()");
                return strAsString;
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$q */
        public static final class q extends Lambda implements Function0<List<? extends KTypeImpl>> {

            /* compiled from: KClassImpl.kt */
            /* renamed from: d0.e0.p.d.h$a$q$a, reason: collision with other inner class name */
            public static final class C13303a extends Lambda implements Function0<Type> {
                public final /* synthetic */ KotlinType $kotlinType;
                public final /* synthetic */ q this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C13303a(KotlinType kotlinType, q qVar) {
                    super(0);
                    this.$kotlinType = kotlinType;
                    this.this$0 = qVar;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Type invoke() {
                    return invoke2();
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Type invoke2() {
                    ClassifierDescriptor declarationDescriptor = this.$kotlinType.getConstructor().getDeclarationDescriptor();
                    if (!(declarationDescriptor instanceof ClassDescriptor)) {
                        throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
                    }
                    Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
                    if (javaClass == null) {
                        StringBuilder sbM833U = outline.m833U("Unsupported superclass of ");
                        sbM833U.append(a.this);
                        sbM833U.append(": ");
                        sbM833U.append(declarationDescriptor);
                        throw new KotlinReflectionInternalError(sbM833U.toString());
                    }
                    if (Intrinsics3.areEqual(KClassImpl.this.getJClass().getSuperclass(), javaClass)) {
                        Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                        Intrinsics3.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                    Intrinsics3.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                    int iIndexOf = _Arrays.indexOf(interfaces, javaClass);
                    if (iIndexOf >= 0) {
                        Type type = KClassImpl.this.getJClass().getGenericInterfaces()[iIndexOf];
                        Intrinsics3.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
                        return type;
                    }
                    StringBuilder sbM833U2 = outline.m833U("No superclass of ");
                    sbM833U2.append(a.this);
                    sbM833U2.append(" in Java reflection for ");
                    sbM833U2.append(declarationDescriptor);
                    throw new KotlinReflectionInternalError(sbM833U2.toString());
                }
            }

            /* compiled from: KClassImpl.kt */
            /* renamed from: d0.e0.p.d.h$a$q$b */
            public static final class b extends Lambda implements Function0<Type> {

                /* renamed from: j */
                public static final b f22376j = new b();

                public b() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Type invoke() {
                    return invoke2();
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Type invoke2() {
                    return Object.class;
                }
            }

            public q() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KTypeImpl> invoke() {
                return invoke2();
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final List<? extends KTypeImpl> invoke2() {
                TypeConstructor typeConstructor = a.this.getDescriptor().getTypeConstructor();
                Intrinsics3.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(supertypes.size());
                for (KotlinType kotlinType : supertypes) {
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "kotlinType");
                    arrayList.add(new KTypeImpl(kotlinType, new C13303a(kotlinType, this)));
                }
                if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(a.this.getDescriptor())) {
                    boolean z2 = false;
                    if (arrayList.isEmpty()) {
                        z2 = true;
                        if (z2) {
                            KotlinType4 anyType = DescriptorUtils2.getBuiltIns(a.this.getDescriptor()).getAnyType();
                            Intrinsics3.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                            arrayList.add(new KTypeImpl(anyType, b.f22376j));
                        }
                    } else {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ClassDescriptor classDescriptorForType = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType());
                            Intrinsics3.checkNotNullExpressionValue(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            ClassKind kind = classDescriptorForType.getKind();
                            Intrinsics3.checkNotNullExpressionValue(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (!(kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS)) {
                                break;
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                return collections.compact(arrayList);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$r */
        public static final class r extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
            public r() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends KTypeParameterImpl> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends KTypeParameterImpl> invoke2() {
                List<TypeParameterDescriptor> declaredTypeParameters = a.this.getDescriptor().getDeclaredTypeParameters();
                Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
                    KClassImpl kClassImpl = KClassImpl.this;
                    Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.f22364e = ReflectProperties.lazySoft(new i());
            ReflectProperties.lazySoft(new d());
            this.f22365f = ReflectProperties.lazySoft(new p());
            this.f22366g = ReflectProperties.lazySoft(new n());
            ReflectProperties.lazySoft(new e());
            ReflectProperties.lazySoft(new l());
            this.f22367h = ReflectProperties.lazy(new m());
            ReflectProperties.lazySoft(new r());
            ReflectProperties.lazySoft(new q());
            this.f22368i = ReflectProperties.lazySoft(new o());
            this.f22369j = ReflectProperties.lazySoft(new g());
            this.f22370k = ReflectProperties.lazySoft(new h());
            this.f22371l = ReflectProperties.lazySoft(new j());
            this.f22372m = ReflectProperties.lazySoft(new k());
            this.f22373n = ReflectProperties.lazySoft(new b());
            this.f22374o = ReflectProperties.lazySoft(new c());
            ReflectProperties.lazySoft(new f());
            ReflectProperties.lazySoft(new C13302a());
        }

        public static final String access$calculateLocalClassName(a aVar, Class cls) {
            Objects.requireNonNull(aVar);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return Strings4.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return Strings4.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return Strings4.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
        }

        public static final Collection access$getDeclaredStaticMembers$p(a aVar) {
            return (Collection) aVar.f22370k.getValue(aVar, f22363d[11]);
        }

        public static final Collection access$getInheritedNonStaticMembers$p(a aVar) {
            return (Collection) aVar.f22371l.getValue(aVar, f22363d[12]);
        }

        public static final Collection access$getInheritedStaticMembers$p(a aVar) {
            return (Collection) aVar.f22372m.getValue(aVar, f22363d[13]);
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.f22373n.getValue(this, f22363d[14]);
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.f22374o.getValue(this, f22363d[15]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.f22369j.getValue(this, f22363d[10]);
        }

        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.f22364e.getValue(this, f22363d[0]);
        }

        public final T getObjectInstance() {
            return this.f22367h.getValue(this, f22363d[6]);
        }

        public final String getQualifiedName() {
            return (String) this.f22366g.getValue(this, f22363d[3]);
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            return (List) this.f22368i.getValue(this, f22363d[9]);
        }

        public final String getSimpleName() {
            return (String) this.f22365f.getValue(this, f22363d[2]);
        }
    }

    /* compiled from: KClassImpl.kt */
    /* renamed from: d0.e0.p.d.h$b */
    public static final class b extends Lambda implements Function0<KClassImpl<T>.a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final KClassImpl<T>.a invoke() {
            return new a();
        }
    }

    /* compiled from: KClassImpl.kt */
    /* renamed from: d0.e0.p.d.h$c */
    public static final /* synthetic */ class c extends FunctionReference implements Function2<MemberDeserializer, C11689n, PropertyDescriptor> {

        /* renamed from: j */
        public static final c f22377j = new c();

        public c() {
            super(2);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ PropertyDescriptor invoke(MemberDeserializer memberDeserializer, C11689n c11689n) {
            return invoke2(memberDeserializer, c11689n);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PropertyDescriptor invoke2(MemberDeserializer memberDeserializer, C11689n c11689n) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(c11689n, "p2");
            return memberDeserializer.loadProperty(c11689n);
        }
    }

    public KClassImpl(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        this.f22362n = cls;
        ReflectProperties.b<KClassImpl<T>.a> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.f22361m = bVarLazy;
    }

    public static final ClassId access$getClassId$p(KClassImpl kClassImpl) {
        Objects.requireNonNull(kClassImpl);
        return RuntimeTypeMapper3.f22358b.mapJvmClassToKotlinClassId(kClassImpl.getJClass());
    }

    public static final Void access$reportUnresolvedClass(KClassImpl kClassImpl) {
        KotlinClassHeader classHeader;
        Objects.requireNonNull(kClassImpl);
        ReflectKotlinClass2 reflectKotlinClass2Create = ReflectKotlinClass2.f23015a.create(kClassImpl.getJClass());
        KotlinClassHeader.a kind = (reflectKotlinClass2Create == null || (classHeader = reflectKotlinClass2Create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind != null) {
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                StringBuilder sbM833U = outline.m833U("Unknown class: ");
                sbM833U.append(kClassImpl.getJClass());
                sbM833U.append(" (kind = ");
                sbM833U.append(kind);
                sbM833U.append(')');
                throw new KotlinReflectionInternalError(sbM833U.toString());
            }
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        StringBuilder sbM836X = outline.m836X("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ", "library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                        sbM836X.append(kClassImpl.getJClass());
                        throw new UnsupportedOperationException(sbM836X.toString());
                    }
                    if (iOrdinal != 4 && iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                StringBuilder sbM836X2 = outline.m836X("Packages and file facades are not yet supported in Kotlin reflection. ", "Meanwhile please use Java reflection to inspect this class: ");
                sbM836X2.append(kClassImpl.getJClass());
                throw new UnsupportedOperationException(sbM836X2.toString());
            }
        }
        StringBuilder sbM833U2 = outline.m833U("Unresolved class: ");
        sbM833U2.append(kClassImpl.getJClass());
        throw new KotlinReflectionInternalError(sbM833U2.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof KClassImpl) && Intrinsics3.areEqual(JvmClassMapping.getJavaObjectType(this), JvmClassMapping.getJavaObjectType((KClass) obj));
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return Collections2.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics3.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    public final ReflectProperties.b<KClassImpl<T>.a> getData() {
        return this.f22361m;
    }

    public ClassDescriptor getDescriptor() {
        return this.f22361m.invoke().getDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        MemberScope3 memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        LookupLocation3 lookupLocation3 = LookupLocation3.FROM_REFLECTION;
        return _Collections.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(name, lookupLocation3), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, lookupLocation3));
    }

    @Override // p507d0.p592z.p594d.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.f22362n;
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (Intrinsics3.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMapping.getKotlinClass(declaringClass);
            Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(i);
        }
        ClassDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof DeserializedClassDescriptor)) {
            descriptor = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
        if (deserializedClassDescriptor == null) {
            return null;
        }
        C11678c classProto = deserializedClassDescriptor.getClassProto();
        GeneratedMessageLite.f<C11678c, List<C11689n>> fVar = JvmProtoBuf.f23660j;
        Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classLocalVariable");
        C11689n c11689n = (C11689n) ProtoBufUtil.getExtensionOrNull(classProto, fVar, i);
        if (c11689n != null) {
            return (PropertyDescriptor) util2.deserializeToDescriptor(getJClass(), c11689n, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), c.f22377j);
        }
        return null;
    }

    public final MemberScope3 getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // p507d0.p513e0.KClass
    public T getObjectInstance() {
        return this.f22361m.invoke().getObjectInstance();
    }

    @Override // p507d0.p513e0.p514p.p515d.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        MemberScope3 memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        LookupLocation3 lookupLocation3 = LookupLocation3.FROM_REFLECTION;
        return _Collections.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(name, lookupLocation3), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, lookupLocation3));
    }

    @Override // p507d0.p513e0.KClass
    public String getQualifiedName() {
        return this.f22361m.invoke().getQualifiedName();
    }

    @Override // p507d0.p513e0.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.f22361m.invoke().getSealedSubclasses();
    }

    @Override // p507d0.p513e0.KClass
    public String getSimpleName() {
        return this.f22361m.invoke().getSimpleName();
    }

    public final MemberScope3 getStaticScope$kotlin_reflection() {
        MemberScope3 staticScope = getDescriptor().getStaticScope();
        Intrinsics3.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    public int hashCode() {
        return JvmClassMapping.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sbM833U = outline.m833U("class ");
        ClassId classIdMapJvmClassToKotlinClassId = RuntimeTypeMapper3.f22358b.mapJvmClassToKotlinClassId(getJClass());
        FqName packageFqName = classIdMapJvmClassToKotlinClassId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String strAsString = classIdMapJvmClassToKotlinClassId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        sbM833U.append(str + StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null));
        return sbM833U.toString();
    }
}
