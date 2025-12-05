package p007b.p008a.p041q.p044m0.p045c;

import android.content.Intent;
import android.media.projection.MediaProjection;
import co.discord.media_engine.Codecs2;
import co.discord.media_engine.Codecs3;
import co.discord.media_engine.Codecs4;
import co.discord.media_engine.Codecs5;
import co.discord.media_engine.Connection;
import co.discord.media_engine.EncryptionSettings;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
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
import p007b.p008a.p041q.MediaEngineExecutorService;
import p007b.p008a.p041q.p044m0.Codec2;
import p007b.p008a.p041q.p044m0.ScreenCapturer;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MediaEngineConnectionLegacy.kt */
/* renamed from: b.a.q.m0.c.e, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaEngineConnectionLegacy5 implements MediaEngineConnection {

    /* renamed from: a */
    public final CopyOnWriteArrayList<MediaEngineConnection.InterfaceC5648d> f1698a;

    /* renamed from: b */
    public MediaEngineConnection.ConnectionState f1699b;

    /* renamed from: c */
    public boolean f1700c;

    /* renamed from: d */
    public final Map<Long, Integer> f1701d;

    /* renamed from: e */
    public final Map<Long, Long> f1702e;

    /* renamed from: f */
    public final Set<Long> f1703f;

    /* renamed from: g */
    public final Set<Long> f1704g;

    /* renamed from: h */
    public final Set<Long> f1705h;

    /* renamed from: i */
    public final List<Codec2> f1706i;

    /* renamed from: j */
    public final Connection f1707j;

    /* renamed from: k */
    public final MediaEngineExecutorService f1708k;

    /* renamed from: l */
    public final Logger f1709l;

    /* renamed from: m */
    public final NoiseCancellationConfig f1710m;

    /* renamed from: n */
    public final Discord f1711n;

    /* renamed from: o */
    public final List<Codec2> f1712o;

    /* renamed from: p */
    public final MediaEngineConnection.Type f1713p;

    /* renamed from: q */
    public final long f1714q;

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$a */
    public static final class a extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            long j = this.$userId;
            int i = this.$audioSsrc;
            int i2 = (int) this.$resolvedVideoSsrc;
            Objects.requireNonNull(MediaEngineConnectionLegacy5.this);
            connection2.connectUser(j, i, i2, i2 > 0 ? i2 + 1 : 0, this.$isMuted, this.$volume);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Connection, Unit> {

        /* renamed from: j */
        public static final b f1715j = new b();

        public b() {
            super(1, Connection.class, "dispose", "dispose()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "p1");
            connection2.dispose();
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$c */
    public static final class c extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onConnectionStateChange(MediaEngineConnectionLegacy5.this, MediaEngineConnection.ConnectionState.DISCONNECTED);
            interfaceC5648d2.onDestroy(MediaEngineConnectionLegacy5.this);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$d */
    public static final class d extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.disableVideo(this.$userId, this.$disabled);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$e */
    public static final class e extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ KrispOveruseDetector.Status $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(KrispOveruseDetector.Status status) {
            super(1);
            this.$status = status;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onKrispStatus(MediaEngineConnectionLegacy5.this, this.$status);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$f */
    public static final class f extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ Function1 $onStats;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function1 function1) {
            super(1);
            this.$onStats = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.getStats(new MediaEngineConnectionLegacy6(this));
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$g */
    public static final class g extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {

        /* renamed from: $e */
        public final /* synthetic */ MediaEngineConnection.FailedConnectionException f1716$e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MediaEngineConnection.FailedConnectionException failedConnectionException) {
            super(1);
            this.f1716$e = failedConnectionException;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onError(MediaEngineConnectionLegacy5.this, this.f1716$e);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$h */
    public static final class h extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ Codecs2 $audioDecoder;
        public final /* synthetic */ Codecs3 $audioEncoder;
        public final /* synthetic */ Codecs4 $videoDecoder;
        public final /* synthetic */ Codecs5 $videoEncoder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Codecs3 codecs3, Codecs5 codecs5, Codecs2 codecs2, Codecs4 codecs4) {
            super(1);
            this.$audioEncoder = codecs3;
            this.$videoEncoder = codecs5;
            this.$audioDecoder = codecs2;
            this.$videoDecoder = codecs4;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setCodecs(this.$audioEncoder, this.$videoEncoder, new Codecs2[]{this.$audioDecoder}, new Codecs4[]{this.$videoDecoder});
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$i */
    public static final class i extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ EncryptionSettings $encryptionSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EncryptionSettings encryptionSettings) {
            super(1);
            this.$encryptionSettings = encryptionSettings;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setEncryptionSettings(this.$encryptionSettings);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$j */
    public static final class j extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ MediaEngineConnection.InputMode $inputMode;
        public final /* synthetic */ MediaEngineConnection.C5647c $inputModeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MediaEngineConnection.C5647c c5647c, MediaEngineConnection.InputMode inputMode) {
            super(1);
            this.$inputModeOptions = c5647c;
            this.$inputMode = inputMode;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setVADLeadingFramesToBuffer(this.$inputModeOptions.f18912b);
            connection2.setVADTrailingFramesToSend(this.$inputModeOptions.f18913c);
            connection2.setVADTriggerThreshold(this.$inputModeOptions.f18911a);
            connection2.setVADAutoThreshold(this.$inputModeOptions.f18914d ? 3 : -1);
            connection2.setVADUseKrisp(this.$inputModeOptions.f18915e);
            connection2.setAudioInputMode(this.$inputMode.getNumeral());
            connection2.enableForwardErrorCorrection(true);
            connection2.setExpectedPacketLossRate(0.3f);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$k */
    public static final class k extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.muteUser(this.$userId, this.$mute);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$l */
    public static final class l extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onLocalMute(this.$userId, this.$mute);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$m */
    public static final class m extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ boolean $offScreen;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$offScreen = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onLocalVideoOffScreen(this.$userId, this.$offScreen);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$n */
    public static final class n extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setUserPlayoutVolume(this.$userId, this.$volume / 100.0f);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$o */
    public static final class o extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $active;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z2) {
            super(1);
            this.$active = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setPTTActive(this.$active);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$p */
    public static final class p extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ int $frameRate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(1);
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onTargetFrameRate(this.$frameRate);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$q */
    public static final class q extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ MediaEngineConnection.C5646b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(MediaEngineConnection.C5646b c5646b) {
            super(1);
            this.$quality = c5646b;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onTargetBitrate(this.$quality.f18906b);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$r */
    public static final class r extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ int $frameRate;
        public final /* synthetic */ MediaEngineConnection.C5646b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MediaEngineConnection.C5646b c5646b, int i) {
            super(1);
            this.$quality = c5646b;
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            MediaEngineConnection.C5646b c5646b = this.$quality;
            connection2.setEncodingQuality(c5646b.f18905a, c5646b.f18906b, c5646b.f18907c, c5646b.f18908d, this.$frameRate);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$s */
    public static final class s extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfDeaf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(boolean z2) {
            super(1);
            this.$selfDeaf = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.deafenLocalUser(this.$selfDeaf);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$t */
    public static final class t extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfMute;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(boolean z2) {
            super(1);
            this.$selfMute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.muteLocalUser(this.$selfMute);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$u */
    public static final class u extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $isVideoBroadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(boolean z2) {
            super(1);
            this.$isVideoBroadcast = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setVideoBroadcast(this.$isVideoBroadcast);
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$v */
    public static final class v extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ ScreenCapturer $screenCapturer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ScreenCapturer screenCapturer) {
            super(1);
            this.$screenCapturer = screenCapturer;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            ScreenCapturer screenCapturer = this.$screenCapturer;
            connection2.startScreenshareBroadcast(screenCapturer, screenCapturer.f1681o.getNativeInstance());
            return Unit.f27425a;
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$w */
    public static final class w extends MediaProjection.Callback {
        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
        }
    }

    /* compiled from: MediaEngineConnectionLegacy.kt */
    /* renamed from: b.a.q.m0.c.e$x */
    public static final class x extends Lambda implements Function1<Connection, Unit> {

        /* renamed from: j */
        public static final x f1717j = new x();

        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.stopScreenshareBroadcast();
            return Unit.f27425a;
        }
    }

    public MediaEngineConnectionLegacy5(MediaEngineExecutorService mediaEngineExecutorService, Logger logger, NoiseCancellationConfig noiseCancellationConfig, Discord discord, List<Codec2> list, MediaEngineConnection.Type type, long j2, MediaEngine.C5640a c5640a, List<? extends MediaEngineConnection.InterfaceC5648d> list2) {
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(noiseCancellationConfig, "noiseCancellationConfig");
        Intrinsics3.checkNotNullParameter(discord, "voiceEngineLegacy");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(c5640a, "connectionOptions");
        Intrinsics3.checkNotNullParameter(list2, "listeners");
        this.f1708k = mediaEngineExecutorService;
        this.f1709l = logger;
        this.f1710m = noiseCancellationConfig;
        this.f1711n = discord;
        this.f1712o = list;
        this.f1713p = type;
        this.f1714q = j2;
        MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTING;
        this.f1699b = connectionState;
        this.f1701d = Maps6.mutableMapOf(Tuples.m10073to(Long.valueOf(j2), Integer.valueOf(c5640a.f18898a)));
        this.f1702e = new LinkedHashMap();
        this.f1703f = new LinkedHashSet();
        this.f1704g = new LinkedHashSet();
        this.f1705h = new LinkedHashSet();
        this.f1706i = new ArrayList();
        int i2 = c5640a.f18898a;
        String str = c5640a.f18899b;
        int i3 = c5640a.f18900c;
        Object[] array = c5640a.f18901d.toArray(new StreamParameters[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Connection connectionConnectToServer = discord.connectToServer(i2, j2, str, i3, (StreamParameters[]) array, new MediaEngineConnectionLegacy4(this));
        Intrinsics3.checkNotNullExpressionValue(connectionConnectToServer, "voiceEngineLegacy.connec…fo, errorMessage) }\n    }");
        connectionConnectToServer.setOnVideoCallback(new MediaEngineConnectionLegacy2(this));
        connectionConnectToServer.setUserSpeakingStatusChangedCallback(new MediaEngineConnectionLegacy3(this));
        this.f1707j = connectionConnectToServer;
        this.f1698a = new CopyOnWriteArrayList<>(list2);
        this.f1699b = connectionState;
        m318y(new MediaEngineConnectionLegacy(this, connectionState));
    }

    /* renamed from: x */
    public static final void m294x(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5, Function0 function0) {
        MediaEngineExecutorService mediaEngineExecutorService = mediaEngineConnectionLegacy5.f1708k;
        mediaEngineExecutorService.f1609l.execute(new MediaEngineConnectionLegacy9(function0));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: a */
    public synchronized void mo295a(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        Intrinsics3.checkNotNullParameter(intent, "permission");
        m319z(new v(new ScreenCapturer(intent, new w(), this.f1709l, thumbnailEmitter)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: b */
    public boolean mo296b() {
        return this.f1710m.f1757a;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: c */
    public void mo297c(boolean z2) {
        this.f1700c = z2;
        m319z(new t(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: d */
    public void mo298d(long j2, boolean z2) {
        if (z2) {
            this.f1705h.add(Long.valueOf(j2));
        } else {
            this.f1705h.remove(Long.valueOf(j2));
        }
        m318y(new m(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void destroy() {
        Logger.i$default(this.f1709l, "MediaEngineConnectionLegacy", "destroy(). Disconnecting from server", null, 4, null);
        m319z(b.f1715j);
        m318y(new c());
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: e */
    public void mo299e(long j2, float f2) {
        m319z(new n(j2, f2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: f */
    public void mo300f(KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(status, "status");
        m318y(new e(status));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: g */
    public boolean mo301g(long j2) {
        return this.f1704g.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public MediaEngineConnection.Type getType() {
        return this.f1713p;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: h */
    public synchronized void mo302h() {
        m319z(x.f1717j);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: i */
    public void mo303i(long j2, boolean z2) {
        m319z(new d(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: j */
    public void mo304j(boolean z2) {
        m319z(new u(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: k */
    public void mo305k(MediaEngineConnection.InputMode inputMode, MediaEngineConnection.C5647c c5647c) {
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        Intrinsics3.checkNotNullParameter(c5647c, "inputModeOptions");
        NoiseCancellationConfig noiseCancellationConfig = this.f1710m;
        if (inputMode == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            boolean z2 = c5647c.f18914d;
        }
        Objects.requireNonNull(noiseCancellationConfig);
        m319z(new j(c5647c, inputMode));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: l */
    public void mo306l(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        Intrinsics3.checkNotNullParameter(interfaceC5648d, "listener");
        this.f1698a.add(interfaceC5648d);
        interfaceC5648d.onConnectionStateChange(this, this.f1699b);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: m */
    public void mo307m(MediaEngineConnection.C5646b c5646b) {
        Intrinsics3.checkNotNullParameter(c5646b, "quality");
        int i2 = this.f1700c ? c5646b.f18909e : c5646b.f18910f;
        m318y(new p(i2));
        m318y(new q(c5646b));
        m319z(new r(c5646b, i2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: n */
    public void mo308n(Function1<? super Stats, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onStats");
        m319z(new f(function1));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: o */
    public void mo309o(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        Intrinsics3.checkNotNullParameter(interfaceC5648d, "listener");
        this.f1698a.remove(interfaceC5648d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: p */
    public boolean mo310p(long j2) {
        return this.f1705h.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: q */
    public void mo311q(boolean z2) {
        m319z(new o(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: r */
    public void mo312r(String str, String str2) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(str, "audioCodec");
        Intrinsics3.checkNotNullParameter(str2, "videoCodec");
        Iterator<T> it = this.f1706i.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(((Codec2) next).f1671a, str)) {
                    break;
                }
            }
        }
        Codec2 codec2 = (Codec2) next;
        Iterator<T> it2 = this.f1706i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics3.areEqual(((Codec2) next2).f1671a, str2)) {
                obj = next2;
                break;
            }
        }
        Codec2 codec22 = (Codec2) obj;
        try {
            if (codec2 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing audio codec: " + str + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            if (codec22 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing video codec: " + str2 + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            Integer num = codec22.f1675e;
            if (num == null) {
                throw new MediaEngineConnection.FailedConnectionException("Video codec " + str2 + " rtxPayloadType was null.", MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            num.intValue();
            Codecs3 codecs3 = new Codecs3(codec2.f1674d, str, 48000, 960, 1, 64000);
            Codecs2 codecs2 = new Codecs2(codec2.f1674d, str, 48000, 2, MapsJVM.mapOf(Tuples.m10073to("stereo", "1")));
            Map mapMapOf = Maps6.mapOf(Tuples.m10073to("level-asymmetry-allowed", "1"), Tuples.m10073to("packetization-mode", "1"), Tuples.m10073to("profile-level-id", "42e01f"));
            m319z(new h(codecs3, new Codecs5(str2, codec22.f1674d, codec22.f1675e.intValue(), mapMapOf), codecs2, new Codecs4(str2, codec22.f1674d, codec22.f1675e.intValue(), mapMapOf)));
        } catch (MediaEngineConnection.FailedConnectionException e2) {
            m318y(new g(e2));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: s */
    public void mo313s(long j2, int i2, Integer num, boolean z2, float f2) {
        if (i2 == 0) {
            Logger.w$default(this.f1709l, "MediaEngineConnectionLegacy", "Attempting to create user " + j2 + " with 0 audio SSRC", null, 4, null);
            return;
        }
        Long lValueOf = num != null ? Long.valueOf(num.intValue()) : this.f1702e.get(Long.valueOf(j2));
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
        Integer num2 = this.f1701d.get(Long.valueOf(j2));
        boolean z3 = num2 == null || num2.intValue() != i2;
        Long l2 = this.f1702e.get(Long.valueOf(j2));
        boolean z4 = l2 == null || l2.longValue() != jLongValue;
        if (z3 || z4) {
            Logger.i$default(this.f1709l, "MediaEngineConnectionLegacy", "creating user: " + j2 + " with audio SSRC: " + i2 + " and video SSRC: " + num, null, 4, null);
            m319z(new a(j2, i2, jLongValue, z2, f2));
        }
        if (z2) {
            this.f1703f.add(Long.valueOf(j2));
        } else {
            this.f1703f.remove(Long.valueOf(j2));
        }
        this.f1701d.put(Long.valueOf(j2), Integer.valueOf(i2));
        this.f1702e.put(Long.valueOf(j2), Long.valueOf(jLongValue));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: t */
    public void mo314t(String str, int[] iArr) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(iArr, "secretKey");
        m319z(new i(new EncryptionSettings(str, iArr)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: u */
    public boolean mo315u(long j2) {
        return this.f1703f.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: v */
    public void mo316v(boolean z2) {
        m319z(new s(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* renamed from: w */
    public void mo317w(long j2, boolean z2) {
        m319z(new k(j2, z2));
        if (z2) {
            this.f1703f.add(Long.valueOf(j2));
        } else {
            this.f1703f.remove(Long.valueOf(j2));
        }
        m318y(new l(j2, z2));
    }

    /* renamed from: y */
    public final void m318y(Function1<? super MediaEngineConnection.InterfaceC5648d, Unit> function1) {
        for (MediaEngineConnection.InterfaceC5648d interfaceC5648d : this.f1698a) {
            try {
                Intrinsics3.checkNotNullExpressionValue(interfaceC5648d, "it");
                function1.invoke(interfaceC5648d);
            } catch (Exception e2) {
                Logger.e$default(this.f1709l, "MediaEngineConnectionLegacy", "Error in listener", e2, null, 8, null);
            }
        }
    }

    /* renamed from: z */
    public final synchronized void m319z(Function1<? super Connection, Unit> function1) {
        function1.invoke(this.f1707j);
    }
}
