package com.discord.widgets.voice.fullscreen.stage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelSpeakerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.calls.StageCallSpeakerView;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p062y.p063j0.StageCallSpeakerView2;
import p007b.p008a.p062y.p063j0.StageCallSpeakerView3;
import p007b.p008a.p062y.p063j0.StageCallSpeakerView4;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.SpeakerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallViewHolder8 extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder8(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_speaker, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        StageCallSpeakerView stageCallSpeakerView = (StageCallSpeakerView) view.findViewById(C5419R.id.stage_channel_speaker_container);
        if (stageCallSpeakerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.stage_channel_speaker_container)));
        }
        WidgetStageChannelSpeakerBinding widgetStageChannelSpeakerBinding = new WidgetStageChannelSpeakerBinding((ConstraintLayout) view, stageCallSpeakerView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelSpeakerBinding, "WidgetStageChannelSpeakerBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        int dimensionPixelSize;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.SpeakerItem speakerItem = (StageCallItem.SpeakerItem) data;
        StageCallSpeakerView stageCallSpeakerView = this.binding.f18159b;
        Intrinsics3.checkNotNullExpressionValue(stageCallSpeakerView, "binding.stageChannelSpeakerContainer");
        ViewGroup.LayoutParams layoutParams = stageCallSpeakerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int speakersPerRow = speakerItem.getSpeakersPerRow();
        if (speakersPerRow == 1) {
            dimensionPixelSize = 0;
        } else if (speakersPerRow != 2) {
            ConstraintLayout constraintLayout = this.binding.f18158a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            dimensionPixelSize = constraintLayout.getResources().getDimensionPixelSize(C5419R.dimen.speaker_height_three_up);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.f18158a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            dimensionPixelSize = constraintLayout2.getResources().getDimensionPixelSize(C5419R.dimen.speaker_height_two_up);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = dimensionPixelSize;
        layoutParams2.dimensionRatio = speakerItem.getSpeakersPerRow() != 1 ? null : "H,16:9";
        stageCallSpeakerView.setLayoutParams(layoutParams2);
        StageCallSpeakerView stageCallSpeakerView2 = this.binding.f18159b;
        StoreVoiceParticipants.VoiceUser voiceUser = speakerItem.getVoiceUser();
        boolean zIsModerator = speakerItem.isModerator();
        boolean zIsBlocked = speakerItem.isBlocked();
        Objects.requireNonNull(stageCallSpeakerView2);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        String colorId = RepresentativeColors2.getColorId(voiceUser.getUser());
        stageCallSpeakerView2.binding.f1349b.setOnBitmapLoadedListener(new StageCallSpeakerView2(colorId));
        stageCallSpeakerView2.binding.f1355h.setPulsing(voiceUser.getIsSpeaking());
        stageCallSpeakerView2.binding.f1349b.m8570a(voiceUser, C5419R.dimen.avatar_size_hero);
        stageCallSpeakerView2.binding.f1349b.setRingMargin(DimenUtils.dpToPixels(2));
        ImageView imageView = stageCallSpeakerView2.binding.f1353f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stageChannelSpeakerMuteIndicator");
        imageView.setVisibility(voiceUser.getIsMuted() && !voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView2 = stageCallSpeakerView2.binding.f1351d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.stageChannelSpeakerDeafenIndicator");
        imageView2.setVisibility(voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView3 = stageCallSpeakerView2.binding.f1352e;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.stageChannelSpeakerModIndicator");
        imageView3.setVisibility(zIsModerator ? 0 : 8);
        TextView textView = stageCallSpeakerView2.binding.f1354g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelSpeakerName");
        textView.setText(voiceUser.getDisplayName());
        ImageView imageView4 = stageCallSpeakerView2.binding.f1350c;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.stageChannelSpeakerBlocked");
        imageView4.setVisibility(zIsBlocked ? 0 : 8);
        Subscription subscription = stageCallSpeakerView2.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<R> observableM11083G = RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(colorId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "UserRepresentativeColors…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableM11100Z, StageCallSpeakerView.class, (Context) null, new StageCallSpeakerView3(stageCallSpeakerView2), (Function1) null, (Function0) null, (Function0) null, new StageCallSpeakerView4(stageCallSpeakerView2), 58, (Object) null);
    }
}
