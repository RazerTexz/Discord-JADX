package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelSpeakerMediaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: StageCallViewHolder.kt */
/* loaded from: classes.dex */
public final class MediaViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerMediaBinding binding;

    /* compiled from: StageCallViewHolder.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        public AnonymousClass1(StageCallItem.MediaItem mediaItem) {
            this.$item = mediaItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MediaViewHolder.access$getAdapter$p(MediaViewHolder.this).getOnMediaParticipantTapped().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* compiled from: StageCallViewHolder.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<View, Unit> {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StageCallItem.MediaItem mediaItem) {
            super(1);
            this.$item = mediaItem;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            MediaViewHolder.access$getAdapter$p(MediaViewHolder.this).getOnMediaParticipantLongClicked().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaViewHolder(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_speaker_media, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(R.id.stage_channel_media_speaker_container);
        if (videoCallParticipantView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_media_speaker_container)));
        }
        WidgetStageChannelSpeakerMediaBinding widgetStageChannelSpeakerMediaBinding = new WidgetStageChannelSpeakerMediaBinding((CardView) view, videoCallParticipantView);
        m.checkNotNullExpressionValue(widgetStageChannelSpeakerMediaBinding, "WidgetStageChannelSpeake…diaBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerMediaBinding;
    }

    public static final /* synthetic */ StageCallAdapter access$getAdapter$p(MediaViewHolder mediaViewHolder) {
        return (StageCallAdapter) mediaViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        StageCallItem.MediaItem mediaItem = (StageCallItem.MediaItem) data;
        VideoCallParticipantView videoCallParticipantView = this.binding.f2655b;
        m.checkNotNullExpressionValue(videoCallParticipantView, "binding.stageChannelMediaSpeakerContainer");
        videoCallParticipantView.c(mediaItem.getParticipantData(), null, false, new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0), true);
        videoCallParticipantView.setOnWatchStreamClicked(((StageCallAdapter) this.adapter).getOnWatchStreamClicked());
        videoCallParticipantView.setOnClickListener(new AnonymousClass1(mediaItem));
        ViewExtensions.setOnLongClickListenerConsumeClick(videoCallParticipantView, new AnonymousClass2(mediaItem));
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorShown();
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorClick();
        m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        m.checkNotNullParameter(onStreamQualityIndicatorClick, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClick;
    }
}
