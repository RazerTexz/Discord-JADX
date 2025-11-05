package d0.e0.p.d.l0;

import d0.e0.p.d.a0;
import d0.e0.p.d.j0;
import d0.e0.p.d.l0.e;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.l;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ranges.IntRange;

/* compiled from: InlineClassAwareCaller.kt */
/* loaded from: classes3.dex */
public final class g<M extends Member> implements d<M> {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final d<M> f3205b;
    public final boolean c;

    /* compiled from: InlineClassAwareCaller.kt */
    public static final class a {
        public final IntRange a;

        /* renamed from: b, reason: collision with root package name */
        public final Method[] f3206b;
        public final Method c;

        public a(IntRange intRange, Method[] methodArr, Method method) {
            m.checkNotNullParameter(intRange, "argumentRange");
            m.checkNotNullParameter(methodArr, "unbox");
            this.a = intRange;
            this.f3206b = methodArr;
            this.c = method;
        }

        public final IntRange component1() {
            return this.a;
        }

        public final Method[] component2() {
            return this.f3206b;
        }

        public final Method component3() {
            return this.c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g(d0.e0.p.d.m0.c.b bVar, d<? extends M> dVar, boolean z2) {
        a aVar;
        Class<?> inlineClass;
        m.checkNotNullParameter(bVar, "descriptor");
        m.checkNotNullParameter(dVar, "caller");
        this.f3205b = dVar;
        this.c = z2;
        c0 returnType = bVar.getReturnType();
        m.checkNotNull(returnType);
        m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        Class<?> inlineClass2 = h.toInlineClass(returnType);
        Method boxMethod = inlineClass2 != null ? h.getBoxMethod(inlineClass2, bVar) : null;
        if (d0.e0.p.d.m0.k.g.isGetterOfUnderlyingPropertyOfInlineClass(bVar)) {
            aVar = new a(IntRange.INSTANCE.getEMPTY(), new Method[0], boxMethod);
        } else {
            int i = -1;
            if (!(dVar instanceof e.h.c)) {
                if (bVar instanceof l) {
                    if (!(dVar instanceof c)) {
                        i = 0;
                    }
                } else if (bVar.getDispatchReceiverParameter() != null && !(dVar instanceof c)) {
                    d0.e0.p.d.m0.c.m containingDeclaration = bVar.getContainingDeclaration();
                    m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                    if (!d0.e0.p.d.m0.k.g.isInlineClass(containingDeclaration)) {
                        i = 1;
                    }
                }
            }
            int i2 = (z2 ? 2 : 0) + (((bVar instanceof x) && ((x) bVar).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            q0 extensionReceiverParameter = bVar.getExtensionReceiverParameter();
            c0 type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (bVar instanceof l) {
                d0.e0.p.d.m0.c.e constructedClass = ((l) bVar).getConstructedClass();
                m.checkNotNullExpressionValue(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    d0.e0.p.d.m0.c.m containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Objects.requireNonNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((d0.e0.p.d.m0.c.e) containingDeclaration2).getDefaultType());
                }
            } else {
                d0.e0.p.d.m0.c.m containingDeclaration3 = bVar.getContainingDeclaration();
                m.checkNotNullExpressionValue(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.k.g.isInlineClass(containingDeclaration3)) {
                    arrayList.add(((d0.e0.p.d.m0.c.e) containingDeclaration3).getDefaultType());
                }
            }
            List<c1> valueParameters = bVar.getValueParameters();
            m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((c1) it.next()).getType());
            }
            int size = arrayList.size() + i + i2;
            if (f.getArity(this) != size) {
                StringBuilder sbU = b.d.b.a.a.U("Inconsistent number of parameters in the descriptor and Java reflection object: ");
                sbU.append(f.getArity(this));
                sbU.append(" != ");
                sbU.append(size);
                sbU.append('\n');
                sbU.append("Calling: ");
                sbU.append(bVar);
                sbU.append('\n');
                sbU.append("Parameter types: ");
                sbU.append(getParameterTypes());
                sbU.append(")\n");
                sbU.append("Default: ");
                sbU.append(this.c);
                throw new a0(sbU.toString());
            }
            IntRange intRangeUntil = d0.d0.f.until(Math.max(i, 0), arrayList.size() + i);
            Method[] methodArr = new Method[size];
            for (int i3 = 0; i3 < size; i3++) {
                methodArr[i3] = (!intRangeUntil.contains(i3) || (inlineClass = h.toInlineClass((c0) arrayList.get(i3 - i))) == null) ? null : h.getUnboxMethod(inlineClass, bVar);
            }
            aVar = new a(intRangeUntil, methodArr, boxMethod);
        }
        this.a = aVar;
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        m.checkNotNullParameter(objArr, "args");
        a aVar = this.a;
        IntRange intRangeComponent1 = aVar.component1();
        Method[] methodArrComponent2 = aVar.component2();
        Method methodComponent3 = aVar.component3();
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        m.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(objArrCopyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int first = intRangeComponent1.getFirst();
        int last = intRangeComponent1.getLast();
        if (first <= last) {
            while (true) {
                Method method = methodArrComponent2[first];
                Object objDefaultPrimitiveValue = objArr[first];
                if (method != null) {
                    if (objDefaultPrimitiveValue != null) {
                        objDefaultPrimitiveValue = method.invoke(objDefaultPrimitiveValue, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.checkNotNullExpressionValue(returnType, "method.returnType");
                        objDefaultPrimitiveValue = j0.defaultPrimitiveValue(returnType);
                    }
                }
                objArrCopyOf[first] = objDefaultPrimitiveValue;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object objCall = this.f3205b.call(objArrCopyOf);
        return (methodComponent3 == null || (objInvoke = methodComponent3.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // d0.e0.p.d.l0.d
    /* renamed from: getMember */
    public M mo80getMember() {
        return (M) this.f3205b.mo80getMember();
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return this.f3205b.getParameterTypes();
    }

    @Override // d0.e0.p.d.l0.d
    public Type getReturnType() {
        return this.f3205b.getReturnType();
    }
}
