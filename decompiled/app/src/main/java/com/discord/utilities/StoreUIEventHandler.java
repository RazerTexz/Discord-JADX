package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: StoreUIEventHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUIEventHandler {
    private final StoreChannels channelsStore;
    private final Context context;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreStageChannels stageChannelsStore;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            KrispOveruseDetector.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[KrispOveruseDetector.Status.CPU_OVERUSE.ordinal()] = 1;
            iArr[KrispOveruseDetector.Status.VAD_CPU_OVERUSE.ordinal()] = 2;
            iArr[KrispOveruseDetector.Status.FAILED.ordinal()] = 3;
            StoreUserGuildSettings.SettingsUpdateType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.GUILD.ordinal()] = 1;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CHANNEL.ordinal()] = 2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.THREAD.ordinal()] = 3;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CATEGORY.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$1 */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class C66621 extends Lambda implements Function1<KrispOveruseDetector.Status, Unit> {
        public C66621() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector.Status status) {
            invoke2(status);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(status, "it");
            StoreUIEventHandler.access$handleKrispStatusEvent(StoreUIEventHandler.this, status);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$2 */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class C66632 extends Lambda implements Function1<StoreUserGuildSettings.Event, Unit> {
        public C66632() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserGuildSettings.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            StoreUIEventHandler.access$handleUserGuildSettingsEvent(StoreUIEventHandler.this, event);
        }
    }

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        this.context = context;
        this.mediaEngineStore = storeMediaEngine;
        this.channelsStore = storeChannels;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.stageChannelsStore = storeStageChannels;
        this.storeUserGuildSettings = storeUserGuildSettings;
        subscribeToStoreEvents();
    }

    public static final /* synthetic */ void access$handleKrispStatusEvent(StoreUIEventHandler storeUIEventHandler, KrispOveruseDetector.Status status) {
        storeUIEventHandler.handleKrispStatusEvent(status);
    }

    public static final /* synthetic */ void access$handleUserGuildSettingsEvent(StoreUIEventHandler storeUIEventHandler, StoreUserGuildSettings.Event event) {
        storeUIEventHandler.handleUserGuildSettingsEvent(event);
    }

    @MainThread
    private final void handleKrispStatusEvent(KrispOveruseDetector.Status krispStatusEvent) {
        int i;
        Channel channel;
        StageRoles stageRolesM11392getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector.Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.m7669D(channel) && (stageRolesM11392getMyRolesvisDeB4 = this.stageChannelsStore.m11392getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m11407isAudienceimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = C5419R.string.mobile_noise_cancellation_cpu_overuse;
        } else if (iOrdinal == 1) {
            i = C5419R.string.mobile_noise_cancellation_failed;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.mobile_advanced_voice_activity_cpu_overuse;
        }
        AppToast.m169g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings.Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings.Event.SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings.Event.SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = C5419R.string.server_settings_updated;
        } else if (iOrdinal == 1) {
            i = C5419R.string.channel_settings_have_been_updated;
        } else if (iOrdinal == 2) {
            i = C5419R.string.thread_settings_updated;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.category_settings_have_been_updated;
        }
        AppToast.m169g(this.context, i, 0, null, 12);
        KotlinExtensions.getExhaustive(Unit.f27425a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(this.mediaEngineStore.onKrispStatusEvent()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C66621(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(this.storeUserGuildSettings.observeEvents()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C66632(), 62, (Object) null);
    }
}
