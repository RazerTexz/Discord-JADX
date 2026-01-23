package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Build;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;

/* JADX INFO: renamed from: b.i.c.m.d.k.y */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4665y implements C4663x.g {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f12460a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f12461b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f12462c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f12463d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f12464e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f12465f;

    public C4665y(C4663x c4663x, int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3) {
        this.f12460a = i;
        this.f12461b = i2;
        this.f12462c = j;
        this.f12463d = j2;
        this.f12464e = z2;
        this.f12465f = i3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* JADX INFO: renamed from: a */
    public void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception {
        int i = this.f12460a;
        String str = Build.MODEL;
        int i2 = this.f12461b;
        long j = this.f12462c;
        long j2 = this.f12463d;
        boolean z2 = this.f12464e;
        int i3 = this.f12465f;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        ByteString2 byteString2M6666j = SessionProtobufHelper.m6666j(str);
        ByteString2 byteString2M6666j2 = SessionProtobufHelper.m6666j(str3);
        ByteString2 byteString2M6666j3 = SessionProtobufHelper.m6666j(str2);
        codedOutputStream2.m6654r(9, 2);
        int iM6641c = CodedOutputStream2.m6641c(3, i) + 0;
        int iM6640b = byteString2M6666j == null ? 0 : CodedOutputStream2.m6640b(4, byteString2M6666j);
        int iM6644f = CodedOutputStream2.m6644f(5, i2);
        int iM6645h = CodedOutputStream2.m6645h(6, j);
        int iM6645h2 = CodedOutputStream2.m6645h(7, j2);
        codedOutputStream2.m6652o(CodedOutputStream2.m6644f(12, i3) + CodedOutputStream2.m6639a(10, z2) + iM6645h2 + iM6645h + iM6644f + iM6641c + iM6640b + (byteString2M6666j3 == null ? 0 : CodedOutputStream2.m6640b(13, byteString2M6666j3)) + (byteString2M6666j2 == null ? 0 : CodedOutputStream2.m6640b(14, byteString2M6666j2)));
        codedOutputStream2.m6650m(3, i);
        codedOutputStream2.m6649l(4, byteString2M6666j);
        codedOutputStream2.m6655s(5, i2);
        codedOutputStream2.m6656t(6, j);
        codedOutputStream2.m6656t(7, j2);
        codedOutputStream2.m6648k(10, z2);
        codedOutputStream2.m6655s(12, i3);
        if (byteString2M6666j3 != null) {
            codedOutputStream2.m6649l(13, byteString2M6666j3);
        }
        if (byteString2M6666j2 != null) {
            codedOutputStream2.m6649l(14, byteString2M6666j2);
        }
    }
}
