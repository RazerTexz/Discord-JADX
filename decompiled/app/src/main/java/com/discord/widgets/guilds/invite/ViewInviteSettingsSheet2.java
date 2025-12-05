package com.discord.widgets.guilds.invite;

import androidx.annotation.IdRes;
import com.discord.C5419R;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ViewInviteSettingsSheet.kt */
/* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$ChannelsSpinnerAdapter$setupViews$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ boolean $dropDownMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet2(boolean z2) {
        super(0);
        this.$dropDownMode = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    @IdRes
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.$dropDownMode ? C5419R.id.channel_spinner_dropdown_item_textview : C5419R.id.channel_spinner_item_textview;
    }
}
