package b.g.a.c.c0;

import b.g.a.c.c0.e0;
import b.g.a.c.c0.h;
import b.g.a.c.c0.k;
import b.g.a.c.c0.t;
import b.g.a.c.i0.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: AnnotatedClass.java */
/* loaded from: classes3.dex */
public final class c extends b implements e0 {
    public static final a j = new a(null, Collections.emptyList(), Collections.emptyList());
    public final b.g.a.c.j k;
    public final Class<?> l;
    public final b.g.a.c.h0.m m;
    public final List<b.g.a.c.j> n;
    public final b.g.a.c.b o;
    public final b.g.a.c.h0.n p;
    public final t.a q;
    public final Class<?> r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f684s;
    public final b.g.a.c.i0.a t;
    public a u;
    public l v;
    public List<g> w;

    /* renamed from: x, reason: collision with root package name */
    public transient Boolean f685x;

    /* compiled from: AnnotatedClass.java */
    public static final class a {
        public final e a;

        /* renamed from: b, reason: collision with root package name */
        public final List<e> f686b;
        public final List<j> c;

        public a(e eVar, List<e> list, List<j> list2) {
            this.a = eVar;
            this.f686b = list;
            this.c = list2;
        }
    }

    public c(b.g.a.c.j jVar, Class<?> cls, List<b.g.a.c.j> list, Class<?> cls2, b.g.a.c.i0.a aVar, b.g.a.c.h0.m mVar, b.g.a.c.b bVar, t.a aVar2, b.g.a.c.h0.n nVar, boolean z2) {
        this.k = jVar;
        this.l = cls;
        this.n = list;
        this.r = cls2;
        this.t = aVar;
        this.m = mVar;
        this.o = bVar;
        this.q = aVar2;
        this.p = nVar;
        this.f684s = z2;
    }

    @Override // b.g.a.c.c0.e0
    public b.g.a.c.j a(Type type) {
        return this.p.b(null, type, this.m);
    }

