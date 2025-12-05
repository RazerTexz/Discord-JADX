package com.discord.widgets.chat.overlay;

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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p025i.WidgetChatInputStickerSuggestionsBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: WidgetChatOverlay.kt */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChatOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatOverlayBinding;", 0)};

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
                Observable observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeId().m11112r().m11099Y(WidgetChatOverlay2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
                return observableM11099Y;
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
            int iM3a = C0002b.m3a(this.channelId) * 31;
            boolean z2 = this.isViewingOldMessages;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iM3a + i;
        }

        public final boolean isViewingOldMessages() {
            return this.isViewingOldMessages;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("OldMessageModel(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", isViewingOldMessages=");
            return outline.m827O(sbM833U, this.isViewingOldMessages, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    public static final /* data */ class StickerAutocompleteState {
        private final boolean autocompleteVisible;
        private final FlexInputState flexInputState;
        private final boolean isForumPostDraftCreation;

        public StickerAutocompleteState(boolean z2, FlexInputState flexInputState, boolean z3) {
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
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
            Intrinsics3.checkNotNullParameter(flexInputState, "flexInputState");
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
            return this.autocompleteVisible == stickerAutocompleteState.autocompleteVisible && Intrinsics3.areEqual(this.flexInputState, stickerAutocompleteState.flexInputState) && this.isForumPostDraftCreation == stickerAutocompleteState.isForumPostDraftCreation;
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
            StringBuilder sbM833U = outline.m833U("StickerAutocompleteState(autocompleteVisible=");
            sbM833U.append(this.autocompleteVisible);
            sbM833U.append(", flexInputState=");
            sbM833U.append(this.flexInputState);
            sbM833U.append(", isForumPostDraftCreation=");
            return outline.m827O(sbM833U, this.isForumPostDraftCreation, ")");
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    public static final class TypingIndicatorViewHolder {
        private final WidgetChatOverlayBinding binding;

        public TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
            Intrinsics3.checkNotNullParameter(widgetChatOverlayBinding, "binding");
            this.binding = widgetChatOverlayBinding;
        }

        private final void configureTyping(ChatTypingModel.Typing model) throws Resources.NotFoundException {
            if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
                this.binding.f16365d.m8620c();
                RelativeLayout relativeLayout = this.binding.f16364c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout2 = this.binding.f16364c;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
            relativeLayout2.setVisibility(0);
            ConstraintLayout constraintLayout = this.binding.f16362a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Resources resources = constraintLayout.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.root.resources");
            CharSequence typingString = getTypingString(resources, model.getTypingUsers());
            CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !StringsJVM.isBlank(typingString));
            TextView textView = this.binding.f16368g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
            ViewExtensions.setTextAndVisibilityBy(textView, typingString);
            TypingDots typingDots = this.binding.f16365d;
            Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
            typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
            TypingDots typingDots2 = this.binding.f16365d;
            if (!model.getTypingUsers().isEmpty()) {
                TypingDots.m8618b(typingDots2, false, 1);
            } else {
                typingDots2.m8620c();
            }
            TextView textView2 = this.binding.f16366e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
            ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
            ImageView imageView = this.binding.f16367f;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
            imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
        }

        private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) throws Resources.NotFoundException {
            if (cooldownSecs > 0) {
                return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * cooldownSecs, null, null, 6, null);
            }
            if (channelRateLimit <= 0 || hasTypingText) {
                return "";
            }
            ConstraintLayout constraintLayout = this.binding.f16362a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            String string = constraintLayout.getResources().getString(C5419R.string.channel_slowmode_desc_short);
            Intrinsics3.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
            return string;
        }

        private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
            int size = typingUsers.size();
            return size != 0 ? size != 1 ? size != 2 ? size != 3 ? FormatUtils.m217i(resources, C5419R.string.several_users_typing, new Object[0], null, 4) : FormatUtils.m217i(resources, C5419R.string.three_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, null, 4) : FormatUtils.m217i(resources, C5419R.string.two_users_typing, new Object[]{typingUsers.get(0), typingUsers.get(1)}, null, 4) : FormatUtils.m217i(resources, C5419R.string.one_user_typing, new Object[]{typingUsers.get(0)}, null, 4) : "";
        }

        public final void configureUI(ChatTypingModel model) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(model, "model");
            if (model instanceof ChatTypingModel.Hide) {
                RelativeLayout relativeLayout = this.binding.f16364c;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
                relativeLayout.setVisibility(8);
            } else if (model instanceof ChatTypingModel.Typing) {
                configureTyping((ChatTypingModel.Typing) model);
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$1 */
    public static final class ViewOnClickListenerC81951 implements View.OnClickListener {
        public static final ViewOnClickListenerC81951 INSTANCE = new ViewOnClickListenerC81951();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getExpressionSuggestions().setExpressionSuggestionsEnabled(false);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$2 */
    public static final class ViewOnClickListenerC81962 implements View.OnClickListener {
        public static final ViewOnClickListenerC81962 INSTANCE = new ViewOnClickListenerC81962();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessagesLoader().requestNewestMessages();
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$3 */
    public static final class C81973 extends Lambda implements Function1<OldMessageModel, Unit> {
        public C81973() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OldMessageModel oldMessageModel) {
            invoke2(oldMessageModel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OldMessageModel oldMessageModel) {
            if (oldMessageModel.isViewingOldMessages()) {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f16363b.show();
            } else {
                WidgetChatOverlay.access$getBinding$p(WidgetChatOverlay.this).f16363b.hide();
            }
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$4 */
    public static final class C81984 extends Lambda implements Function1<ChatTypingModel, Unit> {
        public C81984() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            invoke2(chatTypingModel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatTypingModel chatTypingModel) throws Resources.NotFoundException {
            TypingIndicatorViewHolder typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(WidgetChatOverlay.this);
            Intrinsics3.checkNotNullExpressionValue(chatTypingModel, "it");
            typingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$5 */
    public static final class C81995<T1, T2, T3, R> implements Func3<Boolean, FlexInputState, StoreChannelsSelected.ResolvedSelectedChannel, StickerAutocompleteState> {
        public static final C81995 INSTANCE = new C81995();

        @Override // p658rx.functions.Func3
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
            Intrinsics3.checkNotNullExpressionValue(bool, "autocompleteVisible");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(flexInputState, "flexInputState");
            return new StickerAutocompleteState(zBooleanValue, flexInputState, (threadDraft == null || (parentChannel = threadDraft.getParentChannel()) == null || !ChannelUtils.m7693q(parentChannel)) ? false : true);
        }
    }

    /* compiled from: WidgetChatOverlay.kt */
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$onViewBoundOrOnResume$6 */
    public static final /* synthetic */ class C82006 extends FunctionReferenceImpl implements Function1<StickerAutocompleteState, Unit> {
        public C82006(WidgetChatOverlay widgetChatOverlay) {
            super(1, widgetChatOverlay, WidgetChatOverlay.class, "configureStickerSuggestions", "configureStickerSuggestions(Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$StickerAutocompleteState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAutocompleteState stickerAutocompleteState) {
            invoke2(stickerAutocompleteState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAutocompleteState stickerAutocompleteState) {
            Intrinsics3.checkNotNullParameter(stickerAutocompleteState, "p1");
            WidgetChatOverlay.access$configureStickerSuggestions((WidgetChatOverlay) this.receiver, stickerAutocompleteState);
        }
    }

    public WidgetChatOverlay() {
        super(C5419R.layout.widget_chat_overlay);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatOverlay5.INSTANCE, null, 2, null);
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new C8190xf3aa4753(this), new AppViewModelDelegates2(new WidgetChatOverlay8(this)));
        this.chatInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChatInputViewModel.class), new C8192xf3aa4755(this), new AppViewModelDelegates2(WidgetChatOverlay6.INSTANCE));
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
            Intrinsics3.throwUninitializedPropertyAccessException("typingIndicatorViewHolder");
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
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().f16369h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
            LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.f1380a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
            linearLayout.setVisibility(8);
            return;
        }
        List listTake = _Collections.take(getFlexInputViewModel().getMatchingStickers(flexInputState.inputText), 4);
        boolean z2 = SearchUtils.INSTANCE.getQueriesFromSearchText(flexInputState.inputText).size() == 1;
        if (listTake == null || listTake.isEmpty()) {
            WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding2 = getBinding().f16369h;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding2, "binding.stickersSuggestions");
            LinearLayout linearLayout2 = widgetChatInputStickerSuggestionsBinding2.f1380a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.stickersSuggestions.root");
            linearLayout2.setVisibility(8);
            return;
        }
        StoreStream.INSTANCE.getExpressionSuggestions().trackExpressionSuggestionsDisplayed(flexInputState.inputText);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding3 = getBinding().f16369h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding3, "binding.stickersSuggestions");
        LinearLayout linearLayout3 = widgetChatInputStickerSuggestionsBinding3.f1380a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.stickersSuggestions.root");
        linearLayout3.setVisibility(0);
        int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new StickerView[]{getBinding().f16369h.f1381b, getBinding().f16369h.f1382c, getBinding().f16369h.f1383d, getBinding().f16369h.f1384e})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            StickerView stickerView = (StickerView) obj;
            Sticker sticker = i < listTake.size() ? (Sticker) listTake.get(i) : null;
            Intrinsics3.checkNotNullExpressionValue(stickerView, "stickerView");
            stickerView.setVisibility(sticker != null ? 0 : 8);
            if (sticker != null) {
                StickerView.m8613e(stickerView, sticker, null, 2);
                stickerView.setOnClickListener(new WidgetChatOverlay7(sticker, stickerView, sticker, this, listTake, z2));
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
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        this.typingIndicatorViewHolder = new TypingIndicatorViewHolder(binding);
        WidgetChatInputStickerSuggestionsBinding widgetChatInputStickerSuggestionsBinding = getBinding().f16369h;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputStickerSuggestionsBinding, "binding.stickersSuggestions");
        LinearLayout linearLayout = widgetChatInputStickerSuggestionsBinding.f1380a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stickersSuggestions.root");
        Drawable background = linearLayout.getBackground();
        Intrinsics3.checkNotNullExpressionValue(background, "binding.stickersSuggestions.root.background");
        background.setAlpha(216);
        getBinding().f16369h.f1385f.setOnClickListener(ViewOnClickListenerC81951.INSTANCE);
        getBinding().f16363b.setOnClickListener(ViewOnClickListenerC81962.INSTANCE);
        Observable<OldMessageModel> observableM11112r = OldMessageModel.INSTANCE.get().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "OldMessageModel.get()\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C81973(), 62, (Object) null);
        Observable observableM11112r2 = ObservableExtensionsKt.computationLatest(ChatTypingModel.INSTANCE.get()).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r2, "ChatTypingModel\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11112r2, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C81984(), 62, (Object) null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11075i = Observable.m11075i(companion.getAutocomplete().observeAutocompleteVisibility().m11112r(), getFlexInputViewModel().observeState().m11112r(), companion.getChannelsSelected().observeResolvedSelectedChannel(), C81995.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…() == true,\n      )\n    }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11075i, this, null, 2, null), WidgetChatOverlay.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82006(this), 62, (Object) null);
    }
}
