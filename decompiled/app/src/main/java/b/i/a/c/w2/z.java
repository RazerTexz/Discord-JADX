package b.i.a.c.w2;

import androidx.annotation.Nullable;
import b.i.a.c.w2.s;
import b.i.a.c.x0;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.UUID;

/* compiled from: ErrorStateDrmSession.java */
/* loaded from: classes3.dex */
public final class z implements DrmSession {
    public final DrmSession.DrmSessionException a;

    public z(DrmSession.DrmSessionException drmSessionException) {
        this.a = drmSessionException;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable s.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(@Nullable s.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return x0.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e(String str) {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException f() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public b.i.a.c.v2.b g() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}
