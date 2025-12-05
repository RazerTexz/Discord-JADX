package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p516l0.Caller2;
import p507d0.p513e0.p514p.p515d.p516l0.CallerImpl;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InternalUnderlyingValOfInlineClass.kt */
/* renamed from: d0.e0.p.d.l0.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class InternalUnderlyingValOfInlineClass implements Caller2<Method> {

    /* renamed from: a */
    public final Type f22442a;

    /* renamed from: b */
    public final Method f22443b;

    /* renamed from: c */
    public final List<Type> f22444c;

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    /* renamed from: d0.e0.p.d.l0.i$a */
    public static final class a extends InternalUnderlyingValOfInlineClass implements Caller {

        /* renamed from: d */
        public final Object f22445d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, Collections2.emptyList(), null);
            Intrinsics3.checkNotNullParameter(method, "unboxMethod");
            this.f22445d = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = this.f22445d;
            Intrinsics3.checkNotNullParameter(objArr, "args");
            return this.f22443b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    /* renamed from: d0.e0.p.d.l0.i$b */
    public static final class b extends InternalUnderlyingValOfInlineClass {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, CollectionsJVM.listOf(method.getDeclaringClass()), null);
            Intrinsics3.checkNotNullParameter(method, "unboxMethod");
        }

        @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
        public Object call(Object[] objArr) {
            Object[] objArrCopyOfRange;
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Object obj = objArr[0];
            CallerImpl.d dVar = CallerImpl.f22423a;
            if (objArr.length <= 1) {
                objArrCopyOfRange = new Object[0];
            } else {
                objArrCopyOfRange = _ArraysJvm.copyOfRange(objArr, 1, objArr.length);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            Intrinsics3.checkNotNullParameter(objArrCopyOfRange, "args");
            return this.f22443b.invoke(obj, Arrays.copyOf(objArrCopyOfRange, objArrCopyOfRange.length));
        }
    }

    public InternalUnderlyingValOfInlineClass(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f22443b = method;
        this.f22444c = list;
        Class<?> returnType = method.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "unboxMethod.returnType");
        this.f22442a = returnType;
    }

    public void checkArguments(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        Caller2.a.checkArguments(this, objArr);
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    /* renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo11457getMember() {
        return mo11457getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    /* renamed from: getMember */
    public final Method mo11457getMember() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    public final List<Type> getParameterTypes() {
        return this.f22444c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.Caller2
    public final Type getReturnType() {
        return this.f22442a;
    }
}
