package p007b.p225i.p226a.p242c.p266w2;

import android.media.UnsupportedSchemeException;
import android.util.Log;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.util.UUID;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;

/* JADX INFO: renamed from: b.i.a.c.w2.n */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2983n implements ExoMediaDrm.c {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C2983n f8004a = new C2983n();

    @Override // p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm.c
    /* JADX INFO: renamed from: a */
    public final ExoMediaDrm mo3581a(UUID uuid) {
        int i = FrameworkMediaDrm.f7977a;
        try {
            try {
                return new FrameworkMediaDrm(uuid);
            } catch (UnsupportedDrmException unused) {
                String strValueOf = String.valueOf(uuid);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
                sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
                sb.append(strValueOf);
                sb.append(".");
                Log.e("FrameworkMediaDrm", sb.toString());
                return new DummyExoMediaDrm();
            }
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }
}
