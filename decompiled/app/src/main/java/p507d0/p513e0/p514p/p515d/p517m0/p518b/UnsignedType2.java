package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'j' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnsignedType.kt */
/* renamed from: d0.e0.p.d.m0.b.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class UnsignedType2 {

    /* renamed from: j */
    public static final UnsignedType2 f22579j;

    /* renamed from: k */
    public static final UnsignedType2 f22580k;

    /* renamed from: l */
    public static final UnsignedType2 f22581l;

    /* renamed from: m */
    public static final UnsignedType2 f22582m;

    /* renamed from: n */
    public static final /* synthetic */ UnsignedType2[] f22583n;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId classIdFromString = ClassId.fromString("kotlin/UByte");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(\"kotlin/UByte\")");
        UnsignedType2 unsignedType2 = new UnsignedType2("UBYTE", 0, classIdFromString);
        f22579j = unsignedType2;
        ClassId classIdFromString2 = ClassId.fromString("kotlin/UShort");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString2, "fromString(\"kotlin/UShort\")");
        UnsignedType2 unsignedType22 = new UnsignedType2("USHORT", 1, classIdFromString2);
        f22580k = unsignedType22;
        ClassId classIdFromString3 = ClassId.fromString("kotlin/UInt");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString3, "fromString(\"kotlin/UInt\")");
        UnsignedType2 unsignedType23 = new UnsignedType2("UINT", 2, classIdFromString3);
        f22581l = unsignedType23;
        ClassId classIdFromString4 = ClassId.fromString("kotlin/ULong");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString4, "fromString(\"kotlin/ULong\")");
        UnsignedType2 unsignedType24 = new UnsignedType2("ULONG", 3, classIdFromString4);
        f22582m = unsignedType24;
        f22583n = new UnsignedType2[]{unsignedType2, unsignedType22, unsignedType23, unsignedType24};
    }

    public UnsignedType2(String str, int i, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new ClassId(classId.getPackageFqName(), Name.identifier(Intrinsics3.stringPlus(shortClassName.asString(), "Array")));
    }

    public static UnsignedType2 valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (UnsignedType2) Enum.valueOf(UnsignedType2.class, str);
    }

    public static UnsignedType2[] values() {
        UnsignedType2[] unsignedType2Arr = f22583n;
        UnsignedType2[] unsignedType2Arr2 = new UnsignedType2[unsignedType2Arr.length];
        System.arraycopy(unsignedType2Arr, 0, unsignedType2Arr2, 0, unsignedType2Arr.length);
        return unsignedType2Arr2;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
