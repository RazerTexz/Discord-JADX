package com.discord.widgets.hubs;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.c0;
import com.discord.R;
import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* compiled from: WidgetHubEmailFlow.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow$onViewCreated$learnMore$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            b0.Companion companion = b0.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getString(R.string.hub_email_connection_sidebar_learn_more_header);
            m.checkNotNullExpressionValue(string, "getString(R.string.hub_e…idebar_learn_more_header)");
            b0.Companion.b(companion, childFragmentManager, string, d0.t.m.listOf(new c0(null, WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getString(R.string.hub_email_connection_sidebar_description), null, null, null, null, null, Opcodes.LUSHR)), false, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$onViewCreated$learnMore$1(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("{helpdeskArticle}", new AnonymousClass1());
    }
}
