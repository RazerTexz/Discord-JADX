package b.a.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.x;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e6;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import d0.z.d.a0;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.subjects.PublishSubject;

/* compiled from: WidgetUrgentMessageDialog.kt */
/* loaded from: classes.dex */
public final class t extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(t.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* compiled from: WidgetUrgentMessageDialog.kt */
    /* renamed from: b.a.a.t$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, e6> {
        public static final b j = new b();

        public b() {
            super(1, e6.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public e6 invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.view_dialog_confirmation_confirm;
            LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.view_dialog_confirmation_confirm);
            if (loadingButton != null) {
                i = R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view2.findViewById(R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view2.findViewById(R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new e6((LinearLayout) view2, loadingButton, textView, textView2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    public static final class c extends d0.z.d.o implements Function1<x.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(x.d dVar) {
            x.d dVar2 = dVar;
            d0.z.d.m.checkNotNullParameter(dVar2, "viewState");
            t tVar = t.this;
            KProperty[] kPropertyArr = t.j;
            TextView textView = tVar.g().c;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
            textView.setText(tVar.getString(R.string.system_dm_urgent_message_modal_header));
            TextView textView2 = tVar.g().d;
            d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
            textView2.setText(tVar.getString(R.string.system_dm_urgent_message_modal_body));
            tVar.g().f108b.setText(tVar.getString(R.string.okay));
            tVar.g().f108b.setIsLoading(dVar2.f50b);
            tVar.g().f108b.setOnClickListener(new u(tVar));
            return Unit.a;
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    public static final class d extends d0.z.d.o implements Function1<x.b, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(x.b bVar) {
            x.b bVar2 = bVar;
            d0.z.d.m.checkNotNullParameter(bVar2, "event");
            t tVar = t.this;
            KProperty[] kPropertyArr = t.j;
            Objects.requireNonNull(tVar);
            if (d0.z.d.m.areEqual(bVar2, x.b.a.a)) {
                tVar.dismiss();
            } else {
                if (!d0.z.d.m.areEqual(bVar2, x.b.C0028b.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                b.a.d.m.g(tVar.getContext(), R.string.internal_server_error, 0, null, 12);
            }
            return Unit.a;
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    public static final class e extends d0.z.d.o implements Function0<x> {
        public static final e j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public x invoke() {
            return new x(null, null, null, 7);
        }
    }

    public t() {
        super(R.layout.widget_urgent_message_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
        e eVar = e.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(x.class), new defpackage.k(1, g0Var), new i0(eVar));
    }

    public final e6 g() {
        return (e6) this.binding.getValue((Fragment) this, j[0]);
    }

    public final x h() {
        return (x) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreStream.INSTANCE.getNotices().markDialogSeen("URGENT_MESSAGE_DIALOG");
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(h().observeViewState(), this, null, 2, null), t.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new c(), 62, (Object) null);
        PublishSubject<x.b> publishSubject = h().k;
        d0.z.d.m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(publishSubject, this, null, 2, null), t.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
