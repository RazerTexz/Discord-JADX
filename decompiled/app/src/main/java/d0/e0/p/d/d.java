package d0.e0.p.d;

import d0.e0.p.d.m0.f.a0.b.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RuntimeTypeMapper.kt */
/* loaded from: classes3.dex */
public abstract class d {

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class a extends d {
        public final List<Method> a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f3191b;

        /* compiled from: Comparisons.kt */
        /* renamed from: d0.e0.p.d.d$a$a, reason: collision with other inner class name */
        public static final class C0494a<T> implements Comparator<T> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Method method = (Method) t;
                d0.z.d.m.checkNotNullExpressionValue(method, "it");
                String name = method.getName();
                Method method2 = (Method) t2;
                d0.z.d.m.checkNotNullExpressionValue(method2, "it");
                return d0.u.a.compareValues(name, method2.getName());
            }
        }

        /* compiled from: RuntimeTypeMapper.kt */
        public static final class b extends d0.z.d.o implements Function1<Method, CharSequence> {
            public static final b j = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Method method) {
                return invoke2(method);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Method method) {
                d0.z.d.m.checkNotNullExpressionValue(method, "it");
                Class<?> returnType = method.getReturnType();
                d0.z.d.m.checkNotNullExpressionValue(returnType, "it.returnType");
                return d0.e0.p.d.m0.c.k1.b.b.getDesc(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) throws SecurityException {
            super(null);
            d0.z.d.m.checkNotNullParameter(cls, "jClass");
            this.f3191b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
            this.a = d0.t.k.sortedWith(declaredMethods, new C0494a());
        }

        @Override // d0.e0.p.d.d
        public String asString() {
            return d0.t.u.joinToString$default(this.a, "", "<init>(", ")V", 0, null, b.j, 24, null);
        }

        public final List<Method> getMethods() {
            return this.a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class b extends d {
        public final Constructor<?> a;

        /* compiled from: RuntimeTypeMapper.kt */
        public static final class a extends d0.z.d.o implements Function1<Class<?>, CharSequence> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> cls) {
                return invoke2(cls);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Class<?> cls) {
                d0.z.d.m.checkNotNullExpressionValue(cls, "it");
                return d0.e0.p.d.m0.c.k1.b.b.getDesc(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            d0.z.d.m.checkNotNullParameter(constructor, "constructor");
            this.a = constructor;
        }

        @Override // d0.e0.p.d.d
        public String asString() {
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            d0.z.d.m.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            return d0.t.k.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.j, 24, (Object) null);
        }

        public final Constructor<?> getConstructor() {
            return this.a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class c extends d {
        public final Method a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            d0.z.d.m.checkNotNullParameter(method, "method");
            this.a = method;
        }

        @Override // d0.e0.p.d.d
        public String asString() {
            return h0.access$getSignature$p(this.a);
        }

        public final Method getMethod() {
            return this.a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$d, reason: collision with other inner class name */
    public static final class C0495d extends d {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final e.b f3192b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0495d(e.b bVar) {
            super(null);
            d0.z.d.m.checkNotNullParameter(bVar, "signature");
            this.f3192b = bVar;
            this.a = bVar.asString();
        }

        @Override // d0.e0.p.d.d
        public String asString() {
            return this.a;
        }

        public final String getConstructorDesc() {
            return this.f3192b.getDesc();
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    public static final class e extends d {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final e.b f3193b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e.b bVar) {
            super(null);
            d0.z.d.m.checkNotNullParameter(bVar, "signature");
            this.f3193b = bVar;
            this.a = bVar.asString();
        }

        @Override // d0.e0.p.d.d
        public String asString() {
            return this.a;
        }

        public final String getMethodDesc() {
            return this.f3193b.getDesc();
        }

        public final String getMethodName() {
            return this.f3193b.getName();
        }
    }

    public d(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
