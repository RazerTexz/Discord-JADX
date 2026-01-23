package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'l' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: b.i.a.f.h.l.p7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class EnumC3789p7 {

    /* JADX INFO: renamed from: A */
    public static final EnumC3789p7 f10199A;

    /* JADX INFO: renamed from: B */
    public static final /* synthetic */ EnumC3789p7[] f10200B;

    /* JADX INFO: renamed from: j */
    public static final EnumC3789p7 f10201j;

    /* JADX INFO: renamed from: k */
    public static final EnumC3789p7 f10202k;

    /* JADX INFO: renamed from: l */
    public static final EnumC3789p7 f10203l;

    /* JADX INFO: renamed from: m */
    public static final EnumC3789p7 f10204m;

    /* JADX INFO: renamed from: n */
    public static final EnumC3789p7 f10205n;

    /* JADX INFO: renamed from: o */
    public static final EnumC3789p7 f10206o;

    /* JADX INFO: renamed from: p */
    public static final EnumC3789p7 f10207p;

    /* JADX INFO: renamed from: q */
    public static final EnumC3789p7 f10208q;

    /* JADX INFO: renamed from: r */
    public static final EnumC3789p7 f10209r;

    /* JADX INFO: renamed from: s */
    public static final EnumC3789p7 f10210s;

    /* JADX INFO: renamed from: t */
    public static final EnumC3789p7 f10211t;

    /* JADX INFO: renamed from: u */
    public static final EnumC3789p7 f10212u;

    /* JADX INFO: renamed from: v */
    public static final EnumC3789p7 f10213v;

    /* JADX INFO: renamed from: w */
    public static final EnumC3789p7 f10214w;

    /* JADX INFO: renamed from: x */
    public static final EnumC3789p7 f10215x;

    /* JADX INFO: renamed from: y */
    public static final EnumC3789p7 f10216y;

    /* JADX INFO: renamed from: z */
    public static final EnumC3789p7 f10217z;
    private final EnumC3880w7 zzs;
    private final int zzt;

    static {
        EnumC3789p7 enumC3789p7 = new EnumC3789p7("DOUBLE", 0, EnumC3880w7.DOUBLE, 1);
        f10201j = enumC3789p7;
        EnumC3789p7 enumC3789p72 = new EnumC3789p7("FLOAT", 1, EnumC3880w7.FLOAT, 5);
        f10202k = enumC3789p72;
        EnumC3880w7 enumC3880w7 = EnumC3880w7.LONG;
        EnumC3789p7 enumC3789p73 = new EnumC3789p7("INT64", 2, enumC3880w7, 0);
        f10203l = enumC3789p73;
        EnumC3789p7 enumC3789p74 = new EnumC3789p7("UINT64", 3, enumC3880w7, 0);
        f10204m = enumC3789p74;
        EnumC3880w7 enumC3880w72 = EnumC3880w7.INT;
        EnumC3789p7 enumC3789p75 = new EnumC3789p7("INT32", 4, enumC3880w72, 0);
        f10205n = enumC3789p75;
        EnumC3789p7 enumC3789p76 = new EnumC3789p7("FIXED64", 5, enumC3880w7, 1);
        f10206o = enumC3789p76;
        EnumC3789p7 enumC3789p77 = new EnumC3789p7("FIXED32", 6, enumC3880w72, 5);
        f10207p = enumC3789p77;
        EnumC3789p7 enumC3789p78 = new EnumC3789p7("BOOL", 7, EnumC3880w7.BOOLEAN, 0);
        f10208q = enumC3789p78;
        C3828s7 c3828s7 = new C3828s7("STRING", EnumC3880w7.STRING);
        f10209r = c3828s7;
        EnumC3880w7 enumC3880w73 = EnumC3880w7.MESSAGE;
        C3815r7 c3815r7 = new C3815r7("GROUP", enumC3880w73);
        f10210s = c3815r7;
        C3854u7 c3854u7 = new C3854u7("MESSAGE", enumC3880w73);
        f10211t = c3854u7;
        C3841t7 c3841t7 = new C3841t7("BYTES", EnumC3880w7.BYTE_STRING);
        f10212u = c3841t7;
        EnumC3789p7 enumC3789p79 = new EnumC3789p7("UINT32", 12, enumC3880w72, 0);
        f10213v = enumC3789p79;
        EnumC3789p7 enumC3789p710 = new EnumC3789p7("ENUM", 13, EnumC3880w7.ENUM, 0);
        f10214w = enumC3789p710;
        EnumC3789p7 enumC3789p711 = new EnumC3789p7("SFIXED32", 14, enumC3880w72, 5);
        f10215x = enumC3789p711;
        EnumC3789p7 enumC3789p712 = new EnumC3789p7("SFIXED64", 15, enumC3880w7, 1);
        f10216y = enumC3789p712;
        EnumC3789p7 enumC3789p713 = new EnumC3789p7("SINT32", 16, enumC3880w72, 0);
        f10217z = enumC3789p713;
        EnumC3789p7 enumC3789p714 = new EnumC3789p7("SINT64", 17, enumC3880w7, 0);
        f10199A = enumC3789p714;
        f10200B = new EnumC3789p7[]{enumC3789p7, enumC3789p72, enumC3789p73, enumC3789p74, enumC3789p75, enumC3789p76, enumC3789p77, enumC3789p78, c3828s7, c3815r7, c3854u7, c3841t7, enumC3789p79, enumC3789p710, enumC3789p711, enumC3789p712, enumC3789p713, enumC3789p714};
    }

    public EnumC3789p7(String str, int i, EnumC3880w7 enumC3880w7, int i2) {
        this.zzs = enumC3880w7;
        this.zzt = i2;
    }

    public static EnumC3789p7[] values() {
        return (EnumC3789p7[]) f10200B.clone();
    }

    /* JADX INFO: renamed from: f */
    public final EnumC3880w7 m5180f() {
        return this.zzs;
    }

    public EnumC3789p7(String str, int i, EnumC3880w7 enumC3880w7, int i2, C3802q7 c3802q7) {
        this.zzs = enumC3880w7;
        this.zzt = i2;
    }
}
