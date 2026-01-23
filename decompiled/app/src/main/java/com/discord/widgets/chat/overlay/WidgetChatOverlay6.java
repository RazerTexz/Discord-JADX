package com.discord.widgets.chat.overlay;

import com.discord.widgets.chat.input.ChatInputViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$chatInputViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay6 extends Lambda implements Function0<ChatInputViewModel> {
    public static final WidgetChatOverlay6 INSTANCE = new WidgetChatOverlay6();

    public WidgetChatOverlay6() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChatInputViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChatInputViewModel invoke() {
        return new ChatInputViewModel(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }
}
