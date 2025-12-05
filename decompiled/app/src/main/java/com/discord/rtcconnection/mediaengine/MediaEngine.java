package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import androidx.core.app.FrameMetricsAggregator;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.MediaEngineExecutorService;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: MediaEngine.kt */
/* loaded from: classes.dex */
public interface MediaEngine {

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class AudioInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final String audioSubsystem;

        /* renamed from: b, reason: from kotlin metadata */
        public final String audioLayer;

        public AudioInfo(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "audioSubsystem");
            Intrinsics3.checkNotNullParameter(str2, "audioLayer");
            this.audioSubsystem = str;
            this.audioLayer = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioInfo)) {
                return false;
            }
            AudioInfo audioInfo = (AudioInfo) other;
            return Intrinsics3.areEqual(this.audioSubsystem, audioInfo.audioSubsystem) && Intrinsics3.areEqual(this.audioLayer, audioInfo.audioLayer);
        }

        public int hashCode() {
            String str = this.audioSubsystem;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.audioLayer;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("AudioInfo(audioSubsystem=");
            sbM833U.append(this.audioSubsystem);
            sbM833U.append(", audioLayer=");
            return outline.m822J(sbM833U, this.audioLayer, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class EchoCancellationInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final boolean builtinAecRequested;

        /* renamed from: b, reason: from kotlin metadata */
        public final boolean builtinAecSupportedNative;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean builtinAecSupportedJava;

        /* renamed from: d, reason: from kotlin metadata */
        public final boolean builtinAecEnabled;

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean aecEnabledInSettings;

        /* renamed from: f, reason: from kotlin metadata */
        public final boolean aecEnabledInNativeConfig;

        /* renamed from: g, reason: from kotlin metadata */
        public final boolean aecMobileMode;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean aecEnabledByDefault;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean aecMobileModeByDefault;

        public EchoCancellationInfo() {
            this(false, false, false, false, false, false, false, false, false, FrameMetricsAggregator.EVERY_DURATION);
        }

        public EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
            this.builtinAecRequested = z2;
            this.builtinAecSupportedNative = z3;
            this.builtinAecSupportedJava = z4;
            this.builtinAecEnabled = z5;
            this.aecEnabledInSettings = z6;
            this.aecEnabledInNativeConfig = z7;
            this.aecMobileMode = z8;
            this.aecEnabledByDefault = z9;
            this.aecMobileModeByDefault = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EchoCancellationInfo)) {
                return false;
            }
            EchoCancellationInfo echoCancellationInfo = (EchoCancellationInfo) other;
            return this.builtinAecRequested == echoCancellationInfo.builtinAecRequested && this.builtinAecSupportedNative == echoCancellationInfo.builtinAecSupportedNative && this.builtinAecSupportedJava == echoCancellationInfo.builtinAecSupportedJava && this.builtinAecEnabled == echoCancellationInfo.builtinAecEnabled && this.aecEnabledInSettings == echoCancellationInfo.aecEnabledInSettings && this.aecEnabledInNativeConfig == echoCancellationInfo.aecEnabledInNativeConfig && this.aecMobileMode == echoCancellationInfo.aecMobileMode && this.aecEnabledByDefault == echoCancellationInfo.aecEnabledByDefault && this.aecMobileModeByDefault == echoCancellationInfo.aecMobileModeByDefault;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.builtinAecRequested;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.builtinAecSupportedNative;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.builtinAecSupportedJava;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.builtinAecEnabled;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.aecEnabledInSettings;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            ?? r25 = this.aecEnabledInNativeConfig;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.aecMobileMode;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            ?? r27 = this.aecEnabledByDefault;
            int i14 = r27;
            if (r27 != 0) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            boolean z3 = this.aecMobileModeByDefault;
            return i15 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("EchoCancellationInfo(builtinAecRequested=");
            sbM833U.append(this.builtinAecRequested);
            sbM833U.append(", builtinAecSupportedNative=");
            sbM833U.append(this.builtinAecSupportedNative);
            sbM833U.append(", builtinAecSupportedJava=");
            sbM833U.append(this.builtinAecSupportedJava);
            sbM833U.append(", builtinAecEnabled=");
            sbM833U.append(this.builtinAecEnabled);
            sbM833U.append(", aecEnabledInSettings=");
            sbM833U.append(this.aecEnabledInSettings);
            sbM833U.append(", aecEnabledInNativeConfig=");
            sbM833U.append(this.aecEnabledInNativeConfig);
            sbM833U.append(", aecMobileMode=");
            sbM833U.append(this.aecMobileMode);
            sbM833U.append(", aecEnabledByDefault=");
            sbM833U.append(this.aecEnabledByDefault);
            sbM833U.append(", aecMobileModeByDefault=");
            return outline.m827O(sbM833U, this.aecMobileModeByDefault, ")");
        }

        public /* synthetic */ EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class LocalVoiceStatus {

        /* renamed from: a, reason: from kotlin metadata */
        public final float amplitude;

        /* renamed from: b, reason: from kotlin metadata */
        public final boolean isSpeaking;

        public LocalVoiceStatus(float f, boolean z2) {
            this.amplitude = f;
            this.isSpeaking = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalVoiceStatus)) {
                return false;
            }
            LocalVoiceStatus localVoiceStatus = (LocalVoiceStatus) other;
            return Float.compare(this.amplitude, localVoiceStatus.amplitude) == 0 && this.isSpeaking == localVoiceStatus.isSpeaking;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.amplitude) * 31;
            boolean z2 = this.isSpeaking;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iFloatToIntBits + i;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("LocalVoiceStatus(amplitude=");
            sbM833U.append(this.amplitude);
            sbM833U.append(", isSpeaking=");
            return outline.m827O(sbM833U, this.isSpeaking, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public enum OpenSLESConfig {
        DEFAULT,
        FORCE_ENABLED,
        FORCE_DISABLED
    }

    /* compiled from: MediaEngine.kt */
    public enum OpenSLUsageMode {
        ALLOW_LIST,
        EXCLUDE_LIST
    }

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class VoiceConfig {

        /* renamed from: a, reason: from kotlin metadata */
        public final float outputVolume;

        /* renamed from: b, reason: from kotlin metadata */
        public final boolean echoCancellation;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean noiseSuppression;

        /* renamed from: d, reason: from kotlin metadata */
        public final boolean noiseCancellation;

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean automaticGainControl;

        /* renamed from: f, reason: from kotlin metadata */
        public final MediaEngineConnection.InputMode inputMode;

        /* renamed from: g, reason: from kotlin metadata */
        public final MediaEngineConnection.C5647c inputModeOptions;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean isSelfDeafened;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean isSelfMuted;

        public VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection.InputMode inputMode, MediaEngineConnection.C5647c c5647c, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(c5647c, "inputModeOptions");
            this.outputVolume = f;
            this.echoCancellation = z2;
            this.noiseSuppression = z3;
            this.noiseCancellation = z4;
            this.automaticGainControl = z5;
            this.inputMode = inputMode;
            this.inputModeOptions = c5647c;
            this.isSelfDeafened = z6;
            this.isSelfMuted = z7;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfig)) {
                return false;
            }
            VoiceConfig voiceConfig = (VoiceConfig) other;
            return Float.compare(this.outputVolume, voiceConfig.outputVolume) == 0 && this.echoCancellation == voiceConfig.echoCancellation && this.noiseSuppression == voiceConfig.noiseSuppression && this.noiseCancellation == voiceConfig.noiseCancellation && this.automaticGainControl == voiceConfig.automaticGainControl && Intrinsics3.areEqual(this.inputMode, voiceConfig.inputMode) && Intrinsics3.areEqual(this.inputModeOptions, voiceConfig.inputModeOptions) && this.isSelfDeafened == voiceConfig.isSelfDeafened && this.isSelfMuted == voiceConfig.isSelfMuted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.outputVolume) * 31;
            boolean z2 = this.echoCancellation;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iFloatToIntBits + i) * 31;
            boolean z3 = this.noiseSuppression;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.noiseCancellation;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.automaticGainControl;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iHashCode = (i8 + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
            MediaEngineConnection.C5647c c5647c = this.inputModeOptions;
            int iHashCode2 = (iHashCode + (c5647c != null ? c5647c.hashCode() : 0)) * 31;
            boolean z6 = this.isSelfDeafened;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (iHashCode2 + i9) * 31;
            boolean z7 = this.isSelfMuted;
            return i10 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("VoiceConfig(outputVolume=");
            sbM833U.append(this.outputVolume);
            sbM833U.append(", echoCancellation=");
            sbM833U.append(this.echoCancellation);
            sbM833U.append(", noiseSuppression=");
            sbM833U.append(this.noiseSuppression);
            sbM833U.append(", noiseCancellation=");
            sbM833U.append(this.noiseCancellation);
            sbM833U.append(", automaticGainControl=");
            sbM833U.append(this.automaticGainControl);
            sbM833U.append(", inputMode=");
            sbM833U.append(this.inputMode);
            sbM833U.append(", inputModeOptions=");
            sbM833U.append(this.inputModeOptions);
            sbM833U.append(", isSelfDeafened=");
            sbM833U.append(this.isSelfDeafened);
            sbM833U.append(", isSelfMuted=");
            return outline.m827O(sbM833U, this.isSelfMuted, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    /* renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$a */
    public static final class C5640a {

        /* renamed from: a */
        public final int f18898a;

        /* renamed from: b */
        public final String f18899b;

        /* renamed from: c */
        public final int f18900c;

        /* renamed from: d */
        public final List<StreamParameters> f18901d;

        public C5640a(int i, String str, int i2, List<StreamParameters> list) {
            Intrinsics3.checkNotNullParameter(str, "ip");
            Intrinsics3.checkNotNullParameter(list, "streams");
            this.f18898a = i;
            this.f18899b = str;
            this.f18900c = i2;
            this.f18901d = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5640a)) {
                return false;
            }
            C5640a c5640a = (C5640a) obj;
            return this.f18898a == c5640a.f18898a && Intrinsics3.areEqual(this.f18899b, c5640a.f18899b) && this.f18900c == c5640a.f18900c && Intrinsics3.areEqual(this.f18901d, c5640a.f18901d);
        }

        public int hashCode() {
            int i = this.f18898a * 31;
            String str = this.f18899b;
            int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.f18900c) * 31;
            List<StreamParameters> list = this.f18901d;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ConnectionOptions(ssrc=");
            sbM833U.append(this.f18898a);
            sbM833U.append(", ip=");
            sbM833U.append(this.f18899b);
            sbM833U.append(", port=");
            sbM833U.append(this.f18900c);
            sbM833U.append(", streams=");
            return outline.m824L(sbM833U, this.f18901d, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    /* renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$b */
    public interface InterfaceC5641b {
        void onEchoCancellationUpdated(EchoCancellationInfo echoCancellationInfo);
    }

    /* compiled from: MediaEngine.kt */
    /* renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$c */
    public interface InterfaceC5642c {
        void onConnected();

        void onConnecting();

        void onNativeEngineInitialized();

        void onNewConnection(MediaEngineConnection mediaEngineConnection);
    }

    /* renamed from: a */
    Observable<Unit> mo321a();

    /* renamed from: b */
    void mo322b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    /* renamed from: c */
    MediaEngineExecutorService mo323c();

    @AnyThread
    /* renamed from: d */
    void mo324d(VoiceConfig voiceConfig);

    /* renamed from: e */
    Observable<AudioInfo> mo325e();

    /* renamed from: f */
    void mo326f(int deviceIndex);

    /* renamed from: g */
    MediaEngineConnection mo327g(long userId, C5640a options, MediaEngineConnection.Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    /* renamed from: h */
    void mo328h(OpenSLUsageMode openSLUsageMode);

    /* renamed from: i */
    Discord mo329i();

    /* renamed from: j */
    void mo330j(Function1<? super DeviceDescription4[], Unit> devicesCallback);

    /* renamed from: k */
    void mo331k(boolean enabled);

    /* renamed from: l */
    void mo332l(Function1<? super LocalVoiceStatus, Unit> voiceStatusListener);
}
