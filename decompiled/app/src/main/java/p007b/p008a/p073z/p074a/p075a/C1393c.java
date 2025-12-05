package p007b.p008a.p073z.p074a.p075a;

import com.discord.models.user.User;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.c */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1393c implements Function1 {

    /* renamed from: j */
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddMember f2085j;

    /* renamed from: k */
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddMember.Model f2086k;

    public /* synthetic */ C1393c(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember, WidgetChannelSettingsPermissionsAddMember.Model model) {
        this.f2085j = widgetChannelSettingsPermissionsAddMember;
        this.f2086k = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember = this.f2085j;
        WidgetChannelSettingsPermissionsAddMember.Model model = this.f2086k;
        WidgetChannelSettingsEditPermissions.createForUser(widgetChannelSettingsPermissionsAddMember.getContext(), WidgetChannelSettingsPermissionsAddMember.Model.access$100(model).getGuildId(), WidgetChannelSettingsPermissionsAddMember.Model.access$100(model).getId(), ((User) obj).getId());
        return Unit.f27425a;
    }
}
