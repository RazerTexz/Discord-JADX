package p007b.p225i.p226a.p242c.p266w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;

/* JADX INFO: renamed from: b.i.a.c.w2.u, reason: use source file name */
/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DrmSessionManager2 {

    /* JADX INFO: renamed from: a */
    public static final DrmSessionManager2 f8017a = new a();

    /* JADX INFO: renamed from: b.i.a.c.w2.u$a */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public class a implements DrmSessionManager2 {
        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void mo3597a() {
            DrmSessionManager.m3595b(this);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
        /* JADX INFO: renamed from: b */
        public /* synthetic */ b mo3598b(Looper looper, DrmSessionEventListener.a aVar, Format2 format2) {
            return DrmSessionManager.m3594a(this, looper, aVar, format2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
        @Nullable
        /* JADX INFO: renamed from: c */
        public DrmSession mo3599c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2) {
            if (format2.f7158z == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
        /* JADX INFO: renamed from: d */
        public int mo3600d(Format2 format2) {
            return format2.f7158z != null ? 1 : 0;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
        public /* synthetic */ void release() {
            DrmSessionManager.m3596c(this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.w2.u$b */
    /* JADX INFO: compiled from: DrmSessionManager.java */
    public interface b {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f8018a = 0;

        void release();
    }

    /* JADX INFO: renamed from: a */
    void mo3597a();

    /* JADX INFO: renamed from: b */
    b mo3598b(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2);

    @Nullable
    /* JADX INFO: renamed from: c */
    DrmSession mo3599c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2);

    /* JADX INFO: renamed from: d */
    int mo3600d(Format2 format2);

    void release();
}
