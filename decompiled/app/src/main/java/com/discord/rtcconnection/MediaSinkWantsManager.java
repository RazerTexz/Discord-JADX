package com.discord.rtcconnection;

import b.a.q.e;
import b.a.q.h;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;

/* compiled from: MediaSinkWantsManager.kt */
/* loaded from: classes.dex */
public final class MediaSinkWantsManager implements MediaEngineConnection.d {
    public final Map<Long, Long> a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Long, List<b>> f2771b;
    public final Set<Long> c;
    public MediaEngineConnection d;
    public Long e;
    public final BehaviorSubject<Map<String, EncodeQuality>> f;
    public Map<String, ? extends EncodeQuality> g;
    public final long h;
    public final b.a.q.c i;
    public final e j;
    public final Logger k;
    public final a l;

    /* compiled from: MediaSinkWantsManager.kt */
    public enum VideoQualityMode {
        AUTO(1),
        FULL(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int numeral;

        /* compiled from: MediaSinkWantsManager.kt */
        /* renamed from: com.discord.rtcconnection.MediaSinkWantsManager$VideoQualityMode$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final VideoQualityMode a(Integer num) {
                return (num != null && num.intValue() == 1) ? VideoQualityMode.AUTO : (num != null && num.intValue() == 2) ? VideoQualityMode.FULL : VideoQualityMode.AUTO;
            }
        }

        VideoQualityMode(int i) {
            this.numeral = i;
        }

        public final int getNumeral() {
            return this.numeral;
        }
    }

    /* compiled from: MediaSinkWantsManager.kt */
    public interface a {
        void a(long j, long j2, long j3, VideoMetadata videoMetadata);
    }

    /* compiled from: MediaSinkWantsManager.kt */
    public static final class b {
        public final EncodeQuality a;

        /* renamed from: b, reason: collision with root package name */
        public final long f2772b;
        public final VideoMetadata c;

        public b(EncodeQuality encodeQuality, long j, VideoMetadata videoMetadata) {
            m.checkNotNullParameter(encodeQuality, "encodeQuality");
            this.a = encodeQuality;
            this.f2772b = j;
            this.c = videoMetadata;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && this.f2772b == bVar.f2772b && m.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            EncodeQuality encodeQuality = this.a;
            int iA = (a0.a.a.b.a(this.f2772b) + ((encodeQuality != null ? encodeQuality.hashCode() : 0) * 31)) * 31;
            VideoMetadata videoMetadata = this.c;
            return iA + (videoMetadata != null ? videoMetadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("VideoStreamDescriptor(encodeQuality=");
            sbU.append(this.a);
            sbU.append(", ssrc=");
            sbU.append(this.f2772b);
            sbU.append(", metadata=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MediaSinkWantsManager.kt */
    public static final class c extends o implements Function0<Unit> {
        public final /* synthetic */ Long $ssrc;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Long l, long j) {
            super(0);
            this.$ssrc = l;
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.$ssrc != null) {
                MediaSinkWantsManager.this.a.put(Long.valueOf(this.$userId), this.$ssrc);
            } else {
                MediaSinkWantsManager.this.a.remove(Long.valueOf(this.$userId));
            }
            MediaSinkWantsManager.e(MediaSinkWantsManager.this, null, 1);
            return Unit.a;
        }
    }

    public MediaSinkWantsManager(long j, b.a.q.c cVar, e eVar, Logger logger, a aVar) {
        m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        m.checkNotNullParameter(eVar, "ladder");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(aVar, "listener");
        this.h = j;
        this.i = cVar;
        this.j = eVar;
        this.k = logger;
        this.l = aVar;
        this.a = new LinkedHashMap();
        this.f2771b = new LinkedHashMap();
        new LinkedHashMap();
        this.c = new LinkedHashSet();
        this.f = BehaviorSubject.l0(g0.mapOf(d0.o.to("any", EncodeQuality.Hundred)));
        this.g = h0.emptyMap();
    }

    public static /* synthetic */ void e(MediaSinkWantsManager mediaSinkWantsManager, List list, int i) {
        mediaSinkWantsManager.d((i & 1) != 0 ? n.emptyList() : null);
    }

    public final void a(String str) {
        Logger.w$default(this.k, "MediaSinkWantsManager", str, null, 4, null);
    }

    public final Future<?> b(Function0<Unit> function0) {
        b.a.q.c cVar = this.i;
        return cVar.l.submit(new b.a.q.m(function0));
    }

    public final Future<?> c(long j, Long l) {
        return b(new c(l, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(List<String> list) {
        int i;
        e.c cVarPrevious;
        EncodeQuality encodeQuality;
        Iterator<Map.Entry<Long, List<b>>> it;
        long j;
        EncodeQuality encodeQuality2;
        MediaEngineConnection mediaEngineConnection = this.d;
        if (mediaEngineConnection != null) {
            e eVar = this.j;
            int i2 = 1;
            if (mediaEngineConnection != null) {
                Set<Long> set = this.c;
                if ((set instanceof Collection) && set.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it2 = set.iterator();
                    i = 0;
                    while (it2.hasNext()) {
                        if ((!mediaEngineConnection.g(((Number) it2.next()).longValue())) && (i = i + 1) < 0) {
                            n.throwCountOverflow();
                        }
                    }
                }
            }
            Objects.requireNonNull(eVar);
            if (i < 0) {
                encodeQuality = EncodeQuality.Hundred;
            } else {
                List<e.c> list2 = eVar.d;
                ListIterator<e.c> listIterator = list2.listIterator(list2.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        cVarPrevious = listIterator.previous();
                        if (cVarPrevious.f259b * i <= eVar.f257b) {
                            break;
                        }
                    } else {
                        cVarPrevious = null;
                        break;
                    }
                }
                e.c cVar = cVarPrevious;
                if (cVar == null) {
                    cVar = (e.c) u.first((List) eVar.d);
                }
                encodeQuality = cVar.c;
            }
            Map<String, EncodeQuality> mapMutableMapOf = h0.mutableMapOf(d0.o.to("any", encodeQuality));
            Iterator<Map.Entry<Long, List<b>>> it3 = this.f2771b.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry<Long, List<b>> next = it3.next();
                long jLongValue = next.getKey().longValue();
                List<b> value = next.getValue();
                b bVar = (b) u.firstOrNull((List) value);
                if (bVar != null) {
                    Long l = this.e;
                    if (l != null) {
                        long j2 = this.h;
                        if (l != null && l.longValue() == j2) {
                            if (value.size() > 1) {
                                for (b bVar2 : value) {
                                    if (bVar2.a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(bVar2.f2772b), EncodeQuality.Zero);
                                    } else {
                                        bVar = bVar2;
                                    }
                                }
                            }
                        } else if (value.size() > i2) {
                            Long l2 = this.e;
                            if (l2 != null && jLongValue == l2.longValue()) {
                                for (b bVar3 : value) {
                                    EncodeQuality encodeQuality3 = bVar3.a;
                                    EncodeQuality encodeQuality4 = EncodeQuality.Hundred;
                                    if (encodeQuality3 == encodeQuality4) {
                                        mapMutableMapOf.put(String.valueOf(bVar3.f2772b), encodeQuality4);
                                        bVar = bVar3;
                                    } else {
                                        mapMutableMapOf.put(String.valueOf(bVar3.f2772b), EncodeQuality.Zero);
                                    }
                                }
                            } else {
                                for (b bVar4 : value) {
                                    if (bVar4.a == EncodeQuality.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(bVar4.f2772b), EncodeQuality.Zero);
                                    } else {
                                        bVar = bVar4;
                                    }
                                }
                            }
                        } else {
                            Long l3 = this.e;
                            if (l3 != null && jLongValue == l3.longValue() && encodeQuality != (encodeQuality2 = EncodeQuality.Hundred)) {
                                mapMutableMapOf.put(String.valueOf(bVar.f2772b), encodeQuality2);
                            }
                        }
                        if (mediaEngineConnection.g(jLongValue) || mediaEngineConnection.p(jLongValue)) {
                            Iterator<b> it4 = value.iterator();
                            while (it4.hasNext()) {
                                mapMutableMapOf.put(String.valueOf(it4.next().f2772b), EncodeQuality.Zero);
                            }
                        }
                        if (list.contains(String.valueOf(jLongValue))) {
                            Long l4 = this.a.get(Long.valueOf(jLongValue));
                            if (l4 != null) {
                                it = it3;
                                j = jLongValue;
                                this.l.a(jLongValue, l4.longValue(), bVar.f2772b, bVar.c);
                            } else {
                                it = it3;
                                j = jLongValue;
                                a("Missing audioSsrc for user " + j + ", can't update video ssrc!");
                            }
                        } else {
                            it = it3;
                            j = jLongValue;
                        }
                        EncodeQuality encodeQuality5 = this.g.get(String.valueOf(bVar.f2772b));
                        EncodeQuality encodeQuality6 = EncodeQuality.Zero;
                        if (encodeQuality5 == encodeQuality6 && mapMutableMapOf.get(String.valueOf(bVar.f2772b)) != encodeQuality6) {
                            mediaEngineConnection.i(j, false);
                        }
                        if (encodeQuality5 != encodeQuality6 && mapMutableMapOf.get(String.valueOf(bVar.f2772b)) == encodeQuality6) {
                            mediaEngineConnection.i(j, true);
                        }
                        it3 = it;
                    }
                }
                i2 = 1;
            }
            for (Map.Entry<Long, Long> entry : this.a.entrySet()) {
                long jLongValue2 = entry.getKey().longValue();
                long jLongValue3 = entry.getValue().longValue();
                if (mediaEngineConnection.u(jLongValue2)) {
                    mapMutableMapOf.put(String.valueOf(jLongValue3), EncodeQuality.Zero);
                }
            }
            this.g = mapMutableMapOf;
            this.f.onNext(mapMutableMapOf);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<b.a.q.m0.a> list) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(transportInfo, "transportInfo");
        m.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(connectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(failedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalMute(long j, boolean z2) {
        b(new h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onLocalVideoOffScreen(long j, boolean z2) {
        b(new h(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        m.checkNotNullParameter(streamParametersArr, "streams");
    }
}
