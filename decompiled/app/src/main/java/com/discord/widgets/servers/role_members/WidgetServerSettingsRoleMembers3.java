package com.discord.widgets.servers.role_members;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers3 extends RecyclerView.ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder$configureUI$1 */
    public static final class ViewOnClickListenerC95691 implements View.OnClickListener {
        public final /* synthetic */ ServerSettingsRoleMemberAdapterItem $adapterItem;
        public final /* synthetic */ Function2 $removeMemberClickListener;

        public ViewOnClickListenerC95691(Function2 function2, ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem) {
            this.$removeMemberClickListener = function2;
            this.$adapterItem = serverSettingsRoleMemberAdapterItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$removeMemberClickListener.invoke(this.$adapterItem.getGuildMember(), this.$adapterItem.getPermissionOwner().getUser());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers3(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.f15225a);
        Intrinsics3.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(ServerSettingsRoleMemberAdapterItem adapterItem, Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f15226b.m8598a(adapterItem.getPermissionOwner());
        this.binding.f15227c.setOnClickListener(new ViewOnClickListenerC95691(removeMemberClickListener, adapterItem));
    }
}
