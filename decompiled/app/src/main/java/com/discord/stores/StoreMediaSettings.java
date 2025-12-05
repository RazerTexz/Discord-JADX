package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* compiled from: StoreMediaSettings.kt */
/* loaded from: classes2.dex */
public final class StoreMediaSettings extends Store {
    private final AppSoundManager appSoundManager;
    private boolean canUseVad;
    private SelfMuteFailure forceSelfMuteReason;
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private VoiceConfiguration voiceConfiguration;
    private final VoiceConfigurationCache voiceConfigurationCache;
    private final SerializedSubject<VoiceConfiguration, VoiceConfiguration> voiceConfigurationSubject;

    /* compiled from: StoreMediaSettings.kt */
    public enum NoiseProcessing {
        None,
        Suppression,
        Cancellation,
        CancellationTemporarilyDisabled
    }

    /* compiled from: StoreMediaSettings.kt */
    public enum SelfMuteFailure {
        CANNOT_USE_VAD
    }

    /* compiled from: StoreMediaSettings.kt */
    public enum VadUseKrisp {
        Disabled,
        Enabled,
        TemporarilyDisabled
    }

    /* compiled from: StoreMediaSettings.kt */
    public static final /* data */ class VoiceConfiguration {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int DEFAULT_NOISE_PROCESSING;
        public static final float DEFAULT_OUTPUT_VOLUME = 100.0f;
        public static final float DEFAULT_SENSITIVITY = -50.0f;
        private static final VoiceConfiguration DEFAULT_VOICE_CONFIG;
        private final boolean automaticGainControl;
        private final boolean automaticVad;
        private final boolean echoCancellation;
        private final boolean enableVideoHardwareScaling;
        private final MediaEngineConnection.InputMode inputMode;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final Map<Long, Boolean> mutedUsers;
        private final NoiseProcessing noiseProcessing;
        private final Map<Long, Boolean> offScreenUsers;
        private final float outputVolume;
        private final float sensitivity;
        private final Map<Long, Float> userOutputVolumes;
        private final VadUseKrisp vadUseKrisp;
        private final boolean voiceParticipantsHidden;

        /* compiled from: StoreMediaSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final int getDEFAULT_NOISE_PROCESSING() {
                return VoiceConfiguration.access$getDEFAULT_NOISE_PROCESSING$cp();
            }

            public final VoiceConfiguration getDEFAULT_VOICE_CONFIG() {
                return VoiceConfiguration.access$getDEFAULT_VOICE_CONFIG$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            VoiceConfiguration voiceConfiguration = new VoiceConfiguration(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
            DEFAULT_VOICE_CONFIG = voiceConfiguration;
            DEFAULT_NOISE_PROCESSING = voiceConfiguration.noiseProcessing.ordinal();
        }

        public VoiceConfiguration() {
            this(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
        }

        public VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map<Long, Boolean> map, Map<Long, Float> map2, Map<Long, Boolean> map3, boolean z7, boolean z8) {
            Intrinsics3.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(map, "mutedUsers");
            Intrinsics3.checkNotNullParameter(map2, "userOutputVolumes");
            Intrinsics3.checkNotNullParameter(map3, "offScreenUsers");
            this.isSelfMuted = z2;
            this.isSelfDeafened = z3;
            this.automaticVad = z4;
            this.vadUseKrisp = vadUseKrisp;
            this.automaticGainControl = z5;
            this.echoCancellation = z6;
            this.noiseProcessing = noiseProcessing;
            this.sensitivity = f;
            this.inputMode = inputMode;
            this.outputVolume = f2;
            this.mutedUsers = map;
            this.userOutputVolumes = map2;
            this.offScreenUsers = map3;
            this.enableVideoHardwareScaling = z7;
            this.voiceParticipantsHidden = z8;
        }

        public static final /* synthetic */ int access$getDEFAULT_NOISE_PROCESSING$cp() {
            return DEFAULT_NOISE_PROCESSING;
        }

        public static final /* synthetic */ VoiceConfiguration access$getDEFAULT_VOICE_CONFIG$cp() {
            return DEFAULT_VOICE_CONFIG;
        }

        /* renamed from: component1, reason: from getter */
        private final boolean getIsSelfMuted() {
            return this.isSelfMuted;
        }

        public static /* synthetic */ VoiceConfiguration copy$default(VoiceConfiguration voiceConfiguration, boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, Object obj) {
            return voiceConfiguration.copy((i & 1) != 0 ? voiceConfiguration.isSelfMuted : z2, (i & 2) != 0 ? voiceConfiguration.isSelfDeafened : z3, (i & 4) != 0 ? voiceConfiguration.automaticVad : z4, (i & 8) != 0 ? voiceConfiguration.vadUseKrisp : vadUseKrisp, (i & 16) != 0 ? voiceConfiguration.automaticGainControl : z5, (i & 32) != 0 ? voiceConfiguration.echoCancellation : z6, (i & 64) != 0 ? voiceConfiguration.noiseProcessing : noiseProcessing, (i & 128) != 0 ? voiceConfiguration.sensitivity : f, (i & 256) != 0 ? voiceConfiguration.inputMode : inputMode, (i & 512) != 0 ? voiceConfiguration.outputVolume : f2, (i & 1024) != 0 ? voiceConfiguration.mutedUsers : map, (i & 2048) != 0 ? voiceConfiguration.userOutputVolumes : map2, (i & 4096) != 0 ? voiceConfiguration.offScreenUsers : map3, (i & 8192) != 0 ? voiceConfiguration.enableVideoHardwareScaling : z7, (i & 16384) != 0 ? voiceConfiguration.voiceParticipantsHidden : z8);
        }

        /* renamed from: component10, reason: from getter */
        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final Map<Long, Boolean> component11() {
            return this.mutedUsers;
        }

        public final Map<Long, Float> component12() {
            return this.userOutputVolumes;
        }

        public final Map<Long, Boolean> component13() {
            return this.offScreenUsers;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelfDeafened() {
            return this.isSelfDeafened;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        /* renamed from: component4, reason: from getter */
        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        /* renamed from: component7, reason: from getter */
        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        /* renamed from: component8, reason: from getter */
        public final float getSensitivity() {
            return this.sensitivity;
        }

        /* renamed from: component9, reason: from getter */
        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final VoiceConfiguration copy(boolean isSelfMuted, boolean isSelfDeafened, boolean automaticVad, VadUseKrisp vadUseKrisp, boolean automaticGainControl, boolean echoCancellation, NoiseProcessing noiseProcessing, float sensitivity, MediaEngineConnection.InputMode inputMode, float outputVolume, Map<Long, Boolean> mutedUsers, Map<Long, Float> userOutputVolumes, Map<Long, Boolean> offScreenUsers, boolean enableVideoHardwareScaling, boolean voiceParticipantsHidden) {
            Intrinsics3.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(mutedUsers, "mutedUsers");
            Intrinsics3.checkNotNullParameter(userOutputVolumes, "userOutputVolumes");
            Intrinsics3.checkNotNullParameter(offScreenUsers, "offScreenUsers");
            return new VoiceConfiguration(isSelfMuted, isSelfDeafened, automaticVad, vadUseKrisp, automaticGainControl, echoCancellation, noiseProcessing, sensitivity, inputMode, outputVolume, mutedUsers, userOutputVolumes, offScreenUsers, enableVideoHardwareScaling, voiceParticipantsHidden);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfiguration)) {
                return false;
            }
            VoiceConfiguration voiceConfiguration = (VoiceConfiguration) other;
            return this.isSelfMuted == voiceConfiguration.isSelfMuted && this.isSelfDeafened == voiceConfiguration.isSelfDeafened && this.automaticVad == voiceConfiguration.automaticVad && Intrinsics3.areEqual(this.vadUseKrisp, voiceConfiguration.vadUseKrisp) && this.automaticGainControl == voiceConfiguration.automaticGainControl && this.echoCancellation == voiceConfiguration.echoCancellation && Intrinsics3.areEqual(this.noiseProcessing, voiceConfiguration.noiseProcessing) && Float.compare(this.sensitivity, voiceConfiguration.sensitivity) == 0 && Intrinsics3.areEqual(this.inputMode, voiceConfiguration.inputMode) && Float.compare(this.outputVolume, voiceConfiguration.outputVolume) == 0 && Intrinsics3.areEqual(this.mutedUsers, voiceConfiguration.mutedUsers) && Intrinsics3.areEqual(this.userOutputVolumes, voiceConfiguration.userOutputVolumes) && Intrinsics3.areEqual(this.offScreenUsers, voiceConfiguration.offScreenUsers) && this.enableVideoHardwareScaling == voiceConfiguration.enableVideoHardwareScaling && this.voiceParticipantsHidden == voiceConfiguration.voiceParticipantsHidden;
        }

        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final Map<Long, Boolean> getMutedUsers() {
            return this.mutedUsers;
        }

        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        public final Map<Long, Boolean> getOffScreenUsers() {
            return this.offScreenUsers;
        }

        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final float getSensitivity() {
            return this.sensitivity;
        }

        public final Map<Long, Float> getUserOutputVolumes() {
            return this.userOutputVolumes;
        }

        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v27, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isSelfMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isSelfDeafened;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.automaticVad;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            VadUseKrisp vadUseKrisp = this.vadUseKrisp;
            int iHashCode = (i5 + (vadUseKrisp != null ? vadUseKrisp.hashCode() : 0)) * 31;
            ?? r23 = this.automaticGainControl;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (iHashCode + i6) * 31;
            ?? r24 = this.echoCancellation;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            NoiseProcessing noiseProcessing = this.noiseProcessing;
            int iFloatToIntBits = (Float.floatToIntBits(this.sensitivity) + ((i9 + (noiseProcessing != null ? noiseProcessing.hashCode() : 0)) * 31)) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iFloatToIntBits2 = (Float.floatToIntBits(this.outputVolume) + ((iFloatToIntBits + (inputMode != null ? inputMode.hashCode() : 0)) * 31)) * 31;
            Map<Long, Boolean> map = this.mutedUsers;
            int iHashCode2 = (iFloatToIntBits2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Float> map2 = this.userOutputVolumes;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Boolean> map3 = this.offScreenUsers;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            ?? r25 = this.enableVideoHardwareScaling;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (iHashCode4 + i10) * 31;
            boolean z3 = this.voiceParticipantsHidden;
            return i11 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isSelfDeafened() {
            return this.isSelfDeafened;
        }

        public final boolean isSelfMuted() {
            return this.isSelfMuted || this.isSelfDeafened;
        }

        public final MediaEngine.VoiceConfig toMediaEngineVoiceConfig() {
            int i = 63 & 1;
            int i2 = 63 & 8;
            int i3 = 63 & 16;
            return new MediaEngine.VoiceConfig(this.outputVolume, this.echoCancellation, _Arrays.contains(new NoiseProcessing[]{NoiseProcessing.Suppression, NoiseProcessing.CancellationTemporarilyDisabled}, this.noiseProcessing), this.noiseProcessing == NoiseProcessing.Cancellation, this.automaticGainControl, this.inputMode, new MediaEngineConnection.C5647c((int) this.sensitivity, (2 & 63) != 0 ? 10 : 0, (63 & 4) != 0 ? 40 : 0, this.automaticVad, this.vadUseKrisp == VadUseKrisp.Enabled, (63 & 32) != 0 ? 5 : 0), this.isSelfDeafened, isSelfMuted());
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("VoiceConfiguration(isSelfMuted=");
            sbM833U.append(this.isSelfMuted);
            sbM833U.append(", isSelfDeafened=");
            sbM833U.append(this.isSelfDeafened);
            sbM833U.append(", automaticVad=");
            sbM833U.append(this.automaticVad);
            sbM833U.append(", vadUseKrisp=");
            sbM833U.append(this.vadUseKrisp);
            sbM833U.append(", automaticGainControl=");
            sbM833U.append(this.automaticGainControl);
            sbM833U.append(", echoCancellation=");
            sbM833U.append(this.echoCancellation);
            sbM833U.append(", noiseProcessing=");
            sbM833U.append(this.noiseProcessing);
            sbM833U.append(", sensitivity=");
            sbM833U.append(this.sensitivity);
            sbM833U.append(", inputMode=");
            sbM833U.append(this.inputMode);
            sbM833U.append(", outputVolume=");
            sbM833U.append(this.outputVolume);
            sbM833U.append(", mutedUsers=");
            sbM833U.append(this.mutedUsers);
            sbM833U.append(", userOutputVolumes=");
            sbM833U.append(this.userOutputVolumes);
            sbM833U.append(", offScreenUsers=");
            sbM833U.append(this.offScreenUsers);
            sbM833U.append(", enableVideoHardwareScaling=");
            sbM833U.append(this.enableVideoHardwareScaling);
            sbM833U.append(", voiceParticipantsHidden=");
            return outline.m827O(sbM833U, this.voiceParticipantsHidden, ")");
        }

        public /* synthetic */ VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? VadUseKrisp.Enabled : vadUseKrisp, (i & 16) != 0 ? true : z5, (i & 32) == 0 ? z6 : true, (i & 64) != 0 ? NoiseProcessing.Cancellation : noiseProcessing, (i & 128) != 0 ? -50.0f : f, (i & 256) != 0 ? MediaEngineConnection.InputMode.VOICE_ACTIVITY : inputMode, (i & 512) != 0 ? 100.0f : f2, (i & 1024) != 0 ? Maps6.emptyMap() : map, (i & 2048) != 0 ? Maps6.emptyMap() : map2, (i & 4096) != 0 ? Maps6.emptyMap() : map3, (i & 8192) != 0 ? false : z7, (i & 16384) == 0 ? z8 : false);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VadUseKrisp.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[VadUseKrisp.TemporarilyDisabled.ordinal()] = 1;
            NoiseProcessing.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NoiseProcessing.CancellationTemporarilyDisabled.ordinal()] = 1;
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$getInputMode$1 */
    public static final class C61841<T, R> implements Func1<VoiceConfiguration, MediaEngineConnection.InputMode> {
        public static final C61841 INSTANCE = new C61841();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ MediaEngineConnection.InputMode call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final MediaEngineConnection.InputMode call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getInputMode();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersMuted$1 */
    public static final class C61851<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Boolean>> {
        public static final C61851 INSTANCE = new C61851();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Boolean> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Boolean> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getMutedUsers();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersOffScreen$1 */
    public static final class C61861<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Boolean>> {
        public static final C61861 INSTANCE = new C61861();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Boolean> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Boolean> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getOffScreenUsers();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersVolume$1 */
    public static final class C61871<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Float>> {
        public static final C61871 INSTANCE = new C61871();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Float> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Float> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getUserOutputVolumes();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$init$1 */
    public static final class C61881<T, R> implements Func1<Long, Observable<? extends Boolean>> {

