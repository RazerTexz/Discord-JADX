package com.discord.utilities.system;

import a0.a.a.b;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.AnyThread;
import b.d.b.a.a;
import com.discord.api.permission.Permission;
import com.discord.utilities.system.ProcfsReader;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.k;
import d0.l;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DeviceResourceUsageMonitor.kt */
/* loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor {
    private static final long SC_CLK_TCK;
    private static final long SC_PAGE_SIZE;
    private static final int cpuCoreCount;
    private Long activeThreadId;
    private final Function1<ResourceUsage, Unit> callback;
    private final Clock clock;
    private Thread thread;
    private final Object threadSync;
    private final TimeSpan timeSpan;

    /* compiled from: DeviceResourceUsageMonitor.kt */
    public static final /* data */ class ResourceUsage {
        private final int cpuCoreCount;
        private final int cpuUsagePercent;
        private final long memoryRssBytes;

        public ResourceUsage(int i, long j, int i2) {
            this.cpuUsagePercent = i;
            this.memoryRssBytes = j;
            this.cpuCoreCount = i2;
        }

        public static /* synthetic */ ResourceUsage copy$default(ResourceUsage resourceUsage, int i, long j, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = resourceUsage.cpuUsagePercent;
            }
            if ((i3 & 2) != 0) {
                j = resourceUsage.memoryRssBytes;
            }
            if ((i3 & 4) != 0) {
                i2 = resourceUsage.cpuCoreCount;
            }
            return resourceUsage.copy(i, j, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCpuUsagePercent() {
            return this.cpuUsagePercent;
        }

        /* renamed from: component2, reason: from getter */
        public final long getMemoryRssBytes() {
            return this.memoryRssBytes;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCpuCoreCount() {
            return this.cpuCoreCount;
        }

        public final ResourceUsage copy(int cpuUsagePercent, long memoryRssBytes, int cpuCoreCount) {
            return new ResourceUsage(cpuUsagePercent, memoryRssBytes, cpuCoreCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceUsage)) {
                return false;
            }
            ResourceUsage resourceUsage = (ResourceUsage) other;
            return this.cpuUsagePercent == resourceUsage.cpuUsagePercent && this.memoryRssBytes == resourceUsage.memoryRssBytes && this.cpuCoreCount == resourceUsage.cpuCoreCount;
        }

        public final int getCpuCoreCount() {
            return this.cpuCoreCount;
        }

        public final int getCpuUsagePercent() {
            return this.cpuUsagePercent;
        }

        public final long getMemoryRssBytes() {
            return this.memoryRssBytes;
        }

        public int hashCode() {
            return ((b.a(this.memoryRssBytes) + (this.cpuUsagePercent * 31)) * 31) + this.cpuCoreCount;
        }

        public String toString() {
            StringBuilder sbU = a.U("ResourceUsage(cpuUsagePercent=");
            sbU.append(this.cpuUsagePercent);
            sbU.append(", memoryRssBytes=");
            sbU.append(this.memoryRssBytes);
            sbU.append(", cpuCoreCount=");
            return a.B(sbU, this.cpuCoreCount, ")");
        }
    }

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        Object objM97constructorimpl3;
        try {
            k.a aVar = k.j;
            objM97constructorimpl = k.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK)));
        } catch (Throwable th) {
            k.a aVar2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
        if (k.m101isFailureimpl(objM97constructorimpl)) {
            objM97constructorimpl = 100L;
        }
        SC_CLK_TCK = ((Number) objM97constructorimpl).longValue();
        try {
            k.a aVar3 = k.j;
            objM97constructorimpl2 = k.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_PAGE_SIZE)));
        } catch (Throwable th2) {
            k.a aVar4 = k.j;
            objM97constructorimpl2 = k.m97constructorimpl(l.createFailure(th2));
        }
        Long lValueOf = Long.valueOf(Permission.SEND_TTS_MESSAGES);
        if (k.m101isFailureimpl(objM97constructorimpl2)) {
            objM97constructorimpl2 = lValueOf;
        }
        SC_PAGE_SIZE = ((Number) objM97constructorimpl2).longValue();
        try {
            k.a aVar5 = k.j;
            objM97constructorimpl3 = k.m97constructorimpl(Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } catch (Throwable th3) {
            k.a aVar6 = k.j;
            objM97constructorimpl3 = k.m97constructorimpl(l.createFailure(th3));
        }
        if (k.m101isFailureimpl(objM97constructorimpl3)) {
            objM97constructorimpl3 = 1;
        }
        cpuCoreCount = ((Number) objM97constructorimpl3).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceResourceUsageMonitor(TimeSpan timeSpan, Clock clock, Function1<? super ResourceUsage, Unit> function1) {
        m.checkNotNullParameter(timeSpan, "timeSpan");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(function1, "callback");
        this.timeSpan = timeSpan;
        this.clock = clock;
        this.callback = function1;
        this.threadSync = new Object();
    }

    public static final /* synthetic */ void access$monitor(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        deviceResourceUsageMonitor.monitor();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void monitor() throws InterruptedException {
        ProcfsReader.Stat stat = null;
        Long lValueOf = null;
        while (true) {
            synchronized (this.threadSync) {
                Long l = this.activeThreadId;
                Thread threadCurrentThread = Thread.currentThread();
                m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
                long id2 = threadCurrentThread.getId();
                if (l == null || l.longValue() != id2) {
                    break;
                }
                if (Thread.interrupted()) {
                    return;
                }
                ProcfsReader.Stat statFile = ProcfsReader.INSTANCE.readStatFile();
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (stat != null && lValueOf != null) {
                    double totalTime = ((statFile.getTotalTime() - stat.getTotalTime()) * 100) / (SC_CLK_TCK * ((jCurrentTimeMillis - lValueOf.longValue()) / 1000.0d));
                    int i = cpuCoreCount;
                    if (i == 0) {
                        i = 1;
                    }
                    this.callback.invoke(new ResourceUsage((int) (totalTime / i), statFile.getRssPages() * SC_PAGE_SIZE, i));
                }
                lValueOf = Long.valueOf(jCurrentTimeMillis);
                Thread.sleep(this.timeSpan.toMillis());
                stat = statFile;
            }
        }
    }

    @AnyThread
    public final void finalize() {
        stop();
    }

    @AnyThread
    public final void start() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            Thread threadThread$default = d0.v.a.thread$default(true, true, null, "DeviceResourceUsageMonitor", 2, new DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1(this), 4, null);
            this.activeThreadId = Long.valueOf(threadThread$default.getId());
            this.thread = threadThread$default;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }

    @AnyThread
    public final void stop() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            this.thread = null;
            this.activeThreadId = null;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }
}
