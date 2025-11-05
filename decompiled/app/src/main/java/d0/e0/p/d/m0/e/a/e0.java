package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpecialGenericSignatures.kt */
/* loaded from: classes3.dex */
public class e0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final List<a.C0519a> f3311b;
    public static final List<String> c;
    public static final Map<a.C0519a, c> d;
    public static final Map<String, c> e;
    public static final Set<d0.e0.p.d.m0.g.e> f;
    public static final Set<String> g;
    public static final a.C0519a h;
    public static final Map<a.C0519a, d0.e0.p.d.m0.g.e> i;
    public static final Map<String, d0.e0.p.d.m0.g.e> j;
    public static final List<d0.e0.p.d.m0.g.e> k;
    public static final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.g.e>> l;

    /* compiled from: SpecialGenericSignatures.kt */
    public static final class a {

        /* compiled from: SpecialGenericSignatures.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.e0$a$a, reason: collision with other inner class name */
        public static final class C0519a {
            public final d0.e0.p.d.m0.g.e a;

            /* renamed from: b, reason: collision with root package name */
            public final String f3312b;

            public C0519a(d0.e0.p.d.m0.g.e eVar, String str) {
                d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.z.d.m.checkNotNullParameter(str, "signature");
                this.a = eVar;
                this.f3312b = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0519a)) {
                    return false;
                }
                C0519a c0519a = (C0519a) obj;
                return d0.z.d.m.areEqual(this.a, c0519a.a) && d0.z.d.m.areEqual(this.f3312b, c0519a.f3312b);
            }

            public final d0.e0.p.d.m0.g.e getName() {
                return this.a;
            }

            public final String getSignature() {
                return this.f3312b;
            }

            public int hashCode() {
                return this.f3312b.hashCode() + (this.a.hashCode() * 31);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("NameAndSignature(name=");
                sbU.append(this.a);
                sbU.append(", signature=");
                return b.d.b.a.a.H(sbU, this.f3312b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final C0519a access$method(a aVar, String str, String str2, String str3, String str4) {
            Objects.requireNonNull(aVar);
            d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str2);
            d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(name)");
            return new C0519a(eVarIdentifier, d0.e0.p.d.m0.e.b.w.a.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return e0.access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp();
        }

        public final Set<d0.e0.p.d.m0.g.e> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return e0.access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp();
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return e0.access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp();
        }

        public final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.g.e>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return e0.access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp();
        }

        public final List<d0.e0.p.d.m0.g.e> getORIGINAL_SHORT_NAMES() {
            return e0.access$getORIGINAL_SHORT_NAMES$cp();
        }

        public final C0519a getREMOVE_AT_NAME_AND_SIGNATURE() {
            return e0.access$getREMOVE_AT_NAME_AND_SIGNATURE$cp();
        }

        public final Map<String, c> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return e0.access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp();
        }

        public final Map<String, d0.e0.p.d.m0.g.e> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return e0.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp();
        }

        public final b getSpecialSignatureInfo(String str) {
            d0.z.d.m.checkNotNullParameter(str, "builtinSignature");
            return getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str) ? b.ONE_COLLECTION_PARAMETER : ((c) h0.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == c.j ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        b(String str, boolean z2) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z2;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            b[] bVarArr = new b[bVarArrValuesCustom.length];
            System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, bVarArrValuesCustom.length);
            return bVarArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpecialGenericSignatures.kt */
    public static final class c {
        public static final c j;
        public static final c k;
        public static final c l;
        public static final c m;
        public static final /* synthetic */ c[] n;
        private final Object defaultValue;

        /* compiled from: SpecialGenericSignatures.kt */
        public static final class a extends c {
            public a(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            c cVar = new c("NULL", 0, null);
            j = cVar;
            c cVar2 = new c("INDEX", 1, -1);
            k = cVar2;
            c cVar3 = new c("FALSE", 2, Boolean.FALSE);
            l = cVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            m = aVar;
            n = new c[]{cVar, cVar2, cVar3, aVar};
        }

        public c(String str, int i, Object obj) {
            this.defaultValue = obj;
        }

        public static c valueOf(String str) {
            d0.z.d.m.checkNotNullParameter(str, "value");
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            c[] cVarArr = n;
            c[] cVarArr2 = new c[cVarArr.length];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
            return cVarArr2;
        }

        public c(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this.defaultValue = obj;
        }
    }

    static {
        Set<String> of = n0.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            a aVar = a;
            String desc = d0.e0.p.d.m0.k.y.d.BOOLEAN.getDesc();
            d0.z.d.m.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(a.access$method(aVar, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f3311b = arrayList;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0519a) it.next()).getSignature());
        }
        c = arrayList2;
        List<a.C0519a> list = f3311b;
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0519a) it2.next()).getName().asString());
        }
        d0.e0.p.d.m0.e.b.w wVar = d0.e0.p.d.m0.e.b.w.a;
        a aVar2 = a;
        String strJavaUtil = wVar.javaUtil("Collection");
        d0.e0.p.d.m0.k.y.d dVar = d0.e0.p.d.m0.k.y.d.BOOLEAN;
        String desc2 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        a.C0519a c0519aAccess$method = a.access$method(aVar2, strJavaUtil, "contains", "Ljava/lang/Object;", desc2);
        c cVar = c.l;
        String strJavaUtil2 = wVar.javaUtil("Collection");
        String desc3 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String strJavaUtil3 = wVar.javaUtil("Map");
        String desc4 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String strJavaUtil4 = wVar.javaUtil("Map");
        String desc5 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String strJavaUtil5 = wVar.javaUtil("Map");
        String desc6 = dVar.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        a.C0519a c0519aAccess$method2 = a.access$method(aVar2, wVar.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.j;
        String strJavaUtil6 = wVar.javaUtil("List");
        d0.e0.p.d.m0.k.y.d dVar2 = d0.e0.p.d.m0.k.y.d.INT;
        String desc7 = dVar2.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc7, "INT.desc");
        a.C0519a c0519aAccess$method3 = a.access$method(aVar2, strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        c cVar3 = c.k;
        String strJavaUtil7 = wVar.javaUtil("List");
        String desc8 = dVar2.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<a.C0519a, c> mapMapOf = h0.mapOf(d0.o.to(c0519aAccess$method, cVar), d0.o.to(a.access$method(aVar2, strJavaUtil2, "remove", "Ljava/lang/Object;", desc3), cVar), d0.o.to(a.access$method(aVar2, strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), cVar), d0.o.to(a.access$method(aVar2, strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), cVar), d0.o.to(a.access$method(aVar2, strJavaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), cVar), d0.o.to(a.access$method(aVar2, wVar.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.m), d0.o.to(c0519aAccess$method2, cVar2), d0.o.to(a.access$method(aVar2, wVar.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), d0.o.to(c0519aAccess$method3, cVar3), d0.o.to(a.access$method(aVar2, strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), cVar3));
        d = mapMapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(mapMapOf.size()));
        Iterator<T> it3 = mapMapOf.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0519a) entry.getKey()).getSignature(), entry.getValue());
        }
        e = linkedHashMap;
        Set setPlus = o0.plus((Set) d.keySet(), (Iterable) f3311b);
        ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(setPlus, 10));
        Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C0519a) it4.next()).getName());
        }
        f = d0.t.u.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(setPlus, 10));
        Iterator it5 = setPlus.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C0519a) it5.next()).getSignature());
        }
        g = d0.t.u.toSet(arrayList5);
        a aVar3 = a;
        d0.e0.p.d.m0.k.y.d dVar3 = d0.e0.p.d.m0.k.y.d.INT;
        String desc9 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc9, "INT.desc");
        h = a.access$method(aVar3, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        d0.e0.p.d.m0.e.b.w wVar2 = d0.e0.p.d.m0.e.b.w.a;
        String strJavaLang = wVar2.javaLang("Number");
        String desc10 = d0.e0.p.d.m0.k.y.d.BYTE.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String strJavaLang2 = wVar2.javaLang("Number");
        String desc11 = d0.e0.p.d.m0.k.y.d.SHORT.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String strJavaLang3 = wVar2.javaLang("Number");
        String desc12 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc12, "INT.desc");
        String strJavaLang4 = wVar2.javaLang("Number");
        String desc13 = d0.e0.p.d.m0.k.y.d.LONG.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc13, "LONG.desc");
        String strJavaLang5 = wVar2.javaLang("Number");
        String desc14 = d0.e0.p.d.m0.k.y.d.FLOAT.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String strJavaLang6 = wVar2.javaLang("Number");
        String desc15 = d0.e0.p.d.m0.k.y.d.DOUBLE.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String strJavaLang7 = wVar2.javaLang("CharSequence");
        String desc16 = dVar3.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = d0.e0.p.d.m0.k.y.d.CHAR.getDesc();
        d0.z.d.m.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<a.C0519a, d0.e0.p.d.m0.g.e> mapMapOf2 = h0.mapOf(d0.o.to(a.access$method(aVar3, strJavaLang, "toByte", "", desc10), d0.e0.p.d.m0.g.e.identifier("byteValue")), d0.o.to(a.access$method(aVar3, strJavaLang2, "toShort", "", desc11), d0.e0.p.d.m0.g.e.identifier("shortValue")), d0.o.to(a.access$method(aVar3, strJavaLang3, "toInt", "", desc12), d0.e0.p.d.m0.g.e.identifier("intValue")), d0.o.to(a.access$method(aVar3, strJavaLang4, "toLong", "", desc13), d0.e0.p.d.m0.g.e.identifier("longValue")), d0.o.to(a.access$method(aVar3, strJavaLang5, "toFloat", "", desc14), d0.e0.p.d.m0.g.e.identifier("floatValue")), d0.o.to(a.access$method(aVar3, strJavaLang6, "toDouble", "", desc15), d0.e0.p.d.m0.g.e.identifier("doubleValue")), d0.o.to(aVar3.getREMOVE_AT_NAME_AND_SIGNATURE(), d0.e0.p.d.m0.g.e.identifier("remove")), d0.o.to(a.access$method(aVar3, strJavaLang7, "get", desc16, desc17), d0.e0.p.d.m0.g.e.identifier("charAt")));
        i = mapMapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(mapMapOf2.size()));
        Iterator<T> it6 = mapMapOf2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0519a) entry2.getKey()).getSignature(), entry2.getValue());
        }
        j = linkedHashMap2;
        Set<a.C0519a> setKeySet = i.keySet();
        ArrayList arrayList6 = new ArrayList(d0.t.o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C0519a) it7.next()).getName());
        }
        k = arrayList6;
        Set<Map.Entry<a.C0519a, d0.e0.p.d.m0.g.e>> setEntrySet = i.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(d0.t.o.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C0519a) entry3.getKey()).getName(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            d0.e0.p.d.m0.g.e eVar = (d0.e0.p.d.m0.g.e) pair.getSecond();
            Object arrayList8 = linkedHashMap3.get(eVar);
            if (arrayList8 == null) {
                arrayList8 = new ArrayList();
                linkedHashMap3.put(eVar, arrayList8);
            }
            ((List) arrayList8).add((d0.e0.p.d.m0.g.e) pair.getFirst());
        }
        l = linkedHashMap3;
    }

    public static final /* synthetic */ List access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp() {
        return c;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp() {
        return f;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp() {
        return g;
    }

    public static final /* synthetic */ Map access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp() {
        return l;
    }

    public static final /* synthetic */ List access$getORIGINAL_SHORT_NAMES$cp() {
        return k;
    }

    public static final /* synthetic */ a.C0519a access$getREMOVE_AT_NAME_AND_SIGNATURE$cp() {
        return h;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp() {
        return e;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp() {
        return j;
    }
}
