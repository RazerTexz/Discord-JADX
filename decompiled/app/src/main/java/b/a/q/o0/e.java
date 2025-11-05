package b.a.q.o0;

import androidx.annotation.AnyThread;
import co.discord.media_engine.InboundRtpVideo;
import com.discord.utilities.collections.Histogram;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.t.h0;
import d0.t.n;
import d0.t.r;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoQuality.kt */
/* loaded from: classes.dex */
public final class e {
    public final ListenerCollectionSubject<?> e;
    public final ListenerCollection<?> f;
    public final long g;
    public Long h;
    public final d i;
    public final d j;
    public final d k;
    public final f l;
    public final Map<String, C0048e> m;
    public final Map<Long, Long> n;
    public final DeviceResourceUsageMonitor o;
    public final Logger p;
    public final Clock q;
    public static final b d = new b(null);
    public static final List<Integer> a = n.listOf((Object[]) new Integer[]{0, 500000, 1000000, 1500000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000});

    /* renamed from: b, reason: collision with root package name */
    public static final List<Integer> f280b = n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60});
    public static final List<Integer> c = n.listOf((Object[]) new Integer[]{720, 480, 360});

    /* compiled from: VideoQuality.kt */
    public static final class a {
        public long a;

        /* renamed from: b, reason: collision with root package name */
        public long f281b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;

        public a() {
            this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383);
        }

        public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
            this.a = j;
            this.f281b = j2;
            this.c = j3;
            this.d = j4;
            this.e = j5;
            this.f = j6;
            this.g = j7;
            this.h = j8;
            this.i = j9;
            this.j = j10;
            this.k = j11;
            this.l = j12;
            this.m = j13;
            this.n = j14;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f281b == aVar.f281b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && this.n == aVar.n;
        }

        public int hashCode() {
            return a0.a.a.b.a(this.n) + ((a0.a.a.b.a(this.m) + ((a0.a.a.b.a(this.l) + ((a0.a.a.b.a(this.k) + ((a0.a.a.b.a(this.j) + ((a0.a.a.b.a(this.i) + ((a0.a.a.b.a(this.h) + ((a0.a.a.b.a(this.g) + ((a0.a.a.b.a(this.f) + ((a0.a.a.b.a(this.e) + ((a0.a.a.b.a(this.d) + ((a0.a.a.b.a(this.c) + ((a0.a.a.b.a(this.f281b) + (a0.a.a.b.a(this.a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("AggregatedProperties(framesCodec=");
            sbU.append(this.a);
            sbU.append(", framesNetwork=");
            sbU.append(this.f281b);
            sbU.append(", packets=");
            sbU.append(this.c);
            sbU.append(", packetsLost=");
            sbU.append(this.d);
            sbU.append(", framesDropped=");
            sbU.append(this.e);
            sbU.append(", bytes=");
            sbU.append(this.f);
            sbU.append(", nackCount=");
            sbU.append(this.g);
            sbU.append(", pliCount=");
            sbU.append(this.h);
            sbU.append(", qpSum=");
            sbU.append(this.i);
            sbU.append(", freezeCount=");
            sbU.append(this.j);
            sbU.append(", pauseCount=");
            sbU.append(this.k);
            sbU.append(", totalFreezesDuration=");
            sbU.append(this.l);
            sbU.append(", totalPausesDuration=");
            sbU.append(this.m);
            sbU.append(", totalFramesDuration=");
            return b.d.b.a.a.C(sbU, this.n, ")");
        }

        public /* synthetic */ a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, (i & 16) != 0 ? 0L : j5, (i & 32) != 0 ? 0L : j6, (i & 64) != 0 ? 0L : j7, (i & 128) != 0 ? 0L : j8, (i & 256) != 0 ? 0L : j9, (i & 512) != 0 ? 0L : j10, (i & 1024) != 0 ? 0L : j11, (i & 2048) != 0 ? 0L : j12, (i & 4096) != 0 ? 0L : j13, (i & 8192) == 0 ? j14 : 0L);
        }
    }

    /* compiled from: VideoQuality.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final long a(b bVar, Float f) {
            if (f != null) {
                return d0.a0.a.roundToLong(f.floatValue());
            }
            return 0L;
        }
    }

    /* compiled from: VideoQuality.kt */
    public static abstract class c {
    }

    /* compiled from: VideoQuality.kt */
    public static final class d {
        public Long a;

        /* renamed from: b, reason: collision with root package name */
        public long f282b;

        public d(boolean z2, long j) {
            this.a = z2 ? Long.valueOf(j) : null;
        }

        public final boolean a() {
            return this.a != null;
        }

        public final void b(boolean z2, long j) {
            Long l = this.a;
            if (l == null) {
                if (z2) {
                    this.a = Long.valueOf(j);
                }
            } else if (l != null) {
                long jLongValue = l.longValue();
                if (z2) {
                    return;
                }
                this.f282b = (j - jLongValue) + this.f282b;
                this.a = null;
            }
        }

        public final long c(long j) {
            Long l = this.a;
            if (l == null) {
                return this.f282b;
            }
            return (this.f282b + j) - l.longValue();
        }
    }

    /* compiled from: VideoQuality.kt */
    /* renamed from: b.a.q.o0.e$e, reason: collision with other inner class name */
    public static class C0048e {
        public Long d;
        public long f;
        public float i;
        public List<g> a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Histogram f283b = new Histogram(5, 0, 2, null);
        public final Histogram c = new Histogram(25600, 0, 2, null);
        public a e = new a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383);
        public Map<Integer, Float> g = new LinkedHashMap();
        public Map<Integer, Float> h = new LinkedHashMap();
        public Map<Integer, Float> j = new LinkedHashMap();

        public C0048e() {
            Iterator<T> it = e.a.iterator();
            while (it.hasNext()) {
                this.g.put(Integer.valueOf(((Number) it.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it2 = e.f280b.iterator();
            while (it2.hasNext()) {
                this.h.put(Integer.valueOf(((Number) it2.next()).intValue()), Float.valueOf(0.0f));
            }
            Iterator<T> it3 = e.c.iterator();
            while (it3.hasNext()) {
                this.j.put(Integer.valueOf(((Number) it3.next()).intValue()), Float.valueOf(0.0f));
            }
        }
    }

    /* compiled from: VideoQuality.kt */
    public static final class f extends C0048e {
        public int k = 2500000;
        public int l = 30;
        public long m;
        public long n;
        public long o;
    }

    /* compiled from: VideoQuality.kt */
    public static final class g {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final long f284b;
        public final a c;

        public g(long j, long j2, a aVar) {
            m.checkNotNullParameter(aVar, "aggregatedProperties");
            this.a = j;
            this.f284b = j2;
            this.c = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.f284b == gVar.f284b && m.areEqual(this.c, gVar.c);
        }

        public int hashCode() {
            int iA = (a0.a.a.b.a(this.f284b) + (a0.a.a.b.a(this.a) * 31)) * 31;
            a aVar = this.c;
            return iA + (aVar != null ? aVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("RawVideoStats(resolution=");
            sbU.append(this.a);
            sbU.append(", timestamp=");
            sbU.append(this.f284b);
            sbU.append(", aggregatedProperties=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }

        public g() {
            this(0L, 0L, new a(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383));
        }
    }

    /* compiled from: VideoQuality.kt */
    public static final class h extends o implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
            DeviceResourceUsageMonitor.ResourceUsage resourceUsage2 = resourceUsage;
            m.checkNotNullParameter(resourceUsage2, "it");
            e eVar = e.this;
            List<Integer> list = e.a;
            synchronized (eVar) {
                Iterator<Map.Entry<String, C0048e>> it = eVar.m.entrySet().iterator();
                while (it.hasNext()) {
                    C0048e value = it.next().getValue();
                    value.f283b.addSample(resourceUsage2.getCpuUsagePercent());
                    value.c.addSample(resourceUsage2.getMemoryRssBytes());
                }
                eVar.l.f283b.addSample(resourceUsage2.getCpuUsagePercent());
                eVar.l.c.addSample(resourceUsage2.getMemoryRssBytes());
            }
            return Unit.a;
        }
    }

    public e(Logger logger, Clock clock) {
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(clock, "clock");
        this.p = logger;
        this.q = clock;
        ListenerCollectionSubject<?> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.e = listenerCollectionSubject;
        this.f = listenerCollectionSubject;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        this.g = jCurrentTimeMillis;
        this.i = new d(false, jCurrentTimeMillis);
        this.j = new d(false, jCurrentTimeMillis);
        this.k = new d(false, jCurrentTimeMillis);
        this.l = new f();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        DeviceResourceUsageMonitor deviceResourceUsageMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1L, TimeUnit.SECONDS), clock, new h());
        this.o = deviceResourceUsageMonitor;
        deviceResourceUsageMonitor.start();
    }

    public final void a(C0048e c0048e, g gVar) {
        c0048e.a.add(gVar);
        if (c0048e.a.size() < 2) {
            return;
        }
        g gVar2 = c0048e.a.get(r1.size() - 1);
        List<g> list = c0048e.a;
        g gVar3 = list.get(list.size() - 2);
        b.a.q.o0.f fVar = b.a.q.o0.f.j;
        c0048e.f = (gVar2.f284b - gVar3.f284b) + c0048e.f;
        a aVar = c0048e.e;
        a aVar2 = gVar2.c;
        a aVar3 = gVar3.c;
        aVar.a = fVar.a(aVar2.a, aVar3.a) + aVar.a;
        aVar.f281b = fVar.a(aVar2.f281b, aVar3.f281b) + aVar.f281b;
        aVar.c = fVar.a(aVar2.c, aVar3.c) + aVar.c;
        aVar.d = fVar.a(aVar2.d, aVar3.d) + aVar.d;
        aVar.e = fVar.a(aVar2.e, aVar3.e) + aVar.e;
        aVar.f = fVar.a(aVar2.f, aVar3.f) + aVar.f;
        aVar.g = fVar.a(aVar2.g, aVar3.g) + aVar.g;
        aVar.h = fVar.a(aVar2.h, aVar3.h) + aVar.h;
        aVar.i = fVar.a(aVar2.i, aVar3.i) + aVar.i;
        aVar.j = fVar.a(aVar2.j, aVar3.j) + aVar.j;
        aVar.k = fVar.a(aVar2.j, aVar3.j) + aVar.k;
        aVar.l = fVar.a(aVar2.l, aVar3.l) + aVar.l;
        aVar.m = fVar.a(aVar2.m, aVar3.m) + aVar.m;
        aVar.n = fVar.a(aVar2.n, aVar3.n) + aVar.n;
        a aVar4 = gVar2.c;
        long j = aVar4.f;
        long j2 = aVar4.a;
        long j3 = gVar2.f284b;
        long j4 = gVar2.a;
        float f2 = (j3 - gVar3.f284b) / 1000.0f;
        c0048e.i = (j4 * f2) + c0048e.i;
        if (c0048e.a.size() < 6) {
            return;
        }
        g gVar4 = c0048e.a.get(r2.size() - 3);
        a aVar5 = gVar4.c;
        long j5 = aVar5.f;
        long j6 = aVar5.a;
        long j7 = gVar4.f284b;
        Iterator<T> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long j8 = j2;
            int iIntValue = ((Number) it.next()).intValue();
            long j9 = j6;
            if (j4 <= iIntValue) {
                Map<Integer, Float> map = c0048e.j;
                Integer numValueOf = Integer.valueOf(iIntValue);
                Float f3 = c0048e.j.get(Integer.valueOf(iIntValue));
                map.put(numValueOf, Float.valueOf((f3 != null ? f3.floatValue() : 0.0f) + f2));
            }
            j2 = j8;
            j6 = j9;
        }
        float f4 = (j3 - j7) / 1000.0f;
        float f5 = ((j - j5) * 8) / f4;
        float f6 = (j2 - j6) / f4;
        Iterator<T> it2 = a.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (f5 <= iIntValue2) {
                Map<Integer, Float> map2 = c0048e.g;
                Integer numValueOf2 = Integer.valueOf(iIntValue2);
                Float f7 = c0048e.g.get(Integer.valueOf(iIntValue2));
                map2.put(numValueOf2, Float.valueOf((f7 != null ? f7.floatValue() : 0.0f) + f2));
            }
        }
        Iterator<T> it3 = f280b.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Number) it3.next()).intValue();
            if (f6 <= iIntValue3) {
                Map<Integer, Float> map3 = c0048e.h;
                Integer numValueOf3 = Integer.valueOf(iIntValue3);
                Float f8 = c0048e.h.get(Integer.valueOf(iIntValue3));
                map3.put(numValueOf3, Float.valueOf((f8 != null ? f8.floatValue() : 0.0f) + f2));
            }
        }
        r.removeFirst(c0048e.a);
    }

    public final void b(int i) {
        if (this.l.a.size() < 2) {
            return;
        }
        long j = this.l.a.get(r0.size() - 1).f284b;
        List<g> list = this.l.a;
        float f2 = (j - list.get(list.size() - 2).f284b) / 1000.0f;
        f fVar = this.l;
        long j2 = fVar.m;
        Float fValueOf = Float.valueOf(fVar.l * f2);
        fVar.m = j2 + (fValueOf != null ? d0.a0.a.roundToLong(fValueOf.floatValue()) : 0L);
        f fVar2 = this.l;
        long j3 = fVar2.n;
        Float fValueOf2 = Float.valueOf((i / 8.0f) * f2);
        fVar2.n = j3 + (fValueOf2 != null ? d0.a0.a.roundToLong(fValueOf2.floatValue()) : 0L);
        f fVar3 = this.l;
        long j4 = fVar3.o;
        Float fValueOf3 = Float.valueOf((fVar3.k / 8.0f) * f2);
        fVar3.o = j4 + (fValueOf3 != null ? d0.a0.a.roundToLong(fValueOf3.floatValue()) : 0L);
    }

    @AnyThread
    public final synchronized Map<String, Object> c(String str) {
        C0048e c0048e;
        m.checkNotNullParameter(str, "userId");
        c0048e = this.m.get(str);
        return c0048e != null ? e(c0048e) : null;
    }

    @AnyThread
    public final synchronized Map<String, Object> d() {
        float f2;
        float f3;
        Float fValueOf;
        Float fValueOf2;
        Float fValueOf3;
        f2 = r0.f / 1000.0f;
        f3 = 0;
        return h0.plus(e(this.l), h0.mapOf(d0.o.to("target_bitrate_max", Long.valueOf((f2 <= f3 || (fValueOf3 = Float.valueOf(((float) (this.l.o * ((long) 8))) / f2)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf3.floatValue()))), d0.o.to("target_bitrate_network", Long.valueOf((f2 <= f3 || (fValueOf2 = Float.valueOf(((float) (this.l.n * ((long) 8))) / f2)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf2.floatValue()))), d0.o.to("target_fps", Long.valueOf((f2 <= f3 || (fValueOf = Float.valueOf(((float) this.l.m) / f2)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf.floatValue()))), d0.o.to("duration_encoder_nvidia_cuda", 0L), d0.o.to("duration_encoder_nvidia_direct3d", 0L), d0.o.to("duration_encoder_openh264", 0L), d0.o.to("duration_encoder_videotoolbox", 0L), d0.o.to("duration_encoder_amd_direct3d", 0L), d0.o.to("duration_encoder_intel", 0L), d0.o.to("duration_encoder_intel_direct3d", 0L), d0.o.to("duration_encoder_unknown", 0L)));
    }

    public final Map<String, Object> e(C0048e c0048e) {
        Float fValueOf;
        long jCurrentTimeMillis = this.q.currentTimeMillis();
        float fLongValue = (this.h != null ? r4.longValue() - this.g : jCurrentTimeMillis - this.g) / 1000.0f;
        float f2 = c0048e.f / 1000.0f;
        float f3 = 0;
        long jRoundToLong = (f2 <= f3 || (fValueOf = Float.valueOf(c0048e.i / f2)) == null) ? 0L : d0.a0.a.roundToLong(fValueOf.floatValue());
        Histogram.Report report = c0048e.f283b.getReport();
        Histogram.Report report2 = c0048e.c.getReport();
        b bVar = d;
        long j = 1024;
        Map mapMapOf = h0.mapOf(d0.o.to("duration", Double.valueOf(Math.floor(fLongValue))), b.d.b.a.a.b0(bVar, c0048e.g.get(8000000), "duration_stream_under_8mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(7000000), "duration_stream_under_7mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(6000000), "duration_stream_under_6mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(5000000), "duration_stream_under_5mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(4000000), "duration_stream_under_4mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(3000000), "duration_stream_under_3mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(2000000), "duration_stream_under_2mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(1500000), "duration_stream_under_1_5mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(1000000), "duration_stream_under_1mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(500000), "duration_stream_under_0_5mbps"), b.d.b.a.a.b0(bVar, c0048e.g.get(0), "duration_stream_at_0mbps"), b.d.b.a.a.b0(bVar, c0048e.h.get(60), "duration_fps_under_60"), b.d.b.a.a.b0(bVar, c0048e.h.get(55), "duration_fps_under_55"), b.d.b.a.a.b0(bVar, c0048e.h.get(50), "duration_fps_under_50"), b.d.b.a.a.b0(bVar, c0048e.h.get(45), "duration_fps_under_45"), b.d.b.a.a.b0(bVar, c0048e.h.get(40), "duration_fps_under_40"), b.d.b.a.a.b0(bVar, c0048e.h.get(35), "duration_fps_under_35"), b.d.b.a.a.b0(bVar, c0048e.h.get(30), "duration_fps_under_30"), b.d.b.a.a.b0(bVar, c0048e.h.get(25), "duration_fps_under_25"), b.d.b.a.a.b0(bVar, c0048e.h.get(20), "duration_fps_under_20"), b.d.b.a.a.b0(bVar, c0048e.h.get(15), "duration_fps_under_15"), b.d.b.a.a.b0(bVar, c0048e.h.get(10), "duration_fps_under_10"), b.d.b.a.a.b0(bVar, c0048e.h.get(5), "duration_fps_under_5"), b.d.b.a.a.b0(bVar, c0048e.h.get(0), "duration_fps_at_0"), d0.o.to("avg_resolution", Long.valueOf(jRoundToLong)), b.d.b.a.a.b0(bVar, c0048e.j.get(720), "duration_resolution_under_720"), b.d.b.a.a.b0(bVar, c0048e.j.get(480), "duration_resolution_under_480"), b.d.b.a.a.b0(bVar, c0048e.j.get(360), "duration_resolution_under_360"), d0.o.to("num_pauses", 0), d0.o.to("duration_paused", Long.valueOf(b.a(bVar, Float.valueOf(this.i.c(jCurrentTimeMillis) / 1000.0f)))), d0.o.to("duration_zero_receivers", Long.valueOf(b.a(bVar, Float.valueOf(this.j.c(jCurrentTimeMillis) / 1000.0f)))), d0.o.to("duration_video_stopped", Long.valueOf(b.a(bVar, Float.valueOf(this.k.c(jCurrentTimeMillis) / 1000.0f)))), d0.o.to("client_performance_cpu_percentile25", Long.valueOf(report.getPercentile25())), d0.o.to("client_performance_cpu_percentile50", Long.valueOf(report.getPercentile50())), d0.o.to("client_performance_cpu_percentile75", Long.valueOf(report.getPercentile75())), d0.o.to("client_performance_cpu_percentile90", Long.valueOf(report.getPercentile90())), d0.o.to("client_performance_cpu_percentile95", Long.valueOf(report.getPercentile95())), d0.o.to("client_performance_memory_percentile25", Long.valueOf(report2.getPercentile25() / j)), d0.o.to("client_performance_memory_percentile50", Long.valueOf(report2.getPercentile50() / j)), d0.o.to("client_performance_memory_percentile75", Long.valueOf(report2.getPercentile75() / j)), d0.o.to("client_performance_memory_percentile90", Long.valueOf(report2.getPercentile90() / j)), d0.o.to("client_performance_memory_percentile95", Long.valueOf(report2.getPercentile95() / j)), d0.o.to("client_performance_memory_min", Long.valueOf(report2.getMin() / j)), d0.o.to("client_performance_memory_max", Long.valueOf(report2.getMax() / j)));
        a aVar = c0048e.e;
        long jA = f2 > f3 ? b.a(bVar, Float.valueOf((aVar.f * 8) / f2)) : 0L;
        long jA2 = f2 > f3 ? b.a(bVar, Float.valueOf(aVar.a / f2)) : 0L;
        Pair[] pairArr = new Pair[16];
        pairArr[0] = d0.o.to("avg_bitrate", Long.valueOf(jA));
        pairArr[1] = d0.o.to("avg_fps", Long.valueOf(jA2));
        pairArr[2] = d0.o.to("num_bytes", Long.valueOf(aVar.f));
        pairArr[3] = d0.o.to("num_packets_lost", Long.valueOf(aVar.d));
        pairArr[4] = d0.o.to("num_packets", Long.valueOf(aVar.c));
        pairArr[5] = d0.o.to("num_frames", Long.valueOf(aVar.f281b));
        Long l = c0048e.d;
        pairArr[6] = d0.o.to("time_to_first_frame_ms", Long.valueOf(l != null ? l.longValue() : 0L));
        pairArr[7] = d0.o.to("num_frames_dropped", Long.valueOf(aVar.e));
        pairArr[8] = d0.o.to("num_nacks", Long.valueOf(aVar.g));
        pairArr[9] = d0.o.to("num_plis", Long.valueOf(aVar.h));
        pairArr[10] = d0.o.to("qp_sum", Long.valueOf(aVar.i));
        pairArr[11] = d0.o.to("receiver_freeze_count", Long.valueOf(aVar.j));
        pairArr[12] = d0.o.to("receiver_pause_count", Long.valueOf(aVar.k));
        pairArr[13] = d0.o.to("receiver_total_freezes_duration", Long.valueOf(aVar.l));
        pairArr[14] = d0.o.to("receiver_total_pauses_duration", Long.valueOf(aVar.m));
        pairArr[15] = d0.o.to("receiver_total_frames_duration", Long.valueOf(aVar.n));
        return h0.plus(mapMapOf, h0.mapOf(pairArr));
    }

    public final g f(InboundRtpVideo inboundRtpVideo, long j) {
        return new g(inboundRtpVideo.getResolution().getHeight(), j, new a(inboundRtpVideo.getFramesDecoded(), inboundRtpVideo.getFramesReceived(), inboundRtpVideo.getPacketsReceived(), inboundRtpVideo.getPacketsLost(), inboundRtpVideo.getFramesDropped(), inboundRtpVideo.getBytesReceived(), inboundRtpVideo.getNackCount(), inboundRtpVideo.getPliCount(), inboundRtpVideo.getQpSum(), inboundRtpVideo.getFreezeCount(), inboundRtpVideo.getPauseCount(), inboundRtpVideo.getTotalFreezesDuration(), inboundRtpVideo.getTotalPausesDuration(), inboundRtpVideo.getTotalFramesDuration()));
    }

    public final void g(Boolean bool, Integer num, long j) {
        if (num != null) {
            this.j.b(num.intValue() == 0, j);
        }
        boolean z2 = this.i.a() || this.j.a();
        if (z2 != this.k.a()) {
            this.k.b(z2, j);
            this.l.a.clear();
        }
    }
}
