package com.discord.widgets.forums;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.databinding.ForumBrowserHeaderItemBinding;
import com.discord.databinding.ForumBrowserPostItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.forums.ForumBrowserItem;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetForumBrowserAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter extends MGRecyclerAdapterSimple<ForumBrowserItem> {
    private final RecyclerView.ItemDecoration itemDecoration;
    private final Function1<Channel, Unit> onPostClick;
    private final Function1<Channel, Unit> onPostLongClick;

    /* compiled from: WidgetForumBrowserAdapter.kt */
    public static final class HeaderItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(C5419R.layout.forum_browser_header_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C5419R.id.header_name);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.header_name)));
            }
            ForumBrowserHeaderItemBinding forumBrowserHeaderItemBinding = new ForumBrowserHeaderItemBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserHeaderItemBinding, "ForumBrowserHeaderItemBinding.bind(itemView)");
            this.binding = forumBrowserHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) {
            onConfigure2(i, forumBrowserItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ForumBrowserItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f15077b.setText(((ForumBrowserItem.HeaderItem) data).getStringResId());
        }
    }

    /* compiled from: WidgetForumBrowserAdapter.kt */
    public static final class LoadingItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(C5419R.layout.forum_browser_loading_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
        }
    }

    /* compiled from: WidgetForumBrowserAdapter.kt */
    public static final class PostItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserPostItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(C5419R.layout.forum_browser_post_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            ForumBrowserPostView forumBrowserPostView = (ForumBrowserPostView) view;
            ForumBrowserPostItemBinding forumBrowserPostItemBinding = new ForumBrowserPostItemBinding(forumBrowserPostView, forumBrowserPostView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostItemBinding, "ForumBrowserPostItemBinding.bind(itemView)");
            this.binding = forumBrowserPostItemBinding;
        }

        public static final /* synthetic */ WidgetForumBrowserAdapter access$getAdapter$p(PostItem postItem) {
            return (WidgetForumBrowserAdapter) postItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) throws Resources.NotFoundException {
            onConfigure2(i, forumBrowserItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ForumBrowserItem data) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ForumBrowserItem.PostItem postItem = (ForumBrowserItem.PostItem) data;
            this.binding.f15079b.configurePost(postItem.getPost());
            this.binding.f15079b.setOnClickListener(new WidgetForumBrowserAdapter2(this, postItem));
            ForumBrowserPostView forumBrowserPostView = this.binding.f15079b;
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostView, "binding.forumBrowserPostView");
            ViewExtensions.setOnLongClickListenerConsumeClick(forumBrowserPostView, new WidgetForumBrowserAdapter3(this, postItem));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function12) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onPostClick");
        Intrinsics3.checkNotNullParameter(function12, "onPostLongClick");
        this.onPostClick = function1;
        this.onPostLongClick = function12;
        this.itemDecoration = new WidgetForumBrowserAdapter4(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.getInternalData();
    }

    public static final /* synthetic */ Function1 access$getOnPostClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostClick;
    }

    public static final /* synthetic */ Function1 access$getOnPostLongClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostLongClick;
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ForumBrowserItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderItem(this);
        }
        if (viewType == 1) {
            return new PostItem(this);
        }
        if (viewType == 2) {
            return new LoadingItem(this);
        }
        throw new IllegalStateException(outline.m871q("Invalid view type: ", viewType));
    }
}
