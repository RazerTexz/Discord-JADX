package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.a.y.a0;
import com.discord.R;
import com.discord.api.application.ApplicationAsset;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoCallGridViewHolder.kt */
/* loaded from: classes.dex */
public abstract class VideoCallGridViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: VideoCallGridViewHolder.kt */
    public static final class EmbeddedActivity extends VideoCallGridViewHolder {
        private final VideoCallGridItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbeddedActivity(VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding) {
            m.checkNotNullParameter(videoCallGridItemEmbeddedActivityBinding, "binding");
            FrameLayout frameLayout = videoCallGridItemEmbeddedActivityBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = videoCallGridItemEmbeddedActivityBinding;
            this.distinctChangeDetector = new MGImages.DistinctChangeDetector();
        }

        public final void configure(CallParticipant.EmbeddedActivityParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped) {
            m.checkNotNullParameter(callParticipant, "callParticipant");
            m.checkNotNullParameter(onTapped, "onTapped");
            ApplicationAsset backgroundAsset = callParticipant.getBackgroundAsset();
            String assetImage = backgroundAsset != null ? IconUtils.INSTANCE.getAssetImage(Long.valueOf(callParticipant.getApplication().getId()), String.valueOf(backgroundAsset.getId()), 1024) : null;
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.appBackgroundImage");
            simpleDraweeView.setVisibility(assetImage != null ? 0 : 8);
            View view = this.binding.e;
            m.checkNotNullExpressionValue(view, "binding.appBackgroundOverlay");
            view.setVisibility(assetImage != null ? 0 : 8);
            if (assetImage != null) {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appBackgroundImage");
                Uri uri = Uri.parse(assetImage);
                m.checkNotNullExpressionValue(uri, "Uri.parse(backgroundAssetUrl)");
                mGImages.setImage(simpleDraweeView2, uri, this.distinctChangeDetector);
            }
            this.binding.a.setOnClickListener(new VideoCallGridViewHolder$EmbeddedActivity$configure$1(onTapped, callParticipant));
            FrameLayout frameLayout = this.binding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            Resources resources = frameLayout.getResources();
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.activityPreviewTitle");
            CharSequence name = callParticipant.getEmbeddedActivity().getName();
            if (name == null) {
                m.checkNotNullExpressionValue(resources, "resources");
                name = b.i(resources, R.string.embedded_activities_unknown_activity_name, new Object[0], null, 4);
            }
            textView.setText(name);
            List<UserGuildMember> participantsInActivity = callParticipant.getParticipantsInActivity();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            m.checkNotNullParameter(participantsInActivity, "userGuildMembers");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(participantsInActivity, 10));
            for (UserGuildMember userGuildMember : participantsInActivity) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.c(new a0((String) it.next()), null));
            }
            this.binding.f2169b.setItems(arrayList2);
        }

        public final VideoCallGridItemEmbeddedActivityBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: VideoCallGridViewHolder.kt */
    public static final class UserOrStream extends VideoCallGridViewHolder {
        private final VideoCallParticipantView videoCallParticipantView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserOrStream(VideoCallParticipantView videoCallParticipantView) {
            super(videoCallParticipantView, null);
            m.checkNotNullParameter(videoCallParticipantView, "videoCallParticipantView");
            this.videoCallParticipantView = videoCallParticipantView;
        }

        public final void configure(CallParticipant.UserOrStreamParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped, Function1<? super CallParticipant, Unit> onLongClicked, Function1<? super String, Unit> onWatchStreamClicked, DisplayCutoutCompat displayCutout, int spanCount, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClicked, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
            m.checkNotNullParameter(callParticipant, "callParticipant");
            m.checkNotNullParameter(onTapped, "onTapped");
            m.checkNotNullParameter(onLongClicked, "onLongClicked");
            m.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
            m.checkNotNullParameter(onStreamQualityIndicatorShown, "onStreamQualityIndicatorShown");
            m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onStreamQualityIndicatorClicked");
            m.checkNotNullParameter(callUiInsets, "callUiInsets");
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            m.checkNotNullExpressionValue(resources, "itemView.resources");
            this.videoCallParticipantView.c(callParticipant.getParticipantData(), displayCutout, resources.getConfiguration().orientation != 2 ? getAdapterPosition() < spanCount : getAdapterPosition() % spanCount == 0, callUiInsets, controlsVisible);
            this.videoCallParticipantView.setOnWatchStreamClicked(onWatchStreamClicked);
            this.videoCallParticipantView.setOnClickListener(new VideoCallGridViewHolder$UserOrStream$configure$1(onTapped, callParticipant));
            ViewExtensions.setOnLongClickListenerConsumeClick(this.videoCallParticipantView, new VideoCallGridViewHolder$UserOrStream$configure$2(onLongClicked, callParticipant));
            VideoCallParticipantView videoCallParticipantView = this.videoCallParticipantView;
            Objects.requireNonNull(videoCallParticipantView);
            m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
            m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onClicked");
            videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
            videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClicked;
        }
    }

    private VideoCallGridViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ VideoCallGridViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
