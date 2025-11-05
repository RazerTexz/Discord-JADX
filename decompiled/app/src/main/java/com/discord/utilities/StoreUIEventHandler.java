package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreUIEventHandler.kt */
/* loaded from: classes2.dex */
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

    /* compiled from: StoreUIEventHandler.kt */
    /* renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<KrispOveruseDetector.Status, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector.Status status) {
            invoke2(status);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KrispOveruseDetector.Status status) {
            m.checkNotNullParameter(status, "it");
            StoreUIEventHandler.access$handleKrispStatusEvent(StoreUIEventHandler.this, status);
        }
    }

    /* compiled from: StoreUIEventHandler.kt */
    /* renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<StoreUserGuildSettings.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserGuildSettings.Event event) {
            m.checkNotNullParameter(event, "event");
            StoreUIEventHandler.access$handleUserGuildSettingsEvent(StoreUIEventHandler.this, event);
        }
    }

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
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
        StageRoles stageRolesM15getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector.Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.D(channel) && (stageRolesM15getMyRolesvisDeB4 = this.stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = R.string.mobile_noise_cancellation_cpu_overuse;
        } else if (iOrdinal == 1) {
            i = R.string.mobile_noise_cancellation_failed;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.mobile_advanced_voice_activity_cpu_overuse;
        }
        b.a.d.m.g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings.Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings.Event.SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings.Event.SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = R.string.server_settings_updated;
        } else if (iOrdinal == 1) {
            i = R.string.channel_settings_have_been_updated;
        } else if (iOrdinal == 2) {
            i = R.string.thread_settings_updated;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.category_settings_have_been_updated;
        }
        b.a.d.m.g(this.context, i, 0, null, 12);
        KotlinExtensionsKt.getExhaustive(Unit.a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.mediaEngineStore.onKrispStatusEvent()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.storeUserGuildSettings.observeEvents()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
