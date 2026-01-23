package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

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
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c, reason: use source file name */
/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassKind {

    /* JADX INFO: renamed from: j */
    public static final a f22601j;

    /* JADX INFO: renamed from: k */
    public static final FunctionClassKind f22602k;

    /* JADX INFO: renamed from: l */
    public static final FunctionClassKind f22603l;

    /* JADX INFO: renamed from: m */
    public static final FunctionClassKind f22604m;

    /* JADX INFO: renamed from: n */
    public static final FunctionClassKind f22605n;

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ FunctionClassKind[] f22606o;
    private final String classNamePrefix;
    private final FqName packageFqName;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a */
    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FunctionClassKind.kt */
        public static final class C13305a {

            /* JADX INFO: renamed from: a */
            public final FunctionClassKind f22607a;

            /* JADX INFO: renamed from: b */
            public final int f22608b;

            public C13305a(FunctionClassKind functionClassKind, int i) {
                Intrinsics3.checkNotNullParameter(functionClassKind, "kind");
                this.f22607a = functionClassKind;
                this.f22608b = i;
            }

            public final FunctionClassKind component1() {
                return this.f22607a;
            }

            public final int component2() {
                return this.f22608b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13305a)) {
                    return false;
                }
                C13305a c13305a = (C13305a) obj;
                return this.f22607a == c13305a.f22607a && this.f22608b == c13305a.f22608b;
            }

            public final FunctionClassKind getKind() {
                return this.f22607a;
            }

            public int hashCode() {
                return (this.f22607a.hashCode() * 31) + this.f22608b;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("KindWithArity(kind=");
                sbM833U.append(this.f22607a);
                sbM833U.append(", arity=");
                return outline.m813A(sbM833U, this.f22608b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final FunctionClassKind byClassNamePrefix(FqName fqName, String str) {
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics3.checkNotNullParameter(str, "className");
            FunctionClassKind[] functionClassKindArrValues = FunctionClassKind.values();
            for (int i = 0; i < 4; i++) {
                FunctionClassKind functionClassKind = functionClassKindArrValues[i];
                if (Intrinsics3.areEqual(functionClassKind.getPackageFqName(), fqName) && StringsJVM.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2, null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        public final FunctionClassKind getFunctionalClassKind(String str, FqName fqName) {
            Intrinsics3.checkNotNullParameter(str, "className");
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            C13305a className = parseClassName(str, fqName);
            if (className == null) {
                return null;
            }
            return className.getKind();
        }

        public final C13305a parseClassName(String str, FqName fqName) {
            Integer numValueOf;
            Intrinsics3.checkNotNullParameter(str, "className");
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            FunctionClassKind functionClassKindByClassNamePrefix = byClassNamePrefix(fqName, str);
            if (functionClassKindByClassNamePrefix == null) {
                return null;
            }
            String strSubstring = str.substring(functionClassKindByClassNamePrefix.getClassNamePrefix().length());
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
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
            return new C13305a(functionClassKindByClassNamePrefix, numValueOf.intValue());
        }
    }

    static {
        FunctionClassKind functionClassKind = new FunctionClassKind("Function", 0, StandardNames.f22499l, "Function");
        f22602k = functionClassKind;
        FunctionClassKind functionClassKind2 = new FunctionClassKind("SuspendFunction", 1, StandardNames.f22491d, "SuspendFunction");
        f22603l = functionClassKind2;
        FqName fqName = StandardNames.f22496i;
        FunctionClassKind functionClassKind3 = new FunctionClassKind("KFunction", 2, fqName, "KFunction");
        f22604m = functionClassKind3;
        FunctionClassKind functionClassKind4 = new FunctionClassKind("KSuspendFunction", 3, fqName, "KSuspendFunction");
        f22605n = functionClassKind4;
        f22606o = new FunctionClassKind[]{functionClassKind, functionClassKind2, functionClassKind3, functionClassKind4};
        f22601j = new a(null);
    }

    public FunctionClassKind(String str, int i, FqName fqName, String str2) {
        this.packageFqName = fqName;
        this.classNamePrefix = str2;
    }

    public static FunctionClassKind valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        FunctionClassKind[] functionClassKindArr = f22606o;
        FunctionClassKind[] functionClassKindArr2 = new FunctionClassKind[functionClassKindArr.length];
        System.arraycopy(functionClassKindArr, 0, functionClassKindArr2, 0, functionClassKindArr.length);
        return functionClassKindArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int i) {
        Name nameIdentifier = Name.identifier(Intrinsics3.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"$classNamePrefix$arity\")");
        return nameIdentifier;
    }
}