        /* compiled from: StoreMediaSettings.kt */
        /* renamed from: com.discord.stores.StoreMediaSettings$init$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Boolean>> {
            public final /* synthetic */ Long $id;

            /* compiled from: StoreMediaSettings.kt */
            /* renamed from: com.discord.stores.StoreMediaSettings$init$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132611<T, R> implements Func1<Long, Boolean> {
                public static final C132611 INSTANCE = new C132611();

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Boolean call(Long l) {
                    return call2(l);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Boolean call2(Long l) {
                    return Boolean.valueOf(PermissionUtils.can(Permission.USE_VAD, l));
                }
            }

            public AnonymousClass1(Long l) {
                this.$id = l;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Channel channel) {
                return call2(channel);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Boolean> call2(Channel channel) {
                if (channel == null || ChannelUtils.m7667B(channel) || ChannelUtils.m7669D(channel)) {
                    return new ScalarSynchronousObservable(Boolean.TRUE);
                }
                StorePermissions storePermissionsAccess$getStorePermissions$p = StoreMediaSettings.access$getStorePermissions$p(StoreMediaSettings.this);
                Long l = this.$id;
                Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
                return storePermissionsAccess$getStorePermissions$p.observePermissionsForChannel(l.longValue()).m11083G(C132611.INSTANCE);
            }
        }

        public C61881() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Long l) {
            StoreChannels storeChannelsAccess$getStoreChannels$p = StoreMediaSettings.access$getStoreChannels$p(StoreMediaSettings.this);
            Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
            return storeChannelsAccess$getStoreChannels$p.observeChannel(l.longValue()).m11099Y(new AnonymousClass1(l));
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$init$2 */
    public static final /* synthetic */ class C61892 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C61892(StoreMediaSettings storeMediaSettings) {
            super(1, storeMediaSettings, StoreMediaSettings.class, "handleCanUseVad", "handleCanUseVad(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            StoreMediaSettings.access$handleCanUseVad((StoreMediaSettings) this.receiver, z2);
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$isSelfDeafened$1 */
    public static final class C61901<T, R> implements Func1<VoiceConfiguration, Boolean> {
        public static final C61901 INSTANCE = new C61901();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(VoiceConfiguration voiceConfiguration) {
            return Boolean.valueOf(voiceConfiguration.isSelfDeafened());
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    /* renamed from: com.discord.stores.StoreMediaSettings$isSelfMuted$1 */
    public static final class C61911<T, R> implements Func1<VoiceConfiguration, Boolean> {
        public static final C61911 INSTANCE = new C61911();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(VoiceConfiguration voiceConfiguration) {
            return Boolean.valueOf(voiceConfiguration.isSelfMuted());
        }
    }

    public /* synthetic */ StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeVoiceChannelSelected, storeChannels, storePermissions, (i & 8) != 0 ? new VoiceConfigurationCache(SharedPreferencesProvider.INSTANCE.get()) : voiceConfigurationCache, (i & 16) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storeChannels;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storePermissions;
    }

    public static final /* synthetic */ void access$handleCanUseVad(StoreMediaSettings storeMediaSettings, boolean z2) {
        storeMediaSettings.handleCanUseVad(z2);
    }

    private final synchronized void handleCanUseVad(boolean canUseVad) {
        this.canUseVad = canUseVad;
        updateForceMute();
    }

    private final void setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
        this.voiceConfiguration = voiceConfiguration;
        this.voiceConfigurationSubject.f27653k.onNext(voiceConfiguration);
        this.voiceConfigurationCache.write(voiceConfiguration);
    }

    private final void updateForceMute() {
        this.forceSelfMuteReason = null;
        if (!this.canUseVad && this.voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            this.forceSelfMuteReason = SelfMuteFailure.CANNOT_USE_VAD;
        }
        if (this.forceSelfMuteReason != null) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, true, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32766, null));
        }
    }

