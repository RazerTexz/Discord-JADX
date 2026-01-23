package com.discord.api.channel;

import com.discord.api.user.User;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.api.channel.ChannelUtils$getDisplayName$1, reason: use source file name */
/* JADX INFO: compiled from: ChannelUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelUtils2 extends Lambda implements Function1<User, CharSequence> {
    public static final ChannelUtils2 INSTANCE = new ChannelUtils2();

    public ChannelUtils2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(User user) {
        User user2 = user;
        Intrinsics3.checkNotNullParameter(user2, "it");
        return user2.getUsername();
    }
}
