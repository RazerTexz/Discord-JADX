package com.discord.widgets.directories;

import android.widget.TextView;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.widgets.directories.DirectoryChannelItem;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
/* loaded from: classes2.dex */
public final class SectionHeaderViewHolder extends DirectoryChannelViewHolder {
    private final DirectorySectionHeaderListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public SectionHeaderViewHolder(DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding) {
        Intrinsics3.checkNotNullParameter(directorySectionHeaderListItemBinding, "viewBinding");
        TextView textView = directorySectionHeaderListItemBinding.f15044a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directorySectionHeaderListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        int textRes = ((DirectoryChannelItem.SectionHeader) item).getTextRes();
        TextView textView = this.viewBinding.f15045b;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.directorySectionText");
        FormatUtils.m222n(textView, textRes, new Object[0], null, 4);
    }

    public final DirectorySectionHeaderListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
