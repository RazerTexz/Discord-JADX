package p007b.p225i.p226a.p242c.p266w2;

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
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;

/* compiled from: ExoMediaDrm.java */
/* renamed from: b.i.a.c.w2.a0, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExoMediaDrm {

    /* compiled from: ExoMediaDrm.java */
    /* renamed from: b.i.a.c.w2.a0$a */
    public static final class a {

        /* renamed from: a */
        public final byte[] f7967a;

        /* renamed from: b */
        public final String f7968b;

        public a(byte[] bArr, String str, int i) {
            this.f7967a = bArr;
            this.f7968b = str;
        }
    }

    /* compiled from: ExoMediaDrm.java */
    /* renamed from: b.i.a.c.w2.a0$b */
    public interface b {
    }

    /* compiled from: ExoMediaDrm.java */
    /* renamed from: b.i.a.c.w2.a0$c */
    public interface c {
        /* renamed from: a */
        ExoMediaDrm mo3581a(UUID uuid);
    }

    /* compiled from: ExoMediaDrm.java */
    /* renamed from: b.i.a.c.w2.a0$d */
    public static final class d {

        /* renamed from: a */
        public final byte[] f7969a;

        /* renamed from: b */
        public final String f7970b;

        public d(byte[] bArr, String str) {
            this.f7969a = bArr;
            this.f7970b = str;
        }
    }

    /* renamed from: a */
    Map<String, String> mo3569a(byte[] bArr);

    /* renamed from: b */
    d mo3570b();

    /* renamed from: c */
    CryptoConfig mo3571c(byte[] bArr) throws MediaCryptoException;

    /* renamed from: d */
    byte[] mo3572d() throws MediaDrmException;

    /* renamed from: e */
    boolean mo3573e(byte[] bArr, String str);

    /* renamed from: f */
    void mo3574f(byte[] bArr, byte[] bArr2);

    /* renamed from: g */
    void mo3575g(byte[] bArr);

    /* renamed from: h */
    void mo3576h(@Nullable b bVar);

    @Nullable
    /* renamed from: i */
    byte[] mo3577i(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    /* renamed from: j */
    void mo3578j(byte[] bArr) throws DeniedByServerException;

    /* renamed from: k */
    a mo3579k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    /* renamed from: l */
    int mo3580l();

    void release();
}
