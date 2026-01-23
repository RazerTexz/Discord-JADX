package com.discord.models.botuikit;

import com.discord.api.botuikit.ActionRowComponent;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.botuikit.ActionRowMessageComponentKt, reason: use source file name */
/* JADX INFO: compiled from: ActionRowMessageComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionRowMessageComponent2 {
    public static final ActionRowMessageComponent mergeToMessageComponent(ActionRowComponent actionRowComponent, int i, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(actionRowComponent, "$this$mergeToMessageComponent");
        Intrinsics3.checkNotNullParameter(list, "children");
        return new ActionRowMessageComponent(actionRowComponent.getType(), i, list);
    }
}
