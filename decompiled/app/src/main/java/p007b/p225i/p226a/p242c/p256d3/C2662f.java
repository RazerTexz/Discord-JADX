package p007b.p225i.p226a.p242c.p256d3;

import java.util.Comparator;
import p007b.p225i.p226a.p242c.p256d3.SpannedToHtmlConverter;

/* compiled from: lambda */
/* renamed from: b.i.a.c.d3.f */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2662f implements Comparator {

    /* renamed from: j */
    public static final /* synthetic */ C2662f f6340j = new C2662f();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SpannedToHtmlConverter.c cVar = (SpannedToHtmlConverter.c) obj;
        SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
        int iCompare = Integer.compare(cVar2.f6360a, cVar.f6360a);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = cVar2.f6362c.compareTo(cVar.f6362c);
        return iCompareTo != 0 ? iCompareTo : cVar2.f6363d.compareTo(cVar.f6363d);
    }
}
