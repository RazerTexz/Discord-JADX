package com.discord.widgets.voice.call;

import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$SystemCallIncoming$onViewCreated$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetVoiceCallIncoming.SystemCallIncoming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceCallIncoming3(WidgetVoiceCallIncoming.SystemCallIncoming systemCallIncoming) {
        super(1);
        this.this$0 = systemCallIncoming;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StringBuilder sbM833U = outline.m833U("Stopping ");
        sbM833U.append(this.this$0.getClass().getName());
        sbM833U.append(" to prevent keeping screen awake");
        AppLog.m8358i(sbM833U.toString());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
