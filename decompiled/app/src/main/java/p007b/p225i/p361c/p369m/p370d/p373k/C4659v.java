package p007b.p225i.p361c.p369m.p370d.p373k;

import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.v */
/* loaded from: classes3.dex */
public class C4659v implements C4663x.g {

    /* renamed from: a */
    public final /* synthetic */ String f12401a;

    /* renamed from: b */
    public final /* synthetic */ String f12402b;

    /* renamed from: c */
    public final /* synthetic */ String f12403c;

    /* renamed from: d */
    public final /* synthetic */ String f12404d;

    /* renamed from: e */
    public final /* synthetic */ int f12405e;

    /* renamed from: f */
    public final /* synthetic */ C4663x f12406f;

    public C4659v(C4663x c4663x, String str, String str2, String str3, String str4, int i) {
        this.f12406f = c4663x;
        this.f12401a = str;
        this.f12402b = str2;
        this.f12403c = str3;
        this.f12404d = str4;
        this.f12405e = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* renamed from: a */
    public void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.f12401a;
        String str2 = this.f12402b;
        String str3 = this.f12403c;
        String str4 = this.f12404d;
        int i = this.f12405e;
        String str5 = this.f12406f.f12445y;
        ByteString2 byteString2 = SessionProtobufHelper.f12694a;
        ByteString2 byteString2M6637a = ByteString2.m6637a(str);
        ByteString2 byteString2M6637a2 = ByteString2.m6637a(str2);
        ByteString2 byteString2M6637a3 = ByteString2.m6637a(str3);
        ByteString2 byteString2M6637a4 = ByteString2.m6637a(str4);
        ByteString2 byteString2M6637a5 = str5 != null ? ByteString2.m6637a(str5) : null;
        codedOutputStream2.m6654r(7, 2);
        int iM6640b = CodedOutputStream2.m6640b(6, byteString2M6637a4) + CodedOutputStream2.m6640b(3, byteString2M6637a3) + CodedOutputStream2.m6640b(2, byteString2M6637a2) + CodedOutputStream2.m6640b(1, byteString2M6637a) + 0;
        if (byteString2M6637a5 != null) {
            iM6640b = CodedOutputStream2.m6640b(9, byteString2M6637a5) + CodedOutputStream2.m6640b(8, SessionProtobufHelper.f12695b) + iM6640b;
        }
        codedOutputStream2.m6652o(CodedOutputStream2.m6641c(10, i) + iM6640b);
        codedOutputStream2.m6649l(1, byteString2M6637a);
        codedOutputStream2.m6649l(2, byteString2M6637a2);
        codedOutputStream2.m6649l(3, byteString2M6637a3);
        codedOutputStream2.m6649l(6, byteString2M6637a4);
        if (byteString2M6637a5 != null) {
            codedOutputStream2.m6649l(8, SessionProtobufHelper.f12695b);
            codedOutputStream2.m6649l(9, byteString2M6637a5);
        }
        codedOutputStream2.m6650m(10, i);
    }
}
