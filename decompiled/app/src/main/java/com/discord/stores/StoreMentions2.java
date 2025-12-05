package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreMentions.kt */
/* renamed from: com.discord.stores.StoreMentions$processMarkUnread$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMentions2 extends Lambda implements Function1<ModelReadState, Boolean> {
    public final /* synthetic */ long $channelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions2(long j) {
        super(1);
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
        return Boolean.valueOf(invoke2(modelReadState));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelReadState modelReadState) {
        Intrinsics3.checkNotNullParameter(modelReadState, "it");
        return modelReadState.getChannelId() == this.$channelId;
    }
}
