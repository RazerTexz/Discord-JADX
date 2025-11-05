package b.i.a.c.w2;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: ExoMediaDrm.java */
/* loaded from: classes3.dex */
public interface a0 {

    /* compiled from: ExoMediaDrm.java */
    public static final class a {
        public final byte[] a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1148b;

        public a(byte[] bArr, String str, int i) {
            this.a = bArr;
            this.f1148b = str;
        }
    }

    /* compiled from: ExoMediaDrm.java */
    public interface b {
    }

    /* compiled from: ExoMediaDrm.java */
    public interface c {
        a0 a(UUID uuid);
    }

    /* compiled from: ExoMediaDrm.java */
    public static final class d {
        public final byte[] a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1149b;

        public d(byte[] bArr, String str) {
            this.a = bArr;
            this.f1149b = str;
        }
    }

    Map<String, String> a(byte[] bArr);

    d b();

    b.i.a.c.v2.b c(byte[] bArr) throws MediaCryptoException;

    byte[] d() throws MediaDrmException;

    boolean e(byte[] bArr, String str);

    void f(byte[] bArr, byte[] bArr2);

    void g(byte[] bArr);

    void h(@Nullable b bVar);

    @Nullable
    byte[] i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void j(byte[] bArr) throws DeniedByServerException;

    a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    int l();

    void release();
}
