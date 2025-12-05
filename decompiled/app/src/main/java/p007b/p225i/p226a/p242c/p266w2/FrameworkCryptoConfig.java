package p007b.p225i.p226a.p242c.p266w2;

import java.util.UUID;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;

/* compiled from: FrameworkCryptoConfig.java */
/* renamed from: b.i.a.c.w2.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class FrameworkCryptoConfig implements CryptoConfig {

    /* renamed from: a */
    public static final boolean f7972a;

    /* renamed from: b */
    public final UUID f7973b;

    /* renamed from: c */
    public final byte[] f7974c;

    /* renamed from: d */
    public final boolean f7975d;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    static {
        boolean z2;
        if ("Amazon".equals(Util2.f6710c)) {
            String str = Util2.f6711d;
            z2 = "AFTM".equals(str) || "AFTB".equals(str);
        }
        f7972a = z2;
    }

    public FrameworkCryptoConfig(UUID uuid, byte[] bArr, boolean z2) {
        this.f7973b = uuid;
        this.f7974c = bArr;
        this.f7975d = z2;
    }
}
