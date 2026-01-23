package com.discord.widgets.servers.role_members;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppComponent;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.recycler.DiffCreator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersAdapter, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers2 extends RecyclerView.Adapter<WidgetServerSettingsRoleMembers3> {
    private final DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, WidgetServerSettingsRoleMembers3> diffCreator;
    private List<ServerSettingsRoleMemberAdapterItem> items;
    private Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener;

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersAdapter$setItems$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95681 extends Lambda implements Function1<List<? extends ServerSettingsRoleMemberAdapterItem>, Unit> {
        public C95681() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsRoleMemberAdapterItem> list) {
            invoke2((List<ServerSettingsRoleMemberAdapterItem>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ServerSettingsRoleMemberAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            WidgetServerSettingsRoleMembers2.access$setItems$p(WidgetServerSettingsRoleMembers2.this, list);
        }
    }

    public /* synthetic */ WidgetServerSettingsRoleMembers2(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2) {
        return widgetServerSettingsRoleMembers2.items;
    }

    public static final /* synthetic */ void access$setItems$p(WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2, List list) {
        widgetServerSettingsRoleMembers2.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetServerSettingsRoleMembers3) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<ServerSettingsRoleMemberAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C95681(), this.items, newItems);
    }

    public final void setRemoveMemberClickListener(Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.removeMemberClickListener = removeMemberClickListener;
    }

    public WidgetServerSettingsRoleMembers2(AppComponent appComponent, DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, WidgetServerSettingsRoleMembers3> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(WidgetServerSettingsRoleMembers3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = this.items.get(position);
        Function2<? super GuildMember, ? super User, Unit> function2 = this.removeMemberClickListener;
        if (function2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("removeMemberClickListener");
        }
        holder.configureUI(serverSettingsRoleMemberAdapterItem, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetServerSettingsRoleMembers3 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingM8389a = RemovablePermissionOwnerViewBinding.m8389a(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics3.checkNotNullExpressionValue(removablePermissionOwnerViewBindingM8389a, "RemovablePermissionOwner…rent,\n        false\n    )");
        return new WidgetServerSettingsRoleMembers3(removablePermissionOwnerViewBindingM8389a);
    }
}
