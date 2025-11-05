package b.o.a.q;

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
/* loaded from: classes3.dex */
public final class a {
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final /* synthetic */ a[] o;
    private d type;

    static {
        d dVar = d.CONTINUOUS;
        a aVar = new a("PINCH", 0, dVar);
        j = aVar;
        d dVar2 = d.ONE_SHOT;
        a aVar2 = new a("TAP", 1, dVar2);
        k = aVar2;
        a aVar3 = new a("LONG_TAP", 2, dVar2);
        l = aVar3;
        a aVar4 = new a("SCROLL_HORIZONTAL", 3, dVar);
        m = aVar4;
        a aVar5 = new a("SCROLL_VERTICAL", 4, dVar);
        n = aVar5;
        o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5};
    }

    public a(@NonNull String str, int i, d dVar) {
        this.type = dVar;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) o.clone();
    }

    public boolean f(@NonNull b bVar) {
        return bVar == b.j || bVar.g() == this.type;
    }
}
