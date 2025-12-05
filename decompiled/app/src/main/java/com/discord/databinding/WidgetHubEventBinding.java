package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* loaded from: classes.dex */
public final class WidgetHubEventBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final GuildScheduledEventItemView f17179a;

    /* renamed from: b */
    @NonNull
    public final GuildScheduledEventItemView f17180b;

    public WidgetHubEventBinding(@NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull GuildScheduledEventItemView guildScheduledEventItemView2) {
        this.f17179a = guildScheduledEventItemView;
        this.f17180b = guildScheduledEventItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17179a;
    }
}
