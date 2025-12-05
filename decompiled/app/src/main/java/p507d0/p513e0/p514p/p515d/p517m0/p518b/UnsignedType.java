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
/* renamed from: d0.e0.p.d.m0.b.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class UnsignedType {

    /* renamed from: j */
    public static final UnsignedType f22574j;

    /* renamed from: k */
    public static final UnsignedType f22575k;

    /* renamed from: l */
    public static final UnsignedType f22576l;

    /* renamed from: m */
    public static final UnsignedType f22577m;

    /* renamed from: n */
    public static final /* synthetic */ UnsignedType[] f22578n;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId classIdFromString = ClassId.fromString("kotlin/UByteArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(\"kotlin/UByteArray\")");
        UnsignedType unsignedType = new UnsignedType("UBYTEARRAY", 0, classIdFromString);
        f22574j = unsignedType;
        ClassId classIdFromString2 = ClassId.fromString("kotlin/UShortArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString2, "fromString(\"kotlin/UShortArray\")");
        UnsignedType unsignedType2 = new UnsignedType("USHORTARRAY", 1, classIdFromString2);
        f22575k = unsignedType2;
        ClassId classIdFromString3 = ClassId.fromString("kotlin/UIntArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString3, "fromString(\"kotlin/UIntArray\")");
        UnsignedType unsignedType3 = new UnsignedType("UINTARRAY", 2, classIdFromString3);
        f22576l = unsignedType3;
        ClassId classIdFromString4 = ClassId.fromString("kotlin/ULongArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString4, "fromString(\"kotlin/ULongArray\")");
        UnsignedType unsignedType4 = new UnsignedType("ULONGARRAY", 3, classIdFromString4);
        f22577m = unsignedType4;
        f22578n = new UnsignedType[]{unsignedType, unsignedType2, unsignedType3, unsignedType4};
    }

    public UnsignedType(String str, int i, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    public static UnsignedType valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        UnsignedType[] unsignedTypeArr = f22578n;
        UnsignedType[] unsignedTypeArr2 = new UnsignedType[unsignedTypeArr.length];
        System.arraycopy(unsignedTypeArr, 0, unsignedTypeArr2, 0, unsignedTypeArr.length);
        return unsignedTypeArr2;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
