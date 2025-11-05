package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiPickerViewModel.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class EmojiPickerViewModel$handleStoreState$favoriteItems$1 extends FunctionReferenceImpl implements Function1<Long, Guild> {
    public EmojiPickerViewModel$handleStoreState$favoriteItems$1(LinkedHashMap linkedHashMap) {
        super(1, linkedHashMap, LinkedHashMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke2(l);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Guild invoke2(Long l) {
        Intrinsics3.checkNotNullParameter(l, "p1");
        return (Guild) ((LinkedHashMap) this.receiver).get(l);
    }
}
