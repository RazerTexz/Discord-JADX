package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JacksonInject;
import p007b.p195g.p196a.p197a.JsonCreator;
import p007b.p195g.p196a.p197a.JsonProperty;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.PropertyNamingStrategy;
import p007b.p195g.p196a.p205c.p210c0.POJOPropertyBuilder;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.c0.b0, reason: use source file name */
/* JADX INFO: compiled from: POJOPropertiesCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class POJOPropertiesCollector {

    /* JADX INFO: renamed from: a */
    public final MapperConfig<?> f4633a;

    /* JADX INFO: renamed from: b */
    public final AccessorNamingStrategy f4634b;

    /* JADX INFO: renamed from: c */
    public final boolean f4635c;

    /* JADX INFO: renamed from: d */
    public final JavaType f4636d;

    /* JADX INFO: renamed from: e */
    public final AnnotatedClass f4637e;

    /* JADX INFO: renamed from: f */
    public final VisibilityChecker<?> f4638f;

    /* JADX INFO: renamed from: g */
    public final AnnotationIntrospector f4639g;

    /* JADX INFO: renamed from: h */
    public final boolean f4640h;

    /* JADX INFO: renamed from: i */
    public boolean f4641i;

    /* JADX INFO: renamed from: j */
    public LinkedHashMap<String, POJOPropertyBuilder> f4642j;

    /* JADX INFO: renamed from: k */
    public LinkedList<POJOPropertyBuilder> f4643k;

    /* JADX INFO: renamed from: l */
    public Map<PropertyName, PropertyName> f4644l;

    /* JADX INFO: renamed from: m */
    public LinkedList<AnnotatedMember> f4645m;

    /* JADX INFO: renamed from: n */
    public LinkedList<AnnotatedMember> f4646n;

    /* JADX INFO: renamed from: o */
    public LinkedList<AnnotatedMethod> f4647o;

    /* JADX INFO: renamed from: p */
    public LinkedList<AnnotatedMember> f4648p;

    /* JADX INFO: renamed from: q */
    public LinkedList<AnnotatedMember> f4649q;

    /* JADX INFO: renamed from: r */
    public LinkedList<AnnotatedMember> f4650r;

    /* JADX INFO: renamed from: s */
    public HashSet<String> f4651s;

    /* JADX INFO: renamed from: t */
    public LinkedHashMap<Object, AnnotatedMember> f4652t;

    public POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z2, JavaType javaType, AnnotatedClass annotatedClass, AccessorNamingStrategy accessorNamingStrategy) {
        this.f4633a = mapperConfig;
        this.f4635c = z2;
        this.f4636d = javaType;
        this.f4637e = annotatedClass;
        if (mapperConfig.m2278p()) {
            this.f4640h = true;
            this.f4639g = mapperConfig.m2267e();
        } else {
            this.f4640h = false;
            this.f4639g = NopAnnotationIntrospector.f4764j;
        }
        this.f4638f = mapperConfig.mo2275m(javaType._class, annotatedClass);
        this.f4634b = accessorNamingStrategy;
        mapperConfig.m2279q(MapperFeature.USE_STD_BEAN_NAMING);
    }

    /* JADX INFO: renamed from: a */
    public void m1822a(Map<String, POJOPropertyBuilder> map, AnnotatedParameter annotatedParameter) {
        POJOPropertyBuilder pOJOPropertyBuilderM1827f;
        JsonCreator.a aVarMo1777d;
        String strMo1785i = this.f4639g.mo1785i(annotatedParameter);
        if (strMo1785i == null) {
            strMo1785i = "";
        }
        PropertyName propertyNameMo1790n = this.f4639g.mo1790n(annotatedParameter);
        boolean z2 = (propertyNameMo1790n == null || propertyNameMo1790n.m2230d()) ? false : true;
        if (!z2) {
            if (strMo1785i.isEmpty() || (aVarMo1777d = this.f4639g.mo1777d(this.f4633a, annotatedParameter._owner)) == null || aVarMo1777d == JsonCreator.a.DISABLED) {
                return;
            } else {
                propertyNameMo1790n = PropertyName.m2227a(strMo1785i);
            }
        }
        PropertyName propertyName = propertyNameMo1790n;
        String strM1823b = m1823b(strMo1785i);
        if (z2 && strM1823b.isEmpty()) {
            String str = propertyName._simpleName;
            pOJOPropertyBuilderM1827f = map.get(str);
            if (pOJOPropertyBuilderM1827f == null) {
                pOJOPropertyBuilderM1827f = new POJOPropertyBuilder(this.f4633a, this.f4639g, this.f4635c, propertyName);
                map.put(str, pOJOPropertyBuilderM1827f);
            }
        } else {
            pOJOPropertyBuilderM1827f = m1827f(map, strM1823b);
        }
        pOJOPropertyBuilderM1827f.f4678r = new POJOPropertyBuilder.d<>(annotatedParameter, pOJOPropertyBuilderM1827f.f4678r, propertyName, z2, true, false);
        this.f4643k.add(pOJOPropertyBuilderM1827f);
    }

    /* JADX INFO: renamed from: b */
    public final String m1823b(String str) {
        PropertyName propertyName;
        Map<PropertyName, PropertyName> map = this.f4644l;
        return (map == null || (propertyName = map.get(m1826e(str))) == null) ? str : propertyName._simpleName;
    }

    /* JADX INFO: renamed from: c */
    public void m1824c(String str) {
        if (this.f4635c || str == null) {
            return;
        }
        if (this.f4651s == null) {
            this.f4651s = new HashSet<>();
        }
        this.f4651s.add(str);
    }

    /* JADX INFO: renamed from: d */
    public void m1825d(JacksonInject.a aVar, AnnotatedMember annotatedMember) {
        if (aVar == null) {
            return;
        }
        Object obj = aVar._id;
        if (this.f4652t == null) {
            this.f4652t = new LinkedHashMap<>();
        }
        AnnotatedMember annotatedMemberPut = this.f4652t.put(obj, annotatedMember);
        if (annotatedMemberPut == null || annotatedMemberPut.getClass() != annotatedMember.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    /* JADX INFO: renamed from: e */
    public final PropertyName m1826e(String str) {
        return PropertyName.m2228b(str, null);
    }

    /* JADX INFO: renamed from: f */
    public POJOPropertyBuilder m1827f(Map<String, POJOPropertyBuilder> map, String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = map.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        POJOPropertyBuilder pOJOPropertyBuilder2 = new POJOPropertyBuilder(this.f4633a, this.f4639g, this.f4635c, PropertyName.m2227a(str));
        map.put(str, pOJOPropertyBuilder2);
        return pOJOPropertyBuilder2;
    }

    /* JADX INFO: renamed from: g */
    public boolean m1828g(POJOPropertyBuilder pOJOPropertyBuilder, List<POJOPropertyBuilder> list) {
        if (list != null) {
            String str = pOJOPropertyBuilder.f4676p._simpleName;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f4676p._simpleName.equals(str)) {
                    list.set(i, pOJOPropertyBuilder);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x087e  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1829h() {
        PropertyNamingStrategy propertyNamingStrategy;
        boolean zBooleanValue;
        boolean z2;
        Collection<POJOPropertyBuilder> collectionValues;
        String strMo2233c;
        HashSet<String> hashSet;
        JsonProperty.a aVarMo1796t;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar2;
        POJOPropertyBuilder.d<AnnotatedField> dVar3;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar4;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar5;
        POJOPropertyBuilder.d<AnnotatedField> dVar6;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar7;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar8;
        boolean z3;
        String strMo1785i;
        PropertyName propertyName;
        boolean z4;
        boolean z5;
        boolean zM1595f;
        String strMo1785i2;
        PropertyName propertyName2;
        boolean z6;
        boolean zM1595f2;
        PropertyName propertyNameM1826e;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedHashMap<String, POJOPropertyBuilder> linkedHashMap = new LinkedHashMap<>();
        AnnotationIntrospector annotationIntrospector = this.f4639g;
        boolean z10 = (this.f4635c || this.f4633a.m2279q(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zM2279q = this.f4633a.m2279q(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this.f4637e.m1833g()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(annotationIntrospector.mo1766V(this.f4633a, annotatedField))) {
                if (this.f4649q == null) {
                    this.f4649q = new LinkedList<>();
                }
                this.f4649q.add(annotatedField);
            }
            if (bool.equals(annotationIntrospector.mo1767W(annotatedField))) {
                if (this.f4650r == null) {
                    this.f4650r = new LinkedList<>();
                }
                this.f4650r.add(annotatedField);
            } else {
                boolean zEquals = bool.equals(annotationIntrospector.mo1763S(annotatedField));
                boolean zEquals2 = bool.equals(annotationIntrospector.mo1765U(annotatedField));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.f4646n == null) {
                            this.f4646n = new LinkedList<>();
                        }
                        this.f4646n.add(annotatedField);
                    }
                    if (zEquals2) {
                        if (this.f4648p == null) {
                            this.f4648p = new LinkedList<>();
                        }
                        this.f4648p.add(annotatedField);
                    }
                } else {
                    String strMo1785i3 = annotationIntrospector.mo1785i(annotatedField);
                    if (strMo1785i3 == null) {
                        strMo1785i3 = annotatedField.mo1819c();
                    }
                    Objects.requireNonNull((DefaultAccessorNamingStrategy) this.f4634b);
                    if (strMo1785i3 != null) {
                        PropertyName propertyNameM1826e2 = m1826e(strMo1785i3);
                        PropertyName propertyNameMo1749E = annotationIntrospector.mo1749E(this.f4633a, annotatedField, propertyNameM1826e2);
                        if (propertyNameMo1749E != null && !propertyNameMo1749E.equals(propertyNameM1826e2)) {
                            if (this.f4644l == null) {
                                this.f4644l = new HashMap();
                            }
                            this.f4644l.put(propertyNameMo1749E, propertyNameM1826e2);
                        }
                        PropertyName propertyNameMo1791o = this.f4635c ? annotationIntrospector.mo1791o(annotatedField) : annotationIntrospector.mo1790n(annotatedField);
                        boolean z11 = propertyNameMo1791o != null;
                        if (z11 && propertyNameMo1791o.m2230d()) {
                            propertyNameM1826e = m1826e(strMo1785i3);
                            z7 = false;
                        } else {
                            propertyNameM1826e = propertyNameMo1791o;
                            z7 = z11;
                        }
                        boolean zM1595f3 = propertyNameM1826e != null;
                        if (!zM1595f3) {
                            VisibilityChecker.a aVar = (VisibilityChecker.a) this.f4638f;
                            Objects.requireNonNull(aVar);
                            zM1595f3 = aVar._fieldMinLevel.m1595f(annotatedField.f4708l);
                        }
                        boolean zMo1770Z = annotationIntrospector.mo1770Z(annotatedField);
                        if (!Modifier.isTransient(annotatedField.f4708l.getModifiers()) || z11) {
                            z8 = zMo1770Z;
                            z9 = zM1595f3;
                        } else if (zM2279q) {
                            z9 = false;
                            z8 = true;
                        } else {
                            z8 = zMo1770Z;
                            z9 = false;
                        }
                        if (!z10 || propertyNameM1826e != null || z8 || !Modifier.isFinal(annotatedField.f4708l.getModifiers())) {
                            POJOPropertyBuilder pOJOPropertyBuilderM1827f = m1827f(linkedHashMap, strMo1785i3);
                            pOJOPropertyBuilderM1827f.f4677q = new POJOPropertyBuilder.d<>(annotatedField, pOJOPropertyBuilderM1827f.f4677q, propertyNameM1826e, z7, z9, z8);
                        }
                    }
                }
            }
        }
        for (AnnotatedMethod annotatedMethod : (AnnotatedMethodMap) this.f4637e.m1834h()) {
            int iM1905o = annotatedMethod.m1905o();
            if (iM1905o == 0) {
                AnnotationIntrospector annotationIntrospector2 = this.f4639g;
                Class<?> returnType = annotatedMethod.f4718l.getReturnType();
                if (returnType != Void.TYPE && (returnType != Void.class || this.f4633a.m2279q(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES))) {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(annotationIntrospector2.mo1763S(annotatedMethod))) {
                        if (this.f4645m == null) {
                            this.f4645m = new LinkedList<>();
                        }
                        this.f4645m.add(annotatedMethod);
                    } else if (bool2.equals(annotationIntrospector2.mo1766V(this.f4633a, annotatedMethod))) {
                        if (this.f4649q == null) {
                            this.f4649q = new LinkedList<>();
                        }
                        this.f4649q.add(annotatedMethod);
                    } else if (bool2.equals(annotationIntrospector2.mo1767W(annotatedMethod))) {
                        if (this.f4650r == null) {
                            this.f4650r = new LinkedList<>();
                        }
                        this.f4650r.add(annotatedMethod);
                    } else {
                        PropertyName propertyNameMo1791o2 = annotationIntrospector2.mo1791o(annotatedMethod);
                        boolean z12 = propertyNameMo1791o2 != null;
                        if (z12) {
                            strMo1785i = annotationIntrospector2.mo1785i(annotatedMethod);
                            if (strMo1785i == null && (strMo1785i = this.f4634b.mo1817c(annotatedMethod, annotatedMethod.mo1819c())) == null) {
                                strMo1785i = this.f4634b.mo1815a(annotatedMethod, annotatedMethod.mo1819c());
                            }
                            if (strMo1785i == null) {
                                strMo1785i = annotatedMethod.mo1819c();
                            }
                            if (propertyNameMo1791o2.m2230d()) {
                                propertyNameMo1791o2 = m1826e(strMo1785i);
                                z12 = false;
                            }
                            propertyName = propertyNameMo1791o2;
                            z4 = z12;
                            z5 = true;
                        } else {
                            strMo1785i = annotationIntrospector2.mo1785i(annotatedMethod);
                            if (strMo1785i == null) {
                                strMo1785i = this.f4634b.mo1817c(annotatedMethod, annotatedMethod.mo1819c());
                            }
                            if (strMo1785i == null) {
                                strMo1785i = this.f4634b.mo1815a(annotatedMethod, annotatedMethod.mo1819c());
                                if (strMo1785i != null) {
                                    VisibilityChecker.a aVar2 = (VisibilityChecker.a) this.f4638f;
                                    Objects.requireNonNull(aVar2);
                                    zM1595f = aVar2._isGetterMinLevel.m1595f(annotatedMethod.f4718l);
                                }
                            } else {
                                VisibilityChecker.a aVar3 = (VisibilityChecker.a) this.f4638f;
                                Objects.requireNonNull(aVar3);
                                zM1595f = aVar3._getterMinLevel.m1595f(annotatedMethod.f4718l);
                            }
                            z4 = z12;
                            z5 = zM1595f;
                            propertyName = propertyNameMo1791o2;
                        }
                        String strM1823b = m1823b(strMo1785i);
                        boolean zMo1770Z2 = annotationIntrospector2.mo1770Z(annotatedMethod);
                        POJOPropertyBuilder pOJOPropertyBuilderM1827f2 = m1827f(linkedHashMap, strM1823b);
                        pOJOPropertyBuilderM1827f2.f4679s = new POJOPropertyBuilder.d<>(annotatedMethod, pOJOPropertyBuilderM1827f2.f4679s, propertyName, z4, z5, zMo1770Z2);
                    }
                }
            } else if (iM1905o == 1) {
                AnnotationIntrospector annotationIntrospector3 = this.f4639g;
                PropertyName propertyNameMo1790n = annotationIntrospector3.mo1790n(annotatedMethod);
                boolean z13 = propertyNameMo1790n != null;
                if (z13) {
                    strMo1785i2 = annotationIntrospector3.mo1785i(annotatedMethod);
                    if (strMo1785i2 == null) {
                        strMo1785i2 = this.f4634b.mo1816b(annotatedMethod, annotatedMethod.mo1819c());
                    }
                    if (strMo1785i2 == null) {
                        strMo1785i2 = annotatedMethod.mo1819c();
                    }
                    if (propertyNameMo1790n.m2230d()) {
                        propertyNameMo1790n = m1826e(strMo1785i2);
                        z13 = false;
                    }
                    propertyName2 = propertyNameMo1790n;
                    z6 = z13;
                    zM1595f2 = true;
                } else {
                    strMo1785i2 = annotationIntrospector3.mo1785i(annotatedMethod);
                    if (strMo1785i2 == null) {
                        strMo1785i2 = this.f4634b.mo1816b(annotatedMethod, annotatedMethod.mo1819c());
                    }
                    if (strMo1785i2 != null) {
                        VisibilityChecker.a aVar4 = (VisibilityChecker.a) this.f4638f;
                        Objects.requireNonNull(aVar4);
                        z6 = z13;
                        zM1595f2 = aVar4._setterMinLevel.m1595f(annotatedMethod.f4718l);
                        propertyName2 = propertyNameMo1790n;
                    }
                }
                String strM1823b2 = m1823b(strMo1785i2);
                boolean zMo1770Z3 = annotationIntrospector3.mo1770Z(annotatedMethod);
                POJOPropertyBuilder pOJOPropertyBuilderM1827f3 = m1827f(linkedHashMap, strM1823b2);
                pOJOPropertyBuilderM1827f3.f4680t = new POJOPropertyBuilder.d<>(annotatedMethod, pOJOPropertyBuilderM1827f3.f4680t, propertyName2, z6, zM1595f2, zMo1770Z3);
            } else if (iM1905o == 2 && Boolean.TRUE.equals(this.f4639g.mo1765U(annotatedMethod))) {
                if (this.f4647o == null) {
                    this.f4647o = new LinkedList<>();
                }
                this.f4647o.add(annotatedMethod);
            }
        }
        AnnotatedClass annotatedClass = this.f4637e;
        Boolean boolValueOf = annotatedClass.f4667x;
        if (boolValueOf == null) {
            Class<?> cls = annotatedClass.f4655l;
            Annotation[] annotationArr = ClassUtil.f4944a;
            if (Modifier.isStatic(cls.getModifiers())) {
                z3 = false;
                boolValueOf = Boolean.valueOf(z3);
                annotatedClass.f4667x = boolValueOf;
            } else {
                if ((ClassUtil.m2188t(cls) ? null : cls.getEnclosingClass()) != null) {
                    z3 = true;
                }
                boolValueOf = Boolean.valueOf(z3);
                annotatedClass.f4667x = boolValueOf;
            }
        }
        if (!boolValueOf.booleanValue() && this.f4640h) {
            for (AnnotatedConstructor annotatedConstructor : this.f4637e.m1832f().f4669b) {
                if (this.f4643k == null) {
                    this.f4643k = new LinkedList<>();
                }
                int length = annotatedConstructor._constructor.getParameterTypes().length;
                for (int i = 0; i < length; i++) {
                    m1822a(linkedHashMap, annotatedConstructor.m1910m(i));
                }
            }
            for (AnnotatedMethod annotatedMethod2 : this.f4637e.m1832f().f4670c) {
                if (this.f4643k == null) {
                    this.f4643k = new LinkedList<>();
                }
                int iM1905o2 = annotatedMethod2.m1905o();
                for (int i2 = 0; i2 < iM1905o2; i2++) {
                    m1822a(linkedHashMap, annotatedMethod2.m1910m(i2));
                }
            }
        }
        Iterator<POJOPropertyBuilder> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder next = it.next();
            if (!(next.m1868z(next.f4677q) || next.m1868z(next.f4679s) || next.m1868z(next.f4680t) || next.m1868z(next.f4678r))) {
                it.remove();
            } else if (next.m1867y(next.f4677q) || next.m1867y(next.f4679s) || next.m1867y(next.f4680t) || next.m1867y(next.f4678r)) {
                if (next.mo1863u()) {
                    next.f4677q = next.m1842G(next.f4677q);
                    next.f4679s = next.m1842G(next.f4679s);
                    next.f4680t = next.m1842G(next.f4680t);
                    next.f4678r = next.m1842G(next.f4678r);
                    if (!next.mo1849f()) {
                        m1824c(next.mo1858p());
                    }
                } else {
                    it.remove();
                    m1824c(next.mo1858p());
                }
            }
        }
        boolean zM2279q2 = this.f4633a.m2279q(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder pOJOPropertyBuilder : linkedHashMap.values()) {
            POJOPropertiesCollector pOJOPropertiesCollector = this.f4635c ? null : this;
            JsonProperty.a aVar5 = JsonProperty.a.AUTO;
            AnnotationIntrospector annotationIntrospector4 = pOJOPropertyBuilder.f4674n;
            if (annotationIntrospector4 == null || (!pOJOPropertyBuilder.f4672l ? ((dVar = pOJOPropertyBuilder.f4678r) == null || (aVarMo1796t = annotationIntrospector4.mo1796t(dVar.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar2 = pOJOPropertyBuilder.f4680t) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar2.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar3 = pOJOPropertyBuilder.f4677q) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar3.f4686a)) == null || aVarMo1796t == aVar5) && ((dVar4 = pOJOPropertyBuilder.f4679s) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar4.f4686a)) == null || aVarMo1796t == aVar5))) : ((dVar5 = pOJOPropertyBuilder.f4679s) == null || (aVarMo1796t = annotationIntrospector4.mo1796t(dVar5.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar6 = pOJOPropertyBuilder.f4677q) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar6.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar7 = pOJOPropertyBuilder.f4678r) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar7.f4686a)) == null || aVarMo1796t == aVar5) && ((dVar8 = pOJOPropertyBuilder.f4680t) == null || (aVarMo1796t = pOJOPropertyBuilder.f4674n.mo1796t(dVar8.f4686a)) == null || aVarMo1796t == aVar5))))) {
                aVarMo1796t = null;
            }
            if (aVarMo1796t != null) {
                aVar5 = aVarMo1796t;
            }
            int iOrdinal = aVar5.ordinal();
            if (iOrdinal == 1) {
                if (pOJOPropertiesCollector != null) {
                    pOJOPropertiesCollector.m1824c(pOJOPropertyBuilder.mo1858p());
                    Iterator<PropertyName> it2 = pOJOPropertyBuilder.m1847L().iterator();
                    while (it2.hasNext()) {
                        pOJOPropertiesCollector.m1824c(it2.next()._simpleName);
                    }
                }
                pOJOPropertyBuilder.f4680t = null;
                pOJOPropertyBuilder.f4678r = null;
                if (!pOJOPropertyBuilder.f4672l) {
                    pOJOPropertyBuilder.f4677q = null;
                }
            } else if (iOrdinal == 2) {
                pOJOPropertyBuilder.f4679s = null;
                if (pOJOPropertyBuilder.f4672l) {
                    pOJOPropertyBuilder.f4677q = null;
                }
            } else if (iOrdinal != 3) {
                pOJOPropertyBuilder.f4679s = pOJOPropertyBuilder.m1843H(pOJOPropertyBuilder.f4679s);
                pOJOPropertyBuilder.f4678r = pOJOPropertyBuilder.m1843H(pOJOPropertyBuilder.f4678r);
                if (!zM2279q2 || pOJOPropertyBuilder.f4679s == null) {
                    pOJOPropertyBuilder.f4677q = pOJOPropertyBuilder.m1843H(pOJOPropertyBuilder.f4677q);
                    pOJOPropertyBuilder.f4680t = pOJOPropertyBuilder.m1843H(pOJOPropertyBuilder.f4680t);
                }
            }
        }
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it3 = linkedHashMap.entrySet().iterator();
        LinkedList<POJOPropertyBuilder> linkedList = null;
        while (it3.hasNext()) {
            POJOPropertyBuilder value = it3.next().getValue();
            Set<PropertyName> setM1847L = value.m1847L();
            if (!setM1847L.isEmpty()) {
                it3.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setM1847L.size() == 1) {
                    linkedList.add(new POJOPropertyBuilder(value, setM1847L.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    value.m1837B(setM1847L, map, value.f4677q);
                    value.m1837B(setM1847L, map, value.f4679s);
                    value.m1837B(setM1847L, map, value.f4680t);
                    value.m1837B(setM1847L, map, value.f4678r);
                    linkedList.addAll(map.values());
                }
            }
        }
        if (linkedList != null) {
            for (POJOPropertyBuilder pOJOPropertyBuilder2 : linkedList) {
                String strMo1858p = pOJOPropertyBuilder2.mo1858p();
                POJOPropertyBuilder pOJOPropertyBuilder3 = linkedHashMap.get(strMo1858p);
                if (pOJOPropertyBuilder3 == null) {
                    linkedHashMap.put(strMo1858p, pOJOPropertyBuilder2);
                } else {
                    pOJOPropertyBuilder3.m1846K(pOJOPropertyBuilder2);
                }
                if (m1828g(pOJOPropertyBuilder2, this.f4643k) && (hashSet = this.f4651s) != null) {
                    hashSet.remove(strMo1858p);
                }
            }
        }
        for (AnnotatedField annotatedField2 : this.f4637e.m1833g()) {
            m1825d(this.f4639g.mo1786j(annotatedField2), annotatedField2);
        }
        for (AnnotatedMethod annotatedMethod3 : (AnnotatedMethodMap) this.f4637e.m1834h()) {
            if (annotatedMethod3.m1905o() == 1) {
                m1825d(this.f4639g.mo1786j(annotatedMethod3), annotatedMethod3);
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder4 : linkedHashMap.values()) {
            if (this.f4635c) {
                POJOPropertyBuilder.d<AnnotatedMethod> dVar9 = pOJOPropertyBuilder4.f4679s;
                if (dVar9 != null) {
                    pOJOPropertyBuilder4.f4679s = pOJOPropertyBuilder4.m1836A(pOJOPropertyBuilder4.f4679s, pOJOPropertyBuilder4.m1841F(0, dVar9, pOJOPropertyBuilder4.f4677q, pOJOPropertyBuilder4.f4678r, pOJOPropertyBuilder4.f4680t));
                } else {
                    POJOPropertyBuilder.d<AnnotatedField> dVar10 = pOJOPropertyBuilder4.f4677q;
                    if (dVar10 != null) {
                        pOJOPropertyBuilder4.f4677q = pOJOPropertyBuilder4.m1836A(pOJOPropertyBuilder4.f4677q, pOJOPropertyBuilder4.m1841F(0, dVar10, pOJOPropertyBuilder4.f4678r, pOJOPropertyBuilder4.f4680t));
                    }
                }
            } else {
                POJOPropertyBuilder.d<AnnotatedParameter> dVar11 = pOJOPropertyBuilder4.f4678r;
                if (dVar11 != null) {
                    pOJOPropertyBuilder4.f4678r = pOJOPropertyBuilder4.m1836A(pOJOPropertyBuilder4.f4678r, pOJOPropertyBuilder4.m1841F(0, dVar11, pOJOPropertyBuilder4.f4680t, pOJOPropertyBuilder4.f4677q, pOJOPropertyBuilder4.f4679s));
                } else {
                    POJOPropertyBuilder.d<AnnotatedMethod> dVar12 = pOJOPropertyBuilder4.f4680t;
                    if (dVar12 != null) {
                        pOJOPropertyBuilder4.f4680t = pOJOPropertyBuilder4.m1836A(pOJOPropertyBuilder4.f4680t, pOJOPropertyBuilder4.m1841F(0, dVar12, pOJOPropertyBuilder4.f4677q, pOJOPropertyBuilder4.f4679s));
                    } else {
                        POJOPropertyBuilder.d<AnnotatedField> dVar13 = pOJOPropertyBuilder4.f4677q;
                        if (dVar13 != null) {
                            pOJOPropertyBuilder4.f4677q = pOJOPropertyBuilder4.m1836A(pOJOPropertyBuilder4.f4677q, pOJOPropertyBuilder4.m1841F(0, dVar13, pOJOPropertyBuilder4.f4679s));
                        }
                    }
                }
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder5 : linkedHashMap.values()) {
            pOJOPropertyBuilder5.f4677q = pOJOPropertyBuilder5.m1845J(pOJOPropertyBuilder5.f4677q);
            pOJOPropertyBuilder5.f4679s = pOJOPropertyBuilder5.m1845J(pOJOPropertyBuilder5.f4679s);
            pOJOPropertyBuilder5.f4680t = pOJOPropertyBuilder5.m1845J(pOJOPropertyBuilder5.f4680t);
            pOJOPropertyBuilder5.f4678r = pOJOPropertyBuilder5.m1845J(pOJOPropertyBuilder5.f4678r);
        }
        Object objMo1792p = this.f4639g.mo1792p(this.f4637e);
        if (objMo1792p == null) {
            propertyNamingStrategy = this.f4633a._base._propertyNamingStrategy;
        } else if (objMo1792p instanceof PropertyNamingStrategy) {
            propertyNamingStrategy = (PropertyNamingStrategy) objMo1792p;
        } else {
            if (!(objMo1792p instanceof Class)) {
                StringBuilder sbM833U = outline.m833U("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
                sbM833U.append(objMo1792p.getClass().getName());
                sbM833U.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
                throw new IllegalStateException(sbM833U.toString());
            }
            Class cls2 = (Class) objMo1792p;
            if (cls2 == PropertyNamingStrategy.class) {
                propertyNamingStrategy = null;
            } else {
                if (!PropertyNamingStrategy.class.isAssignableFrom(cls2)) {
                    throw new IllegalStateException(outline.m867o(cls2, outline.m833U("AnnotationIntrospector returned Class "), "; expected Class<PropertyNamingStrategy>"));
                }
                Objects.requireNonNull(this.f4633a._base);
                propertyNamingStrategy = (PropertyNamingStrategy) ClassUtil.m2175g(cls2, this.f4633a.m2265b());
            }
        }
        if (propertyNamingStrategy != null) {
            POJOPropertyBuilder[] pOJOPropertyBuilderArr = (POJOPropertyBuilder[]) linkedHashMap.values().toArray(new POJOPropertyBuilder[linkedHashMap.size()]);
            linkedHashMap.clear();
            for (POJOPropertyBuilder pOJOPropertyBuilder6 : pOJOPropertyBuilderArr) {
                PropertyName propertyName3 = pOJOPropertyBuilder6.f4675o;
                if (!(pOJOPropertyBuilder6.m1865w(pOJOPropertyBuilder6.f4677q) || pOJOPropertyBuilder6.m1865w(pOJOPropertyBuilder6.f4679s) || pOJOPropertyBuilder6.m1865w(pOJOPropertyBuilder6.f4680t) || pOJOPropertyBuilder6.m1865w(pOJOPropertyBuilder6.f4678r)) || this.f4633a.m2279q(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                    if (this.f4635c) {
                        strMo2233c = pOJOPropertyBuilder6.f4679s != null ? propertyNamingStrategy.mo2233c(this.f4633a, pOJOPropertyBuilder6.mo1856n(), propertyName3._simpleName) : pOJOPropertyBuilder6.f4677q != null ? propertyNamingStrategy.mo2232b(this.f4633a, pOJOPropertyBuilder6.mo1854l(), propertyName3._simpleName) : null;
                    } else if (pOJOPropertyBuilder6.f4680t != null) {
                        strMo2233c = propertyNamingStrategy.mo2234d(this.f4633a, pOJOPropertyBuilder6.mo1861s(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.f4678r != null) {
                        strMo2233c = propertyNamingStrategy.mo2231a(this.f4633a, pOJOPropertyBuilder6.mo1853k(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.f4677q != null) {
                        strMo2233c = propertyNamingStrategy.mo2232b(this.f4633a, pOJOPropertyBuilder6.mo1854l(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.f4679s != null) {
                        strMo2233c = propertyNamingStrategy.mo2233c(this.f4633a, pOJOPropertyBuilder6.mo1856n(), propertyName3._simpleName);
                    }
                }
                if (strMo2233c == null || propertyName3._simpleName.equals(strMo2233c)) {
                    strMo2233c = propertyName3._simpleName;
                } else {
                    PropertyName propertyName4 = pOJOPropertyBuilder6.f4675o;
                    if (!strMo2233c.equals(propertyName4._simpleName)) {
                        propertyName4 = new PropertyName(strMo2233c, propertyName4._namespace);
                    }
                    if (propertyName4 != pOJOPropertyBuilder6.f4675o) {
                        pOJOPropertyBuilder6 = new POJOPropertyBuilder(pOJOPropertyBuilder6, propertyName4);
                    }
                }
                POJOPropertyBuilder pOJOPropertyBuilder7 = linkedHashMap.get(strMo2233c);
                if (pOJOPropertyBuilder7 == null) {
                    linkedHashMap.put(strMo2233c, pOJOPropertyBuilder6);
                } else {
                    pOJOPropertyBuilder7.m1846K(pOJOPropertyBuilder6);
                }
                m1828g(pOJOPropertyBuilder6, this.f4643k);
            }
        }
        if (this.f4633a.m2279q(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator<Map.Entry<String, POJOPropertyBuilder>> it4 = linkedHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                if (it4.next().getValue().mo1859q() != null) {
                    Objects.requireNonNull(this.f4639g);
                }
            }
        }
        AnnotationIntrospector annotationIntrospector5 = this.f4639g;
        Boolean boolMo1754J = annotationIntrospector5.mo1754J(this.f4637e);
        if (boolMo1754J == null) {
            MapperConfig<?> mapperConfig = this.f4633a;
            Objects.requireNonNull(mapperConfig);
            zBooleanValue = mapperConfig.m2279q(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            zBooleanValue = boolMo1754J.booleanValue();
        }
        Iterator<POJOPropertyBuilder> it5 = linkedHashMap.values().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (it5.next().mo1857o()._index != null) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        String[] strArrMo1753I = annotationIntrospector5.mo1753I(this.f4637e);
        if (zBooleanValue || z2 || this.f4643k != null || strArrMo1753I != null) {
            int size = linkedHashMap.size();
            Map<? extends Object, ? extends Object> treeMap = zBooleanValue ? new TreeMap<>() : new LinkedHashMap<>(size + size);
            for (POJOPropertyBuilder pOJOPropertyBuilder8 : linkedHashMap.values()) {
                treeMap.put(pOJOPropertyBuilder8.mo1858p(), pOJOPropertyBuilder8);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
            if (strArrMo1753I != null) {
                for (String strMo1858p2 : strArrMo1753I) {
                    POJOPropertyBuilder pOJOPropertyBuilder9 = (POJOPropertyBuilder) treeMap.remove(strMo1858p2);
                    if (pOJOPropertyBuilder9 == null) {
                        Iterator<POJOPropertyBuilder> it6 = linkedHashMap.values().iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            POJOPropertyBuilder next2 = it6.next();
                            if (strMo1858p2.equals(next2.f4676p._simpleName)) {
                                strMo1858p2 = next2.mo1858p();
                                pOJOPropertyBuilder9 = next2;
                                break;
                            }
                        }
                    }
                    if (pOJOPropertyBuilder9 != null) {
                        linkedHashMap2.put(strMo1858p2, pOJOPropertyBuilder9);
                    }
                }
            }
            if (z2) {
                TreeMap treeMap2 = new TreeMap();
                Iterator<Map.Entry<? extends Object, ? extends Object>> it7 = treeMap.entrySet().iterator();
                while (it7.hasNext()) {
                    POJOPropertyBuilder pOJOPropertyBuilder10 = (POJOPropertyBuilder) it7.next().getValue();
                    Integer num = pOJOPropertyBuilder10.mo1857o()._index;
                    if (num != null) {
                        treeMap2.put(num, pOJOPropertyBuilder10);
                        it7.remove();
                    }
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder11 : treeMap2.values()) {
                    linkedHashMap2.put(pOJOPropertyBuilder11.mo1858p(), pOJOPropertyBuilder11);
                }
            }
            if (this.f4643k != null && (!zBooleanValue || this.f4633a.m2279q(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zBooleanValue) {
                    TreeMap treeMap3 = new TreeMap();
                    for (POJOPropertyBuilder pOJOPropertyBuilder12 : this.f4643k) {
                        treeMap3.put(pOJOPropertyBuilder12.mo1858p(), pOJOPropertyBuilder12);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.f4643k;
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder13 : collectionValues) {
                    String strMo1858p3 = pOJOPropertyBuilder13.mo1858p();
                    if (treeMap.containsKey(strMo1858p3)) {
                        linkedHashMap2.put(strMo1858p3, pOJOPropertyBuilder13);
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.f4642j = linkedHashMap;
        this.f4641i = true;
    }

    /* JADX INFO: renamed from: i */
    public void m1830i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbM833U = outline.m833U("Problem with definition of ");
        sbM833U.append(this.f4637e);
        sbM833U.append(": ");
        sbM833U.append(str);
        throw new IllegalArgumentException(sbM833U.toString());
    }
}
