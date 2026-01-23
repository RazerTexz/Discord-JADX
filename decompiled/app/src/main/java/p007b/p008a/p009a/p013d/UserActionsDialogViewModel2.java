package p007b.p008a.p009a.p013d;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import java.util.Map;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: b.a.a.d.c, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialogViewModel2<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ UserActionsDialogViewModel3 f325j;

    public UserActionsDialogViewModel2(UserActionsDialogViewModel3 userActionsDialogViewModel3, Channel channel) {
        this.f325j = userActionsDialogViewModel3;
    }

    @Override // p637j0.p641k.Func1
    public GuildMember call(Map<Long, ? extends GuildMember> map) {
        return map.get(Long.valueOf(this.f325j.f327k));
    }
}
