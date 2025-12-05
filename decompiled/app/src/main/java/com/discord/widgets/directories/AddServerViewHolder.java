package com.discord.widgets.directories;

import android.view.View;
import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    /* renamed from: com.discord.widgets.directories.AddServerViewHolder$bind$1 */
    public static final class ViewOnClickListenerC82701 implements View.OnClickListener {
        public final /* synthetic */ DirectoryChannelItemClickInterface $listener;

        public ViewOnClickListenerC82701(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
            this.$listener = directoryChannelItemClickInterface;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$listener.onAddServerClicked();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        Intrinsics3.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.f15040a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.viewBinding.f15041b.setOnClickListener(new ViewOnClickListenerC82701(listener));
    }

    public final DirectoryAddServerListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
