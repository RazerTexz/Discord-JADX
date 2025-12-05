package p007b.p225i.p361c.p369m.p370d.p373k;

import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.u */
/* loaded from: classes3.dex */
public class C4657u implements C4663x.g {

    /* renamed from: a */
    public final /* synthetic */ String f12395a;

    /* renamed from: b */
    public final /* synthetic */ String f12396b;

    /* renamed from: c */
    public final /* synthetic */ long f12397c;

    public C4657u(C4663x c4663x, String str, String str2, long j) {
        this.f12395a = str;
        this.f12396b = str2;
        this.f12397c = j;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* renamed from: a */
    public void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = this.f12395a;
        String str2 = this.f12396b;
        long j = this.f12397c;
        ByteString2 byteString2 = SessionProtobufHelper.f12694a;
        codedOutputStream2.m6649l(1, ByteString2.m6637a(str2));
        codedOutputStream2.m6649l(2, ByteString2.m6637a(str));
        codedOutputStream2.m6656t(3, j);
    }
}
