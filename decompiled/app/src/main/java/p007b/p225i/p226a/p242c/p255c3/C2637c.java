package p007b.p225i.p226a.p242c.p255c3;

import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: b.i.a.c.c3.c */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2637c implements Comparator {

    /* renamed from: j */
    public static final /* synthetic */ C2637c f6179j = new C2637c();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        Integer num2 = (Integer) obj2;
        int[] iArr = DefaultTrackSelector.f6192b;
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }
}
