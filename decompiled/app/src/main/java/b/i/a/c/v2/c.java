package b.i.a.c.v2;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.e0;

/* compiled from: CryptoInfo.java */
/* loaded from: classes3.dex */
public final class c {

    @Nullable
    public byte[] a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f1141b;
    public int c;

    @Nullable
    public int[] d;

    @Nullable
    public int[] e;
    public int f;
    public int g;
    public int h;
    public final MediaCodec.CryptoInfo i;

    @Nullable
    public final b j;

    /* compiled from: CryptoInfo.java */
    @RequiresApi(24)
    public static final class b {
        public final MediaCodec.CryptoInfo a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f1142b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this.a = cryptoInfo;
        }
    }

    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = e0.a >= 24 ? new b(cryptoInfo, null) : null;
    }
}
