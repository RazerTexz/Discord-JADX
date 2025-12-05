package com.discord.widgets.voice.fullscreen.stage;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StageCallAdapter.kt */
/* loaded from: classes.dex */
public final class StageCallAdapter extends MGRecyclerAdapterSimple<StageCallItem> {
    public static final int AUDIENCE_SPAN_COUNT = 3;
    public static final int SPAN_COUNT = 12;
    public static final int SPEAKER_FULL_SPAN_COUNT = 12;
    public static final int SPEAKER_HALF_SPAN_COUNT = 6;
    public static final int SPEAKER_THIRD_SPAN_COUNT = 4;
    private final FragmentManager fragmentManager;
    private final RecyclerView.ItemDecoration itemDecoration;
    private int numSpeakers;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantLongClicked;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantTapped;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StageCallAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function1, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function12, Function1<? super String, Unit> function13, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function2, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function22) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(function1, "onMediaParticipantTapped");
        Intrinsics3.checkNotNullParameter(function12, "onMediaParticipantLongClicked");
        Intrinsics3.checkNotNullParameter(function13, "onWatchStreamClicked");
        Intrinsics3.checkNotNullParameter(function2, "onStreamQualityIndicatorShown");
        Intrinsics3.checkNotNullParameter(function22, "onStreamQualityIndicatorClick");
        this.fragmentManager = fragmentManager;
        this.onMediaParticipantTapped = function1;
        this.onMediaParticipantLongClicked = function12;
        this.onWatchStreamClicked = function13;
        this.onStreamQualityIndicatorShown = function2;
        this.onStreamQualityIndicatorClick = function22;
        this.spanSizeLookup = new StageCallAdapter3(this);
        this.itemDecoration = new StageCallAdapter2(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.getInternalData();
    }

    public static final /* synthetic */ int access$getNumSpeakers$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.numSpeakers;
    }

    public static final /* synthetic */ void access$setNumSpeakers$p(StageCallAdapter stageCallAdapter, int i) {
        stageCallAdapter.numSpeakers = i;
    }

    private final void openWidgetUserSheet(long userId, Channel channel) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channel.getId()), this.fragmentManager, Long.valueOf(channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantLongClicked() {
        return this.onMediaParticipantLongClicked;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantTapped() {
        return this.onMediaParticipantTapped;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorClick() {
        return this.onStreamQualityIndicatorClick;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorShown() {
        return this.onStreamQualityIndicatorShown;
    }

    public final Function1<String, Unit> getOnWatchStreamClicked() {
        return this.onWatchStreamClicked;
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onItemClick$app_productionGoogleRelease(StageCallItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof StageCallItem2) {
            StageCallItem2 stageCallItem2 = (StageCallItem2) item;
            openWidgetUserSheet(stageCallItem2.getVoiceUser().getUser().getId(), stageCallItem2.getChannel());
        }
    }

    public final void setData(List<? extends StageCallItem> data, int numSpeakers) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.numSpeakers = numSpeakers;
        super.setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<StageCallAdapter, StageCallItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new StageCallViewHolder4(this);
            case 1:
                return new StageCallViewHolder8(this);
            case 2:
                return new StageCallViewHolder2(this);
            case 3:
                return new StageCallViewHolder3(this);
            case 4:
                return new StageCallViewHolder5(this);
            case 5:
                return new StageCallViewHolder7(this);
            case 6:
                return new StageCallViewHolder6(this);
            default:
                throw new IllegalStateException(outline.m871q("Invalid view type: ", viewType));
        }
    }
}
