package d0.e0.p.d.l0;

import d0.e0.p.d.l0.d;
import d0.t.k;
import d0.t.n;
import d0.z.d.c0;
import d0.z.d.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CallerImpl.kt */
/* loaded from: classes3.dex */
public abstract class e<M extends Member> implements d0.e0.p.d.l0.d<M> {
    public static final d a = new d(null);

    /* renamed from: b, reason: collision with root package name */
    public final List<Type> f3204b;
    public final M c;
    public final Type d;
    public final Class<?> e;

    /* compiled from: CallerImpl.kt */
    public static final class a extends e<Constructor<?>> implements d0.e0.p.d.l0.c {
        public final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor<?> constructor, Object obj) {
            Object[] objArr;
            m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                objArr = new Type[0];
            } else {
                Object[] objArrCopyOfRange = d0.t.j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length - 1);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                objArr = objArrCopyOfRange;
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
            this.f = obj;
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            c0 c0Var = new c0(3);
            c0Var.add(this.f);
            c0Var.addSpread(objArr);
            c0Var.add(null);
            return constructorMo80getMember.newInstance(c0Var.toArray(new Object[c0Var.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    public static final class b extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor<?> constructor) {
            Object[] objArr;
            m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                objArr = new Type[0];
            } else {
                Object[] objArrCopyOfRange = d0.t.j.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                objArr = objArrCopyOfRange;
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            c0 c0Var = new c0(2);
            c0Var.addSpread(objArr);
            c0Var.add(null);
            return constructorMo80getMember.newInstance(c0Var.toArray(new Object[c0Var.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    public static final class c extends e<Constructor<?>> implements d0.e0.p.d.l0.c {
        public final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor<?> constructor, Object obj) {
            m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f = obj;
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            c0 c0Var = new c0(2);
            c0Var.add(this.f);
            c0Var.addSpread(objArr);
            return constructorMo80getMember.newInstance(c0Var.toArray(new Object[c0Var.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    public static final class d {
        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$e, reason: collision with other inner class name */
    public static final class C0502e extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public C0502e(Constructor<?> constructor) {
            m.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            m.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            m.checkNotNullExpressionValue(declaringClass2, "klass");
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            m.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo80getMember().newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: CallerImpl.kt */
    public static abstract class f extends e<Field> {

        /* compiled from: CallerImpl.kt */
        public static final class a extends f implements d0.e0.p.d.l0.c {
            public final Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                m.checkNotNullParameter(field, "field");
                this.f = obj;
            }

            @Override // d0.e0.p.d.l0.e.f, d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return mo80getMember().get(this.f);
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class b extends f implements d0.e0.p.d.l0.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                m.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                m.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                m.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.e
            public void checkArguments(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                a(k.firstOrNull(objArr));
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$e, reason: collision with other inner class name */
        public static final class C0503e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0503e(Field field) {
                super(field, false, null);
                m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            Type genericType = field.getGenericType();
            m.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, genericType, z2 ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo80getMember().get(getInstanceClass() != null ? k.first(objArr) : null);
        }
    }

    /* compiled from: CallerImpl.kt */
    public static abstract class g extends e<Field> {
        public final boolean f;

        /* compiled from: CallerImpl.kt */
        public static final class a extends g implements d0.e0.p.d.l0.c {
            public final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z2, Object obj) {
                super(field, z2, false, null);
                m.checkNotNullParameter(field, "field");
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.e.g, d0.e0.p.d.l0.d
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo80getMember().set(this.g, k.first(objArr));
                return Unit.a;
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class b extends g implements d0.e0.p.d.l0.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z2) {
                super(field, z2, false, null);
                m.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.e.g, d0.e0.p.d.l0.d
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo80getMember().set(null, k.last(objArr));
                return Unit.a;
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z2) {
                super(field, z2, true, null);
                m.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z2) {
                super(field, z2, true, null);
                m.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.e.g, d0.e0.p.d.l0.e
            public void checkArguments(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                a(k.firstOrNull(objArr));
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$e, reason: collision with other inner class name */
        public static final class C0504e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0504e(Field field, boolean z2) {
                super(field, z2, false, null);
                m.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            Class cls = Void.TYPE;
            m.checkNotNullExpressionValue(cls, "Void.TYPE");
            Class<?> declaringClass = z3 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            m.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType}, null);
            this.f = z2;
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            mo80getMember().set(getInstanceClass() != null ? k.first(objArr) : null, k.last(objArr));
            return Unit.a;
        }

        @Override // d0.e0.p.d.l0.e
        public void checkArguments(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            super.checkArguments(objArr);
            if (this.f && k.last(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    /* compiled from: CallerImpl.kt */
    public static abstract class h extends e<Method> {
        public final boolean f;

        /* compiled from: CallerImpl.kt */
        public static final class a extends h implements d0.e0.p.d.l0.c {
            public final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, (Type[]) null, 4);
                m.checkNotNullParameter(method, "method");
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(this.g, objArr);
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class b extends h implements d0.e0.p.d.l0.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, (Type[]) null, 4);
                m.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(null, objArr);
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class c extends h implements d0.e0.p.d.l0.c {
            public final Object g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, Object obj) {
                Object objCopyOfRange;
                m.checkNotNullParameter(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
                if (genericParameterTypes.length <= 1) {
                    objCopyOfRange = new Type[0];
                } else {
                    objCopyOfRange = d0.t.j.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                    Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                super(method, false, (Type[]) objCopyOfRange, (DefaultConstructorMarker) null);
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                c0 c0Var = new c0(2);
                c0Var.add(this.g);
                c0Var.addSpread(objArr);
                return b(null, c0Var.toArray(new Object[c0Var.size()]));
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, (Type[]) null, 6);
                m.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = d0.t.j.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return b(obj, objArrCopyOfRange);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$e, reason: collision with other inner class name */
        public static final class C0505e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0505e(Method method) {
                super(method, true, (Type[]) null, 4);
                m.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                a(k.firstOrNull(objArr));
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = d0.t.j.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return b(null, objArrCopyOfRange);
            }
        }

        /* compiled from: CallerImpl.kt */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, (Type[]) null, 6);
                m.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.d
            public Object call(Object[] objArr) {
                m.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z2, typeArr);
        }

        public final Object b(Object obj, Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            return this.f ? Unit.a : mo80getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, int i) {
            Type[] genericParameterTypes;
            z2 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z2;
            if ((i & 4) != 0) {
                genericParameterTypes = method.getGenericParameterTypes();
                m.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
            } else {
                genericParameterTypes = null;
            }
            this(method, z2, genericParameterTypes);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z2, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            m.checkNotNullExpressionValue(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z2 ? method.getDeclaringClass() : null, typeArr, null);
            this.f = m.areEqual(getReturnType(), Void.TYPE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        List<Type> list;
        this.c = member;
        this.d = type;
        this.e = cls;
        if (cls != null) {
            c0 c0Var = new c0(2);
            c0Var.add(cls);
            c0Var.addSpread(typeArr);
            list = n.listOf(c0Var.toArray(new Type[c0Var.size()]));
            list = list == null ? k.toList(typeArr) : list;
        }
        this.f3204b = list;
    }

    public final void a(Object obj) {
        if (obj == null || !this.c.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        d.a.checkArguments(this, objArr);
    }

    public final Class<?> getInstanceClass() {
        return this.e;
    }

    @Override // d0.e0.p.d.l0.d
    /* renamed from: getMember */
    public final M mo80getMember() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return this.f3204b;
    }

    @Override // d0.e0.p.d.l0.d
    public final Type getReturnType() {
        return this.d;
    }
}
