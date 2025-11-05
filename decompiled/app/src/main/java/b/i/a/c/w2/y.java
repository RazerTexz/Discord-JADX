package b.i.a.c.w2;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.w2.a0;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DummyExoMediaDrm.java */
@RequiresApi(18)
/* loaded from: classes3.dex */
public final class y implements a0 {
    @Override // b.i.a.c.w2.a0
    public Map<String, String> a(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public a0.d b() {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public b.i.a.c.v2.b c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public byte[] d() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // b.i.a.c.w2.a0
    public boolean e(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public void f(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public void g(byte[] bArr) {
    }

    @Override // b.i.a.c.w2.a0
    public void h(@Nullable a0.b bVar) {
    }

    @Override // b.i.a.c.w2.a0
    @Nullable
    public byte[] i(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public void j(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public a0.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // b.i.a.c.w2.a0
    public int l() {
        return 1;
    }

    @Override // b.i.a.c.w2.a0
    public void release() {
    }
}
