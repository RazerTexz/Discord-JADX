package p007b.p008a.p073z.p074a.p075a;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.channels.SimpleMembersAdapter;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p637j0.p641k.Func1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.d */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1394d implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ Map f2087j;

    public /* synthetic */ C1394d(Map map) {
        this.f2087j = map;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        User user = (User) obj;
        return new SimpleMembersAdapter.MemberItem(user, (GuildMember) outline.m849f(user, this.f2087j));
    }
}
