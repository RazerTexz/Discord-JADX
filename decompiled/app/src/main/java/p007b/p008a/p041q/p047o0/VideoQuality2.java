package p007b.p008a.p041q.p047o0;

import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: VideoQuality.kt */
/* renamed from: b.a.q.o0.f, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoQuality2 extends Lambda implements Function2<Long, Long, Long> {

    /* renamed from: j */
    public static final VideoQuality2 f1867j = new VideoQuality2();

    public VideoQuality2() {
        super(2);
    }

    /* renamed from: a */
    public final long m363a(long j, long j2) {
        return j2 > j ? j : j - j2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Long invoke(Long l, Long l2) {
        return Long.valueOf(m363a(l.longValue(), l2.longValue()));
    }
}
