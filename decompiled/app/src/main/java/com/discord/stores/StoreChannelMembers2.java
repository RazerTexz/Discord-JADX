package com.discord.stores;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreChannelMembers.kt */
/* renamed from: com.discord.stores.StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreChannelMembers2 extends Lambda implements Function1<ModelGuildMemberListUpdate.Group, CharSequence> {
    public static final StoreChannelMembers2 INSTANCE = new StoreChannelMembers2();

    public StoreChannelMembers2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ModelGuildMemberListUpdate.Group group) {
        return invoke2(group);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ModelGuildMemberListUpdate.Group group) {
        Intrinsics3.checkNotNullParameter(group, "it");
        return String.valueOf(group.getCount());
    }
}
