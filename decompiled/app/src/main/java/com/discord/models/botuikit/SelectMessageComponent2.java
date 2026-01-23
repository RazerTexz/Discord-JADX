package com.discord.models.botuikit;

import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.SelectComponent;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.widgets.botuikit.ComponentChatListState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.botuikit.SelectMessageComponentKt, reason: use source file name */
/* JADX INFO: compiled from: SelectMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectMessageComponent2 {
    public static final SelectMessageComponent mergeToMessageComponent(SelectComponent selectComponent, int i, ActionInteractionComponentState actionInteractionComponentState, ComponentChatListState.ComponentStoreState componentStoreState) {
        Intrinsics3.checkNotNullParameter(selectComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(actionInteractionComponentState, "actionInteractionComponentState");
        Intrinsics3.checkNotNullParameter(componentStoreState, "componentStoreState");
        Map<Integer, List<SelectComponent2>> selections = componentStoreState.getSelections();
        List arrayList = selections != null ? selections.get(Integer.valueOf(i)) : null;
        Component6 type = selectComponent.getType();
        String customId = selectComponent.getCustomId();
        String placeholder = selectComponent.getPlaceholder();
        int minValues = selectComponent.getMinValues();
        int maxValues = selectComponent.getMaxValues();
        List<SelectComponent2> listM7609e = selectComponent.m7609e();
        if (selectComponent.getDisabled()) {
            actionInteractionComponentState = ActionInteractionComponentState.Disabled.INSTANCE;
        }
        ActionInteractionComponentState actionInteractionComponentState2 = actionInteractionComponentState;
        if (arrayList == null) {
            List<SelectComponent2> listM7609e2 = selectComponent.m7609e();
            arrayList = new ArrayList();
            for (Object obj : listM7609e2) {
                if (((SelectComponent2) obj).getDefault()) {
                    arrayList.add(obj);
                }
            }
        }
        return new SelectMessageComponent(type, i, actionInteractionComponentState2, customId, placeholder, minValues, maxValues, listM7609e, arrayList, componentStoreState.getAnimateEmojis());
    }
}
