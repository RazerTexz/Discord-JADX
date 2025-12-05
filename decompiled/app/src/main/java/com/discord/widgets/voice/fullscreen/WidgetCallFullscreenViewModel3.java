package com.discord.widgets.voice.fullscreen;

import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetCallFullscreenViewModel.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$ViewState$Valid$menuItems$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel3 extends Lambda implements Function0<Set<? extends WidgetCallFullscreenViewModel.MenuItem>> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel3(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends WidgetCallFullscreenViewModel.MenuItem> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends WidgetCallFullscreenViewModel.MenuItem> invoke2() {
        WidgetCallFullscreenViewModel.ViewState.Valid valid = this.this$0;
        return WidgetCallFullscreenViewModel.ViewState.Valid.access$computeMenuItems(valid, PermissionUtils.can(16L, valid.getCallModel().getChannelPermissions()), this.this$0.getCallModel().isConnected(), ChannelUtils.m7669D(this.this$0.getCallModel().getChannel()), this.this$0.getCallModel().getSelectedVideoDevice(), this.this$0.getCallModel().getVideoDevices(), this.this$0.isTextInVoiceEnabled());
    }
}
