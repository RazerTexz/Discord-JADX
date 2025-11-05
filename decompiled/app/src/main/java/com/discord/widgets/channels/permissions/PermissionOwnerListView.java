package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionOwnerListView.kt */
/* loaded from: classes2.dex */
public final class PermissionOwnerListView extends RecyclerView {
    private final Adapter adapter;

    /* compiled from: PermissionOwnerListView.kt */
    public static final class Adapter extends RecyclerView.Adapter<PermissionOwnerViewHolder> {
        private Function1<? super PermissionOwner, Unit> onRemoveClicked = PermissionOwnerListView$Adapter$onRemoveClicked$1.INSTANCE;
        private List<Item> data = n.emptyList();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        public final Function1<PermissionOwner, Unit> getOnRemoveClicked() {
            return this.onRemoveClicked;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder((PermissionOwnerViewHolder) viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setData(List<Item> data) {
            m.checkNotNullParameter(data, "data");
            this.data = data;
            notifyDataSetChanged();
        }

        public final void setOnRemoveClicked(Function1<? super PermissionOwner, Unit> function1) {
            m.checkNotNullParameter(function1, "<set-?>");
            this.onRemoveClicked = function1;
        }

        public void onBindViewHolder(PermissionOwnerViewHolder holder, int position) {
            m.checkNotNullParameter(holder, "holder");
            holder.configure(this.data.get(position), new PermissionOwnerListView$Adapter$onBindViewHolder$1(this, this.data.get(position)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PermissionOwnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            m.checkNotNullParameter(parent, "parent");
            RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingA = RemovablePermissionOwnerViewBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
            m.checkNotNullExpressionValue(removablePermissionOwnerViewBindingA, "RemovablePermissionOwner…,\n          false\n      )");
            return new PermissionOwnerViewHolder(removablePermissionOwnerViewBindingA);
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    public static final /* data */ class Item {
        private final PermissionOwner permissionOwner;
        private final RemoveStatus removeStatus;

        public Item(PermissionOwner permissionOwner, RemoveStatus removeStatus) {
            m.checkNotNullParameter(permissionOwner, "permissionOwner");
            m.checkNotNullParameter(removeStatus, "removeStatus");
            this.permissionOwner = permissionOwner;
            this.removeStatus = removeStatus;
        }

        public static /* synthetic */ Item copy$default(Item item, PermissionOwner permissionOwner, RemoveStatus removeStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                permissionOwner = item.permissionOwner;
            }
            if ((i & 2) != 0) {
                removeStatus = item.removeStatus;
            }
            return item.copy(permissionOwner, removeStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final PermissionOwner getPermissionOwner() {
            return this.permissionOwner;
        }

        /* renamed from: component2, reason: from getter */
        public final RemoveStatus getRemoveStatus() {
            return this.removeStatus;
        }

        public final Item copy(PermissionOwner permissionOwner, RemoveStatus removeStatus) {
            m.checkNotNullParameter(permissionOwner, "permissionOwner");
            m.checkNotNullParameter(removeStatus, "removeStatus");
            return new Item(permissionOwner, removeStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return m.areEqual(this.permissionOwner, item.permissionOwner) && m.areEqual(this.removeStatus, item.removeStatus);
        }

        public final PermissionOwner getPermissionOwner() {
            return this.permissionOwner;
        }

        public final RemoveStatus getRemoveStatus() {
            return this.removeStatus;
        }

        public int hashCode() {
            PermissionOwner permissionOwner = this.permissionOwner;
            int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
            RemoveStatus removeStatus = this.removeStatus;
            return iHashCode + (removeStatus != null ? removeStatus.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Item(permissionOwner=");
            sbU.append(this.permissionOwner);
            sbU.append(", removeStatus=");
            sbU.append(this.removeStatus);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    public static final class PermissionOwnerViewHolder extends RecyclerView.ViewHolder {
        private final RemovablePermissionOwnerViewBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                RemoveStatus.CannotRemove.Reason.values();
                int[] iArr = new int[4];
                $EnumSwitchMapping$0 = iArr;
                iArr[RemoveStatus.CannotRemove.Reason.IS_NOT_OVERRIDE.ordinal()] = 1;
                iArr[RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionOwnerViewHolder(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
            super(removablePermissionOwnerViewBinding.a);
            m.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
            this.binding = removablePermissionOwnerViewBinding;
        }

        public static final /* synthetic */ RemovablePermissionOwnerViewBinding access$getBinding$p(PermissionOwnerViewHolder permissionOwnerViewHolder) {
            return permissionOwnerViewHolder.binding;
        }

        public final void configure(Item item, Function0<Unit> onRemoveClicked) {
            m.checkNotNullParameter(item, "item");
            m.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
            this.binding.f2138b.a(item.getPermissionOwner());
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.remove");
            ViewExtensions.setEnabledAlpha$default(imageView, item.getRemoveStatus() instanceof RemoveStatus.CanRemove, 0.0f, 2, null);
            this.binding.c.setOnClickListener(new PermissionOwnerListView$PermissionOwnerViewHolder$configure$1(this, item, onRemoveClicked));
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    public static abstract class RemoveStatus {

        /* compiled from: PermissionOwnerListView.kt */
        public static final class CanRemove extends RemoveStatus {
            public static final CanRemove INSTANCE = new CanRemove();

            private CanRemove() {
                super(null);
            }
        }

        /* compiled from: PermissionOwnerListView.kt */
        public static final /* data */ class CannotRemove extends RemoveStatus {
            private final Reason reason;

            /* compiled from: PermissionOwnerListView.kt */
            public enum Reason {
                IS_GUILD_OWNER,
                IS_ADMINISTRATOR,
                IS_NOT_OVERRIDE,
                HAS_NO_PERMISSION
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CannotRemove(Reason reason) {
                super(null);
                m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
                this.reason = reason;
            }

            public static /* synthetic */ CannotRemove copy$default(CannotRemove cannotRemove, Reason reason, int i, Object obj) {
                if ((i & 1) != 0) {
                    reason = cannotRemove.reason;
                }
                return cannotRemove.copy(reason);
            }

            /* renamed from: component1, reason: from getter */
            public final Reason getReason() {
                return this.reason;
            }

            public final CannotRemove copy(Reason reason) {
                m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
                return new CannotRemove(reason);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CannotRemove) && m.areEqual(this.reason, ((CannotRemove) other).reason);
                }
                return true;
            }

            public final Reason getReason() {
                return this.reason;
            }

            public int hashCode() {
                Reason reason = this.reason;
                if (reason != null) {
                    return reason.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("CannotRemove(reason=");
                sbU.append(this.reason);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: PermissionOwnerListView.kt */
        public static final class IsRemoving extends RemoveStatus {
            public static final IsRemoving INSTANCE = new IsRemoving();

            private IsRemoving() {
                super(null);
            }
        }

        private RemoveStatus() {
        }

        public /* synthetic */ RemoveStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public final void setData(List<Item> permissionOwners, Function1<? super PermissionOwner, Unit> onRemoveClicked) {
        m.checkNotNullParameter(permissionOwners, "permissionOwners");
        m.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
        this.adapter.setOnRemoveClicked(onRemoveClicked);
        this.adapter.setData(permissionOwners);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
