package p007b.p445m.p446a;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p507d0.p580t.Collections2;

/* compiled from: DefaultParam.kt */
/* renamed from: b.m.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultParam {

    /* renamed from: b */
    public static final long f13640b;

    /* renamed from: c */
    public static final long f13641c;

    /* renamed from: d */
    public static final long f13642d;

    /* renamed from: e */
    public static final DefaultParam f13643e = new DefaultParam();

    /* renamed from: a */
    public static final List<String> f13639a = Collections2.listOf((Object[]) new String[]{"2.us.pool.ntp.org", "1.us.pool.ntp.org", "0.us.pool.ntp.org"});

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f13640b = timeUnit.toMillis(1L);
        f13641c = timeUnit.toMillis(1L);
        f13642d = TimeUnit.SECONDS.toMillis(6L);
    }
}
