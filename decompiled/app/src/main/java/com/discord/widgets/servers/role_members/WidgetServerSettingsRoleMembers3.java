package com.discord.widgets.servers.role_members;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers3 extends RecyclerView.ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ServerSettingsRoleMemberAdapterItem $adapterItem;
        public final /* synthetic */ Function2 $removeMemberClickListener;

        public AnonymousClass1(Function2 function2, ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem) {
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
        super(removablePermissionOwnerViewBinding.a);
        Intrinsics3.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(ServerSettingsRoleMemberAdapterItem adapterItem, Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f2138b.a(adapterItem.getPermissionOwner());
        this.binding.c.setOnClickListener(new AnonymousClass1(removeMemberClickListener, adapterItem));
    }
}
