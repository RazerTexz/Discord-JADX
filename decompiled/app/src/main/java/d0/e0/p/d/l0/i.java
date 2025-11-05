package d0.e0.p.d.l0;

import d0.e0.p.d.l0.d;
import d0.e0.p.d.l0.e;
import d0.t.n;
import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InternalUnderlyingValOfInlineClass.kt */
/* loaded from: classes3.dex */
public abstract class i implements d<Method> {
    public final Type a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3207b;
    public final List<Type> c;

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class a extends i implements c {
        public final Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, n.emptyList(), null);
            m.checkNotNullParameter(method, "unboxMethod");
            this.d = obj;
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = this.d;
            m.checkNotNullParameter(objArr, "args");
            return this.f3207b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    public static final class b extends i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, d0.t.m.listOf(method.getDeclaringClass()), null);
            m.checkNotNullParameter(method, "unboxMethod");
        }

        @Override // d0.e0.p.d.l0.d
        public Object call(Object[] objArr) {
            Object[] objArrCopyOfRange;
            m.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = objArr[0];
            e.d dVar = e.a;
            if (objArr.length <= 1) {
                objArrCopyOfRange = new Object[0];
            } else {
                objArrCopyOfRange = d0.t.j.copyOfRange(objArr, 1, objArr.length);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            m.checkNotNullParameter(objArrCopyOfRange, "args");
            return this.f3207b.invoke(obj, Arrays.copyOf(objArrCopyOfRange, objArrCopyOfRange.length));
        }
    }

    public i(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3207b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        m.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        d.a.checkArguments(this, objArr);
    }

    @Override // d0.e0.p.d.l0.d
    /* renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return mo80getMember();
    }

    @Override // d0.e0.p.d.l0.d
    /* renamed from: getMember */
    public final Method mo80getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.d
    public final List<Type> getParameterTypes() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.d
    public final Type getReturnType() {
        return this.a;
    }
}
