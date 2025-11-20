package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.databinding.WidgetChannelSettingsAddMemberCategoryBinding;
import com.discord.databinding.WidgetChannelSettingsAddMemberItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.permissions.ChannelPermissionOwnerView;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AddMemberAdapter.kt */
/* loaded from: classes2.dex */
public final class AddMemberAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener;

    /* compiled from: AddMemberAdapter.kt */
    public static final class AddMemberAdapterCategoryItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberCategoryBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.CategoryItem.Companion.CategoryType.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.CategoryItem.Companion.CategoryType.ROLE.ordinal()] = 1;
                iArr[Item.CategoryItem.Companion.CategoryType.MEMBER.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterCategoryItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_category, addMemberAdapter);
            m.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.label);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.label)));
            }
            WidgetChannelSettingsAddMemberCategoryBinding widgetChannelSettingsAddMemberCategoryBinding = new WidgetChannelSettingsAddMemberCategoryBinding((LinearLayout) view, textView);
            m.checkNotNullExpressionValue(widgetChannelSettingsAddMemberCategoryBinding, "WidgetChannelSettingsAdd…oryBinding.bind(itemView)");
            this.binding = widgetChannelSettingsAddMemberCategoryBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            String string;
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2270b;
            m.checkNotNullExpressionValue(textView, "binding.label");
            int iOrdinal = ((Item.CategoryItem) data).getCategoryType().ordinal();
            if (iOrdinal == 0) {
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.roles);
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.members);
            }
            textView.setText(string);
        }
    }

    /* compiled from: AddMemberAdapter.kt */
    public static final class AddMemberAdapterItemItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberItemBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.values();
                int[] iArr = new int[1];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS.ordinal()] = 1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterItemItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_item, addMemberAdapter);
            m.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.channel_permission_owner_view;
            ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) view.findViewById(R.id.channel_permission_owner_view);
            if (channelPermissionOwnerView != null) {
                i = R.id.checkbox;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.checkbox);
                if (materialCheckBox != null) {
                    i = R.id.container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container);
                    if (constraintLayout != null) {
                        WidgetChannelSettingsAddMemberItemBinding widgetChannelSettingsAddMemberItemBinding = new WidgetChannelSettingsAddMemberItemBinding((FrameLayout) view, channelPermissionOwnerView, materialCheckBox, constraintLayout);
                        m.checkNotNullExpressionValue(widgetChannelSettingsAddMemberItemBinding, "WidgetChannelSettingsAdd…temBinding.bind(itemView)");
                        this.binding = widgetChannelSettingsAddMemberItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ void access$handleClick(AddMemberAdapterItemItem addMemberAdapterItemItem, Item.PermissionOwnerItem permissionOwnerItem) {
            addMemberAdapterItemItem.handleClick(permissionOwnerItem);
        }

        private final void handleClick(Item.PermissionOwnerItem item) {
            PermissionOwner permissionOwner = item.getPermissionOwner();
            Item.PermissionOwnerItem.Companion.AddStatus addStatus = item.getAddStatus();
            if (m.areEqual(addStatus, Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE)) {
                handleOnClickForPermissionOwner(permissionOwner);
            } else if ((addStatus instanceof Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) && ((Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) item.getAddStatus()).getReason().ordinal() == 0) {
                FrameLayout frameLayout = this.binding.a;
                m.checkNotNullExpressionValue(frameLayout, "binding.root");
                Toast.makeText(frameLayout.getContext(), R.string.channel_permissions_add_has_guild_permissions, 0).show();
            }
        }

        private final void handleOnClickForPermissionOwner(PermissionOwner permissionOwner) {
            Function2 function2Access$getOnClickListener$p = AddMemberAdapter.access$getOnClickListener$p((AddMemberAdapter) this.adapter);
            if (function2Access$getOnClickListener$p != null) {
                if (permissionOwner instanceof PermissionOwner.Member) {
                    function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId()), PermissionOverwrite.Type.MEMBER);
                } else if (permissionOwner instanceof PermissionOwner.Role) {
                    function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId()), PermissionOverwrite.Type.ROLE);
                }
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            Item.PermissionOwnerItem permissionOwnerItem = (Item.PermissionOwnerItem) data;
            this.binding.f2271b.a(permissionOwnerItem.getPermissionOwner());
            MaterialCheckBox materialCheckBox = this.binding.c;
            m.checkNotNullExpressionValue(materialCheckBox, "binding.checkbox");
            materialCheckBox.setChecked(permissionOwnerItem.getChecked());
            this.binding.c.setOnClickListener(new AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1(this, permissionOwnerItem));
            this.binding.d.setOnClickListener(new AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$2(this, permissionOwnerItem));
            ConstraintLayout constraintLayout = this.binding.d;
            m.checkNotNullExpressionValue(constraintLayout, "binding.container");
            ViewExtensions.setEnabledAlpha$default(constraintLayout, m.areEqual(permissionOwnerItem.getAddStatus(), Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE), 0.0f, 2, null);
        }
    }

    /* compiled from: AddMemberAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CATEGORY = 0;
        public static final int TYPE_PERMISSION_OWNER = 1;

        /* compiled from: AddMemberAdapter.kt */
        public static final /* data */ class CategoryItem extends Item {
            private final Companion.CategoryType categoryType;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CategoryItem(Companion.CategoryType categoryType) {
                super(null);
                m.checkNotNullParameter(categoryType, "categoryType");
                this.categoryType = categoryType;
                this.key = categoryType.toString();
            }

            public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, Companion.CategoryType categoryType, int i, Object obj) {
                if ((i & 1) != 0) {
                    categoryType = categoryItem.categoryType;
                }
                return categoryItem.copy(categoryType);
            }

            /* renamed from: component1, reason: from getter */
            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
            }

            public final CategoryItem copy(Companion.CategoryType categoryType) {
                m.checkNotNullParameter(categoryType, "categoryType");
                return new CategoryItem(categoryType);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CategoryItem) && m.areEqual(this.categoryType, ((CategoryItem) other).categoryType);
                }
                return true;
            }

            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                Companion.CategoryType categoryType = this.categoryType;
                if (categoryType != null) {
                    return categoryType.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("CategoryItem(categoryType=");
                sbU.append(this.categoryType);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: AddMemberAdapter.kt */
        public static final /* data */ class PermissionOwnerItem extends Item {
            private final Companion.AddStatus addStatus;
            private final boolean checked;
            private final String key;
            private final PermissionOwner permissionOwner;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionOwnerItem(PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus) {
                String strValueOf;
                super(null);
                m.checkNotNullParameter(permissionOwner, "permissionOwner");
                m.checkNotNullParameter(addStatus, "addStatus");
                this.permissionOwner = permissionOwner;
                this.checked = z2;
                this.addStatus = addStatus;
                this.type = 1;
                if (permissionOwner instanceof PermissionOwner.Member) {
                    strValueOf = String.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId());
                } else {
                    if (!(permissionOwner instanceof PermissionOwner.Role)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strValueOf = String.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId());
                }
                this.key = strValueOf;
            }

            public static /* synthetic */ PermissionOwnerItem copy$default(PermissionOwnerItem permissionOwnerItem, PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    permissionOwner = permissionOwnerItem.permissionOwner;
                }
                if ((i & 2) != 0) {
                    z2 = permissionOwnerItem.checked;
                }
                if ((i & 4) != 0) {
                    addStatus = permissionOwnerItem.addStatus;
                }
                return permissionOwnerItem.copy(permissionOwner, z2, addStatus);
            }

            /* renamed from: component1, reason: from getter */
            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getChecked() {
                return this.checked;
            }

            /* renamed from: component3, reason: from getter */
            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final PermissionOwnerItem copy(PermissionOwner permissionOwner, boolean checked, Companion.AddStatus addStatus) {
                m.checkNotNullParameter(permissionOwner, "permissionOwner");
                m.checkNotNullParameter(addStatus, "addStatus");
                return new PermissionOwnerItem(permissionOwner, checked, addStatus);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionOwnerItem)) {
                    return false;
                }
                PermissionOwnerItem permissionOwnerItem = (PermissionOwnerItem) other;
                return m.areEqual(this.permissionOwner, permissionOwnerItem.permissionOwner) && this.checked == permissionOwnerItem.checked && m.areEqual(this.addStatus, permissionOwnerItem.addStatus);
            }

            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final boolean getChecked() {
                return this.checked;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                PermissionOwner permissionOwner = this.permissionOwner;
                int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
                boolean z2 = this.checked;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Companion.AddStatus addStatus = this.addStatus;
                return i2 + (addStatus != null ? addStatus.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("PermissionOwnerItem(permissionOwner=");
                sbU.append(this.permissionOwner);
                sbU.append(", checked=");
                sbU.append(this.checked);
                sbU.append(", addStatus=");
                sbU.append(this.addStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public static final /* synthetic */ Function2 access$getOnClickListener$p(AddMemberAdapter addMemberAdapter) {
        return addMemberAdapter.onClickListener;
    }

    public static final /* synthetic */ void access$setOnClickListener$p(AddMemberAdapter addMemberAdapter, Function2 function2) {
        addMemberAdapter.onClickListener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<AddMemberAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AddMemberAdapterCategoryItem(this);
        }
        if (viewType == 1) {
            return new AddMemberAdapterItemItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
