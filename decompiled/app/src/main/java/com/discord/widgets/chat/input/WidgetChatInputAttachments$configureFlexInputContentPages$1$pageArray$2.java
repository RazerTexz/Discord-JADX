package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.AddContentPagerAdapter4;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;

/* compiled from: WidgetChatInputAttachments.kt */
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2 extends AddContentPagerAdapter4.a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public WidgetChatInputAttachments.DiscordFilesFragment createFragment() {
        return new WidgetChatInputAttachments.DiscordFilesFragment();
    }
}
