package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInviteBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final GuildScheduledEventItemView f16226a;

    /* renamed from: b */
    @NonNull
    public final GuildScheduledEventItemView f16227b;

    public WidgetChatListAdapterItemGuildScheduledEventInviteBinding(@NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull GuildScheduledEventItemView guildScheduledEventItemView2) {
        this.f16226a = guildScheduledEventItemView;
        this.f16227b = guildScheduledEventItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16226a;
    }
}
