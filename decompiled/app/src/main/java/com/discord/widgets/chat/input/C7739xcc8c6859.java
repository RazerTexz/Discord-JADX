package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2 */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7739xcc8c6859 extends AddContentPagerAdapter4.a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7739xcc8c6859(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public WidgetChatInputAttachments.DiscordFilesFragment createFragment() {
        return new WidgetChatInputAttachments.DiscordFilesFragment();
    }
}
