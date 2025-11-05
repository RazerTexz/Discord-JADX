package b.i.a.c.e3.b0;

import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Comparator {
    public static final /* synthetic */ b j = new b();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        long j2 = hVar.o;
        long j3 = hVar2.o;
        return j2 - j3 == 0 ? hVar.f(hVar2) : j2 < j3 ? -1 : 1;
    }
}
