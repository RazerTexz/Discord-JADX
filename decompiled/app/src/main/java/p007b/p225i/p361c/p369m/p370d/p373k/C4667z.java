package p007b.p225i.p361c.p369m.p370d.p373k;

import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.z */
/* loaded from: classes3.dex */
public class C4667z implements C4663x.g {

    /* renamed from: a */
    public final /* synthetic */ UserMetadata f12467a;

    public C4667z(C4663x c4663x, UserMetadata userMetadata) {
        this.f12467a = userMetadata;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* renamed from: a */
    public void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.f12467a.f12290a;
        ByteString2 byteString2 = SessionProtobufHelper.f12694a;
        if (str == null) {
            str = "";
        }
        ByteString2 byteString2M6637a = ByteString2.m6637a(str);
        SessionProtobufHelper.m6666j(null);
        SessionProtobufHelper.m6666j(null);
        int iM6640b = CodedOutputStream2.m6640b(1, byteString2M6637a) + 0;
        codedOutputStream2.m6654r(6, 2);
        codedOutputStream2.m6652o(iM6640b);
        codedOutputStream2.m6649l(1, byteString2M6637a);
    }
}
