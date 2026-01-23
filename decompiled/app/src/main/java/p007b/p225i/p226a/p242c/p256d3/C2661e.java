package p007b.p225i.p226a.p242c.p256d3;

import java.util.Comparator;
import p007b.p225i.p226a.p242c.p256d3.SpannedToHtmlConverter;

/* JADX INFO: renamed from: b.i.a.c.d3.e */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2661e implements Comparator {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ C2661e f6339j = new C2661e();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SpannedToHtmlConverter.c cVar = (SpannedToHtmlConverter.c) obj;
        SpannedToHtmlConverter.c cVar2 = (SpannedToHtmlConverter.c) obj2;
        int iCompare = Integer.compare(cVar2.f6361b, cVar.f6361b);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = cVar.f6362c.compareTo(cVar2.f6362c);
        return iCompareTo != 0 ? iCompareTo : cVar.f6363d.compareTo(cVar2.f6363d);
    }
}
