package p007b.p225i.p226a.p242c.p265v2;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: CryptoInfo.java */
/* renamed from: b.i.a.c.v2.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class CryptoInfo {

    /* renamed from: a */
    @Nullable
    public byte[] f7902a;

    /* renamed from: b */
    @Nullable
    public byte[] f7903b;

    /* renamed from: c */
    public int f7904c;

    /* renamed from: d */
    @Nullable
    public int[] f7905d;

    /* renamed from: e */
    @Nullable
    public int[] f7906e;

    /* renamed from: f */
    public int f7907f;

    /* renamed from: g */
    public int f7908g;

    /* renamed from: h */
    public int f7909h;

    /* renamed from: i */
    public final MediaCodec.CryptoInfo f7910i;

    /* renamed from: j */
    @Nullable
    public final b f7911j;

    /* compiled from: CryptoInfo.java */
    @RequiresApi(24)
    /* renamed from: b.i.a.c.v2.c$b */
    public static final class b {

        /* renamed from: a */
        public final MediaCodec.CryptoInfo f7912a;

        /* renamed from: b */
        public final MediaCodec.CryptoInfo.Pattern f7913b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this.f7912a = cryptoInfo;
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f7910i = cryptoInfo;
        this.f7911j = Util2.f6708a >= 24 ? new b(cryptoInfo, null) : null;
    }
}
