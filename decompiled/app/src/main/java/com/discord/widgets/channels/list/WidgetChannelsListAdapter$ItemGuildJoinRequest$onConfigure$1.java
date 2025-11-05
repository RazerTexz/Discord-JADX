package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildJoinRequest this$0;

    /* compiled from: WidgetChannelsListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        m.checkNotNullExpressionValue(context, "context");
        MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, context, WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0)), WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0).getSelectedGuildId(), "Channel Notice", null, null, AnonymousClass1.INSTANCE, 48, null);
    }
}
