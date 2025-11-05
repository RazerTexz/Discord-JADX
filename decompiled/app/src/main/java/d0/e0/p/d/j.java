package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.c;
import d0.e0.p.d.c0;
import d0.e0.p.d.d;
import d0.e0.p.d.l0.a;
import d0.e0.p.d.l0.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;

/* compiled from: KFunctionImpl.kt */
/* loaded from: classes3.dex */
public final class j extends f<Object> implements d0.z.d.i<Object>, KFunction<Object>, d0.e0.p.d.c {
    public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    public final c0.a o;
    public final c0.b p;
    public final c0.b q;
    public final i r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3200s;
    public final Object t;

    /* compiled from: KFunctionImpl.kt */
    public static final class a extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<? extends Member>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<? extends Member> invoke2() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.l0.d<? extends Member> invoke() throws SecurityException {
            Object constructor;
            d0.e0.p.d.l0.d dVarAccess$createInstanceMethodCaller;
            a.EnumC0500a enumC0500a = a.EnumC0500a.POSITIONAL_CALL;
            d dVarMapSignature = f0.f3198b.mapSignature(j.this.getDescriptor());
            if (dVarMapSignature instanceof d.C0495d) {
                if (j.this.b()) {
                    Class<?> jClass = j.this.getContainer().getJClass();
                    List<d0.e0.f> parameters = j.this.getParameters();
                    ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((d0.e0.f) it.next()).getName();
                        d0.z.d.m.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new d0.e0.p.d.l0.a(jClass, arrayList, enumC0500a, a.b.KOTLIN, null, 16, null);
                }
                constructor = j.this.getContainer().findConstructorBySignature(((d.C0495d) dVarMapSignature).getConstructorDesc());
            } else if (dVarMapSignature instanceof d.e) {
                d.e eVar = (d.e) dVarMapSignature;
                constructor = j.this.getContainer().findMethodBySignature(eVar.getMethodName(), eVar.getMethodDesc());
            } else if (dVarMapSignature instanceof d.c) {
                constructor = ((d.c) dVarMapSignature).getMethod();
            } else {
                if (!(dVarMapSignature instanceof d.b)) {
                    if (!(dVarMapSignature instanceof d.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<Method> methods = ((d.a) dVarMapSignature).getMethods();
                    Class<?> jClass2 = j.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        d0.z.d.m.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new d0.e0.p.d.l0.a(jClass2, arrayList2, enumC0500a, a.b.JAVA, methods);
                }
                constructor = ((d.b) dVarMapSignature).getConstructor();
            }
            if (constructor instanceof Constructor) {
                j jVar = j.this;
                dVarAccess$createInstanceMethodCaller = j.access$createConstructorCaller(jVar, (Constructor) constructor, jVar.getDescriptor());
            } else {
                if (!(constructor instanceof Method)) {
                    StringBuilder sbU = b.d.b.a.a.U("Could not compute caller for function: ");
                    sbU.append(j.this.getDescriptor());
                    sbU.append(" (member = ");
                    sbU.append(constructor);
                    sbU.append(')');
                    throw new a0(sbU.toString());
                }
                Method method2 = (Method) constructor;
                dVarAccess$createInstanceMethodCaller = !Modifier.isStatic(method2.getModifiers()) ? j.access$createInstanceMethodCaller(j.this, method2) : j.this.getDescriptor().getAnnotations().findAnnotation(j0.getJVM_STATIC()) != null ? j.access$createJvmStaticInObjectCaller(j.this, method2) : j.access$createStaticMethodCaller(j.this, method2);
            }
            return d0.e0.p.d.l0.h.createInlineClassAwareCallerIfNeeded$default(dVarAccess$createInstanceMethodCaller, j.this.getDescriptor(), false, 2, null);
        }
    }

