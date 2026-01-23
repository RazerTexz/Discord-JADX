package p007b.p008a.p009a.p013d;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import p007b.p008a.p009a.p013d.UserActionsDialogViewModel5;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: b.a.a.d.e, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel4<T1, T2, T3, R> implements Func3<User, Integer, GuildMember, UserActionsDialogViewModel5.c> {

    /* JADX INFO: renamed from: a */
    public static final UserActionsDialogViewModel4 f328a = new UserActionsDialogViewModel4();

    @Override // p658rx.functions.Func3
    public UserActionsDialogViewModel5.c call(User user, Integer num, GuildMember guildMember) {
        return new UserActionsDialogViewModel5.c(user, num, guildMember);
    }
}
