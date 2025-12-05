package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildJoinRequest this$0;

    /* compiled from: WidgetChannelsListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1$1 */
    public static final class C74461 extends Lambda implements Function0<Unit> {
        public static final C74461 INSTANCE = new C74461();

        public C74461() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    public WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1(WidgetChannelsListAdapter.ItemGuildJoinRequest itemGuildJoinRequest, Context context) {
        this.this$0 = itemGuildJoinRequest;
        this.$context = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
        Context context = this.$context;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, context, WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0)), WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0).getSelectedGuildId(), "Channel Notice", null, null, C74461.INSTANCE, 48, null);
    }
}
