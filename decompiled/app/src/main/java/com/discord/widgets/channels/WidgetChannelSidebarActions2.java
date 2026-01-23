package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSidebarActions2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSidebarActionsBinding> {
    public static final WidgetChannelSidebarActions2 INSTANCE = new WidgetChannelSidebarActions2();

    public WidgetChannelSidebarActions2() {
        super(1, WidgetChannelSidebarActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSidebarActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSidebarActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.widget_channel_sidebar_actions_guild_view;
        GuildChannelSideBarActionsView guildChannelSideBarActionsView = (GuildChannelSideBarActionsView) view.findViewById(C5419R.id.widget_channel_sidebar_actions_guild_view);
        if (guildChannelSideBarActionsView != null) {
            i = C5419R.id.widget_channel_sidebar_actions_private_view;
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = (PrivateChannelSideBarActionsView) view.findViewById(C5419R.id.widget_channel_sidebar_actions_private_view);
            if (privateChannelSideBarActionsView != null) {
                return new WidgetChannelSidebarActionsBinding((FrameLayout) view, guildChannelSideBarActionsView, privateChannelSideBarActionsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
