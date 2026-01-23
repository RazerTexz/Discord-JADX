package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'k' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: b.i.a.f.h.l.e5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC3639e5 {

    /* JADX INFO: renamed from: j */
    public static final EnumC3639e5 f9902j;

    /* JADX INFO: renamed from: k */
    public static final EnumC3639e5 f9903k;

    /* JADX INFO: renamed from: l */
    public static final EnumC3639e5 f9904l;

    /* JADX INFO: renamed from: m */
    public static final EnumC3639e5 f9905m;

    /* JADX INFO: renamed from: n */
    public static final EnumC3639e5 f9906n;

    /* JADX INFO: renamed from: o */
    public static final EnumC3639e5 f9907o;

    /* JADX INFO: renamed from: p */
    public static final EnumC3639e5 f9908p;

    /* JADX INFO: renamed from: q */
    public static final EnumC3639e5 f9909q;

    /* JADX INFO: renamed from: r */
    public static final EnumC3639e5 f9910r;

    /* JADX INFO: renamed from: s */
    public static final EnumC3639e5 f9911s;

    /* JADX INFO: renamed from: t */
    public static final /* synthetic */ EnumC3639e5[] f9912t;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        EnumC3639e5 enumC3639e5 = new EnumC3639e5("VOID", 0, Void.class, Void.class, null);
        f9902j = enumC3639e5;
        Class cls = Integer.TYPE;
        EnumC3639e5 enumC3639e52 = new EnumC3639e5("INT", 1, cls, Integer.class, 0);
        f9903k = enumC3639e52;
        EnumC3639e5 enumC3639e53 = new EnumC3639e5("LONG", 2, Long.TYPE, Long.class, 0L);
        f9904l = enumC3639e53;
        EnumC3639e5 enumC3639e54 = new EnumC3639e5("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f9905m = enumC3639e54;
        EnumC3639e5 enumC3639e55 = new EnumC3639e5("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f9906n = enumC3639e55;
        EnumC3639e5 enumC3639e56 = new EnumC3639e5("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f9907o = enumC3639e56;
        EnumC3639e5 enumC3639e57 = new EnumC3639e5("STRING", 6, String.class, String.class, "");
        f9908p = enumC3639e57;
        EnumC3639e5 enumC3639e58 = new EnumC3639e5("BYTE_STRING", 7, AbstractC3837t3.class, AbstractC3837t3.class, AbstractC3837t3.f10322j);
        f9909q = enumC3639e58;
        EnumC3639e5 enumC3639e59 = new EnumC3639e5("ENUM", 8, cls, Integer.class, null);
        f9910r = enumC3639e59;
        EnumC3639e5 enumC3639e510 = new EnumC3639e5("MESSAGE", 9, Object.class, Object.class, null);
        f9911s = enumC3639e510;
        f9912t = new EnumC3639e5[]{enumC3639e5, enumC3639e52, enumC3639e53, enumC3639e54, enumC3639e55, enumC3639e56, enumC3639e57, enumC3639e58, enumC3639e59, enumC3639e510};
    }

    public EnumC3639e5(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static EnumC3639e5[] values() {
        return (EnumC3639e5[]) f9912t.clone();
    }

    /* JADX INFO: renamed from: f */
    public final Class<?> m4822f() {
        return this.zzl;
    }
}
