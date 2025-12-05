package com.discord.widgets.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFriendsListAdapterItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetFriendsList.kt */
/* renamed from: com.discord.widgets.friends.WidgetFriendsListLoadingAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsList5 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int LOADING_CELLS_COUNT = 15;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_friends_list_adapter_item_loading, parent, false);
        int i = C5419R.id.blank_item_avatar_placeholder;
        View viewFindViewById = viewInflate.findViewById(C5419R.id.blank_item_avatar_placeholder);
        if (viewFindViewById != null) {
            i = C5419R.id.blank_item_username_placeholder;
            View viewFindViewById2 = viewInflate.findViewById(C5419R.id.blank_item_username_placeholder);
            if (viewFindViewById2 != null) {
                WidgetFriendsListAdapterItemLoadingBinding widgetFriendsListAdapterItemLoadingBinding = new WidgetFriendsListAdapterItemLoadingBinding((ConstraintLayout) viewInflate, viewFindViewById, viewFindViewById2);
                Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterItemLoadingBinding, "WidgetFriendsListAdapter….context), parent, false)");
                return new WidgetFriendsList2(widgetFriendsListAdapterItemLoadingBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
