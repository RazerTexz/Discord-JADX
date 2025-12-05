package com.discord.widgets.servers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewCategoryOverrideItemBinding;
import com.discord.databinding.ViewChannelOverrideItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.view.extensions.ViewExtensions;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Standard2;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NotificationsOverridesAdapter.kt */
/* loaded from: classes2.dex */
public final class NotificationsOverridesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Item> data;
    private final Function2<View, Item, Unit> onClick;

    /* compiled from: NotificationsOverridesAdapter.kt */
    public static final class DiffCallback extends DiffUtil.Callback {
        private final List<Item> newItems;
        private final List<Item> oldItems;

        public DiffCallback(List<Item> list, List<Item> list2) {
            Intrinsics3.checkNotNullParameter(list, "newItems");
            Intrinsics3.checkNotNullParameter(list2, "oldItems");
            this.newItems = list;
            this.oldItems = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(this.newItems.get(newItemPosition), this.oldItems.get(oldItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return this.newItems.get(newItemPosition).getChannel().getId() == this.oldItems.get(oldItemPosition).getChannel().getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldItems.size();
        }
    }

    /* compiled from: NotificationsOverridesAdapter.kt */
    public static final class Item {
        private final Channel channel;
        private final ModelNotificationSettings.ChannelOverride overrideSettings;
        private final Channel parent;

        public Item(Channel channel, Channel channel2, ModelNotificationSettings.ChannelOverride channelOverride) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelOverride, "overrideSettings");
            this.channel = channel;
            this.parent = channel2;
            this.overrideSettings = channelOverride;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final ModelNotificationSettings.ChannelOverride getOverrideSettings() {
            return this.overrideSettings;
        }

        public final Channel getParent() {
            return this.parent;
        }
    }

    /* compiled from: NotificationsOverridesAdapter.kt */
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        private final Function2<View, Item, Unit> onClick;

        /* compiled from: NotificationsOverridesAdapter.kt */
        public static final class CategoryOverridesViewHolder extends ViewHolder {
            private final ViewCategoryOverrideItemBinding binding;

            /* JADX WARN: Illegal instructions before constructor call */
            public CategoryOverridesViewHolder(ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding, Function2<? super View, ? super Item, Unit> function2) {
                Intrinsics3.checkNotNullParameter(viewCategoryOverrideItemBinding, "binding");
                Intrinsics3.checkNotNullParameter(function2, "onClick");
                ConstraintLayout constraintLayout = viewCategoryOverrideItemBinding.f15379a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                super(constraintLayout, function2, null);
                this.binding = viewCategoryOverrideItemBinding;
            }

            @Override // com.discord.widgets.servers.NotificationsOverridesAdapter.ViewHolder
            public void onBind(Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onBind(data);
                TextView textView = this.binding.f15380b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.categoryOverrideName");
                textView.setText(ChannelUtils.m7679c(data.getChannel()));
                int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? C5419R.string.form_label_muted : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
                TextView textView2 = this.binding.f15381c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.categoryOverrideStatus");
                FormatUtils.m222n(textView2, iMessageNotificationToString, new Object[0], null, 4);
            }
        }

        /* compiled from: NotificationsOverridesAdapter.kt */
        public static final class ChannelOverridesViewHolder extends ViewHolder {
            private final ViewChannelOverrideItemBinding binding;

            /* JADX WARN: Illegal instructions before constructor call */
            public ChannelOverridesViewHolder(ViewChannelOverrideItemBinding viewChannelOverrideItemBinding, Function2<? super View, ? super Item, Unit> function2) {
                Intrinsics3.checkNotNullParameter(viewChannelOverrideItemBinding, "binding");
                Intrinsics3.checkNotNullParameter(function2, "onClick");
                ConstraintLayout constraintLayout = viewChannelOverrideItemBinding.f15382a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                super(constraintLayout, function2, null);
                this.binding = viewChannelOverrideItemBinding;
            }

            @Override // com.discord.widgets.servers.NotificationsOverridesAdapter.ViewHolder
            public void onBind(Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onBind(data);
                TextView textView = this.binding.f15384c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelOverrideName");
                textView.setText(ChannelUtils.m7679c(data.getChannel()));
                TextView textView2 = this.binding.f15383b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelOverrideCategoryName");
                Channel parent = data.getParent();
                ViewExtensions.setTextAndVisibilityBy(textView2, parent != null ? ChannelUtils.m7679c(parent) : null);
                int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? C5419R.string.form_label_muted : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
                TextView textView3 = this.binding.f15385d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelOverrideStatus");
                FormatUtils.m222n(textView3, iMessageNotificationToString, new Object[0], null, 4);
            }
        }

        public /* synthetic */ ViewHolder(View view, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function2);
        }

        public final Function2<View, Item, Unit> getOnClick() {
            return this.onClick;
        }

        @StringRes
        public final int messageNotificationToString(int messageNotificationLevel) {
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_ALL) {
                return C5419R.string.form_label_all_messages;
            }
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_MENTIONS) {
                return C5419R.string.form_label_only_mentions;
            }
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_NOTHING) {
                return C5419R.string.form_label_nothing;
            }
            return 0;
        }

        public void onBind(Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.itemView.setOnClickListener(new NotificationsOverridesAdapter2(this, data));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ViewHolder(View view, Function2<? super View, ? super Item, Unit> function2) {
            super(view);
            this.onClick = function2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationsOverridesAdapter(Function2<? super View, ? super Item, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onClick");
        this.onClick = function2;
        this.data = Collections2.emptyList();
    }

    public final List<Item> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getChannel().getType();
    }

    public final Function2<View, Item, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @MainThread
    public final void setData(List<Item> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallback(list, this.data), true);
        Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(D…back(value, field), true)");
        this.data = list;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.onBind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int i = C5419R.id.navigation_indicator;
        if (viewType != 0 && viewType != 15) {
            if (viewType == 4) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.view_category_override_item, parent, false);
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.category_override_name);
                if (textView != null) {
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.category_override_status);
                    if (textView2 != null) {
                        Guideline guideline = (Guideline) viewInflate.findViewById(C5419R.id.guideline);
                        if (guideline != null) {
                            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.navigation_indicator);
                            if (imageView != null) {
                                ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding = new ViewCategoryOverrideItemBinding((ConstraintLayout) viewInflate, textView, textView2, guideline, imageView);
                                Intrinsics3.checkNotNullExpressionValue(viewCategoryOverrideItemBinding, "ViewCategoryOverrideItem….context), parent, false)");
                                return new ViewHolder.CategoryOverridesViewHolder(viewCategoryOverrideItemBinding, this.onClick);
                            }
                        } else {
                            i = C5419R.id.guideline;
                        }
                    } else {
                        i = C5419R.id.category_override_status;
                    }
                } else {
                    i = C5419R.id.category_override_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
            if (viewType != 5) {
                throw new Standard2(outline.m883w("An operation is not implemented: ", outline.m873r("Type[", viewType, "] not implemented")));
            }
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.view_channel_override_item, parent, false);
        TextView textView3 = (TextView) viewInflate2.findViewById(C5419R.id.channel_override_category_name);
        if (textView3 != null) {
            TextView textView4 = (TextView) viewInflate2.findViewById(C5419R.id.channel_override_name);
            if (textView4 != null) {
                TextView textView5 = (TextView) viewInflate2.findViewById(C5419R.id.channel_override_status);
                if (textView5 != null) {
                    Guideline guideline2 = (Guideline) viewInflate2.findViewById(C5419R.id.guideline);
                    if (guideline2 != null) {
                        ImageView imageView2 = (ImageView) viewInflate2.findViewById(C5419R.id.navigation_indicator);
                        if (imageView2 != null) {
                            ViewChannelOverrideItemBinding viewChannelOverrideItemBinding = new ViewChannelOverrideItemBinding((ConstraintLayout) viewInflate2, textView3, textView4, textView5, guideline2, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(viewChannelOverrideItemBinding, "ViewChannelOverrideItemB….context), parent, false)");
                            return new ViewHolder.ChannelOverridesViewHolder(viewChannelOverrideItemBinding, this.onClick);
                        }
                    } else {
                        i = C5419R.id.guideline;
                    }
                } else {
                    i = C5419R.id.channel_override_status;
                }
            } else {
                i = C5419R.id.channel_override_name;
            }
        } else {
            i = C5419R.id.channel_override_category_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
