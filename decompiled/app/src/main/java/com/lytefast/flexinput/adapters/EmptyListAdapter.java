package com.lytefast.flexinput.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* compiled from: EmptyListAdapter.kt */
/* loaded from: classes3.dex */
public class EmptyListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final int actionBtnId;
    private final int itemLayoutId;
    private final View.OnClickListener onClickListener;

    /* compiled from: EmptyListAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: from kotlin metadata */
        public final View actionBtn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EmptyListAdapter emptyListAdapter, View view) {
            super(view);
            m.checkNotNullParameter(view, "itemView");
            View viewFindViewById = view.findViewById(EmptyListAdapter.access$getActionBtnId$p(emptyListAdapter));
            m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(actionBtnId)");
            this.actionBtn = viewFindViewById;
        }
    }

    public EmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
        m.checkNotNullParameter(onClickListener, "onClickListener");
        this.itemLayoutId = i;
        this.actionBtnId = i2;
        this.onClickListener = onClickListener;
    }

    public static final /* synthetic */ int access$getActionBtnId$p(EmptyListAdapter emptyListAdapter) {
        return emptyListAdapter.actionBtnId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.actionBtn.setOnClickListener(this.onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayoutId, parent, false);
        m.checkNotNullExpressionValue(viewInflate, "view");
        return new ViewHolder(this, viewInflate);
    }
}
