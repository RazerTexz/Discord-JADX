package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryChannel.kt */
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel6 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel6(Guild guild, WidgetDirectoryChannel widgetDirectoryChannel) {
        this.$guild = guild;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context contextM885x = outline.m885x(view, "it", "it.context");
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WidgetGuildInviteShare.Companion.launch$default(companion, contextM885x, childFragmentManager, this.$guild.getId(), null, false, null, null, "Guild Header", 120, null);
    }
}
