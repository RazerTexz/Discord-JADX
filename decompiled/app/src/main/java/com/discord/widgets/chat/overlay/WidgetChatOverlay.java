package com.discord.widgets.chat.overlay;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.i.x4;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import d0.g0.t;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetChatOverlay.kt */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: chatInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy chatInputViewModel;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private TypingIndicatorViewHolder typingIndicatorViewHolder;

    /* compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class OldMessageModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long channelId;
        private final boolean isViewingOldMessages;

        /* compiled from: WidgetChatOverlay.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<OldMessageModel> get() {
                Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeId().r().Y(WidgetChatOverlay$OldMessageModel$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public OldMessageModel(long j, boolean z2) {
            this.channelId = j;
            this.isViewingOldMessages = z2;
        }

        public static /* synthetic */ OldMessageModel copy$default(OldMessageModel oldMessageModel, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = oldMessageModel.channelId;
            }
            if ((i & 2) != 0) {
                z2 = oldMessageModel.isViewingOldMessages;
            }
            return oldMessageModel.copy(j, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public final OldMessageModel copy(long channelId, boolean isViewingOldMessages) {
            return new OldMessageModel(channelId, isViewingOldMessages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldMessageModel)) {
                return false;
            }
            OldMessageModel oldMessageModel = (OldMessageModel) other;
            return this.channelId == oldMessageModel.channelId && this.isViewingOldMessages == oldMessageModel.isViewingOldMessages;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            boolean z2 = this.isViewingOldMessages;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iA + i;
        }

        public final boolean isViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public String toString() {
            StringBuilder sbU = a.U("OldMessageModel(channelId=");
            sbU.append(this.channelId);
            sbU.append(", isViewingOldMessages=");
            return a.O(sbU, this.isViewingOldMessages, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class StickerAutocompleteState {
        private final boolean autocompleteVisible;
        private final FlexInputState flexInputState;
        private final boolean isForumPostDraftCreation;

        public StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
            m.checkNotNullParameter(flexInputState, "flexInputState");
            this.autocompleteVisible = z2;
            this.flexInputState = flexInputState;
            this.isForumPostDraftCreation = z3;
        }

        public static /* synthetic */ StickerAutocompleteState copy$default(StickerAutocompleteState stickerAutocompleteState, boolean z2, FlexInputState flexInputState, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = stickerAutocompleteState.autocompleteVisible;
            }
            if ((i & 2) != 0) {
                flexInputState = stickerAutocompleteState.flexInputState;
            }
            if ((i & 4) != 0) {
                z3 = stickerAutocompleteState.isForumPostDraftCreation;
            }
            return stickerAutocompleteState.copy(z2, flexInputState, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public final StickerAutocompleteState copy(boolean autocompleteVisible, FlexInputState flexInputState, boolean isForumPostDraftCreation) {
            m.checkNotNullParameter(flexInputState, "flexInputState");
            return new StickerAutocompleteState(autocompleteVisible, flexInputState, isForumPostDraftCreation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StickerAutocompleteState)) {
                return false;
            }
            StickerAutocompleteState stickerAutocompleteState = (StickerAutocompleteState) other;
            return this.autocompleteVisible == stickerAutocompleteState.autocompleteVisible && m.areEqual(this.flexInputState, stickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == stickerAutocompleteState.isForumPostDraftCreation;
        }

        public final boolean getAutocompleteVisible() {
            return this.autocompleteVisible;
        }

        public final FlexInputState getFlexInputState() {
            return this.flexInputState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.autocompleteVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            FlexInputState flexInputState = this.flexInputState;
            int iHashCode = (i + (flexInputState != null ? flexInputState.hashCode() : 0)) * 31;
            boolean z3 = this.isForumPostDraftCreation;
            return iHashCode + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isForumPostDraftCreation() {
            return this.isForumPostDraftCreation;
        }

        public String toString() {
            StringBuilder sbU = a.U("StickerAutocompleteState(autocompleteVisible=");
            sbU.append(this.autocompleteVisible);
            sbU.append(", flexInputState=");
            sbU.append(this.flexInputState);
            sbU.append(", isForumPostDraftCreation=");
            return a.O(sbU, this.isForumPostDraftCreation, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    public static final class TypingIndicatorViewHolder {
        private final WidgetChatOverlayBinding binding;

        public TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
            m.checkNotNullParameter(widgetChatOverlayBinding, "binding");
            this.binding = widgetChatOverlayBinding;
        }

        private final void configureTyping(ChatTypingModel.Typing model) throws Resources.NotFoundException {
            if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
                this.binding.d.c();
                RelativeLayout relativeLayout = this.binding.c;
                m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout2 = this.binding.c;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
            relativeLayout2.setVisibility(0);
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Resources resources = constraintLayout.getResources();
            m.checkNotNullExpressionValue(resources, "binding.root.resources");
            CharSequence typingString = getTypingString(resources, model.getTypingUsers());
            CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !t.isBlank(typingString));
            TextView textView = this.binding.g;
            m.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
            ViewExtensions.setTextAndVisibilityBy(textView, typingString);
            TypingDots typingDots = this.binding.d;
            m.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
            typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
            TypingDots typingDots2 = this.binding.d;
            if (!model.getTypingUsers().isEmpty()) {
                TypingDots.b(typingDots2, false, 1);
            } else {
                typingDots2.c();
            }
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
            ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
            ImageView imageView = this.binding.f;
            m.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
            imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
        }

        private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) throws Resources.NotFoundException {
            if (cooldownSecs > 0) {
                return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * cooldownSecs, null, null, 6, null);
            }
            if (channelRateLimit <= 0 || hasTypingText) {
                return "";
            }
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            String string = constraintLayout.getResources().getString(R.string.channel_slowmode_desc_short);
            m.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
            return string;
        }

        private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
            int size = typingUsers.size();
            return size != 0 ? size != 1 ? size != 2 ? size != 3 ? b.a.k.b.i(resources, R.string.several_users_typing, new Object[0], null, 4) : b.a.k.b.i(resources, R.string.three_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, null, 4) : b.a.k.b.i(resources, R.string.two_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1)}, null, 4) : b.a.k.b.i(resources, R.string.one_user_typing, new Object[]{typingUsers.get(0)}, null, 4) : "";
        }

        public final void configureUI(ChatTypingModel model) throws Resources.NotFoundException {
            m.checkNotNullParameter(model, "model");
            if (model instanceof ChatTypingModel.Hide) {
                RelativeLayout relativeLayout = this.binding.c;
                m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
            } else if (model instanceof ChatTypingModel.Typing) {
                configureTyping((ChatTypingModel.Typing) model);
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessagesLoader().requestNewestMessages();
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<OldMessageModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OldMessageModel oldMessageModel) {
            invoke2(oldMessageModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OldMessageModel oldMessageModel) {
            if (oldMessageModel.isViewingOldMessages()) {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f2345b.show();
            } else {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f2345b.hide();
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<ChatTypingModel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            invoke2(chatTypingModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            TypingIndicatorViewHolder typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(WidgetChatOverlay.this);
            m.checkNotNullExpressionValue(chatTypingModel, "it");
            typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$5, reason: invalid class name */
    public static final class AnonymousClass5<T1, T2, T3, R> implements Func3<Boolean, FlexInputState, StoreChannelsSelected.ResolvedSelectedChannel, StickerAutocompleteState> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ StickerAutocompleteState call(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return call2(bool, flexInputState, resolvedSelectedChannel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StickerAutocompleteState call2(Boolean bool, FlexInputState flexInputState, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            Channel parentChannel;
            if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                resolvedSelectedChannel = null;
            }
            StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
            m.checkNotNullExpressionValue(bool, "autocompleteVisible");
            boolean zBooleanValue = bool.booleanValue();
            m.checkNotNullExpressionValue(flexInputState, "flexInputState");
            return new StickerAutocompleteState(zBooleanValue, flexInputState, (threadDraft == null || (parentChannel = threadDraft.getParentChannel()) == null || !ChannelUtils.q(parentChannel)) ? false : true);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends k implements Function1<StickerAutocompleteState, Unit> {
        public AnonymousClass6(WidgetChatOverlay widgetChatOverlay) {
            super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAutocompleteState stickerAutocompleteState) {
            invoke2(stickerAutocompleteState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAutocompleteState stickerAutocompleteState) {
            m.checkNotNullParameter(stickerAutocompleteState, "p1");
            WidgetChatOverlay.access$configureStickerSuggestions((WidgetChatOverlay) this.receiver, stickerAutocompleteState);
        }
    }

    public WidgetChatOverlay() {
        super(R.layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatOverlay$binding$2.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetChatOverlay$flexInputViewModel$2(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatOverlay$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(WidgetChatOverlay$chatInputViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureStickerSuggestions(WidgetChatOverlay widgetChatOverlay, StickerAutocompleteState stickerAutocompleteState) {
        widgetChatOverlay.configureStickerSuggestions(stickerAutocompleteState);
    }

    public static final /* synthetic */ WidgetChatOverlayBinding access$getBinding$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getBinding();
    }

    public static final /* synthetic */ ChatInputViewModel access$getChatInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getChatInputViewModel();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetChatOverlay widgetChatOverlay) {
        return widgetChatOverlay.getFlexInputViewModel();
    }

    public static final /* synthetic */ TypingIndicatorViewHolder access$getTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay) {
        TypingIndicatorViewHolder typingIndicatorViewHolder = widgetChatOverlay.typingIndicatorViewHolder;
        if (typingIndicatorViewHolder == null) {
            m.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
        }
        return typingIndicatorViewHolder;
    }

    public static final /* synthetic */ void access$setTypingIndicatorViewHolder$p(WidgetChatOverlay widgetChatOverlay, TypingIndicatorViewHolder typingIndicatorViewHolder) {
        widgetChatOverlay.typingIndicatorViewHolder = typingIndicatorViewHolder;
    }

    private final void configureStickerSuggestions(StickerAutocompleteState stickerAutocompleteState) {
        boolean autocompleteVisible = stickerAutocompleteState.getAutocompleteVisible();
        FlexInputState flexInputState = stickerAutocompleteState.getFlexInputState();
        boolean isForumPostDraftCreation = stickerAutocompleteState.getIsForumPostDraftCreation();
        if (!flexInputState.expressionSuggestionsEnabled || autocompleteVisible || isForumPostDraftCreation) {
            x4 x4Var = getBinding().h;
            m.checkNotNullExpressionValue(x4Var, "binding.stickersSuggestions");
            LinearLayout linearLayout = x4Var.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        List listTake = u.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            x4 x4Var2 = getBinding().h;
            m.checkNotNullExpressionValue(x4Var2, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = x4Var2.a;
            m.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.INSTANCE.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        x4 x4Var3 = getBinding().h;
        m.checkNotNullExpressionValue(x4Var3, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = x4Var3.a;
        m.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : n.listOf((Object[]) new StickerView[]{getBinding().h.f230b, getBinding().h.c, getBinding().h.d, getBinding().h.e})) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            StickerView stickerView = (StickerView) obj;
            Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            m.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.e(stickerView, sticker, null, 2);
                stickerView.setOnClickListener(new WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1(sticker, stickerView, sticker, this, listTake, z2));
            }
            i = i2;
        }
    }

    private final WidgetChatOverlayBinding getBinding() {
        return (WidgetChatOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChatInputViewModel getChatInputViewModel() {
        return (ChatInputViewModel) this.chatInputViewModel.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetChatOverlayBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new TypingIndicatorViewHolder(binding);
        x4 x4Var = getBinding().h;
        m.checkNotNullExpressionValue(x4Var, "binding.stickersSuggestions");
        LinearLayout linearLayout = x4Var.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        m.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().h.f.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().f2345b.setOnClickListener(AnonymousClass2.INSTANCE);
        Observable<OldMessageModel> observableR = OldMessageModel.INSTANCE.get().r();
        m.checkNotNullExpressionValue(observableR, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        Observable observableR2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.INSTANCE.get()).r();
        m.checkNotNullExpressionValue(observableR2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableI = Observable.i(companion.getAutocomplete().observeAutocompleteVisibility().r(), getFlexInputViewModel().observeState().r(), companion.getChannelsSelected().observeResolvedSelectedChannel(), AnonymousClass5.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableI, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(this), 62, (Object) null);
    }
}
