package com.discord.widgets.directories;

import com.discord.databinding.WidgetDirectoryChannelBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetDirectoryChannel.kt */
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryChannel4 extends FunctionReferenceImpl implements Function1<WidgetDirectoryChannelBinding, Unit> {
    public WidgetDirectoryChannel4(WidgetDirectoryChannel widgetDirectoryChannel) {
        super(1, widgetDirectoryChannel, WidgetDirectoryChannel.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetDirectoryChannelBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        invoke2(widgetDirectoryChannelBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        Intrinsics3.checkNotNullParameter(widgetDirectoryChannelBinding, "p1");
        WidgetDirectoryChannel.access$onViewBindingDestroy((WidgetDirectoryChannel) this.receiver, widgetDirectoryChannelBinding);
    }
}
