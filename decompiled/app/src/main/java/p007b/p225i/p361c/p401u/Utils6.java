package p007b.p225i.p361c.p401u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;
import p007b.p225i.p361c.p401u.p404q.SystemClock3;

/* JADX INFO: renamed from: b.i.c.u.n, reason: use source file name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Utils6 {

    /* JADX INFO: renamed from: a */
    public static final long f12948a = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: b */
    public static final Pattern f12949b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: c */
    public static Utils6 f12950c;

    /* JADX INFO: renamed from: d */
    public final SystemClock3 f12951d;

    public Utils6(SystemClock3 systemClock3) {
        this.f12951d = systemClock3;
    }

    /* JADX INFO: renamed from: c */
    public static Utils6 m6770c() {
        if (SystemClock3.f13007a == null) {
            SystemClock3.f13007a = new SystemClock3();
        }
        SystemClock3 systemClock3 = SystemClock3.f13007a;
        if (f12950c == null) {
            f12950c = new Utils6(systemClock3);
        }
        return f12950c;
    }

    /* JADX INFO: renamed from: a */
    public long m6771a() {
        Objects.requireNonNull(this.f12951d);
        return System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: b */
    public long m6772b() {
        return TimeUnit.MILLISECONDS.toSeconds(m6771a());
    }

    /* JADX INFO: renamed from: d */
    public boolean m6773d(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.mo6774a())) {
            return true;
        }
        return persistedInstallationEntry.mo6775b() + persistedInstallationEntry.mo6780g() < m6772b() + f12948a;
    }
}
