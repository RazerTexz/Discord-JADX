package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.DirectoryChannelTabBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel7 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
    public final /* synthetic */ TabLayout $this_apply;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1 */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class C82931 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public final /* synthetic */ int $position;
        public final /* synthetic */ TabLayout.Tab $tab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C82931(int i, TabLayout.Tab tab) {
            super(1);
            this.$position = i;
            this.$tab = tab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            String string;
            Intrinsics3.checkNotNullParameter(viewState, "state");
            Tuples2 tuples2 = (Tuples2) _Collections.getOrNull(viewState.getMappedTabs(), this.$position);
            if (tuples2 == null) {
                StringBuilder sbM833U = outline.m833U("Missing tab for position: ");
                sbM833U.append(this.$position);
                throw new IllegalStateException(sbM833U.toString());
            }
            TabLayout.Tab tab = this.$tab;
            View viewInflate = WidgetDirectoryChannel7.this.this$0.getLayoutInflater().inflate(C5419R.layout.directory_channel_tab, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            DirectoryChannelTabBinding directoryChannelTabBinding = new DirectoryChannelTabBinding(textView, textView);
            if (((Number) tuples2.getSecond()).intValue() <= 0) {
                string = "";
            } else {
                StringBuilder sbM833U2 = outline.m833U(" (");
                sbM833U2.append(((Number) tuples2.getSecond()).intValue());
                sbM833U2.append(')');
                string = sbM833U2.toString();
            }
            Intrinsics3.checkNotNullExpressionValue(textView, "tabView");
            StringBuilder sb = new StringBuilder();
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) tuples2.getFirst();
            Context context = WidgetDirectoryChannel7.this.$this_apply.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            sb.append(directoryEntryCategory.getTitle(context));
            sb.append(string);
            textView.setText(sb.toString());
            Intrinsics3.checkNotNullExpressionValue(directoryChannelTabBinding, "DirectoryChannelTabBindi…text)}$count\"\n          }");
            tab.setCustomView(textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel7(TabLayout tabLayout, WidgetDirectoryChannel widgetDirectoryChannel) {
        super(2);
        this.$this_apply = tabLayout;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
        invoke(tab, num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(TabLayout.Tab tab, int i) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
        this.this$0.getViewModel().withViewState(new C82931(i, tab));
    }
}