    /* compiled from: KFunctionImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<d0.e0.p.d.l0.d<? extends Member>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ d0.e0.p.d.l0.d<? extends Member> invoke2() {
            return invoke();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final d0.e0.p.d.l0.d<? extends Member> invoke() {
            GenericDeclaration genericDeclarationFindDefaultConstructor;
            d0.e0.p.d.l0.d dVarAccess$createJvmStaticInObjectCaller;
            a.EnumC0500a enumC0500a = a.EnumC0500a.CALL_BY_NAME;
            d dVarMapSignature = f0.f3198b.mapSignature(j.this.getDescriptor());
            if (dVarMapSignature instanceof d.e) {
                i container = j.this.getContainer();
                d.e eVar = (d.e) dVarMapSignature;
                String methodName = eVar.getMethodName();
                String methodDesc = eVar.getMethodDesc();
                d0.z.d.m.checkNotNull(j.this.getCaller().mo80getMember());
                genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(r5.getModifiers()));
            } else if (dVarMapSignature instanceof d.C0495d) {
                if (j.this.b()) {
                    Class<?> jClass = j.this.getContainer().getJClass();
                    List<d0.e0.f> parameters = j.this.getParameters();
                    ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((d0.e0.f) it.next()).getName();
                        d0.z.d.m.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new d0.e0.p.d.l0.a(jClass, arrayList, enumC0500a, a.b.KOTLIN, null, 16, null);
                }
                genericDeclarationFindDefaultConstructor = j.this.getContainer().findDefaultConstructor(((d.C0495d) dVarMapSignature).getConstructorDesc());
            } else {
                if (dVarMapSignature instanceof d.a) {
                    List<Method> methods = ((d.a) dVarMapSignature).getMethods();
                    Class<?> jClass2 = j.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        d0.z.d.m.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new d0.e0.p.d.l0.a(jClass2, arrayList2, enumC0500a, a.b.JAVA, methods);
                }
                genericDeclarationFindDefaultConstructor = null;
            }
            if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
                j jVar = j.this;
                dVarAccess$createJvmStaticInObjectCaller = j.access$createConstructorCaller(jVar, (Constructor) genericDeclarationFindDefaultConstructor, jVar.getDescriptor());
            } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
                dVarAccess$createJvmStaticInObjectCaller = null;
            } else if (j.this.getDescriptor().getAnnotations().findAnnotation(j0.getJVM_STATIC()) != null) {
                d0.e0.p.d.m0.c.m containingDeclaration = j.this.getDescriptor().getContainingDeclaration();
                Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                dVarAccess$createJvmStaticInObjectCaller = !((d0.e0.p.d.m0.c.e) containingDeclaration).isCompanionObject() ? j.access$createJvmStaticInObjectCaller(j.this, (Method) genericDeclarationFindDefaultConstructor) : j.access$createStaticMethodCaller(j.this, (Method) genericDeclarationFindDefaultConstructor);
            }
            if (dVarAccess$createJvmStaticInObjectCaller != null) {
                return d0.e0.p.d.l0.h.createInlineClassAwareCallerIfNeeded(dVarAccess$createJvmStaticInObjectCaller, j.this.getDescriptor(), true);
            }
            return null;
        }
    }

    /* compiled from: KFunctionImpl.kt */
    public static final class c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.x> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.$name = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.c.x invoke() {
            return j.this.getContainer().findFunctionDescriptor(this.$name, j.access$getSignature$p(j.this));
        }
    }

    public j(i iVar, String str, String str2, d0.e0.p.d.m0.c.x xVar, Object obj) {
        this.r = iVar;
        this.f3200s = str2;
        this.t = obj;
        this.o = c0.lazySoft(xVar, new c(str));
        this.p = c0.lazy(new a());
        this.q = c0.lazy(new b());
    }

    public static final d0.e0.p.d.l0.e access$createConstructorCaller(j jVar, Constructor constructor, d0.e0.p.d.m0.c.x xVar) {
        Objects.requireNonNull(jVar);
        return d0.e0.p.d.m0.k.y.a.shouldHideConstructorDueToInlineClassTypeValueParameters(xVar) ? jVar.isBound() ? new e.a(constructor, jVar.getBoundReceiver()) : new e.b(constructor) : jVar.isBound() ? new e.c(constructor, jVar.getBoundReceiver()) : new e.C0502e(constructor);
    }

    public static final e.h access$createInstanceMethodCaller(j jVar, Method method) {
        return jVar.isBound() ? new e.h.a(method, jVar.getBoundReceiver()) : new e.h.d(method);
    }

    public static final e.h access$createJvmStaticInObjectCaller(j jVar, Method method) {
        return jVar.isBound() ? new e.h.b(method) : new e.h.C0505e(method);
    }

    public static final e.h access$createStaticMethodCaller(j jVar, Method method) {
        return jVar.isBound() ? new e.h.c(method, jVar.getBoundReceiver()) : new e.h.f(method);
    }

    public static final /* synthetic */ String access$getSignature$p(j jVar) {
        return jVar.f3200s;
    }

    public boolean equals(Object obj) {
        j jVarAsKFunctionImpl = j0.asKFunctionImpl(obj);
        return jVarAsKFunctionImpl != null && d0.z.d.m.areEqual(getContainer(), jVarAsKFunctionImpl.getContainer()) && d0.z.d.m.areEqual(getName(), jVarAsKFunctionImpl.getName()) && d0.z.d.m.areEqual(this.f3200s, jVarAsKFunctionImpl.f3200s) && d0.z.d.m.areEqual(this.t, jVarAsKFunctionImpl.t);
    }

    @Override // d0.z.d.i
    public int getArity() {
        return d0.e0.p.d.l0.f.getArity(getCaller());
    }

    public final Object getBoundReceiver() {
        return d0.e0.p.d.l0.h.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
    }

    @Override // d0.e0.p.d.f
    public i getContainer() {
        return this.r;
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getDefaultCaller() {
        return (d0.e0.p.d.l0.d) this.q.getValue(this, n[2]);
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.m0.c.x getDescriptor() {
        return (d0.e0.p.d.m0.c.x) this.o.getValue(this, n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    public int hashCode() {
        return this.f3200s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return c.a.invoke(this);
    }

    @Override // d0.e0.p.d.f
    public boolean isBound() {
        return !d0.z.d.m.areEqual(this.t, d0.z.d.d.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public String toString() {
        return e0.f3197b.renderFunction(getDescriptor());
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return c.a.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return c.a.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return c.a.invoke(this, obj, obj2, obj3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return c.a.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j(i iVar, d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        String strAsString = xVar.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(iVar, strAsString, f0.f3198b.mapSignature(xVar).asString(), xVar, d0.z.d.d.NO_RECEIVER);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
