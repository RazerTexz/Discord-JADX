package com.discord.widgets.directories;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDirectoryChannelViewPagerAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannelViewPagerAdapter extends FragmentStateAdapter {
    private List<? extends DirectoryEntryCategory> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannelViewPagerAdapter(AppFragment appFragment) {
        super(appFragment);
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.tabs = Collections2.emptyList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public /* bridge */ /* synthetic */ Fragment createFragment(int i) {
        return createFragment(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.tabs.size();
    }

    public final List<DirectoryEntryCategory> getTabs() {
        return this.tabs;
    }

    public final void setTabs(List<? extends DirectoryEntryCategory> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.tabs = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public WidgetDirectoryCategory createFragment(int position) {
        WidgetDirectoryCategory widgetDirectoryCategory = new WidgetDirectoryCategory();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) _Collections.getOrNull(this.tabs, position);
        if (directoryEntryCategory != null) {
            widgetDirectoryCategory.setArguments(AnimatableValueParser.m514e2(new WidgetDirectoryCategory2(directoryEntryCategory)));
            return widgetDirectoryCategory;
        }
        StringBuilder sbM834V = outline.m834V("Couldn't find tab with position ", position, " in ");
        sbM834V.append(this.tabs);
        throw new IllegalStateException(sbM834V.toString());
    }
}
