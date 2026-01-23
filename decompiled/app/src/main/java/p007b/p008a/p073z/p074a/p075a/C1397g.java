package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.channel.Channel;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: b.a.z.a.a.g */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1397g implements Func1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f2092j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Channel f2093k;

    public /* synthetic */ C1397g(long j, Channel channel) {
        this.f2092j = j;
        this.f2093k = channel;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        return WidgetChannelSettingsPermissionsAddMember.Model.lambda$null$0(this.f2092j, this.f2093k, (String) obj);
    }
}