    @Override // b.g.a.c.c0.b
    public <A extends Annotation> A b(Class<A> cls) {
        return (A) this.t.a(cls);
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this.l;
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this.k;
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return b.g.a.c.i0.d.o(obj, c.class) && ((c) obj).l == this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0146  */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a f() throws SecurityException, IllegalArgumentException {
        d.a aVar;
        ArrayList arrayList;
        int size;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        List listEmptyList;
        b.g.a.c.j jVar;
        int i;
        ArrayList arrayList5;
        b.g.a.c.h0.m mVar;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] methodArr;
        d.a[] aVarArr;
        a aVar2 = this.u;
        if (aVar2 == null) {
            b.g.a.c.j jVar2 = this.k;
            if (jVar2 == null) {
                aVar2 = j;
            } else {
                b.g.a.c.b bVar = this.o;
                b.g.a.c.h0.n nVar = this.p;
                Class<?> cls = this.r;
                f fVar = new f(bVar, this, this.f684s | (cls != null));
                if (jVar2.w()) {
                    aVar = null;
                    arrayList = null;
                } else {
                    aVar = null;
                    arrayList = null;
                    for (d.a aVar3 : b.g.a.c.i0.d.l(jVar2._class)) {
                        if (!aVar3.a.isSynthetic()) {
                            if (aVar3.a() == 0) {
                                aVar = aVar3;
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(aVar3);
                            }
                        }
                    }
                }
                if (arrayList == null) {
                    ?? EmptyList = Collections.emptyList();
                    arrayList3 = EmptyList;
                    if (aVar != null) {
                        arrayList2 = EmptyList;
                        size = 0;
                    }
                    arrayList4 = null;
                    for (Method method : b.g.a.c.i0.d.k(jVar2._class)) {
                        if (f.f(method)) {
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(method);
                        }
                    }
                    if (arrayList4 != null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        e0.b bVar2 = new e0.b(nVar);
                        int size2 = arrayList4.size();
                        ArrayList arrayList6 = new ArrayList(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            arrayList6.add(null);
                        }
                        if (cls != null) {
                            Method[] declaredMethods = cls.getDeclaredMethods();
                            int length = declaredMethods.length;
                            y[] yVarArr = null;
                            int i3 = 0;
                            while (i3 < length) {
                                Method method2 = declaredMethods[i3];
                                if (f.f(method2)) {
                                    if (yVarArr == null) {
                                        yVarArr = new y[size2];
                                        int i4 = 0;
                                        while (i4 < size2) {
                                            yVarArr[i4] = new y((Method) arrayList4.get(i4));
                                            i4++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    y yVar = new y(method2);
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size2) {
                                            break;
                                        }
                                        if (yVar.equals(yVarArr[i5])) {
                                            arrayList6.set(i5, fVar.j((Method) arrayList4.get(i5), bVar2, method2));
                                            break;
                                        }
                                        i5++;
                                    }
                                } else {
                                    methodArr = declaredMethods;
                                }
                                i3++;
                                declaredMethods = methodArr;
                            }
                        }
                        int i6 = 0;
                        while (i6 < size2) {
                            if (((j) arrayList6.get(i6)) == null) {
                                Method method3 = (Method) arrayList4.get(i6);
                                TypeVariable<Method>[] typeParameters = method3.getTypeParameters();
                                if (typeParameters.length == 0 || jVar2.j().i()) {
                                    jVar = jVar2;
                                    i = size2;
                                    arrayList5 = arrayList4;
                                    mVar = null;
                                    arrayList6.set(i6, fVar.j(method3, mVar == null ? bVar2 : new e0.a(nVar, mVar), null));
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(jVar2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList8 = new ArrayList(typeParameters.length);
                                            i = size2;
                                            int i7 = 0;
                                            while (true) {
                                                if (i7 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableI1 = b.c.a.a0.d.i1(actualTypeArguments[i7]);
                                                    if (typeVariableI1 != null) {
                                                        String name = typeVariableI1.getName();
                                                        if (name == null) {
                                                            jVar = jVar2;
                                                            break;
                                                        }
                                                        arrayList5 = arrayList4;
                                                        b.g.a.c.j jVarF = jVar2.j().f(i7);
                                                        if (jVarF == null) {
                                                            jVar = jVar2;
                                                            break;
                                                        }
                                                        jVar = jVar2;
                                                        int length2 = typeParameters.length;
                                                        typeArr = actualTypeArguments;
                                                        int i8 = 0;
                                                        while (true) {
                                                            if (i8 >= length2) {
                                                                typeVariable = null;
                                                                break;
                                                            }
                                                            typeVariable = typeParameters[i8];
                                                            int i9 = length2;
                                                            if (name.equals(typeVariable.getName())) {
                                                                break;
                                                            }
                                                            i8++;
                                                            length2 = i9;
                                                        }
                                                        if (typeVariable == null) {
                                                            break;
                                                        }
                                                        Type[] bounds = typeVariable.getBounds();
                                                        int length3 = bounds.length;
                                                        typeVariableArr = typeParameters;
                                                        int i10 = 0;
                                                        while (true) {
                                                            if (i10 >= length3) {
                                                                z2 = true;
                                                                break;
                                                            }
                                                            int i11 = length3;
                                                            if (!b.c.a.a0.d.A1(bVar2, jVarF, bounds[i10])) {
                                                                z2 = false;
                                                                break;
                                                            }
                                                            i10++;
                                                            length3 = i11;
                                                        }
                                                        if (z2) {
                                                            int iIndexOf = arrayList7.indexOf(name);
                                                            if (iIndexOf != -1) {
                                                                b.g.a.c.j jVar3 = (b.g.a.c.j) arrayList8.get(iIndexOf);
                                                                if (!jVarF.equals(jVar3)) {
                                                                    boolean zB = jVar3.B(jVarF._class);
                                                                    boolean zB2 = jVarF.B(jVar3._class);
                                                                    if (!zB && !zB2) {
                                                                        break;
                                                                    }
                                                                    if ((zB ^ zB2) && zB2) {
                                                                        arrayList8.set(iIndexOf, jVarF);
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else {
                                                                arrayList7.add(name);
                                                                arrayList8.add(jVarF);
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        jVar = jVar2;
                                                        arrayList5 = arrayList4;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i7++;
                                                    arrayList4 = arrayList5;
                                                    jVar2 = jVar;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    jVar = jVar2;
                                                    arrayList5 = arrayList4;
                                                    if (arrayList7.isEmpty()) {
                                                        break;
                                                    }
                                                    mVar = (arrayList7.isEmpty() || arrayList8.isEmpty()) ? b.g.a.c.h0.m.l : new b.g.a.c.h0.m((String[]) arrayList7.toArray(b.g.a.c.h0.m.j), (b.g.a.c.j[]) arrayList8.toArray(b.g.a.c.h0.m.k), null);
                                                }
                                            }
                                            mVar = null;
                                            arrayList6.set(i6, fVar.j(method3, mVar == null ? bVar2 : new e0.a(nVar, mVar), null));
                                        }
                                        arrayList5 = arrayList4;
                                        mVar = null;
                                        arrayList6.set(i6, fVar.j(method3, mVar == null ? bVar2 : new e0.a(nVar, mVar), null));
                                    }
                                }
                            } else {
                                jVar = jVar2;
                                i = size2;
                                arrayList5 = arrayList4;
                            }
                            i6++;
                            size2 = i;
                            arrayList4 = arrayList5;
                            jVar2 = jVar;
                        }
                        listEmptyList = arrayList6;
                    }
                    if (fVar.e) {
                        e eVar = fVar.f;
                        if (eVar != null && fVar.c.Z(eVar)) {
                            fVar.f = null;
                        }
                        int size3 = arrayList3.size();
                        while (true) {
                            size3--;
                            if (size3 < 0) {
                                break;
                            }
                            if (fVar.c.Z((i) arrayList3.get(size3))) {
                                arrayList3.remove(size3);
                            }
                        }
                        int size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 < 0) {
                                break;
                            }
                            if (fVar.c.Z((i) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    aVar2 = new a(fVar.f, arrayList3, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i12 = 0; i12 < size; i12++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    d.a[] aVarArrL = b.g.a.c.i0.d.l(cls);
                    int length4 = aVarArrL.length;
                    y[] yVarArr2 = null;
                    int i13 = 0;
                    while (i13 < length4) {
                        d.a aVar4 = aVarArrL[i13];
                        if (aVar4.a() != 0) {
                            aVarArr = aVarArrL;
                            if (arrayList != null) {
                                if (yVarArr2 == null) {
                                    y[] yVarArr3 = new y[size];
                                    for (int i14 = 0; i14 < size; i14++) {
                                        yVarArr3[i14] = new y(((d.a) arrayList.get(i14)).a);
                                    }
                                    yVarArr2 = yVarArr3;
                                }
                                y yVar2 = new y(aVar4.a);
                                int i15 = 0;
                                while (true) {
                                    if (i15 >= size) {
                                        break;
                                    }
                                    if (yVar2.equals(yVarArr2[i15])) {
                                        arrayList2.set(i15, fVar.k((d.a) arrayList.get(i15), aVar4));
                                        break;
                                    }
                                    i15++;
                                }
                            }
                        } else if (aVar != null) {
                            aVarArr = aVarArrL;
                            fVar.f = new e(fVar.d, aVar.a, fVar.g(aVar, aVar4), u.a);
                            aVar = null;
                        } else {
                            aVarArr = aVarArrL;
                        }
                        i13++;
                        aVarArrL = aVarArr;
                    }
                }
                if (aVar != null) {
                    fVar.f = new e(fVar.d, aVar.a, fVar.g(aVar, null), u.a);
                }
                for (int i16 = 0; i16 < size; i16++) {
                    if (((e) arrayList2.get(i16)) == null) {
                        arrayList2.set(i16, fVar.k((d.a) arrayList.get(i16), null));
                    }
                }
                arrayList3 = arrayList2;
                arrayList4 = null;
                while (i < r6) {
                }
                if (arrayList4 != null) {
                }
                if (fVar.e) {
                }
                aVar2 = new a(fVar.f, arrayList3, listEmptyList);
            }
            this.u = aVar2;
        }
        return aVar2;
    }

    public Iterable<g> g() {
        List<g> listEmptyList = this.w;
        if (listEmptyList == null) {
            b.g.a.c.j jVar = this.k;
            if (jVar == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, h.a> mapF = new h(this.o, this.p, this.q, this.f684s).f(this, jVar, null);
                if (mapF == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapF.size());
                    for (h.a aVar : mapF.values()) {
                        arrayList.add(new g(aVar.a, aVar.f690b, aVar.c.b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.w = listEmptyList;
        }
        return listEmptyList;
    }

    public Iterable<j> h() {
        boolean z2;
        Class<?> clsA;
        l lVar = this.v;
        if (lVar == null) {
            b.g.a.c.j jVar = this.k;
            if (jVar == null) {
                lVar = new l();
            } else {
                b.g.a.c.b bVar = this.o;
                t.a aVar = this.q;
                b.g.a.c.h0.n nVar = this.p;
                List<b.g.a.c.j> list = this.n;
                Class<?> cls = this.r;
                k kVar = new k(bVar, aVar, this.f684s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                kVar.f(this, jVar._class, linkedHashMap, cls);
                Iterator<b.g.a.c.j> it = list.iterator();
                while (true) {
                    Class<?> clsA2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    b.g.a.c.j next = it.next();
                    t.a aVar2 = kVar.d;
                    if (aVar2 != null) {
                        clsA2 = aVar2.a(next._class);
                    }
                    kVar.f(new e0.a(nVar, next.j()), next._class, linkedHashMap, clsA2);
                }
                t.a aVar3 = kVar.d;
                if (aVar3 == null || (clsA = aVar3.a(Object.class)) == null) {
                    z2 = false;
                } else {
                    kVar.g(this, jVar._class, linkedHashMap, clsA);
                    z2 = true;
                }
                if (z2 && kVar.c != null && !linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        y yVar = (y) entry.getKey();
                        if ("hashCode".equals(yVar.f696b) && yVar.c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(yVar.f696b, new Class[0]);
                                if (declaredMethod != null) {
                                    k.a aVar4 = (k.a) entry.getValue();
                                    aVar4.c = kVar.d(aVar4.c, declaredMethod.getDeclaredAnnotations());
                                    aVar4.f691b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    lVar = new l();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        k.a aVar5 = (k.a) entry2.getValue();
                        Method method = aVar5.f691b;
                        j jVar2 = method == null ? null : new j(aVar5.a, method, aVar5.c.b(), null);
                        if (jVar2 != null) {
                            linkedHashMap2.put(entry2.getKey(), jVar2);
                        }
                    }
                    lVar = new l(linkedHashMap2);
                }
            }
            this.v = lVar;
        }
        return lVar;
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    public String toString() {
        return b.d.b.a.a.o(this.l, b.d.b.a.a.U("[AnnotedClass "), "]");
    }

    public c(Class<?> cls) {
        this.k = null;
        this.l = cls;
        this.n = Collections.emptyList();
        this.r = null;
        this.t = o.a;
        this.m = b.g.a.c.h0.m.l;
        this.o = null;
        this.q = null;
        this.p = null;
        this.f684s = false;
    }
}
