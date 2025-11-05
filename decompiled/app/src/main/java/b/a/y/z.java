package b.a.y;

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
import b.a.i.b1;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
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
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* loaded from: classes2.dex */
public final class z extends l implements AppComponent {
    public final WidgetGlobalSearchAdapter A;
    public final BehaviorSubject<String> B;
    public String C;

    /* renamed from: z, reason: collision with root package name */
    public b1 f318z;

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            z.this.g();
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class b extends d0.z.d.o implements Function1<Editable, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            d0.z.d.m.checkNotNullParameter(editable2, "editable");
            z.this.B.onNext(editable2.toString());
            return Unit.a;
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class c<T, R> implements j0.k.b<String, String> {
        public static final c j = new c();

        @Override // j0.k.b
        public String call(String str) {
            return '!' + str;
        }
    }

    /* compiled from: OverlayVoiceSelectorBubbleDialog.kt */
    public static final class d extends d0.z.d.o implements Function1<WidgetGlobalSearchModel, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            WidgetGlobalSearchModel widgetGlobalSearchModel2 = widgetGlobalSearchModel;
            d0.z.d.m.checkNotNullParameter(widgetGlobalSearchModel2, "it");
            z zVar = z.this;
            TextView textView = zVar.f318z.d;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.emptyResults");
            textView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ? 0 : 8);
            RecyclerView recyclerView = zVar.f318z.f;
            d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
            recyclerView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ^ true ? 0 : 8);
            WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = zVar.A;
            widgetGlobalSearchAdapter.setOnUpdated(new x(zVar, widgetGlobalSearchModel2));
            List<WidgetGlobalSearchModel.ItemDataPayload> data = widgetGlobalSearchModel2.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) obj).getChannel();
                if (channel != null && ChannelUtils.J(channel)) {
                    arrayList.add(obj);
                }
            }
            widgetGlobalSearchAdapter.setData(arrayList);
            widgetGlobalSearchAdapter.setOnSelectedListener(new y(zVar, widgetGlobalSearchModel2));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
        super(context);
        d0.z.d.m.checkNotNullParameter(context, "context");
        getWindowLayoutParams().flags &= -9;
        b1 b1VarA = b1.a(LayoutInflater.from(getContext()), this, true);
        d0.z.d.m.checkNotNullExpressionValue(b1VarA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = b1VarA;
        RecyclerView recyclerView = this.f318z.f;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        this.A = new WidgetGlobalSearchAdapter(recyclerView);
        this.B = BehaviorSubject.l0("");
    }

    @Override // b.a.y.l
    public Animator getClosingAnimator() throws Resources.NotFoundException {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.f318z.c);
        d0.z.d.m.checkNotNullExpressionValue(animatorLoadAnimator, "AnimatorInflater.loadAni…binding.dialogCard)\n    }");
        return animatorLoadAnimator;
    }

    public final void h() {
        this.f318z.f82b.setOnClickListener(new a());
        TextInputLayout textInputLayout = this.f318z.e;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.overlayChannelSearch");
        ViewExtensions.setText(textInputLayout, this.C);
        TextInputLayout textInputLayout2 = this.f318z.e;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout2, "binding.overlayChannelSearch");
        EditText editText = textInputLayout2.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher(null, null, new b(), 3, null));
        }
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.A;
        RecyclerView recyclerView = this.f318z.f;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        widgetGlobalSearchAdapter.setRecycler(recyclerView);
        MGRecyclerAdapter.INSTANCE.configure(this.A);
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        Observable<String> observableG = this.B.G(c.j);
        d0.z.d.m.checkNotNullExpressionValue(observableG, "filterPublisher.map { \"!$it\" }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(companion.getForNav(observableG), this, this.A), z.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        h();
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.f318z.c);
        animatorLoadAnimator.start();
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getUnsubscribeSignal().onNext(null);
        removeAllViewsInLayout();
        b1 b1VarA = b1.a(LayoutInflater.from(getContext()), this, true);
        d0.z.d.m.checkNotNullExpressionValue(b1VarA, "OverlayVoiceChannelSelec…rom(context), this, true)");
        this.f318z = b1VarA;
        h();
    }
}
