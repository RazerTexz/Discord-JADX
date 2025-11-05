package com.discord.models.botuikit;

import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.ButtonStyle;
import com.discord.api.botuikit.ComponentType;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.z.d.m;

/* compiled from: ButtonMessageComponent.kt */
/* loaded from: classes.dex */
public final class ButtonMessageComponentKt {
    public static final ButtonMessageComponent mergeToMessageComponent(ButtonComponent buttonComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        m.checkNotNullParameter(buttonComponent, "$this$mergeToMessageComponent");
        m.checkNotNullParameter(actionInteractionComponentState, "buttonStateInteraction");
        m.checkNotNullParameter(componentStoreState, "componentStoreState");
        ComponentType type = buttonComponent.getType();
        String customId = buttonComponent.getCustomId();
        String label = buttonComponent.getLabel();
        ButtonStyle style = buttonComponent.getStyle();
        if (buttonComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        } else if (buttonComponent.getUrl() != null) {
            actionInteractionComponentState = ActionInteractionComponentState.Enabled.INSTANCE;
        }
        return new ButtonMessageComponent(type, i, actionInteractionComponentState, customId, label, style, buttonComponent.getEmoji(), buttonComponent.getUrl(), componentStoreState.getAnimateEmojis());
    }
}
