package d0.e0.p.d.m0.e.b;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
public abstract class k {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d f3379b = new d(d0.e0.p.d.m0.k.y.d.BOOLEAN);
    public static final d c = new d(d0.e0.p.d.m0.k.y.d.CHAR);
    public static final d d = new d(d0.e0.p.d.m0.k.y.d.BYTE);
    public static final d e = new d(d0.e0.p.d.m0.k.y.d.SHORT);
    public static final d f = new d(d0.e0.p.d.m0.k.y.d.INT);
    public static final d g = new d(d0.e0.p.d.m0.k.y.d.FLOAT);
    public static final d h = new d(d0.e0.p.d.m0.k.y.d.LONG);
    public static final d i = new d(d0.e0.p.d.m0.k.y.d.DOUBLE);

    /* compiled from: methodSignatureMapping.kt */
    public static final class a extends k {
        public final k j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar) {
            super(null);
            d0.z.d.m.checkNotNullParameter(kVar, "elementType");
            this.j = kVar;
        }

        public final k getElementType() {
            return this.j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d getBOOLEAN$descriptors_jvm() {
            return k.access$getBOOLEAN$cp();
        }

        public final d getBYTE$descriptors_jvm() {
            return k.access$getBYTE$cp();
        }

        public final d getCHAR$descriptors_jvm() {
            return k.access$getCHAR$cp();
        }

        public final d getDOUBLE$descriptors_jvm() {
            return k.access$getDOUBLE$cp();
        }

        public final d getFLOAT$descriptors_jvm() {
            return k.access$getFLOAT$cp();
        }

        public final d getINT$descriptors_jvm() {
            return k.access$getINT$cp();
        }

        public final d getLONG$descriptors_jvm() {
            return k.access$getLONG$cp();
        }

        public final d getSHORT$descriptors_jvm() {
            return k.access$getSHORT$cp();
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class c extends k {
        public final String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            d0.z.d.m.checkNotNullParameter(str, "internalName");
            this.j = str;
        }

        public final String getInternalName() {
            return this.j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class d extends k {
        public final d0.e0.p.d.m0.k.y.d j;

        public d(d0.e0.p.d.m0.k.y.d dVar) {
            super(null);
            this.j = dVar;
        }

        public final d0.e0.p.d.m0.k.y.d getJvmPrimitiveType() {
            return this.j;
        }
    }

    public k() {
    }

    public static final /* synthetic */ d access$getBOOLEAN$cp() {
        return f3379b;
    }

    public static final /* synthetic */ d access$getBYTE$cp() {
        return d;
    }

    public static final /* synthetic */ d access$getCHAR$cp() {
        return c;
    }

    public static final /* synthetic */ d access$getDOUBLE$cp() {
        return i;
    }

    public static final /* synthetic */ d access$getFLOAT$cp() {
        return g;
    }

    public static final /* synthetic */ d access$getINT$cp() {
        return f;
    }

    public static final /* synthetic */ d access$getLONG$cp() {
        return h;
    }

    public static final /* synthetic */ d access$getSHORT$cp() {
        return e;
    }

    public String toString() {
        return m.a.toString2(this);
    }

    public k(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
