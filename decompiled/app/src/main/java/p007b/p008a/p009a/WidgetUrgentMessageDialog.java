package p007b.p008a.p009a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.WidgetUrgentMessageDialogViewModel3;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.WidgetUrgentMessageDialogBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetUrgentMessageDialog.kt */
/* renamed from: b.a.a.t, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUrgentMessageDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f438j = {outline.m846d0(WidgetUrgentMessageDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0)};

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
    /* renamed from: b.a.a.t$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetUrgentMessageDialogBinding> {

        /* renamed from: j */
        public static final b f442j = new b();

        public b() {
            super(1, WidgetUrgentMessageDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetUrgentMessageDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.view_dialog_confirmation_confirm;
            LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.view_dialog_confirmation_confirm);
            if (loadingButton != null) {
                i = C5419R.id.view_dialog_confirmation_header;
                TextView textView = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_header);
                if (textView != null) {
                    i = C5419R.id.view_dialog_confirmation_text;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.view_dialog_confirmation_text);
                    if (textView2 != null) {
                        return new WidgetUrgentMessageDialogBinding((LinearLayout) view2, loadingButton, textView, textView2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    /* renamed from: b.a.a.t$c */
    public static final class c extends Lambda implements Function1<WidgetUrgentMessageDialogViewModel3.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetUrgentMessageDialogViewModel3.d dVar) {
            WidgetUrgentMessageDialogViewModel3.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "viewState");
            WidgetUrgentMessageDialog widgetUrgentMessageDialog = WidgetUrgentMessageDialog.this;
            KProperty[] kPropertyArr = WidgetUrgentMessageDialog.f438j;
            TextView textView = widgetUrgentMessageDialog.m145g().f825c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
            textView.setText(widgetUrgentMessageDialog.getString(C5419R.string.system_dm_urgent_message_modal_header));
            TextView textView2 = widgetUrgentMessageDialog.m145g().f826d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
            textView2.setText(widgetUrgentMessageDialog.getString(C5419R.string.system_dm_urgent_message_modal_body));
            widgetUrgentMessageDialog.m145g().f824b.setText(widgetUrgentMessageDialog.getString(C5419R.string.okay));
            widgetUrgentMessageDialog.m145g().f824b.setIsLoading(dVar2.f453b);
            widgetUrgentMessageDialog.m145g().f824b.setOnClickListener(new WidgetUrgentMessageDialog2(widgetUrgentMessageDialog));
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    /* renamed from: b.a.a.t$d */
    public static final class d extends Lambda implements Function1<WidgetUrgentMessageDialogViewModel3.b, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WidgetUrgentMessageDialogViewModel3.b bVar) {
            WidgetUrgentMessageDialogViewModel3.b bVar2 = bVar;
            Intrinsics3.checkNotNullParameter(bVar2, "event");
            WidgetUrgentMessageDialog widgetUrgentMessageDialog = WidgetUrgentMessageDialog.this;
            KProperty[] kPropertyArr = WidgetUrgentMessageDialog.f438j;
            Objects.requireNonNull(widgetUrgentMessageDialog);
            if (Intrinsics3.areEqual(bVar2, WidgetUrgentMessageDialogViewModel3.b.a.f449a)) {
                widgetUrgentMessageDialog.dismiss();
            } else {
                if (!Intrinsics3.areEqual(bVar2, WidgetUrgentMessageDialogViewModel3.b.C13210b.f450a)) {
                    throw new NoWhenBranchMatchedException();
                }
                AppToast.m169g(widgetUrgentMessageDialog.getContext(), C5419R.string.internal_server_error, 0, null, 12);
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetUrgentMessageDialog.kt */
    /* renamed from: b.a.a.t$e */
    public static final class e extends Lambda implements Function0<WidgetUrgentMessageDialogViewModel3> {

        /* renamed from: j */
        public static final e f443j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public WidgetUrgentMessageDialogViewModel3 invoke() {
            return new WidgetUrgentMessageDialogViewModel3(null, null, null, 7);
        }
    }

    public WidgetUrgentMessageDialog() {
        super(C5419R.layout.widget_urgent_message_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f442j, null, 2, null);
        e eVar = e.f443j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUrgentMessageDialogViewModel3.class), new C12788k(1, appViewModelDelegates3), new AppViewModelDelegates5(eVar));
    }

    /* renamed from: g */
    public final WidgetUrgentMessageDialogBinding m145g() {
        return (WidgetUrgentMessageDialogBinding) this.binding.getValue((Fragment) this, f438j[0]);
    }

    /* renamed from: h */
    public final WidgetUrgentMessageDialogViewModel3 m146h() {
        return (WidgetUrgentMessageDialogViewModel3) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreStream.INSTANCE.getNotices().markDialogSeen("URGENT_MESSAGE_DIALOG");
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(m146h().observeViewState(), this, null, 2, null), WidgetUrgentMessageDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new c(), 62, (Object) null);
        PublishSubject<WidgetUrgentMessageDialogViewModel3.b> publishSubject = m146h().f447k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(publishSubject, this, null, 2, null), WidgetUrgentMessageDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
