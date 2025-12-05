package p007b.p008a.p062y.p068o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import p007b.p008a.p025i.WidgetDiscoveryOtherSpeakersCountBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.p068o0.SpeakersItem;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SpeakersViewHolder.kt */
/* renamed from: b.a.y.o0.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpeakersViewHolder2 extends MGRecyclerViewHolder<SpeakersAdapter, SpeakersItem> {

    /* renamed from: a */
    public final WidgetDiscoveryOtherSpeakersCountBinding f2053a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersViewHolder2(SpeakersAdapter speakersAdapter) {
        super(C5419R.layout.widget_discovery_other_speakers_count, speakersAdapter);
        Intrinsics3.checkNotNullParameter(speakersAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.other_speakers_count_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.other_speakers_count_text)));
        }
        WidgetDiscoveryOtherSpeakersCountBinding widgetDiscoveryOtherSpeakersCountBinding = new WidgetDiscoveryOtherSpeakersCountBinding((LinearLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetDiscoveryOtherSpeakersCountBinding, "WidgetDiscoveryOtherSpea…untBinding.bind(itemView)");
        this.f2053a = widgetDiscoveryOtherSpeakersCountBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, SpeakersItem speakersItem) {
        SpeakersItem speakersItem2 = speakersItem;
        Intrinsics3.checkNotNullParameter(speakersItem2, "data");
        super.onConfigure(i, speakersItem2);
        int i2 = ((SpeakersItem.b) speakersItem2).f2061l;
        TextView textView = this.f2053a.f848b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.otherSpeakersCountText");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        textView.setText(FormatUtils.m218j(view, C5419R.string.discovery_speaker_count, new Object[]{StringResourceUtils.getI18nPluralString(outline.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.discovery_speaker_count_speakersCount, i2, Integer.valueOf(i2))}, null, 4));
    }
}
