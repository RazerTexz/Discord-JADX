package d0.e0.p.d.m0.e.b.b0;

import d0.t.g0;
import d0.t.j;
import d0.t.n;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinClassHeader.kt */
/* loaded from: classes3.dex */
public final class a {
    public final EnumC0533a a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.a0.b.f f3366b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String f;
    public final int g;

    /* compiled from: KotlinClassHeader.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.b0.a$a, reason: collision with other inner class name */
    public enum EnumC0533a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        public static final C0534a j = new C0534a(null);
        public static final Map<Integer, EnumC0533a> k;

        /* renamed from: id, reason: collision with root package name */
        private final int f3367id;

        /* compiled from: KotlinClassHeader.kt */
        /* renamed from: d0.e0.p.d.m0.e.b.b0.a$a$a, reason: collision with other inner class name */
        public static final class C0534a {
            public C0534a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final EnumC0533a getById(int i) {
                EnumC0533a enumC0533a = (EnumC0533a) EnumC0533a.access$getEntryById$cp().get(Integer.valueOf(i));
                return enumC0533a == null ? EnumC0533a.UNKNOWN : enumC0533a;
            }
        }

        static {
            EnumC0533a[] enumC0533aArrValuesCustom = valuesCustom();
            LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(6), 16));
            for (int i = 0; i < 6; i++) {
                EnumC0533a enumC0533a = enumC0533aArrValuesCustom[i];
                linkedHashMap.put(Integer.valueOf(enumC0533a.getId()), enumC0533a);
            }
            k = linkedHashMap;
        }

        EnumC0533a(int i) {
            this.f3367id = i;
        }

        public static final /* synthetic */ Map access$getEntryById$cp() {
            return k;
        }

        public static final EnumC0533a getById(int i) {
            return j.getById(i);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0533a[] valuesCustom() {
            EnumC0533a[] enumC0533aArrValuesCustom = values();
            EnumC0533a[] enumC0533aArr = new EnumC0533a[enumC0533aArrValuesCustom.length];
            System.arraycopy(enumC0533aArrValuesCustom, 0, enumC0533aArr, 0, enumC0533aArrValuesCustom.length);
            return enumC0533aArr;
        }

        public final int getId() {
            return this.f3367id;
        }
    }

    public a(EnumC0533a enumC0533a, d0.e0.p.d.m0.f.a0.b.f fVar, d0.e0.p.d.m0.f.a0.b.c cVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        m.checkNotNullParameter(enumC0533a, "kind");
        m.checkNotNullParameter(fVar, "metadataVersion");
        m.checkNotNullParameter(cVar, "bytecodeVersion");
        this.a = enumC0533a;
        this.f3366b = fVar;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final String[] getData() {
        return this.c;
    }

    public final String[] getIncompatibleData() {
        return this.d;
    }

    public final EnumC0533a getKind() {
        return this.a;
    }

    public final d0.e0.p.d.m0.f.a0.b.f getMetadataVersion() {
        return this.f3366b;
    }

    public final String getMultifileClassName() {
        String str = this.f;
        if (getKind() == EnumC0533a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.c;
        if (!(getKind() == EnumC0533a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> listAsList = strArr != null ? j.asList(strArr) : null;
        return listAsList != null ? listAsList : n.emptyList();
    }

    public final String[] getStrings() {
        return this.e;
    }

    public final boolean isPreRelease() {
        return a(this.g, 2);
    }

    public final boolean isUnstableFirBinary() {
        return a(this.g, 64) && !a(this.g, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return a(this.g, 16) && !a(this.g, 32);
    }

    public String toString() {
        return this.a + " version=" + this.f3366b;
    }
}
