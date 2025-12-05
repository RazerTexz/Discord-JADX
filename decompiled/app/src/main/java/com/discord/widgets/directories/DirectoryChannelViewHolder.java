package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public abstract class DirectoryChannelViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryChannelViewHolder(View view) {
        super(view);
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    public abstract void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener);
}
