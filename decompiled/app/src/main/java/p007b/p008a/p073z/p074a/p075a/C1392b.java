package p007b.p008a.p073z.p074a.p075a;

import com.discord.stores.StoreStream;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.z.a.a.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1392b implements Action1 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f2084j;

    public /* synthetic */ C1392b(long j) {
        this.f2084j = j;
    }

    @Override // p658rx.functions.Action1
    public final void call(Object obj) {
        int i = WidgetChannelSettingsPermissionsAddMember.f19372j;
        StoreStream.getGatewaySocket().requestGuildMembers(this.f2084j, (String) obj);
    }
}
