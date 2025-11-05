package com.discord.utilities.system;

import a0.a.a.b;
import b.d.b.a.a;
import d0.g;
import d0.g0.s;
import d0.g0.w;
import d0.y.f;
import d0.z.d.m;
import java.io.File;
import java.util.List;
import kotlin.Lazy;

/* compiled from: ProcfsReader.kt */
/* loaded from: classes2.dex */
public final class ProcfsReader {
    public static final ProcfsReader INSTANCE = new ProcfsReader();

    /* renamed from: pid$delegate, reason: from kotlin metadata */
    private static final Lazy pid = g.lazy(ProcfsReader$pid$2.INSTANCE);
    private static final Stat default = new Stat(0, 0, 0, 0);

    /* compiled from: ProcfsReader.kt */
    public static final /* data */ class Stat {
        private final long rssPages;
        private final long systemTime;
        private final long totalTime;
        private final long userTime;

        public Stat(long j, long j2, long j3, long j4) {
            this.userTime = j;
            this.systemTime = j2;
            this.totalTime = j3;
            this.rssPages = j4;
        }

        public static /* synthetic */ Stat copy$default(Stat stat, long j, long j2, long j3, long j4, int i, Object obj) {
            return stat.copy((i & 1) != 0 ? stat.userTime : j, (i & 2) != 0 ? stat.systemTime : j2, (i & 4) != 0 ? stat.totalTime : j3, (i & 8) != 0 ? stat.rssPages : j4);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserTime() {
            return this.userTime;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSystemTime() {
            return this.systemTime;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTotalTime() {
            return this.totalTime;
        }

        /* renamed from: component4, reason: from getter */
        public final long getRssPages() {
            return this.rssPages;
        }

        public final Stat copy(long userTime, long systemTime, long totalTime, long rssPages) {
            return new Stat(userTime, systemTime, totalTime, rssPages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stat)) {
                return false;
            }
            Stat stat = (Stat) other;
            return this.userTime == stat.userTime && this.systemTime == stat.systemTime && this.totalTime == stat.totalTime && this.rssPages == stat.rssPages;
        }

        public final long getRssPages() {
            return this.rssPages;
        }

        public final long getSystemTime() {
            return this.systemTime;
        }

        public final long getTotalTime() {
            return this.totalTime;
        }

        public final long getUserTime() {
            return this.userTime;
        }

        public int hashCode() {
            return b.a(this.rssPages) + ((b.a(this.totalTime) + ((b.a(this.systemTime) + (b.a(this.userTime) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = a.U("Stat(userTime=");
            sbU.append(this.userTime);
            sbU.append(", systemTime=");
            sbU.append(this.systemTime);
            sbU.append(", totalTime=");
            sbU.append(this.totalTime);
            sbU.append(", rssPages=");
            return a.C(sbU, this.rssPages, ")");
        }
    }

    private ProcfsReader() {
    }

    private final int getPid() {
        return ((Number) pid.getValue()).intValue();
    }

    private final Stat parsePidStats(String input) {
        if (input.length() == 0) {
            return default;
        }
        List listSplit$default = w.split$default((CharSequence) input, new char[]{' '}, false, 0, 6, (Object) null);
        long j = toLong((String) listSplit$default.get(13));
        long j2 = toLong((String) listSplit$default.get(14));
        return new Stat(j, j2, j + j2, toLong((String) listSplit$default.get(23)));
    }

    private final String readFile(File file) {
        try {
            if (file.exists()) {
                return f.readText$default(file, null, 1, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final long toLong(String s2) {
        Long longOrNull = s.toLongOrNull(s2);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final Stat readStatFile() {
        return readStatFile(new File(a.B(a.U("/proc/"), getPid(), "/stat")));
    }

    public final Stat readStatFile(File file) {
        m.checkNotNullParameter(file, "file");
        String file2 = readFile(file);
        return file2 != null ? parsePidStats(file2) : default;
    }
}
