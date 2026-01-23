package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class EmojiPickerViewModel$handleStoreState$frequentItems$1 extends FunctionReferenceImpl implements Function1<Long, Guild> {
    public EmojiPickerViewModel$handleStoreState$frequentItems$1(LinkedHashMap linkedHashMap) {
        super(1, linkedHashMap, LinkedHashMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke2(l);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Guild invoke2(Long l) {
        Intrinsics3.checkNotNullParameter(l, "p1");
        return (Guild) ((LinkedHashMap) this.receiver).get(l);
    }
}
