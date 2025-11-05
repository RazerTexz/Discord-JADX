package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c0;
import d0.e0.p.d.i;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.b.b0.a;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.k.a0.l;
import d0.e0.p.d.m0.n.u0;
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

/* compiled from: KClassImpl.kt */
/* loaded from: classes3.dex */
public final class h<T> extends i implements d0.e0.c<T>, z {
    public final c0.b<h<T>.a> m;
    public final Class<T> n;

    /* compiled from: KClassImpl.kt */
    public final class a extends i.b {
        public static final /* synthetic */ KProperty[] d = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "annotations", "getAnnotations()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        public final c0.a e;
        public final c0.a f;
        public final c0.a g;
        public final c0.b h;
        public final c0.a i;
        public final c0.a j;
        public final c0.a k;
        public final c0.a l;
        public final c0.a m;
        public final c0.a n;
        public final c0.a o;

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$a, reason: collision with other inner class name */
        public static final class C0497a extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.f<?>>> {
            public C0497a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends d0.e0.p.d.f<?>> invoke2() {
                return d0.t.u.plus((Collection) a.this.getAllNonStaticMembers(), (Iterable) a.this.getAllStaticMembers());
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class b extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.f<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends d0.e0.p.d.f<?>> invoke2() {
                return d0.t.u.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getInheritedNonStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class c extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.f<?>>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends d0.e0.p.d.f<?>> invoke2() {
                return d0.t.u.plus(a.access$getDeclaredStaticMembers$p(a.this), (Iterable) a.access$getInheritedStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class d extends d0.z.d.o implements Function0<List<? extends Annotation>> {
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
                return j0.computeAnnotations(a.this.getDescriptor());
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class e extends d0.z.d.o implements Function0<List<? extends KFunction<? extends T>>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KFunction<T>> invoke() {
                Collection<d0.e0.p.d.m0.c.l> constructorDescriptors = h.this.getConstructorDescriptors();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(constructorDescriptors, 10));
                Iterator<T> it = constructorDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(new d0.e0.p.d.j(h.this, (d0.e0.p.d.m0.c.l) it.next()));
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class f extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.f<?>>> {
            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends d0.e0.p.d.f<?>> invoke2() {
                return d0.t.u.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getDeclaredStaticMembers$p(a.this));
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class g extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.f<?>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends d0.e0.p.d.f<?>> invoke2() {
                h hVar = h.this;
                return hVar.b(hVar.getMemberScope$kotlin_reflection(), i.c.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        /* renamed from: d0.e0.p.d.h$a$h, reason: collision with other inner class name */
        public static final class C0498h extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.f<?>>> {
            public C0498h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends d0.e0.p.d.f<?>> invoke2() {
                h hVar = h.this;
                return hVar.b(hVar.getStaticScope$kotlin_reflection(), i.c.DECLARED);
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class i extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.e> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.c.e invoke() {
                d0.e0.p.d.m0.g.a aVarAccess$getClassId$p = h.access$getClassId$p(h.this);
                d0.e0.p.d.m0.c.k1.a.k moduleData = h.this.getData().invoke().getModuleData();
                d0.e0.p.d.m0.c.e eVarDeserializeClass = aVarAccess$getClassId$p.isLocal() ? moduleData.getDeserialization().deserializeClass(aVarAccess$getClassId$p) : d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(moduleData.getModule(), aVarAccess$getClassId$p);
                if (eVarDeserializeClass != null) {
                    return eVarDeserializeClass;
                }
                h.access$reportUnresolvedClass(h.this);
                throw null;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class j extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.f<?>>> {
            public j() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends d0.e0.p.d.f<?>> invoke2() {
                h hVar = h.this;
                return hVar.b(hVar.getMemberScope$kotlin_reflection(), i.c.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class k extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.f<?>>> {
            public k() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.f<?>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<? extends d0.e0.p.d.f<?>> invoke2() {
                h hVar = h.this;
                return hVar.b(hVar.getStaticScope$kotlin_reflection(), i.c.INHERITED);
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class l extends d0.z.d.o implements Function0<List<? extends h<? extends Object>>> {
            public l() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends h<? extends Object>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends h<? extends Object>> invoke2() {
                Collection contributedDescriptors$default = l.a.getContributedDescriptors$default(a.this.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                ArrayList<d0.e0.p.d.m0.c.m> arrayList = new ArrayList();
                for (T t : contributedDescriptors$default) {
                    if (!d0.e0.p.d.m0.k.e.isEnumEntry((d0.e0.p.d.m0.c.m) t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (d0.e0.p.d.m0.c.m mVar : arrayList) {
                    Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) mVar);
                    h hVar = javaClass != null ? new h(javaClass) : null;
                    if (hVar != null) {
                        arrayList2.add(hVar);
                    }
                }
                return arrayList2;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class m extends d0.z.d.o implements Function0<T> {
            public m() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                d0.e0.p.d.m0.c.e descriptor = a.this.getDescriptor();
                if (descriptor.getKind() != d0.e0.p.d.m0.c.f.OBJECT) {
                    return null;
                }
                T t = (T) ((!descriptor.isCompanionObject() || d0.e0.p.d.m0.b.d.isMappedIntrinsicCompanionObject(d0.e0.p.d.m0.b.c.a, descriptor)) ? h.this.getJClass().getDeclaredField("INSTANCE") : h.this.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString())).get(null);
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                return t;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class n extends d0.z.d.o implements Function0<String> {
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
                if (h.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                d0.e0.p.d.m0.g.a aVarAccess$getClassId$p = h.access$getClassId$p(h.this);
                if (aVarAccess$getClassId$p.isLocal()) {
                    return null;
                }
                return aVarAccess$getClassId$p.asSingleFqName().asString();
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class o extends d0.z.d.o implements Function0<List<? extends h<? extends T>>> {
            public o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<h<? extends T>> invoke() {
                Collection<d0.e0.p.d.m0.c.e> sealedSubclasses = a.this.getDescriptor().getSealedSubclasses();
                d0.z.d.m.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (d0.e0.p.d.m0.c.e eVar : sealedSubclasses) {
                    Objects.requireNonNull(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = j0.toJavaClass(eVar);
                    h hVar = javaClass != null ? new h(javaClass) : null;
                    if (hVar != null) {
                        arrayList.add(hVar);
                    }
                }
                return arrayList;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class p extends d0.z.d.o implements Function0<String> {
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
                if (h.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                d0.e0.p.d.m0.g.a aVarAccess$getClassId$p = h.access$getClassId$p(h.this);
                if (aVarAccess$getClassId$p.isLocal()) {
                    a aVar = a.this;
                    return a.access$calculateLocalClassName(aVar, h.this.getJClass());
                }
                String strAsString = aVarAccess$getClassId$p.getShortClassName().asString();
                d0.z.d.m.checkNotNullExpressionValue(strAsString, "classId.shortClassName.asString()");
                return strAsString;
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class q extends d0.z.d.o implements Function0<List<? extends x>> {

            /* compiled from: KClassImpl.kt */
            /* renamed from: d0.e0.p.d.h$a$q$a, reason: collision with other inner class name */
            public static final class C0499a extends d0.z.d.o implements Function0<Type> {
                public final /* synthetic */ d0.e0.p.d.m0.n.c0 $kotlinType;
                public final /* synthetic */ q this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0499a(d0.e0.p.d.m0.n.c0 c0Var, q qVar) {
                    super(0);
                    this.$kotlinType = c0Var;
                    this.this$0 = qVar;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Type invoke() {
                    return invoke2();
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Type invoke2() {
                    d0.e0.p.d.m0.c.h declarationDescriptor = this.$kotlinType.getConstructor().getDeclarationDescriptor();
                    if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
                        throw new a0("Supertype not a class: " + declarationDescriptor);
                    }
                    Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) declarationDescriptor);
                    if (javaClass == null) {
                        StringBuilder sbU = b.d.b.a.a.U("Unsupported superclass of ");
                        sbU.append(a.this);
                        sbU.append(": ");
                        sbU.append(declarationDescriptor);
                        throw new a0(sbU.toString());
                    }
                    if (d0.z.d.m.areEqual(h.this.getJClass().getSuperclass(), javaClass)) {
                        Type genericSuperclass = h.this.getJClass().getGenericSuperclass();
                        d0.z.d.m.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = h.this.getJClass().getInterfaces();
                    d0.z.d.m.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                    int iIndexOf = d0.t.k.indexOf(interfaces, javaClass);
                    if (iIndexOf >= 0) {
                        Type type = h.this.getJClass().getGenericInterfaces()[iIndexOf];
                        d0.z.d.m.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
                        return type;
                    }
                    StringBuilder sbU2 = b.d.b.a.a.U("No superclass of ");
                    sbU2.append(a.this);
                    sbU2.append(" in Java reflection for ");
                    sbU2.append(declarationDescriptor);
                    throw new a0(sbU2.toString());
                }
            }

            /* compiled from: KClassImpl.kt */
            public static final class b extends d0.z.d.o implements Function0<Type> {
                public static final b j = new b();

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
            public /* bridge */ /* synthetic */ List<? extends x> invoke() {
                return invoke2();
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final List<? extends x> invoke2() {
                u0 typeConstructor = a.this.getDescriptor().getTypeConstructor();
                d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                Collection<d0.e0.p.d.m0.n.c0> supertypes = typeConstructor.getSupertypes();
                d0.z.d.m.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(supertypes.size());
                for (d0.e0.p.d.m0.n.c0 c0Var : supertypes) {
                    d0.z.d.m.checkNotNullExpressionValue(c0Var, "kotlinType");
                    arrayList.add(new x(c0Var, new C0499a(c0Var, this)));
                }
                if (!d0.e0.p.d.m0.b.h.isSpecialClassWithNoSupertypes(a.this.getDescriptor())) {
                    boolean z2 = false;
                    if (arrayList.isEmpty()) {
                        z2 = true;
                        if (z2) {
                            d0.e0.p.d.m0.n.j0 anyType = d0.e0.p.d.m0.k.x.a.getBuiltIns(a.this.getDescriptor()).getAnyType();
                            d0.z.d.m.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                            arrayList.add(new x(anyType, b.j));
                        }
                    } else {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            d0.e0.p.d.m0.c.e classDescriptorForType = d0.e0.p.d.m0.k.e.getClassDescriptorForType(((x) it.next()).getType());
                            d0.z.d.m.checkNotNullExpressionValue(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                            d0.e0.p.d.m0.c.f kind = classDescriptorForType.getKind();
                            d0.z.d.m.checkNotNullExpressionValue(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                            if (!(kind == d0.e0.p.d.m0.c.f.INTERFACE || kind == d0.e0.p.d.m0.c.f.ANNOTATION_CLASS)) {
                                break;
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    }
                }
                return d0.e0.p.d.m0.p.a.compact(arrayList);
            }
        }

        /* compiled from: KClassImpl.kt */
        public static final class r extends d0.z.d.o implements Function0<List<? extends y>> {
            public r() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends y> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends y> invoke2() {
                List<z0> declaredTypeParameters = a.this.getDescriptor().getDeclaredTypeParameters();
                d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(declaredTypeParameters, 10));
                for (z0 z0Var : declaredTypeParameters) {
                    h hVar = h.this;
                    d0.z.d.m.checkNotNullExpressionValue(z0Var, "descriptor");
                    arrayList.add(new y(hVar, z0Var));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.e = c0.lazySoft(new i());
            c0.lazySoft(new d());
            this.f = c0.lazySoft(new p());
            this.g = c0.lazySoft(new n());
            c0.lazySoft(new e());
            c0.lazySoft(new l());
            this.h = c0.lazy(new m());
            c0.lazySoft(new r());
            c0.lazySoft(new q());
            this.i = c0.lazySoft(new o());
            this.j = c0.lazySoft(new g());
            this.k = c0.lazySoft(new C0498h());
            this.l = c0.lazySoft(new j());
            this.m = c0.lazySoft(new k());
            this.n = c0.lazySoft(new b());
            this.o = c0.lazySoft(new c());
            c0.lazySoft(new f());
            c0.lazySoft(new C0497a());
        }

        public static final String access$calculateLocalClassName(a aVar, Class cls) {
            Objects.requireNonNull(aVar);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return d0.g0.w.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return d0.g0.w.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return d0.g0.w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
        }

        public static final Collection access$getDeclaredStaticMembers$p(a aVar) {
            return (Collection) aVar.k.getValue(aVar, d[11]);
        }

        public static final Collection access$getInheritedNonStaticMembers$p(a aVar) {
            return (Collection) aVar.l.getValue(aVar, d[12]);
        }

        public static final Collection access$getInheritedStaticMembers$p(a aVar) {
            return (Collection) aVar.m.getValue(aVar, d[13]);
        }

        public final Collection<d0.e0.p.d.f<?>> getAllNonStaticMembers() {
            return (Collection) this.n.getValue(this, d[14]);
        }

        public final Collection<d0.e0.p.d.f<?>> getAllStaticMembers() {
            return (Collection) this.o.getValue(this, d[15]);
        }

        public final Collection<d0.e0.p.d.f<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.j.getValue(this, d[10]);
        }

        public final d0.e0.p.d.m0.c.e getDescriptor() {
            return (d0.e0.p.d.m0.c.e) this.e.getValue(this, d[0]);
        }

        public final T getObjectInstance() {
            return this.h.getValue(this, d[6]);
        }

        public final String getQualifiedName() {
            return (String) this.g.getValue(this, d[3]);
        }

        public final List<d0.e0.c<? extends T>> getSealedSubclasses() {
            return (List) this.i.getValue(this, d[9]);
        }

        public final String getSimpleName() {
            return (String) this.f.getValue(this, d[2]);
        }
    }

    /* compiled from: KClassImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<h<T>.a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final h<T>.a invoke() {
            return new a();
        }
    }

    /* compiled from: KClassImpl.kt */
    public static final /* synthetic */ class c extends d0.z.d.j implements Function2<d0.e0.p.d.m0.l.b.u, d0.e0.p.d.m0.f.n, n0> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.l.b.u.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ n0 invoke(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
            return invoke2(uVar, nVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final n0 invoke2(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
            d0.z.d.m.checkNotNullParameter(uVar, "p1");
            d0.z.d.m.checkNotNullParameter(nVar, "p2");
            return uVar.loadProperty(nVar);
        }
    }

    public h(Class<T> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "jClass");
        this.n = cls;
        c0.b<h<T>.a> bVarLazy = c0.lazy(new b());
        d0.z.d.m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.m = bVarLazy;
    }

    public static final d0.e0.p.d.m0.g.a access$getClassId$p(h hVar) {
        Objects.requireNonNull(hVar);
        return f0.f3198b.mapJvmClassToKotlinClassId(hVar.getJClass());
    }

    public static final Void access$reportUnresolvedClass(h hVar) {
        d0.e0.p.d.m0.e.b.b0.a classHeader;
        Objects.requireNonNull(hVar);
        d0.e0.p.d.m0.c.k1.a.f fVarCreate = d0.e0.p.d.m0.c.k1.a.f.a.create(hVar.getJClass());
        a.EnumC0533a kind = (fVarCreate == null || (classHeader = fVarCreate.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind != null) {
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                StringBuilder sbU = b.d.b.a.a.U("Unknown class: ");
                sbU.append(hVar.getJClass());
                sbU.append(" (kind = ");
                sbU.append(kind);
                sbU.append(')');
                throw new a0(sbU.toString());
            }
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        StringBuilder sbX = b.d.b.a.a.X("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ", "library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                        sbX.append(hVar.getJClass());
                        throw new UnsupportedOperationException(sbX.toString());
                    }
                    if (iOrdinal != 4 && iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                StringBuilder sbX2 = b.d.b.a.a.X("Packages and file facades are not yet supported in Kotlin reflection. ", "Meanwhile please use Java reflection to inspect this class: ");
                sbX2.append(hVar.getJClass());
                throw new UnsupportedOperationException(sbX2.toString());
            }
        }
        StringBuilder sbU2 = b.d.b.a.a.U("Unresolved class: ");
        sbU2.append(hVar.getJClass());
        throw new a0(sbU2.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && d0.z.d.m.areEqual(d0.z.a.getJavaObjectType(this), d0.z.a.getJavaObjectType((d0.e0.c) obj));
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.l> getConstructorDescriptors() {
        d0.e0.p.d.m0.c.e descriptor = getDescriptor();
        if (descriptor.getKind() == d0.e0.p.d.m0.c.f.INTERFACE || descriptor.getKind() == d0.e0.p.d.m0.c.f.OBJECT) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.d> constructors = descriptor.getConstructors();
        d0.z.d.m.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    public final c0.b<h<T>.a> getData() {
        return this.m;
    }

    public d0.e0.p.d.m0.c.e getDescriptor() {
        return this.m.invoke().getDescriptor();
    }

    @Override // d0.e0.p.d.i
    public Collection<d0.e0.p.d.m0.c.x> getFunctions(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.e0.p.d.m0.k.a0.i memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FROM_REFLECTION;
        return d0.t.u.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(eVar, dVar), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(eVar, dVar));
    }

    @Override // d0.z.d.e
    public Class<T> getJClass() {
        return this.n;
    }

    @Override // d0.e0.p.d.i
    public n0 getLocalProperty(int i) {
        Class<?> declaringClass;
        if (d0.z.d.m.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            d0.e0.c kotlinClass = d0.z.a.getKotlinClass(declaringClass);
            Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((h) kotlinClass).getLocalProperty(i);
        }
        d0.e0.p.d.m0.c.e descriptor = getDescriptor();
        if (!(descriptor instanceof d0.e0.p.d.m0.l.b.e0.d)) {
            descriptor = null;
        }
        d0.e0.p.d.m0.l.b.e0.d dVar = (d0.e0.p.d.m0.l.b.e0.d) descriptor;
        if (dVar == null) {
            return null;
        }
        d0.e0.p.d.m0.f.c classProto = dVar.getClassProto();
        g.f<d0.e0.p.d.m0.f.c, List<d0.e0.p.d.m0.f.n>> fVar = d0.e0.p.d.m0.f.a0.a.j;
        d0.z.d.m.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classLocalVariable");
        d0.e0.p.d.m0.f.n nVar = (d0.e0.p.d.m0.f.n) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(classProto, fVar, i);
        if (nVar != null) {
            return (n0) j0.deserializeToDescriptor(getJClass(), nVar, dVar.getC().getNameResolver(), dVar.getC().getTypeTable(), dVar.getMetadataVersion(), c.j);
        }
        return null;
    }

    public final d0.e0.p.d.m0.k.a0.i getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // d0.e0.c
    public T getObjectInstance() {
        return this.m.invoke().getObjectInstance();
    }

    @Override // d0.e0.p.d.i
    public Collection<n0> getProperties(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.e0.p.d.m0.k.a0.i memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FROM_REFLECTION;
        return d0.t.u.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(eVar, dVar), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(eVar, dVar));
    }

    @Override // d0.e0.c
    public String getQualifiedName() {
        return this.m.invoke().getQualifiedName();
    }

    @Override // d0.e0.c
    public List<d0.e0.c<? extends T>> getSealedSubclasses() {
        return this.m.invoke().getSealedSubclasses();
    }

    @Override // d0.e0.c
    public String getSimpleName() {
        return this.m.invoke().getSimpleName();
    }

    public final d0.e0.p.d.m0.k.a0.i getStaticScope$kotlin_reflection() {
        d0.e0.p.d.m0.k.a0.i staticScope = getDescriptor().getStaticScope();
        d0.z.d.m.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    public int hashCode() {
        return d0.z.a.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sbU = b.d.b.a.a.U("class ");
        d0.e0.p.d.m0.g.a aVarMapJvmClassToKotlinClassId = f0.f3198b.mapJvmClassToKotlinClassId(getJClass());
        d0.e0.p.d.m0.g.b packageFqName = aVarMapJvmClassToKotlinClassId.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String strAsString = aVarMapJvmClassToKotlinClassId.getRelativeClassName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        sbU.append(str + d0.g0.t.replace$default(strAsString, '.', '$', false, 4, (Object) null));
        return sbU.toString();
    }
}
