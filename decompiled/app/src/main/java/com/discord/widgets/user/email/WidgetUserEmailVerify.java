package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyResend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailUpdate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserEmailVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> emailUpdateLauncher;

    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            AppScreen2.m156d(context, WidgetUserEmailVerify.class, WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final MeUser me;
        private final boolean verified;

        /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<Model> observableM11112r = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).m11083G(WidgetUserEmailVerify2.INSTANCE).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.email = meUser.getEmail();
            this.verified = meUser.isVerified();
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            return model.copy(meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        public final Model copy(MeUser me2) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new Model(me2);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.me, ((Model) other).me);
            }
            return true;
        }

        public final String getEmail() {
            return this.email;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getVerified() {
            return this.verified;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            if (meUser != null) {
                return meUser.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$1 */
    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final class ViewOnClickListenerC102561 implements View.OnClickListener {
        public ViewOnClickListenerC102561() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserEmailUpdate.Companion.launch$default(WidgetUserEmailUpdate.INSTANCE, outline.m885x(view, "it", "it.context"), WidgetUserEmailVerify.access$getMode$p(WidgetUserEmailVerify.this), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2 */
    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final class ViewOnClickListenerC102572 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Void r1) {
                return new TrackNetworkActionUserVerifyResend();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r6) {
                ViewOnClickListenerC102572 viewOnClickListenerC102572 = ViewOnClickListenerC102572.this;
                WidgetUserEmailVerify widgetUserEmailVerify = WidgetUserEmailVerify.this;
                AppToast.m172j(widgetUserEmailVerify, FormatUtils.m219k(widgetUserEmailVerify, C5419R.string.verification_email_body, new Object[]{viewOnClickListenerC102572.$model.getEmail()}, null, 4), 0, 4);
            }
        }

        public ViewOnClickListenerC102572(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthVerifyResend(new RestAPIParams.EmptyBody()), false, 1, null), AnonymousClass1.INSTANCE), WidgetUserEmailVerify.this, null, 2, null), WidgetUserEmailVerify.this.getClass(), WidgetUserEmailVerify.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 60, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final /* synthetic */ class C102581 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C102581(WidgetUserEmailVerify widgetUserEmailVerify) {
            super(1, widgetUserEmailVerify, WidgetUserEmailVerify.class, "configureUI", "configureUI(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetUserEmailVerify.access$configureUI((WidgetUserEmailVerify) this.receiver, model);
        }
    }

    public WidgetUserEmailVerify() {
        super(C5419R.layout.widget_user_email_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserEmailVerify3.INSTANCE, null, 2, null);
        this.emailUpdateLauncher = WidgetUserEmailUpdate.INSTANCE.registerForResult(this, new WidgetUserEmailVerify4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserEmailVerify widgetUserEmailVerify, Model model) {
        widgetUserEmailVerify.configureUI(model);
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserEmailVerify widgetUserEmailVerify) {
        return widgetUserEmailVerify.getMode();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserEmailVerify widgetUserEmailVerify, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserEmailVerify.setMode(mode);
    }

    private final void configureUI(Model model) {
        if (model.getVerified()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        } else if (model.getEmail() == null) {
            WidgetUserEmailUpdate.INSTANCE.launch(requireContext(), getMode(), this.emailUpdateLauncher);
        } else {
            getBinding().f18331b.setOnClickListener(new ViewOnClickListenerC102561());
            getBinding().f18332c.setOnClickListener(new ViewOnClickListenerC102572(model));
        }
    }

    private final WidgetUserEmailVerifyBinding getBinding() {
        return (WidgetUserEmailVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetUserEmailVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C102581(this), 62, (Object) null);
    }
}
