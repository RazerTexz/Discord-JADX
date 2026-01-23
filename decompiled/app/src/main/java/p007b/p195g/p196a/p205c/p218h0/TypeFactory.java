package p007b.p195g.p196a.p205c.p218h0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonNode;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.LRUMap;
import p007b.p195g.p196a.p205c.p219i0.LookupCache;

/* JADX INFO: renamed from: b.g.a.c.h0.n, reason: use source file name */
/* JADX INFO: compiled from: TypeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeFactory implements Serializable {

    /* JADX INFO: renamed from: A */
    public static final SimpleType f4920A;

    /* JADX INFO: renamed from: B */
    public static final SimpleType f4921B;

    /* JADX INFO: renamed from: C */
    public static final SimpleType f4922C;

    /* JADX INFO: renamed from: D */
    public static final SimpleType f4923D;

    /* JADX INFO: renamed from: j */
    public static final JavaType[] f4924j = new JavaType[0];

    /* JADX INFO: renamed from: k */
    public static final TypeFactory f4925k = new TypeFactory();

    /* JADX INFO: renamed from: l */
    public static final TypeBindings f4926l = TypeBindings.f4908l;

    /* JADX INFO: renamed from: m */
    public static final Class<?> f4927m = String.class;

    /* JADX INFO: renamed from: n */
    public static final Class<?> f4928n = Object.class;

    /* JADX INFO: renamed from: o */
    public static final Class<?> f4929o = Comparable.class;

    /* JADX INFO: renamed from: p */
    public static final Class<?> f4930p = Class.class;

    /* JADX INFO: renamed from: q */
    public static final Class<?> f4931q = Enum.class;

    /* JADX INFO: renamed from: r */
    public static final Class<?> f4932r = JsonNode.class;

    /* JADX INFO: renamed from: s */
    public static final Class<?> f4933s;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: t */
    public static final Class<?> f4934t;

    /* JADX INFO: renamed from: u */
    public static final Class<?> f4935u;

    /* JADX INFO: renamed from: v */
    public static final SimpleType f4936v;

    /* JADX INFO: renamed from: w */
    public static final SimpleType f4937w;

    /* JADX INFO: renamed from: x */
    public static final SimpleType f4938x;

    /* JADX INFO: renamed from: y */
    public static final SimpleType f4939y;

    /* JADX INFO: renamed from: z */
    public static final SimpleType f4940z;
    public final LookupCache<Object, JavaType> _typeCache = new LRUMap(16, 200);
    public final TypeParser _parser = new TypeParser(this);
    public final TypeModifier[] _modifiers = null;
    public final ClassLoader _classLoader = null;

    static {
        Class<?> cls = Boolean.TYPE;
        f4933s = cls;
        Class<?> cls2 = Integer.TYPE;
        f4934t = cls2;
        Class<?> cls3 = Long.TYPE;
        f4935u = cls3;
        f4936v = new SimpleType(cls);
        f4937w = new SimpleType(cls2);
        f4938x = new SimpleType(cls3);
        f4939y = new SimpleType(String.class);
        f4940z = new SimpleType(Object.class);
        f4920A = new SimpleType(Comparable.class);
        f4921B = new SimpleType(Enum.class);
        f4922C = new SimpleType(Class.class);
        f4923D = new SimpleType(JsonNode.class);
    }

    /* JADX INFO: renamed from: k */
    public static JavaType m2158k() {
        Objects.requireNonNull(f4925k);
        return f4940z;
    }

    /* JADX INFO: renamed from: a */
    public JavaType m2159a(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == f4933s) {
                return f4936v;
            }
            if (cls == f4934t) {
                return f4937w;
            }
            if (cls == f4935u) {
                return f4938x;
            }
            return null;
        }
        if (cls == f4927m) {
            return f4939y;
        }
        if (cls == f4928n) {
            return f4940z;
        }
        if (cls == f4932r) {
            return f4923D;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public JavaType m2160b(ClassStack classStack, Type type, TypeBindings typeBindings) {
        JavaType javaTypeM2160b;
        Type[] bounds;
        TypeBindings typeBindingsM2148d;
        if (type instanceof Class) {
            javaTypeM2160b = m2161c(classStack, (Class) type, f4926l);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls = (Class) parameterizedType.getRawType();
            if (cls == f4931q) {
                javaTypeM2160b = f4921B;
            } else if (cls == f4929o) {
                javaTypeM2160b = f4920A;
            } else if (cls == f4930p) {
                javaTypeM2160b = f4922C;
            } else {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
                if (length == 0) {
                    typeBindingsM2148d = f4926l;
                } else {
                    JavaType[] javaTypeArr = new JavaType[length];
                    for (int i = 0; i < length; i++) {
                        javaTypeArr[i] = m2160b(classStack, actualTypeArguments[i], typeBindings);
                    }
                    typeBindingsM2148d = TypeBindings.m2148d(cls, javaTypeArr);
                }
                javaTypeM2160b = m2161c(classStack, cls, typeBindingsM2148d);
            }
        } else {
            if (type instanceof JavaType) {
                return (JavaType) type;
            }
            if (type instanceof GenericArrayType) {
                javaTypeM2160b = ArrayType.m2092L(m2160b(classStack, ((GenericArrayType) type).getGenericComponentType(), typeBindings), typeBindings);
            } else if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                String name = typeVariable.getName();
                if (typeBindings == null) {
                    throw new IllegalArgumentException(outline.m886y("Null `bindings` passed (type variable \"", name, "\")"));
                }
                JavaType javaTypeM2150e = typeBindings.m2150e(name);
                if (javaTypeM2150e != null) {
                    javaTypeM2160b = javaTypeM2150e;
                } else if (typeBindings.m2153h(name)) {
                    javaTypeM2160b = f4940z;
                } else {
                    TypeBindings typeBindingsM2157l = typeBindings.m2157l(name);
                    synchronized (typeVariable) {
                        bounds = typeVariable.getBounds();
                    }
                    javaTypeM2160b = m2160b(classStack, bounds[0], typeBindingsM2157l);
                }
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sbM833U = outline.m833U("Unrecognized Type: ");
                    sbM833U.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                javaTypeM2160b = m2160b(classStack, ((WildcardType) type).getUpperBounds()[0], typeBindings);
            }
        }
        if (this._modifiers != null) {
            javaTypeM2160b.mo2136j();
            TypeModifier[] typeModifierArr = this._modifiers;
            if (typeModifierArr.length > 0) {
                TypeModifier typeModifier = typeModifierArr[0];
                throw null;
            }
        }
        return javaTypeM2160b;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaType m2161c(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        ClassStack classStack2;
        ClassStack classStack3;
        JavaType javaTypeM2160b;
        JavaType[] javaTypeArrM2163e;
        Object obj;
        JavaType referenceType;
        JavaType javaType;
        JavaType javaType2;
        JavaType javaType3;
        SimpleType simpleType;
        JavaType javaType4;
        JavaType javaType5;
        JavaType javaTypeM2159a = m2159a(cls);
        if (javaTypeM2159a != null) {
            return javaTypeM2159a;
        }
        Object objM2149a = (typeBindings == null || typeBindings.m2154i()) ? cls : typeBindings.m2149a(cls);
        JavaType javaTypeMo2093C = this._typeCache.get(objM2149a);
        if (javaTypeMo2093C != null) {
            return javaTypeMo2093C;
        }
        if (classStack == null) {
            classStack3 = new ClassStack(cls);
        } else {
            if (classStack.f4903b != cls) {
                classStack2 = classStack.f4902a;
                while (true) {
                    if (classStack2 == null) {
                        classStack2 = null;
                        break;
                    }
                    if (classStack2.f4903b == cls) {
                        break;
                    }
                    classStack2 = classStack2.f4902a;
                }
            } else {
                classStack2 = classStack;
            }
            if (classStack2 != null) {
                ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(cls, f4926l);
                if (classStack2.f4904c == null) {
                    classStack2.f4904c = new ArrayList<>();
                }
                classStack2.f4904c.add(resolvedRecursiveType);
                return resolvedRecursiveType;
            }
            classStack3 = new ClassStack(classStack, cls);
        }
        if (cls.isArray()) {
            referenceType = ArrayType.m2092L(m2160b(classStack3, cls.getComponentType(), typeBindings), typeBindings);
            obj = objM2149a;
        } else {
            if (cls.isInterface()) {
                javaTypeArrM2163e = m2163e(classStack3, cls, typeBindings);
                javaTypeM2160b = null;
            } else {
                Annotation[] annotationArr = ClassUtil.f4944a;
                Type genericSuperclass = cls.getGenericSuperclass();
                javaTypeM2160b = genericSuperclass == null ? null : m2160b(classStack3, genericSuperclass, typeBindings);
                javaTypeArrM2163e = m2163e(classStack3, cls, typeBindings);
            }
            JavaType[] javaTypeArr = javaTypeArrM2163e;
            JavaType javaType6 = javaTypeM2160b;
            if (cls == Properties.class) {
                SimpleType simpleType2 = f4939y;
                javaTypeMo2093C = MapType.m2123Q(cls, typeBindings, javaType6, javaTypeArr, simpleType2, simpleType2);
            } else if (javaType6 != null) {
                javaTypeMo2093C = javaType6.mo2093C(cls, typeBindings, javaType6, javaTypeArr);
            }
            if (javaTypeMo2093C == null) {
                TypeBindings typeBindings2 = typeBindings == null ? f4926l : typeBindings;
                if (cls == Map.class) {
                    if (cls == Properties.class) {
                        simpleType = f4939y;
                    } else {
                        List<JavaType> listM2152g = typeBindings2.m2152g();
                        int size = listM2152g.size();
                        if (size == 0) {
                            simpleType = f4940z;
                        } else {
                            if (size != 2) {
                                Object[] objArr = new Object[4];
                                objArr[0] = ClassUtil.m2189u(cls);
                                objArr[1] = Integer.valueOf(size);
                                objArr[2] = size == 1 ? "" : "s";
                                objArr[3] = typeBindings2;
                                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
                            }
                            JavaType javaType7 = listM2152g.get(0);
                            javaType4 = listM2152g.get(1);
                            javaType5 = javaType7;
                            referenceType = MapType.m2123Q(cls, typeBindings2, javaType6, javaTypeArr, javaType5, javaType4);
                        }
                    }
                    javaType5 = simpleType;
                    javaType4 = javaType5;
                    referenceType = MapType.m2123Q(cls, typeBindings2, javaType6, javaTypeArr, javaType5, javaType4);
                } else if (cls == Collection.class) {
                    List<JavaType> listM2152g2 = typeBindings2.m2152g();
                    if (listM2152g2.isEmpty()) {
                        javaType3 = f4940z;
                    } else {
                        if (listM2152g2.size() != 1) {
                            throw new IllegalArgumentException(outline.m867o(cls, outline.m833U("Strange Collection type "), ": cannot determine type parameters"));
                        }
                        javaType3 = listM2152g2.get(0);
                    }
                    referenceType = new CollectionType(cls, typeBindings2, javaType6, javaTypeArr, javaType3, null, null, false);
                } else {
                    if (cls == AtomicReference.class) {
                        List<JavaType> listM2152g3 = typeBindings2.m2152g();
                        if (listM2152g3.isEmpty()) {
                            javaType2 = f4940z;
                        } else {
                            if (listM2152g3.size() != 1) {
                                throw new IllegalArgumentException(outline.m867o(cls, outline.m833U("Strange Reference type "), ": cannot determine type parameters"));
                            }
                            javaType2 = listM2152g3.get(0);
                        }
                        obj = objM2149a;
                        javaType = javaType6;
                        referenceType = new ReferenceType(cls, typeBindings2, javaType6, javaTypeArr, javaType2, null, null, null, false);
                    } else {
                        obj = objM2149a;
                        javaType = javaType6;
                        referenceType = null;
                    }
                    if (referenceType == null) {
                        int length = javaTypeArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                referenceType = null;
                                break;
                            }
                            JavaType javaTypeMo2093C2 = javaTypeArr[i].mo2093C(cls, typeBindings, javaType, javaTypeArr);
                            if (javaTypeMo2093C2 != null) {
                                referenceType = javaTypeMo2093C2;
                                break;
                            }
                            i++;
                        }
                        if (referenceType == null) {
                            referenceType = m2162d(cls, typeBindings, javaType, javaTypeArr);
                        }
                    }
                }
                obj = objM2149a;
                javaType = javaType6;
                if (referenceType == null) {
                }
            } else {
                obj = objM2149a;
                referenceType = javaTypeMo2093C;
            }
        }
        ArrayList<ResolvedRecursiveType> arrayList = classStack3.f4904c;
        if (arrayList != null) {
            for (ResolvedRecursiveType resolvedRecursiveType2 : arrayList) {
                if (resolvedRecursiveType2._referencedType != null) {
                    StringBuilder sbM833U = outline.m833U("Trying to re-set self reference; old value = ");
                    sbM833U.append(resolvedRecursiveType2._referencedType);
                    sbM833U.append(", new = ");
                    sbM833U.append(referenceType);
                    throw new IllegalStateException(sbM833U.toString());
                }
                resolvedRecursiveType2._referencedType = referenceType;
            }
        }
        if (!referenceType.mo2103s()) {
            this._typeCache.putIfAbsent(obj, referenceType);
        }
        return referenceType;
    }

    /* JADX INFO: renamed from: d */
    public JavaType m2162d(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new SimpleType(cls, typeBindings, javaType, javaTypeArr, null, null, false);
    }

    /* JADX INFO: renamed from: e */
    public JavaType[] m2163e(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Annotation[] annotationArr = ClassUtil.f4944a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return f4924j;
        }
        int length = genericInterfaces.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = m2160b(classStack, genericInterfaces[i], typeBindings);
        }
        return javaTypeArr;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m2164f(JavaType javaType, JavaType javaType2) {
        if (javaType2 instanceof PlaceholderForType) {
            ((PlaceholderForType) javaType2)._actualType = javaType;
            return true;
        }
        if (javaType._class != javaType2._class) {
            return false;
        }
        List<JavaType> listM2152g = javaType.mo2136j().m2152g();
        List<JavaType> listM2152g2 = javaType2.mo2136j().m2152g();
        int size = listM2152g.size();
        for (int i = 0; i < size; i++) {
            if (!m2164f(listM2152g.get(i), listM2152g2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public JavaType m2165g(JavaType javaType, Class<?> cls) {
        Class<?> cls2 = javaType._class;
        if (cls2 == cls) {
            return javaType;
        }
        JavaType javaTypeMo2144i = javaType.mo2144i(cls);
        if (javaTypeMo2144i != null) {
            return javaTypeMo2144i;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), javaType));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), javaType));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d A[LOOP:0: B:45:0x009b->B:46:0x009d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaType m2166h(JavaType javaType, Class<?> cls, boolean z2) throws IllegalArgumentException {
        int length;
        int i;
        JavaType javaTypeMo2144i;
        String str;
        JavaType javaTypeM2161c;
        Class<?> cls2 = javaType._class;
        if (cls2 == cls) {
            return javaType;
        }
        if (cls2 == Object.class) {
            javaTypeM2161c = m2161c(null, cls, f4926l);
        } else {
            if (!cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format("Class %s not subtype of %s", ClassUtil.m2189u(cls), ClassUtil.m2182n(javaType)));
            }
            if (javaType.mo2104v()) {
                if (javaType.mo2122z()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        javaTypeM2161c = m2161c(null, cls, TypeBindings.m2147c(cls, javaType.mo2121o(), javaType.mo2099k()));
                    }
                } else if (javaType.mo2111u()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        javaTypeM2161c = m2161c(null, cls, TypeBindings.m2146b(cls, javaType.mo2099k()));
                    } else {
                        if (cls2 == EnumSet.class) {
                            return javaType;
                        }
                        if (javaType.mo2136j().m2154i()) {
                            javaTypeM2161c = m2161c(null, cls, f4926l);
                        } else {
                            PlaceholderForType[] placeholderForTypeArr = new PlaceholderForType[length];
                            while (i < length) {
                            }
                            javaTypeMo2144i = m2161c(null, cls, TypeBindings.m2148d(cls, placeholderForTypeArr)).mo2144i(javaType._class);
                            if (javaTypeMo2144i != null) {
                            }
                        }
                    }
                }
            } else if (javaType.mo2136j().m2154i() && (length = cls.getTypeParameters().length) != 0) {
                PlaceholderForType[] placeholderForTypeArr2 = new PlaceholderForType[length];
                for (i = 0; i < length; i++) {
                    placeholderForTypeArr2[i] = new PlaceholderForType(i);
                }
                javaTypeMo2144i = m2161c(null, cls, TypeBindings.m2148d(cls, placeholderForTypeArr2)).mo2144i(javaType._class);
                if (javaTypeMo2144i != null) {
                    throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", javaType._class.getName(), cls.getName()));
                }
                List<JavaType> listM2152g = javaType.mo2136j().m2152g();
                List<JavaType> listM2152g2 = javaTypeMo2144i.mo2136j().m2152g();
                int size = listM2152g2.size();
                int size2 = listM2152g.size();
                int i2 = 0;
                while (i2 < size2) {
                    JavaType javaType2 = listM2152g.get(i2);
                    JavaType javaTypeM2158k = i2 < size ? listM2152g2.get(i2) : m2158k();
                    if (!m2164f(javaType2, javaTypeM2158k)) {
                        if (javaType2._class == Object.class) {
                            continue;
                        } else {
                            if (i2 != 0 || !javaType.mo2122z()) {
                                if (javaType2._class.isInterface()) {
                                    Class<?> cls3 = javaTypeM2158k._class;
                                    Class<?> cls4 = javaType2._class;
                                    if (cls4 == cls3 || cls4.isAssignableFrom(cls3)) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), javaType2.mo1729e(), javaTypeM2158k.mo1729e());
                                break;
                            }
                            if (javaTypeM2158k._class == Object.class) {
                                continue;
                            }
                        }
                    }
                    i2++;
                }
                str = null;
                if (str != null && !z2) {
                    StringBuilder sbM833U = outline.m833U("Failed to specialize base type ");
                    sbM833U.append(javaType.mo1729e());
                    sbM833U.append(" as ");
                    sbM833U.append(cls.getName());
                    sbM833U.append(", problem: ");
                    sbM833U.append(str);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                JavaType[] javaTypeArr = new JavaType[length];
                for (int i3 = 0; i3 < length; i3++) {
                    JavaType javaTypeM2158k2 = placeholderForTypeArr2[i3]._actualType;
                    if (javaTypeM2158k2 == null) {
                        javaTypeM2158k2 = m2158k();
                    }
                    javaTypeArr[i3] = javaTypeM2158k2;
                }
                javaTypeM2161c = m2161c(null, cls, TypeBindings.m2148d(cls, javaTypeArr));
            } else {
                javaTypeM2161c = m2161c(null, cls, f4926l);
            }
        }
        return javaTypeM2161c.mo2105F(javaType);
    }

    /* JADX INFO: renamed from: i */
    public JavaType[] m2167i(JavaType javaType, Class<?> cls) {
        JavaType javaTypeMo2144i = javaType.mo2144i(cls);
        return javaTypeMo2144i == null ? f4924j : javaTypeMo2144i.mo2136j().m2156k();
    }

    @Deprecated
    /* JADX INFO: renamed from: j */
    public JavaType m2168j(Class<?> cls) {
        JavaType javaTypeM2159a;
        TypeBindings typeBindings = f4926l;
        return (!typeBindings.m2154i() || (javaTypeM2159a = m2159a(cls)) == null) ? m2162d(cls, typeBindings, null, null) : javaTypeM2159a;
    }
}
