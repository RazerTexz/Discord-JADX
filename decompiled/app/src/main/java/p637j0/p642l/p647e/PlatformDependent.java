package p637j0.p642l.p647e;

/* compiled from: PlatformDependent.java */
/* renamed from: j0.l.e.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlatformDependent {

    /* renamed from: a */
    public static final int f27281a;

    /* renamed from: b */
    public static final boolean f27282b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        f27281a = iIntValue;
        f27282b = iIntValue != 0;
    }
}
