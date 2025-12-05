package p007b.p008a.p062y;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.OverlayVoiceChannelSelectorBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* renamed from: b.a.y.z, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayVoiceSelectorBubbleDialog3 extends OverlayAppDialog2 implements AppComponent {

    /* renamed from: A */
    public final WidgetGlobalSearchAdapter f2077A;

    /* renamed from: B */
    public final BehaviorSubject<String> f2078B;

    /* renamed from: C */
    public String f2079C;

    /* renamed from: z */
    public OverlayVoiceChannelSelectorBinding f2080z;

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    /* renamed from: b.a.y.z$a */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OverlayVoiceSelectorBubbleDialog3.this.m387g();
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    /* renamed from: b.a.y.z$b */
    public static final class b extends Lambda implements Function1<Editable, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            Intrinsics3.checkNotNullParameter(editable2, "editable");
            OverlayVoiceSelectorBubbleDialog3.this.f2078B.onNext(editable2.toString());
            return Unit.f27425a;
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    /* renamed from: b.a.y.z$c */
    public static final class c<T, R> implements Func1<String, String> {

        /* renamed from: j */
        public static final c f2082j = new c();

        @Override // p637j0.p641k.Func1
        public String call(String str) {
            return '!' + str;
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    /* renamed from: b.a.y.z$d */
    public static final class d extends Lambda implements Function1<WidgetGlobalSearchModel, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            WidgetGlobalSearchModel widgetGlobalSearchModel2 = widgetGlobalSearchModel;
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchModel2, "it");
            OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3 = OverlayVoiceSelectorBubbleDialog3.this;
            TextView textView = overlayVoiceSelectorBubbleDialog3.f2080z.f699d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyResults");
            textView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ? 0 : 8);
            RecyclerView recyclerView = overlayVoiceSelectorBubbleDialog3.f2080z.f701f;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
            recyclerView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ^ true ? 0 : 8);
            WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = overlayVoiceSelectorBubbleDialog3.f2077A;
            widgetGlobalSearchAdapter.setOnUpdated(new OverlayVoiceSelectorBubbleDialog(overlayVoiceSelectorBubbleDialog3, widgetGlobalSearchModel2));
            List<WidgetGlobalSearchModel.ItemDataPayload> data = widgetGlobalSearchModel2.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) obj).getChannel();
                if (channel != null && ChannelUtils.m7675J(channel)) {
                    arrayList.add(obj);
                }
            }
            widgetGlobalSearchAdapter.setData(arrayList);
            widgetGlobalSearchAdapter.setOnSelectedListener(new OverlayVoiceSelectorBubbleDialog2(overlayVoiceSelectorBubbleDialog3, widgetGlobalSearchModel2));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceSelectorBubbleDialog3(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        getWindowLayoutParams().flags &= -9;
        OverlayVoiceChannelSelectorBinding overlayVoiceChannelSelectorBindingM196a = OverlayVoiceChannelSelectorBinding.m196a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceChannelSelectorBindingM196a, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f2080z = overlayVoiceChannelSelectorBindingM196a;
        RecyclerView recyclerView = this.f2080z.f701f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        this.f2077A = new WidgetGlobalSearchAdapter(recyclerView);
        this.f2078B = BehaviorSubject.m11130l0("");
    }

    @Override // p007b.p008a.p062y.OverlayAppDialog2
    public Animator getClosingAnimator() throws Resources.NotFoundException {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.f2080z.f698c);
        Intrinsics3.checkNotNullExpressionValue(animatorLoadAnimator, "AnimatorInflater.loadAni…binding.dialogCard)\n    }");
        return animatorLoadAnimator;
    }

    /* renamed from: h */
    public final void m393h() {
        this.f2080z.f697b.setOnClickListener(new a());
        TextInputLayout textInputLayout = this.f2080z.f700e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.overlayChannelSearch");
        ViewExtensions.setText(textInputLayout, this.f2079C);
        TextInputLayout textInputLayout2 = this.f2080z.f700e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.overlayChannelSearch");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(null, null, new b(), 3, null));
        }
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.f2077A;
        RecyclerView recyclerView = this.f2080z.f701f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        widgetGlobalSearchAdapter.setRecycler(recyclerView);
        MGRecyclerAdapter.INSTANCE.configure(this.f2077A);
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        Observable<String> observableM11083G = this.f2078B.m11083G(c.f2082j);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filterPublisher.map { \"!$it\" }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8519ui(companion.getForNav(observableM11083G), this, this.f2077A), OverlayVoiceSelectorBubbleDialog3.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        m393h();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5419R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.f2080z.f698c);
        animatorLoadAnimator.start();
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getUnsubscribeSignal().onNext(null);
        removeAllViewsInLayout();
        OverlayVoiceChannelSelectorBinding overlayVoiceChannelSelectorBindingM196a = OverlayVoiceChannelSelectorBinding.m196a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceChannelSelectorBindingM196a, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f2080z = overlayVoiceChannelSelectorBindingM196a;
        m393h();
    }
}
