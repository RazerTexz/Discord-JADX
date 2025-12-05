package com.discord.widgets.hubs;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.i18n.RenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p062y.SelectorBottomSheet;
import p007b.p008a.p062y.SelectorBottomSheet2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubEmailFlow.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow5 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1$1 */
    public static final class C90381 extends Lambda implements Function1<View, Unit> {
        public C90381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubEmailFlow5.this.this$0.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetHubEmailFlow5.this.this$0.getString(C5419R.string.hub_email_connection_sidebar_learn_more_header);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.hub_e…idebar_learn_more_header)");
            SelectorBottomSheet.Companion.m378b(companion, childFragmentManager, string, CollectionsJVM.listOf(new SelectorBottomSheet2(null, WidgetHubEmailFlow5.this.this$0.getString(C5419R.string.hub_email_connection_sidebar_description), null, null, null, null, null, Opcodes.LUSHR)), false, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow5(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8423b("{helpdeskArticle}", new C90381());
    }
}