    public final Observable<MediaEngineConnection.InputMode> getInputMode() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61841.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…    .map { it.inputMode }");
        Observable<MediaEngineConnection.InputMode> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized Map<Long, Boolean> getMutedUsers() {
        return this.voiceConfiguration.getMutedUsers();
    }

    public final Observable<Map<Long, Boolean>> getUsersMuted() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61851.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…   .map { it.mutedUsers }");
        Observable<Map<Long, Boolean>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Boolean>> getUsersOffScreen() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61861.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…map { it.offScreenUsers }");
        Observable<Map<Long, Boolean>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Float>> getUsersVolume() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61871.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec… { it.userOutputVolumes }");
        Observable<Map<Long, Float>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized boolean getVideoHardwareScalingBlocking() {
        return this.voiceConfiguration.getEnableVideoHardwareScaling();
    }

    public final Observable<VoiceConfiguration> getVoiceConfig() {
        Observable<VoiceConfiguration> observableM11112r = ObservableExtensionsKt.computationLatest(this.voiceConfigurationSubject).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<VoiceConfiguration> getVoiceConfiguration() {
        return this.voiceConfigurationSubject;
    }

    public final synchronized VoiceConfiguration getVoiceConfigurationBlocking() {
        return this.voiceConfiguration;
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.storeChannels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null || !ChannelUtils.m7667B(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
            return;
        }
        setSelfDeafen(false);
    }

    public final void init() {
        setVoiceConfiguration(this.voiceConfigurationCache.read());
        Observable<R> observableM11099Y = this.storeVoiceChannelSelected.observeSelectedVoiceChannelId().m11099Y(new C61881());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeVoiceChannelSelecte…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableM11099Y, StoreMediaSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C61892(this), 62, (Object) null);
    }

