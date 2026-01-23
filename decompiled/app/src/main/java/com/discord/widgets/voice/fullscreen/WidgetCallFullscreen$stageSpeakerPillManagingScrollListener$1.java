package com.discord.widgets.voice.fullscreen;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.stores.StoreVoiceParticipants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1 extends RecyclerView.OnScrollListener {
    private List<StoreVoiceParticipants.VoiceUser> activeSpeakers = Collections2.emptyList();
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    public final List<StoreVoiceParticipants.VoiceUser> getActiveSpeakers() {
        return this.activeSpeakers;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        List<StoreVoiceParticipants.VoiceUser> list = this.activeSpeakers;
        boolean z2 = true;
        if ((list instanceof Collection) && list.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!WidgetCallFullscreen.access$isStageUserVisible(this.this$0, ((StoreVoiceParticipants.VoiceUser) it.next()).getUser().getId())) {
                    break;
                }
            }
            z2 = false;
        }
        ConstraintLayout constraintLayout = WidgetCallFullscreen.access$getBinding$p(this.this$0).f15777t;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setActiveSpeakers(List<StoreVoiceParticipants.VoiceUser> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.activeSpeakers = list;
    }
}
