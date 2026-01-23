package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Build;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;

/* JADX INFO: renamed from: b.i.c.m.d.k.w */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4661w implements C4663x.g {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f12414a;

    public C4661w(C4663x c4663x, String str, String str2, boolean z2) {
        this.f12414a = z2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* JADX INFO: renamed from: a */
    public void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception {
        String str = Build.VERSION.RELEASE;
        String str2 = Build.VERSION.CODENAME;
        boolean z2 = this.f12414a;
        ByteString2 byteString2 = SessionProtobufHelper.f12694a;
        ByteString2 byteString2M6637a = ByteString2.m6637a(str);
        ByteString2 byteString2M6637a2 = ByteString2.m6637a(str2);
        codedOutputStream2.m6654r(8, 2);
        codedOutputStream2.m6652o(CodedOutputStream2.m6639a(4, z2) + CodedOutputStream2.m6640b(3, byteString2M6637a2) + CodedOutputStream2.m6640b(2, byteString2M6637a) + CodedOutputStream2.m6641c(1, 3) + 0);
        codedOutputStream2.m6650m(1, 3);
        codedOutputStream2.m6649l(2, byteString2M6637a);
        codedOutputStream2.m6649l(3, byteString2M6637a2);
        codedOutputStream2.m6648k(4, z2);
    }
}
