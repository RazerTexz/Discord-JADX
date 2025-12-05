package p007b.p225i.p226a.p242c.p266w2;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;

/* compiled from: DummyExoMediaDrm.java */
@RequiresApi(18)
/* renamed from: b.i.a.c.w2.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class DummyExoMediaDrm implements ExoMediaDrm {
    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: a */
    public Map<String, String> mo3569a(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: b */
    public ExoMediaDrm.d mo3570b() {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: c */
    public CryptoConfig mo3571c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: d */
    public byte[] mo3572d() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: e */
    public boolean mo3573e(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: f */
    public void mo3574f(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: g */
    public void mo3575g(byte[] bArr) {
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: h */
    public void mo3576h(@Nullable ExoMediaDrm.b bVar) {
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    @Nullable
    /* renamed from: i */
    public byte[] mo3577i(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: j */
    public void mo3578j(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: k */
    public ExoMediaDrm.a mo3579k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    /* renamed from: l */
    public int mo3580l() {
        return 1;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm
    public void release() {
    }
}
