package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildInvitePageBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInvite2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildInvitePageBinding> {
    public static final WidgetGuildInvite2 INSTANCE = new WidgetGuildInvite2();

    public WidgetGuildInvite2() {
        super(1, WidgetGuildInvitePageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInvitePageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInvitePageBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInvitePageBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_invite_actions;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_invite_actions);
        if (linearLayout != null) {
            i = C5419R.id.guild_invite_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_invite_cancel);
            if (materialButton != null) {
                i = C5419R.id.guild_invite_event_info;
                GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(C5419R.id.guild_invite_event_info);
                if (guildScheduledEventItemView != null) {
                    i = C5419R.id.guild_invite_info;
                    WidgetInviteInfo widgetInviteInfo = (WidgetInviteInfo) view.findViewById(C5419R.id.guild_invite_info);
                    if (widgetInviteInfo != null) {
                        i = C5419R.id.scroll_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.scroll_view);
                        if (nestedScrollView != null) {
                            i = C5419R.id.toolbar;
                            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.toolbar);
                            if (appBarLayout != null) {
                                return new WidgetGuildInvitePageBinding((ConstraintLayout) view, linearLayout, materialButton, guildScheduledEventItemView, widgetInviteInfo, nestedScrollView, appBarLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
