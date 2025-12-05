package com.discord.rtcconnection;

import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
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
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p041q.MediaEngineExecutorService;
import p007b.p008a.p041q.MediaSinkWantsLadder3;
import p007b.p008a.p041q.MediaSinkWantsManager3;
import p007b.p008a.p041q.MediaSinkWantsManager8;
import p007b.p008a.p041q.p044m0.Codec2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.BehaviorSubject;

/* compiled from: MediaSinkWantsManager.kt */
/* loaded from: classes.dex */
public final class MediaSinkWantsManager implements MediaEngineConnection.InterfaceC5648d {

    /* renamed from: a */
    public final Map<Long, Long> f18742a;

    /* renamed from: b */
    public final Map<Long, List<C5603b>> f18743b;

    /* renamed from: c */
    public final Set<Long> f18744c;

    /* renamed from: d */
    public MediaEngineConnection f18745d;

    /* renamed from: e */
    public Long f18746e;

    /* renamed from: f */
    public final BehaviorSubject<Map<String, MediaSinkWantsManager9>> f18747f;

    /* renamed from: g */
    public Map<String, ? extends MediaSinkWantsManager9> f18748g;

    /* renamed from: h */
    public final long f18749h;

    /* renamed from: i */
    public final MediaEngineExecutorService f18750i;

    /* renamed from: j */
    public final MediaSinkWantsLadder3 f18751j;

    /* renamed from: k */
    public final Logger f18752k;

    /* renamed from: l */
    public final InterfaceC5602a f18753l;

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

