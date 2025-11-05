package b.a.q.m0.c;

import android.content.Intent;
import android.media.projection.MediaProjection;
import co.discord.media_engine.AudioDecoder;
import co.discord.media_engine.AudioEncoder;
import co.discord.media_engine.Connection;
import co.discord.media_engine.EncryptionSettings;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VideoDecoder;
import co.discord.media_engine.VideoEncoder;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.g0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: MediaEngineConnectionLegacy.kt */
/* loaded from: classes.dex */
public final class e implements MediaEngineConnection {
    public final CopyOnWriteArrayList<MediaEngineConnection.d> a;

    /* renamed from: b, reason: collision with root package name */
    public MediaEngineConnection.ConnectionState f270b;
    public boolean c;
    public final Map<Long, Integer> d;
    public final Map<Long, Long> e;
    public final Set<Long> f;
    public final Set<Long> g;
    public final Set<Long> h;
    public final List<b.a.q.m0.a> i;
    public final Connection j;
    public final b.a.q.c k;
    public final Logger l;
    public final b.a.q.m0.c.u m;
    public final Discord n;
    public final List<b.a.q.m0.a> o;
    public final MediaEngineConnection.Type p;
    public final long q;

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ int $audioSsrc;
        public final /* synthetic */ boolean $isMuted;
        public final /* synthetic */ long $resolvedVideoSsrc;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, long j2, boolean z2, float f) {
            super(1);
            this.$userId = j;
            this.$audioSsrc = i;
            this.$resolvedVideoSsrc = j2;
            this.$isMuted = z2;
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            long j = this.$userId;
            int i = this.$audioSsrc;
            int i2 = (int) this.$resolvedVideoSsrc;
            Objects.requireNonNull(e.this);
            connection2.connectUser(j, i, i2, i2 > 0 ? i2 + 1 : 0, this.$isMuted, this.$volume);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<Connection, Unit> {
        public static final b j = new b();

        public b() {
            super(1, Connection.class, "dispose", "dispose()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "p1");
            connection2.dispose();
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class c extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onConnectionStateChange(e.this, MediaEngineConnection.ConnectionState.DISCONNECTED);
            dVar2.onDestroy(e.this);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class d extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $disabled;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$disabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.disableVideo(this.$userId, this.$disabled);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$e, reason: collision with other inner class name */
    public static final class C0043e extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ KrispOveruseDetector.Status $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0043e(KrispOveruseDetector.Status status) {
            super(1);
            this.$status = status;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onKrispStatus(e.this, this.$status);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class f extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ Function1 $onStats;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function1 function1) {
            super(1);
            this.$onStats = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.getStats(new b.a.q.m0.c.f(this));
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class g extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ MediaEngineConnection.FailedConnectionException $e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MediaEngineConnection.FailedConnectionException failedConnectionException) {
            super(1);
            this.$e = failedConnectionException;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onError(e.this, this.$e);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class h extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ AudioDecoder $audioDecoder;
        public final /* synthetic */ AudioEncoder $audioEncoder;
        public final /* synthetic */ VideoDecoder $videoDecoder;
        public final /* synthetic */ VideoEncoder $videoEncoder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AudioEncoder audioEncoder, VideoEncoder videoEncoder, AudioDecoder audioDecoder, VideoDecoder videoDecoder) {
            super(1);
            this.$audioEncoder = audioEncoder;
            this.$videoEncoder = videoEncoder;
            this.$audioDecoder = audioDecoder;
            this.$videoDecoder = videoDecoder;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setCodecs(this.$audioEncoder, this.$videoEncoder, new AudioDecoder[]{this.$audioDecoder}, new VideoDecoder[]{this.$videoDecoder});
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class i extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ EncryptionSettings $encryptionSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EncryptionSettings encryptionSettings) {
            super(1);
            this.$encryptionSettings = encryptionSettings;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setEncryptionSettings(this.$encryptionSettings);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class j extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ MediaEngineConnection.InputMode $inputMode;
        public final /* synthetic */ MediaEngineConnection.c $inputModeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MediaEngineConnection.c cVar, MediaEngineConnection.InputMode inputMode) {
            super(1);
            this.$inputModeOptions = cVar;
            this.$inputMode = inputMode;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setVADLeadingFramesToBuffer(this.$inputModeOptions.f2800b);
            connection2.setVADTrailingFramesToSend(this.$inputModeOptions.c);
            connection2.setVADTriggerThreshold(this.$inputModeOptions.a);
            connection2.setVADAutoThreshold(this.$inputModeOptions.d ? 3 : -1);
            connection2.setVADUseKrisp(this.$inputModeOptions.e);
            connection2.setAudioInputMode(this.$inputMode.getNumeral());
            connection2.enableForwardErrorCorrection(true);
            connection2.setExpectedPacketLossRate(0.3f);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class k extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.muteUser(this.$userId, this.$mute);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class l extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onLocalMute(this.$userId, this.$mute);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class m extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ boolean $offScreen;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$offScreen = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onLocalVideoOffScreen(this.$userId, this.$offScreen);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class n extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ long $userId;
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(long j, float f) {
            super(1);
            this.$userId = j;
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setUserPlayoutVolume(this.$userId, this.$volume / 100.0f);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class o extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $active;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z2) {
            super(1);
            this.$active = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setPTTActive(this.$active);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class p extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ int $frameRate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(1);
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onTargetFrameRate(this.$frameRate);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class q extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ MediaEngineConnection.b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(MediaEngineConnection.b bVar) {
            super(1);
            this.$quality = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "it");
            dVar2.onTargetBitrate(this.$quality.f2799b);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class r extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ int $frameRate;
        public final /* synthetic */ MediaEngineConnection.b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MediaEngineConnection.b bVar, int i) {
            super(1);
            this.$quality = bVar;
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            MediaEngineConnection.b bVar = this.$quality;
            connection2.setEncodingQuality(bVar.a, bVar.f2799b, bVar.c, bVar.d, this.$frameRate);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class s extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfDeaf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(boolean z2) {
            super(1);
            this.$selfDeaf = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.deafenLocalUser(this.$selfDeaf);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class t extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfMute;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(boolean z2) {
            super(1);
            this.$selfMute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.muteLocalUser(this.$selfMute);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class u extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $isVideoBroadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(boolean z2) {
            super(1);
            this.$isVideoBroadcast = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.setVideoBroadcast(this.$isVideoBroadcast);
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class v extends d0.z.d.o implements Function1<Connection, Unit> {
        public final /* synthetic */ b.a.q.m0.b $screenCapturer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(b.a.q.m0.b bVar) {
            super(1);
            this.$screenCapturer = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            b.a.q.m0.b bVar = this.$screenCapturer;
            connection2.startScreenshareBroadcast(bVar, bVar.o.getNativeInstance());
            return Unit.a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class w extends MediaProjection.Callback {
        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class x extends d0.z.d.o implements Function1<Connection, Unit> {
        public static final x j = new x();

        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
            connection2.stopScreenshareBroadcast();
            return Unit.a;
        }
    }

    public e(b.a.q.c cVar, Logger logger, b.a.q.m0.c.u uVar, Discord discord, List<b.a.q.m0.a> list, MediaEngineConnection.Type type, long j2, MediaEngine.a aVar, List<? extends MediaEngineConnection.d> list2) {
        d0.z.d.m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        d0.z.d.m.checkNotNullParameter(logger, "logger");
        d0.z.d.m.checkNotNullParameter(uVar, "noiseCancellationConfig");
        d0.z.d.m.checkNotNullParameter(discord, "voiceEngineLegacy");
        d0.z.d.m.checkNotNullParameter(list, "supportedVideoCodecs");
        d0.z.d.m.checkNotNullParameter(type, "type");
        d0.z.d.m.checkNotNullParameter(aVar, "connectionOptions");
        d0.z.d.m.checkNotNullParameter(list2, "listeners");
        this.k = cVar;
        this.l = logger;
        this.m = uVar;
        this.n = discord;
        this.o = list;
        this.p = type;
        this.q = j2;
        MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTING;
        this.f270b = connectionState;
        this.d = h0.mutableMapOf(d0.o.to(Long.valueOf(j2), Integer.valueOf(aVar.a)));
        this.e = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = new ArrayList();
        int i2 = aVar.a;
        String str = aVar.f2797b;
        int i3 = aVar.c;
        Object[] array = aVar.d.toArray(new StreamParameters[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Connection connectionConnectToServer = discord.connectToServer(i2, j2, str, i3, (StreamParameters[]) array, new b.a.q.m0.c.d(this));
        d0.z.d.m.checkNotNullExpressionValue(connectionConnectToServer, "voiceEngineLegacy.connec…fo, errorMessage) }\n    }");
        connectionConnectToServer.setOnVideoCallback(new b.a.q.m0.c.b(this));
        connectionConnectToServer.setUserSpeakingStatusChangedCallback(new b.a.q.m0.c.c(this));
        this.j = connectionConnectToServer;
        this.a = new CopyOnWriteArrayList<>(list2);
        this.f270b = connectionState;
        y(new b.a.q.m0.c.a(this, connectionState));
    }

    public static final void x(e eVar, Function0 function0) {
        b.a.q.c cVar = eVar.k;
        cVar.l.execute(new b.a.q.m0.c.i(function0));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void a(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        d0.z.d.m.checkNotNullParameter(intent, "permission");
        z(new v(new b.a.q.m0.b(intent, new w(), this.l, thumbnailEmitter)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean b() {
        return this.m.a;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void c(boolean z2) {
        this.c = z2;
        z(new t(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void d(long j2, boolean z2) {
        if (z2) {
            this.h.add(Long.valueOf(j2));
        } else {
            this.h.remove(Long.valueOf(j2));
        }
        y(new m(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void destroy() {
        Logger.i$default(this.l, "MediaEngineConnectionLegacy", "destroy(). Disconnecting from server", null, 4, null);
        z(b.j);
        y(new c());
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void e(long j2, float f2) {
        z(new n(j2, f2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void f(KrispOveruseDetector.Status status) {
        d0.z.d.m.checkNotNullParameter(status, "status");
        y(new C0043e(status));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean g(long j2) {
        return this.g.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public MediaEngineConnection.Type getType() {
        return this.p;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void h() {
        z(x.j);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void i(long j2, boolean z2) {
        z(new d(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void j(boolean z2) {
        z(new u(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void k(MediaEngineConnection.InputMode inputMode, MediaEngineConnection.c cVar) {
        d0.z.d.m.checkNotNullParameter(inputMode, "inputMode");
        d0.z.d.m.checkNotNullParameter(cVar, "inputModeOptions");
        b.a.q.m0.c.u uVar = this.m;
        if (inputMode == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            boolean z2 = cVar.d;
        }
        Objects.requireNonNull(uVar);
        z(new j(cVar, inputMode));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void l(MediaEngineConnection.d dVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "listener");
        this.a.add(dVar);
        dVar.onConnectionStateChange(this, this.f270b);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void m(MediaEngineConnection.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "quality");
        int i2 = this.c ? bVar.e : bVar.f;
        y(new p(i2));
        y(new q(bVar));
        z(new r(bVar, i2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void n(Function1<? super Stats, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "onStats");
        z(new f(function1));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void o(MediaEngineConnection.d dVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "listener");
        this.a.remove(dVar);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean p(long j2) {
        return this.h.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void q(boolean z2) {
        z(new o(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void r(String str, String str2) {
        Object obj;
        Object next;
        d0.z.d.m.checkNotNullParameter(str, "audioCodec");
        d0.z.d.m.checkNotNullParameter(str2, "videoCodec");
        Iterator<T> it = this.i.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (d0.z.d.m.areEqual(((b.a.q.m0.a) next).a, str)) {
                    break;
                }
            }
        }
        b.a.q.m0.a aVar = (b.a.q.m0.a) next;
        Iterator<T> it2 = this.i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (d0.z.d.m.areEqual(((b.a.q.m0.a) next2).a, str2)) {
                obj = next2;
                break;
            }
        }
        b.a.q.m0.a aVar2 = (b.a.q.m0.a) obj;
        try {
            if (aVar == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing audio codec: " + str + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            if (aVar2 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing video codec: " + str2 + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            Integer num = aVar2.e;
            if (num == null) {
                throw new MediaEngineConnection.FailedConnectionException("Video codec " + str2 + " rtxPayloadType was null.", MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            num.intValue();
            AudioEncoder audioEncoder = new AudioEncoder(aVar.d, str, 48000, 960, 1, 64000);
            AudioDecoder audioDecoder = new AudioDecoder(aVar.d, str, 48000, 2, g0.mapOf(d0.o.to("stereo", "1")));
            Map mapMapOf = h0.mapOf(d0.o.to("level-asymmetry-allowed", "1"), d0.o.to("packetization-mode", "1"), d0.o.to("profile-level-id", "42e01f"));
            z(new h(audioEncoder, new VideoEncoder(str2, aVar2.d, aVar2.e.intValue(), mapMapOf), audioDecoder, new VideoDecoder(str2, aVar2.d, aVar2.e.intValue(), mapMapOf)));
        } catch (MediaEngineConnection.FailedConnectionException e) {
            y(new g(e));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void s(long j2, int i2, Integer num, boolean z2, float f2) {
        if (i2 == 0) {
            Logger.w$default(this.l, "MediaEngineConnectionLegacy", "Attempting to create user " + j2 + " with 0 audio SSRC", null, 4, null);
            return;
        }
        Long lValueOf = num != null ? Long.valueOf(num.intValue()) : this.e.get(Long.valueOf(j2));
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
        Integer num2 = this.d.get(Long.valueOf(j2));
        boolean z3 = num2 == null || num2.intValue() != i2;
        Long l2 = this.e.get(Long.valueOf(j2));
        boolean z4 = l2 == null || l2.longValue() != jLongValue;
        if (z3 || z4) {
            Logger.i$default(this.l, "MediaEngineConnectionLegacy", "creating user: " + j2 + " with audio SSRC: " + i2 + " and video SSRC: " + num, null, 4, null);
            z(new a(j2, i2, jLongValue, z2, f2));
        }
        if (z2) {
            this.f.add(Long.valueOf(j2));
        } else {
            this.f.remove(Long.valueOf(j2));
        }
        this.d.put(Long.valueOf(j2), Integer.valueOf(i2));
        this.e.put(Long.valueOf(j2), Long.valueOf(jLongValue));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void t(String str, int[] iArr) {
        d0.z.d.m.checkNotNullParameter(str, "mode");
        d0.z.d.m.checkNotNullParameter(iArr, "secretKey");
        z(new i(new EncryptionSettings(str, iArr)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean u(long j2) {
        return this.f.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void v(boolean z2) {
        z(new s(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void w(long j2, boolean z2) {
        z(new k(j2, z2));
        if (z2) {
            this.f.add(Long.valueOf(j2));
        } else {
            this.f.remove(Long.valueOf(j2));
        }
        y(new l(j2, z2));
    }

    public final void y(Function1<? super MediaEngineConnection.d, Unit> function1) {
        for (MediaEngineConnection.d dVar : this.a) {
            try {
                d0.z.d.m.checkNotNullExpressionValue(dVar, "it");
                function1.invoke(dVar);
            } catch (Exception e) {
                Logger.e$default(this.l, "MediaEngineConnectionLegacy", "Error in listener", e, null, 8, null);
            }
        }
    }

    public final synchronized void z(Function1<? super Connection, Unit> function1) {
        function1.invoke(this.j);
    }
}
