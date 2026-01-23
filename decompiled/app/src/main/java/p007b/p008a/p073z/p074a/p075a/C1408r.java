package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import java.util.List;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: b.a.z.a.a.r */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1408r implements Func4 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Channel f2107a;

    public /* synthetic */ C1408r(Channel channel) {
        this.f2107a = channel;
    }

    @Override // p658rx.functions.Func4
    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return WidgetChannelSettingsPermissionsAddRole.Model.lambda$null$2(this.f2107a, (Guild) obj, (MeUser) obj2, (Long) obj3, (List) obj4);
    }
}
