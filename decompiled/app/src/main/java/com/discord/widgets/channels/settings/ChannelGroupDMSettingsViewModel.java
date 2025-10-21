package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ChannelGroupDMSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restApi;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            ChannelGroupDMSettingsViewModel.access$handleStoreState(ChannelGroupDMSettingsViewModel.this, storeState);
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings) {
            Observable observableY = storeChannels.observeChannel(channelId).Y(new ChannelGroupDMSettingsViewModel2(storeUserGuildSettings));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels\n          …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            return companion.observeStoreState(j, storeChannels, storeUserGuildSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class Event {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class LeaveGroupSuccess extends Event {
            public static final LeaveGroupSuccess INSTANCE = new LeaveGroupSuccess();

            private LeaveGroupSuccess() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class SettingsSaved extends Event {
            public static final SettingsSaved INSTANCE = new SettingsSaved();

            private SettingsSaved() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Channel channel;
            private final ModelNotificationSettings notificationSettings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, ModelNotificationSettings modelNotificationSettings) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
                this.channel = channel;
                this.notificationSettings = modelNotificationSettings;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, ModelNotificationSettings modelNotificationSettings, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i & 2) != 0) {
                    modelNotificationSettings = valid.notificationSettings;
                }
                return valid.copy(channel, modelNotificationSettings);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public final Valid copy(Channel channel, ModelNotificationSettings notificationSettings) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
                return new Valid(channel, notificationSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channel, valid.channel) && Intrinsics3.areEqual(this.notificationSettings, valid.notificationSettings);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
                return iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channel=");
                sbU.append(this.channel);
                sbU.append(", notificationSettings=");
                sbU.append(this.notificationSettings);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final ChannelSettings channelSettings;
            private final String editedIconUrl;
            private final boolean hasUnsavedIconChange;

            /* renamed from: isDefaultPhoto$delegate, reason: from kotlin metadata */
            private final Lazy isDefaultPhoto;
            private final String originalIconUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ChannelSettings channelSettings, String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(channelSettings, "channelSettings");
                this.channelSettings = channelSettings;
                this.originalIconUrl = str;
                this.editedIconUrl = str2;
                this.hasUnsavedIconChange = !Intrinsics3.areEqual(str, str2);
                this.isDefaultPhoto = LazyJVM.lazy(new ChannelGroupDMSettingsViewModel3(this));
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ChannelSettings channelSettings, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelSettings = valid.channelSettings;
                }
                if ((i & 2) != 0) {
                    str = valid.originalIconUrl;
                }
                if ((i & 4) != 0) {
                    str2 = valid.editedIconUrl;
                }
                return valid.copy(channelSettings, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            /* renamed from: component2, reason: from getter */
            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            /* renamed from: component3, reason: from getter */
            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final Valid copy(ChannelSettings channelSettings, String originalIconUrl, String editedIconUrl) {
                Intrinsics3.checkNotNullParameter(channelSettings, "channelSettings");
                return new Valid(channelSettings, originalIconUrl, editedIconUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channelSettings, valid.channelSettings) && Intrinsics3.areEqual(this.originalIconUrl, valid.originalIconUrl) && Intrinsics3.areEqual(this.editedIconUrl, valid.editedIconUrl);
            }

            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            public final String getCurrentIconUrl() {
                if (!this.hasUnsavedIconChange) {
                    return IconUtils.getForChannel(this.channelSettings.getChannel(), null);
                }
                String str = this.editedIconUrl;
                return str != null ? str : IconUtils.INSTANCE.getDefaultForGroupDM(this.channelSettings.getChannel().getId());
            }

            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final boolean getHasUnsavedIconChange() {
                return this.hasUnsavedIconChange;
            }

            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            public int hashCode() {
                ChannelSettings channelSettings = this.channelSettings;
                int iHashCode = (channelSettings != null ? channelSettings.hashCode() : 0) * 31;
                String str = this.originalIconUrl;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.editedIconUrl;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public final boolean isDefaultPhoto() {
                return ((Boolean) this.isDefaultPhoto.getValue()).booleanValue();
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channelSettings=");
                sbU.append(this.channelSettings);
                sbU.append(", originalIconUrl=");
                sbU.append(this.originalIconUrl);
                sbU.append(", editedIconUrl=");
                return outline.J(sbU, this.editedIconUrl, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$editGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Valid valid) {
            super(1);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = ChannelGroupDMSettingsViewModel.access$getEventSubject$p(ChannelGroupDMSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.SettingsSaved.INSTANCE);
            ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel = ChannelGroupDMSettingsViewModel.this;
            ViewState.Valid valid = this.$viewState;
            ChannelGroupDMSettingsViewModel.access$updateViewState(channelGroupDMSettingsViewModel, valid.copy(ChannelSettings.copy$default(valid.getChannelSettings(), channel, false, null, 6, null), IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$leaveGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = ChannelGroupDMSettingsViewModel.access$getEventSubject$p(ChannelGroupDMSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.LeaveGroupSuccess.INSTANCE);
        }
    }

    public /* synthetic */ ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel) {
        return channelGroupDMSettingsViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, StoreState storeState) {
        channelGroupDMSettingsViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, ViewState viewState) {
        channelGroupDMSettingsViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Channel channel = valid.getChannel();
            ChannelSettings channelSettingsCreateFromNotificationSettings = ChannelSettings.INSTANCE.createFromNotificationSettings(channel, valid.getNotificationSettings());
            ViewState viewState = getViewState();
            updateViewState(viewState instanceof ViewState.Valid ? ViewState.Valid.copy$default((ViewState.Valid) viewState, channelSettingsCreateFromNotificationSettings, null, null, 6, null) : new ViewState.Valid(channelSettingsCreateFromNotificationSettings, IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    @MainThread
    public final void editGroup(long groupId, String name) {
        String originalIconUrl;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (valid.getHasUnsavedIconChange()) {
                originalIconUrl = valid.getEditedIconUrl();
                if (originalIconUrl == null) {
                    originalIconUrl = "";
                }
            } else {
                originalIconUrl = valid.getOriginalIconUrl();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.editGroupDM(groupId, new RestAPIParams.GroupDM(name, originalIconUrl)), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(valid), 62, (Object) null);
        }
    }

    @MainThread
    public final void leaveGroup() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.deleteChannel(valid.getChannelSettings().getChannel().getId()), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onIconEdited(String iconUrl) {
        Intrinsics3.checkNotNullParameter(iconUrl, "iconUrl");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, iconUrl, 3, null));
        }
    }

    @MainThread
    public final void removeEditedIcon() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, null, 3, null));
        }
    }

    public final void unmute(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.storeUserGuildSettings.setChannelMuted(context, this.channelId, false, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.restApi = restAPI;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
