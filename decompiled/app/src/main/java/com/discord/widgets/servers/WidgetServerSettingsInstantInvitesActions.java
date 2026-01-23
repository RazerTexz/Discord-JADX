package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(FragmentManager fragmentManager, String inviteCode) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class ViewOnClickListenerC92591 implements View.OnClickListener {
        public final /* synthetic */ String $inviteCode;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModelInvite, Unit> {
            public AnonymousClass1(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions) {
                super(1, widgetServerSettingsInstantInvitesActions, WidgetServerSettingsInstantInvitesActions.class, "handleInviteRevoked", "handleInviteRevoked(Lcom/discord/models/domain/ModelInvite;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                Intrinsics3.checkNotNullParameter(modelInvite, "p1");
                WidgetServerSettingsInstantInvitesActions.access$handleInviteRevoked((WidgetServerSettingsInstantInvitesActions) this.receiver, modelInvite);
            }
        }

        public ViewOnClickListenerC92591(String str) {
            this.$inviteCode = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeInvite(this.$inviteCode), false, 1, null), WidgetServerSettingsInstantInvitesActions.this, null, 2, null).m11108k(C0879o.m181h(new WidgetServerSettingsInstantInvitesActions3(new AnonymousClass1(WidgetServerSettingsInstantInvitesActions.this)), WidgetServerSettingsInstantInvitesActions.this.getContext(), null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class ViewOnClickListenerC92602 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public ViewOnClickListenerC92602(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.m165c(outline.m885x(view, "it", "it.context"), this.$inviteUrl, 0, 4);
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class ViewOnClickListenerC92613 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public ViewOnClickListenerC92613(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextM885x = outline.m885x(view, "it", "it.context");
            String str = this.$inviteUrl;
            IntentUtils.performChooserSendIntent(contextM885x, str, FormatUtils.m219k(WidgetServerSettingsInstantInvitesActions.this, C5419R.string.share_invite_mobile, new Object[]{str}, null, 4));
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    public WidgetServerSettingsInstantInvitesActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions2.INSTANCE, null, 2, null);
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
        return C5419R.layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || StringsJVM.isBlank(string)) {
            dismiss();
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().f17680e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().f17680e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().f17678c.setOnClickListener(new ViewOnClickListenerC92591(string));
        getBinding().f17677b.setOnClickListener(new ViewOnClickListenerC92602(strCreateLinkFromCode));
        getBinding().f17679d.setOnClickListener(new ViewOnClickListenerC92613(strCreateLinkFromCode));
    }
}
