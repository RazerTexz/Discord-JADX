package d0.e0.p.d.l0;

import d0.e0.p.d.l0.d;
import d0.t.h0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnnotationConstructorCaller.kt */
/* loaded from: classes3.dex */
public final class a implements d {
    public final List<Type> a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Class<?>> f3202b;
    public final List<Object> c;
    public final Class<?> d;
    public final List<String> e;
    public final EnumC0500a f;
    public final List<Method> g;

    /* compiled from: AnnotationConstructorCaller.kt */
    /* renamed from: d0.e0.p.d.l0.a$a, reason: collision with other inner class name */
    public enum EnumC0500a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* compiled from: AnnotationConstructorCaller.kt */
    public enum b {
        JAVA,
        KOTLIN
    }

    public a(Class<?> cls, List<String> list, EnumC0500a enumC0500a, b bVar, List<Method> list2) {
        m.checkNotNullParameter(cls, "jClass");
        m.checkNotNullParameter(list, "parameterNames");
        m.checkNotNullParameter(enumC0500a, "callMode");
        m.checkNotNullParameter(bVar, "origin");
        m.checkNotNullParameter(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = enumC0500a;
        this.g = list2;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.g;
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            m.checkNotNullExpressionValue(returnType, "it");
            Class<?> wrapperByPrimitive = d0.e0.p.d.m0.c.k1.b.b.getWrapperByPrimitive(returnType);
            if (wrapperByPrimitive != null) {
                returnType = wrapperByPrimitive;
            }
            arrayList2.add(returnType);
        }
        this.f3202b = arrayList2;
        List<Method> list4 = this.g;
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == EnumC0500a.POSITIONAL_CALL && bVar == b.JAVA && (!u.minus(this.e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            Object objAccess$transformKotlinToJvm = (obj == null && this.f == EnumC0500a.CALL_BY_NAME) ? this.c.get(i2) : d0.e0.p.d.l0.b.access$transformKotlinToJvm(obj, this.f3202b.get(i2));
            if (objAccess$transformKotlinToJvm == null) {
                d0.e0.p.d.l0.b.access$throwIllegalArgumentType(i2, this.e.get(i2), this.f3202b.get(i2));
                throw null;
            }
            arrayList.add(objAccess$transformKotlinToJvm);
            i++;
            i2 = i3;
        }
        return d0.e0.p.d.l0.b.createAnnotationInstance(this.d, h0.toMap(u.zip(this.e, arrayList)), this.g);
    }

    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        d.a.checkArguments(this, objArr);
    }

    public Void getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.d
    /* renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return (Member) getMember();
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // d0.e0.p.d.l0.d
    public Type getReturnType() {
        return this.d;
    }

    public /* synthetic */ a(Class cls, List list, EnumC0500a enumC0500a, b bVar, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            list2 = new ArrayList(o.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
        this(cls, list, enumC0500a, bVar, list2);
    }
}
