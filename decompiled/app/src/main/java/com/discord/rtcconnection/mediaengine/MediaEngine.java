package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import androidx.core.app.FrameMetricsAggregator;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: MediaEngine.kt */
/* loaded from: classes.dex */
public interface MediaEngine {

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class AudioInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final String audioSubsystem;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String audioLayer;

        public AudioInfo(String str, String str2) {
            m.checkNotNullParameter(str, "audioSubsystem");
            m.checkNotNullParameter(str2, "audioLayer");
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
            return m.areEqual(this.audioSubsystem, audioInfo.audioSubsystem) && m.areEqual(this.audioLayer, audioInfo.audioLayer);
        }

        public int hashCode() {
            String str = this.audioSubsystem;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.audioLayer;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("AudioInfo(audioSubsystem=");
            sbU.append(this.audioSubsystem);
            sbU.append(", audioLayer=");
            return b.d.b.a.a.J(sbU, this.audioLayer, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class EchoCancellationInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final boolean builtinAecRequested;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
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
            StringBuilder sbU = b.d.b.a.a.U("EchoCancellationInfo(builtinAecRequested=");
            sbU.append(this.builtinAecRequested);
            sbU.append(", builtinAecSupportedNative=");
            sbU.append(this.builtinAecSupportedNative);
            sbU.append(", builtinAecSupportedJava=");
            sbU.append(this.builtinAecSupportedJava);
            sbU.append(", builtinAecEnabled=");
            sbU.append(this.builtinAecEnabled);
            sbU.append(", aecEnabledInSettings=");
            sbU.append(this.aecEnabledInSettings);
            sbU.append(", aecEnabledInNativeConfig=");
            sbU.append(this.aecEnabledInNativeConfig);
            sbU.append(", aecMobileMode=");
            sbU.append(this.aecMobileMode);
            sbU.append(", aecEnabledByDefault=");
            sbU.append(this.aecEnabledByDefault);
            sbU.append(", aecMobileModeByDefault=");
            return b.d.b.a.a.O(sbU, this.aecMobileModeByDefault, ")");
        }

        public /* synthetic */ EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final /* data */ class LocalVoiceStatus {

        /* renamed from: a, reason: from kotlin metadata */
        public final float amplitude;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
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
            StringBuilder sbU = b.d.b.a.a.U("LocalVoiceStatus(amplitude=");
            sbU.append(this.amplitude);
            sbU.append(", isSpeaking=");
            return b.d.b.a.a.O(sbU, this.isSpeaking, ")");
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

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
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
        public final MediaEngineConnection.c inputModeOptions;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean isSelfDeafened;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean isSelfMuted;

        public VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection.InputMode inputMode, MediaEngineConnection.c cVar, boolean z6, boolean z7) {
            m.checkNotNullParameter(inputMode, "inputMode");
            m.checkNotNullParameter(cVar, "inputModeOptions");
            this.outputVolume = f;
            this.echoCancellation = z2;
            this.noiseSuppression = z3;
            this.noiseCancellation = z4;
            this.automaticGainControl = z5;
            this.inputMode = inputMode;
            this.inputModeOptions = cVar;
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
            return Float.compare(this.outputVolume, voiceConfig.outputVolume) == 0 && this.echoCancellation == voiceConfig.echoCancellation && this.noiseSuppression == voiceConfig.noiseSuppression && this.noiseCancellation == voiceConfig.noiseCancellation && this.automaticGainControl == voiceConfig.automaticGainControl && m.areEqual(this.inputMode, voiceConfig.inputMode) && m.areEqual(this.inputModeOptions, voiceConfig.inputModeOptions) && this.isSelfDeafened == voiceConfig.isSelfDeafened && this.isSelfMuted == voiceConfig.isSelfMuted;
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
            MediaEngineConnection.c cVar = this.inputModeOptions;
            int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
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
            StringBuilder sbU = b.d.b.a.a.U("VoiceConfig(outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(", echoCancellation=");
            sbU.append(this.echoCancellation);
            sbU.append(", noiseSuppression=");
            sbU.append(this.noiseSuppression);
            sbU.append(", noiseCancellation=");
            sbU.append(this.noiseCancellation);
            sbU.append(", automaticGainControl=");
            sbU.append(this.automaticGainControl);
            sbU.append(", inputMode=");
            sbU.append(this.inputMode);
            sbU.append(", inputModeOptions=");
            sbU.append(this.inputModeOptions);
            sbU.append(", isSelfDeafened=");
            sbU.append(this.isSelfDeafened);
            sbU.append(", isSelfMuted=");
            return b.d.b.a.a.O(sbU, this.isSelfMuted, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2797b;
        public final int c;
        public final List<StreamParameters> d;

        public a(int i, String str, int i2, List<StreamParameters> list) {
            m.checkNotNullParameter(str, "ip");
            m.checkNotNullParameter(list, "streams");
            this.a = i;
            this.f2797b = str;
            this.c = i2;
            this.d = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && m.areEqual(this.f2797b, aVar.f2797b) && this.c == aVar.c && m.areEqual(this.d, aVar.d);
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.f2797b;
            int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31;
            List<StreamParameters> list = this.d;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ConnectionOptions(ssrc=");
            sbU.append(this.a);
            sbU.append(", ip=");
            sbU.append(this.f2797b);
            sbU.append(", port=");
            sbU.append(this.c);
            sbU.append(", streams=");
            return b.d.b.a.a.L(sbU, this.d, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public interface b {
        void onEchoCancellationUpdated(EchoCancellationInfo echoCancellationInfo);
    }

    /* compiled from: MediaEngine.kt */
    public interface c {
        void onConnected();

        void onConnecting();

        void onNativeEngineInitialized();

        void onNewConnection(MediaEngineConnection mediaEngineConnection);
    }

    Observable<Unit> a();

    void b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    b.a.q.c c();

    @AnyThread
    void d(VoiceConfig voiceConfig);

    Observable<AudioInfo> e();

    void f(int deviceIndex);

    MediaEngineConnection g(long userId, a options, MediaEngineConnection.Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    void h(OpenSLUsageMode openSLUsageMode);

    Discord i();

    void j(Function1<? super VideoInputDeviceDescription[], Unit> devicesCallback);

    void k(boolean enabled);

    void l(Function1<? super LocalVoiceStatus, Unit> voiceStatusListener);
}
