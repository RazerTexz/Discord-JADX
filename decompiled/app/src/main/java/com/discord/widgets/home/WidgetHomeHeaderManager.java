package com.discord.widgets.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.toolbar.ToolbarUtils2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StatusView;
import com.discord.views.ToolbarTitleLayout;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.WidgetHomePanelCenterChatBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager {
    private static final String ANALYTICS_SOURCE = "Toolbar";
    public static final WidgetHomeHeaderManager INSTANCE = new WidgetHomeHeaderManager();

    /* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
    public static final /* data */ class HeaderData {
        private final Integer drawableRes;
        private final boolean leftButtonIsBack;
        private final CharSequence subtitle;
        private final CharSequence title;
        private final Integer trailingDrawable;

        public HeaderData(CharSequence charSequence, CharSequence charSequence2, @DrawableRes Integer num, boolean z2, @DrawableRes Integer num2) {
            this.title = charSequence;
            this.subtitle = charSequence2;
            this.drawableRes = num;
            this.leftButtonIsBack = z2;
            this.trailingDrawable = num2;
        }

        public static /* synthetic */ HeaderData copy$default(HeaderData headerData, CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = headerData.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = headerData.subtitle;
            }
            CharSequence charSequence3 = charSequence2;
            if ((i & 4) != 0) {
                num = headerData.drawableRes;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                z2 = headerData.leftButtonIsBack;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                num2 = headerData.trailingDrawable;
            }
            return headerData.copy(charSequence, charSequence3, num3, z3, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        public final HeaderData copy(CharSequence title, CharSequence subtitle, @DrawableRes Integer drawableRes, boolean leftButtonIsBack, @DrawableRes Integer trailingDrawable) {
            return new HeaderData(title, subtitle, drawableRes, leftButtonIsBack, trailingDrawable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeaderData)) {
                return false;
            }
            HeaderData headerData = (HeaderData) other;
            return Intrinsics3.areEqual(this.title, headerData.title) && Intrinsics3.areEqual(this.subtitle, headerData.subtitle) && Intrinsics3.areEqual(this.drawableRes, headerData.drawableRes) && this.leftButtonIsBack == headerData.leftButtonIsBack && Intrinsics3.areEqual(this.trailingDrawable, headerData.trailingDrawable);
        }

        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final boolean getLeftButtonIsBack() {
            return this.leftButtonIsBack;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final Integer getTrailingDrawable() {
            return this.trailingDrawable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.subtitle;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            Integer num = this.drawableRes;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            boolean z2 = this.leftButtonIsBack;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            Integer num2 = this.trailingDrawable;
            return i + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("HeaderData(title=");
            sbM833U.append(this.title);
            sbM833U.append(", subtitle=");
            sbM833U.append(this.subtitle);
            sbM833U.append(", drawableRes=");
            sbM833U.append(this.drawableRes);
            sbM833U.append(", leftButtonIsBack=");
            sbM833U.append(this.leftButtonIsBack);
            sbM833U.append(", trailingDrawable=");
            return outline.m818F(sbM833U, this.trailingDrawable, ")");
        }

        public /* synthetic */ HeaderData(CharSequence charSequence, CharSequence charSequence2, Integer num, boolean z2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? null : charSequence2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : num2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configureThreadBrowserIconBehavior$1 */
    /* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
    public static final class ViewOnClickListenerC89701 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;

        public ViewOnClickListenerC89701(Context context, Channel channel) {
            this.$context = context;
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowser.INSTANCE.show(this.$context, this.$channel.getGuildId(), ChannelUtils.m7673H(this.$channel) ? this.$channel.getParentId() : this.$channel.getId(), "Chat List Header");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$getOnConfigureAction$1 */
    /* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
    public static final class C89711<T> implements Action1<Menu> {
        public final /* synthetic */ Resources $resources;
        public final /* synthetic */ WidgetHomeModel $this_getOnConfigureAction;

        public C89711(WidgetHomeModel widgetHomeModel, Resources resources) {
            this.$this_getOnConfigureAction = widgetHomeModel;
            this.$resources = resources;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            boolean z2 = false;
            boolean z3 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.m7670E(this.$this_getOnConfigureAction.getChannel());
            boolean zIsSmallScreen = DeviceUtils.INSTANCE.isSmallScreen(this.$resources);
            boolean z4 = this.$this_getOnConfigureAction.getThreadExperimentEnabled() && this.$this_getOnConfigureAction.getThreadCount() > 0 && !WidgetHomeHeaderManager.access$isChannelNSFWGated(WidgetHomeHeaderManager.INSTANCE, this.$this_getOnConfigureAction.isChannelNsfw(), this.$this_getOnConfigureAction.isNsfwUnConsented(), this.$this_getOnConfigureAction.getNsfwAllowed());
            Channel channel = this.$this_getOnConfigureAction.getChannel();
            Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
            if ((numValueOf != null && numValueOf.intValue() == 3) || (numValueOf != null && numValueOf.intValue() == 1)) {
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem.setVisible(false);
                MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem2.setVisible(true);
                MenuItem menuItemFindItem3 = menu.findItem(C5419R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem3, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem3.setVisible(false);
            } else if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))) {
                MenuItem menuItemFindItem4 = menu.findItem(C5419R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem4, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem4.setVisible(true);
                if (zIsSmallScreen) {
                    MenuItem menuItemFindItem5 = menu.findItem(C5419R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem5, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem5.setVisible(!this.$this_getOnConfigureAction.getThreadExperimentEnabled());
                    MenuItem menuItemFindItem6 = menu.findItem(C5419R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem6, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem6.setVisible(z4);
                } else {
                    MenuItem menuItemFindItem7 = menu.findItem(C5419R.id.menu_chat_search);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem7, "menu.findItem(R.id.menu_chat_search)");
                    menuItemFindItem7.setVisible(true);
                    MenuItem menuItemFindItem8 = menu.findItem(C5419R.id.menu_chat_thread_browser);
                    Intrinsics3.checkNotNullExpressionValue(menuItemFindItem8, "menu.findItem(R.id.menu_chat_thread_browser)");
                    menuItemFindItem8.setVisible(z4);
                }
            } else if ((numValueOf != null && numValueOf.intValue() == 10) || ((numValueOf != null && numValueOf.intValue() == 12) || (numValueOf != null && numValueOf.intValue() == 11))) {
                MenuItem menuItemFindItem9 = menu.findItem(C5419R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem9, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem9.setVisible(!ChannelUtils.m7686j(this.$this_getOnConfigureAction.getChannel()));
                MenuItem menuItemFindItem10 = menu.findItem(C5419R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem10, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem10.setVisible(!zIsSmallScreen);
                MenuItem menuItemFindItem11 = menu.findItem(C5419R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem11, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem11.setVisible(false);
            } else if (numValueOf != null && numValueOf.intValue() == 14) {
                MenuItem menuItemFindItem12 = menu.findItem(C5419R.id.menu_chat_search);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem12, "menu.findItem(R.id.menu_chat_search)");
                menuItemFindItem12.setVisible(false);
                MenuItem menuItemFindItem13 = menu.findItem(C5419R.id.menu_chat_side_panel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem13, "menu.findItem(R.id.menu_chat_side_panel)");
                menuItemFindItem13.setVisible(true);
                MenuItem menuItemFindItem14 = menu.findItem(C5419R.id.menu_chat_thread_browser);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem14, "menu.findItem(R.id.menu_chat_thread_browser)");
                menuItemFindItem14.setVisible(false);
            }
            boolean z5 = this.$this_getOnConfigureAction.getChannel() != null && ChannelUtils.m7667B(this.$this_getOnConfigureAction.getChannel());
            MenuItem menuItemFindItem15 = menu.findItem(C5419R.id.menu_chat_start_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem15, "menu.findItem(R.id.menu_chat_start_call)");
            menuItemFindItem15.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
            MenuItem menuItemFindItem16 = menu.findItem(C5419R.id.menu_chat_start_video_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem16, "menu.findItem(R.id.menu_chat_start_video_call)");
            menuItemFindItem16.setVisible((this.$this_getOnConfigureAction.isCallConnected() || !z5 || z3) ? false : true);
            MenuItem menuItemFindItem17 = menu.findItem(C5419R.id.menu_chat_stop_call);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem17, "menu.findItem(R.id.menu_chat_stop_call)");
            if (this.$this_getOnConfigureAction.isCallConnected() && !z3) {
                z2 = true;
            }
            menuItemFindItem17.setVisible(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$getOnSelectedAction$1 */
    /* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
    public static final class C89721 implements Action2<MenuItem, Context> {
        public final /* synthetic */ AppFragment $appFragment;
        public final /* synthetic */ PanelLayout $panelLayout;
        public final /* synthetic */ WidgetHomeModel $this_getOnSelectedAction;

        public C89721(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
            this.$this_getOnSelectedAction = widgetHomeModel;
            this.$appFragment = appFragment;
            this.$panelLayout = panelLayout;
        }

        private final void launchForSearch(Context context) {
            Channel channel = this.$this_getOnSelectedAction.getChannel();
            if (channel != null && ChannelUtils.m7667B(channel)) {
                WidgetSearch.INSTANCE.launchForChannel(this.$this_getOnSelectedAction.getChannelId(), context);
                return;
            }
            Channel channel2 = this.$this_getOnSelectedAction.getChannel();
            if (channel2 == null || !ChannelUtils.m7698v(channel2)) {
                return;
            }
            WidgetSearch.INSTANCE.launchForGuild(this.$this_getOnSelectedAction.getChannel().getGuildId(), context);
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            Intrinsics3.checkNotNullParameter(context, "context");
            AppFragment appFragment = this.$appFragment;
            FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(appFragment, appFragment, context, parentFragmentManager);
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_chat_add_friend /* 2131364371 */:
                    WidgetFriendsAdd.Companion.show$default(WidgetFriendsAdd.INSTANCE, context, null, WidgetHomeHeaderManager.ANALYTICS_SOURCE, 2, null);
                    break;
                case C5419R.id.menu_chat_search /* 2131364372 */:
                    launchForSearch(context);
                    break;
                case C5419R.id.menu_chat_side_panel /* 2131364373 */:
                    this.$panelLayout.openEndPanel();
                    break;
                case C5419R.id.menu_chat_start_call /* 2131364374 */:
                    privateCallLauncher.launchVoiceCall(this.$this_getOnSelectedAction.getChannelId());
                    break;
                case C5419R.id.menu_chat_start_group /* 2131364375 */:
                    ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.$appFragment, this.$this_getOnSelectedAction.getChannel(), WidgetHomeHeaderManager.ANALYTICS_SOURCE, null, null, 24, null);
                    break;
                case C5419R.id.menu_chat_start_video_call /* 2131364376 */:
                    privateCallLauncher.launchVideoCall(this.$this_getOnSelectedAction.getChannelId());
                    break;
                case C5419R.id.menu_chat_stop_call /* 2131364377 */:
                    StoreStream.INSTANCE.getVoiceChannelSelected().clear();
                    break;
            }
            AppFragment.hideKeyboard$default(this.$appFragment, null, 1, null);
        }
    }

    private WidgetHomeHeaderManager() {
    }

    public static final /* synthetic */ boolean access$isChannelNSFWGated(WidgetHomeHeaderManager widgetHomeHeaderManager, boolean z2, boolean z3, NsfwAllowance nsfwAllowance) {
        return widgetHomeHeaderManager.isChannelNSFWGated(z2, z3, nsfwAllowance);
    }

    private final void configureThreadBrowserIconBehavior(Toolbar toolbar, WidgetHomeModel model, Channel channel, Context context) {
        View actionView;
        View actionView2;
        Menu menu;
        if (channel != null) {
            boolean z2 = !ChannelUtils.m7693q(channel);
            int threadCount = model.getThreadCount();
            View viewFindViewById = null;
            MenuItem menuItemFindItem = (toolbar == null || (menu = toolbar.getMenu()) == null) ? null : menu.findItem(C5419R.id.menu_chat_thread_browser);
            TextView textView = (menuItemFindItem == null || (actionView2 = menuItemFindItem.getActionView()) == null) ? null : (TextView) actionView2.findViewById(C5419R.id.thread_browser_count);
            if (textView != null) {
                textView.setText(String.valueOf(Math.min(99, threadCount)));
            }
            if (textView != null) {
                ViewKt.setVisible(textView, threadCount != 0 && z2);
            }
            if (menuItemFindItem != null && (actionView = menuItemFindItem.getActionView()) != null) {
                viewFindViewById = actionView.findViewById(C5419R.id.thread_browser_root);
            }
            if (viewFindViewById != null) {
                ViewKt.setVisible(viewFindViewById, z2);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new ViewOnClickListenerC89701(context, channel));
            }
        }
    }

    private final HeaderData getHeaderData(WidgetHomeModel widgetHomeModel, Context context) {
        StoreChannelsSelected.ResolvedSelectedChannel selectedChannel = widgetHomeModel.getSelectedChannel();
        if (!(selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel)) {
            return selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? new HeaderData(context.getString(C5419R.string.create_thread), ChannelUtils.m7680d(((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) widgetHomeModel.getSelectedChannel()).getParentChannel(), context, false), null, true, null, 16, null) : new HeaderData(null, null, null, false, null, 30, null);
        }
        Channel channel = widgetHomeModel.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf == null) {
            return new HeaderData(context.getString(C5419R.string.channels_unavailable_title), null, null, false, null, 26, null);
        }
        if (numValueOf.intValue() == 3) {
            return new HeaderData(ChannelUtils.m7680d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(C5419R.drawable.ic_group_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 1) {
            return new HeaderData(ChannelUtils.m7680d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(C5419R.drawable.ic_direct_message_header), false, null, 26, null);
        }
        if (numValueOf.intValue() == 14) {
            return new HeaderData(ChannelUtils.m7680d(widgetHomeModel.getChannel(), context, false), null, Integer.valueOf(C5419R.drawable.ic_hub_24dp), false, null, 26, null);
        }
        if (widgetHomeModel.getChannel().getId() <= 0) {
            return new HeaderData(null, null, null, false, null, 26, null);
        }
        String strM7680d = ChannelUtils.m7680d(widgetHomeModel.getChannel(), context, false);
        Channel parentChannel = widgetHomeModel.getParentChannel();
        return new HeaderData(strM7680d, parentChannel != null ? ChannelUtils.m7680d(parentChannel, context, false) : null, Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(widgetHomeModel.getChannel())), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) widgetHomeModel.getSelectedChannel()).getPeekParent() != null || ChannelUtils.m7675J(widgetHomeModel.getChannel()), null, 16, null);
    }

    private final Action1<Menu> getOnConfigureAction(WidgetHomeModel widgetHomeModel, Resources resources) {
        return new C89711(widgetHomeModel, resources);
    }

    private final C89721 getOnSelectedAction(WidgetHomeModel widgetHomeModel, AppFragment appFragment, PanelLayout panelLayout) {
        return new C89721(widgetHomeModel, appFragment, panelLayout);
    }

    private final boolean isChannelNSFWGated(boolean isChannelNsfw, boolean isNsfwUnConsented, NsfwAllowance nsfwAllowed) {
        return isChannelNsfw && (isNsfwUnConsented || (nsfwAllowed == NsfwAllowance.DISALLOWED));
    }

    public final void configure(WidgetHome widgetHome, WidgetHomeModel model, WidgetHomeBinding binding) {
        int themedDrawableRes$default;
        int i;
        Intrinsics3.checkNotNullParameter(widgetHome, "widgetHome");
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(binding, "binding");
        widgetHome.lockCloseRightPanel(model.getChannel() == null || !(ChannelUtils.m7667B(model.getChannel()) || ChannelUtils.m7698v(model.getChannel())) || ChannelUtils.m7686j(model.getChannel()));
        Channel channel = model.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 14) {
            widgetHome.bindToolbar(binding.f17127d.f963d);
        } else if (numValueOf != null && numValueOf.intValue() == 15) {
            widgetHome.bindToolbar(binding.f17127d.f961b);
        } else {
            WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = binding.f17127d.f962c;
            Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterChatBinding, "binding.panelCenter.widgetHomePanelCenterChat");
            widgetHome.bindToolbar(widgetHomePanelCenterChatBinding.f982a);
        }
        widgetHome.setActionBarTitleLayoutExpandedTappableArea();
        Context context = widgetHome.getContext();
        if (context != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            HeaderData headerData = widgetHomeHeaderManager.getHeaderData(model, context);
            CharSequence title = headerData.getTitle();
            CharSequence subtitle = headerData.getSubtitle();
            Integer drawableRes = headerData.getDrawableRes();
            boolean leftButtonIsBack = headerData.getLeftButtonIsBack();
            Integer trailingDrawable = headerData.getTrailingDrawable();
            if (leftButtonIsBack) {
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.ic_action_bar_back, 0, 2, (Object) null);
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                themedDrawableRes$default = C5419R.drawable.ic_menu_24dp;
            }
            Integer numValueOf2 = Integer.valueOf(themedDrawableRes$default);
            if (leftButtonIsBack) {
                i = C5419R.string.back;
            } else {
                if (leftButtonIsBack) {
                    throw new NoWhenBranchMatchedException();
                }
                i = C5419R.string.toggle_drawer;
            }
            widgetHome.setActionBarDisplayHomeAsUpEnabled(true, numValueOf2, Integer.valueOf(i));
            widgetHome.setActionBarTitle(title, drawableRes, trailingDrawable);
            widgetHome.setActionBarSubtitle(subtitle);
            Toolbar toolbar = widgetHome.getToolbar();
            if (toolbar != null) {
                toolbar.setNavigationOnClickListener(new WidgetHomeHeaderManager2(model, widgetHome, model, binding));
            }
        }
        widgetHome.setActionBarTitleClick(new WidgetHomeHeaderManager3(model, widgetHome, model, binding));
        WidgetHomeHeaderManager widgetHomeHeaderManager2 = INSTANCE;
        C89721 onSelectedAction = widgetHomeHeaderManager2.getOnSelectedAction(model, widgetHome, widgetHome.getPanelLayout());
        Resources resources = widgetHome.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "widgetHome.resources");
        Toolbar actionBarOptionsMenu = widgetHome.setActionBarOptionsMenu(C5419R.menu.menu_chat_toolbar, onSelectedAction, widgetHomeHeaderManager2.getOnConfigureAction(model, resources));
        Channel channel2 = model.getChannel();
        boolean zM7690n = channel2 != null ? ChannelUtils.m7690n(channel2, model.getDmPresence()) : false;
        ToolbarTitleLayout actionBarTitleLayout = widgetHome.getActionBarTitleLayout();
        if (actionBarTitleLayout != null) {
            Presence dmPresence = model.getDmPresence();
            StatusView statusView = actionBarTitleLayout.binding.f709c;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.toolbarPresence");
            statusView.setVisibility(zM7690n ? 0 : 8);
            actionBarTitleLayout.binding.f709c.setPresence(dmPresence);
        }
        TextView unreadCountView = widgetHome.getUnreadCountView();
        Integer numValueOf3 = Integer.valueOf(model.getUnreadCount());
        if (!(numValueOf3.intValue() > 0)) {
            numValueOf3 = null;
        }
        ViewExtensions.setTextAndVisibilityBy(unreadCountView, numValueOf3 != null ? String.valueOf(numValueOf3.intValue()) : null);
        Toolbar toolbar2 = widgetHome.getToolbar();
        if (toolbar2 != null) {
            ToolbarUtils2.positionUnreadCountView(toolbar2, unreadCountView);
        }
        widgetHomeHeaderManager2.configureThreadBrowserIconBehavior(actionBarOptionsMenu, model, model.getChannel(), widgetHome.getContext());
    }
}
