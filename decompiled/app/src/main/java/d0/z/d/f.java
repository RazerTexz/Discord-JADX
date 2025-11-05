package d0.z.d;

import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.g0;
import d0.t.h0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ClassReference.kt */
/* loaded from: classes3.dex */
public final class f implements d0.e0.c<Object>, e {
    public static final Map<Class<? extends d0.c<?>>, Integer> j;
    public static final HashMap<String, String> k;
    public static final HashMap<String, String> l;
    public static final HashMap<String, String> m;
    public static final Map<String, String> n;
    public static final a o = new a(null);
    public final Class<?> p;

    /* compiled from: ClassReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String getClassQualifiedName(Class<?> cls) {
            String str;
            m.checkNotNullParameter(cls, "jClass");
            String strW = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str2 = (String) f.access$getClassFqNames$cp().get(cls.getName());
                return str2 != null ? str2 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            m.checkNotNullExpressionValue(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) f.access$getClassFqNames$cp().get(componentType.getName())) != null) {
                strW = b.d.b.a.a.w(str, "Array");
            }
            return strW != null ? strW : "kotlin.Array";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String getClassSimpleName(Class<?> cls) {
            String str;
            String strSubstringAfter$default;
            m.checkNotNullParameter(cls, "jClass");
            String strW = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        strSubstringAfter$default = d0.g0.w.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default == null) {
                            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                            if (enclosingConstructor != null) {
                                m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                                strSubstringAfter$default = d0.g0.w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                            } else {
                                strSubstringAfter$default = null;
                            }
                        }
                    }
                    if (strSubstringAfter$default != null) {
                        return strSubstringAfter$default;
                    }
                    m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    return d0.g0.w.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
                }
                if (!cls.isArray()) {
                    String str2 = (String) f.access$getSimpleNames$cp().get(cls.getName());
                    return str2 != null ? str2 : cls.getSimpleName();
                }
                Class<?> componentType = cls.getComponentType();
                m.checkNotNullExpressionValue(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) f.access$getSimpleNames$cp().get(componentType.getName())) != null) {
                    strW = b.d.b.a.a.w(str, "Array");
                }
                if (strW == null) {
                    return "Array";
                }
            }
            return strW;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listListOf = d0.t.n.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, d0.z.c.a.class, d0.z.c.b.class, d0.z.c.c.class, d0.z.c.d.class, Function22.class});
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            arrayList.add(d0.o.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        j = h0.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put(Constants.LONG, "kotlin.Long");
        map.put("double", "kotlin.Double");
        k = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        l = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        m.checkNotNullExpressionValue(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            m.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(d0.g0.w.substringAfterLast$default(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair pair = d0.o.to(sb.toString(), str + ".Companion");
            map3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry<Class<? extends d0.c<?>>, Integer> entry : j.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        m = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), d0.g0.w.substringAfterLast$default((String) entry2.getValue(), '.', null, 2, null));
        }
        n = linkedHashMap;
    }

    public f(Class<?> cls) {
        m.checkNotNullParameter(cls, "jClass");
        this.p = cls;
    }

    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return m;
    }

    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return n;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && m.areEqual(d0.z.a.getJavaObjectType(this), d0.z.a.getJavaObjectType((d0.e0.c) obj));
    }

    @Override // d0.z.d.e
    public Class<?> getJClass() {
        return this.p;
    }

    @Override // d0.e0.c
    public Object getObjectInstance() {
        throw new d0.z.b();
    }

    @Override // d0.e0.c
    public String getQualifiedName() {
        return o.getClassQualifiedName(getJClass());
    }

    @Override // d0.e0.c
    public List<d0.e0.c<? extends Object>> getSealedSubclasses() {
        throw new d0.z.b();
    }

    @Override // d0.e0.c
    public String getSimpleName() {
        return o.getClassSimpleName(getJClass());
    }

    public int hashCode() {
        return d0.z.a.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
