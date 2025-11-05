package com.discord.widgets.directories;

import android.view.View;
import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import d0.z.d.m;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* compiled from: WidgetDirectoryEntryViewHolder.kt */
    /* renamed from: com.discord.widgets.directories.AddServerViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ DirectoryChannelItemClickInterface $listener;

        public AnonymousClass1(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
            this.$listener = directoryChannelItemClickInterface;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$listener.onAddServerClicked();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        m.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.a;
        m.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(listener, "listener");
        this.viewBinding.f2095b.setOnClickListener(new AnonymousClass1(listener));
    }

    public final DirectoryAddServerListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
