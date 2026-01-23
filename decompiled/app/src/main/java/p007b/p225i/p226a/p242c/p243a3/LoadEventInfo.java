package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;

/* JADX INFO: renamed from: b.i.a.c.a3.t, reason: use source file name */
/* JADX INFO: compiled from: LoadEventInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadEventInfo {

    /* JADX INFO: renamed from: a */
    public static final AtomicLong f5703a = new AtomicLong();

    /* JADX INFO: renamed from: b */
    public final Map<String, List<String>> f5704b;

    public LoadEventInfo(long j, DataSpec dataSpec, long j2) {
        Uri uri = dataSpec.f6542a;
        this.f5704b = Collections.emptyMap();
    }

    public LoadEventInfo(long j, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.f5704b = map;
    }
}
