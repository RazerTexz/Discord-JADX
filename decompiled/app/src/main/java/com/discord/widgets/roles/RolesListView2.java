package com.discord.widgets.roles;

import android.content.Context;
import android.view.View;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.role.GuildRole;
import d0.z.d.Intrinsics3;

/* compiled from: RolesListView.kt */
/* renamed from: com.discord.widgets.roles.RolesListView$updateView$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RolesListView2 implements View.OnClickListener {
    public final /* synthetic */ boolean $developerModeEnabled$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ int $roleDefaultColor$inlined;
    public final /* synthetic */ RolesListView this$0;

    public RolesListView2(GuildRole guildRole, RolesListView rolesListView, int i, long j, boolean z2) {
        this.$role = guildRole;
        this.this$0 = rolesListView;
        this.$roleDefaultColor$inlined = i;
        this.$guildId$inlined = j;
        this.$developerModeEnabled$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AppToast.b(context, String.valueOf(this.$role.getId()), FormatUtils.j(this.this$0, R.string.role_id_copied, new Object[]{this.$role.getName()}, null, 4));
    }
}
