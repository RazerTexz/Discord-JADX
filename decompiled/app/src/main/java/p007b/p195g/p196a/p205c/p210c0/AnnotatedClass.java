package p007b.p195g.p196a.p205c.p210c0;

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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedFieldCollector;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethodCollector;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.Annotations;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.c0.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedClass.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedClass extends Annotated implements TypeResolutionContext {

    /* JADX INFO: renamed from: j */
    public static final a f4653j = new a(null, Collections.emptyList(), Collections.emptyList());

    /* JADX INFO: renamed from: k */
    public final JavaType f4654k;

    /* JADX INFO: renamed from: l */
    public final Class<?> f4655l;

    /* JADX INFO: renamed from: m */
    public final TypeBindings f4656m;

    /* JADX INFO: renamed from: n */
    public final List<JavaType> f4657n;

    /* JADX INFO: renamed from: o */
    public final AnnotationIntrospector f4658o;

    /* JADX INFO: renamed from: p */
    public final TypeFactory f4659p;

    /* JADX INFO: renamed from: q */
    public final ClassIntrospector.a f4660q;

    /* JADX INFO: renamed from: r */
    public final Class<?> f4661r;

    /* JADX INFO: renamed from: s */
    public final boolean f4662s;

    /* JADX INFO: renamed from: t */
    public final Annotations f4663t;

    /* JADX INFO: renamed from: u */
    public a f4664u;

    /* JADX INFO: renamed from: v */
    public AnnotatedMethodMap f4665v;

    /* JADX INFO: renamed from: w */
    public List<AnnotatedField> f4666w;

    /* JADX INFO: renamed from: x */
    public transient Boolean f4667x;

    /* JADX INFO: renamed from: b.g.a.c.c0.c$a */
    /* JADX INFO: compiled from: AnnotatedClass.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final AnnotatedConstructor f4668a;

        /* JADX INFO: renamed from: b */
        public final List<AnnotatedConstructor> f4669b;

        /* JADX INFO: renamed from: c */
        public final List<AnnotatedMethod> f4670c;

        public a(AnnotatedConstructor annotatedConstructor, List<AnnotatedConstructor> list, List<AnnotatedMethod> list2) {
            this.f4668a = annotatedConstructor;
            this.f4669b = list;
            this.f4670c = list2;
        }
    }

    public AnnotatedClass(JavaType javaType, Class<?> cls, List<JavaType> list, Class<?> cls2, Annotations annotations, TypeBindings typeBindings, AnnotationIntrospector annotationIntrospector, ClassIntrospector.a aVar, TypeFactory typeFactory, boolean z2) {
        this.f4654k = javaType;
        this.f4655l = cls;
        this.f4657n = list;
        this.f4661r = cls2;
        this.f4663t = annotations;
        this.f4656m = typeBindings;
        this.f4658o = annotationIntrospector;
        this.f4660q = aVar;
        this.f4659p = typeFactory;
        this.f4662s = z2;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext
    /* JADX INFO: renamed from: a */
    public JavaType mo1831a(Type type) {
        return this.f4659p.m2160b(null, type, this.f4656m);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* JADX INFO: renamed from: b */
    public <A extends Annotation> A mo1818b(Class<A> cls) {
        return (A) this.f4663t.mo1915a(cls);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* JADX INFO: renamed from: c */
    public String mo1819c() {
        return this.f4655l.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* JADX INFO: renamed from: d */
    public Class<?> mo1820d() {
        return this.f4655l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* JADX INFO: renamed from: e */
    public JavaType mo1821e() {
        return this.f4654k;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.m2183o(obj, AnnotatedClass.class) && ((AnnotatedClass) obj).f4655l == this.f4655l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0146  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a m1832f() {
        ClassUtil.a aVar;
        ArrayList arrayList;
        int size;
        ?? arrayList2;
        ?? r2;
        ArrayList arrayList3;
        List listEmptyList;
        JavaType javaType;
        int i;
        ArrayList arrayList4;
        TypeBindings typeBindings;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] methodArr;
        ClassUtil.a[] aVarArr;
        a aVar2 = this.f4664u;
        if (aVar2 == null) {
            JavaType javaType2 = this.f4654k;
            if (javaType2 == null) {
                aVar2 = f4653j;
            } else {
                AnnotationIntrospector annotationIntrospector = this.f4658o;
                TypeFactory typeFactory = this.f4659p;
                Class<?> cls = this.f4661r;
                AnnotatedCreatorCollector annotatedCreatorCollector = new AnnotatedCreatorCollector(annotationIntrospector, this, this.f4662s | (cls != null));
                if (javaType2.m2219w()) {
                    aVar = null;
                    arrayList = null;
                } else {
                    aVar = null;
                    arrayList = null;
                    for (ClassUtil.a aVar3 : ClassUtil.m2180l(javaType2._class)) {
                        if (!aVar3.f4947a.isSynthetic()) {
                            if (aVar3.m2195a() == 0) {
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
                    List listEmptyList2 = Collections.emptyList();
                    r2 = listEmptyList2;
                    if (aVar != null) {
                        arrayList2 = listEmptyList2;
                        size = 0;
                    }
                    arrayList3 = null;
                    for (Method method : ClassUtil.m2179k(javaType2._class)) {
                        if (AnnotatedCreatorCollector.m1892f(method)) {
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(method);
                        }
                    }
                    if (arrayList3 != null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        TypeResolutionContext.b bVar = new TypeResolutionContext.b(typeFactory);
                        int size2 = arrayList3.size();
                        ArrayList arrayList5 = new ArrayList(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            arrayList5.add(null);
                        }
                        if (cls != null) {
                            Method[] declaredMethods = cls.getDeclaredMethods();
                            int length = declaredMethods.length;
                            MemberKey[] memberKeyArr = null;
                            int i3 = 0;
                            while (i3 < length) {
                                Method method2 = declaredMethods[i3];
                                if (AnnotatedCreatorCollector.m1892f(method2)) {
                                    if (memberKeyArr == null) {
                                        memberKeyArr = new MemberKey[size2];
                                        int i4 = 0;
                                        while (i4 < size2) {
                                            memberKeyArr[i4] = new MemberKey((Method) arrayList3.get(i4));
                                            i4++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    MemberKey memberKey = new MemberKey(method2);
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size2) {
                                            break;
                                        }
                                        if (memberKey.equals(memberKeyArr[i5])) {
                                            arrayList5.set(i5, annotatedCreatorCollector.m1896j((Method) arrayList3.get(i5), bVar, method2));
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
                            if (((AnnotatedMethod) arrayList5.get(i6)) == null) {
                                Method method3 = (Method) arrayList3.get(i6);
                                TypeVariable<Method>[] typeParameters = method3.getTypeParameters();
                                if (typeParameters.length == 0 || javaType2.mo2136j().m2154i()) {
                                    javaType = javaType2;
                                    i = size2;
                                    arrayList4 = arrayList3;
                                    typeBindings = null;
                                    arrayList5.set(i6, annotatedCreatorCollector.m1896j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(javaType2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList6 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            i = size2;
                                            int i7 = 0;
                                            while (true) {
                                                if (i7 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableM529i1 = AnimatableValueParser.m529i1(actualTypeArguments[i7]);
                                                    if (typeVariableM529i1 != null) {
                                                        String name = typeVariableM529i1.getName();
                                                        if (name == null) {
                                                            javaType = javaType2;
                                                            break;
                                                        }
                                                        arrayList4 = arrayList3;
                                                        JavaType javaTypeM2151f = javaType2.mo2136j().m2151f(i7);
                                                        if (javaTypeM2151f == null) {
                                                            javaType = javaType2;
                                                            break;
                                                        }
                                                        javaType = javaType2;
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
                                                            if (!AnimatableValueParser.m417A1(bVar, javaTypeM2151f, bounds[i10])) {
                                                                z2 = false;
                                                                break;
                                                            }
                                                            i10++;
                                                            length3 = i11;
                                                        }
                                                        if (z2) {
                                                            int iIndexOf = arrayList6.indexOf(name);
                                                            if (iIndexOf != -1) {
                                                                JavaType javaType3 = (JavaType) arrayList7.get(iIndexOf);
                                                                if (!javaTypeM2151f.equals(javaType3)) {
                                                                    boolean zM2216B = javaType3.m2216B(javaTypeM2151f._class);
                                                                    boolean zM2216B2 = javaTypeM2151f.m2216B(javaType3._class);
                                                                    if (!zM2216B && !zM2216B2) {
                                                                        break;
                                                                    }
                                                                    if ((zM2216B ^ zM2216B2) && zM2216B2) {
                                                                        arrayList7.set(iIndexOf, javaTypeM2151f);
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else {
                                                                arrayList6.add(name);
                                                                arrayList7.add(javaTypeM2151f);
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        javaType = javaType2;
                                                        arrayList4 = arrayList3;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i7++;
                                                    arrayList3 = arrayList4;
                                                    javaType2 = javaType;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    javaType = javaType2;
                                                    arrayList4 = arrayList3;
                                                    if (arrayList6.isEmpty()) {
                                                        break;
                                                    }
                                                    typeBindings = (arrayList6.isEmpty() || arrayList7.isEmpty()) ? TypeBindings.f4908l : new TypeBindings((String[]) arrayList6.toArray(TypeBindings.f4906j), (JavaType[]) arrayList7.toArray(TypeBindings.f4907k), null);
                                                }
                                            }
                                            typeBindings = null;
                                            arrayList5.set(i6, annotatedCreatorCollector.m1896j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                        }
                                        arrayList4 = arrayList3;
                                        typeBindings = null;
                                        arrayList5.set(i6, annotatedCreatorCollector.m1896j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                    }
                                }
                            } else {
                                javaType = javaType2;
                                i = size2;
                                arrayList4 = arrayList3;
                            }
                            i6++;
                            size2 = i;
                            arrayList3 = arrayList4;
                            javaType2 = javaType;
                        }
                        listEmptyList = arrayList5;
                    }
                    if (annotatedCreatorCollector.f4706e) {
                        AnnotatedConstructor annotatedConstructor = annotatedCreatorCollector.f4707f;
                        if (annotatedConstructor != null && annotatedCreatorCollector.f4750c.mo1770Z(annotatedConstructor)) {
                            annotatedCreatorCollector.f4707f = null;
                        }
                        int size3 = r2.size();
                        while (true) {
                            size3--;
                            if (size3 < 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.f4750c.mo1770Z((AnnotatedMember) r2.get(size3))) {
                                r2.remove(size3);
                            }
                        }
                        int size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 < 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.f4750c.mo1770Z((AnnotatedMember) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    aVar2 = new a(annotatedCreatorCollector.f4707f, r2, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i12 = 0; i12 < size; i12++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    ClassUtil.a[] aVarArrM2180l = ClassUtil.m2180l(cls);
                    int length4 = aVarArrM2180l.length;
                    MemberKey[] memberKeyArr2 = null;
                    int i13 = 0;
                    while (i13 < length4) {
                        ClassUtil.a aVar4 = aVarArrM2180l[i13];
                        if (aVar4.m2195a() != 0) {
                            aVarArr = aVarArrM2180l;
                            if (arrayList != null) {
                                if (memberKeyArr2 == null) {
                                    MemberKey[] memberKeyArr3 = new MemberKey[size];
                                    for (int i14 = 0; i14 < size; i14++) {
                                        memberKeyArr3[i14] = new MemberKey(((ClassUtil.a) arrayList.get(i14)).f4947a);
                                    }
                                    memberKeyArr2 = memberKeyArr3;
                                }
                                MemberKey memberKey2 = new MemberKey(aVar4.f4947a);
                                int i15 = 0;
                                while (true) {
                                    if (i15 >= size) {
                                        break;
                                    }
                                    if (memberKey2.equals(memberKeyArr2[i15])) {
                                        arrayList2.set(i15, annotatedCreatorCollector.m1897k((ClassUtil.a) arrayList.get(i15), aVar4));
                                        break;
                                    }
                                    i15++;
                                }
                            }
                        } else if (aVar != null) {
                            aVarArr = aVarArrM2180l;
                            annotatedCreatorCollector.f4707f = new AnnotatedConstructor(annotatedCreatorCollector.f4705d, aVar.f4947a, annotatedCreatorCollector.m1893g(aVar, aVar4), CollectorBase.f4748a);
                            aVar = null;
                        } else {
                            aVarArr = aVarArrM2180l;
                        }
                        i13++;
                        aVarArrM2180l = aVarArr;
                    }
                }
                if (aVar != null) {
                    annotatedCreatorCollector.f4707f = new AnnotatedConstructor(annotatedCreatorCollector.f4705d, aVar.f4947a, annotatedCreatorCollector.m1893g(aVar, null), CollectorBase.f4748a);
                }
                for (int i16 = 0; i16 < size; i16++) {
                    if (((AnnotatedConstructor) arrayList2.get(i16)) == null) {
                        arrayList2.set(i16, annotatedCreatorCollector.m1897k((ClassUtil.a) arrayList.get(i16), null));
                    }
                }
                r2 = arrayList2;
                arrayList3 = null;
                while (i < r6) {
                }
                if (arrayList3 != null) {
                }
                if (annotatedCreatorCollector.f4706e) {
                }
                aVar2 = new a(annotatedCreatorCollector.f4707f, r2, listEmptyList);
            }
            this.f4664u = aVar2;
        }
        return aVar2;
    }

    /* JADX INFO: renamed from: g */
    public Iterable<AnnotatedField> m1833g() {
        List<AnnotatedField> listEmptyList = this.f4666w;
        if (listEmptyList == null) {
            JavaType javaType = this.f4654k;
            if (javaType == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, AnnotatedFieldCollector.a> mapM1900f = new AnnotatedFieldCollector(this.f4658o, this.f4659p, this.f4660q, this.f4662s).m1900f(this, javaType, null);
                if (mapM1900f == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapM1900f.size());
                    for (AnnotatedFieldCollector.a aVar : mapM1900f.values()) {
                        arrayList.add(new AnnotatedField(aVar.f4713a, aVar.f4714b, aVar.f4715c.mo1912b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.f4666w = listEmptyList;
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: h */
    public Iterable<AnnotatedMethod> m1834h() {
        boolean z2;
        Class<?> clsMo1885a;
        AnnotatedMethodMap annotatedMethodMap = this.f4665v;
        if (annotatedMethodMap == null) {
            JavaType javaType = this.f4654k;
            if (javaType == null) {
                annotatedMethodMap = new AnnotatedMethodMap();
            } else {
                AnnotationIntrospector annotationIntrospector = this.f4658o;
                ClassIntrospector.a aVar = this.f4660q;
                TypeFactory typeFactory = this.f4659p;
                List<JavaType> list = this.f4657n;
                Class<?> cls = this.f4661r;
                AnnotatedMethodCollector annotatedMethodCollector = new AnnotatedMethodCollector(annotationIntrospector, aVar, this.f4662s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                annotatedMethodCollector.m1908f(this, javaType._class, linkedHashMap, cls);
                Iterator<JavaType> it = list.iterator();
                while (true) {
                    Class<?> clsMo1885a2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    JavaType next = it.next();
                    ClassIntrospector.a aVar2 = annotatedMethodCollector.f4719d;
                    if (aVar2 != null) {
                        clsMo1885a2 = aVar2.mo1885a(next._class);
                    }
                    annotatedMethodCollector.m1908f(new TypeResolutionContext.a(typeFactory, next.mo2136j()), next._class, linkedHashMap, clsMo1885a2);
                }
                ClassIntrospector.a aVar3 = annotatedMethodCollector.f4719d;
                if (aVar3 == null || (clsMo1885a = aVar3.mo1885a(Object.class)) == null) {
                    z2 = false;
                } else {
                    annotatedMethodCollector.m1909g(this, javaType._class, linkedHashMap, clsMo1885a);
                    z2 = true;
                }
                if (z2 && annotatedMethodCollector.f4750c != null && !linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        MemberKey memberKey = (MemberKey) entry.getKey();
                        if ("hashCode".equals(memberKey.f4762b) && memberKey.f4763c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(memberKey.f4762b, new Class[0]);
                                if (declaredMethod != null) {
                                    AnnotatedMethodCollector.a aVar4 = (AnnotatedMethodCollector.a) entry.getValue();
                                    aVar4.f4723c = annotatedMethodCollector.m1926d(aVar4.f4723c, declaredMethod.getDeclaredAnnotations());
                                    aVar4.f4722b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    annotatedMethodMap = new AnnotatedMethodMap();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        AnnotatedMethodCollector.a aVar5 = (AnnotatedMethodCollector.a) entry2.getValue();
                        Method method = aVar5.f4722b;
                        AnnotatedMethod annotatedMethod = method == null ? null : new AnnotatedMethod(aVar5.f4721a, method, aVar5.f4723c.mo1912b(), null);
                        if (annotatedMethod != null) {
                            linkedHashMap2.put(entry2.getKey(), annotatedMethod);
                        }
                    }
                    annotatedMethodMap = new AnnotatedMethodMap(linkedHashMap2);
                }
            }
            this.f4665v = annotatedMethodMap;
        }
        return annotatedMethodMap;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this.f4655l.getName().hashCode();
    }

    public String toString() {
        return outline.m867o(this.f4655l, outline.m833U("[AnnotedClass "), "]");
    }

    public AnnotatedClass(Class<?> cls) {
        this.f4654k = null;
        this.f4655l = cls;
        this.f4657n = Collections.emptyList();
        this.f4661r = null;
        this.f4663t = AnnotationCollector.f4725a;
        this.f4656m = TypeBindings.f4908l;
        this.f4658o = null;
        this.f4660q = null;
        this.f4659p = null;
        this.f4662s = false;
    }
}
