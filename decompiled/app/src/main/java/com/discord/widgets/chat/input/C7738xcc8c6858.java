package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;

/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1 */
/* loaded from: classes2.dex */
public final class C7738xcc8c6858 extends AddContentPagerAdapter4.a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7738xcc8c6858(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public WidgetChatInputAttachments.DiscordMediaFragment createFragment() {
        return new WidgetChatInputAttachments.DiscordMediaFragment();
    }
}
