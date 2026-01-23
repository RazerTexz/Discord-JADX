package com.discord.utilities.search.validation;

import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.validation.SearchData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.search.validation.SearchData$Builder$buildForChannel$1, reason: use source file name */
/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchData2 extends Lambda implements Function1<User, Unit> {
    public final /* synthetic */ Map $guildMembers;
    public final /* synthetic */ HashMap $usernameAndDiscriminatorIndex;
    public final /* synthetic */ HashMap $users;
    public final /* synthetic */ SearchData.Builder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchData2(SearchData.Builder builder, HashMap map, Map map2, HashMap map3) {
        super(1);
        this.this$0 = builder;
        this.$users = map;
        this.$guildMembers = map2;
        this.$usernameAndDiscriminatorIndex = map3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "recipient");
        this.$users.put(Long.valueOf(user.getId()), new UserGuildMember(user, (GuildMember) outline.m849f(user, this.$guildMembers)));
        this.$usernameAndDiscriminatorIndex.put(SearchData.Builder.access$getUsernameWithDiscrim(this.this$0, user), Long.valueOf(user.getId()));
    }
}
