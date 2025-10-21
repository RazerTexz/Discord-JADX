package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: WidgetTos.kt */
/* loaded from: classes.dex */
public final class WidgetTos extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTos.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: isAcknowledgement$delegate, reason: from kotlin metadata */
    private final Lazy isAcknowledgement;

    /* compiled from: WidgetTos.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, boolean isAck) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("intent_args_key", isAck);
            AppScreen2.d(context, WidgetTos.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTos.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ RestAPIParams.UserAgreements $userAgreementsParam;

        /* compiled from: WidgetTos.kt */
        /* renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03491 extends Lambda implements Function1<Void, Unit> {
            public static final C03491 INSTANCE = new C03491();

            public C03491() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        public AnonymousClass1(RestAPIParams.UserAgreements userAgreements) {
            this.$userAgreementsParam = userAgreements;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(this.$userAgreementsParam), false, 1, null), WidgetTos.this, null, 2, null).k(o.a.g(WidgetTos.this.getContext(), C03491.INSTANCE, null));
            WidgetTos.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetTos.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTos$isAcknowledgement$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetTos.this.getMostRecentIntent().getBooleanExtra("intent_args_key", false);
        }
    }

    /* compiled from: WidgetTos.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTos$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetTos.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTos$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                return;
            }
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetTos() {
        super(R.layout.widget_tos);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTos2.INSTANCE, null, 2, null);
        this.isAcknowledgement = LazyJVM.lazy(new AnonymousClass2());
    }

    private final void configureAcknowledgementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.n(textView, R.string.terms_acknowledgement_description_1, new Object[]{DateUtils.formatDateTime(requireContext(), 1648454400000L, 4)}, null, 4);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.n(textView2, R.string.terms_acknowledgement_description_2, new Object[0], null, 4);
    }

    private final void configureAgreementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        binding.f2674b.setOnClickListener(new WidgetTos3(this));
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.n(textView, R.string.terms_agreement_description_1, new Object[0], null, 4);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.n(textView2, R.string.terms_agreement_description_2, new Object[0], null, 4);
        MaterialButton materialButton = binding.f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "alertTosAckContinue");
        FormatUtils.n(materialButton, R.string.got_it, new Object[0], null, 4);
    }

    private final void configureCommonTosModalUI() {
        MaterialButton materialButton = getBinding().f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.alertTosAckContinue");
        FormatUtils.n(materialButton, R.string.got_it, new Object[0], null, 4);
        getBinding().f2674b.setOnClickListener(new AnonymousClass1(isAcknowledgement() ? RestAPIParams.UserAgreements.INSTANCE.acknowledge() : RestAPIParams.UserAgreements.INSTANCE.agree()));
    }

    private final void configureCommonUI() {
        WidgetTosBinding binding = getBinding();
        LinkifiedTextView linkifiedTextView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "alertTosTermsOfService");
        FormatUtils.n(linkifiedTextView, R.string.terms_of_service, new Object[]{getString(R.string.terms_of_service_url)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "alertTosPrivacyPolicy");
        FormatUtils.n(linkifiedTextView2, R.string.privacy_policy, new Object[]{getString(R.string.privacy_policy_url)}, null, 4);
        LinkifiedTextView linkifiedTextView3 = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "alertTosCommunityGuidelines");
        FormatUtils.n(linkifiedTextView3, R.string.community_guidelines, new Object[]{getString(R.string.community_guidelines_url)}, null, 4);
        LinkifiedTextView linkifiedTextView4 = binding.c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView4, "alertTosBlogPost");
        FormatUtils.n(linkifiedTextView4, R.string.blog_post, new Object[]{getString(R.string.important_updates_url)}, null, 4);
    }

    private final void configureUI() {
        configureCommonUI();
        if (isAcknowledgement()) {
            configureAcknowledgementUI();
        } else {
            configureAgreementUI();
        }
    }

    private final WidgetTosBinding getBinding() {
        return (WidgetTosBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean isAcknowledgement() {
        return ((Boolean) this.isAcknowledgement.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, AnonymousClass1.INSTANCE, 0, 2, null);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_settings_logout, AnonymousClass2.INSTANCE, null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        configureUI();
    }
}
