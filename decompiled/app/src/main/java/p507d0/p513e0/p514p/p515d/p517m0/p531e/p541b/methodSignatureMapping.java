package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: methodSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class methodSignatureMapping {

    /* renamed from: a */
    public static final b f23617a = new b(null);

    /* renamed from: b */
    public static final d f23618b = new d(JvmPrimitiveType.BOOLEAN);

    /* renamed from: c */
    public static final d f23619c = new d(JvmPrimitiveType.CHAR);

    /* renamed from: d */
    public static final d f23620d = new d(JvmPrimitiveType.BYTE);

    /* renamed from: e */
    public static final d f23621e = new d(JvmPrimitiveType.SHORT);

    /* renamed from: f */
    public static final d f23622f = new d(JvmPrimitiveType.INT);

    /* renamed from: g */
    public static final d f23623g = new d(JvmPrimitiveType.FLOAT);

    /* renamed from: h */
    public static final d f23624h = new d(JvmPrimitiveType.LONG);

    /* renamed from: i */
    public static final d f23625i = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$a */
    public static final class a extends methodSignatureMapping {

        /* renamed from: j */
        public final methodSignatureMapping f23626j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(methodSignatureMapping methodsignaturemapping) {
            super(null);
            Intrinsics3.checkNotNullParameter(methodsignaturemapping, "elementType");
            this.f23626j = methodsignaturemapping;
        }

        public final methodSignatureMapping getElementType() {
            return this.f23626j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d getBOOLEAN$descriptors_jvm() {
            return methodSignatureMapping.access$getBOOLEAN$cp();
        }

        public final d getBYTE$descriptors_jvm() {
            return methodSignatureMapping.access$getBYTE$cp();
        }

        public final d getCHAR$descriptors_jvm() {
            return methodSignatureMapping.access$getCHAR$cp();
        }

        public final d getDOUBLE$descriptors_jvm() {
            return methodSignatureMapping.access$getDOUBLE$cp();
        }

        public final d getFLOAT$descriptors_jvm() {
            return methodSignatureMapping.access$getFLOAT$cp();
        }

        public final d getINT$descriptors_jvm() {
            return methodSignatureMapping.access$getINT$cp();
        }

        public final d getLONG$descriptors_jvm() {
            return methodSignatureMapping.access$getLONG$cp();
        }

        public final d getSHORT$descriptors_jvm() {
            return methodSignatureMapping.access$getSHORT$cp();
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$c */
    public static final class c extends methodSignatureMapping {

        /* renamed from: j */
        public final String f23627j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "internalName");
            this.f23627j = str;
        }

        public final String getInternalName() {
            return this.f23627j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$d */
    public static final class d extends methodSignatureMapping {

        /* renamed from: j */
        public final JvmPrimitiveType f23628j;

        public d(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.f23628j = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.f23628j;
        }
    }

    public methodSignatureMapping() {
    }

    public static final /* synthetic */ d access$getBOOLEAN$cp() {
        return f23618b;
    }

    public static final /* synthetic */ d access$getBYTE$cp() {
        return f23620d;
    }

    public static final /* synthetic */ d access$getCHAR$cp() {
        return f23619c;
    }

    public static final /* synthetic */ d access$getDOUBLE$cp() {
        return f23625i;
    }

    public static final /* synthetic */ d access$getFLOAT$cp() {
        return f23623g;
    }

    public static final /* synthetic */ d access$getINT$cp() {
        return f23622f;
    }

    public static final /* synthetic */ d access$getLONG$cp() {
        return f23624h;
    }

    public static final /* synthetic */ d access$getSHORT$cp() {
        return f23621e;
    }

    public String toString() {
        return methodSignatureMapping2.f23629a.toString2(this);
    }

    public methodSignatureMapping(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
