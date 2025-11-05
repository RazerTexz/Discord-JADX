package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g0.t;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(FragmentManager fragmentManager, String inviteCode) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(inviteCode, "inviteCode");
            WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions = new WidgetServerSettingsInstantInvitesActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetServerSettingsInstantInvitesActions.ARG_INVITE_CODE, inviteCode);
            widgetServerSettingsInstantInvitesActions.setArguments(bundle);
            widgetServerSettingsInstantInvitesActions.show(fragmentManager, WidgetServerSettingsInstantInvitesActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $inviteCode;

        /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C04301 extends k implements Function1<ModelInvite, Unit> {
            public C04301(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions) {
                super(1, widgetServerSettingsInstantInvitesActions, WidgetServerSettingsInstantInvitesActions.class, "handleInviteRevoked", "handleInviteRevoked(Lcom/discord/models/domain/ModelInvite;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                m.checkNotNullParameter(modelInvite, "p1");
                WidgetServerSettingsInstantInvitesActions.access$handleInviteRevoked((WidgetServerSettingsInstantInvitesActions) this.receiver, modelInvite);
            }
        }

        public AnonymousClass1(String str) {
            this.$inviteCode = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeInvite(this.$inviteCode), false, 1, null), WidgetServerSettingsInstantInvitesActions.this, null, 2, null).k(o.h(new WidgetServerSettingsInstantInvitesActions$sam$rx_functions_Action1$0(new C04301(WidgetServerSettingsInstantInvitesActions.this)), WidgetServerSettingsInstantInvitesActions.this.getContext(), null));
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public AnonymousClass2(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a.d.m.c(a.x(view, "it", "it.context"), this.$inviteUrl, 0, 4);
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public AnonymousClass3(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextX = a.x(view, "it", "it.context");
            String str = this.$inviteUrl;
            IntentUtils.performChooserSendIntent(contextX, str, b.k(WidgetServerSettingsInstantInvitesActions.this, R.string.share_invite_mobile, new Object[]{str}, null, 4));
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    public WidgetServerSettingsInstantInvitesActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$handleInviteRevoked(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, ModelInvite modelInvite) {
        widgetServerSettingsInstantInvitesActions.handleInviteRevoked(modelInvite);
    }

    public static final void create(FragmentManager fragmentManager, String str) {
        INSTANCE.create(fragmentManager, str);
    }

    private final WidgetServerSettingsInstantInviteActionsBinding getBinding() {
        return (WidgetServerSettingsInstantInviteActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleInviteRevoked(ModelInvite invite) {
        StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(invite);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || t.isBlank(string)) {
            dismiss();
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().c.setOnClickListener(new AnonymousClass1(string));
        getBinding().f2573b.setOnClickListener(new AnonymousClass2(strCreateLinkFromCode));
        getBinding().d.setOnClickListener(new AnonymousClass3(strCreateLinkFromCode));
    }
}
