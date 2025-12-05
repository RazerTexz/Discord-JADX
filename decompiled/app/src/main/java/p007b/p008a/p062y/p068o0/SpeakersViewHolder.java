package p007b.p008a.p062y.p068o0;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.WidgetDiscoveryStageCardSpeakerBinding;
import p007b.p008a.p062y.p068o0.SpeakersItem;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SpeakersViewHolder.kt */
/* renamed from: b.a.y.o0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpeakersViewHolder extends MGRecyclerViewHolder<SpeakersAdapter, SpeakersItem> {

    /* renamed from: a */
    public final WidgetDiscoveryStageCardSpeakerBinding f2052a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersViewHolder(SpeakersAdapter speakersAdapter) {
        super(C5419R.layout.widget_discovery_stage_card_speaker, speakersAdapter);
        Intrinsics3.checkNotNullParameter(speakersAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.discovery_stage_card_speaker_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.discovery_stage_card_speaker_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.discovery_stage_card_speaker_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.discovery_stage_card_speaker_name);
            if (textView != null) {
                WidgetDiscoveryStageCardSpeakerBinding widgetDiscoveryStageCardSpeakerBinding = new WidgetDiscoveryStageCardSpeakerBinding((LinearLayout) view, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetDiscoveryStageCardSpeakerBinding, "WidgetDiscoveryStageCard…kerBinding.bind(itemView)");
                this.f2052a = widgetDiscoveryStageCardSpeakerBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, SpeakersItem speakersItem) throws Resources.NotFoundException {
        SpeakersItem speakersItem2 = speakersItem;
        Intrinsics3.checkNotNullParameter(speakersItem2, "data");
        super.onConfigure(i, speakersItem2);
        SpeakersItem.a aVar = (SpeakersItem.a) speakersItem2;
        SimpleDraweeView simpleDraweeView = this.f2052a.f878b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.discoveryStageCardSpeakerAvatar");
        SimpleDraweeViewExtensions.setAvatar$default(simpleDraweeView, aVar.f2057l, false, C5419R.dimen.avatar_size_medium, aVar.f2058m, 2, null);
        TextView textView = this.f2052a.f879c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discoveryStageCardSpeakerName");
        textView.setText(aVar.f2059n);
    }
}
