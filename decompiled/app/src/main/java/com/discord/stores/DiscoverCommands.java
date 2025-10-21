package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommand;
import com.discord.stores.LoadState;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreApplicationCommands.kt */
/* loaded from: classes2.dex */
public final /* data */ class DiscoverCommands {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ApplicationCommand> commands;
    private final int currentEndOffset;
    private final int currentStartOffset;
    private final boolean hasMoreAfter;
    private final boolean hasMoreBefore;
    private final Long jumpedApplicationId;
    private final int jumpedSequenceId;
    private final LoadState loadState;

    /* compiled from: StoreApplicationCommands.kt */
    public static final class Companion {
        private Companion() {
        }

        public final DiscoverCommands getDefaultModelDiscoveryCommands() {
            return new DiscoverCommands(Collections2.emptyList(), 0, 0, false, false, 0, null, null, 128, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoverCommands(List<? extends ApplicationCommand> list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(list, "commands");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        this.commands = list;
        this.currentStartOffset = i;
        this.currentEndOffset = i2;
        this.hasMoreBefore = z2;
        this.hasMoreAfter = z3;
        this.jumpedSequenceId = i3;
        this.jumpedApplicationId = l;
        this.loadState = loadState;
    }

    public static /* synthetic */ DiscoverCommands copy$default(DiscoverCommands discoverCommands, List list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState, int i4, Object obj) {
        return discoverCommands.copy((i4 & 1) != 0 ? discoverCommands.commands : list, (i4 & 2) != 0 ? discoverCommands.currentStartOffset : i, (i4 & 4) != 0 ? discoverCommands.currentEndOffset : i2, (i4 & 8) != 0 ? discoverCommands.hasMoreBefore : z2, (i4 & 16) != 0 ? discoverCommands.hasMoreAfter : z3, (i4 & 32) != 0 ? discoverCommands.jumpedSequenceId : i3, (i4 & 64) != 0 ? discoverCommands.jumpedApplicationId : l, (i4 & 128) != 0 ? discoverCommands.loadState : loadState);
    }

    public final List<ApplicationCommand> component1() {
        return this.commands;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    /* renamed from: component6, reason: from getter */
    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    /* renamed from: component8, reason: from getter */
    public final LoadState getLoadState() {
        return this.loadState;
    }

    public final DiscoverCommands copy(List<? extends ApplicationCommand> commands, int currentStartOffset, int currentEndOffset, boolean hasMoreBefore, boolean hasMoreAfter, int jumpedSequenceId, Long jumpedApplicationId, LoadState loadState) {
        Intrinsics3.checkNotNullParameter(commands, "commands");
        Intrinsics3.checkNotNullParameter(loadState, "loadState");
        return new DiscoverCommands(commands, currentStartOffset, currentEndOffset, hasMoreBefore, hasMoreAfter, jumpedSequenceId, jumpedApplicationId, loadState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoverCommands)) {
            return false;
        }
        DiscoverCommands discoverCommands = (DiscoverCommands) other;
        return Intrinsics3.areEqual(this.commands, discoverCommands.commands) && this.currentStartOffset == discoverCommands.currentStartOffset && this.currentEndOffset == discoverCommands.currentEndOffset && this.hasMoreBefore == discoverCommands.hasMoreBefore && this.hasMoreAfter == discoverCommands.hasMoreAfter && this.jumpedSequenceId == discoverCommands.jumpedSequenceId && Intrinsics3.areEqual(this.jumpedApplicationId, discoverCommands.jumpedApplicationId) && Intrinsics3.areEqual(this.loadState, discoverCommands.loadState);
    }

    public final List<ApplicationCommand> getCommands() {
        return this.commands;
    }

    public final int getCurrentEndOffset() {
        return this.currentEndOffset;
    }

    public final int getCurrentStartOffset() {
        return this.currentStartOffset;
    }

    public final boolean getHasMoreAfter() {
        return this.hasMoreAfter;
    }

    public final boolean getHasMoreBefore() {
        return this.hasMoreBefore;
    }

    public final Long getJumpedApplicationId() {
        return this.jumpedApplicationId;
    }

    public final int getJumpedSequenceId() {
        return this.jumpedSequenceId;
    }

    public final LoadState getLoadState() {
        return this.loadState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<ApplicationCommand> list = this.commands;
        int iHashCode = (((((list != null ? list.hashCode() : 0) * 31) + this.currentStartOffset) * 31) + this.currentEndOffset) * 31;
        boolean z2 = this.hasMoreBefore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.hasMoreAfter;
        int i3 = (((i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.jumpedSequenceId) * 31;
        Long l = this.jumpedApplicationId;
        int iHashCode2 = (i3 + (l != null ? l.hashCode() : 0)) * 31;
        LoadState loadState = this.loadState;
        return iHashCode2 + (loadState != null ? loadState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DiscoverCommands(commands=");
        sbU.append(this.commands);
        sbU.append(", currentStartOffset=");
        sbU.append(this.currentStartOffset);
        sbU.append(", currentEndOffset=");
        sbU.append(this.currentEndOffset);
        sbU.append(", hasMoreBefore=");
        sbU.append(this.hasMoreBefore);
        sbU.append(", hasMoreAfter=");
        sbU.append(this.hasMoreAfter);
        sbU.append(", jumpedSequenceId=");
        sbU.append(this.jumpedSequenceId);
        sbU.append(", jumpedApplicationId=");
        sbU.append(this.jumpedApplicationId);
        sbU.append(", loadState=");
        sbU.append(this.loadState);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ DiscoverCommands(List list, int i, int i2, boolean z2, boolean z3, int i3, Long l, LoadState loadState, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, z2, z3, i3, l, (i4 & 128) != 0 ? LoadState.None.INSTANCE : loadState);
    }
}
