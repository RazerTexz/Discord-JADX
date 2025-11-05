package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.hubs.WidgetHubAddServer;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubAddServer.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1 extends o implements Function0<Unit> {
    public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
    public final /* synthetic */ HubAddServerState $state$inlined;
    public final /* synthetic */ WidgetHubAddServer.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer$onServerClickListener$1$$special$$inlined$let$lambda$1(DirectoryEntryGuild directoryEntryGuild, WidgetHubAddServer.AnonymousClass1 anonymousClass1, HubAddServerState hubAddServerState) {
        super(0);
        this.$directoryEntry = directoryEntryGuild;
        this.this$0 = anonymousClass1;
        this.$state$inlined = hubAddServerState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetHubAddServer.this.getViewModel().removeGuild(this.this$0.$guildId, this.$directoryEntry.getDirectoryChannelId());
    }
}
