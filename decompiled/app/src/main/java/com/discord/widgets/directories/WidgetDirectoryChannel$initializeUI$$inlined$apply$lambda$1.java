package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.google.android.material.tabs.TabLayout;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetDirectoryChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1 extends o implements Function2<TabLayout.Tab, Integer, Unit> {
    public final /* synthetic */ TabLayout $this_apply;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public final /* synthetic */ int $position;
        public final /* synthetic */ TabLayout.Tab $tab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, TabLayout.Tab tab) {
            super(1);
            this.$position = i;
            this.$tab = tab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            String string;
            m.checkNotNullParameter(viewState, "state");
            Pair pair = (Pair) u.getOrNull(viewState.getMappedTabs(), this.$position);
            if (pair == null) {
                StringBuilder sbU = a.U("Missing tab for position: ");
                sbU.append(this.$position);
                throw new IllegalStateException(sbU.toString());
            }
            TabLayout.Tab tab = this.$tab;
            View viewInflate = WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1.this.this$0.getLayoutInflater().inflate(R.layout.directory_channel_tab, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            b.a.i.m mVar = new b.a.i.m(textView, textView);
            if (((Number) pair.getSecond()).intValue() <= 0) {
                string = "";
            } else {
                StringBuilder sbU2 = a.U(" (");
                sbU2.append(((Number) pair.getSecond()).intValue());
                sbU2.append(')');
                string = sbU2.toString();
            }
            m.checkNotNullExpressionValue(textView, "tabView");
            StringBuilder sb = new StringBuilder();
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) pair.getFirst();
            Context context = WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1.this.$this_apply.getContext();
            m.checkNotNullExpressionValue(context, "context");
            sb.append(directoryEntryCategory.getTitle(context));
            sb.append(string);
            textView.setText(sb.toString());
            m.checkNotNullExpressionValue(mVar, "DirectoryChannelTabBindi…text)}$count\"\n          }");
            tab.setCustomView(textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1(TabLayout tabLayout, WidgetDirectoryChannel widgetDirectoryChannel) {
        super(2);
        this.$this_apply = tabLayout;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
        invoke(tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout.Tab tab, int i) {
        m.checkNotNullParameter(tab, "tab");
        this.this$0.getViewModel().withViewState(new AnonymousClass1(i, tab));
    }
}