            /* renamed from: a */
            public final VideoQualityMode m8457a(Integer num) {
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
    /* renamed from: com.discord.rtcconnection.MediaSinkWantsManager$a */
    public interface InterfaceC5602a {
        /* renamed from: a */
        void mo8458a(long j, long j2, long j3, VideoMetadata videoMetadata);
    }

    /* compiled from: MediaSinkWantsManager.kt */
    /* renamed from: com.discord.rtcconnection.MediaSinkWantsManager$b */
    public static final class C5603b {

        /* renamed from: a */
        public final MediaSinkWantsManager9 f18754a;

        /* renamed from: b */
        public final long f18755b;

        /* renamed from: c */
        public final VideoMetadata f18756c;

        public C5603b(MediaSinkWantsManager9 mediaSinkWantsManager9, long j, VideoMetadata videoMetadata) {
            Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "encodeQuality");
            this.f18754a = mediaSinkWantsManager9;
            this.f18755b = j;
            this.f18756c = videoMetadata;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5603b)) {
                return false;
            }
            C5603b c5603b = (C5603b) obj;
            return Intrinsics3.areEqual(this.f18754a, c5603b.f18754a) && this.f18755b == c5603b.f18755b && Intrinsics3.areEqual(this.f18756c, c5603b.f18756c);
        }

        public int hashCode() {
            MediaSinkWantsManager9 mediaSinkWantsManager9 = this.f18754a;
            int iM3a = (C0002b.m3a(this.f18755b) + ((mediaSinkWantsManager9 != null ? mediaSinkWantsManager9.hashCode() : 0) * 31)) * 31;
            VideoMetadata videoMetadata = this.f18756c;
            return iM3a + (videoMetadata != null ? videoMetadata.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("VideoStreamDescriptor(encodeQuality=");
            sbM833U.append(this.f18754a);
            sbM833U.append(", ssrc=");
            sbM833U.append(this.f18755b);
            sbM833U.append(", metadata=");
            sbM833U.append(this.f18756c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: MediaSinkWantsManager.kt */
    /* renamed from: com.discord.rtcconnection.MediaSinkWantsManager$c */
    public static final class C5604c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $ssrc;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5604c(Long l, long j) {
            super(0);
            this.$ssrc = l;
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.$ssrc != null) {
                MediaSinkWantsManager.this.f18742a.put(Long.valueOf(this.$userId), this.$ssrc);
            } else {
                MediaSinkWantsManager.this.f18742a.remove(Long.valueOf(this.$userId));
            }
            MediaSinkWantsManager.m8452e(MediaSinkWantsManager.this, null, 1);
            return Unit.f27425a;
        }
    }

    public MediaSinkWantsManager(long j, MediaEngineExecutorService mediaEngineExecutorService, MediaSinkWantsLadder3 mediaSinkWantsLadder3, Logger logger, InterfaceC5602a interfaceC5602a) {
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder3, "ladder");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(interfaceC5602a, "listener");
        this.f18749h = j;
        this.f18750i = mediaEngineExecutorService;
        this.f18751j = mediaSinkWantsLadder3;
        this.f18752k = logger;
        this.f18753l = interfaceC5602a;
        this.f18742a = new LinkedHashMap();
        this.f18743b = new LinkedHashMap();
        new LinkedHashMap();
        this.f18744c = new LinkedHashSet();
        this.f18747f = BehaviorSubject.m11130l0(MapsJVM.mapOf(Tuples.m10073to("any", MediaSinkWantsManager9.Hundred)));
        this.f18748g = Maps6.emptyMap();
    }

    /* renamed from: e */
    public static /* synthetic */ void m8452e(MediaSinkWantsManager mediaSinkWantsManager, List list, int i) {
        mediaSinkWantsManager.m8456d((i & 1) != 0 ? Collections2.emptyList() : null);
    }

    /* renamed from: a */
    public final void m8453a(String str) {
        Logger.w$default(this.f18752k, "MediaSinkWantsManager", str, null, 4, null);
    }

    /* renamed from: b */
    public final Future<?> m8454b(Function0<Unit> function0) {
        MediaEngineExecutorService mediaEngineExecutorService = this.f18750i;
        return mediaEngineExecutorService.f1609l.submit(new MediaSinkWantsManager8(function0));
    }

    /* renamed from: c */
    public final Future<?> m8455c(long j, Long l) {
        return m8454b(new C5604c(l, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014a  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8456d(List<String> list) {
        int i;
        MediaSinkWantsLadder3.c cVarPrevious;
        MediaSinkWantsManager9 mediaSinkWantsManager9;
        Iterator<Map.Entry<Long, List<C5603b>>> it;
        long j;
        MediaSinkWantsManager9 mediaSinkWantsManager92;
        MediaEngineConnection mediaEngineConnection = this.f18745d;
        if (mediaEngineConnection != null) {
            MediaSinkWantsLadder3 mediaSinkWantsLadder3 = this.f18751j;
            int i2 = 1;
            if (mediaEngineConnection != null) {
                Set<Long> set = this.f18744c;
                if ((set instanceof Collection) && set.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it2 = set.iterator();
                    i = 0;
                    while (it2.hasNext()) {
                        if ((!mediaEngineConnection.mo301g(((Number) it2.next()).longValue())) && (i = i + 1) < 0) {
                            Collections2.throwCountOverflow();
                        }
                    }
                }
            }
            Objects.requireNonNull(mediaSinkWantsLadder3);
            if (i < 0) {
                mediaSinkWantsManager9 = MediaSinkWantsManager9.Hundred;
            } else {
                List<MediaSinkWantsLadder3.c> list2 = mediaSinkWantsLadder3.f1616d;
                ListIterator<MediaSinkWantsLadder3.c> listIterator = list2.listIterator(list2.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        cVarPrevious = listIterator.previous();
                        if (cVarPrevious.f1623b * i <= mediaSinkWantsLadder3.f1614b) {
                            break;
                        }
                    } else {
                        cVarPrevious = null;
                        break;
                    }
                }
                MediaSinkWantsLadder3.c cVar = cVarPrevious;
                if (cVar == null) {
                    cVar = (MediaSinkWantsLadder3.c) _Collections.first((List) mediaSinkWantsLadder3.f1616d);
                }
                mediaSinkWantsManager9 = cVar.f1624c;
            }
            Map<String, MediaSinkWantsManager9> mapMutableMapOf = Maps6.mutableMapOf(Tuples.m10073to("any", mediaSinkWantsManager9));
            Iterator<Map.Entry<Long, List<C5603b>>> it3 = this.f18743b.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry<Long, List<C5603b>> next = it3.next();
                long jLongValue = next.getKey().longValue();
                List<C5603b> value = next.getValue();
                C5603b c5603b = (C5603b) _Collections.firstOrNull((List) value);
                if (c5603b != null) {
                    Long l = this.f18746e;
                    if (l != null) {
                        long j2 = this.f18749h;
                        if (l != null && l.longValue() == j2) {
                            if (value.size() > 1) {
                                for (C5603b c5603b2 : value) {
                                    if (c5603b2.f18754a == MediaSinkWantsManager9.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(c5603b2.f18755b), MediaSinkWantsManager9.Zero);
                                    } else {
                                        c5603b = c5603b2;
                                    }
                                }
                            }
                        } else if (value.size() > i2) {
                            Long l2 = this.f18746e;
                            if (l2 != null && jLongValue == l2.longValue()) {
                                for (C5603b c5603b3 : value) {
                                    MediaSinkWantsManager9 mediaSinkWantsManager93 = c5603b3.f18754a;
                                    MediaSinkWantsManager9 mediaSinkWantsManager94 = MediaSinkWantsManager9.Hundred;
                                    if (mediaSinkWantsManager93 == mediaSinkWantsManager94) {
                                        mapMutableMapOf.put(String.valueOf(c5603b3.f18755b), mediaSinkWantsManager94);
                                        c5603b = c5603b3;
                                    } else {
                                        mapMutableMapOf.put(String.valueOf(c5603b3.f18755b), MediaSinkWantsManager9.Zero);
                                    }
                                }
                            } else {
                                for (C5603b c5603b4 : value) {
                                    if (c5603b4.f18754a == MediaSinkWantsManager9.Hundred) {
                                        mapMutableMapOf.put(String.valueOf(c5603b4.f18755b), MediaSinkWantsManager9.Zero);
                                    } else {
                                        c5603b = c5603b4;
                                    }
                                }
                            }
                        } else {
                            Long l3 = this.f18746e;
                            if (l3 != null && jLongValue == l3.longValue() && mediaSinkWantsManager9 != (mediaSinkWantsManager92 = MediaSinkWantsManager9.Hundred)) {
                                mapMutableMapOf.put(String.valueOf(c5603b.f18755b), mediaSinkWantsManager92);
                            }
                        }
                        if (mediaEngineConnection.mo301g(jLongValue) || mediaEngineConnection.mo310p(jLongValue)) {
                            Iterator<C5603b> it4 = value.iterator();
                            while (it4.hasNext()) {
                                mapMutableMapOf.put(String.valueOf(it4.next().f18755b), MediaSinkWantsManager9.Zero);
                            }
                        }
                        if (list.contains(String.valueOf(jLongValue))) {
                            Long l4 = this.f18742a.get(Long.valueOf(jLongValue));
                            if (l4 != null) {
                                it = it3;
                                j = jLongValue;
                                this.f18753l.mo8458a(jLongValue, l4.longValue(), c5603b.f18755b, c5603b.f18756c);
                            } else {
                                it = it3;
                                j = jLongValue;
                                m8453a("Missing audioSsrc for user " + j + ", can't update video ssrc!");
                            }
                        } else {
                            it = it3;
                            j = jLongValue;
                        }
                        MediaSinkWantsManager9 mediaSinkWantsManager95 = this.f18748g.get(String.valueOf(c5603b.f18755b));
                        MediaSinkWantsManager9 mediaSinkWantsManager96 = MediaSinkWantsManager9.Zero;
                        if (mediaSinkWantsManager95 == mediaSinkWantsManager96 && mapMutableMapOf.get(String.valueOf(c5603b.f18755b)) != mediaSinkWantsManager96) {
                            mediaEngineConnection.mo303i(j, false);
                        }
                        if (mediaSinkWantsManager95 != mediaSinkWantsManager96 && mapMutableMapOf.get(String.valueOf(c5603b.f18755b)) == mediaSinkWantsManager96) {
                            mediaEngineConnection.mo303i(j, true);
                        }
                        it3 = it;
                    }
                }
                i2 = 1;
            }
            for (Map.Entry<Long, Long> entry : this.f18742a.entrySet()) {
                long jLongValue2 = entry.getKey().longValue();
                long jLongValue3 = entry.getValue().longValue();
                if (mediaEngineConnection.mo315u(jLongValue2)) {
                    mapMutableMapOf.put(String.valueOf(jLongValue3), MediaSinkWantsManager9.Zero);
                }
            }
            this.f18748g = mapMutableMapOf;
            this.f18747f.onNext(mapMutableMapOf);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<Codec2> list) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(status, "status");
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalMute(long j, boolean z2) {
        m8454b(new MediaSinkWantsManager3(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onLocalVideoOffScreen(long j, boolean z2) {
        m8454b(new MediaSinkWantsManager3(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onSpeaking(long j, int i, boolean z2) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetBitrate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onTargetFrameRate(int i) {
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
    public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
        Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
    }
}
