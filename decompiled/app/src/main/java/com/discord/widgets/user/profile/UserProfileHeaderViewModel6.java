package com.discord.widgets.user.profile;

import com.discord.models.member.GuildMember;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: UserProfileHeaderViewModel.kt */
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState$Loaded$guildMemberColorId$2, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel6 extends Lambda implements Function0<String> {
    public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel6(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        String avatarHash;
        GuildMember guildMember = this.this$0.getGuildMember();
        return (guildMember == null || (avatarHash = guildMember.getAvatarHash()) == null) ? this.this$0.getAvatarColorId() : avatarHash;
    }
}
