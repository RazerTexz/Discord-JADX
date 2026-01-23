package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.HandlerC10769d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.SeekParameters;
import p007b.p225i.p226a.p242c.p243a3.IcyDataSource;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;
import p007b.p225i.p226a.p242c.p243a3.SampleQueue;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p257e3.DataReader;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.DefaultLoadErrorHandlingPolicy;
import p007b.p225i.p226a.p242c.p257e3.LoadErrorHandlingPolicy;
import p007b.p225i.p226a.p242c.p257e3.StatsDataSource;
import p007b.p225i.p226a.p242c.p259f3.ConditionVariable;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p273h0.Mp3Extractor;

/* JADX INFO: renamed from: b.i.a.c.a3.e0, reason: use source file name */
/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.InterfaceC10767b<a>, Loader.InterfaceC10771f, SampleQueue.d {

    /* JADX INFO: renamed from: j */
    public static final Map<String, String> f5498j;

    /* JADX INFO: renamed from: k */
    public static final Format2 f5499k;

    /* JADX INFO: renamed from: B */
    @Nullable
    public MediaPeriod.a f5501B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public IcyHeaders f5502C;

    /* JADX INFO: renamed from: F */
    public boolean f5505F;

    /* JADX INFO: renamed from: G */
    public boolean f5506G;

    /* JADX INFO: renamed from: H */
    public boolean f5507H;

    /* JADX INFO: renamed from: I */
    public e f5508I;

    /* JADX INFO: renamed from: J */
    public SeekMap f5509J;

    /* JADX INFO: renamed from: L */
    public boolean f5511L;

    /* JADX INFO: renamed from: N */
    public boolean f5513N;

    /* JADX INFO: renamed from: O */
    public boolean f5514O;

    /* JADX INFO: renamed from: P */
    public int f5515P;

    /* JADX INFO: renamed from: R */
    public long f5517R;

    /* JADX INFO: renamed from: T */
    public boolean f5519T;

    /* JADX INFO: renamed from: U */
    public int f5520U;

    /* JADX INFO: renamed from: V */
    public boolean f5521V;

    /* JADX INFO: renamed from: W */
    public boolean f5522W;

    /* JADX INFO: renamed from: l */
    public final Uri f5523l;

    /* JADX INFO: renamed from: m */
    public final DataSource3 f5524m;

    /* JADX INFO: renamed from: n */
    public final DrmSessionManager2 f5525n;

    /* JADX INFO: renamed from: o */
    public final LoadErrorHandlingPolicy f5526o;

    /* JADX INFO: renamed from: p */
    public final MediaSourceEventListener.a f5527p;

    /* JADX INFO: renamed from: q */
    public final DrmSessionEventListener.a f5528q;

    /* JADX INFO: renamed from: r */
    public final b f5529r;

    /* JADX INFO: renamed from: s */
    public final DefaultAllocator f5530s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final String f5531t;

    /* JADX INFO: renamed from: u */
    public final long f5532u;

    /* JADX INFO: renamed from: w */
    public final ProgressiveMediaExtractor f5534w;

    /* JADX INFO: renamed from: v */
    public final Loader f5533v = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: x */
    public final ConditionVariable f5535x = new ConditionVariable();

    /* JADX INFO: renamed from: y */
    public final Runnable f5536y = new RunnableC2541g(this);

    /* JADX INFO: renamed from: z */
    public final Runnable f5537z = new RunnableC2545i(this);

    /* JADX INFO: renamed from: A */
    public final Handler f5500A = Util2.m3002j();

    /* JADX INFO: renamed from: E */
    public d[] f5504E = new d[0];

    /* JADX INFO: renamed from: D */
    public SampleQueue[] f5503D = new SampleQueue[0];

    /* JADX INFO: renamed from: S */
    public long f5518S = -9223372036854775807L;

    /* JADX INFO: renamed from: Q */
    public long f5516Q = -1;

    /* JADX INFO: renamed from: K */
    public long f5510K = -9223372036854775807L;

    /* JADX INFO: renamed from: M */
    public int f5512M = 1;

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$a */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class a implements Loader.InterfaceC10770e, IcyDataSource.a {

        /* JADX INFO: renamed from: b */
        public final Uri f5539b;

        /* JADX INFO: renamed from: c */
        public final StatsDataSource f5540c;

        /* JADX INFO: renamed from: d */
        public final ProgressiveMediaExtractor f5541d;

        /* JADX INFO: renamed from: e */
        public final ExtractorOutput f5542e;

        /* JADX INFO: renamed from: f */
        public final ConditionVariable f5543f;

        /* JADX INFO: renamed from: h */
        public volatile boolean f5545h;

        /* JADX INFO: renamed from: j */
        public long f5547j;

        /* JADX INFO: renamed from: m */
        @Nullable
        public TrackOutput2 f5550m;

        /* JADX INFO: renamed from: n */
        public boolean f5551n;

        /* JADX INFO: renamed from: g */
        public final PositionHolder f5544g = new PositionHolder();

        /* JADX INFO: renamed from: i */
        public boolean f5546i = true;

        /* JADX INFO: renamed from: l */
        public long f5549l = -1;

        /* JADX INFO: renamed from: a */
        public final long f5538a = LoadEventInfo.f5703a.getAndIncrement();

        /* JADX INFO: renamed from: k */
        public DataSpec f5548k = m2503a(0);

        public a(Uri uri, DataSource3 dataSource3, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f5539b = uri;
            this.f5540c = new StatsDataSource(dataSource3);
            this.f5541d = progressiveMediaExtractor;
            this.f5542e = extractorOutput;
            this.f5543f = conditionVariable;
        }

        /* JADX INFO: renamed from: a */
        public final DataSpec m2503a(long j) {
            Collections.emptyMap();
            Uri uri = this.f5539b;
            String str = ProgressiveMediaPeriod.this.f5531t;
            Map<String, String> map = ProgressiveMediaPeriod.f5498j;
            if (uri != null) {
                return new DataSpec(uri, 0L, 1, null, map, j, -1L, str, 6, null);
            }
            throw new IllegalStateException("The uri must be set.");
        }

        /* JADX INFO: renamed from: b */
        public void m2504b() throws IOException {
            DataReader icyDataSource;
            int i;
            int iMo3635e = 0;
            while (iMo3635e == 0 && !this.f5545h) {
                try {
                    long j = this.f5544g.f8992a;
                    DataSpec dataSpecM2503a = m2503a(j);
                    this.f5548k = dataSpecM2503a;
                    long jMo2586a = this.f5540c.mo2586a(dataSpecM2503a);
                    this.f5549l = jMo2586a;
                    if (jMo2586a != -1) {
                        this.f5549l = jMo2586a + j;
                    }
                    ProgressiveMediaPeriod.this.f5502C = IcyHeaders.m8881a(this.f5540c.mo2588j());
                    StatsDataSource statsDataSource = this.f5540c;
                    IcyHeaders icyHeaders = ProgressiveMediaPeriod.this.f5502C;
                    if (icyHeaders == null || (i = icyHeaders.f19962o) == -1) {
                        icyDataSource = statsDataSource;
                    } else {
                        icyDataSource = new IcyDataSource(statsDataSource, i, this);
                        TrackOutput2 trackOutput2M2474B = ProgressiveMediaPeriod.this.m2474B(new d(0, true));
                        this.f5550m = trackOutput2M2474B;
                        ((SampleQueue) trackOutput2M2474B).mo2526e(ProgressiveMediaPeriod.f5499k);
                    }
                    long jM2558a = j;
                    ((BundledExtractorsAdapter) this.f5541d).m2559b(icyDataSource, this.f5539b, this.f5540c.mo2588j(), j, this.f5549l, this.f5542e);
                    if (ProgressiveMediaPeriod.this.f5502C != null) {
                        Extractor extractor = ((BundledExtractorsAdapter) this.f5541d).f5646b;
                        if (extractor instanceof Mp3Extractor) {
                            ((Mp3Extractor) extractor).f8333s = true;
                        }
                    }
                    if (this.f5546i) {
                        ProgressiveMediaExtractor progressiveMediaExtractor = this.f5541d;
                        long j2 = this.f5547j;
                        Extractor extractor2 = ((BundledExtractorsAdapter) progressiveMediaExtractor).f5646b;
                        Objects.requireNonNull(extractor2);
                        extractor2.mo3637g(jM2558a, j2);
                        this.f5546i = false;
                    }
                    while (true) {
                        long j3 = jM2558a;
                        while (iMo3635e == 0 && !this.f5545h) {
                            try {
                                ConditionVariable conditionVariable = this.f5543f;
                                synchronized (conditionVariable) {
                                    while (!conditionVariable.f6728b) {
                                        conditionVariable.wait();
                                    }
                                }
                                ProgressiveMediaExtractor progressiveMediaExtractor2 = this.f5541d;
                                PositionHolder positionHolder = this.f5544g;
                                BundledExtractorsAdapter bundledExtractorsAdapter = (BundledExtractorsAdapter) progressiveMediaExtractor2;
                                Extractor extractor3 = bundledExtractorsAdapter.f5646b;
                                Objects.requireNonNull(extractor3);
                                ExtractorInput extractorInput = bundledExtractorsAdapter.f5647c;
                                Objects.requireNonNull(extractorInput);
                                iMo3635e = extractor3.mo3635e(extractorInput, positionHolder);
                                jM2558a = ((BundledExtractorsAdapter) this.f5541d).m2558a();
                                if (jM2558a > ProgressiveMediaPeriod.this.f5532u + j3) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f5543f.m3025a();
                        ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                        progressiveMediaPeriod.f5500A.post(progressiveMediaPeriod.f5537z);
                    }
                    if (iMo3635e == 1) {
                        iMo3635e = 0;
                    } else if (((BundledExtractorsAdapter) this.f5541d).m2558a() != -1) {
                        this.f5544g.f8992a = ((BundledExtractorsAdapter) this.f5541d).m2558a();
                    }
                    StatsDataSource statsDataSource2 = this.f5540c;
                    if (statsDataSource2 != null) {
                        try {
                            statsDataSource2.f6641a.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (iMo3635e != 1 && ((BundledExtractorsAdapter) this.f5541d).m2558a() != -1) {
                        this.f5544g.f8992a = ((BundledExtractorsAdapter) this.f5541d).m2558a();
                    }
                    StatsDataSource statsDataSource3 = this.f5540c;
                    if (statsDataSource3 != null) {
                        try {
                            statsDataSource3.f6641a.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$b */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$c */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class c implements SampleStream {

        /* JADX INFO: renamed from: a */
        public final int f5553a;

        public c(int i) {
            this.f5553a = i;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: a */
        public int mo2505a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i3 = this.f5553a;
            if (progressiveMediaPeriod.m2476D()) {
                return -3;
            }
            progressiveMediaPeriod.m2501y(i3);
            SampleQueue sampleQueue = progressiveMediaPeriod.f5503D[i3];
            boolean z2 = progressiveMediaPeriod.f5521V;
            boolean z3 = (i & 2) != 0;
            SampleQueue.b bVar = sampleQueue.f5597b;
            synchronized (sampleQueue) {
                decoderInputBuffer.f19779m = false;
                i2 = -5;
                if (sampleQueue.m2536o()) {
                    Format2 format2 = sampleQueue.f5598c.m2561b(sampleQueue.m2532k()).f5625a;
                    if (!z3 && format2 == sampleQueue.f5603h) {
                        int iM2533l = sampleQueue.m2533l(sampleQueue.f5615t);
                        if (sampleQueue.m2538q(iM2533l)) {
                            decoderInputBuffer.f7901j = sampleQueue.f5609n[iM2533l];
                            long j = sampleQueue.f5610o[iM2533l];
                            decoderInputBuffer.f19780n = j;
                            if (j < sampleQueue.f5616u) {
                                decoderInputBuffer.m3551j(Integer.MIN_VALUE);
                            }
                            bVar.f5622a = sampleQueue.f5608m[iM2533l];
                            bVar.f5623b = sampleQueue.f5607l[iM2533l];
                            bVar.f5624c = sampleQueue.f5611p[iM2533l];
                            i2 = -4;
                        } else {
                            decoderInputBuffer.f19779m = true;
                            i2 = -3;
                        }
                    }
                    sampleQueue.m2539r(format2, formatHolder);
                } else {
                    if (!z2 && !sampleQueue.f5619x) {
                        Format2 format22 = sampleQueue.f5593B;
                        if (format22 == null || (!z3 && format22 == sampleQueue.f5603h)) {
                            i2 = -3;
                        } else {
                            sampleQueue.m2539r(format22, formatHolder);
                        }
                    }
                    decoderInputBuffer.f7901j = 4;
                    i2 = -4;
                }
            }
            if (i2 == -4 && !decoderInputBuffer.m3555n()) {
                boolean z4 = (i & 1) != 0;
                if ((i & 4) == 0) {
                    if (z4) {
                        SampleDataQueue sampleDataQueue = sampleQueue.f5596a;
                        SampleDataQueue.m2517f(sampleDataQueue.f5582e, decoderInputBuffer, sampleQueue.f5597b, sampleDataQueue.f5580c);
                    } else {
                        SampleDataQueue sampleDataQueue2 = sampleQueue.f5596a;
                        sampleDataQueue2.f5582e = SampleDataQueue.m2517f(sampleDataQueue2.f5582e, decoderInputBuffer, sampleQueue.f5597b, sampleDataQueue2.f5580c);
                    }
                }
                if (!z4) {
                    sampleQueue.f5615t++;
                }
            }
            if (i2 == -3) {
                progressiveMediaPeriod.m2502z(i3);
            }
            return i2;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: b */
        public void mo2506b() throws IOException {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            SampleQueue sampleQueue = progressiveMediaPeriod.f5503D[this.f5553a];
            DrmSession drmSession = sampleQueue.f5604i;
            if (drmSession == null || drmSession.getState() != 1) {
                progressiveMediaPeriod.m2473A();
            } else {
                DrmSession.DrmSessionException drmSessionExceptionMo3611f = sampleQueue.f5604i.mo3611f();
                Objects.requireNonNull(drmSessionExceptionMo3611f);
                throw drmSessionExceptionMo3611f;
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: c */
        public int mo2507c(long j) {
            int iM2530i;
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            int i = this.f5553a;
            boolean z2 = false;
            if (progressiveMediaPeriod.m2476D()) {
                return 0;
            }
            progressiveMediaPeriod.m2501y(i);
            SampleQueue sampleQueue = progressiveMediaPeriod.f5503D[i];
            boolean z3 = progressiveMediaPeriod.f5521V;
            synchronized (sampleQueue) {
                int iM2533l = sampleQueue.m2533l(sampleQueue.f5615t);
                if (sampleQueue.m2536o() && j >= sampleQueue.f5610o[iM2533l]) {
                    if (j <= sampleQueue.f5618w || !z3) {
                        iM2530i = sampleQueue.m2530i(iM2533l, sampleQueue.f5612q - sampleQueue.f5615t, j, true);
                        if (iM2530i == -1) {
                        }
                    } else {
                        iM2530i = sampleQueue.f5612q - sampleQueue.f5615t;
                    }
                }
                iM2530i = 0;
            }
            synchronized (sampleQueue) {
                if (iM2530i >= 0) {
                    if (sampleQueue.f5615t + iM2530i <= sampleQueue.f5612q) {
                        z2 = true;
                    }
                    AnimatableValueParser.m531j(z2);
                    sampleQueue.f5615t += iM2530i;
                } else {
                    AnimatableValueParser.m531j(z2);
                    sampleQueue.f5615t += iM2530i;
                }
            }
            if (iM2530i == 0) {
                progressiveMediaPeriod.m2502z(i);
            }
            return iM2530i;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: d */
        public boolean mo2508d() {
            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
            return !progressiveMediaPeriod.m2476D() && progressiveMediaPeriod.f5503D[this.f5553a].m2537p(progressiveMediaPeriod.f5521V);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$d */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final int f5555a;

        /* JADX INFO: renamed from: b */
        public final boolean f5556b;

        public d(int i, boolean z2) {
            this.f5555a = i;
            this.f5556b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f5555a == dVar.f5555a && this.f5556b == dVar.f5556b;
        }

        public int hashCode() {
            return (this.f5555a * 31) + (this.f5556b ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$e */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class e {

        /* JADX INFO: renamed from: a */
        public final TrackGroupArray f5557a;

        /* JADX INFO: renamed from: b */
        public final boolean[] f5558b;

        /* JADX INFO: renamed from: c */
        public final boolean[] f5559c;

        /* JADX INFO: renamed from: d */
        public final boolean[] f5560d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f5557a = trackGroupArray;
            this.f5558b = zArr;
            int i = trackGroupArray.f5675k;
            this.f5559c = new boolean[i];
            this.f5560d = new boolean[i];
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        f5498j = Collections.unmodifiableMap(map);
        Format2.b bVar = new Format2.b();
        bVar.f7163a = "icy";
        bVar.f7173k = "application/x-icy";
        f5499k = bVar.m3277a();
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource3 dataSource3, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager2 drmSessionManager2, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2, b bVar, DefaultAllocator defaultAllocator, @Nullable String str, int i) {
        this.f5523l = uri;
        this.f5524m = dataSource3;
        this.f5525n = drmSessionManager2;
        this.f5528q = aVar;
        this.f5526o = loadErrorHandlingPolicy;
        this.f5527p = aVar2;
        this.f5529r = bVar;
        this.f5530s = defaultAllocator;
        this.f5531t = str;
        this.f5532u = i;
        this.f5534w = progressiveMediaExtractor;
    }

    /* JADX INFO: renamed from: A */
    public void m2473A() throws IOException {
        Loader loader = this.f5533v;
        int iM2873a = ((DefaultLoadErrorHandlingPolicy) this.f5526o).m2873a(this.f5512M);
        IOException iOException = loader.f20233e;
        if (iOException != null) {
            throw iOException;
        }
        Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = loader.f20232d;
        if (handlerC10769d != null) {
            if (iM2873a == Integer.MIN_VALUE) {
                iM2873a = handlerC10769d.f20236j;
            }
            IOException iOException2 = handlerC10769d.f20240n;
            if (iOException2 != null && handlerC10769d.f20241o > iM2873a) {
                throw iOException2;
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final TrackOutput2 m2474B(d dVar) {
        int length = this.f5503D.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.f5504E[i])) {
                return this.f5503D[i];
            }
        }
        DefaultAllocator defaultAllocator = this.f5530s;
        Looper looper = this.f5500A.getLooper();
        DrmSessionManager2 drmSessionManager2 = this.f5525n;
        DrmSessionEventListener.a aVar = this.f5528q;
        Objects.requireNonNull(looper);
        Objects.requireNonNull(drmSessionManager2);
        Objects.requireNonNull(aVar);
        SampleQueue sampleQueue = new SampleQueue(defaultAllocator, looper, drmSessionManager2, aVar);
        sampleQueue.f5602g = this;
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f5504E, i2);
        dVarArr[length] = dVar;
        int i3 = Util2.f6708a;
        this.f5504E = dVarArr;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.f5503D, i2);
        sampleQueueArr[length] = sampleQueue;
        this.f5503D = sampleQueueArr;
        return sampleQueue;
    }

    /* JADX INFO: renamed from: C */
    public final void m2475C() {
        a aVar = new a(this.f5523l, this.f5524m, this.f5534w, this, this.f5535x);
        if (this.f5506G) {
            AnimatableValueParser.m426D(m2499w());
            long j = this.f5510K;
            if (j != -9223372036854775807L && this.f5518S > j) {
                this.f5521V = true;
                this.f5518S = -9223372036854775807L;
                return;
            }
            SeekMap seekMap = this.f5509J;
            Objects.requireNonNull(seekMap);
            long j2 = seekMap.mo3620h(this.f5518S).f8993a.f8999c;
            long j3 = this.f5518S;
            aVar.f5544g.f8992a = j2;
            aVar.f5547j = j3;
            aVar.f5546i = true;
            aVar.f5551n = false;
            for (SampleQueue sampleQueue : this.f5503D) {
                sampleQueue.f5616u = this.f5518S;
            }
            this.f5518S = -9223372036854775807L;
        }
        this.f5520U = m2497u();
        Loader loader = this.f5533v;
        int iM2873a = ((DefaultLoadErrorHandlingPolicy) this.f5526o).m2873a(this.f5512M);
        Objects.requireNonNull(loader);
        Looper looperMyLooper = Looper.myLooper();
        AnimatableValueParser.m438H(looperMyLooper);
        loader.f20233e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        loader.new HandlerC10769d(looperMyLooper, aVar, this, iM2873a, jElapsedRealtime).m8942b(0L);
        DataSpec dataSpec = aVar.f5548k;
        MediaSourceEventListener.a aVar2 = this.f5527p;
        aVar2.m2471f(new LoadEventInfo(aVar.f5538a, dataSpec, jElapsedRealtime), new MediaLoadData(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
    }

    /* JADX INFO: renamed from: D */
    public final boolean m2476D() {
        return this.f5514O || m2499w();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* JADX INFO: renamed from: a */
    public void mo2477a(SeekMap seekMap) {
        this.f5500A.post(new RunnableC2543h(this, seekMap));
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: b */
    public void mo2478b(Loader.InterfaceC10770e interfaceC10770e, long j, long j2, boolean z2) {
        a aVar = (a) interfaceC10770e;
        StatsDataSource statsDataSource = aVar.f5540c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.f5538a, aVar.f5548k, statsDataSource.f6643c, statsDataSource.f6644d, j, j2, statsDataSource.f6642b);
        Objects.requireNonNull(this.f5526o);
        MediaSourceEventListener.a aVar2 = this.f5527p;
        aVar2.m2468c(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
        if (z2) {
            return;
        }
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        for (SampleQueue sampleQueue : this.f5503D) {
            sampleQueue.m2540s(false);
        }
        if (this.f5515P > 0) {
            MediaPeriod.a aVar3 = this.f5501B;
            Objects.requireNonNull(aVar3);
            aVar3.mo2542a(this);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: c */
    public long mo2479c() {
        if (this.f5515P == 0) {
            return Long.MIN_VALUE;
        }
        return mo2493q();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: d */
    public void mo2480d(Loader.InterfaceC10770e interfaceC10770e, long j, long j2) {
        SeekMap seekMap;
        a aVar = (a) interfaceC10770e;
        if (this.f5510K == -9223372036854775807L && (seekMap = this.f5509J) != null) {
            boolean zMo3619c = seekMap.mo3619c();
            long jM2498v = m2498v();
            long j3 = jM2498v == Long.MIN_VALUE ? 0L : jM2498v + 10000;
            this.f5510K = j3;
            ((ProgressiveMediaSource) this.f5529r).m2512u(j3, zMo3619c, this.f5511L);
        }
        StatsDataSource statsDataSource = aVar.f5540c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.f5538a, aVar.f5548k, statsDataSource.f6643c, statsDataSource.f6644d, j, j2, statsDataSource.f6642b);
        Objects.requireNonNull(this.f5526o);
        MediaSourceEventListener.a aVar2 = this.f5527p;
        aVar2.m2469d(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        this.f5521V = true;
        MediaPeriod.a aVar3 = this.f5501B;
        Objects.requireNonNull(aVar3);
        aVar3.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: e */
    public void mo2481e() throws IOException {
        m2473A();
        if (this.f5521V && !this.f5506G) {
            throw ParserException.m8755a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: f */
    public long mo2482f(long j) {
        boolean z2;
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (!this.f5509J.mo3619c()) {
            j = 0;
        }
        this.f5514O = false;
        this.f5517R = j;
        if (m2499w()) {
            this.f5518S = j;
            return j;
        }
        if (this.f5512M != 7) {
            int length = this.f5503D.length;
            for (int i = 0; i < length; i++) {
                if (!this.f5503D[i].m2541t(j, false) && (zArr[i] || !this.f5507H)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return j;
            }
        }
        this.f5519T = false;
        this.f5518S = j;
        this.f5521V = false;
        if (this.f5533v.m8940b()) {
            for (SampleQueue sampleQueue : this.f5503D) {
                sampleQueue.m2529h();
            }
            Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = this.f5533v.f20232d;
            AnimatableValueParser.m438H(handlerC10769d);
            handlerC10769d.m8941a(false);
        } else {
            this.f5533v.f20233e = null;
            for (SampleQueue sampleQueue2 : this.f5503D) {
                sampleQueue2.m2540s(false);
            }
        }
        return j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: g */
    public boolean mo2483g(long j) {
        if (!this.f5521V) {
            if (!(this.f5533v.f20233e != null) && !this.f5519T && (!this.f5506G || this.f5515P != 0)) {
                boolean zM3026b = this.f5535x.m3026b();
                if (this.f5533v.m8940b()) {
                    return zM3026b;
                }
                m2475C();
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: h */
    public boolean mo2484h() {
        boolean z2;
        if (this.f5533v.m8940b()) {
            ConditionVariable conditionVariable = this.f5535x;
            synchronized (conditionVariable) {
                z2 = conditionVariable.f6728b;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: i */
    public long mo2485i(long j, SeekParameters seekParameters) {
        m2496t();
        if (!this.f5509J.mo3619c()) {
            return 0L;
        }
        SeekMap.a aVarMo3620h = this.f5509J.mo3620h(j);
        long j2 = aVarMo3620h.f8993a.f8998b;
        long j3 = aVarMo3620h.f8994b.f8998b;
        long j4 = seekParameters.f7191c;
        if (j4 == 0 && seekParameters.f7192d == 0) {
            return j;
        }
        int i = Util2.f6708a;
        long j5 = j - j4;
        long j6 = ((j4 ^ j) & (j ^ j5)) >= 0 ? j5 : Long.MIN_VALUE;
        long j7 = seekParameters.f7192d;
        long j8 = RecyclerView.FOREVER_NS;
        long j9 = j + j7;
        if (((j7 ^ j9) & (j ^ j9)) >= 0) {
            j8 = j9;
        }
        boolean z2 = false;
        boolean z3 = j6 <= j2 && j2 <= j8;
        if (j6 <= j3 && j3 <= j8) {
            z2 = true;
        }
        if (z3 && z2) {
            if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
                return j2;
            }
        } else {
            if (z3) {
                return j2;
            }
            if (!z2) {
                return j6;
            }
        }
        return j3;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* JADX INFO: renamed from: j */
    public void mo2486j() {
        this.f5505F = true;
        this.f5500A.post(this.f5536y);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: k */
    public long mo2487k() {
        if (!this.f5514O) {
            return -9223372036854775807L;
        }
        if (!this.f5521V && m2497u() <= this.f5520U) {
            return -9223372036854775807L;
        }
        this.f5514O = false;
        return this.f5517R;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: l */
    public void mo2488l(MediaPeriod.a aVar, long j) {
        this.f5501B = aVar;
        this.f5535x.m3026b();
        m2475C();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: m */
    public long mo2489m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        m2496t();
        e eVar = this.f5508I;
        TrackGroupArray trackGroupArray = eVar.f5557a;
        boolean[] zArr3 = eVar.f5559c;
        int i = this.f5515P;
        for (int i2 = 0; i2 < exoTrackSelection2Arr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelection2Arr[i2] == null || !zArr[i2])) {
                int i3 = ((c) sampleStreamArr[i2]).f5553a;
                AnimatableValueParser.m426D(zArr3[i3]);
                this.f5515P--;
                zArr3[i3] = false;
                sampleStreamArr[i2] = null;
            }
        }
        boolean z2 = !this.f5513N ? j == 0 : i != 0;
        for (int i4 = 0; i4 < exoTrackSelection2Arr.length; i4++) {
            if (sampleStreamArr[i4] == null && exoTrackSelection2Arr[i4] != null) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i4];
                AnimatableValueParser.m426D(exoTrackSelection2.length() == 1);
                AnimatableValueParser.m426D(exoTrackSelection2.mo2730f(0) == 0);
                int iM2575a = trackGroupArray.m2575a(exoTrackSelection2.mo2727a());
                AnimatableValueParser.m426D(!zArr3[iM2575a]);
                this.f5515P++;
                zArr3[iM2575a] = true;
                sampleStreamArr[i4] = new c(iM2575a);
                zArr2[i4] = true;
                if (!z2) {
                    SampleQueue sampleQueue = this.f5503D[iM2575a];
                    z2 = (sampleQueue.m2541t(j, true) || sampleQueue.m2532k() == 0) ? false : true;
                }
            }
        }
        if (this.f5515P == 0) {
            this.f5519T = false;
            this.f5514O = false;
            if (this.f5533v.m8940b()) {
                for (SampleQueue sampleQueue2 : this.f5503D) {
                    sampleQueue2.m2529h();
                }
                Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = this.f5533v.f20232d;
                AnimatableValueParser.m438H(handlerC10769d);
                handlerC10769d.m8941a(false);
            } else {
                for (SampleQueue sampleQueue3 : this.f5503D) {
                    sampleQueue3.m2540s(false);
                }
            }
        } else if (z2) {
            j = mo2482f(j);
            for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
                if (sampleStreamArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.f5513N = true;
        return j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: n */
    public TrackGroupArray mo2490n() {
        m2496t();
        return this.f5508I.f5557a;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader.C10768c mo2491o(Loader.InterfaceC10770e interfaceC10770e, long j, long j2, IOException iOException, int i) {
        long jMin;
        boolean z2;
        Loader.C10768c c10768cM8939a;
        SeekMap seekMap;
        boolean z3;
        a aVar = (a) interfaceC10770e;
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        StatsDataSource statsDataSource = aVar.f5540c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(aVar.f5538a, aVar.f5548k, statsDataSource.f6643c, statsDataSource.f6644d, j, j2, statsDataSource.f6642b);
        Util2.m2992M(aVar.f5547j);
        Util2.m2992M(this.f5510K);
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            jMin = -9223372036854775807L;
        } else {
            int i2 = DataSourceException.f20224j;
            Throwable cause = iOException;
            while (true) {
                if (cause == null) {
                    z3 = false;
                    break;
                }
                if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                    z3 = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (!z3) {
                jMin = Math.min((i - 1) * 1000, 5000);
            }
        }
        if (jMin == -9223372036854775807L) {
            c10768cM8939a = Loader.f20230b;
        } else {
            int iM2497u = m2497u();
            boolean z4 = iM2497u > this.f5520U;
            if (this.f5516Q != -1 || ((seekMap = this.f5509J) != null && seekMap.mo3621i() != -9223372036854775807L)) {
                this.f5520U = iM2497u;
            } else if (!this.f5506G || m2476D()) {
                this.f5514O = this.f5506G;
                this.f5517R = 0L;
                this.f5520U = 0;
                for (SampleQueue sampleQueue : this.f5503D) {
                    sampleQueue.m2540s(false);
                }
                aVar.f5544g.f8992a = 0L;
                aVar.f5547j = 0L;
                aVar.f5546i = true;
                aVar.f5551n = false;
            } else {
                this.f5519T = true;
                z2 = false;
                c10768cM8939a = !z2 ? Loader.m8939a(z4, jMin) : Loader.f20229a;
            }
            z2 = true;
            if (!z2) {
            }
        }
        int i3 = c10768cM8939a.f20234a;
        boolean z5 = !(i3 == 0 || i3 == 1);
        MediaSourceEventListener.a aVar2 = this.f5527p;
        aVar2.m2470e(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)), iOException, z5);
        if (z5) {
            Objects.requireNonNull(this.f5526o);
        }
        return c10768cM8939a;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorOutput
    /* JADX INFO: renamed from: p */
    public TrackOutput2 mo2492p(int i, int i2) {
        return m2474B(new d(i, false));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: q */
    public long mo2493q() {
        long jM2498v;
        boolean z2;
        long j;
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (this.f5521V) {
            return Long.MIN_VALUE;
        }
        if (m2499w()) {
            return this.f5518S;
        }
        if (this.f5507H) {
            int length = this.f5503D.length;
            jM2498v = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    SampleQueue sampleQueue = this.f5503D[i];
                    synchronized (sampleQueue) {
                        z2 = sampleQueue.f5619x;
                    }
                    if (z2) {
                        continue;
                    } else {
                        SampleQueue sampleQueue2 = this.f5503D[i];
                        synchronized (sampleQueue2) {
                            j = sampleQueue2.f5618w;
                        }
                        jM2498v = Math.min(jM2498v, j);
                    }
                }
            }
        } else {
            jM2498v = Long.MAX_VALUE;
        }
        if (jM2498v == RecyclerView.FOREVER_NS) {
            jM2498v = m2498v();
        }
        return jM2498v == Long.MIN_VALUE ? this.f5517R : jM2498v;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: r */
    public void mo2494r(long j, boolean z2) {
        long jM2528g;
        int i;
        m2496t();
        if (m2499w()) {
            return;
        }
        boolean[] zArr = this.f5508I.f5559c;
        int length = this.f5503D.length;
        for (int i2 = 0; i2 < length; i2++) {
            SampleQueue sampleQueue = this.f5503D[i2];
            boolean z3 = zArr[i2];
            SampleDataQueue sampleDataQueue = sampleQueue.f5596a;
            synchronized (sampleQueue) {
                int i3 = sampleQueue.f5612q;
                jM2528g = -1;
                if (i3 != 0) {
                    long[] jArr = sampleQueue.f5610o;
                    int i4 = sampleQueue.f5614s;
                    if (j >= jArr[i4]) {
                        int iM2530i = sampleQueue.m2530i(i4, (!z3 || (i = sampleQueue.f5615t) == i3) ? i3 : i + 1, j, z2);
                        if (iM2530i != -1) {
                            jM2528g = sampleQueue.m2528g(iM2530i);
                        }
                    }
                }
            }
            sampleDataQueue.m2518a(jM2528g);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: s */
    public void mo2495s(long j) {
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    /* JADX INFO: renamed from: t */
    public final void m2496t() {
        AnimatableValueParser.m426D(this.f5506G);
        Objects.requireNonNull(this.f5508I);
        Objects.requireNonNull(this.f5509J);
    }

    /* JADX INFO: renamed from: u */
    public final int m2497u() {
        int iM2535n = 0;
        for (SampleQueue sampleQueue : this.f5503D) {
            iM2535n += sampleQueue.m2535n();
        }
        return iM2535n;
    }

    /* JADX INFO: renamed from: v */
    public final long m2498v() {
        long j;
        long jMax = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.f5503D) {
            synchronized (sampleQueue) {
                j = sampleQueue.f5618w;
            }
            jMax = Math.max(jMax, j);
        }
        return jMax;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m2499w() {
        return this.f5518S != -9223372036854775807L;
    }

    /* JADX INFO: renamed from: x */
    public final void m2500x() {
        if (this.f5522W || this.f5506G || !this.f5505F || this.f5509J == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.f5503D) {
            if (sampleQueue.m2534m() == null) {
                return;
            }
        }
        this.f5535x.m3025a();
        int length = this.f5503D.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            Format2 format2M2534m = this.f5503D[i].m2534m();
            Objects.requireNonNull(format2M2534m);
            String str = format2M2534m.f7155w;
            boolean zM3050h = MimeTypes.m3050h(str);
            boolean z2 = zM3050h || MimeTypes.m3052j(str);
            zArr[i] = z2;
            this.f5507H = z2 | this.f5507H;
            IcyHeaders icyHeaders = this.f5502C;
            if (icyHeaders != null) {
                if (zM3050h || this.f5504E[i].f5556b) {
                    Metadata metadata = format2M2534m.f7153u;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.m8877a(icyHeaders);
                    Format2.b bVarM3275a = format2M2534m.m3275a();
                    bVarM3275a.f7171i = metadata2;
                    format2M2534m = bVarM3275a.m3277a();
                }
                if (zM3050h && format2M2534m.f7149q == -1 && format2M2534m.f7150r == -1 && icyHeaders.f19957j != -1) {
                    Format2.b bVarM3275a2 = format2M2534m.m3275a();
                    bVarM3275a2.f7168f = icyHeaders.f19957j;
                    format2M2534m = bVarM3275a2.m3277a();
                }
            }
            int iMo3600d = this.f5525n.mo3600d(format2M2534m);
            Format2.b bVarM3275a3 = format2M2534m.m3275a();
            bVarM3275a3.f7162D = iMo3600d;
            trackGroupArr[i] = new TrackGroup(bVarM3275a3.m3277a());
        }
        this.f5508I = new e(new TrackGroupArray(trackGroupArr), zArr);
        this.f5506G = true;
        MediaPeriod.a aVar = this.f5501B;
        Objects.requireNonNull(aVar);
        aVar.mo2563b(this);
    }

    /* JADX INFO: renamed from: y */
    public final void m2501y(int i) {
        m2496t();
        e eVar = this.f5508I;
        boolean[] zArr = eVar.f5560d;
        if (zArr[i]) {
            return;
        }
        Format2 format2 = eVar.f5557a.f5676l[i].f5662l[0];
        MediaSourceEventListener.a aVar = this.f5527p;
        aVar.m2467b(new MediaLoadData(1, MimeTypes.m3049g(format2.f7155w), format2, 0, null, aVar.m2466a(this.f5517R), -9223372036854775807L));
        zArr[i] = true;
    }

    /* JADX INFO: renamed from: z */
    public final void m2502z(int i) {
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (this.f5519T && zArr[i] && !this.f5503D[i].m2537p(false)) {
            this.f5518S = 0L;
            this.f5519T = false;
            this.f5514O = true;
            this.f5517R = 0L;
            this.f5520U = 0;
            for (SampleQueue sampleQueue : this.f5503D) {
                sampleQueue.m2540s(false);
            }
            MediaPeriod.a aVar = this.f5501B;
            Objects.requireNonNull(aVar);
            aVar.mo2542a(this);
        }
    }
}
