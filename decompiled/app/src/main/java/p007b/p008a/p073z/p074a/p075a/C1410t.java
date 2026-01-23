package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: b.a.z.a.a.t */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1410t implements Func1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Channel f2109j;

    public /* synthetic */ C1410t(Channel channel) {
        this.f2109j = channel;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        Channel channel = this.f2109j;
        GuildRole guildRole = (GuildRole) obj;
        if (channel.m7655v() == null) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < channel.m7655v().size(); i++) {
            if (channel.m7655v().get(i).m8131e() == guildRole.getId()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
