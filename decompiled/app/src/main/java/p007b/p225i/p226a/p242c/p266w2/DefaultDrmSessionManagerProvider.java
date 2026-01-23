package p007b.p225i.p226a.p242c.p266w2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.p257e3.DefaultHttpDataSource;
import p007b.p225i.p226a.p242c.p257e3.DefaultLoadErrorHandlingPolicy;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.UnmodifiableIterator;

/* JADX INFO: renamed from: b.i.a.c.w2.r, reason: use source file name */
/* JADX INFO: compiled from: DefaultDrmSessionManagerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDrmSessionManagerProvider {

    /* JADX INFO: renamed from: a */
    public final Object f8009a = new Object();

    /* JADX INFO: renamed from: b */
    @GuardedBy("lock")
    public MediaItem2.f f8010b;

    /* JADX INFO: renamed from: c */
    @GuardedBy("lock")
    public DrmSessionManager2 f8011c;

    @RequiresApi(18)
    /* JADX INFO: renamed from: a */
    public final DrmSessionManager2 m3586a(MediaItem2.f fVar) {
        DefaultHttpDataSource.b bVar = new DefaultHttpDataSource.b();
        bVar.f6623b = null;
        Uri uri = fVar.f7291b;
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri == null ? null : uri.toString(), fVar.f7295f, bVar);
        UnmodifiableIterator<Map.Entry<String, String>> unmodifiableIteratorMo6251j = fVar.f7292c.m6274e().mo6251j();
        while (unmodifiableIteratorMo6251j.hasNext()) {
            Map.Entry<String, String> next = unmodifiableIteratorMo6251j.next();
            String key = next.getKey();
            String value = next.getValue();
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            synchronized (httpMediaDrmCallback.f7985d) {
                httpMediaDrmCallback.f7985d.put(key, value);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = C.f8024d;
        int i = FrameworkMediaDrm.f7977a;
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        UUID uuid2 = fVar.f7290a;
        C2983n c2983n = C2983n.f8004a;
        Objects.requireNonNull(uuid2);
        boolean z2 = fVar.f7293d;
        boolean z3 = fVar.f7294e;
        int[] iArrM4333q1 = C3404f.m4333q1(fVar.f7296g);
        for (int i2 : iArrM4333q1) {
            boolean z4 = true;
            if (i2 != 2 && i2 != 1) {
                z4 = false;
            }
            AnimatableValueParser.m531j(z4);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, c2983n, httpMediaDrmCallback, map, z2, (int[]) iArrM4333q1.clone(), z3, defaultLoadErrorHandlingPolicy, 300000L, null);
        byte[] bArr = fVar.f7297h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        AnimatableValueParser.m426D(defaultDrmSessionManager.f19826m.isEmpty());
        defaultDrmSessionManager.f19835v = 0;
        defaultDrmSessionManager.f19836w = bArrCopyOf;
        return defaultDrmSessionManager;
    }
}
