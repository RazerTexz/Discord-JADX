package p007b.p008a.p073z.p074a.p075a;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p658rx.functions.Func2;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.f */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1396f implements Func2 {

    /* renamed from: j */
    public final /* synthetic */ Map f2091j;

    public /* synthetic */ C1396f(Map map) {
        this.f2091j = map;
    }

    @Override // p658rx.functions.Func2
    public final Object call(Object obj, Object obj2) {
        Map map = this.f2091j;
        User user = (User) obj;
        User user2 = (User) obj2;
        return Integer.valueOf(GuildMember.compareUserNames(user, user2, (GuildMember) outline.m849f(user, map), (GuildMember) outline.m849f(user2, map)));
    }
}
