package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lytefast.flexinput.fragment.CameraFragment;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;

/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3 */
/* loaded from: classes2.dex */
public final class C7740xcc8c685a extends AddContentPagerAdapter4.a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7740xcc8c685a(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public CameraFragment createFragment() {
        return new CameraFragment();
    }
}
