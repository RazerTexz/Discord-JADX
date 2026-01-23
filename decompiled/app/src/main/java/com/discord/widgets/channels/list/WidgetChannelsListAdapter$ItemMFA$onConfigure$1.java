package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.i18n.RenderContext;
import com.discord.utilities.uri.UriHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppHelpDesk;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemMFA$onConfigure$1 extends Lambda implements Function1<RenderContext, Unit> {
    public static final WidgetChannelsListAdapter$ItemMFA$onConfigure$1 INSTANCE = new WidgetChannelsListAdapter$ItemMFA$onConfigure$1();

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemMFA$onConfigure$1$1 */
    /* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
    public static final class C74481 extends Lambda implements Function1<View, Unit> {
        public static final C74481 INSTANCE = new C74481();

        public C74481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            UriHandler.handle$default(uriHandler, context, AppHelpDesk.f507a.m149a(219576828L, null), false, false, null, 28, null);
        }
    }

    public WidgetChannelsListAdapter$ItemMFA$onConfigure$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8423b("onClick", C74481.INSTANCE);
    }
}
