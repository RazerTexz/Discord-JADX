package com.discord.widgets.voice.fullscreen.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.VideoCallGridItemBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: VideoCallGridAdapter.kt */
/* loaded from: classes.dex */
public final class VideoCallGridAdapter extends RecyclerView.Adapter<VideoCallGridViewHolder> {
    private static final int EMBEDDED_ACTIVITY_VIEW_TYPE = 1;
    private static final int USER_OR_STREAM_VIEW_TYPE = 0;
    private CallUiInsets callUiInsets;
    private boolean controlsVisible;
    private List<? extends CallParticipant> data;
    private DisplayCutoutCompat displayCutout;
    private int embeddedActivityParticipantsCount;
    private final Function1<CallParticipant, Unit> onParticipantLongClicked;
    private final Function1<CallParticipant, Unit> onParticipantTapped;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final int spanCount;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;

    /* compiled from: VideoCallGridAdapter.kt */
    public static final /* data */ class CallUiInsets {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public CallUiInsets(int i, int i2, int i3, int i4) {
            this.top = i;
            this.bottom = i2;
            this.left = i3;
            this.right = i4;
        }

        public static /* synthetic */ CallUiInsets copy$default(CallUiInsets callUiInsets, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = callUiInsets.top;
            }
            if ((i5 & 2) != 0) {
                i2 = callUiInsets.bottom;
            }
            if ((i5 & 4) != 0) {
                i3 = callUiInsets.left;
            }
            if ((i5 & 8) != 0) {
                i4 = callUiInsets.right;
            }
            return callUiInsets.copy(i, i2, i3, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: component2, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        /* renamed from: component3, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: component4, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        public final CallUiInsets copy(int top, int bottom, int left, int right) {
            return new CallUiInsets(top, bottom, left, right);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallUiInsets)) {
                return false;
            }
            CallUiInsets callUiInsets = (CallUiInsets) other;
            return this.top == callUiInsets.top && this.bottom == callUiInsets.bottom && this.left == callUiInsets.left && this.right == callUiInsets.right;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public int hashCode() {
            return (((((this.top * 31) + this.bottom) * 31) + this.left) * 31) + this.right;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CallUiInsets(top=");
            sbU.append(this.top);
            sbU.append(", bottom=");
            sbU.append(this.bottom);
            sbU.append(", left=");
            sbU.append(this.left);
            sbU.append(", right=");
            return outline.B(sbU, this.right, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VideoCallParticipantView.ParticipantData.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[VideoCallParticipantView.ParticipantData.Type.DEFAULT.ordinal()] = 1;
            iArr[VideoCallParticipantView.ParticipantData.Type.APPLICATION_STREAMING.ordinal()] = 2;
        }
    }

    /* compiled from: VideoCallGridAdapter.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter$getDiffUtilCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DiffUtil.Callback {
        public final /* synthetic */ List $newData;
        public final /* synthetic */ List $oldData;

        public AnonymousClass1(List list, List list2) {
            this.$oldData = list;
            this.$newData = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual((CallParticipant) this.$oldData.get(oldItemPosition), (CallParticipant) this.$newData.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(((CallParticipant) this.$oldData.get(oldItemPosition)).getId(), ((CallParticipant) this.$newData.get(newItemPosition)).getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.$newData.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.$oldData.size();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoCallGridAdapter(Function1<? super CallParticipant, Unit> function1, Function1<? super CallParticipant, Unit> function12, Function1<? super String, Unit> function13, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function2, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function22, int i) {
        Intrinsics3.checkNotNullParameter(function1, "onParticipantTapped");
        Intrinsics3.checkNotNullParameter(function12, "onParticipantLongClicked");
        Intrinsics3.checkNotNullParameter(function13, "onWatchStreamClicked");
        Intrinsics3.checkNotNullParameter(function2, "onStreamQualityIndicatorShown");
        Intrinsics3.checkNotNullParameter(function22, "onStreamQualityIndicatorClick");
        this.onParticipantTapped = function1;
        this.onParticipantLongClicked = function12;
        this.onWatchStreamClicked = function13;
        this.onStreamQualityIndicatorShown = function2;
        this.onStreamQualityIndicatorClick = function22;
        this.spanCount = i;
        this.data = Collections2.emptyList();
        this.callUiInsets = new CallUiInsets(0, 0, 0, 0);
        this.spanSizeLookup = new VideoCallGridAdapter2(this);
    }

    public static final /* synthetic */ List access$getData$p(VideoCallGridAdapter videoCallGridAdapter) {
        return videoCallGridAdapter.data;
    }

    public static final /* synthetic */ void access$setData$p(VideoCallGridAdapter videoCallGridAdapter, List list) {
        videoCallGridAdapter.data = list;
    }

    private final DiffUtil.Callback getDiffUtilCallback(List<? extends CallParticipant> oldData, List<? extends CallParticipant> newData) {
        return new AnonymousClass1(oldData, newData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (!(callParticipant instanceof CallParticipant.UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
                return ((CallParticipant.EmbeddedActivityParticipant) callParticipant).getApplication().getId();
            }
            throw new NoWhenBranchMatchedException();
        }
        VideoCallParticipantView.ParticipantData participantData = ((CallParticipant.UserOrStreamParticipant) callParticipant).getParticipantData();
        int iOrdinal = participantData.type.ordinal();
        if (iOrdinal == 0) {
            return participantData.voiceParticipant.getUser().getId();
        }
        if (iOrdinal == 1) {
            return participantData.voiceParticipant.getUser().getId() + 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (callParticipant instanceof CallParticipant.UserOrStreamParticipant) {
            return 0;
        }
        if (callParticipant instanceof CallParticipant.EmbeddedActivityParticipant) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    public final void notifyCallControlsVisibilityChanged(boolean controlsVisible) {
        this.controlsVisible = controlsVisible;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((VideoCallGridViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends CallParticipant> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(getDiffUtilCallback(this.data, data), true);
        Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(g…a, newData = data), true)");
        this.data = data;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        int i = 0;
        if (!(data instanceof Collection) || !data.isEmpty()) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                if ((((CallParticipant) it.next()) instanceof CallParticipant.EmbeddedActivityParticipant) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        this.embeddedActivityParticipantsCount = i;
    }

    public final void setDisplayCutout(DisplayCutoutCompat displayCutout, boolean isLandscape) {
        this.displayCutout = displayCutout;
        if (isLandscape) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(0, this.spanCount);
        }
    }

    public final void setInsetsForAvoidingCallUiOverlap(int top, int bottom, int left, int right) {
        this.callUiInsets = new CallUiInsets(top, bottom, left, right);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(VideoCallGridViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof VideoCallGridViewHolder.UserOrStream)) {
            if (holder instanceof VideoCallGridViewHolder.EmbeddedActivity) {
                CallParticipant callParticipant = this.data.get(position);
                Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.EmbeddedActivityParticipant");
                ((VideoCallGridViewHolder.EmbeddedActivity) holder).configure((CallParticipant.EmbeddedActivityParticipant) callParticipant, this.onParticipantTapped);
                return;
            }
            return;
        }
        VideoCallGridViewHolder.UserOrStream userOrStream = (VideoCallGridViewHolder.UserOrStream) holder;
        CallParticipant callParticipant2 = this.data.get(position);
        Objects.requireNonNull(callParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        userOrStream.configure((CallParticipant.UserOrStreamParticipant) callParticipant2, this.onParticipantTapped, this.onParticipantLongClicked, this.onWatchStreamClicked, this.displayCutout, this.spanCount, this.onStreamQualityIndicatorShown, this.onStreamQualityIndicatorClick, this.callUiInsets, this.controlsVisible);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VideoCallGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.video_call_grid_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new VideoCallGridItemBinding(videoCallParticipantView), "VideoCallGridItemBinding…rent, false\n            )");
            Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "VideoCallGridItemBinding… false\n            ).root");
            return new VideoCallGridViewHolder.UserOrStream(videoCallParticipantView);
        }
        if (viewType != 1) {
            throw new IllegalStateException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.video_call_grid_item_embedded_activity, parent, false);
        int i = R.id.activity_participant_avatars;
        PileView pileView = (PileView) viewInflate2.findViewById(R.id.activity_participant_avatars);
        if (pileView != null) {
            i = R.id.activity_preview_subtitle;
            TextView textView = (TextView) viewInflate2.findViewById(R.id.activity_preview_subtitle);
            if (textView != null) {
                i = R.id.activity_preview_title;
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.activity_preview_title);
                if (textView2 != null) {
                    i = R.id.app_background_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.app_background_image);
                    if (simpleDraweeView != null) {
                        i = R.id.app_background_overlay;
                        View viewFindViewById = viewInflate2.findViewById(R.id.app_background_overlay);
                        if (viewFindViewById != null) {
                            VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding = new VideoCallGridItemEmbeddedActivityBinding((FrameLayout) viewInflate2, pileView, textView, textView2, simpleDraweeView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(videoCallGridItemEmbeddedActivityBinding, "VideoCallGridItemEmbedde…tInflater, parent, false)");
                            return new VideoCallGridViewHolder.EmbeddedActivity(videoCallGridItemEmbeddedActivityBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
