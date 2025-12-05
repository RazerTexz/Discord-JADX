package p007b.p008a.p073z.p074a.p075a;

import com.discord.api.role.GuildRole;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.u */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1411u implements Function1 {

    /* renamed from: j */
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole f2110j;

    /* renamed from: k */
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole.Model f2111k;

    public /* synthetic */ C1411u(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, WidgetChannelSettingsPermissionsAddRole.Model model) {
        this.f2110j = widgetChannelSettingsPermissionsAddRole;
        this.f2111k = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole = this.f2110j;
        WidgetChannelSettingsPermissionsAddRole.Model model = this.f2111k;
        WidgetChannelSettingsEditPermissions.createForRole(widgetChannelSettingsPermissionsAddRole.getContext(), WidgetChannelSettingsPermissionsAddRole.Model.access$200(model).getGuildId(), WidgetChannelSettingsPermissionsAddRole.Model.access$200(model).getId(), ((GuildRole) obj).getId());
        return Unit.f27425a;
    }
}
