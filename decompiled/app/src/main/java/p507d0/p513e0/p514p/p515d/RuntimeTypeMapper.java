package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RuntimeTypeMapper.kt */
/* renamed from: d0.e0.p.d.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class RuntimeTypeMapper {

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$a */
    public static final class a extends RuntimeTypeMapper {

        /* renamed from: a */
        public final List<Method> f22327a;

        /* renamed from: b */
        public final Class<?> f22328b;

        /* compiled from: Comparisons.kt */
        /* renamed from: d0.e0.p.d.d$a$a, reason: collision with other inner class name */
        public static final class C13300a<T> implements Comparator<T> {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Method method = (Method) t;
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                String name = method.getName();
                Method method2 = (Method) t2;
                Intrinsics3.checkNotNullExpressionValue(method2, "it");
                return C12169a.compareValues(name, method2.getName());
            }
        }

        /* compiled from: RuntimeTypeMapper.kt */
        /* renamed from: d0.e0.p.d.d$a$b */
        public static final class b extends Lambda implements Function1<Method, CharSequence> {

            /* renamed from: j */
            public static final b f22329j = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Method method) {
                return invoke2(method);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Method method) {
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                Class<?> returnType = method.getReturnType();
                Intrinsics3.checkNotNullExpressionValue(returnType, "it.returnType");
                return reflectClassUtil.getDesc(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) throws SecurityException {
            super(null);
            Intrinsics3.checkNotNullParameter(cls, "jClass");
            this.f22328b = cls;
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics3.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
            this.f22327a = _Arrays.sortedWith(declaredMethods, new C13300a());
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper
        public String asString() {
            return _Collections.joinToString$default(this.f22327a, "", "<init>(", ")V", 0, null, b.f22329j, 24, null);
        }

        public final List<Method> getMethods() {
            return this.f22327a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$b */
    public static final class b extends RuntimeTypeMapper {

        /* renamed from: a */
        public final Constructor<?> f22330a;

        /* compiled from: RuntimeTypeMapper.kt */
        /* renamed from: d0.e0.p.d.d$b$a */
        public static final class a extends Lambda implements Function1<Class<?>, CharSequence> {

            /* renamed from: j */
            public static final a f22331j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> cls) {
                return invoke2(cls);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Class<?> cls) {
                Intrinsics3.checkNotNullExpressionValue(cls, "it");
                return reflectClassUtil.getDesc(cls);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            this.f22330a = constructor;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper
        public String asString() {
            Class<?>[] parameterTypes = this.f22330a.getParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
            return _Arrays.joinToString$default(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.f22331j, 24, (Object) null);
        }

        public final Constructor<?> getConstructor() {
            return this.f22330a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$c */
    public static final class c extends RuntimeTypeMapper {

        /* renamed from: a */
        public final Method f22332a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            Intrinsics3.checkNotNullParameter(method, "method");
            this.f22332a = method;
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper
        public String asString() {
            return RuntimeTypeMapper5.access$getSignature$p(this.f22332a);
        }

        public final Method getMethod() {
            return this.f22332a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$d */
    public static final class d extends RuntimeTypeMapper {

        /* renamed from: a */
        public final String f22333a;

        /* renamed from: b */
        public final JvmMemberSignature.b f22334b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(JvmMemberSignature.b bVar) {
            super(null);
            Intrinsics3.checkNotNullParameter(bVar, "signature");
            this.f22334b = bVar;
            this.f22333a = bVar.asString();
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper
        public String asString() {
            return this.f22333a;
        }

        public final String getConstructorDesc() {
            return this.f22334b.getDesc();
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    /* renamed from: d0.e0.p.d.d$e */
    public static final class e extends RuntimeTypeMapper {

        /* renamed from: a */
        public final String f22335a;

        /* renamed from: b */
        public final JvmMemberSignature.b f22336b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(JvmMemberSignature.b bVar) {
            super(null);
            Intrinsics3.checkNotNullParameter(bVar, "signature");
            this.f22336b = bVar;
            this.f22335a = bVar.asString();
        }

        @Override // p507d0.p513e0.p514p.p515d.RuntimeTypeMapper
        public String asString() {
            return this.f22335a;
        }

        public final String getMethodDesc() {
            return this.f22336b.getDesc();
        }

        public final String getMethodName() {
            return this.f22336b.getName();
        }
    }

    public RuntimeTypeMapper(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();
}
