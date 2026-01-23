package p007b.p008a.p009a.p013d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.UserNameFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p013d.UserActionsDialogViewModel5;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.UserActionsDialogBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.a.d.a, reason: use source file name */
/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserActionsDialog extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f315j = {outline.m846d0(UserActionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/UserActionsDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: b.a.a.d.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f320j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f321k;

        public a(int i, Object obj) {
            this.f320j = i;
            this.f321k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f320j;
            if (i == 0) {
                UserActionsDialog userActionsDialog = (UserActionsDialog) this.f321k;
                KProperty[] kPropertyArr = UserActionsDialog.f315j;
                UserActionsDialogViewModel5 userActionsDialogViewModel5M125h = userActionsDialog.m125h();
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(userActionsDialogViewModel5M125h.f332m, "User Profile", userActionsDialogViewModel5M125h.f331l, 2, null, null, 24, null), false, 1, null), userActionsDialogViewModel5M125h, null, 2, null), UserActionsDialogViewModel5.class, (Context) null, (Function1) null, new UserActionsDialogViewModel7(userActionsDialogViewModel5M125h), (Function0) null, (Function0) null, new UserActionsDialogViewModel6(userActionsDialogViewModel5M125h), 54, (Object) null);
                return;
            }
            if (i == 1) {
                UserActionsDialog userActionsDialog2 = (UserActionsDialog) this.f321k;
                KProperty[] kPropertyArr2 = UserActionsDialog.f315j;
                userActionsDialog2.m125h().removeRelationship(C5419R.string.user_has_been_unblocked);
            } else {
                if (i != 2) {
                    throw null;
                }
                UserActionsDialog userActionsDialog3 = (UserActionsDialog) this.f321k;
                KProperty[] kPropertyArr3 = UserActionsDialog.f315j;
                userActionsDialog3.m125h().removeRelationship(C5419R.string.friend_has_been_deleted);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$c */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, UserActionsDialogBinding> {

        /* JADX INFO: renamed from: j */
        public static final c f322j = new c();

        public c() {
            super(1, UserActionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/UserActionsDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public UserActionsDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.user_actions_dialog_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(C5419R.id.user_actions_dialog_avatar);
            if (simpleDraweeView != null) {
                i = C5419R.id.user_actions_dialog_block_item;
                TextView textView = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_block_item);
                if (textView != null) {
                    i = C5419R.id.user_actions_dialog_remove_friend_item;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_remove_friend_item);
                    if (textView2 != null) {
                        i = C5419R.id.user_actions_dialog_unblock_item;
                        TextView textView3 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_unblock_item);
                        if (textView3 != null) {
                            i = C5419R.id.user_actions_dialog_user_name;
                            TextView textView4 = (TextView) view2.findViewById(C5419R.id.user_actions_dialog_user_name);
                            if (textView4 != null) {
                                return new UserActionsDialogBinding((LinearLayout) view2, simpleDraweeView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$d */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class d<T, R> implements Func1<Object, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final d f323j = new d();

        @Override // p637j0.p641k.Func1
        public Boolean call(Object obj) {
            return Boolean.valueOf(obj instanceof UserActionsDialogViewModel5.d.a);
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$e */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class e<T, R> implements Func1<Object, T> {

        /* JADX INFO: renamed from: j */
        public static final e f324j = new e();

        @Override // p637j0.p641k.Func1
        public final T call(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.dialogs.useractions.UserActionsDialogViewModel.ViewState.Loaded");
            return (T) ((UserActionsDialogViewModel5.d.a) obj);
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$f */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class f extends FunctionReferenceImpl implements Function1<UserActionsDialogViewModel5.d.a, Unit> {
        public f(UserActionsDialog userActionsDialog) {
            super(1, userActionsDialog, UserActionsDialog.class, "updateView", "updateView(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UserActionsDialogViewModel5.d.a aVar) {
            UserActionsDialogViewModel5.d.a aVar2 = aVar;
            Intrinsics3.checkNotNullParameter(aVar2, "p1");
            UserActionsDialog userActionsDialog = (UserActionsDialog) this.receiver;
            KProperty[] kPropertyArr = UserActionsDialog.f315j;
            SimpleDraweeView simpleDraweeView = userActionsDialog.m124g().f1281b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userActionsDialogAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(aVar2.f338a, true, null, 4, null), 0, (Function1) null, userActionsDialog.imagesChangeDetector, 12, (Object) null);
            TextView textView = userActionsDialog.m124g().f1285f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userActionsDialogUserName");
            User user = aVar2.f338a;
            String str = aVar2.f339b;
            Context contextRequireContext = userActionsDialog.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(UserNameFormatter.getSpannableForUserNameWithDiscrim(user, str, contextRequireContext, C5419R.attr.colorHeaderPrimary, C5419R.attr.font_primary_semibold, C5419R.integer.uikit_textsize_large_sp, C5419R.attr.colorTextMuted, C5419R.attr.font_primary_normal, C5419R.integer.uikit_textsize_large_sp));
            TextView textView2 = userActionsDialog.m124g().f1282c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userActionsDialogBlockItem");
            textView2.setVisibility(aVar2.f340c ? 0 : 8);
            TextView textView3 = userActionsDialog.m124g().f1284e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userActionsDialogUnblockItem");
            textView3.setVisibility(aVar2.f341d ? 0 : 8);
            TextView textView4 = userActionsDialog.m124g().f1283d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.userActionsDialogRemoveFriendItem");
            textView4.setVisibility(aVar2.f342e ? 0 : 8);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$g */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final /* synthetic */ class g extends FunctionReferenceImpl implements Function1<UserActionsDialogViewModel5.b, Unit> {
        public g(UserActionsDialog userActionsDialog) {
            super(1, userActionsDialog, UserActionsDialog.class, "handleEvent", "handleEvent(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UserActionsDialogViewModel5.b bVar) {
            UserActionsDialogViewModel5.b bVar2 = bVar;
            Intrinsics3.checkNotNullParameter(bVar2, "p1");
            UserActionsDialog userActionsDialog = (UserActionsDialog) this.receiver;
            KProperty[] kPropertyArr = UserActionsDialog.f315j;
            Objects.requireNonNull(userActionsDialog);
            if (bVar2 instanceof UserActionsDialogViewModel5.b.C13207b) {
                AppToast.m171i(userActionsDialog, ((UserActionsDialogViewModel5.b.C13207b) bVar2).f334a, 0, 4);
                userActionsDialog.dismiss();
            } else if (bVar2 instanceof UserActionsDialogViewModel5.b.a) {
                AppToast.m171i(userActionsDialog, ((UserActionsDialogViewModel5.b.a) bVar2).f333a, 0, 4);
                userActionsDialog.dismiss();
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.d.a$h */
    /* JADX INFO: compiled from: UserActionsDialog.kt */
    public static final class h extends Lambda implements Function0<UserActionsDialogViewModel5> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public UserActionsDialogViewModel5 invoke() {
            UserActionsDialog userActionsDialog = UserActionsDialog.this;
            KProperty[] kPropertyArr = UserActionsDialog.f315j;
            return new UserActionsDialogViewModel5(userActionsDialog.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", 0L), UserActionsDialog.this.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, 12);
        }
    }

    public UserActionsDialog() {
        super(C5419R.layout.user_actions_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f322j, null, 2, null);
        h hVar = new h();
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserActionsDialogViewModel5.class), new C12788k(4, appViewModelDelegates3), new AppViewModelDelegates5(hVar));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
    }

    /* JADX INFO: renamed from: g */
    public final UserActionsDialogBinding m124g() {
        return (UserActionsDialogBinding) this.binding.getValue((Fragment) this, f315j[0]);
    }

    /* JADX INFO: renamed from: h */
    public final UserActionsDialogViewModel5 m125h() {
        return (UserActionsDialogViewModel5) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m124g().f1282c.setOnClickListener(new a(0, this));
        m124g().f1284e.setOnClickListener(new a(1, this));
        m124g().f1283d.setOnClickListener(new a(2, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableM11083G = m125h().observeViewState().m11118y(d.f323j).m11083G(e.f324j);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), UserActionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new f(this), 62, (Object) null);
        PublishSubject<UserActionsDialogViewModel5.b> publishSubject = m125h().f330k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(publishSubject, this, null, 2, null), UserActionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new g(this), 62, (Object) null);
    }
}
