package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$layoutManager$2 extends Lambda implements Function2<VideoCallGridLayoutManager, RecyclerView.State, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$layoutManager$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(2);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView.State state) {
        invoke2(videoCallGridLayoutManager, state);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(videoCallGridLayoutManager, "layoutManager");
        if (WidgetCallFullscreen.access$getHasVideoCallGridChildrenChanged$p(this.this$0)) {
            WidgetCallFullscreen.access$setHasVideoCallGridChildrenChanged$p(this.this$0, false);
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).updateOffScreenParticipantsFromScroll(WidgetCallFullscreen.access$getVisibleParticipants(this.this$0, videoCallGridLayoutManager));
        }
    }
}
