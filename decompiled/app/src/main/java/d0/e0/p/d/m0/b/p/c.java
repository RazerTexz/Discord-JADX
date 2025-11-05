package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.b.k;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'm' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FunctionClassKind.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final a j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final /* synthetic */ c[] o;
    private final String classNamePrefix;
    private final d0.e0.p.d.m0.g.b packageFqName;

    /* compiled from: FunctionClassKind.kt */
    public static final class a {

        /* compiled from: FunctionClassKind.kt */
        /* renamed from: d0.e0.p.d.m0.b.p.c$a$a, reason: collision with other inner class name */
        public static final class C0509a {
            public final c a;

            /* renamed from: b, reason: collision with root package name */
            public final int f3235b;

            public C0509a(c cVar, int i) {
                m.checkNotNullParameter(cVar, "kind");
                this.a = cVar;
                this.f3235b = i;
            }

            public final c component1() {
                return this.a;
            }

            public final int component2() {
                return this.f3235b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0509a)) {
                    return false;
                }
                C0509a c0509a = (C0509a) obj;
                return this.a == c0509a.a && this.f3235b == c0509a.f3235b;
            }

            public final c getKind() {
                return this.a;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f3235b;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("KindWithArity(kind=");
                sbU.append(this.a);
                sbU.append(", arity=");
                return b.d.b.a.a.A(sbU, this.f3235b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final c byClassNamePrefix(d0.e0.p.d.m0.g.b bVar, String str) {
            m.checkNotNullParameter(bVar, "packageFqName");
            m.checkNotNullParameter(str, "className");
            c[] cVarArrValues = c.values();
            for (int i = 0; i < 4; i++) {
                c cVar = cVarArrValues[i];
                if (m.areEqual(cVar.getPackageFqName(), bVar) && t.startsWith$default(str, cVar.getClassNamePrefix(), false, 2, null)) {
                    return cVar;
                }
            }
            return null;
        }

        public final c getFunctionalClassKind(String str, d0.e0.p.d.m0.g.b bVar) {
            m.checkNotNullParameter(str, "className");
            m.checkNotNullParameter(bVar, "packageFqName");
            C0509a className = parseClassName(str, bVar);
            if (className == null) {
                return null;
            }
            return className.getKind();
        }

        public final C0509a parseClassName(String str, d0.e0.p.d.m0.g.b bVar) {
            Integer numValueOf;
            m.checkNotNullParameter(str, "className");
            m.checkNotNullParameter(bVar, "packageFqName");
            c cVarByClassNamePrefix = byClassNamePrefix(bVar, str);
            if (cVarByClassNamePrefix == null) {
                return null;
            }
            String strSubstring = str.substring(cVarByClassNamePrefix.getClassNamePrefix().length());
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            if (strSubstring.length() == 0) {
                numValueOf = null;
                break;
            }
            int length = strSubstring.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char cCharAt = strSubstring.charAt(i);
                i++;
                int i3 = cCharAt - '0';
                if (!(i3 >= 0 && i3 <= 9)) {
                    numValueOf = null;
                    break;
                }
                i2 = (i2 * 10) + i3;
            }
            numValueOf = Integer.valueOf(i2);
            if (numValueOf == null) {
                return null;
            }
            return new C0509a(cVarByClassNamePrefix, numValueOf.intValue());
        }
    }

    static {
        c cVar = new c("Function", 0, k.l, "Function");
        k = cVar;
        c cVar2 = new c("SuspendFunction", 1, k.d, "SuspendFunction");
        l = cVar2;
        d0.e0.p.d.m0.g.b bVar = k.i;
        c cVar3 = new c("KFunction", 2, bVar, "KFunction");
        m = cVar3;
        c cVar4 = new c("KSuspendFunction", 3, bVar, "KSuspendFunction");
        n = cVar4;
        o = new c[]{cVar, cVar2, cVar3, cVar4};
        j = new a(null);
    }

    public c(String str, int i, d0.e0.p.d.m0.g.b bVar, String str2) {
        this.packageFqName = bVar;
        this.classNamePrefix = str2;
    }

    public static c valueOf(String str) {
        m.checkNotNullParameter(str, "value");
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        c[] cVarArr = o;
        c[] cVarArr2 = new c[cVarArr.length];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        return cVarArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final d0.e0.p.d.m0.g.b getPackageFqName() {
        return this.packageFqName;
    }

    public final d0.e0.p.d.m0.g.e numberedClassName(int i) {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(m.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"$classNamePrefix$arity\")");
        return eVarIdentifier;
    }
}