    public final Observable<Boolean> isSelfDeafened() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61901.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…map { it.isSelfDeafened }");
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> isSelfMuted() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(C61911.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec….map { it.isSelfMuted() }");
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized void revertTemporaryDisableKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp().ordinal() != 2 ? this.voiceConfiguration.getVadUseKrisp() : VadUseKrisp.Enabled;
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing().ordinal() != 3 ? this.voiceConfiguration.getNoiseProcessing() : NoiseProcessing.Cancellation;
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing() || vadUseKrisp != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32695, null));
        }
    }

    public final synchronized void setNoiseProcessing(NoiseProcessing noiseProcessing) {
        Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }

    public final synchronized void setOutputVolume(float outputVolume) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, outputVolume, null, null, null, false, false, 32255, null));
    }

    public final synchronized void setSelfDeafen(boolean isDeafened) {
        if (this.voiceConfiguration.isSelfDeafened() == isDeafened) {
            return;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, isDeafened, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32765, null));
        this.appSoundManager.play(isDeafened ? AppSound.INSTANCE.getSOUND_DEAFEN() : AppSound.INSTANCE.getSOUND_UNDEAFEN());
    }

    public final synchronized SelfMuteFailure setSelfMuted(boolean isMuted) {
        if (this.voiceConfiguration.isSelfMuted() == isMuted) {
            return null;
        }
        SelfMuteFailure selfMuteFailure = this.forceSelfMuteReason;
        if (selfMuteFailure != null) {
            return selfMuteFailure;
        }
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, isMuted, voiceConfiguration.isSelfDeafened() && isMuted, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32764, null));
        this.appSoundManager.play(isMuted ? AppSound.INSTANCE.getSOUND_MUTE() : AppSound.INSTANCE.getSOUND_UNMUTE());
        return null;
    }

    public final synchronized void setSensitivity(float sensitivity) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, sensitivity, null, 0.0f, null, null, null, false, false, 32639, null));
    }

    public final synchronized void setUserOffScreen(long userId, boolean offScreen) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getOffScreenUsers());
        map.put(Long.valueOf(userId), Boolean.valueOf(offScreen));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, map, false, false, 28671, null));
    }

    public final synchronized void setUserOutputVolume(long userId, float volume) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getUserOutputVolumes());
        map.put(Long.valueOf(userId), Float.valueOf(volume));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, map, null, false, false, 30719, null));
    }

    public final synchronized void setVADUseKrisp(VadUseKrisp status) {
        Intrinsics3.checkNotNullParameter(status, "status");
        if (status != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, status, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
        }
    }

    public final synchronized void setVoiceInputMode(MediaEngineConnection.InputMode inputMode) {
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, inputMode, 0.0f, null, null, null, false, false, 32511, null));
        updateForceMute();
    }

    public final synchronized void toggleAutomaticGainControl() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, !voiceConfiguration.getAutomaticGainControl(), false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32751, null));
    }

    public final synchronized void toggleAutomaticVAD() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, !voiceConfiguration.getAutomaticVad(), null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32763, null));
    }

    public final synchronized void toggleEchoCancellation() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, !voiceConfiguration.getEchoCancellation(), null, 0.0f, null, 0.0f, null, null, null, false, false, 32735, null));
    }

    public final synchronized void toggleEnableVideoHardwareScaling() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, !voiceConfiguration.getEnableVideoHardwareScaling(), false, 24575, null));
    }

    public final synchronized void toggleNoiseCancellation() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Cancellation;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.Suppression);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleNoiseSuppression() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Suppression;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.None);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleSelfDeafened() {
        setSelfDeafen(!this.voiceConfiguration.isSelfDeafened());
    }

    public final synchronized SelfMuteFailure toggleSelfMuted() {
        return setSelfMuted(!this.voiceConfiguration.isSelfMuted());
    }

    public final synchronized void toggleUserMuted(long userId) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getMutedUsers());
        Boolean bool = (Boolean) map.get(Long.valueOf(userId));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "get(userId) ?: false");
        map.put(Long.valueOf(userId), Boolean.valueOf(!bool.booleanValue()));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, map, null, null, false, false, 31743, null));
    }

    public final synchronized void toggleVADUseKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp();
        VadUseKrisp vadUseKrisp2 = VadUseKrisp.Enabled;
        if (vadUseKrisp == vadUseKrisp2) {
            vadUseKrisp2 = VadUseKrisp.Disabled;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp2, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
    }

    public final synchronized void updateVoiceParticipantsHidden(boolean hidden) {
        if (this.voiceConfiguration.getVoiceParticipantsHidden() != hidden) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, hidden, 16383, null));
        }
    }

    public StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager) {
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(voiceConfigurationCache, "voiceConfigurationCache");
        Intrinsics3.checkNotNullParameter(appSoundManager, "appSoundManager");
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.voiceConfigurationCache = voiceConfigurationCache;
        this.appSoundManager = appSoundManager;
        VoiceConfiguration default_voice_config = VoiceConfiguration.INSTANCE.getDEFAULT_VOICE_CONFIG();
        this.voiceConfiguration = default_voice_config;
        this.voiceConfigurationSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(default_voice_config));
        this.canUseVad = true;
    }

    public final synchronized void setVoiceConfiguration(NoiseProcessing noiseProcessing) {
        Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }
}
