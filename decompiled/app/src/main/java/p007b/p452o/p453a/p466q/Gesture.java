package p007b.p452o.p453a.p466q;

import androidx.annotation.NonNull;

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
/* compiled from: Gesture.java */
/* renamed from: b.o.a.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Gesture {

    /* renamed from: j */
    public static final Gesture f14066j;

    /* renamed from: k */
    public static final Gesture f14067k;

    /* renamed from: l */
    public static final Gesture f14068l;

    /* renamed from: m */
    public static final Gesture f14069m;

    /* renamed from: n */
    public static final Gesture f14070n;

    /* renamed from: o */
    public static final /* synthetic */ Gesture[] f14071o;
    private GestureType type;

    static {
        GestureType gestureType = GestureType.CONTINUOUS;
        Gesture gesture = new Gesture("PINCH", 0, gestureType);
        f14066j = gesture;
        GestureType gestureType2 = GestureType.ONE_SHOT;
        Gesture gesture2 = new Gesture("TAP", 1, gestureType2);
        f14067k = gesture2;
        Gesture gesture3 = new Gesture("LONG_TAP", 2, gestureType2);
        f14068l = gesture3;
        Gesture gesture4 = new Gesture("SCROLL_HORIZONTAL", 3, gestureType);
        f14069m = gesture4;
        Gesture gesture5 = new Gesture("SCROLL_VERTICAL", 4, gestureType);
        f14070n = gesture5;
        f14071o = new Gesture[]{gesture, gesture2, gesture3, gesture4, gesture5};
    }

    public Gesture(@NonNull String str, int i, GestureType gestureType) {
        this.type = gestureType;
    }

    public static Gesture valueOf(String str) {
        return (Gesture) Enum.valueOf(Gesture.class, str);
    }

    public static Gesture[] values() {
        return (Gesture[]) f14071o.clone();
    }

    /* renamed from: f */
    public boolean m7388f(@NonNull GestureAction gestureAction) {
        return gestureAction == GestureAction.f14072j || gestureAction.m7390g() == this.type;
    }
}
