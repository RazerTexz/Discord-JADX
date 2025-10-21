package com.discord.widgets.guilds.list;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import com.discord.widgets.guilds.list.GuildsDragAndDropCallback;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildListAdapter extends RecyclerView.Adapter<GuildListViewHolder> implements GuildsDragAndDropCallback.Controller {
    private static final float NEAR_CENTER_PERCENTAGE = 0.2f;
    private int bottomNavHeight;
    private final Rect boundingBoxRect;
    private GuildListViewHolder draggingItem;
    private final InteractionListener interactionListener;
    private List<? extends GuildListItem> items;
    private final LinearLayoutManager layoutManager;
    private int selectedCenterY;
    private int targetCenterY;

    /* compiled from: WidgetGuildListAdapter.kt */
    public interface InteractionListener {
        boolean onDrop();

        void onItemClicked(View view, GuildListItem item);

        void onItemLongPressed(View view, GuildListItem item);

        void onItemMoved();

        void onOperation(Operation operation);
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    public static abstract class Operation {

        /* compiled from: WidgetGuildListAdapter.kt */
        public static final /* data */ class MoveAbove extends Operation {
            private final int fromPosition;
            private final int targetPosition;

            public MoveAbove(int i, int i2) {
                super(null);
                this.fromPosition = i;
                this.targetPosition = i2;
            }

            public static /* synthetic */ MoveAbove copy$default(MoveAbove moveAbove, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = moveAbove.fromPosition;
                }
                if ((i3 & 2) != 0) {
                    i2 = moveAbove.targetPosition;
                }
                return moveAbove.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFromPosition() {
                return this.fromPosition;
            }

            /* renamed from: component2, reason: from getter */
            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public final MoveAbove copy(int fromPosition, int targetPosition) {
                return new MoveAbove(fromPosition, targetPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoveAbove)) {
                    return false;
                }
                MoveAbove moveAbove = (MoveAbove) other;
                return this.fromPosition == moveAbove.fromPosition && this.targetPosition == moveAbove.targetPosition;
            }

            public final int getFromPosition() {
                return this.fromPosition;
            }

            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public int hashCode() {
                return (this.fromPosition * 31) + this.targetPosition;
            }

            public String toString() {
                StringBuilder sbU = outline.U("MoveAbove(fromPosition=");
                sbU.append(this.fromPosition);
                sbU.append(", targetPosition=");
                return outline.B(sbU, this.targetPosition, ")");
            }
        }

        /* compiled from: WidgetGuildListAdapter.kt */
        public static final /* data */ class MoveBelow extends Operation {
            private final int fromPosition;
            private final int targetPosition;

            public MoveBelow(int i, int i2) {
                super(null);
                this.fromPosition = i;
                this.targetPosition = i2;
            }

            public static /* synthetic */ MoveBelow copy$default(MoveBelow moveBelow, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = moveBelow.fromPosition;
                }
                if ((i3 & 2) != 0) {
                    i2 = moveBelow.targetPosition;
                }
                return moveBelow.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFromPosition() {
                return this.fromPosition;
            }

            /* renamed from: component2, reason: from getter */
            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public final MoveBelow copy(int fromPosition, int targetPosition) {
                return new MoveBelow(fromPosition, targetPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MoveBelow)) {
                    return false;
                }
                MoveBelow moveBelow = (MoveBelow) other;
                return this.fromPosition == moveBelow.fromPosition && this.targetPosition == moveBelow.targetPosition;
            }

            public final int getFromPosition() {
                return this.fromPosition;
            }

            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public int hashCode() {
                return (this.fromPosition * 31) + this.targetPosition;
            }

            public String toString() {
                StringBuilder sbU = outline.U("MoveBelow(fromPosition=");
                sbU.append(this.fromPosition);
                sbU.append(", targetPosition=");
                return outline.B(sbU, this.targetPosition, ")");
            }
        }

        /* compiled from: WidgetGuildListAdapter.kt */
        public static final /* data */ class TargetOperation extends Operation {
            private final int fromPosition;
            private final int targetPosition;

            public TargetOperation(int i, int i2) {
                super(null);
                this.fromPosition = i;
                this.targetPosition = i2;
            }

            public static /* synthetic */ TargetOperation copy$default(TargetOperation targetOperation, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = targetOperation.fromPosition;
                }
                if ((i3 & 2) != 0) {
                    i2 = targetOperation.targetPosition;
                }
                return targetOperation.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFromPosition() {
                return this.fromPosition;
            }

            /* renamed from: component2, reason: from getter */
            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public final TargetOperation copy(int fromPosition, int targetPosition) {
                return new TargetOperation(fromPosition, targetPosition);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TargetOperation)) {
                    return false;
                }
                TargetOperation targetOperation = (TargetOperation) other;
                return this.fromPosition == targetOperation.fromPosition && this.targetPosition == targetOperation.targetPosition;
            }

            public final int getFromPosition() {
                return this.fromPosition;
            }

            public final int getTargetPosition() {
                return this.targetPosition;
            }

            public int hashCode() {
                return (this.fromPosition * 31) + this.targetPosition;
            }

            public String toString() {
                StringBuilder sbU = outline.U("TargetOperation(fromPosition=");
                sbU.append(this.fromPosition);
                sbU.append(", targetPosition=");
                return outline.B(sbU, this.targetPosition, ")");
            }
        }

        private Operation() {
        }

        public /* synthetic */ Operation(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    public enum TargetPosition {
        TOP,
        CENTER,
        BOTTOM
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TargetPosition.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[TargetPosition.TOP.ordinal()] = 1;
            iArr[TargetPosition.CENTER.ordinal()] = 2;
            iArr[TargetPosition.BOTTOM.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$createDiffUtilCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DiffUtil.Callback {
        public final /* synthetic */ List $newItems;
        public final /* synthetic */ List $oldItems;

        public AnonymousClass1(List list, List list2) {
            this.$oldItems = list;
            this.$newItems = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual((GuildListItem) this.$oldItems.get(oldItemPosition), (GuildListItem) this.$newItems.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return ((GuildListItem) this.$oldItems.get(oldItemPosition)).getItemId() == ((GuildListItem) this.$newItems.get(newItemPosition)).getItemId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.$oldItems.size();
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onBindViewHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildListViewHolder $holder;
        public final /* synthetic */ GuildListItem $item;

        public AnonymousClass1(GuildListViewHolder guildListViewHolder, GuildListItem guildListItem) {
            this.$holder = guildListViewHolder;
            this.$item = guildListItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view2 = this.$holder.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "holder.itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view2, this.$item);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onBindViewHolder$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildListViewHolder $holder;
        public final /* synthetic */ GuildListItem $item;

        public AnonymousClass2(GuildListViewHolder guildListViewHolder, GuildListItem guildListItem) {
            this.$holder = guildListViewHolder;
            this.$item = guildListItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view2 = this.$holder.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "holder.itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view2, this.$item);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, View> {
        public final /* synthetic */ ViewGroup $parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewGroup viewGroup) {
            super(1);
            this.$parent = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ View invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final View invoke(int i) {
            return LayoutInflater.from(this.$parent.getContext()).inflate(i, this.$parent, false);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildListItem.GuildItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.GuildItem guildItem) {
            invoke2(guildItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.GuildItem guildItem) {
            Intrinsics3.checkNotNullParameter(guildItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view, guildItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildListItem.GuildItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.GuildItem guildItem) {
            invoke2(guildItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.GuildItem guildItem) {
            Intrinsics3.checkNotNullParameter(guildItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemLongPressed(view, guildItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<GuildListItem.FolderItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.FolderItem folderItem) {
            invoke2(folderItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.FolderItem folderItem) {
            Intrinsics3.checkNotNullParameter(folderItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view, folderItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<GuildListItem.FolderItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.FolderItem folderItem) {
            invoke2(folderItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.FolderItem folderItem) {
            Intrinsics3.checkNotNullParameter(folderItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemLongPressed(view, folderItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<GuildListItem.PrivateChannelItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.PrivateChannelItem privateChannelItem) {
            invoke2(privateChannelItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.PrivateChannelItem privateChannelItem) {
            Intrinsics3.checkNotNullParameter(privateChannelItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view, privateChannelItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<GuildListItem.PrivateChannelItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.PrivateChannelItem privateChannelItem) {
            invoke2(privateChannelItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.PrivateChannelItem privateChannelItem) {
            Intrinsics3.checkNotNullParameter(privateChannelItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemLongPressed(view, privateChannelItem);
        }
    }

    /* compiled from: WidgetGuildListAdapter.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildListAdapter$onCreateViewHolder$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function1<GuildListItem.FriendsItem, Unit> {
        public final /* synthetic */ View $itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(View view) {
            super(1);
            this.$itemView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildListItem.FriendsItem friendsItem) {
            invoke2(friendsItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildListItem.FriendsItem friendsItem) {
            Intrinsics3.checkNotNullParameter(friendsItem, "item");
            InteractionListener interactionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(WidgetGuildListAdapter.this);
            View view = this.$itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            interactionListenerAccess$getInteractionListener$p.onItemClicked(view, friendsItem);
        }
    }

    public WidgetGuildListAdapter(LinearLayoutManager linearLayoutManager, InteractionListener interactionListener) {
        Intrinsics3.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics3.checkNotNullParameter(interactionListener, "interactionListener");
        this.layoutManager = linearLayoutManager;
        this.interactionListener = interactionListener;
        this.items = Collections2.emptyList();
        this.boundingBoxRect = new Rect();
    }

    public static final /* synthetic */ InteractionListener access$getInteractionListener$p(WidgetGuildListAdapter widgetGuildListAdapter) {
        return widgetGuildListAdapter.interactionListener;
    }

    private final AnonymousClass1 createDiffUtilCallback(List<? extends GuildListItem> oldItems, List<? extends GuildListItem> newItems) {
        return new AnonymousClass1(oldItems, newItems);
    }

    private final boolean isPendingGuildOperation(GuildListItem sourceItem, GuildListItem targetItem) {
        return ((sourceItem instanceof GuildListItem.GuildItem) && ((GuildListItem.GuildItem) sourceItem).isPendingGuild()) || ((sourceItem instanceof GuildListItem.FolderItem) && ((GuildListItem.FolderItem) sourceItem).getIsPendingGuildsFolder()) || (((targetItem instanceof GuildListItem.GuildItem) && ((GuildListItem.GuildItem) targetItem).isPendingGuild()) || ((targetItem instanceof GuildListItem.FolderItem) && ((GuildListItem.FolderItem) targetItem).getIsPendingGuildsFolder()));
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.Controller
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
        Intrinsics3.checkNotNullParameter(selected, "selected");
        Intrinsics3.checkNotNullParameter(dropTargets, "dropTargets");
        this.layoutManager.getTransformedBoundingBox(selected.itemView, false, this.boundingBoxRect);
        this.selectedCenterY = this.boundingBoxRect.centerY();
        int i = Integer.MAX_VALUE;
        RecyclerView.ViewHolder viewHolder = null;
        for (RecyclerView.ViewHolder viewHolder2 : dropTargets) {
            this.layoutManager.getTransformedBoundingBox(viewHolder2.itemView, false, this.boundingBoxRect);
            int iCenterY = this.boundingBoxRect.centerY();
            int iAbs = Math.abs(this.selectedCenterY - iCenterY);
            if (iAbs < i) {
                this.targetCenterY = iCenterY;
                viewHolder = viewHolder2;
                i = iAbs;
            }
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getItemId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        GuildListItem guildListItem = this.items.get(position);
        if (guildListItem instanceof GuildListItem.GuildItem) {
            return 3;
        }
        if (guildListItem instanceof GuildListItem.PrivateChannelItem) {
            return 2;
        }
        if (guildListItem instanceof GuildListItem.UnavailableItem) {
            return 4;
        }
        if (guildListItem instanceof GuildListItem.FriendsItem) {
            return 0;
        }
        if (Intrinsics3.areEqual(guildListItem, GuildListItem.DividerItem.INSTANCE)) {
            return 1;
        }
        if (Intrinsics3.areEqual(guildListItem, GuildListItem.CreateItem.INSTANCE)) {
            return 5;
        }
        if (guildListItem instanceof GuildListItem.HubItem) {
            return 9;
        }
        if (Intrinsics3.areEqual(guildListItem, GuildListItem.HelpItem.INSTANCE)) {
            return 7;
        }
        if (guildListItem instanceof GuildListItem.FolderItem) {
            return 6;
        }
        if (Intrinsics3.areEqual(guildListItem, GuildListItem.SpaceItem.INSTANCE)) {
            return 8;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void handleBottomNavHeight(int height) {
        this.bottomNavHeight = height;
        notifyItemChanged(this.items.lastIndexOf(GuildListItem.SpaceItem.INSTANCE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        onBindViewHolder((GuildListViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.Controller
    public void onDragStarted(RecyclerView.ViewHolder viewHolder) {
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        GuildListViewHolder guildListViewHolder = (GuildListViewHolder) viewHolder;
        guildListViewHolder.onDragStarted();
        this.draggingItem = guildListViewHolder;
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.Controller
    public void onDrop() {
        boolean zOnDrop = this.interactionListener.onDrop();
        GuildListViewHolder guildListViewHolder = this.draggingItem;
        if (guildListViewHolder != null) {
            guildListViewHolder.onDragEnded(zOnDrop);
        }
        this.draggingItem = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0134  */
    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        boolean z2;
        Operation moveAbove;
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(target, "target");
        this.interactionListener.onItemMoved();
        long itemId = ((GuildListViewHolder) source).getItemId();
        long itemId2 = ((GuildListViewHolder) target).getItemId();
        int i = -1;
        int i2 = 0;
        int i3 = -1;
        for (Object obj : this.items) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            GuildListItem guildListItem = (GuildListItem) obj;
            if (guildListItem.getItemId() == itemId) {
                i = i2;
            } else if (guildListItem.getItemId() == itemId2) {
                i3 = i2;
            }
            i2 = i4;
        }
        if (i == -1 || i3 == -1) {
            return false;
        }
        View view = source.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "source.itemView");
        TargetPosition targetPosition = (((float) Math.abs(this.selectedCenterY - this.targetCenterY)) > (((float) view.getHeight()) * 0.2f) ? 1 : (((float) Math.abs(this.selectedCenterY - this.targetCenterY)) == (((float) view.getHeight()) * 0.2f) ? 0 : -1)) < 0 ? TargetPosition.CENTER : this.selectedCenterY < this.targetCenterY ? TargetPosition.TOP : TargetPosition.BOTTOM;
        GuildListItem guildListItem2 = this.items.get(i);
        GuildListItem guildListItem3 = this.items.get(i3);
        if (guildListItem2 instanceof GuildListItem.GuildItem) {
            boolean z3 = (guildListItem3 instanceof GuildListItem.FolderItem) && !(((GuildListItem.FolderItem) guildListItem3).isOpen() && targetPosition == TargetPosition.CENTER);
            if (guildListItem3 instanceof GuildListItem.GuildItem) {
                GuildListItem.GuildItem guildItem = (GuildListItem.GuildItem) guildListItem3;
                boolean z4 = !guildItem.isLurkingGuild() && (guildItem.getFolderId() == null || targetPosition != TargetPosition.CENTER);
                z2 = !isPendingGuildOperation(guildListItem2, guildListItem3) && (z3 || z4 || ((guildListItem3 instanceof GuildListItem.CreateItem) && targetPosition == TargetPosition.TOP));
            }
        } else {
            if (!(guildListItem2 instanceof GuildListItem.FolderItem)) {
                throw new IllegalStateException("trying to drag invalid source");
            }
            if (guildListItem3 instanceof GuildListItem.GuildItem) {
                GuildListItem.GuildItem guildItem2 = (GuildListItem.GuildItem) guildListItem3;
                boolean z5 = (guildItem2.isLurkingGuild() || guildItem2.getFolderId() != null || targetPosition == TargetPosition.CENTER) ? false : true;
                boolean z6 = (guildListItem3 instanceof GuildListItem.FolderItem) && (targetPosition == TargetPosition.TOP || (!((GuildListItem.FolderItem) guildListItem3).isOpen() && targetPosition == TargetPosition.BOTTOM));
                if (isPendingGuildOperation(guildListItem2, guildListItem3) || (!z5 && !z6)) {
                }
            }
        }
        if (!z2) {
            return false;
        }
        int iOrdinal = targetPosition.ordinal();
        if (iOrdinal == 0) {
            moveAbove = new Operation.MoveAbove(i, i3);
        } else if (iOrdinal == 1) {
            moveAbove = new Operation.TargetOperation(i, i3);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            moveAbove = new Operation.MoveBelow(i, i3);
        }
        this.interactionListener.onOperation(moveAbove);
        return true;
    }

    public final void setItems(List<? extends GuildListItem> newItems, boolean calculateDiff) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        if (!calculateDiff) {
            this.items = newItems;
            notifyDataSetChanged();
        } else {
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(createDiffUtilCallback(this.items, newItems), true);
            Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(callback, true)");
            this.items = newItems;
            diffResultCalculateDiff.dispatchUpdatesTo(this);
        }
    }

    public void onBindViewHolder(GuildListViewHolder holder, int position) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        GuildListItem guildListItem = this.items.get(position);
        if (guildListItem instanceof GuildListItem.GuildItem) {
            ((GuildListViewHolder.GuildViewHolder) holder).configure((GuildListItem.GuildItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem.FriendsItem) {
            ((GuildListViewHolder.FriendsViewHolder) holder).configure((GuildListItem.FriendsItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem.PrivateChannelItem) {
            ((GuildListViewHolder.PrivateChannelViewHolder) holder).configure((GuildListItem.PrivateChannelItem) guildListItem);
            return;
        }
        if (guildListItem instanceof GuildListItem.FolderItem) {
            ((GuildListViewHolder.FolderViewHolder) holder).configure((GuildListItem.FolderItem) guildListItem);
            return;
        }
        if ((guildListItem instanceof GuildListItem.UnavailableItem) || (guildListItem instanceof GuildListItem.CreateItem) || (guildListItem instanceof GuildListItem.HelpItem)) {
            holder.itemView.setOnClickListener(new AnonymousClass1(holder, guildListItem));
            return;
        }
        if (guildListItem instanceof GuildListItem.HubItem) {
            holder.itemView.setOnClickListener(new AnonymousClass2(holder, guildListItem));
            ((GuildListViewHolder.DiscordHubViewHolder) holder).configure((GuildListItem.HubItem) guildListItem);
        } else if (guildListItem instanceof GuildListItem.SpaceItem) {
            ((GuildListViewHolder.SpaceViewHolder) holder).configure(this.bottomNavHeight);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(parent);
        switch (viewType) {
            case 0:
                View viewInvoke = anonymousClass1.invoke(R.layout.widget_guilds_list_item_profile);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke, "itemView");
                return new GuildListViewHolder.FriendsViewHolder(viewInvoke, new AnonymousClass8(viewInvoke));
            case 1:
                View viewInvoke2 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_divider);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke2, "itemView");
                return new GuildListViewHolder.SimpleViewHolder(viewInvoke2);
            case 2:
                View viewInvoke3 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_dm_vertical);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke3, "itemView");
                return new GuildListViewHolder.PrivateChannelViewHolder(viewInvoke3, new AnonymousClass6(viewInvoke3), new AnonymousClass7(viewInvoke3));
            case 3:
                View viewInvoke4 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_guild_vertical);
                int themedColor = ColorCompat.getThemedColor(parent.getContext(), R.attr.colorBackgroundTertiary);
                int themedColor2 = ColorCompat.getThemedColor(parent.getContext(), R.attr.primary_600);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke4, "itemView");
                return new GuildListViewHolder.GuildViewHolder(viewInvoke4, themedColor, themedColor2, new AnonymousClass2(viewInvoke4), new AnonymousClass3(viewInvoke4));
            case 4:
                View viewInvoke5 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_guild_unavailable);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke5, "itemView");
                return new GuildListViewHolder.SimpleViewHolder(viewInvoke5);
            case 5:
                View viewInvoke6 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_guild_new);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke6, "itemView");
                return new GuildListViewHolder.SimpleViewHolder(viewInvoke6);
            case 6:
                View viewInvoke7 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_folder);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke7, "itemView");
                return new GuildListViewHolder.FolderViewHolder(viewInvoke7, new AnonymousClass4(viewInvoke7), new AnonymousClass5(viewInvoke7));
            case 7:
                View viewInvoke8 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_guild_nux);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke8, "itemView");
                return new GuildListViewHolder.SimpleViewHolder(viewInvoke8);
            case 8:
                View viewInvoke9 = anonymousClass1.invoke(R.layout.recycler_item_bottom_nav_space);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke9, "itemView");
                return new GuildListViewHolder.SpaceViewHolder(viewInvoke9);
            case 9:
                View viewInvoke10 = anonymousClass1.invoke(R.layout.widget_guilds_list_item_hub_verification);
                Intrinsics3.checkNotNullExpressionValue(viewInvoke10, "itemView");
                return new GuildListViewHolder.DiscordHubViewHolder(viewInvoke10);
            default:
                throw new IllegalStateException(outline.q("invalid view type: ", viewType));
        }
    }
}
