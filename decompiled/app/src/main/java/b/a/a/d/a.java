package b.a.a.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.u1;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: UserActionsDialog.kt */
/* loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/UserActionsDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* renamed from: n, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.d.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0021a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public ViewOnClickListenerC0021a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                a aVar = (a) this.k;
                KProperty[] kPropertyArr = a.j;
                b.a.a.d.f fVarH = aVar.h();
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(fVarH.m, "User Profile", fVarH.l, 2, null, null, 24, null), false, 1, null), fVarH, null, 2, null), b.a.a.d.f.class, (Context) null, (Function1) null, new b.a.a.d.h(fVarH), (Function0) null, (Function0) null, new b.a.a.d.g(fVarH), 54, (Object) null);
                return;
            }
            if (i == 1) {
                a aVar2 = (a) this.k;
                KProperty[] kPropertyArr2 = a.j;
                aVar2.h().removeRelationship(R.string.user_has_been_unblocked);
            } else {
                if (i != 2) {
                    throw null;
                }
                a aVar3 = (a) this.k;
                KProperty[] kPropertyArr3 = a.j;
                aVar3.h().removeRelationship(R.string.friend_has_been_deleted);
            }
        }
    }

    /* compiled from: UserActionsDialog.kt */
    /* renamed from: b.a.a.d.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class c extends k implements Function1<View, u1> {
        public static final c j = new c();

        public c() {
            super(1, u1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/UserActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public u1 invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.user_actions_dialog_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.user_actions_dialog_avatar);
            if (simpleDraweeView != null) {
                i = R.id.user_actions_dialog_block_item;
                TextView textView = (TextView) view2.findViewById(R.id.user_actions_dialog_block_item);
                if (textView != null) {
                    i = R.id.user_actions_dialog_remove_friend_item;
                    TextView textView2 = (TextView) view2.findViewById(R.id.user_actions_dialog_remove_friend_item);
                    if (textView2 != null) {
                        i = R.id.user_actions_dialog_unblock_item;
                        TextView textView3 = (TextView) view2.findViewById(R.id.user_actions_dialog_unblock_item);
                        if (textView3 != null) {
                            i = R.id.user_actions_dialog_user_name;
                            TextView textView4 = (TextView) view2.findViewById(R.id.user_actions_dialog_user_name);
                            if (textView4 != null) {
                                return new u1((LinearLayout) view2, simpleDraweeView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: ObservableExtensions.kt */
    public static final class d<T, R> implements j0.k.b<Object, Boolean> {
        public static final d j = new d();

        @Override // j0.k.b
        public Boolean call(Object obj) {
            return Boolean.valueOf(obj instanceof f.d.a);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    public static final class e<T, R> implements j0.k.b<Object, T> {
        public static final e j = new e();

        @Override // j0.k.b
        public final T call(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.dialogs.useractions.UserActionsDialogViewModel.ViewState.Loaded");
            return (T) ((f.d.a) obj);
        }
    }

    /* compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class f extends k implements Function1<f.d.a, Unit> {
        public f(a aVar) {
            super(1, aVar, a.class, "updateView", "updateView(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(f.d.a aVar) {
            f.d.a aVar2 = aVar;
            m.checkNotNullParameter(aVar2, "p1");
            a aVar3 = (a) this.receiver;
            KProperty[] kPropertyArr = a.j;
            SimpleDraweeView simpleDraweeView = aVar3.g().f209b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.userActionsDialogAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(aVar2.a, true, null, 4, null), 0, (Function1) null, aVar3.imagesChangeDetector, 12, (Object) null);
            TextView textView = aVar3.g().f;
            m.checkNotNullExpressionValue(textView, "binding.userActionsDialogUserName");
            User user = aVar2.a;
            String str = aVar2.f47b;
            Context contextRequireContext = aVar3.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, str, contextRequireContext, R.attr.colorHeaderPrimary, R.attr.font_primary_semibold, R.integer.uikit_textsize_large_sp, R.attr.colorTextMuted, R.attr.font_primary_normal, R.integer.uikit_textsize_large_sp));
            TextView textView2 = aVar3.g().c;
            m.checkNotNullExpressionValue(textView2, "binding.userActionsDialogBlockItem");
            textView2.setVisibility(aVar2.c ? 0 : 8);
            TextView textView3 = aVar3.g().e;
            m.checkNotNullExpressionValue(textView3, "binding.userActionsDialogUnblockItem");
            textView3.setVisibility(aVar2.d ? 0 : 8);
            TextView textView4 = aVar3.g().d;
            m.checkNotNullExpressionValue(textView4, "binding.userActionsDialogRemoveFriendItem");
            textView4.setVisibility(aVar2.e ? 0 : 8);
            return Unit.a;
        }
    }

    /* compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class g extends k implements Function1<f.b, Unit> {
        public g(a aVar) {
            super(1, aVar, a.class, "handleEvent", "handleEvent(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(f.b bVar) {
            f.b bVar2 = bVar;
            m.checkNotNullParameter(bVar2, "p1");
            a aVar = (a) this.receiver;
            KProperty[] kPropertyArr = a.j;
            Objects.requireNonNull(aVar);
            if (bVar2 instanceof f.b.C0022b) {
                b.a.d.m.i(aVar, ((f.b.C0022b) bVar2).a, 0, 4);
                aVar.dismiss();
            } else if (bVar2 instanceof f.b.a) {
                b.a.d.m.i(aVar, ((f.b.a) bVar2).a, 0, 4);
                aVar.dismiss();
            }
            return Unit.a;
        }
    }

    /* compiled from: UserActionsDialog.kt */
    public static final class h extends o implements Function0<b.a.a.d.f> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public b.a.a.d.f invoke() {
            a aVar = a.this;
            KProperty[] kPropertyArr = a.j;
            return new b.a.a.d.f(aVar.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", 0L), a.this.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, 12);
        }
    }

    public a() {
        super(R.layout.user_actions_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
        h hVar = new h();
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(b.a.a.d.f.class), new defpackage.k(4, g0Var), new i0(hVar));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
    }

    public final u1 g() {
        return (u1) this.binding.getValue((Fragment) this, j[0]);
    }

    public final b.a.a.d.f h() {
        return (b.a.a.d.f) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().c.setOnClickListener(new ViewOnClickListenerC0021a(0, this));
        g().e.setOnClickListener(new ViewOnClickListenerC0021a(1, this));
        g().d.setOnClickListener(new ViewOnClickListenerC0021a(2, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = h().observeViewState().y(d.j).G(e.j);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new f(this), 62, (Object) null);
        PublishSubject<f.b> publishSubject = h().k;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(publishSubject, this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new g(this), 62, (Object) null);
    }
}
