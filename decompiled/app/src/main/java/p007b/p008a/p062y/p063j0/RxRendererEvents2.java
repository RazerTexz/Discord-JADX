package p007b.p008a.p062y.p063j0;

import android.graphics.Point;
import p007b.p008a.p062y.p063j0.RxRendererEvents;
import p637j0.p641k.Func1;

/* compiled from: RxRendererEvents.kt */
/* renamed from: b.a.y.j0.f, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxRendererEvents2<T, R> implements Func1<RxRendererEvents.a, Point> {

    /* renamed from: j */
    public static final RxRendererEvents2 f2034j = new RxRendererEvents2();

    @Override // p637j0.p641k.Func1
    public Point call(RxRendererEvents.a aVar) {
        RxRendererEvents.a aVar2 = aVar;
        if (aVar2 == null) {
            return null;
        }
        int i = aVar2.f2033c;
        return (i == -180 || i == 0 || i == 180) ? new Point(aVar2.f2031a, aVar2.f2032b) : new Point(aVar2.f2032b, aVar2.f2031a);
    }
}
