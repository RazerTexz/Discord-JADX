package b.a.y.j0;

import android.graphics.Point;
import b.a.y.j0.e;

/* compiled from: RxRendererEvents.kt */
/* loaded from: classes2.dex */
public final class f<T, R> implements j0.k.b<e.a, Point> {
    public static final f j = new f();

    @Override // j0.k.b
    public Point call(e.a aVar) {
        e.a aVar2 = aVar;
        if (aVar2 == null) {
            return null;
        }
        int i = aVar2.c;
        return (i == -180 || i == 0 || i == 180) ? new Point(aVar2.a, aVar2.f312b) : new Point(aVar2.f312b, aVar2.a);
    }
}
