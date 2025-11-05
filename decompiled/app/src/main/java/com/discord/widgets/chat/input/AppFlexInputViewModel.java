package com.discord.widgets.chat.input;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.a.d.d0;
import b.b.a.h.a;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppPermissionsRequests;
import com.discord.panels.PanelState;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExpressionSuggestions;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.lytefast.flexinput.FlexInputAttachmentListener;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.e0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: AppFlexInputViewModel.kt */
/* loaded from: classes2.dex */
public final class AppFlexInputViewModel extends d0<FlexInputState> implements FlexInputViewModel {
    private static final String CHAT_GIFTING_NOTICE = "CHAT_GIFTING_NOTICE";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean attachmentView;
    private PublishSubject<a> eventSubject;
    private final AppPermissionsRequests permissionRequests;
    private FlexInputAttachmentListener singleAttachmentSelectedListener;
    private boolean singleSelectMode;
    private final StoreAnalytics storeAnalytics;
    private final StoreExpressionSuggestions storeExpressionSuggestions;
    private final StoreStickers storeStickers;

    /* compiled from: AppFlexInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass1(AppFlexInputViewModel appFlexInputViewModel) {
            super(1, appFlexInputViewModel, AppFlexInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            AppFlexInputViewModel.access$handleStoreState((AppFlexInputViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(AppFlexInputViewModel$Companion$observeStores$1.INSTANCE);
            m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long channelPermission;
        private final boolean isThreadCreation;
        private final PanelState leftPanelState;
        private final StoreNotices.Notice notice;
        private final PanelState rightPanelState;
        private final Channel selectedChannel;
        private final boolean stickerSuggestionsEnabled;

        public StoreState(PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3) {
            m.checkNotNullParameter(panelState, "leftPanelState");
            m.checkNotNullParameter(panelState2, "rightPanelState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.selectedChannel = channel;
            this.channelPermission = l;
            this.notice = notice;
            this.stickerSuggestionsEnabled = z2;
            this.isThreadCreation = z3;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices.Notice notice, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                panelState = storeState.leftPanelState;
            }
            if ((i & 2) != 0) {
                panelState2 = storeState.rightPanelState;
            }
            PanelState panelState3 = panelState2;
            if ((i & 4) != 0) {
                channel = storeState.selectedChannel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                l = storeState.channelPermission;
            }
            Long l2 = l;
            if ((i & 16) != 0) {
                notice = storeState.notice;
            }
            StoreNotices.Notice notice2 = notice;
            if ((i & 32) != 0) {
                z2 = storeState.stickerSuggestionsEnabled;
            }
            boolean z4 = z2;
            if ((i & 64) != 0) {
                z3 = storeState.isThreadCreation;
            }
            return storeState.copy(panelState, panelState3, channel2, l2, notice2, z4, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsThreadCreation() {
            return this.isThreadCreation;
        }

        public final StoreState copy(PanelState leftPanelState, PanelState rightPanelState, Channel selectedChannel, Long channelPermission, StoreNotices.Notice notice, boolean stickerSuggestionsEnabled, boolean isThreadCreation) {
            m.checkNotNullParameter(leftPanelState, "leftPanelState");
            m.checkNotNullParameter(rightPanelState, "rightPanelState");
            return new StoreState(leftPanelState, rightPanelState, selectedChannel, channelPermission, notice, stickerSuggestionsEnabled, isThreadCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.leftPanelState, storeState.leftPanelState) && m.areEqual(this.rightPanelState, storeState.rightPanelState) && m.areEqual(this.selectedChannel, storeState.selectedChannel) && m.areEqual(this.channelPermission, storeState.channelPermission) && m.areEqual(this.notice, storeState.notice) && this.stickerSuggestionsEnabled == storeState.stickerSuggestionsEnabled && this.isThreadCreation == storeState.isThreadCreation;
        }

        public final Long getChannelPermission() {
            return this.channelPermission;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final StoreNotices.Notice getNotice() {
            return this.notice;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        public final boolean getStickerSuggestionsEnabled() {
            return this.stickerSuggestionsEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            Channel channel = this.selectedChannel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Long l = this.channelPermission;
            int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
            StoreNotices.Notice notice = this.notice;
            int iHashCode5 = (iHashCode4 + (notice != null ? notice.hashCode() : 0)) * 31;
            boolean z2 = this.stickerSuggestionsEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            boolean z3 = this.isThreadCreation;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isThreadCreation() {
            return this.isThreadCreation;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", rightPanelState=");
            sbU.append(this.rightPanelState);
            sbU.append(", selectedChannel=");
            sbU.append(this.selectedChannel);
            sbU.append(", channelPermission=");
            sbU.append(this.channelPermission);
            sbU.append(", notice=");
            sbU.append(this.notice);
            sbU.append(", stickerSuggestionsEnabled=");
            sbU.append(this.stickerSuggestionsEnabled);
            sbU.append(", isThreadCreation=");
            return b.d.b.a.a.O(sbU, this.isThreadCreation, ")");
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$getMatchingStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Set<? extends Sticker>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Set<? extends Sticker> invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<Sticker> invoke2(String str) {
            m.checkNotNullParameter(str, "inputText");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            return StickerUtils.findStickerMatches$default(stickerUtils, str, StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), false, 4, null);
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onGiftButtonClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channelFindChannelById = companion.getChannels().findChannelById(companion.getChannelsSelected().getId());
            WidgetSettingsGifting.INSTANCE.launch(fragmentActivity, new Traits.Location((channelFindChannelById == null || channelFindChannelById.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.CHANNEL_TEXT_AREA, "Button Icon", "gift", null, 16, null));
            StoreNotices.markSeen$default(companion.getNotices(), AppFlexInputViewModel.CHAT_GIFTING_NOTICE, 0L, 2, null);
            return true;
        }
    }

    /* compiled from: AppFlexInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$onSendButtonClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                AppFlexInputViewModel.clean$default(AppFlexInputViewModel.this, false, 1, null);
            }
        }
    }

    public /* synthetic */ AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appPermissionsRequests, (i & 2) != 0 ? new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191) : flexInputState, (i & 4) != 0 ? Companion.access$observeStores(INSTANCE) : observable, (i & 8) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? StoreStream.INSTANCE.getExpressionSuggestions() : storeExpressionSuggestions);
    }

    public static final /* synthetic */ void access$handleStoreState(AppFlexInputViewModel appFlexInputViewModel, StoreState storeState) {
        appFlexInputViewModel.handleStoreState(storeState);
    }

    public static /* synthetic */ void clean$default(AppFlexInputViewModel appFlexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        appFlexInputViewModel.clean(z2);
    }

    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        FlexInputState flexInputStateRequireViewState = requireViewState();
        Channel selectedChannel = storeState.getSelectedChannel();
        Long channelPermission = storeState.getChannelPermission();
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState.a aVar = PanelState.a.a;
        boolean z3 = (m.areEqual(leftPanelState, aVar) ^ true) || (m.areEqual(storeState.getRightPanelState(), aVar) ^ true);
        boolean z4 = (storeState.getNotice() == null || storeState.getNotice().isInAppNotification() || storeState.getNotice().isPopup()) ? false : true;
        boolean zCan = selectedChannel == null ? false : storeState.isThreadCreation() ? PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, channelPermission) : PermissionUtils.INSTANCE.hasAccessWrite(selectedChannel, channelPermission);
        Integer numValueOf = selectedChannel != null ? Integer.valueOf(selectedChannel.getType()) : null;
        boolean z5 = (numValueOf != null && numValueOf.intValue() == 15) ? zCan && storeState.isThreadCreation() : zCan;
        boolean z6 = selectedChannel != null && (ChannelUtils.B(selectedChannel) || PermissionUtils.can(Permission.ATTACH_FILES, channelPermission));
        boolean z7 = flexInputStateRequireViewState.showExpressionTray;
        if (z4 || z3) {
            hideKeyboard();
            z2 = false;
        } else {
            z2 = z7;
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, z5, z6, z2, false, storeState.getStickerSuggestionsEnabled(), selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, selectedChannel != null ? Long.valueOf(selectedChannel.getGuildId()) : null, 575));
    }

    private final void showKeyboard() {
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a.c.a);
    }

    @MainThread
    public final void clean(boolean clearText) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, clearText ? "" : viewState.inputText, true, n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
        }
    }

    public final void focus() {
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a.C0060a.a);
    }

    public final boolean getAttachmentView() {
        return this.attachmentView;
    }

    public final List<Sticker> getMatchingStickers(String inputText) {
        m.checkNotNullParameter(inputText, "inputText");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        int length = inputText.length();
        return u.toList(3 <= length && 50 >= length ? anonymousClass1.invoke2(inputText) : n0.emptySet());
    }

    public final FlexInputAttachmentListener getSingleAttachmentSelectedListener() {
        return this.singleAttachmentSelectedListener;
    }

    public final boolean getSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean hasMediaPermissions() {
        return this.permissionRequests.hasMedia();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean hideExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || !viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return true;
    }

    public final void hideKeyboard() {
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(a.b.a);
    }

    public boolean isAttachmentViewEnabled() {
        return this.attachmentView;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public boolean isSingleSelectMode() {
        return this.singleSelectMode;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<a> observeEvents() {
        PublishSubject<a> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public Observable<FlexInputState> observeState() {
        return observeViewState();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onAttachmentsUpdated(List<? extends Attachment<? extends Object>> attachments) {
        m.checkNotNullParameter(attachments, "attachments");
        updateViewState(FlexInputState.a(requireViewState(), null, false, new ArrayList(attachments), false, false, null, false, false, false, false, false, null, null, 8187));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogDismissed(boolean showKeyboard) {
        if (showKeyboard) {
            showKeyboard();
        }
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 8159));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onContentDialogPageChanged(int index) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, Integer.valueOf(index), false, false, false, false, false, null, null, 8159));
        if (index == 0) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.MEDIA_PICKER);
        } else if (index == 1) {
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.FILES);
        } else {
            if (index != 2) {
                return;
            }
            this.storeAnalytics.trackChatInputComponentViewed(ChatInputComponentTypes.CAMERA);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onCreateThreadSelected() {
        Long l = requireViewState().channelId;
        Long l2 = requireViewState().guildId;
        if (l != null) {
            l.longValue();
            if (l2 != null) {
                l2.longValue();
                ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), l2.longValue(), l.longValue(), null, "Plus Button", 4, null);
                onContentDialogDismissed(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpandButtonClicked() {
        updateViewState(FlexInputState.a(requireViewState(), null, true, null, false, false, null, false, false, false, false, false, null, null, 8189));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onExpressionTrayButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.showExpressionTray) {
            showKeyboard();
        } else {
            hideKeyboard();
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, null, false, false, !flexInputStateRequireViewState.showExpressionTray, false, false, null, null, 7935));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onFlexInputFragmentPause() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGalleryButtonClicked() {
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (flexInputStateRequireViewState.ableToAttachFiles) {
            hideKeyboard();
            updateViewState(FlexInputState.a(flexInputStateRequireViewState, null, false, null, false, false, 0, false, false, false, false, false, null, null, 7903));
        } else {
            PublishSubject<a> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new a.e(R.string.cannot_attach_files));
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onGiftButtonClicked() {
        hideKeyboard();
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(CHAT_GIFTING_NOTICE, null, 0L, 0, false, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, AnonymousClass1.INSTANCE, 150, null));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onInputTextAppended(String appendText) {
        m.checkNotNullParameter(appendText, "appendText");
        f.P0(this, b.d.b.a.a.J(new StringBuilder(), requireViewState().inputText, appendText), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputTextChanged(String inputText, Boolean focused) {
        boolean z2;
        m.checkNotNullParameter(inputText, "inputText");
        FlexInputState flexInputStateRequireViewState = requireViewState();
        if (m.areEqual(inputText, flexInputStateRequireViewState.inputText) || !flexInputStateRequireViewState.ableToSendMessages) {
            return;
        }
        if (m.areEqual(focused, Boolean.TRUE)) {
            showKeyboard();
        } else if (m.areEqual(focused, Boolean.FALSE)) {
            hideKeyboard();
        }
        if (flexInputStateRequireViewState.showExpandedButtons) {
            if (inputText.length() > 0) {
                z2 = false;
            }
        } else {
            z2 = flexInputStateRequireViewState.showExpandedButtons;
        }
        if (inputText.length() > 0) {
            this.storeStickers.fetchEnabledStickerDirectory();
        }
        if (inputText.length() == 0) {
            this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(true);
        }
        updateViewState(FlexInputState.a(flexInputStateRequireViewState, inputText, z2, null, false, false, null, false, false, false, false, false, null, null, 8188));
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onInputTextClicked() {
        showKeyboard();
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        return false;
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public void onSendButtonClicked(FlexInputListener inputListener) {
        FlexInputState viewState = getViewState();
        if (viewState == null || inputListener == null) {
            return;
        }
        inputListener.onSend(viewState.inputText, viewState.attachments, new AnonymousClass1());
    }

    @MainThread
    public void onShowDialog() {
        hideKeyboard();
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void onSingleAttachmentSelected(Attachment<? extends Object> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        FlexInputAttachmentListener flexInputAttachmentListener = this.singleAttachmentSelectedListener;
        if (flexInputAttachmentListener != null) {
            flexInputAttachmentListener.onAttachmentSelected(attachment);
        }
    }

    @MainThread
    public final void onStickerSuggestionSent(boolean shouldClearInput) {
        FlexInputState viewState = getViewState();
        if (viewState != null) {
            updateViewState(FlexInputState.a(viewState, shouldClearInput ? "" : viewState.inputText, true, n.emptyList(), false, false, null, false, false, false, false, false, null, null, 8152));
            if (shouldClearInput) {
                hideKeyboard();
            } else {
                this.storeExpressionSuggestions.setExpressionSuggestionsEnabled(false);
            }
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    @MainThread
    public boolean onToolTipButtonLongPressed(View button) {
        m.checkNotNullParameter(button, "button");
        PublishSubject<a> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new a.d(button.getContentDescription().toString()));
        return true;
    }

    public void removeAttachment(Attachment<?> attachment) {
        List<? extends Attachment<? extends Object>> mutableList;
        List<Attachment<Object>> list;
        m.checkNotNullParameter(attachment, "attachment");
        FlexInputState viewState = getViewState();
        if (viewState == null || (list = viewState.attachments) == null || (mutableList = u.toMutableList((Collection) list)) == null) {
            mutableList = null;
        } else {
            e0.asMutableCollection(mutableList).remove(attachment);
        }
        if (mutableList != null) {
            onAttachmentsUpdated(mutableList);
        }
    }

    @Override // com.lytefast.flexinput.viewmodel.FlexInputViewModel
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        this.permissionRequests.requestMedia(onSuccess);
    }

    public void setAttachmentSelectedListener(FlexInputAttachmentListener attachmentListener) {
        m.checkNotNullParameter(attachmentListener, "attachmentListener");
        this.singleAttachmentSelectedListener = attachmentListener;
    }

    public final void setAttachmentView(boolean z2) {
        this.attachmentView = z2;
    }

    public void setAttachmentViewEnabled(boolean enabled) {
        this.attachmentView = enabled;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.attachmentViewEnabled != enabled) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.a(viewState2, null, false, null, enabled, false, null, false, false, false, false, false, null, null, 8183));
        }
    }

    public void setModeSingleSelect(boolean singleSelect) {
        this.singleSelectMode = singleSelect;
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.singleSelectMode != singleSelect) {
            FlexInputState viewState2 = getViewState();
            if (viewState2 == null) {
                viewState2 = new FlexInputState(null, false, null, false, false, null, false, false, false, false, false, null, null, 8191);
            }
            updateViewState(FlexInputState.a(viewState2, null, false, null, false, singleSelect, null, false, false, false, false, false, null, null, 8175));
        }
    }

    public void setShowExpressionTrayButtonBadge(boolean showBadge) {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, showBadge, false, null, null, 7679));
    }

    public final void setSingleAttachmentSelectedListener(FlexInputAttachmentListener flexInputAttachmentListener) {
        this.singleAttachmentSelectedListener = flexInputAttachmentListener;
    }

    public final void setSingleSelectMode(boolean z2) {
        this.singleSelectMode = z2;
    }

    @MainThread
    public boolean showExpressionTray() {
        FlexInputState viewState = getViewState();
        if (viewState == null || viewState.showExpressionTray) {
            return false;
        }
        updateViewState(FlexInputState.a(viewState, null, false, null, false, false, null, false, false, true, false, false, null, null, 7935));
        return true;
    }

    public final void showKeyboardAndHideExpressionTray() {
        updateViewState(FlexInputState.a(requireViewState(), null, false, null, false, false, null, false, false, false, false, false, null, null, 7935));
        showKeyboard();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFlexInputViewModel(AppPermissionsRequests appPermissionsRequests, FlexInputState flexInputState, Observable<StoreState> observable, StoreStickers storeStickers, StoreAnalytics storeAnalytics, StoreExpressionSuggestions storeExpressionSuggestions) {
        super(flexInputState);
        m.checkNotNullParameter(appPermissionsRequests, "permissionRequests");
        m.checkNotNullParameter(flexInputState, "initialViewState");
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeExpressionSuggestions, "storeExpressionSuggestions");
        this.permissionRequests = appPermissionsRequests;
        this.storeStickers = storeStickers;
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionSuggestions = storeExpressionSuggestions;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        m.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), AppFlexInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        this.attachmentView = true;
    }
}
