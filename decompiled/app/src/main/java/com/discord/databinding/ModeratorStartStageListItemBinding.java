package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildEventPromptView;

/* loaded from: classes.dex */
public final class ModeratorStartStageListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final GuildEventPromptView f15185a;

    public ModeratorStartStageListItemBinding(@NonNull GuildEventPromptView guildEventPromptView) {
        this.f15185a = guildEventPromptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15185a;
    }
}
